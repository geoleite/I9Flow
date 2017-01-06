package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Are_areaConsultJB extends SystemBase {

  private Are_areaBL are_areaBL = new Are_areaBL();
  // Atributos e propriedades
  private Are_areaT are_areaT = new Are_areaT();

  public void setAre_areaT(Are_areaT are_areaT) {
    this.are_areaT = are_areaT;
  }

  public Are_areaT getAre_areaT() {	
    return are_areaT;
  }

	
  private List<Are_areaT> list;

  public List<Are_areaT> getList() {
    return list;
  }
  
  public void setList(List<Are_areaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void consult() throws Exception {
    try {      
      list = are_areaBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }  

  public void delete() throws Exception {
    try {
      if (are_areaBL.delete(are_areaT)) {
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
