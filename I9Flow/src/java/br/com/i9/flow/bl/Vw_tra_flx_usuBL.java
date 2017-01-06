package br.com.i9.flow.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import java.util.ArrayList;
import java.util.Date;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Vw_tra_flx_usuBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        try {
            if (!valide("insert")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
            }
            Vw_tra_flx_usuDAO vw_tra_flx_usuDAO = getVw_tra_flx_usuDAO();
            vw_tra_flx_usuDAO.insert(vw_tra_flx_usuT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Problema ao inserir ".concat("Vw_tra_flx_usu"));
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Vw_tra_flx_usuT> consult() throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
            }
            Vw_tra_flx_usuDAO vw_tra_flx_usuDAO = getVw_tra_flx_usuDAO();
            return vw_tra_flx_usuDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Vw_tra_flx_usuT> consultByStatusTramites(Usu_usuarioT usuT) throws Exception {
        try {
            if (usuT != null) {
                List<Des_destinoT> listDes = getDes_destinoDAO().getByUsuario(usuT.getUsu_nr_id());
                String excetoTramite = "0";
                try {
                    excetoTramite = getParametro("Exceto_Tramite");
                } catch (Exception e) {
                }
                List<Vw_tra_flx_usuT> listTFU = null;
                if (excetoTramite != null) {
                    listTFU = getVw_tra_flx_usuDAO().getByAreasDestinoExcetoTramites(listDes, usuT.getUsu_nr_id(), excetoTramite);
                } else {
                    listTFU = getVw_tra_flx_usuDAO().getByAreasDestino(listDes, usuT.getUsu_nr_id());
                }

                montaIds(listTFU);
                return listTFU;
            } else {
                return new ArrayList<Vw_tra_flx_usuT>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Vw_tra_flx_usuT> consultByStatusTramitesPeriodo(Usu_usuarioT usuT, Date dtInicio, Date dtFinal) throws Exception {
        try {
            if (usuT != null) {
                List<Des_destinoT> listDes = getDes_destinoDAO().getByUsuario(usuT.getUsu_nr_id());
                String excetoTramite = "0";
                try {
                    excetoTramite = getParametro("Exceto_Tramite");
                } catch (Exception e) {
                }
                List<Vw_tra_flx_usuT> listTFU = null;
                if (excetoTramite != null) {
                    listTFU = getVw_tra_flx_usuDAO().getByAreasDestinoExcetoTramitesPeriodo(listDes, usuT.getUsu_nr_id(), excetoTramite, dtInicio, dtFinal);
                } else {
                    listTFU = getVw_tra_flx_usuDAO().getByAreasDestinoPeriodo(listDes, usuT.getUsu_nr_id(), dtInicio, dtFinal);
                }

                montaIds(listTFU);
                return listTFU;
            } else {
                return new ArrayList<Vw_tra_flx_usuT>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    private void montaIds(List<Vw_tra_flx_usuT> listTFU) throws Exception {
        //List<Vw_tra_flx_usuT> listTemp = new ArrayList<Vw_tra_flx_usuT>();
        Did_documento_identificacaoT didT = new Did_documento_identificacaoT();
        Did_documento_identificacaoDAO didDao = getDid_documento_identificacaoDAO();
        for (int i = 0; i < listTFU.size(); i++) {
            Vw_tra_flx_usuT vw_tra_flx_usuT = listTFU.get(i);
            didT.setFlx_nr_id(vw_tra_flx_usuT.getFlx_nr_id());
            List<Did_documento_identificacaoT> listDid = didDao.getByFlx_nr_id(didT);
            StringBuffer sbIds = new StringBuffer();
            for (Did_documento_identificacaoT did_documento_identificacaoT : listDid) {
                sbIds.append(did_documento_identificacaoT.getDid_tx_valor());
                sbIds.append(",");
            }
            if (listDid.size() > 0) {
                sbIds.append("!-");
            } else {
                listTFU.remove(vw_tra_flx_usuT);
            }

            vw_tra_flx_usuT.setIds(sbIds.toString().replaceAll(",!-", ""));

        }
//        for (Vw_tra_flx_usuT vw_tra_flx_usuT : listTFU) {
//            didT.setFlx_nr_id(vw_tra_flx_usuT.getFlx_nr_id());
//            List<Did_documento_identificacaoT> listDid = didDao.getByFlx_nr_id(didT);
//            StringBuffer sbIds = new StringBuffer();
//            for (Did_documento_identificacaoT did_documento_identificacaoT : listDid) {
//                sbIds.append(did_documento_identificacaoT.getDid_tx_valor());
//                sbIds.append(",");
//            }
//            if (listDid.size() > 0) {
//                sbIds.append("!-");
//            } else {
//                listTFU.remove(vw_tra_flx_usuT);
//            }
//
//            vw_tra_flx_usuT.setIds(sbIds.toString().replaceAll(",!-", ""));
//        }
    }

    public List<Vw_tra_flx_usuT> consultByStatusTramites(List<Integer> list) throws Exception {
        try {
            if (list != null && list.size() > 0) {
                List<Des_destinoT> listDes = getDes_destinoDAO().getByUsuario(list);
                String excetoTramite = "";
                try {
                    excetoTramite = getParametro("Exceto_Tramite");
                } catch (Exception e) {
                }
                List<Vw_tra_flx_usuT> listTFU = null;
                if (excetoTramite != null && excetoTramite.trim().length() > 0) {
                    listTFU = getVw_tra_flx_usuDAO().getByAreasDestinoExcetoTramites(listDes, list, excetoTramite);
                } else {
                    listTFU = getVw_tra_flx_usuDAO().getByAreasDestino(listDes, list);
                }
                montaIds(listTFU);
                return listTFU;
            } else {
                return new ArrayList<Vw_tra_flx_usuT>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Vw_tra_flx_usuT> consultByStatusTramitesPeriodo(List<Integer> list, Date dtInicio, Date dtFinal) throws Exception {
        try {
            if (list != null && list.size() > 0) {
                List<Des_destinoT> listDes = getDes_destinoDAO().getByUsuario(list);
                String excetoTramite = "";
                try {
                    excetoTramite = getParametro("Exceto_Tramite");
                } catch (Exception e) {
                }
                List<Vw_tra_flx_usuT> listTFU = null;
                if (excetoTramite != null && excetoTramite.trim().length() > 0) {
                    listTFU = getVw_tra_flx_usuDAO().getByAreasDestinoExcetoTramitesPeriodo(listDes, list, excetoTramite, dtInicio, dtFinal);
                            //(listDes, list, excetoTramite);
                } else {
                    listTFU = getVw_tra_flx_usuDAO().getByAreasDestinoPeriodo(listDes, list, dtInicio, dtFinal);
                }
                montaIds(listTFU);
                return listTFU;
            } else {
                return new ArrayList<Vw_tra_flx_usuT>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
    //     * Consulta o fluxo baseado no usuário e na hierarquia de procuração
    //     * @param usuT
    //     * @return
    //     * @throws Exception
    //     */
//    public List<Vw_tra_flx_usuT> consultByStatusTramitesHierarquia(Usu_usuarioT usuT, Usu_usuarioT usuTProcurador) throws Exception {
//        try {
//            if (usuT != null) {
//                //List<Des_destinoT> listDes = getDes_destinoDAO().getByUsuario(usuT.getUsu_nr_id());
//                return getVw_tra_flx_usuDAO().getByUsuarioProcurador(usuT.getUsu_nr_id(), usuTProcurador.getUsu_nr_id());
//            } else {
//                return new ArrayList<Vw_tra_flx_usuT>();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            close();
//        }
//    }
    public List<Vw_tra_flx_usuT> consultByIdDocumento(List<Did_documento_identificacaoT> listDid) throws Exception {
        try {
            List<Vw_tra_flx_usuT> listTFU = getVw_tra_flx_usuDAO().getListByIdsDocumento(listDid);
            montaIds(listTFU);
            return listTFU;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }
    
    public List<Vw_tra_flx_usuT> consultByTramitadoPeloUsuario(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        try {
            List<Vw_tra_flx_usuT> listTFU = getVw_tra_flx_usuDAO().getByTramitadoPeloUsuario(vw_tra_flx_usuT);
            montaIds(listTFU);
            return listTFU;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Vw_tra_flx_usuT> consultByTramitadoPeloUsuarios(String usersIds) throws Exception {
        try {
            List<Vw_tra_flx_usuT> listTFU = getVw_tra_flx_usuDAO().getByTramitadoPeloUsuarios(usersIds);
            montaIds(listTFU);
            return listTFU;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    public List<Vw_tra_flx_usuT> consultByStatusTramite(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        try {
            List<Vw_tra_flx_usuT> listTFU = getVw_tra_flx_usuDAO().getByTra_nr_id(vw_tra_flx_usuT);
            montaIds(listTFU);
            return listTFU;
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
    public boolean delete(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
            }
            if (exist(vw_tra_flx_usuT)) {
                Vw_tra_flx_usuDAO vw_tra_flx_usuDAO = getVw_tra_flx_usuDAO();
                vw_tra_flx_usuDAO.delete(vw_tra_flx_usuT);
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
    public boolean exist(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        try {
            Vw_tra_flx_usuDAO vw_tra_flx_usuDAO = getVw_tra_flx_usuDAO();
            List<Vw_tra_flx_usuT> listTemp = vw_tra_flx_usuDAO.getByPK(vw_tra_flx_usuT);

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
    public boolean update(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
            }
            if (exist(vw_tra_flx_usuT)) {
                Vw_tra_flx_usuDAO vw_tra_flx_usuDAO = getVw_tra_flx_usuDAO();
                vw_tra_flx_usuDAO.update(vw_tra_flx_usuT);
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
    public Vw_tra_flx_usuT findbyid(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        try {
            Vw_tra_flx_usuDAO vw_tra_flx_usuDAO = getVw_tra_flx_usuDAO();
            List<Vw_tra_flx_usuT> listTemp = vw_tra_flx_usuDAO.getByPK(vw_tra_flx_usuT);
            montaIds(listTemp);
            return listTemp.size() > 0 ? listTemp.get(0) : new Vw_tra_flx_usuT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }
}
