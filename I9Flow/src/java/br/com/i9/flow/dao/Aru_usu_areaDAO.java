package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Aru_usu_areaDAO extends ObjectDAO { 
	 public Aru_usu_areaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Aru_usu_areaT aru_usu_areaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into USR_FLUXO.ARU_USU_AREA  ( USU_NR_ID, ARE_NR_ID) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, aru_usu_areaT.getUsu_nr_id());
			 pStmt.setObject(2, aru_usu_areaT.getAre_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Aru_usu_areaT aru_usu_areaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update USR_FLUXO.ARU_USU_AREA set - where  USU_NR_ID=? and ARE_NR_ID=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, aru_usu_areaT.getUsu_nr_id());
			 pStmt.setObject(2, aru_usu_areaT.getAre_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Aru_usu_areaT aru_usu_areaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from USR_FLUXO.ARU_USU_AREA where  USU_NR_ID=? and ARE_NR_ID=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, aru_usu_areaT.getUsu_nr_id());
			 pStmt.setObject(2, aru_usu_areaT.getAre_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Aru_usu_areaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Aru_usu_areaT> objs = new Vector();
		 while (rs.next()) { 
 			 Aru_usu_areaT aru_usu_areaT = new Aru_usu_areaT();
			 aru_usu_areaT.setUsu_nr_id(rs.getInt("USU_NR_ID"));
			 aru_usu_areaT.setAre_nr_id(rs.getInt("ARE_NR_ID"));
			 objs.add(aru_usu_areaT);
 		 }
 		 return objs; 
 	 }
	 public List<Aru_usu_areaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.ARU_USU_AREA"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Aru_usu_areaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Aru_usu_areaT> getByPK(Aru_usu_areaT aru_usu_areaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.ARU_USU_AREA where  USU_NR_ID=? and ARE_NR_ID=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, aru_usu_areaT.getUsu_nr_id());
			 pStmt.setObject(2, aru_usu_areaT.getAre_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Aru_usu_areaT> getByUsu_nr_id(Aru_usu_areaT aru_usu_areaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.ARU_USU_AREA where  USU_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, aru_usu_areaT.getUsu_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Aru_usu_areaT> getByAre_nr_id(Aru_usu_areaT aru_usu_areaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.ARU_USU_AREA where  ARE_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, aru_usu_areaT.getAre_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 

 }