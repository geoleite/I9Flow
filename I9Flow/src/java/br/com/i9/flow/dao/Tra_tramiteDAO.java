package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Tra_tramiteDAO extends ObjectDAO {

    public Tra_tramiteDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.TRA_TRAMITE  ( TRA_NR_ID, DES_NR_ID, TID_NR_ID, USU_NR_ID, TRA_TX_NOME, TRA_TX_AUTOMATICO) values ( ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tra_tramiteT.getTra_nr_id());
            pStmt.setObject(2, tra_tramiteT.getDes_nr_id());
            pStmt.setObject(3, tra_tramiteT.getTid_nr_id());
            pStmt.setObject(4, tra_tramiteT.getUsu_nr_id());
            pStmt.setObject(5, tra_tramiteT.getTra_tx_nome());
            pStmt.setObject(6, tra_tramiteT.getTra_tx_automatico());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.TRA_TRAMITE set  DES_NR_ID=?, TID_NR_ID=?, USU_NR_ID=?, TRA_TX_NOME=?, TRA_TX_AUTOMATICO=?  where  TRA_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tra_tramiteT.getDes_nr_id());
            pStmt.setObject(2, tra_tramiteT.getTid_nr_id());
            pStmt.setObject(3, tra_tramiteT.getUsu_nr_id());
            pStmt.setObject(4, tra_tramiteT.getTra_tx_nome());
            pStmt.setObject(5, tra_tramiteT.getTra_tx_automatico());
            pStmt.setObject(6, tra_tramiteT.getTra_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.TRA_TRAMITE where  TRA_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tra_tramiteT.getTra_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    private List<Tra_tramiteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Tra_tramiteT> objs = new Vector();
        while (rs.next()) {
            Tra_tramiteT tra_tramiteT = new Tra_tramiteT();
            tra_tramiteT.setTra_nr_id(rs.getInt("TRA_NR_ID"));
            tra_tramiteT.setDes_nr_id(rs.getInt("DES_NR_ID"));
            tra_tramiteT.setTid_nr_id(rs.getInt("TID_NR_ID"));
            tra_tramiteT.setUsu_nr_id(rs.getInt("USU_NR_ID"));
            tra_tramiteT.setTra_tx_nome(rs.getString("TRA_TX_NOME"));
            tra_tramiteT.setTra_tx_automatico(rs.getString("TRA_TX_AUTOMATICO"));
            objs.add(tra_tramiteT);
        }
        return objs;
    }

    public List<Tra_tramiteT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Tra_tramiteT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getAllManuaisByTipoDocumento(Tra_tramiteT traT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE where TRA_TX_AUTOMATICO='N' and tid_nr_id=?  order by tra_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, traT.getTid_nr_id());
            rs = pStmt.executeQuery();
            List<Tra_tramiteT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Tra_tramiteT> getByPK(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE where  TRA_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tra_tramiteT.getTra_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getByIdsDoc(String docTypeName, List<Did_documento_identificacaoT> listIdDoc) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select DISTINCT * from flx_fluxo where flx_nr_id in (");
            for (int i = 0; i < listIdDoc.size(); i++) {
                Did_documento_identificacaoT didT = listIdDoc.get(i);
                sql.append(" (select flx_nr_id from did_documento_identificacao where did_tx_nomecoluna=? and did_tx_valor=?) ");
                if (i < (listIdDoc.size() - 1)) {
                    sql.append(" INTERSECT ");
                }
            }
            sql.append(") order by flx_nr_id desc");
            pStmt = con.prepareStatement(sql.toString());
            int cont = 1;
            for (int i = 0; i < listIdDoc.size(); i++) {
                Did_documento_identificacaoT didT = listIdDoc.get(i);
                pStmt.setObject(cont++, didT.getDid_tx_nomecoluna());
                pStmt.setObject(cont++, didT.getDid_tx_valor());
            }
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getByFirstDocTypeName(String docTypeName) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from tid_tipo_documento tid, tra_tramite tra where upper(tid.tid_tx_nome)=upper(?) and tid.tra_nr_id =tra.tra_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, docTypeName);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getByTra_nr_id(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE where  TRA_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tra_tramiteT.getTra_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getByDes_nr_id(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE where  DES_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tra_tramiteT.getDes_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getByTid_nr_id(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE where  TID_NR_ID = ? order by tra_nr_ordem ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tra_tramiteT.getTid_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getByUsu_nr_id(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE where  USU_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tra_tramiteT.getUsu_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getByTra_tx_nome(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE where  Upper(TRA_TX_NOME) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + tra_tramiteT.getTra_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tra_tramiteT> getByTra_tx_automatico(Tra_tramiteT tra_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.TRA_TRAMITE where  Upper(TRA_TX_AUTOMATICO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + tra_tramiteT.getTra_tx_automatico() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
}
