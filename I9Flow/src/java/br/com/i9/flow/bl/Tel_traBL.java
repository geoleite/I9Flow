package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tel_traBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tel_traT tel_traT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Tel_traDAO tel_traDAO =  getTel_traDAO();
      tel_traDAO.insert(tel_traT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Tel_tra"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Tel_traT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Tel_traDAO tel_traDAO = getTel_traDAO();
      return tel_traDAO.getAll();	 
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
  public boolean delete(Tel_traT tel_traT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(tel_traT)) {
        Tel_traDAO tel_traDAO = getTel_traDAO();
        tel_traDAO.delete(tel_traT);	 
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
  public boolean exist(Tel_traT tel_traT) throws Exception {
   try {
      Tel_traDAO tel_traDAO = getTel_traDAO();
      List<Tel_traT> listTemp  = tel_traDAO.getByPK(tel_traT);	 

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
  public boolean update(Tel_traT tel_traT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(tel_traT)) {
        Tel_traDAO tel_traDAO = getTel_traDAO();
        tel_traDAO.update(tel_traT);	 
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
  public Tel_traT findbyid(Tel_traT tel_traT) throws Exception {
    try {
      Tel_traDAO tel_traDAO = getTel_traDAO();
      List<Tel_traT> listTemp  = tel_traDAO.getByPK( tel_traT);	 
      return listTemp.size()>0?listTemp.get(0):new Tel_traT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
