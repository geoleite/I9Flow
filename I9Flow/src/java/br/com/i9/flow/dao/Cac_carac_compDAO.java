package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Cac_carac_compDAO extends ObjectDAO {

    public Cac_carac_compDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.CAC_CARAC_COMP  ( TRA_NR_ID, TEL_NR_ID, CAC_NR_ID, CAC_TX_IDCOMPONENTE, CAC_TX_VISIVEL, CAC_TX_HABILITADO, CAC_TX_EDITAVEL, CAC_NR_ORDEM) values ( ? , ? , ? , ? , ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cac_carac_compT.getTra_nr_id());
            pStmt.setObject(2, cac_carac_compT.getTel_nr_id());
            pStmt.setObject(3, cac_carac_compT.getCac_nr_id());
            pStmt.setObject(4, cac_carac_compT.getCac_tx_idcomponente());
            pStmt.setObject(5, cac_carac_compT.getCac_tx_visivel());
            pStmt.setObject(6, cac_carac_compT.getCac_tx_habilitado());
            pStmt.setObject(7, cac_carac_compT.getCac_tx_editavel());
            pStmt.setObject(8, cac_carac_compT.getCac_nr_ordem());
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

    public void update(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.CAC_CARAC_COMP set CAC_TX_IDCOMPONENTE=?, CAC_TX_VISIVEL=?, CAC_TX_HABILITADO=?, CAC_TX_EDITAVEL=?, CAC_NR_ORDEM=? where  TRA_NR_ID=? and TEL_NR_ID=? and CAC_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cac_carac_compT.getCac_tx_idcomponente());
            pStmt.setObject(2, cac_carac_compT.getCac_tx_visivel());
            pStmt.setObject(3, cac_carac_compT.getCac_tx_habilitado());
            pStmt.setObject(4, cac_carac_compT.getCac_tx_editavel());
            pStmt.setObject(5, cac_carac_compT.getCac_nr_ordem());
            pStmt.setObject(6, cac_carac_compT.getTra_nr_id());
            pStmt.setObject(7, cac_carac_compT.getTel_nr_id());
            pStmt.setObject(8, cac_carac_compT.getCac_nr_id());
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

    public void delete(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.CAC_CARAC_COMP where  TRA_NR_ID=? and TEL_NR_ID=? and CAC_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cac_carac_compT.getTra_nr_id());
            pStmt.setObject(2, cac_carac_compT.getTel_nr_id());
            pStmt.setObject(3, cac_carac_compT.getCac_nr_id());
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

    private List<Cac_carac_compT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cac_carac_compT> objs = new Vector();
        while (rs.next()) {
            Cac_carac_compT cac_carac_compT = new Cac_carac_compT();
            cac_carac_compT.setTra_nr_id(rs.getInt("TRA_NR_ID"));
            cac_carac_compT.setTel_nr_id(rs.getInt("TEL_NR_ID"));
            cac_carac_compT.setCac_nr_id(rs.getInt("CAC_NR_ID"));
            cac_carac_compT.setCac_tx_idcomponente(rs.getString("CAC_TX_IDCOMPONENTE"));
            cac_carac_compT.setCac_tx_visivel(rs.getString("CAC_TX_VISIVEL"));
            cac_carac_compT.setCac_tx_habilitado(rs.getString("CAC_TX_HABILITADO"));
            cac_carac_compT.setCac_tx_editavel(rs.getString("CAC_TX_EDITAVEL"));
            cac_carac_compT.setCac_nr_ordem(rs.getInt("CAC_NR_ORDEM"));
            objs.add(cac_carac_compT);
        }
        return objs;
    }

    public List<Cac_carac_compT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cac_carac_compT> list = resultSetToObjectTransfer(rs);
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

    public List<Cac_carac_compT> getByPK(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP where  TRA_NR_ID=? and TEL_NR_ID=? and CAC_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cac_carac_compT.getTra_nr_id());
            pStmt.setObject(2, cac_carac_compT.getTel_nr_id());
            pStmt.setObject(3, cac_carac_compT.getCac_nr_id());
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

    public List<Cac_carac_compT> getByClassNameAndFlowId(String className, Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cac.* from tel_tela tel, cac_carac_comp cac where tel.tel_tx_nome=? and tel.tel_nr_id= cac.tel_nr_id and cac.tra_nr_id=? order by cac.cac_nr_ordem";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, className);
            pStmt.setObject(2, cac_carac_compT.getTra_nr_id());
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

    public List<Cac_carac_compT> getByTra_nr_id(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP where  TRA_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cac_carac_compT.getTra_nr_id());
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

    public List<Cac_carac_compT> getByTel_nr_id(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP where  TEL_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cac_carac_compT.getTel_nr_id());
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

    public List<Cac_carac_compT> getByCac_nr_id(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP where  CAC_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cac_carac_compT.getCac_nr_id());
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

    public List<Cac_carac_compT> getByCac_tx_idcomponente(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP where  Upper(CAC_TX_IDCOMPONENTE) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cac_carac_compT.getCac_tx_idcomponente() + '%');
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

    public List<Cac_carac_compT> getByCac_tx_visivel(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP where  Upper(CAC_TX_VISIVEL) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cac_carac_compT.getCac_tx_visivel() + '%');
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

    public List<Cac_carac_compT> getByCac_tx_habilitado(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP where  Upper(CAC_TX_HABILITADO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cac_carac_compT.getCac_tx_habilitado() + '%');
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

    public List<Cac_carac_compT> getByCac_tx_editavel(Cac_carac_compT cac_carac_compT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.CAC_CARAC_COMP where  Upper(CAC_TX_EDITAVEL) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cac_carac_compT.getCac_tx_editavel() + '%');
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
