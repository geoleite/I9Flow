package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Des_destinoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Des_destinoBL des_destinoBL = new Des_destinoBL();
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

  public void clear() throws Exception {
    
      des_destinoT = new Des_destinoT();	
  } 

  public void delete() throws Exception {
    try {
      if (des_destinoBL.exist(des_destinoT)) {
        if (des_destinoBL.delete(des_destinoT)) {
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
      if (des_destinoBL.exist(des_destinoT)) {
        des_destinoBL.update(des_destinoT);	 
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
      des_destinoT= des_destinoBL.findbyid(des_destinoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
