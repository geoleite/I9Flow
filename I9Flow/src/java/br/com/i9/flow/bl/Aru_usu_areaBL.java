package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Aru_usu_areaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Aru_usu_areaT aru_usu_areaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Aru_usu_areaDAO aru_usu_areaDAO =  getAru_usu_areaDAO();
      aru_usu_areaDAO.insert(aru_usu_areaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Aru_usu_area"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Aru_usu_areaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Aru_usu_areaDAO aru_usu_areaDAO = getAru_usu_areaDAO();
      return aru_usu_areaDAO.getAll();	 
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
  public boolean delete(Aru_usu_areaT aru_usu_areaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(aru_usu_areaT)) {
        Aru_usu_areaDAO aru_usu_areaDAO = getAru_usu_areaDAO();
        aru_usu_areaDAO.delete(aru_usu_areaT);	 
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
  public boolean exist(Aru_usu_areaT aru_usu_areaT) throws Exception {
   try {
      Aru_usu_areaDAO aru_usu_areaDAO = getAru_usu_areaDAO();
      List<Aru_usu_areaT> listTemp  = aru_usu_areaDAO.getByPK(aru_usu_areaT);	 

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
  public boolean update(Aru_usu_areaT aru_usu_areaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(aru_usu_areaT)) {
        Aru_usu_areaDAO aru_usu_areaDAO = getAru_usu_areaDAO();
        aru_usu_areaDAO.update(aru_usu_areaT);	 
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
  public Aru_usu_areaT findbyid(Aru_usu_areaT aru_usu_areaT) throws Exception {
    try {
      Aru_usu_areaDAO aru_usu_areaDAO = getAru_usu_areaDAO();
      List<Aru_usu_areaT> listTemp  = aru_usu_areaDAO.getByPK( aru_usu_areaT);	 
      return listTemp.size()>0?listTemp.get(0):new Aru_usu_areaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
