package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.easynet.util.Text;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Flx_fluxoDAO extends ObjectDAO {

    private static String sinal = "sinal";

    public Flx_fluxoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    private int getAutoIncremento() throws Exception {
        String sql = "select max(flx_nr_id) from usr_fluxo.flx_fluxo";
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        int codigo = 0;
        if (rs.next()) {
            codigo = rs.getInt(1);
        }
        return codigo;
    }

    private String substituindoFromEnter(String txt) {
        return txt.replaceAll("\n", "#").replaceAll("\t", "#").replaceAll("\r", "#");
    }

    public void insert(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.FLX_FLUXO  ( FLX_DT_MOVIMENTACAO, FLX_TX_OBS,  FLX_NR_IDANTERIOR, TRA_NR_IDORIGEM, TRA_NR_IDDESTINO, usu_nr_id) values ( ? , replace(?, chr(13) || chr(10), '#') , ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            java.sql.Timestamp dt1 = new java.sql.Timestamp(System.currentTimeMillis());
            pStmt.setObject(1, dt1);
            String textObs = Text.removeAcentos(flx_fluxoT.getFlx_tx_obs());
            textObs = substituindoFromEnter(textObs);
            pStmt.setObject(2, textObs);
            pStmt.setObject(3, flx_fluxoT.getFlx_nr_idanterior());
            pStmt.setObject(4, flx_fluxoT.getTra_nr_idorigem());
            pStmt.setObject(5, flx_fluxoT.getTra_nr_iddestino());
            pStmt.setObject(6, flx_fluxoT.getUsu_nr_id());
            synchronized (sinal) {
                pStmt.execute();
                flx_fluxoT.setFlx_nr_id(getAutoIncremento());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void update(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.FLX_FLUXO set FLX_TX_OBS=replace(?, chr(13) || chr(10), '#'), FLX_DT_FINALIZADO=?, FLX_NR_IDANTERIOR=?, TRA_NR_IDORIGEM=?, TRA_NR_IDDESTINO=?  where  FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            String textObs = Text.removeAcentos(flx_fluxoT.getFlx_tx_obs());
            textObs = substituindoFromEnter(textObs);

            pStmt.setObject(1, textObs);
            java.sql.Date dt2 = new java.sql.Date(flx_fluxoT.getFlx_dt_finalizado().getTime());
            pStmt.setObject(2, dt2);
            pStmt.setObject(3, flx_fluxoT.getFlx_nr_idanterior());
            pStmt.setObject(4, flx_fluxoT.getTra_nr_idorigem());
            pStmt.setObject(5, flx_fluxoT.getTra_nr_iddestino());
            pStmt.setObject(6, flx_fluxoT.getFlx_nr_id());
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

    public void updateObsUsuario(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.FLX_FLUXO set FLX_TX_OBS=replace(?, chr(13) || chr(10), '#'), usu_nr_id=? where  FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            String textObs = Text.removeAcentos(flx_fluxoT.getFlx_tx_obs());
            textObs = substituindoFromEnter(textObs);

            pStmt.setObject(1, textObs);
            pStmt.setObject(2, flx_fluxoT.getUsu_nr_id());
            pStmt.setObject(3, flx_fluxoT.getFlx_nr_id());
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

    public void updateUsuario(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.FLX_FLUXO set usu_nr_id=? where  FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flx_fluxoT.getUsu_nr_id());
            pStmt.setObject(2, flx_fluxoT.getFlx_nr_id());
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

    public void finalizeFluxo(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.FLX_FLUXO set FLX_DT_FINALIZADO=? where FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Timestamp dt1 = new java.sql.Timestamp(System.currentTimeMillis());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, flx_fluxoT.getFlx_nr_id());
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

    public void delete(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.FLX_FLUXO where  FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flx_fluxoT.getFlx_nr_id());
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

    private List<Flx_fluxoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Flx_fluxoT> objs = new Vector();
        while (rs.next()) {
            Flx_fluxoT flx_fluxoT = new Flx_fluxoT();
            flx_fluxoT.setFlx_nr_id(rs.getInt("FLX_NR_ID"));
            flx_fluxoT.setUsu_nr_id(rs.getInt("USU_NR_ID"));
            flx_fluxoT.setFlx_dt_movimentacao(rs.getTimestamp("FLX_DT_MOVIMENTACAO"));

            String textObs = rs.getString("FLX_TX_OBS");
            if (textObs == null) {
                textObs = "";
            }
            textObs = Text.removeAcentos(textObs);
            textObs = substituindoFromEnter(textObs);

            flx_fluxoT.setFlx_tx_obs(textObs);
            flx_fluxoT.setFlx_dt_finalizado(rs.getTimestamp("FLX_DT_FINALIZADO"));
            flx_fluxoT.setFlx_nr_idanterior(rs.getInt("FLX_NR_IDANTERIOR"));
            flx_fluxoT.setTra_nr_idorigem(rs.getInt("TRA_NR_IDORIGEM"));
            flx_fluxoT.setTra_nr_iddestino(rs.getInt("TRA_NR_IDDESTINO"));
            objs.add(flx_fluxoT);
        }
        return objs;
    }

    public List<Flx_fluxoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Flx_fluxoT> list = resultSetToObjectTransfer(rs);
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
    public List<Flx_fluxoT> getByIdsDoc(List<Did_documento_identificacaoT> listIdDoc) throws Exception {
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

    public List<Flx_fluxoT> getByPK(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  FLX_NR_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flx_fluxoT.getFlx_nr_id());
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

    public List<Flx_fluxoT> getByFlx_nr_id(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  FLX_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flx_fluxoT.getFlx_nr_id());
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

    public List<Flx_fluxoT> getByFlx_dt_movimentacao(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  FLX_DT_MOVIMENTACAO = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(flx_fluxoT.getFlx_dt_movimentacao().getTime());
            pStmt.setObject(1, dt1);
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

    public List<Flx_fluxoT> getByFlx_tx_obs(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  Upper(FLX_TX_OBS) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + flx_fluxoT.getFlx_tx_obs() + '%');
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

    public List<Flx_fluxoT> getByFlx_dt_finalizado(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  FLX_DT_FINALIZADO = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(flx_fluxoT.getFlx_dt_finalizado().getTime());
            pStmt.setObject(1, dt1);
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

    public List<Flx_fluxoT> getByFlx_nr_idanterior(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  FLX_NR_IDANTERIOR = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flx_fluxoT.getFlx_nr_idanterior());
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

    public List<Flx_fluxoT> getByTra_nr_idorigem(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  TRA_NR_IDORIGEM = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flx_fluxoT.getTra_nr_idorigem());
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

    public List<Flx_fluxoT> getByTra_nr_iddestino(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  TRA_NR_IDDESTINO = ? order by FLX_DT_MOVIMENTACAO ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flx_fluxoT.getTra_nr_iddestino());
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

    public List<Flx_fluxoT> getByTramiteAtual(Flx_fluxoT flx_fluxoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.FLX_FLUXO where  FLX_DT_FINALIZADO is null and TRA_NR_IDDESTINO = ? order by FLX_DT_MOVIMENTACAO ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flx_fluxoT.getTra_nr_iddestino());
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
