package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Lgc_logicaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Lgc_logicaT lgc_logicaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Lgc_logicaDAO lgc_logicaDAO =  getLgc_logicaDAO();
      lgc_logicaDAO.insert(lgc_logicaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Lgc_logica"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Lgc_logicaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Lgc_logicaDAO lgc_logicaDAO = getLgc_logicaDAO();
      return lgc_logicaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  public List<Lgc_logicaT> consultByTramite(Lgc_logicaT lgc_logicaT) throws Exception {
      try {
      if (!valide("consultByTramite")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consultByTramite"));
      }      
      return getLgc_logicaDAO().getByTra_nr_id(lgc_logicaT);
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
  public boolean delete(Lgc_logicaT lgc_logicaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(lgc_logicaT)) {
        Lgc_logicaDAO lgc_logicaDAO = getLgc_logicaDAO();
        lgc_logicaDAO.delete(lgc_logicaT);	 
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
  public boolean exist(Lgc_logicaT lgc_logicaT) throws Exception {
   try {
      Lgc_logicaDAO lgc_logicaDAO = getLgc_logicaDAO();
      List<Lgc_logicaT> listTemp  = lgc_logicaDAO.getByPK(lgc_logicaT);	 

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
  public boolean update(Lgc_logicaT lgc_logicaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(lgc_logicaT)) {
        Lgc_logicaDAO lgc_logicaDAO = getLgc_logicaDAO();
        lgc_logicaDAO.update(lgc_logicaT);	 
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
  public Lgc_logicaT findbyid(Lgc_logicaT lgc_logicaT) throws Exception {
    try {
      Lgc_logicaDAO lgc_logicaDAO = getLgc_logicaDAO();
      List<Lgc_logicaT> listTemp  = lgc_logicaDAO.getByPK( lgc_logicaT);	 
      return listTemp.size()>0?listTemp.get(0):new Lgc_logicaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
