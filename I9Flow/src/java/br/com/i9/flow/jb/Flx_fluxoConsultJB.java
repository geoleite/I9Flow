package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Flx_fluxoConsultJB extends SystemBase {

  private Flx_fluxoBL flx_fluxoBL = new Flx_fluxoBL();
  // Atributos e propriedades
  private Flx_fluxoT flx_fluxoT = new Flx_fluxoT();

  public void setFlx_fluxoT(Flx_fluxoT flx_fluxoT) {
    this.flx_fluxoT = flx_fluxoT;
  }

  public Flx_fluxoT getFlx_fluxoT() {	
    return flx_fluxoT;
  }

	
  private List<Flx_fluxoT> list;

  public List<Flx_fluxoT> getList() {
    return list;
  }
  
  public void setList(List<Flx_fluxoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void consult() throws Exception {
    try {      
      list = flx_fluxoBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }  

  public void delete() throws Exception {
    try {
      if (flx_fluxoBL.delete(flx_fluxoT)) {
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
