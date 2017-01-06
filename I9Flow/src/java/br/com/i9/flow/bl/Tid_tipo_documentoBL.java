package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipo_documentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Tid_tipo_documentoDAO tid_tipo_documentoDAO =  getTid_tipo_documentoDAO();
      tid_tipo_documentoDAO.insert(tid_tipo_documentoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Tid_tipo_documento"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Tid_tipo_documentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Tid_tipo_documentoDAO tid_tipo_documentoDAO = getTid_tipo_documentoDAO();
      return tid_tipo_documentoDAO.getAll();	 
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
  public boolean delete(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(tid_tipo_documentoT)) {
        Tid_tipo_documentoDAO tid_tipo_documentoDAO = getTid_tipo_documentoDAO();
        tid_tipo_documentoDAO.delete(tid_tipo_documentoT);	 
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
  public boolean exist(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception {
   try {
      Tid_tipo_documentoDAO tid_tipo_documentoDAO = getTid_tipo_documentoDAO();
      List<Tid_tipo_documentoT> listTemp  = tid_tipo_documentoDAO.getByPK(tid_tipo_documentoT);	 

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
  public boolean update(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(tid_tipo_documentoT)) {
        Tid_tipo_documentoDAO tid_tipo_documentoDAO = getTid_tipo_documentoDAO();
        tid_tipo_documentoDAO.update(tid_tipo_documentoT);	 
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
  public Tid_tipo_documentoT findbyid(Tid_tipo_documentoT tid_tipo_documentoT) throws Exception {
    try {
      Tid_tipo_documentoDAO tid_tipo_documentoDAO = getTid_tipo_documentoDAO();
      List<Tid_tipo_documentoT> listTemp  = tid_tipo_documentoDAO.getByPK( tid_tipo_documentoT);	 
      return listTemp.size()>0?listTemp.get(0):new Tid_tipo_documentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
