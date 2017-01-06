package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tel_telaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tel_telaT tel_telaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Tel_telaDAO tel_telaDAO =  getTel_telaDAO();
      tel_telaDAO.insert(tel_telaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Tel_tela"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Tel_telaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Tel_telaDAO tel_telaDAO = getTel_telaDAO();
      return tel_telaDAO.getAll();	 
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
  public boolean delete(Tel_telaT tel_telaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(tel_telaT)) {
        Tel_telaDAO tel_telaDAO = getTel_telaDAO();
        tel_telaDAO.delete(tel_telaT);	 
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
  public boolean exist(Tel_telaT tel_telaT) throws Exception {
   try {
      Tel_telaDAO tel_telaDAO = getTel_telaDAO();
      List<Tel_telaT> listTemp  = tel_telaDAO.getByPK(tel_telaT);	 

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
  public boolean update(Tel_telaT tel_telaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(tel_telaT)) {
        Tel_telaDAO tel_telaDAO = getTel_telaDAO();
        tel_telaDAO.update(tel_telaT);	 
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
  public Tel_telaT findbyid(Tel_telaT tel_telaT) throws Exception {
    try {
      Tel_telaDAO tel_telaDAO = getTel_telaDAO();
      List<Tel_telaT> listTemp  = tel_telaDAO.getByPK( tel_telaT);	 
      return listTemp.size()>0?listTemp.get(0):new Tel_telaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
