package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Des_destinoConsultJB extends SystemBase {

  private Des_destinoBL des_destinoBL = new Des_destinoBL();
  // Atributos e propriedades
  private Des_destinoT des_destinoT = new Des_destinoT();

  public void setDes_destinoT(Des_destinoT des_destinoT) {
    this.des_destinoT = des_destinoT;
  }

  public Des_destinoT getDes_destinoT() {	
    return des_destinoT;
  }

	
  private List<Des_destinoT> list;

  public List<Des_destinoT> getList() {
    return list;
  }
  
  public void setList(List<Des_destinoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void consult() throws Exception {
    try {      
      list = des_destinoBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }  

  public void delete() throws Exception {
    try {
      if (des_destinoBL.delete(des_destinoT)) {
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
