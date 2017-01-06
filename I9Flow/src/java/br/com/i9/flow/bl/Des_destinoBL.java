package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Des_destinoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Des_destinoT des_destinoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Des_destinoDAO des_destinoDAO =  getDes_destinoDAO();
      des_destinoDAO.insert(des_destinoT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Des_destino"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Des_destinoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Des_destinoDAO des_destinoDAO = getDes_destinoDAO();
      return des_destinoDAO.getAll();	 
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
  public boolean delete(Des_destinoT des_destinoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(des_destinoT)) {
        Des_destinoDAO des_destinoDAO = getDes_destinoDAO();
        des_destinoDAO.delete(des_destinoT);	 
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
  public boolean exist(Des_destinoT des_destinoT) throws Exception {
   try {
      Des_destinoDAO des_destinoDAO = getDes_destinoDAO();
      List<Des_destinoT> listTemp  = des_destinoDAO.getByPK(des_destinoT);	 

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
  public boolean update(Des_destinoT des_destinoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(des_destinoT)) {
        Des_destinoDAO des_destinoDAO = getDes_destinoDAO();
        des_destinoDAO.update(des_destinoT);	 
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
  public Des_destinoT findbyid(Des_destinoT des_destinoT) throws Exception {
    try {
      Des_destinoDAO des_destinoDAO = getDes_destinoDAO();
      List<Des_destinoT> listTemp  = des_destinoDAO.getByPK( des_destinoT);	 
      return listTemp.size()>0?listTemp.get(0):new Des_destinoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
