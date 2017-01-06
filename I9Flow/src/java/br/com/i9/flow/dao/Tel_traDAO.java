package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Tel_traDAO extends ObjectDAO { 
	 public Tel_traDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Tel_traT tel_traT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into USR_FLUXO.TEL_TRA  ( TRA_NR_ID, TEL_NR_ID) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_traT.getTra_nr_id());
			 pStmt.setObject(2, tel_traT.getTel_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Tel_traT tel_traT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update USR_FLUXO.TEL_TRA set - where  TRA_NR_ID=? and TEL_NR_ID=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_traT.getTra_nr_id());
			 pStmt.setObject(2, tel_traT.getTel_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Tel_traT tel_traT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from USR_FLUXO.TEL_TRA where  TRA_NR_ID=? and TEL_NR_ID=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_traT.getTra_nr_id());
			 pStmt.setObject(2, tel_traT.getTel_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Tel_traT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Tel_traT> objs = new Vector();
		 while (rs.next()) { 
 			 Tel_traT tel_traT = new Tel_traT();
			 tel_traT.setTra_nr_id(rs.getInt("TRA_NR_ID"));
			 tel_traT.setTel_nr_id(rs.getInt("TEL_NR_ID"));
			 objs.add(tel_traT);
 		 }
 		 return objs; 
 	 }
	 public List<Tel_traT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TEL_TRA"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Tel_traT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tel_traT> getByPK(Tel_traT tel_traT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TEL_TRA where  TRA_NR_ID=? and TEL_NR_ID=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_traT.getTra_nr_id());
			 pStmt.setObject(2, tel_traT.getTel_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tel_traT> getByTra_nr_id(Tel_traT tel_traT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TEL_TRA where  TRA_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_traT.getTra_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tel_traT> getByTel_nr_id(Tel_traT tel_traT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TEL_TRA where  TEL_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_traT.getTel_nr_id());
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