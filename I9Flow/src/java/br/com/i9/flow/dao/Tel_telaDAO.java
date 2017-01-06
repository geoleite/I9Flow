package br.com.i9.flow.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.flow.transfer.*;

public class Tel_telaDAO extends ObjectDAO { 
	 public Tel_telaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Tel_telaT tel_telaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into USR_FLUXO.TEL_TELA  ( TEL_NR_ID, TEL_TX_NOME) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_telaT.getTel_nr_id());
			 pStmt.setObject(2, tel_telaT.getTel_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Tel_telaT tel_telaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update USR_FLUXO.TEL_TELA set  TEL_TX_NOME=?  where  TEL_NR_ID=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_telaT.getTel_tx_nome());
			 pStmt.setObject(2, tel_telaT.getTel_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Tel_telaT tel_telaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from USR_FLUXO.TEL_TELA where  TEL_NR_ID=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_telaT.getTel_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Tel_telaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Tel_telaT> objs = new Vector();
		 while (rs.next()) { 
 			 Tel_telaT tel_telaT = new Tel_telaT();
			 tel_telaT.setTel_nr_id(rs.getInt("TEL_NR_ID"));
			 tel_telaT.setTel_tx_nome(rs.getString("TEL_TX_NOME"));
			 objs.add(tel_telaT);
 		 }
 		 return objs; 
 	 }
	 public List<Tel_telaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TEL_TELA"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Tel_telaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tel_telaT> getByPK(Tel_telaT tel_telaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TEL_TELA where  TEL_NR_ID=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_telaT.getTel_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tel_telaT> getByTel_nr_id(Tel_telaT tel_telaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TEL_TELA where  TEL_NR_ID = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tel_telaT.getTel_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tel_telaT> getByTel_tx_nome(Tel_telaT tel_telaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from USR_FLUXO.TEL_TELA where  Upper(TEL_TX_NOME) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + tel_telaT.getTel_tx_nome()+'%' );
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