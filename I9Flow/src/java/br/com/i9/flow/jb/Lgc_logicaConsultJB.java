package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Lgc_logicaConsultJB extends SystemBase {

  private Lgc_logicaBL lgc_logicaBL = new Lgc_logicaBL();
  // Atributos e propriedades
  private Lgc_logicaT lgc_logicaT = new Lgc_logicaT();

  public void setLgc_logicaT(Lgc_logicaT lgc_logicaT) {
    this.lgc_logicaT = lgc_logicaT;
  }

  public Lgc_logicaT getLgc_logicaT() {	
    return lgc_logicaT;
  }

	
  private List<Lgc_logicaT> list;

  public List<Lgc_logicaT> getList() {
    return list;
  }
  
  public void setList(List<Lgc_logicaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

    public void consultByTramite() throws Exception {
        try {
            list = lgc_logicaBL.consultByTramite(lgc_logicaT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

  public void consult() throws Exception {
    try {      
      list = lgc_logicaBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }  

  public void delete() throws Exception {
    try {
      if (lgc_logicaBL.delete(lgc_logicaT)) {
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
