package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tel_traUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Tel_traBL tel_traBL = new Tel_traBL();
  private Tel_traT tel_traT = new Tel_traT();

  public void setTel_traT(Tel_traT tel_traT) {
    this.tel_traT = tel_traT;
  }

  public Tel_traT getTel_traT() {	
    return tel_traT;
  }

	
  private List<Tel_traT> list;

  public List<Tel_traT> getList() {
    return list;
  }
  
  public void setList(List<Tel_traT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void clear() throws Exception {
    
      tel_traT = new Tel_traT();	
  } 

  public void delete() throws Exception {
    try {
      if (tel_traBL.exist(tel_traT)) {
        if (tel_traBL.delete(tel_traT)) {
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
      if (tel_traBL.exist(tel_traT)) {
        tel_traBL.update(tel_traT);	 
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
      tel_traT= tel_traBL.findbyid(tel_traT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
