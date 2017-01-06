package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Are_areaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Are_areaT are_areaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Are_areaDAO are_areaDAO =  getAre_areaDAO();
      are_areaDAO.insert(are_areaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Are_area"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Are_areaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Are_areaDAO are_areaDAO = getAre_areaDAO();
      return are_areaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  public List<Are_areaT> getByUsuario(int usuNrId) throws Exception {
      try {
          return getAre_areaDAO().getByUsuario(usuNrId);
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
  public boolean delete(Are_areaT are_areaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(are_areaT)) {
        Are_areaDAO are_areaDAO = getAre_areaDAO();
        are_areaDAO.delete(are_areaT);	 
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
  public boolean exist(Are_areaT are_areaT) throws Exception {
   try {
      Are_areaDAO are_areaDAO = getAre_areaDAO();
      List<Are_areaT> listTemp  = are_areaDAO.getByPK(are_areaT);	 

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
  public boolean update(Are_areaT are_areaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(are_areaT)) {
        Are_areaDAO are_areaDAO = getAre_areaDAO();
        are_areaDAO.update(are_areaT);	 
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
  public Are_areaT findbyid(Are_areaT are_areaT) throws Exception {
    try {
      Are_areaDAO are_areaDAO = getAre_areaDAO();
      List<Are_areaT> listTemp  = are_areaDAO.getByPK( are_areaT);	 
      return listTemp.size()>0?listTemp.get(0):new Are_areaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
