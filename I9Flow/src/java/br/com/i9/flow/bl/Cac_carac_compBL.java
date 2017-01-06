package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cac_carac_compBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cac_carac_compT cac_carac_compT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Cac_carac_compDAO cac_carac_compDAO =  getCac_carac_compDAO();
      cac_carac_compDAO.insert(cac_carac_compT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Cac_carac_comp"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Cac_carac_compT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Cac_carac_compDAO cac_carac_compDAO = getCac_carac_compDAO();
      return cac_carac_compDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  public List<Cac_carac_compT> consultByClassNameAndFlowId(String className, Cac_carac_compT cacT) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      return getCac_carac_compDAO().getByClassNameAndFlowId(className, cacT);
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
  public boolean delete(Cac_carac_compT cac_carac_compT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(cac_carac_compT)) {
        Cac_carac_compDAO cac_carac_compDAO = getCac_carac_compDAO();
        cac_carac_compDAO.delete(cac_carac_compT);	 
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
  public boolean exist(Cac_carac_compT cac_carac_compT) throws Exception {
   try {
      Cac_carac_compDAO cac_carac_compDAO = getCac_carac_compDAO();
      List<Cac_carac_compT> listTemp  = cac_carac_compDAO.getByPK(cac_carac_compT);	 

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
  public boolean update(Cac_carac_compT cac_carac_compT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(cac_carac_compT)) {
        Cac_carac_compDAO cac_carac_compDAO = getCac_carac_compDAO();
        cac_carac_compDAO.update(cac_carac_compT);	 
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
  public Cac_carac_compT findbyid(Cac_carac_compT cac_carac_compT) throws Exception {
    try {
      Cac_carac_compDAO cac_carac_compDAO = getCac_carac_compDAO();
      List<Cac_carac_compT> listTemp  = cac_carac_compDAO.getByPK( cac_carac_compT);	 
      return listTemp.size()>0?listTemp.get(0):new Cac_carac_compT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
