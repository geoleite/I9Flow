package br.com.i9.flow.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.i9.flow.AModeloProcAutomatico;
import java.util.Date;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Flx_fluxoBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Usu_usuarioT usuT, Flx_fluxoT flx_fluxoT, List<Did_documento_identificacaoT> listIdDoc) throws Exception {
        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            //flx_fluxoT.setUsu_nr_id(usuT.getUsu_nr_id());
            Flx_fluxoT flxTAnterior = findByDocTypeNameActual(listIdDoc);
            flx_fluxoT.setFlx_nr_idanterior(0);
            if (flxTAnterior != null) {
                flx_fluxoT.setFlx_nr_idanterior(flxTAnterior.getFlx_nr_id());
                getFlx_fluxoDAO().finalizeFluxo(flxTAnterior);
            }
            
            getFlx_fluxoDAO().insert(flx_fluxoT);
            if (listIdDoc != null) {
                for (int i = 0; i < listIdDoc.size(); i++) {
                    Did_documento_identificacaoT didT = listIdDoc.get(i);
                    didT.setFlx_nr_id(flx_fluxoT.getFlx_nr_id());
                    int count = getDid_documento_identificacaoDAO().getCountIdsByIdFluxo(didT.getFlx_nr_id());
                        if (count < listIdDoc.size()) {
                            getDid_documento_identificacaoDAO().insert(didT);
                        }
                    //getDid_documento_identificacaoDAO().insert(didT);
                }
            }
            //Verficando se o processamento do fluxo atual é automático
            verificaProcessamentoAutomatico(flx_fluxoT, usuT, listIdDoc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Flx_fluxo"));
        } finally {
            close();
        }
    }

    /**
     * Finaliza o fluxo
     * @param flxT
     * @throws Exception
     */
    public void finalizeFluxo(Flx_fluxoT flxT) throws Exception {
        try {
            getFlx_fluxoDAO().finalizeFluxo(flxT);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao finalizar fluxo ".concat("Flx_fluxo"));
        } finally {
            close();
        }
    }
    /**
     * Processamento automático 
     * @param flx_fluxoT
     * @param usuT
     * @param listIdDoc
     * @throws Exception
     */
    private void verificaProcessamentoAutomatico(Flx_fluxoT flx_fluxoT, Usu_usuarioT usuT, List<Did_documento_identificacaoT> listIdDoc) throws Exception {
        //Verifica se o tramite de destino é automático
        Tra_tramiteT traT = new Tra_tramiteT();
        traT.setTra_nr_id(flx_fluxoT.getTra_nr_iddestino());
        traT = new Tra_tramiteBL().findbyid(traT);
        if (traT != null && "S".equalsIgnoreCase(traT.getTra_tx_automatico())) {
            //Nao defini o usuario para o caso do processamento ser automático
            //flx_fluxoT.setUsu_nr_id(usuT.getUsu_nr_id());
            flx_fluxoT.setUsu_nr_id(0);
            getFlx_fluxoDAO().finalizeFluxo(flx_fluxoT);
            Opt_opcao_tramiteT optT = new Opt_opcao_tramiteT();
            optT.setTra_nr_idorigem(traT.getTra_nr_id());
            List<Opt_opcao_tramiteT> listOpt = getOpt_opcao_tramiteDAO().getByTra_nr_idorigem(optT);
            Flx_fluxoT flxNovo = new Flx_fluxoT();
            flxNovo.setFlx_nr_id(flx_fluxoT.getFlx_nr_id());
            flxNovo.setTra_nr_idorigem(flx_fluxoT.getTra_nr_iddestino());
            if (processamentoAutomatico(traT, listIdDoc)) {
                optT = listOpt.get(0);
                flxNovo.setTra_nr_iddestino(optT.getTra_nr_iddestino());
                //flxNovo.setFlx_tx_obs("Processamento Automatico aprovado");
                flxNovo.setFlx_tx_obs(flx_fluxoT.getFlx_tx_obs());
                flx_fluxoT.setFlx_tx_obs("Processamento Automatico deferido: ".concat(flx_fluxoT.getFlx_tx_obs()));
            } else {
                optT = listOpt.get(1);
                flxNovo.setTra_nr_iddestino(optT.getTra_nr_iddestino());
                //flxNovo.setFlx_tx_obs("Processamento Automatico falhou");
                flxNovo.setFlx_tx_obs(flx_fluxoT.getFlx_tx_obs());
                flx_fluxoT.setFlx_tx_obs("Processamento Automatico indeferido: ".concat(flx_fluxoT.getFlx_tx_obs()));
            }
            //flx_fluxoT.setUsu_nr_id(usuT.getUsu_nr_id());
            getFlx_fluxoDAO().updateObsUsuario(flx_fluxoT);
            insert(usuT, flxNovo, listIdDoc);
        }
    }

    /**
     * REaliza os processamentos automáticos
     * @param traT
     * @param listDid
     * @return
     * @throws Exception
     */
    private boolean processamentoAutomatico(Tra_tramiteT traT, List<Did_documento_identificacaoT> listDid) throws Exception {
        Lgc_logicaT lgcT = new Lgc_logicaT();
        lgcT.setTra_nr_id(traT.getTra_nr_id());
        List<Lgc_logicaT> listLgc = getLgc_logicaDAO().getByTra_nr_id(lgcT);
        boolean[] resultados = new boolean[listLgc.size()];
        for (int i = 0; i < listLgc.size(); i++) {
            Lgc_logicaT lgc_logicaT = listLgc.get(i);
            String classe = lgc_logicaT.getLgc_tx_classe();
            try {
                AModeloProcAutomatico modeloProcAutomatico = (AModeloProcAutomatico) Class.forName(classe).newInstance();
                modeloProcAutomatico.setListDid(listDid);
                resultados[i] = modeloProcAutomatico.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < resultados.length; i++) {
            boolean res = resultados[i];
            if (!res) {
                System.out.println("Logando problema na validacao automatica: " + listLgc.get(i).getLgc_tx_descricao());
                return false;
            }
        }
        return resultados.length > 0;
    }

    public boolean insertFirst(Usu_usuarioT usuT, Flx_fluxoT flx_fluxoT) throws Exception {
        try {
            if (!valide("insertFirst")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insertFirst"));
            }
            flx_fluxoT.setUsu_nr_id(usuT.getUsu_nr_id());
            getFlx_fluxoDAO().insert(flx_fluxoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Flx_fluxo"));
        } finally {
            close();
        }
    }

    /**
     * Obter os Documentos pelo trâmite e data validade
     * @return
     * @throws Exception
     */
    public List<Flx_fluxoT> consultTramiteData(int idTramite, Date dtValidade) throws Exception {
        try {
            if (!valide("consultTramiteData")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();
            return flx_fluxoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Flx_fluxoT> consult() throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();
            return flx_fluxoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Libera a posse do documento
     * @param listIdDoc
     * @throws Exception
     */
    public void possessionClear(List<Did_documento_identificacaoT> listIdDoc) throws Exception  {
        try {
            Flx_fluxoT flxTActual = findByDocTypeNameActual(listIdDoc);
            if (flxTActual != null) {
                flxTActual.setUsu_nr_id(0);
                getFlx_fluxoDAO().updateUsuario(flxTActual);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
        
    }

    /**
     * Toma posse do documento
     * @param usuT
     * @param listIdDoc
     * @throws Exception
     */
    public void takePossession(Usu_usuarioT usuT, List<Did_documento_identificacaoT> listIdDoc) throws Exception {
        try {
            Flx_fluxoT flxTActual = findByDocTypeNameActual(listIdDoc);
            if (flxTActual != null) {
                flxTActual.setUsu_nr_id(usuT.getUsu_nr_id());
                getFlx_fluxoDAO().updateUsuario(flxTActual);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Deletar um registro
     */
    public boolean delete(Flx_fluxoT flx_fluxoT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(flx_fluxoT)) {
                Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();
                flx_fluxoDAO.delete(flx_fluxoT);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Verifica se o objeto existe na base
     */
    public boolean exist(Flx_fluxoT flx_fluxoT) throws Exception {
        try {
            Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();
            List<Flx_fluxoT> listTemp = flx_fluxoDAO.getByPK(flx_fluxoT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

    }

    /**
     * Realiza uma alterac?o na tabela
     */
    public boolean update(Flx_fluxoT flx_fluxoT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(flx_fluxoT)) {
                Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();
                flx_fluxoDAO.update(flx_fluxoT);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public boolean update(Flx_fluxoT flx_fluxoT, List<Did_documento_identificacaoT> listIdDoc) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(flx_fluxoT)) {
                Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();
                flx_fluxoDAO.finalizeFluxo(flx_fluxoT);
                if (listIdDoc != null) {
                    for (int i = 0; i < listIdDoc.size(); i++) {
                        Did_documento_identificacaoT didT = listIdDoc.get(i);
                        didT.setFlx_nr_id(flx_fluxoT.getFlx_nr_id());
                        int count = getDid_documento_identificacaoDAO().getCountIdsByIdFluxo(didT.getFlx_nr_id());
                        if (count < listIdDoc.size()) {
                            getDid_documento_identificacaoDAO().insert(didT);
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Obtem os dados de um registro
     */
    public Flx_fluxoT findbyid(Flx_fluxoT flx_fluxoT) throws Exception {
        try {
            Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();
            List<Flx_fluxoT> listTemp = flx_fluxoDAO.getByPK(flx_fluxoT);
            return listTemp.size() > 0 ? listTemp.get(0) : new Flx_fluxoT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Flx_fluxoT> findbyTramiteDestinoAtual(Flx_fluxoT flx_fluxoT) throws Exception {
        try {
            Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();
            List<Flx_fluxoT> listTemp = flx_fluxoDAO.getByTramiteAtual(flx_fluxoT);
            return listTemp;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Consulta o tramite atual de um documento
     * @param listIdDoc
     * @return
     * @throws Exception
     */
    public Flx_fluxoT findByDocTypeNameActual(List<Did_documento_identificacaoT> listIdDoc) throws Exception {
        try {
            List<Flx_fluxoT> list = getFlx_fluxoDAO().getByIdsDoc(listIdDoc);
            return list.size() > 0 ? list.get(0) : null;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os tramites de um documento
     * @param listIdDoc
     * @return
     * @throws Exception
     */
    public List<Flx_fluxoT> findByDocId(List<Did_documento_identificacaoT> listIdDoc) throws Exception {
        try {
            List<Flx_fluxoT> list = getFlx_fluxoDAO().getByIdsDoc(listIdDoc);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
}
