package br.com.i9.flow.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Tra_tramiteBL extends SystemBusinessBase {

    private Flx_fluxoT flx_fluxoT;

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Tra_tramiteT tra_tramiteT) throws Exception {

        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            Tra_tramiteDAO tra_tramiteDAO = getTra_tramiteDAO();
            tra_tramiteDAO.insert(tra_tramiteT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Tra_tramite"));
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Tra_tramiteT> consult() throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Tra_tramiteDAO tra_tramiteDAO = getTra_tramiteDAO();
            return tra_tramiteDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }


    public List<Tra_tramiteT>  consultTramiteByTipoDocumento(Tra_tramiteT tra_tramiteT) throws Exception {
        try {
            if (!valide("consultTramiteManualByTipoDocumento")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            return getTra_tramiteDAO().getByTid_nr_id(tra_tramiteT);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Tra_tramiteT>  consultTramiteManualByTipoDocumento(Tra_tramiteT tra_tramiteT) throws Exception {
        try {
            if (!valide("consultTramiteManualByTipoDocumento")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            return getTra_tramiteDAO().getAllManuaisByTipoDocumento(tra_tramiteT);
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
    public boolean delete(Tra_tramiteT tra_tramiteT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(tra_tramiteT)) {
                Tra_tramiteDAO tra_tramiteDAO = getTra_tramiteDAO();
                tra_tramiteDAO.delete(tra_tramiteT);
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
    public boolean exist(Tra_tramiteT tra_tramiteT) throws Exception {
        try {
            Tra_tramiteDAO tra_tramiteDAO = getTra_tramiteDAO();
            List<Tra_tramiteT> listTemp = tra_tramiteDAO.getByPK(tra_tramiteT);

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
    public boolean update(Tra_tramiteT tra_tramiteT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(tra_tramiteT)) {
                Tra_tramiteDAO tra_tramiteDAO = getTra_tramiteDAO();
                tra_tramiteDAO.update(tra_tramiteT);
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
     * Obt?m os dados de um registro
     */
    public Tra_tramiteT findbyid(Tra_tramiteT tra_tramiteT) throws Exception {
        try {
            Tra_tramiteDAO tra_tramiteDAO = getTra_tramiteDAO();
            List<Tra_tramiteT> listTemp = tra_tramiteDAO.getByPK(tra_tramiteT);
            return listTemp.size() > 0 ? listTemp.get(0) : new Tra_tramiteT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public Tra_tramiteT findByDocTypeNameActual(Usu_usuarioT usuT, String docTypeName, List<Did_documento_identificacaoT> listIdDoc) throws Exception {
        try {
            List<Tra_tramiteT> listTemp = null;
            Flx_fluxoBL flxBl = new Flx_fluxoBL();
            if (listIdDoc == null) {
                listTemp = getTra_tramiteDAO().getByFirstDocTypeName(docTypeName);
                //Como é o primeiro Tramite, já grava na tabela de fluxo
                Tra_tramiteT traT = listTemp.size() > 0 ? listTemp.get(0) : null;
                if (traT != null) {
                    flx_fluxoT = new Flx_fluxoT();
                    flx_fluxoT.setTra_nr_idorigem(0);
                    flx_fluxoT.setTra_nr_iddestino(traT.getTra_nr_id());
                    flx_fluxoT.setFlx_tx_obs("Criando Documento");
                    flxBl.insertFirst(usuT, flx_fluxoT);
                }
            } else {
                flx_fluxoT = flxBl.findByDocTypeNameActual(listIdDoc);
                Tra_tramiteT traT = new Tra_tramiteT();
                traT.setTra_nr_id(flx_fluxoT.getTra_nr_iddestino());
                listTemp = getTra_tramiteDAO().getByPK(traT);
            }
            return listTemp.size() > 0 ? listTemp.get(0) : new Tra_tramiteT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * @return the flx_fluxoT
     */
    public Flx_fluxoT getFlx_fluxoT() {
        return flx_fluxoT;
    }
}
