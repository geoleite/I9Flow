package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Des_destinoDAO extends ObjectDAO {

    public Des_destinoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Des_destinoT des_destinoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.DES_DESTINO  ( DES_NR_ID, DES_TX_TIPO, DES_NR_IDREGISTRO) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, des_destinoT.getDes_nr_id());
            pStmt.setObject(2, des_destinoT.getDes_tx_tipo());
            pStmt.setObject(3, des_destinoT.getDes_nr_idregistro());
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

    public void update(Des_destinoT des_destinoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.DES_DESTINO set  DES_TX_TIPO=?, DES_NR_IDREGISTRO=?  where  DES_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, des_destinoT.getDes_tx_tipo());
            pStmt.setObject(2, des_destinoT.getDes_nr_idregistro());
            pStmt.setObject(3, des_destinoT.getDes_nr_id());
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

    public void delete(Des_destinoT des_destinoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.DES_DESTINO where  DES_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, des_destinoT.getDes_nr_id());
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

    private List<Des_destinoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Des_destinoT> objs = new Vector();
        while (rs.next()) {
            Des_destinoT des_destinoT = new Des_destinoT();
            des_destinoT.setDes_nr_id(rs.getInt("DES_NR_ID"));
            des_destinoT.setDes_tx_tipo(rs.getString("DES_TX_TIPO"));
            des_destinoT.setDes_nr_idregistro(rs.getInt("DES_NR_IDREGISTRO"));
            objs.add(des_destinoT);
        }
        return objs;
    }

    public List<Des_destinoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DES_DESTINO";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Des_destinoT> list = resultSetToObjectTransfer(rs);
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

    public List<Des_destinoT> getByPK(Des_destinoT des_destinoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DES_DESTINO where  DES_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, des_destinoT.getDes_nr_id());
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

    public List<Des_destinoT> getByDes_nr_id(Des_destinoT des_destinoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DES_DESTINO where  DES_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, des_destinoT.getDes_nr_id());
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

    public List<Des_destinoT> getByUsuario(int usuNrId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select des.* from USR_FLUXO.des_destino des, usr_fluxo.aru_usu_area aru where  aru.usu_nr_id=? and aru.are_nr_id = des.des_nr_idregistro";
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

    public List<Des_destinoT> getByUsuario(List<Integer> listId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer param = new StringBuffer();
            for (Integer integer : listId) {
                param.append(integer).append(", ");
            }
            param.append("-1");
            param.append(param);
            StringBuffer sql = new StringBuffer("select des.* from USR_FLUXO.des_destino des, usr_fluxo.aru_usu_area aru where  aru.usu_nr_id in (");
            sql.append(param.toString());
            sql.append(") and aru.are_nr_id = des.des_nr_idregistro");
            pStmt = con.prepareStatement(sql.toString());
            //pStmt.setObject(1, usuNrId);
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

    public List<Des_destinoT> getByDes_tx_tipo(Des_destinoT des_destinoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DES_DESTINO where  Upper(DES_TX_TIPO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + des_destinoT.getDes_tx_tipo() + '%');
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

    public List<Des_destinoT> getByDes_nr_idregistro(Des_destinoT des_destinoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DES_DESTINO where  DES_NR_IDREGISTRO = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, des_destinoT.getDes_nr_idregistro());
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
