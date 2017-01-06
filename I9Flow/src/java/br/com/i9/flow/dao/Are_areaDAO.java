package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Are_areaDAO extends ObjectDAO {

    public Are_areaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Are_areaT are_areaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.ARE_AREA  ( ARE_NR_ID, ARE_TX_NOME) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, are_areaT.getAre_nr_id());
            pStmt.setObject(2, are_areaT.getAre_tx_nome());
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

    public void update(Are_areaT are_areaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.ARE_AREA set  ARE_TX_NOME=?  where  ARE_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, are_areaT.getAre_tx_nome());
            pStmt.setObject(2, are_areaT.getAre_nr_id());
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

    public void delete(Are_areaT are_areaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.ARE_AREA where  ARE_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, are_areaT.getAre_nr_id());
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

    private List<Are_areaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Are_areaT> objs = new Vector();
        while (rs.next()) {
            Are_areaT are_areaT = new Are_areaT();
            are_areaT.setAre_nr_id(rs.getInt("ARE_NR_ID"));
            are_areaT.setAre_tx_nome(rs.getString("ARE_TX_NOME"));
            objs.add(are_areaT);
        }
        return objs;
    }


    public List<Are_areaT> getByUsuario(int usuNrId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select are.* from USR_FLUXO.ARE_AREA are, usr_fluxo.aru_usu_area aru where  aru.usu_nr_id=? and are.ARE_NR_ID = aru.are_nr_id ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, usuNrId);
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
    public List<Are_areaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.ARE_AREA";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Are_areaT> list = resultSetToObjectTransfer(rs);
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

    public List<Are_areaT> getByPK(Are_areaT are_areaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.ARE_AREA where  ARE_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, are_areaT.getAre_nr_id());
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

    public List<Are_areaT> getByAre_nr_id(Are_areaT are_areaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.ARE_AREA where  ARE_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, are_areaT.getAre_nr_id());
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

    public List<Are_areaT> getByAre_tx_nome(Are_areaT are_areaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.ARE_AREA where  Upper(ARE_TX_NOME) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + are_areaT.getAre_tx_nome() + '%');
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
