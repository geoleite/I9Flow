package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Opt_opcao_tramiteConsultJB extends SystemBase {

  private Opt_opcao_tramiteBL opt_opcao_tramiteBL = new Opt_opcao_tramiteBL();
  // Atributos e propriedades
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

  public void consult() throws Exception {
    try {      
      list = opt_opcao_tramiteBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }

  public void consultByFlowId() throws Exception {
    try {
      list = opt_opcao_tramiteBL.consultByFlowId(opt_opcao_tramiteT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");
    }
  }


  public void delete() throws Exception {
    try {
      if (opt_opcao_tramiteBL.delete(opt_opcao_tramiteT)) {
        setMsg("Exclusao efetuada com sucesso!");
      } else {
        setMsg("Falha: Nao foi possivel excluir este registro.");
      }
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  
}
