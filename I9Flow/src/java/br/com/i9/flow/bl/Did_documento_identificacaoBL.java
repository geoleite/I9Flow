package br.com.i9.flow.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;
import java.util.Date;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Did_documento_identificacaoBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {

        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            Did_documento_identificacaoDAO did_documento_identificacaoDAO = getDid_documento_identificacaoDAO();
            did_documento_identificacaoDAO.insert(did_documento_identificacaoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Did_documento_identificacao"));
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Did_documento_identificacaoT> consult() throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Did_documento_identificacaoDAO did_documento_identificacaoDAO = getDid_documento_identificacaoDAO();
            return did_documento_identificacaoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Did_documento_identificacaoT> consultByFluxos(String idsFluxo) throws Exception {
        try {
            return getDid_documento_identificacaoDAO().getByFluxos(idsFluxo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Did_documento_identificacaoT> consultByFluxo(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception  {
        try {

            return getDid_documento_identificacaoDAO().getByFlx_nr_id(did_documento_identificacaoT);
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
    public boolean delete(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(did_documento_identificacaoT)) {
                Did_documento_identificacaoDAO did_documento_identificacaoDAO = getDid_documento_identificacaoDAO();
                did_documento_identificacaoDAO.delete(did_documento_identificacaoT);
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
    public boolean exist(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        try {
            Did_documento_identificacaoDAO did_documento_identificacaoDAO = getDid_documento_identificacaoDAO();
            List<Did_documento_identificacaoT> listTemp = did_documento_identificacaoDAO.getByPK(did_documento_identificacaoT);

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
    public boolean update(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(did_documento_identificacaoT)) {
                Did_documento_identificacaoDAO did_documento_identificacaoDAO = getDid_documento_identificacaoDAO();
                did_documento_identificacaoDAO.update(did_documento_identificacaoT);
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
    public Did_documento_identificacaoT findbyid(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        try {
            Did_documento_identificacaoDAO did_documento_identificacaoDAO = getDid_documento_identificacaoDAO();
            List<Did_documento_identificacaoT> listTemp = did_documento_identificacaoDAO.getByPK(did_documento_identificacaoT);
            return listTemp.size() > 0 ? listTemp.get(0) : new Did_documento_identificacaoT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Did_documento_identificacaoT> getByUsuarioProcuracao(int traNrIdDestino, List<Integer> listInteger, Date dtInicial, Date dtFinal) throws Exception {
        try {
            return getDid_documento_identificacaoDAO().getByUsuarioProcuracao(traNrIdDestino, listInteger, dtInicial, dtFinal);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Did_documento_identificacaoT> getByPeriodoTranmite(int traNrIdDestino, Date dtInicial, Date dtFinal) throws Exception {
        try {
            return getDid_documento_identificacaoDAO().getByPeriodoTramite(traNrIdDestino, dtInicial, dtFinal);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }
}
