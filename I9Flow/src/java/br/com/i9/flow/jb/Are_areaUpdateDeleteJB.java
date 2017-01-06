package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Are_areaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Are_areaBL are_areaBL = new Are_areaBL();
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

  public void clear() throws Exception {
    
      are_areaT = new Are_areaT();	
  } 

  public void delete() throws Exception {
    try {
      if (are_areaBL.exist(are_areaT)) {
        if (are_areaBL.delete(are_areaT)) {
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
      if (are_areaBL.exist(are_areaT)) {
        are_areaBL.update(are_areaT);	 
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
      are_areaT= are_areaBL.findbyid(are_areaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
