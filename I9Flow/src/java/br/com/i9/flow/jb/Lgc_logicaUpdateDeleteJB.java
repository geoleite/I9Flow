package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Lgc_logicaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Lgc_logicaBL lgc_logicaBL = new Lgc_logicaBL();
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

  public void clear() throws Exception {
    
      lgc_logicaT = new Lgc_logicaT();	
  } 

  public void delete() throws Exception {
    try {
      if (lgc_logicaBL.exist(lgc_logicaT)) {
        if (lgc_logicaBL.delete(lgc_logicaT)) {
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
      if (lgc_logicaBL.exist(lgc_logicaT)) {
        lgc_logicaBL.update(lgc_logicaT);	 
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
      lgc_logicaT= lgc_logicaBL.findbyid(lgc_logicaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
