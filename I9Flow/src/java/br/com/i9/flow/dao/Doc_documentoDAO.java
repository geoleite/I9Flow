package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Doc_documentoDAO extends ObjectDAO { 
	 public Doc_documentoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Doc_documentoT doc_documentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into USR_FLUXO.DOC_DOCUMENTO  ( DOC_NR_ID, FLX_NR_ID) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, doc_documentoT.getDoc_nr_id());
			 pStmt.setObject(2, doc_documentoT.getFlx_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Doc_documentoT doc_documentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update USR_FLUXO.DOC_DOCUMENTO set  FLX_NR_ID=?  where  DOC_NR_ID=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, doc_documentoT.getFlx_nr_id());
			 pStmt.setObject(2, doc_documentoT.getDoc_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Doc_documentoT doc_documentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from USR_FLUXO.DOC_DOCUMENTO where  DOC_NR_ID=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, doc_documentoT.getDoc_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Doc_documentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Doc_documentoT> objs = new Vector();
		 while (rs.next()) { 
 			 Doc_documentoT doc_documentoT = new Doc_documentoT();
			 doc_documentoT.setDoc_nr_id(rs.getInt("DOC_NR_ID"));
			 doc_documentoT.setFlx_nr_id(rs.getInt("FLX_NR_ID"));
			 objs.add(doc_documentoT);
 		 }
 		 return objs; 
 	 }
	 public List<Doc_documentoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.DOC_DOCUMENTO"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Doc_documentoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Doc_documentoT> getByPK(Doc_documentoT doc_documentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.DOC_DOCUMENTO where  DOC_NR_ID=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, doc_documentoT.getDoc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Doc_documentoT> getByDoc_nr_id(Doc_documentoT doc_documentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.DOC_DOCUMENTO where  DOC_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, doc_documentoT.getDoc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Doc_documentoT> getByFlx_nr_id(Doc_documentoT doc_documentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.DOC_DOCUMENTO where  FLX_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, doc_documentoT.getFlx_nr_id());
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