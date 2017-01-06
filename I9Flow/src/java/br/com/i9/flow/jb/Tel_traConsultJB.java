package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tel_traConsultJB extends SystemBase {

  private Tel_traBL tel_traBL = new Tel_traBL();
  // Atributos e propriedades
  private Tel_traT tel_traT = new Tel_traT();

  public void setTel_traT(Tel_traT tel_traT) {
    this.tel_traT = tel_traT;
  }

  public Tel_traT getTel_traT() {	
    return tel_traT;
  }

	
  private List<Tel_traT> list;

  public List<Tel_traT> getList() {
    return list;
  }
  
  public void setList(List<Tel_traT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void consult() throws Exception {
    try {      
      list = tel_traBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }  

  public void delete() throws Exception {
    try {
      if (tel_traBL.delete(tel_traT)) {
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
