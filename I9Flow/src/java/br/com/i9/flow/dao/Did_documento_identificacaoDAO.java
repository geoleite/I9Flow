package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Did_documento_identificacaoDAO extends ObjectDAO {

    public Did_documento_identificacaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO  ( FLX_NR_ID, DID_TX_NOMECOLUNA, DID_TX_VALOR) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, did_documento_identificacaoT.getFlx_nr_id());
            pStmt.setObject(2, did_documento_identificacaoT.getDid_tx_nomecoluna());
            pStmt.setObject(3, did_documento_identificacaoT.getDid_tx_valor());
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

    public void update(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO set  DID_TX_NOMECOLUNA=?, DID_TX_VALOR=?  where  DID_NR_ID=? and FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, did_documento_identificacaoT.getDid_tx_nomecoluna());
            pStmt.setObject(2, did_documento_identificacaoT.getDid_tx_valor());
            pStmt.setObject(3, did_documento_identificacaoT.getDid_nr_id());
            pStmt.setObject(4, did_documento_identificacaoT.getFlx_nr_id());
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

    public void delete(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO where  DID_NR_ID=? and FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, did_documento_identificacaoT.getDid_nr_id());
            pStmt.setObject(2, did_documento_identificacaoT.getFlx_nr_id());
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

    private List<Did_documento_identificacaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Did_documento_identificacaoT> objs = new Vector();
        while (rs.next()) {
            Did_documento_identificacaoT did_documento_identificacaoT = new Did_documento_identificacaoT();
            did_documento_identificacaoT.setDid_nr_id(rs.getInt("DID_NR_ID"));
            did_documento_identificacaoT.setFlx_nr_id(rs.getInt("FLX_NR_ID"));
            did_documento_identificacaoT.setDid_tx_nomecoluna(rs.getString("DID_TX_NOMECOLUNA"));
            did_documento_identificacaoT.setDid_tx_valor(rs.getString("DID_TX_VALOR"));
            objs.add(did_documento_identificacaoT);
        }
        return objs;
    }

    public List<Did_documento_identificacaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Did_documento_identificacaoT> list = resultSetToObjectTransfer(rs);
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

    /**
     * Obtendo os ids do documento que foram finalizados
     * @param traNrIdDestino
     * @param listUser
     * @return
     * @throws Exception
     */
    public List<Did_documento_identificacaoT> getByUsuarioProcuracao(int traNrIdDestino, List<Integer> listUser,
            java.util.Date dtInicial, java.util.Date dtFinal) throws Exception {
        StringBuffer param = new StringBuffer();
        for (Integer integer : listUser) {
            param.append(integer).append(", ");
        }
        param.append("-1");
        StringBuffer sql = new StringBuffer("select * from did_documento_identificacao where flx_nr_id in ( select flx_nr_id from flx_fluxo where flx_dt_finalizado is not null and flx_dt_finalizado between ? and ? and tra_nr_iddestino = ? and usu_nr_id in  ");
        sql.append("(").append(param).append(")) order by flx_nr_id");
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            pStmt = con.prepareStatement(sql.toString());
            java.sql.Date dt = new java.sql.Date(dtInicial.getTime());
            pStmt.setObject(1, dt);
            dt = new java.sql.Date(dtFinal.getTime());
            pStmt.setObject(2, dt);
            pStmt.setObject(3, traNrIdDestino);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                rs = null;
                pStmt.close();
                pStmt = null;
            } catch (Exception e) {
            }
        }
    }

    /**
     * Obtem todos os identificadores por periodo em um tramite
     * @param traNrIdDestino
     * @param dtInicial
     * @param dtFinal
     * @return
     * @throws Exception
     */
    public List<Did_documento_identificacaoT> getByPeriodoTramite(int traNrIdDestino,
            java.util.Date dtInicial, java.util.Date dtFinal) throws Exception {
        StringBuffer sql = new StringBuffer("select * from did_documento_identificacao where flx_nr_id in ( select flx_nr_id from flx_fluxo where flx_dt_finalizado is not null and flx_dt_finalizado between ? and ? and tra_nr_iddestino = ? ").append(") order by flx_nr_id");
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            pStmt = con.prepareStatement(sql.toString());
            java.sql.Date dt = new java.sql.Date(dtInicial.getTime());
            pStmt.setObject(1, dt);
            dt = new java.sql.Date(dtFinal.getTime());
            pStmt.setObject(2, dt);
            pStmt.setObject(3, traNrIdDestino);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                rs = null;
                pStmt.close();
                pStmt = null;
            } catch (Exception e) {
            }
        }
    }

    public int getCountIdsByIdFluxo(int flxNrId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(flx_nr_id) from did_documento_identificacao where flx_nr_id=?";
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, flxNrId);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
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

    public List<Did_documento_identificacaoT> getByFluxos(String idsFluxo) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO where  FLX_NR_ID in (".concat(idsFluxo).concat(" ) order by DID_TX_NOMECOLUNA");
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                rs = null;
                pStmt.close();
                pStmt = null;
            } catch (Exception e) {
            }
        }
    }

    public List<Did_documento_identificacaoT> getByPK(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO where  DID_NR_ID=? and FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, did_documento_identificacaoT.getDid_nr_id());
            pStmt.setObject(2, did_documento_identificacaoT.getFlx_nr_id());
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


    public List<Did_documento_identificacaoT> getByDid_nr_id(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO where  DID_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, did_documento_identificacaoT.getDid_nr_id());
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

    public List<Did_documento_identificacaoT> getByFlx_nr_id(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO where  FLX_NR_ID = ? order by DID_TX_NOMECOLUNA";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, did_documento_identificacaoT.getFlx_nr_id());
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

    public List<Did_documento_identificacaoT> getByDid_tx_nomecoluna(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO where  Upper(DID_TX_NOMECOLUNA) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + did_documento_identificacaoT.getDid_tx_nomecoluna() + '%');
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

    public List<Did_documento_identificacaoT> getByDid_tx_valor(Did_documento_identificacaoT did_documento_identificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.DID_DOCUMENTO_IDENTIFICACAO where  Upper(DID_TX_VALOR) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + did_documento_identificacaoT.getDid_tx_valor() + '%');
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
