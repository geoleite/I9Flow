package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Doc_documentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Doc_documentoT doc_documentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Doc_documentoDAO doc_documentoDAO =  getDoc_documentoDAO();
      doc_documentoDAO.insert(doc_documentoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Doc_documento"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Doc_documentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Doc_documentoDAO doc_documentoDAO = getDoc_documentoDAO();
      return doc_documentoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  /**
   * Deletar um registro
   */	
  public boolean delete(Doc_documentoT doc_documentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(doc_documentoT)) {
        Doc_documentoDAO doc_documentoDAO = getDoc_documentoDAO();
        doc_documentoDAO.delete(doc_documentoT);	 
        return true;
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Verifica se o objeto existe na base
   */
  public boolean exist(Doc_documentoT doc_documentoT) throws Exception {
   try {
      Doc_documentoDAO doc_documentoDAO = getDoc_documentoDAO();
      List<Doc_documentoT> listTemp  = doc_documentoDAO.getByPK(doc_documentoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alterac?o na tabela
   */	
  public boolean update(Doc_documentoT doc_documentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(doc_documentoT)) {
        Doc_documentoDAO doc_documentoDAO = getDoc_documentoDAO();
        doc_documentoDAO.update(doc_documentoT);	 
	return true;        
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }   

  /**
   * Obt?m os dados de um registro
   */	
  public Doc_documentoT findbyid(Doc_documentoT doc_documentoT) throws Exception {
    try {
      Doc_documentoDAO doc_documentoDAO = getDoc_documentoDAO();
      List<Doc_documentoT> listTemp  = doc_documentoDAO.getByPK( doc_documentoT);	 
      return listTemp.size()>0?listTemp.get(0):new Doc_documentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
