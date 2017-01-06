package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tel_telaConsultJB extends SystemBase {

  private Tel_telaBL tel_telaBL = new Tel_telaBL();
  // Atributos e propriedades
  private Tel_telaT tel_telaT = new Tel_telaT();

  public void setTel_telaT(Tel_telaT tel_telaT) {
    this.tel_telaT = tel_telaT;
  }

  public Tel_telaT getTel_telaT() {	
    return tel_telaT;
  }

	
  private List<Tel_telaT> list;

  public List<Tel_telaT> getList() {
    return list;
  }
  
  public void setList(List<Tel_telaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void consult() throws Exception {
    try {      
      list = tel_telaBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }  

  public void delete() throws Exception {
    try {
      if (tel_telaBL.delete(tel_telaT)) {
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
