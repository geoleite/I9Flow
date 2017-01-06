package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Opt_opcao_tramiteDAO extends ObjectDAO {

    public Opt_opcao_tramiteDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.OPT_OPCAO_TRAMITE  ( TRA_NR_IDORIGEM, TRA_NR_IDDESTINO, OPT_NR_ORDEM, OPT_TX_RETORNO, OPT_TX_NOME) values ( ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, opt_opcao_tramiteT.getTra_nr_idorigem());
            pStmt.setObject(2, opt_opcao_tramiteT.getTra_nr_iddestino());
            pStmt.setObject(3, opt_opcao_tramiteT.getOpt_nr_ordem());
            pStmt.setObject(4, opt_opcao_tramiteT.getOpt_tx_retorno());
            pStmt.setObject(5, opt_opcao_tramiteT.getOpt_tx_nome());
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

    public void update(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.OPT_OPCAO_TRAMITE set  OPT_NR_ORDEM=?, OPT_TX_RETORNO=?, OPT_TX_NOME=?  where  TRA_NR_IDORIGEM=? and TRA_NR_IDDESTINO=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, opt_opcao_tramiteT.getOpt_nr_ordem());
            pStmt.setObject(2, opt_opcao_tramiteT.getOpt_tx_retorno());
            pStmt.setObject(3, opt_opcao_tramiteT.getOpt_tx_nome());
            pStmt.setObject(4, opt_opcao_tramiteT.getTra_nr_idorigem());
            pStmt.setObject(5, opt_opcao_tramiteT.getTra_nr_iddestino());
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

    public void delete(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.OPT_OPCAO_TRAMITE where  TRA_NR_IDORIGEM=? and TRA_NR_IDDESTINO=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, opt_opcao_tramiteT.getTra_nr_idorigem());
            pStmt.setObject(2, opt_opcao_tramiteT.getTra_nr_iddestino());
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

    private List<Opt_opcao_tramiteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Opt_opcao_tramiteT> objs = new Vector();
        while (rs.next()) {
            Opt_opcao_tramiteT opt_opcao_tramiteT = new Opt_opcao_tramiteT();
            opt_opcao_tramiteT.setTra_nr_idorigem(rs.getInt("TRA_NR_IDORIGEM"));
            opt_opcao_tramiteT.setTra_nr_iddestino(rs.getInt("TRA_NR_IDDESTINO"));
            opt_opcao_tramiteT.setOpt_nr_ordem(rs.getInt("OPT_NR_ORDEM"));
            opt_opcao_tramiteT.setOpt_tx_retorno(rs.getString("OPT_TX_RETORNO"));
            opt_opcao_tramiteT.setOpt_tx_nome(rs.getString("OPT_TX_NOME"));
            objs.add(opt_opcao_tramiteT);
        }
        return objs;
    }

    public List<Opt_opcao_tramiteT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.OPT_OPCAO_TRAMITE";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Opt_opcao_tramiteT> list = resultSetToObjectTransfer(rs);
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

    public List<Opt_opcao_tramiteT> getByPK(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.OPT_OPCAO_TRAMITE where  TRA_NR_IDORIGEM=? and TRA_NR_IDDESTINO=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, opt_opcao_tramiteT.getTra_nr_idorigem());
            pStmt.setObject(2, opt_opcao_tramiteT.getTra_nr_iddestino());
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

    public List<Opt_opcao_tramiteT> getByTra_nr_idorigem(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from opt_opcao_tramite where tra_nr_idorigem=? order by opt_nr_ordem";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, opt_opcao_tramiteT.getTra_nr_idorigem());
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

    public List<Opt_opcao_tramiteT> getByTra_nr_iddestino(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.OPT_OPCAO_TRAMITE where  TRA_NR_IDDESTINO = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, opt_opcao_tramiteT.getTra_nr_iddestino());
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

    public List<Opt_opcao_tramiteT> getByOpt_nr_ordem(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.OPT_OPCAO_TRAMITE where  OPT_NR_ORDEM = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, opt_opcao_tramiteT.getOpt_nr_ordem());
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

    public List<Opt_opcao_tramiteT> getByOpt_tx_retorno(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.OPT_OPCAO_TRAMITE where  Upper(OPT_TX_RETORNO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + opt_opcao_tramiteT.getOpt_tx_retorno() + '%');
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

    public List<Opt_opcao_tramiteT> getByOpt_tx_nome(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.OPT_OPCAO_TRAMITE where  Upper(OPT_TX_NOME) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + opt_opcao_tramiteT.getOpt_tx_nome() + '%');
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
