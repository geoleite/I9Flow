package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Flx_fluxoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Flx_fluxoBL flx_fluxoBL = new Flx_fluxoBL();
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

  public void clear() throws Exception {
    
      flx_fluxoT = new Flx_fluxoT();	
  } 

  public void delete() throws Exception {
    try {
      if (flx_fluxoBL.exist(flx_fluxoT)) {
        if (flx_fluxoBL.delete(flx_fluxoT)) {
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
      if (flx_fluxoBL.exist(flx_fluxoT)) {
        flx_fluxoBL.update(flx_fluxoT);	 
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
      flx_fluxoT= flx_fluxoBL.findbyid(flx_fluxoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
