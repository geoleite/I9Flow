package br.com.i9.flow.jb;

import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import java.util.List;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.i9.flow.bl.SystemBusinessBase;

public class SystemBase extends EasySecurityJB implements INotSecurity {

    public final static String FLX_SESSION = "fluxo_sessao";
    public final static String LIST_USER_PROCURATOR="lista_usuarios_procurador";
    public final static String IDS_DOC = "list_ids_doc";
    public int TYPE_DATABASE = DAOFactory.ORACLE;
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "usr_fluxo";
    private String pass = "usr_fluxo";
    private DAOFactory dao;
    private String datasourceName = "";

    public DAOFactory getDAO() throws Exception {
        if (dao != null) {
            return dao;
        }
        SystemBusinessBase sbb = new SystemBusinessBase();
        dao = sbb.getDAO();
        //dao = getDAO(typeDatabase, url, user, pass);
        return dao;
    }

    public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
        if (dao != null) {
            return dao;
        }
        return DAOFactory.getDAOFactory(typeDatabase, url, user, pass);
    }

    public void close() {
        try {
            dao.close();
            dao = null;
        } catch (Exception e) {
        }
    }

    public Are_areaDAO getAre_areaDAO() throws Exception {
        dao = getDAO();
        return new Are_areaDAO(dao);
    }

    public Aru_usu_areaDAO getAru_usu_areaDAO() throws Exception {
        dao = getDAO();
        return new Aru_usu_areaDAO(dao);
    }

    public Cac_carac_compDAO getCac_carac_compDAO() throws Exception {
        dao = getDAO();
        return new Cac_carac_compDAO(dao);
    }

    public Des_destinoDAO getDes_destinoDAO() throws Exception {
        dao = getDAO();
        return new Des_destinoDAO(dao);
    }

    public Did_documento_identificacaoDAO getDid_documento_identificacaoDAO() throws Exception {
        dao = getDAO();
        return new Did_documento_identificacaoDAO(dao);
    }

    public Doc_documentoDAO getDoc_documentoDAO() throws Exception {
        dao = getDAO();
        return new Doc_documentoDAO(dao);
    }

    public Flx_fluxoDAO getFlx_fluxoDAO() throws Exception {
        dao = getDAO();
        return new Flx_fluxoDAO(dao);
    }

    public Lgc_logicaDAO getLgc_logicaDAO() throws Exception {
        dao = getDAO();
        return new Lgc_logicaDAO(dao);
    }

    public Opt_opcao_tramiteDAO getOpt_opcao_tramiteDAO() throws Exception {
        dao = getDAO();
        return new Opt_opcao_tramiteDAO(dao);
    }

    public Tel_telaDAO getTel_telaDAO() throws Exception {
        dao = getDAO();
        return new Tel_telaDAO(dao);
    }

    public Tel_traDAO getTel_traDAO() throws Exception {
        dao = getDAO();
        return new Tel_traDAO(dao);
    }

    public Tid_tipo_documentoDAO getTid_tipo_documentoDAO() throws Exception {
        dao = getDAO();
        return new Tid_tipo_documentoDAO(dao);
    }

    public Tra_tramiteDAO getTra_tramiteDAO() throws Exception {
        dao = getDAO();
        return new Tra_tramiteDAO(dao);
    }

    public Are_areaT findbyIdAre_area(Are_areaT are_areaT) throws Exception {
        try {
            Are_areaDAO are_areaDAO = getAre_areaDAO();

            List<Are_areaT> listTemp = are_areaDAO.getByPK(are_areaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Aru_usu_areaT findbyIdAru_usu_area(Aru_usu_areaT aru_usu_areaT) throws Exception {
        try {
            Aru_usu_areaDAO aru_usu_areaDAO = getAru_usu_areaDAO();

            List<Aru_usu_areaT> listTemp = aru_usu_areaDAO.getByPK(aru_usu_areaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cac_carac_compT findbyIdCac_carac_comp(Cac_carac_compT cac_carac_compT) throws Exception {
        try {
            Cac_carac_compDAO cac_carac_compDAO = getCac_carac_compDAO();

            List<Cac_carac_compT> listTemp = cac_carac_compDAO.getByPK(cac_carac_compT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Des_destinoT findbyIdDes_destino(Des_destinoT des_destinoT) throws Exception {
        try {
            Des_destinoDAO des_destinoDAO = getDes_destinoDAO();

            List<Des_destinoT> listTemp = des_destinoDAO.getByPK(des_destinoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Did_documento_identificacaoT findbyIdDid_documento_identificacao(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        try {
            Did_documento_identificacaoDAO did_documento_identificacaoDAO = getDid_documento_identificacaoDAO();

            List<Did_documento_identificacaoT> listTemp = did_documento_identificacaoDAO.getByPK(did_documento_identificacaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Doc_documentoT findbyIdDoc_documento(Doc_documentoT doc_documentoT) throws Exception {
        try {
            Doc_documentoDAO doc_documentoDAO = getDoc_documentoDAO();

            List<Doc_documentoT> listTemp = doc_documentoDAO.getByPK(doc_documentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Flx_fluxoT findbyIdFlx_fluxo(Flx_fluxoT flx_fluxoT) throws Exception {
        try {
            Flx_fluxoDAO flx_fluxoDAO = getFlx_fluxoDAO();

            List<Flx_fluxoT> listTemp = flx_fluxoDAO.getByPK(flx_fluxoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Lgc_logicaT findbyIdLgc_logica(Lgc_logicaT lgc_logicaT) throws Exception {
        try {
            Lgc_logicaDAO lgc_logicaDAO = getLgc_logicaDAO();

            List<Lgc_logicaT> listTemp = lgc_logicaDAO.getByPK(lgc_logicaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Opt_opcao_tramiteT findbyIdOpt_opcao_tramite(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        try {
            Opt_opcao_tramiteDAO opt_opcao_tramiteDAO = getOpt_opcao_tramiteDAO();

            List<Opt_opcao_tramiteT> listTemp = opt_opcao_tramiteDAO.getByPK(opt_opcao_tramiteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tel_telaT findbyIdTel_tela(Tel_telaT tel_telaT) throws Exception {
        try {
            Tel_telaDAO tel_telaDAO = getTel_telaDAO();

            List<Tel_telaT> listTemp = tel_telaDAO.getByPK(tel_telaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tel_traT findbyIdTel_tra(Tel_traT tel_traT) throws Exception {
        try {
            Tel_traDAO tel_traDAO = getTel_traDAO();

            List<Tel_traT> listTemp = tel_traDAO.getByPK(tel_traT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tid_tipo_documentoT findbyIdTid_tipo_documento(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception {
        try {
            Tid_tipo_documentoDAO tid_tipo_documentoDAO = getTid_tipo_documentoDAO();

            List<Tid_tipo_documentoT> listTemp = tid_tipo_documentoDAO.getByPK(tid_tipo_documentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tra_tramiteT findbyIdTra_tramite(Tra_tramiteT tra_tramiteT) throws Exception {
        try {
            Tra_tramiteDAO tra_tramiteDAO = getTra_tramiteDAO();

            List<Tra_tramiteT> listTemp = tra_tramiteDAO.getByPK(tra_tramiteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
}
