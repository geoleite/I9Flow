package br.com.i9.flow.dao;

import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

public class Vw_tra_flx_usuDAO extends ObjectDAO {

    public Vw_tra_flx_usuDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into USR_FLUXO.VW_TRA_FLX_USU  ( TRA_NR_ID, DES_NR_ID, TID_NR_ID, USU_NR_IDOWNER, TRA_TX_NOME, TRA_TX_AUTOMATICO, FLX_NR_ID, FLX_DT_MOVIMENTACAO, FLX_TX_OBS, FLX_DT_FINALIZADO, FLX_NR_IDANTERIOR, TRA_NR_IDORIGEM, TRA_NR_IDDESTINO, USU_NR_ID, USU_TX_NOME, USU_TX_LOGIN, USU_TX_STATUS, USU_TX_EMAIL) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getTra_nr_id());
            pStmt.setObject(2, vw_tra_flx_usuT.getDes_nr_id());
            pStmt.setObject(3, vw_tra_flx_usuT.getTid_nr_id());
            pStmt.setObject(4, vw_tra_flx_usuT.getUsu_nr_idowner());
            pStmt.setObject(5, vw_tra_flx_usuT.getTra_tx_nome());
            pStmt.setObject(6, vw_tra_flx_usuT.getTra_tx_automatico());
            pStmt.setObject(7, vw_tra_flx_usuT.getFlx_nr_id());
            java.sql.Date dt8 = new java.sql.Date(vw_tra_flx_usuT.getFlx_dt_movimentacao().getTime());
            pStmt.setObject(8, dt8);
            pStmt.setObject(9, vw_tra_flx_usuT.getFlx_tx_obs());
            java.sql.Date dt10 = new java.sql.Date(vw_tra_flx_usuT.getFlx_dt_finalizado().getTime());
            pStmt.setObject(10, dt10);
            pStmt.setObject(11, vw_tra_flx_usuT.getFlx_nr_idanterior());
            pStmt.setObject(12, vw_tra_flx_usuT.getTra_nr_idorigem());
            pStmt.setObject(13, vw_tra_flx_usuT.getTra_nr_iddestino());
            pStmt.setObject(14, vw_tra_flx_usuT.getUsu_nr_id());
            pStmt.setObject(15, vw_tra_flx_usuT.getUsu_tx_nome());
            pStmt.setObject(16, vw_tra_flx_usuT.getUsu_tx_login());
            pStmt.setObject(17, vw_tra_flx_usuT.getUsu_tx_status());
            pStmt.setObject(18, vw_tra_flx_usuT.getUsu_tx_email());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
                pStmt = null;
            } catch (Exception e) {
            }

        }
    }

    public void update(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update USR_FLUXO.VW_TRA_FLX_USU set  TRA_NR_ID=?, DES_NR_ID=?, TID_NR_ID=?, USU_NR_IDOWNER=?, TRA_TX_NOME=?, TRA_TX_AUTOMATICO=?, FLX_NR_ID=?, FLX_DT_MOVIMENTACAO=?, FLX_TX_OBS=?, FLX_DT_FINALIZADO=?, FLX_NR_IDANTERIOR=?, TRA_NR_IDORIGEM=?, TRA_NR_IDDESTINO=?, USU_NR_ID=?, USU_TX_NOME=?, USU_TX_LOGIN=?, USU_TX_STATUS=?, USU_TX_EMAIL=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getTra_nr_id());
            pStmt.setObject(2, vw_tra_flx_usuT.getDes_nr_id());
            pStmt.setObject(3, vw_tra_flx_usuT.getTid_nr_id());
            pStmt.setObject(4, vw_tra_flx_usuT.getUsu_nr_idowner());
            pStmt.setObject(5, vw_tra_flx_usuT.getTra_tx_nome());
            pStmt.setObject(6, vw_tra_flx_usuT.getTra_tx_automatico());
            pStmt.setObject(7, vw_tra_flx_usuT.getFlx_nr_id());
            java.sql.Timestamp dt8 = new java.sql.Timestamp(vw_tra_flx_usuT.getFlx_dt_movimentacao().getTime());
            pStmt.setObject(8, dt8);
            pStmt.setObject(9, vw_tra_flx_usuT.getFlx_tx_obs());
            java.sql.Timestamp dt10 = new java.sql.Timestamp(vw_tra_flx_usuT.getFlx_dt_finalizado().getTime());
            pStmt.setObject(10, dt10);
            pStmt.setObject(11, vw_tra_flx_usuT.getFlx_nr_idanterior());
            pStmt.setObject(12, vw_tra_flx_usuT.getTra_nr_idorigem());
            pStmt.setObject(13, vw_tra_flx_usuT.getTra_nr_iddestino());
            pStmt.setObject(14, vw_tra_flx_usuT.getUsu_nr_id());
            pStmt.setObject(15, vw_tra_flx_usuT.getUsu_tx_nome());
            pStmt.setObject(16, vw_tra_flx_usuT.getUsu_tx_login());
            pStmt.setObject(17, vw_tra_flx_usuT.getUsu_tx_status());
            pStmt.setObject(18, vw_tra_flx_usuT.getUsu_tx_email());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
                pStmt = null;
            } catch (Exception e) {
            }

        }
    }

    public void delete(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from USR_FLUXO.VW_TRA_FLX_USU where -";
            pStmt = con.prepareStatement(sql);
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
                pStmt = null;
            } catch (Exception e) {
            }

        }
    }

    private List<Vw_tra_flx_usuT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Vw_tra_flx_usuT> objs = new Vector<Vw_tra_flx_usuT>();
        while (rs.next()) {
            Vw_tra_flx_usuT vw_tra_flx_usuT = new Vw_tra_flx_usuT();
            vw_tra_flx_usuT.setTra_nr_id(rs.getInt("TRA_NR_ID"));
            vw_tra_flx_usuT.setDes_nr_id(rs.getInt("DES_NR_ID"));
            vw_tra_flx_usuT.setTid_nr_id(rs.getInt("TID_NR_ID"));
            vw_tra_flx_usuT.setUsu_nr_idowner(rs.getInt("USU_NR_IDOWNER"));
            vw_tra_flx_usuT.setTra_tx_nome(rs.getString("TRA_TX_NOME"));
            vw_tra_flx_usuT.setTra_tx_automatico(rs.getString("TRA_TX_AUTOMATICO"));
            vw_tra_flx_usuT.setFlx_nr_id(rs.getInt("FLX_NR_ID"));
            vw_tra_flx_usuT.setFlx_dt_movimentacao(rs.getTimestamp("FLX_DT_MOVIMENTACAO"));
            String obs = rs.getString("FLX_TX_OBS");
            vw_tra_flx_usuT.setFlx_tx_obs(obs != null ? obs : " ");
            vw_tra_flx_usuT.setFlx_dt_finalizado(rs.getTimestamp("FLX_DT_FINALIZADO"));
            vw_tra_flx_usuT.setFlx_nr_idanterior(rs.getInt("FLX_NR_IDANTERIOR"));
            vw_tra_flx_usuT.setTra_nr_idorigem(rs.getInt("TRA_NR_IDORIGEM"));
            vw_tra_flx_usuT.setTra_nr_iddestino(rs.getInt("TRA_NR_IDDESTINO"));
            vw_tra_flx_usuT.setUsu_nr_id(rs.getInt("USU_NR_ID"));
            vw_tra_flx_usuT.setUsu_tx_nome(rs.getString("USU_TX_NOME"));
            vw_tra_flx_usuT.setUsu_tx_login(rs.getString("USU_TX_LOGIN"));
            vw_tra_flx_usuT.setUsu_tx_status(rs.getString("USU_TX_STATUS"));
            vw_tra_flx_usuT.setUsu_tx_email(rs.getString("USU_TX_EMAIL"));
            objs.add(vw_tra_flx_usuT);
        }
        return objs;
    }

    public List<Vw_tra_flx_usuT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Vw_tra_flx_usuT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;
            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByPK(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where -";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByTra_nr_id(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  TRA_NR_ID = ? and FLX_DT_FINALIZADO is null";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getTra_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByAreas(List<Are_areaT> listAre) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listAre.size(); i++) {
                Are_areaT are_areaT = listAre.get(i);
                param.append(are_areaT.getAre_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer sql = new StringBuffer("select * from USR_FLUXO.vw_tra_flx_usu tfu, usr_fluxo.des_destino des where  des.des_tx_tipo='A' and des.des_nr_id in (");
            sql.append(param.toString()).append(") and des.des_nr_id = tfu.des_nr_id and flx_dt_finalizado is null order by FLX_DT_MOVIMENTACAO desc");
            pStmt = con.prepareStatement(sql.toString());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }
        }
    }

    public List<Vw_tra_flx_usuT> getByAreasDestino(List<Des_destinoT> listDes, int usuNrId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listDes.size(); i++) {
                Des_destinoT desT = listDes.get(i);
                param.append(desT.getDes_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer sql = new StringBuffer("select * from vw_tra_flx_usu tfu where tfu.des_nr_id in (");
            sql.append(param.toString()).append(") and (tfu.usu_nr_id is null or tfu.usu_nr_id=?) and flx_dt_finalizado is null order by FLX_DT_MOVIMENTACAO desc ");
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, usuNrId);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByAreasDestinoPeriodo(List<Des_destinoT> listDes, int usuNrId, java.util.Date dtInicio, java.util.Date dtFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listDes.size(); i++) {
                Des_destinoT desT = listDes.get(i);
                param.append(desT.getDes_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer sql = new StringBuffer("select * from vw_tra_flx_usu tfu where tfu.des_nr_id in (");
            sql.append(param.toString()).append(") and (tfu.usu_nr_id is null or tfu.usu_nr_id=?) and flx_dt_finalizado is null and FLX_DT_MOVIMENTACAO between ? and ? order by FLX_DT_MOVIMENTACAO desc ");
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, usuNrId);
            Date dtI = new Date(dtInicio.getTime());
            pStmt.setObject(2, dtI);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dtFinal);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date dtF = new Date(cal.getTimeInMillis());
            pStmt.setObject(3, dtF);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByAreasDestinoExcetoTramites(List<Des_destinoT> listDes, int usuNrId, String idTramites) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listDes.size(); i++) {
                Des_destinoT desT = listDes.get(i);
                param.append(desT.getDes_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer sql = new StringBuffer("select * from vw_tra_flx_usu tfu where tfu.des_nr_id in (");
            sql.append(param.toString()).append(") and (tfu.usu_nr_id is null or tfu.usu_nr_id=?) and flx_dt_finalizado is null and tra_nr_id not in(").append(idTramites).append(") order by FLX_DT_MOVIMENTACAO desc ");
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, usuNrId);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByAreasDestinoExcetoTramitesPeriodo(List<Des_destinoT> listDes, int usuNrId, String idTramites, java.util.Date dtInicio, java.util.Date dtFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listDes.size(); i++) {
                Des_destinoT desT = listDes.get(i);
                param.append(desT.getDes_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer sql = new StringBuffer("select * from vw_tra_flx_usu tfu where tfu.des_nr_id in (");
            sql.append(param.toString()).append(") and (tfu.usu_nr_id is null or tfu.usu_nr_id=?) and flx_dt_finalizado is null and FLX_DT_MOVIMENTACAO between ? and ?  and tra_nr_id not in(").append(idTramites).append(") order by FLX_DT_MOVIMENTACAO desc ");
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, usuNrId);
            Date dtI = new Date(dtInicio.getTime());
            pStmt.setObject(2, dtI);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dtFinal);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date dtF = new Date(cal.getTimeInMillis());
            pStmt.setObject(3, dtF);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    /**
     * Consulta os fluxos baseado no usuário e na procuração
     * @param listDes
     * @param usuNrId
     * @return
     * @throws Exception
     */
    public List<Vw_tra_flx_usuT> getByAreasDestino(List<Des_destinoT> listDes, List<Integer> listUsuarios) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            /*
            select * from flx_fluxo tfu where flx_nr_idanterior <> 0 and (tfu.usu_nr_id is null or tfu.usu_nr_id in (10, 371, 370,429,474,475,476,478) or -1=1) and flx_dt_finalizado is null order by FLX_DT_MOVIMENTACAO desc
             * ou
            select * from vw_tra_flx_usu where flx_nr_id in (
            select flx_nr_id from flx_fluxo tfu where flx_nr_idanterior <> 0 and (tfu.usu_nr_id is null or tfu.usu_nr_id in (10, 371, 370,429,474,475,476,478) or -1=1) and flx_dt_finalizado is null ) order by FLX_DT_MOVIMENTACAO desc
             */

            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listDes.size(); i++) {
                Des_destinoT desT = listDes.get(i);
                param.append(desT.getDes_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer paramUsu = new StringBuffer();
            for (int i = 0; i < listUsuarios.size(); i++) {
                int codigo = listUsuarios.get(i);
                paramUsu.append(codigo).append(", ");
            }
            paramUsu.append("-1");

            StringBuffer sql = new StringBuffer("select * from vw_tra_flx_usu tfu where ");
            if (listDes != null && listDes.size() > 0) {
                sql.append(" tfu.des_nr_id in (").append(param.toString()).append(") and ");
            }
            sql.append(" (tfu.usu_nr_id is null or ");
            if (listUsuarios != null && listUsuarios.size() > 0) {
                sql.append(" tfu.usu_nr_id in (").append(paramUsu).append(") or ");
            }
            sql.append(" -1=1) and ");

            sql.append(" flx_dt_finalizado is null order by FLX_DT_MOVIMENTACAO desc ");
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
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByAreasDestinoPeriodo(List<Des_destinoT> listDes, List<Integer> listUsuarios, java.util.Date dtInicio, java.util.Date dtFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            /*
            select * from flx_fluxo tfu where flx_nr_idanterior <> 0 and (tfu.usu_nr_id is null or tfu.usu_nr_id in (10, 371, 370,429,474,475,476,478) or -1=1) and flx_dt_finalizado is null order by FLX_DT_MOVIMENTACAO desc
             * ou
            select * from vw_tra_flx_usu where flx_nr_id in (
            select flx_nr_id from flx_fluxo tfu where flx_nr_idanterior <> 0 and (tfu.usu_nr_id is null or tfu.usu_nr_id in (10, 371, 370,429,474,475,476,478) or -1=1) and flx_dt_finalizado is null ) order by FLX_DT_MOVIMENTACAO desc
             */

            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listDes.size(); i++) {
                Des_destinoT desT = listDes.get(i);
                param.append(desT.getDes_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer paramUsu = new StringBuffer();
            for (int i = 0; i < listUsuarios.size(); i++) {
                int codigo = listUsuarios.get(i);
                paramUsu.append(codigo).append(", ");
            }
            paramUsu.append("-1");

            StringBuffer sql = new StringBuffer("select * from vw_tra_flx_usu tfu where ");
            if (listDes != null && listDes.size() > 0) {
                sql.append(" tfu.des_nr_id in (").append(param.toString()).append(") and ");
            }
            sql.append(" (tfu.usu_nr_id is null or ");
            if (listUsuarios != null && listUsuarios.size() > 0) {
                sql.append(" tfu.usu_nr_id in (").append(paramUsu).append(") or ");
            }
            sql.append(" -1=1) and ");

            sql.append(" flx_dt_finalizado is null and FLX_DT_MOVIMENTACAO between ? and ? order by FLX_DT_MOVIMENTACAO desc ");
            pStmt = con.prepareStatement(sql.toString());
            Date dtI = new Date(dtInicio.getTime());
            pStmt.setObject(1, dtI);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dtFinal);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date dtF = new Date(cal.getTimeInMillis());
            pStmt.setObject(2, dtF);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByAreasDestinoExcetoTramites(List<Des_destinoT> listDes, List<Integer> listUsuarios, String idTramitesExcecao) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listDes.size(); i++) {
                Des_destinoT desT = listDes.get(i);
                param.append(desT.getDes_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer paramUsu = new StringBuffer();
            for (int i = 0; i < listUsuarios.size(); i++) {
                int codigo = listUsuarios.get(i);
                paramUsu.append(codigo).append(", ");
            }
            paramUsu.append("-1");

            StringBuffer sql = new StringBuffer("select * from vw_tra_flx_usu tfu where ");
            if (listDes != null && listDes.size() > 0) {
                sql.append(" tfu.des_nr_id in (").append(param.toString()).append(") and ");
            }
            sql.append(" (tfu.usu_nr_id is null or ");
            if (listUsuarios != null && listUsuarios.size() > 0) {
                sql.append(" tfu.usu_nr_id in (").append(paramUsu).append(") or ");
            }
            sql.append(" -1=1) and ");

            sql.append(" flx_dt_finalizado is null  and tra_nr_id not in (").append(idTramitesExcecao).append(") order by FLX_DT_MOVIMENTACAO desc ");
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
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByAreasDestinoExcetoTramitesPeriodo(List<Des_destinoT> listDes, List<Integer> listUsuarios, String idTramitesExcecao, java.util.Date dtInicio, java.util.Date dtFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer param = new StringBuffer();
            for (int i = 0; i < listDes.size(); i++) {
                Des_destinoT desT = listDes.get(i);
                param.append(desT.getDes_nr_id()).append(", ");
            }
            param.append("-1");
            StringBuffer paramUsu = new StringBuffer();
            for (int i = 0; i < listUsuarios.size(); i++) {
                int codigo = listUsuarios.get(i);
                paramUsu.append(codigo).append(", ");
            }
            paramUsu.append("-1");

            StringBuffer sql = new StringBuffer("select * from vw_tra_flx_usu tfu where ");
            if (listDes != null && listDes.size() > 0) {
                sql.append(" tfu.des_nr_id in (").append(param.toString()).append(") and ");
            }
            sql.append(" (tfu.usu_nr_id is null or ");
            if (listUsuarios != null && listUsuarios.size() > 0) {
                sql.append(" tfu.usu_nr_id in (").append(paramUsu).append(") or ");
            }
            sql.append(" -1=1) and ");

            sql.append(" flx_dt_finalizado is null and FLX_DT_MOVIMENTACAO between ? and ?  and tra_nr_id not in (").append(idTramitesExcecao).append(") order by FLX_DT_MOVIMENTACAO desc ");
            pStmt = con.prepareStatement(sql.toString());
            Date dtI = new Date(dtInicio.getTime());
            pStmt.setObject(1, dtI);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dtFinal);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date dtF = new Date(cal.getTimeInMillis());
            pStmt.setObject(2, dtF);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getListByIdsDocumento(List<Did_documento_identificacaoT> listIds) {
        StringBuffer sql = new StringBuffer();
        sql.append("select distinct * from vw_tra_flx_usu where flx_nr_id in (");
        for (int i = 0; i < listIds.size(); i++) {
            Did_documento_identificacaoT didT = listIds.get(i);
            sql.append(" (select flx_nr_id from did_documento_identificacao where did_tx_nomecoluna=? and did_tx_valor=?) ");
            if (i < (listIds.size() - 1)) {
                sql.append(" INTERSECT ");
            }
        }
        sql.append(") order by flx_dt_movimentacao desc");
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            pStmt = con.prepareStatement(sql.toString());
            int cont = 1;
            for (int i = 0; i < listIds.size(); i++) {
                Did_documento_identificacaoT didT = listIds.get(i);
                pStmt.setObject(cont++, didT.getDid_tx_nomecoluna());
                pStmt.setObject(cont++, didT.getDid_tx_valor());
            }
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                rs = null;
            } catch (Exception e) {
            }
            try {
                pStmt.close();
                pStmt = null;
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * Tramitado pelo usuário
     * @param vw_tra_flx_usuT parametro contendo o código do usuário
     * @return
     * @throws Exception
     */
    public List<Vw_tra_flx_usuT> getByTramitadoPeloUsuario(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
//            String sql = "select * from vw_tra_flx_usu tfu where tfu.usu_nr_id=? and tfu.flx_dt_finalizado is not null and rownum <=500 order by tfu.flx_dt_finalizado desc";
            String sql = "select * from (select * from vw_tra_flx_usu tfu where tfu.usu_nr_id=? and tfu.flx_dt_finalizado is not null  order by tfu.flx_dt_finalizado desc ) where rownum <= 500";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getUsu_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    /**
     * Tramitado pelos usuários
     * @param userIds id dos usuários
     * @return
     * @throws Exception
     */
    public List<Vw_tra_flx_usuT> getByTramitadoPeloUsuarios(String userIds) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from vw_tra_flx_usu tfu where tfu.usu_nr_id in USERS_IDS and tfu.flx_dt_finalizado is not null order by tfu.flx_dt_finalizado desc";
            sql = sql.replaceAll("USERS_IDS", userIds);
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByDes_nr_id(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  DES_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getDes_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByTid_nr_id(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  TID_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getTid_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByUsu_nr_idowner(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  USU_NR_IDOWNER = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getUsu_nr_idowner());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByTra_tx_nome(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  Upper(TRA_TX_NOME) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_tra_flx_usuT.getTra_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByTra_tx_automatico(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  Upper(TRA_TX_AUTOMATICO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_tra_flx_usuT.getTra_tx_automatico() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByFlx_nr_id(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  FLX_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getFlx_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByFlx_dt_movimentacao(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  FLX_DT_MOVIMENTACAO = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(vw_tra_flx_usuT.getFlx_dt_movimentacao().getTime());
            pStmt.setObject(1, dt1);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByFlx_tx_obs(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  Upper(FLX_TX_OBS) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_tra_flx_usuT.getFlx_tx_obs() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByFlx_dt_finalizado(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  FLX_DT_FINALIZADO = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(vw_tra_flx_usuT.getFlx_dt_finalizado().getTime());
            pStmt.setObject(1, dt1);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByFlx_nr_idanterior(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  FLX_NR_IDANTERIOR = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getFlx_nr_idanterior());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByTra_nr_idorigem(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  TRA_NR_IDORIGEM = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getTra_nr_idorigem());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByTra_nr_iddestino(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  TRA_NR_IDDESTINO = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getTra_nr_iddestino());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByUsu_nr_id(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  USU_NR_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_tra_flx_usuT.getUsu_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByUsu_tx_nome(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  Upper(USU_TX_NOME) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_tra_flx_usuT.getUsu_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByUsu_tx_login(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  Upper(USU_TX_LOGIN) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_tra_flx_usuT.getUsu_tx_login() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;

            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByUsu_tx_status(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  Upper(USU_TX_STATUS) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_tra_flx_usuT.getUsu_tx_status() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
                rs = null;
                pStmt = null;
            } catch (Exception e) {
            }

        }
    }

    public List<Vw_tra_flx_usuT> getByUsu_tx_email(Vw_tra_flx_usuT vw_tra_flx_usuT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from USR_FLUXO.VW_TRA_FLX_USU where  Upper(USU_TX_EMAIL) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_tra_flx_usuT.getUsu_tx_email() + '%');
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
