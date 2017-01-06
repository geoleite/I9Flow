package br.com.i9.flow.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Opt_opcao_tramiteBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("insert"));
      }
      Opt_opcao_tramiteDAO opt_opcao_tramiteDAO =  getOpt_opcao_tramiteDAO();
      opt_opcao_tramiteDAO.insert(opt_opcao_tramiteT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Problema ao inserir ".concat("Opt_opcao_tramite"));
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Opt_opcao_tramiteT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }
      Opt_opcao_tramiteDAO opt_opcao_tramiteDAO = getOpt_opcao_tramiteDAO();
      return opt_opcao_tramiteDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }

  public List<Opt_opcao_tramiteT> consultByFlowId(Opt_opcao_tramiteT optT) throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("consult"));
      }     
      return getOpt_opcao_tramiteDAO().getByTra_nr_idorigem(optT);
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
  public boolean delete(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("delete"));
      }
      if (exist(opt_opcao_tramiteT)) {
        Opt_opcao_tramiteDAO opt_opcao_tramiteDAO = getOpt_opcao_tramiteDAO();
        opt_opcao_tramiteDAO.delete(opt_opcao_tramiteT);	 
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
  public boolean exist(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
   try {
      Opt_opcao_tramiteDAO opt_opcao_tramiteDAO = getOpt_opcao_tramiteDAO();
      List<Opt_opcao_tramiteT> listTemp  = opt_opcao_tramiteDAO.getByPK(opt_opcao_tramiteT);	 

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
  public boolean update(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Tentativa de execucao indevida da operacao".concat("update"));
      }
      if (exist(opt_opcao_tramiteT)) {
        Opt_opcao_tramiteDAO opt_opcao_tramiteDAO = getOpt_opcao_tramiteDAO();
        opt_opcao_tramiteDAO.update(opt_opcao_tramiteT);	 
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
  public Opt_opcao_tramiteT findbyid(Opt_opcao_tramiteT opt_opcao_tramiteT) throws Exception {
    try {
      Opt_opcao_tramiteDAO opt_opcao_tramiteDAO = getOpt_opcao_tramiteDAO();
      List<Opt_opcao_tramiteT> listTemp  = opt_opcao_tramiteDAO.getByPK( opt_opcao_tramiteT);	 
      return listTemp.size()>0?listTemp.get(0):new Opt_opcao_tramiteT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
