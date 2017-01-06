package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Lgc_logicaDAO extends ObjectDAO {

    public Lgc_logicaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.LGC_LOGICA  ( LGC_NR_ID, TRA_NR_ID, LGC_TX_CLASSE, LGC_TX_STATUS, LGC_NR_ORDEM, LGC_TX_DESCRICAO) values ( ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lgc_logicaT.getLgc_nr_id());
            pStmt.setObject(2, lgc_logicaT.getTra_nr_id());
            pStmt.setObject(3, lgc_logicaT.getLgc_tx_classe());
            pStmt.setObject(4, lgc_logicaT.getLgc_tx_status());
            pStmt.setObject(5, lgc_logicaT.getLgc_nr_ordem());
            pStmt.setObject(6, lgc_logicaT.getLgc_tx_descricao());
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

    public void update(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.LGC_LOGICA set  TRA_NR_ID=?, LGC_TX_CLASSE=?, LGC_TX_STATUS=?, LGC_NR_ORDEM=?, LGC_TX_DESCRICAO=?  where  LGC_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lgc_logicaT.getTra_nr_id());
            pStmt.setObject(2, lgc_logicaT.getLgc_tx_classe());
            pStmt.setObject(3, lgc_logicaT.getLgc_tx_status());
            pStmt.setObject(4, lgc_logicaT.getLgc_nr_ordem());
            pStmt.setObject(5, lgc_logicaT.getLgc_tx_descricao());
            pStmt.setObject(6, lgc_logicaT.getLgc_nr_id());
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

    public void delete(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.LGC_LOGICA where  LGC_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lgc_logicaT.getLgc_nr_id());
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

    private List<Lgc_logicaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Lgc_logicaT> objs = new Vector();
        while (rs.next()) {
            Lgc_logicaT lgc_logicaT = new Lgc_logicaT();
            lgc_logicaT.setLgc_nr_id(rs.getInt("LGC_NR_ID"));
            lgc_logicaT.setTra_nr_id(rs.getInt("TRA_NR_ID"));
            lgc_logicaT.setLgc_tx_classe(rs.getString("LGC_TX_CLASSE"));
            lgc_logicaT.setLgc_tx_status(rs.getString("LGC_TX_STATUS"));
            lgc_logicaT.setLgc_nr_ordem(rs.getInt("LGC_NR_ORDEM"));
            lgc_logicaT.setLgc_tx_descricao(rs.getString("LGC_TX_DESCRICAO"));
            objs.add(lgc_logicaT);
        }
        return objs;
    }

    public List<Lgc_logicaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.LGC_LOGICA";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Lgc_logicaT> list = resultSetToObjectTransfer(rs);
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

    public List<Lgc_logicaT> getByPK(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.LGC_LOGICA where  LGC_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lgc_logicaT.getLgc_nr_id());
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

    public List<Lgc_logicaT> getByLgc_nr_id(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.LGC_LOGICA where  LGC_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lgc_logicaT.getLgc_nr_id());
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

    public List<Lgc_logicaT> getByTra_nr_id(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.LGC_LOGICA where  TRA_NR_ID = ? order by LGC_NR_ORDEM ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lgc_logicaT.getTra_nr_id());
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

    public List<Lgc_logicaT> getByLgc_tx_classe(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.LGC_LOGICA where  Upper(LGC_TX_CLASSE) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + lgc_logicaT.getLgc_tx_classe() + '%');
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

    public List<Lgc_logicaT> getByLgc_tx_status(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.LGC_LOGICA where  Upper(LGC_TX_STATUS) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + lgc_logicaT.getLgc_tx_status() + '%');
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

    public List<Lgc_logicaT> getByLgc_nr_ordem(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.LGC_LOGICA where  LGC_NR_ORDEM = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lgc_logicaT.getLgc_nr_ordem());
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

    public List<Lgc_logicaT> getByLgc_tx_descricao(Lgc_logicaT lgc_logicaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.LGC_LOGICA where  Upper(LGC_TX_DESCRICAO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + lgc_logicaT.getLgc_tx_descricao() + '%');
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
