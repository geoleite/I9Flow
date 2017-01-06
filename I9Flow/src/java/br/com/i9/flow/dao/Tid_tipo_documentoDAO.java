package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Tid_tipo_documentoDAO extends ObjectDAO { 
	 public Tid_tipo_documentoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Tid_tipo_documentoT tid_tipo_documentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into USR_FLUXO.TID_TIPO_DOCUMENTO  ( TID_NR_ID, TID_TX_NOME, TRA_NR_ID) values ( ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_documentoT.getTid_nr_id());
			 pStmt.setObject(2, tid_tipo_documentoT.getTid_tx_nome());
			 pStmt.setObject(3, tid_tipo_documentoT.getTra_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Tid_tipo_documentoT tid_tipo_documentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update USR_FLUXO.TID_TIPO_DOCUMENTO set  TID_TX_NOME=?, TRA_NR_ID=?  where  TID_NR_ID=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_documentoT.getTid_tx_nome());
			 pStmt.setObject(2, tid_tipo_documentoT.getTra_nr_id());
			 pStmt.setObject(3, tid_tipo_documentoT.getTid_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Tid_tipo_documentoT tid_tipo_documentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from USR_FLUXO.TID_TIPO_DOCUMENTO where  TID_NR_ID=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_documentoT.getTid_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Tid_tipo_documentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Tid_tipo_documentoT> objs = new Vector();
		 while (rs.next()) { 
 			 Tid_tipo_documentoT tid_tipo_documentoT = new Tid_tipo_documentoT();
			 tid_tipo_documentoT.setTid_nr_id(rs.getInt("TID_NR_ID"));
			 tid_tipo_documentoT.setTid_tx_nome(rs.getString("TID_TX_NOME"));
			 tid_tipo_documentoT.setTra_nr_id(rs.getInt("TRA_NR_ID"));
			 objs.add(tid_tipo_documentoT);
 		 }
 		 return objs; 
 	 }
	 public List<Tid_tipo_documentoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TID_TIPO_DOCUMENTO"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Tid_tipo_documentoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tid_tipo_documentoT> getByPK(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TID_TIPO_DOCUMENTO where  TID_NR_ID=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_documentoT.getTid_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tid_tipo_documentoT> getByTid_nr_id(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TID_TIPO_DOCUMENTO where  TID_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_documentoT.getTid_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tid_tipo_documentoT> getByTid_tx_nome(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TID_TIPO_DOCUMENTO where  Upper(TID_TX_NOME) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + tid_tipo_documentoT.getTid_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tid_tipo_documentoT> getByTra_nr_id(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TID_TIPO_DOCUMENTO where  TRA_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tid_tipo_documentoT.getTra_nr_id());
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