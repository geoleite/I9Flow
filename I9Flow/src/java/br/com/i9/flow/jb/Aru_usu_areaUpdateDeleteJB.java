package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Aru_usu_areaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Aru_usu_areaBL aru_usu_areaBL = new Aru_usu_areaBL();
  private Aru_usu_areaT aru_usu_areaT = new Aru_usu_areaT();

  public void setAru_usu_areaT(Aru_usu_areaT aru_usu_areaT) {
    this.aru_usu_areaT = aru_usu_areaT;
  }

  public Aru_usu_areaT getAru_usu_areaT() {	
    return aru_usu_areaT;
  }

	
  private List<Aru_usu_areaT> list;

  public List<Aru_usu_areaT> getList() {
    return list;
  }
  
  public void setList(List<Aru_usu_areaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void clear() throws Exception {
    
      aru_usu_areaT = new Aru_usu_areaT();	
  } 

  public void delete() throws Exception {
    try {
      if (aru_usu_areaBL.exist(aru_usu_areaT)) {
        if (aru_usu_areaBL.delete(aru_usu_areaT)) {
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
      if (aru_usu_areaBL.exist(aru_usu_areaT)) {
        aru_usu_areaBL.update(aru_usu_areaT);	 
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
      aru_usu_areaT= aru_usu_areaBL.findbyid(aru_usu_areaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
