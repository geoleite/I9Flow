package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Opt_opcao_tramiteUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Opt_opcao_tramiteBL opt_opcao_tramiteBL = new Opt_opcao_tramiteBL();
  private Opt_opcao_tramiteT opt_opcao_tramiteT = new Opt_opcao_tramiteT();

  public void setOpt_opcao_tramiteT(Opt_opcao_tramiteT opt_opcao_tramiteT) {
    this.opt_opcao_tramiteT = opt_opcao_tramiteT;
  }

  public Opt_opcao_tramiteT getOpt_opcao_tramiteT() {	
    return opt_opcao_tramiteT;
  }

	
  private List<Opt_opcao_tramiteT> list;

  public List<Opt_opcao_tramiteT> getList() {
    return list;
  }
  
  public void setList(List<Opt_opcao_tramiteT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void clear() throws Exception {
    
      opt_opcao_tramiteT = new Opt_opcao_tramiteT();	
  } 

  public void delete() throws Exception {
    try {
      if (opt_opcao_tramiteBL.exist(opt_opcao_tramiteT)) {
        if (opt_opcao_tramiteBL.delete(opt_opcao_tramiteT)) {
          setMsg("Exclusao efetuada com sucesso!");
          clear();
        } else {
          setMsg("Falha: Nao foi possivel excluir este registro.");
        }
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );
    } finally {
	close();
    }
  } 

  public void update() throws Exception {
    try {
      if (opt_opcao_tramiteBL.exist(opt_opcao_tramiteT)) {
        opt_opcao_tramiteBL.update(opt_opcao_tramiteT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      opt_opcao_tramiteT= opt_opcao_tramiteBL.findbyid(opt_opcao_tramiteT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
