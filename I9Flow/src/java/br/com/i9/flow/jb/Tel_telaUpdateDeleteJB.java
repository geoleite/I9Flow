package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tel_telaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Tel_telaBL tel_telaBL = new Tel_telaBL();
  private Tel_telaT tel_telaT = new Tel_telaT();

  public void setTel_telaT(Tel_telaT tel_telaT) {
    this.tel_telaT = tel_telaT;
  }

  public Tel_telaT getTel_telaT() {	
    return tel_telaT;
  }

	
  private List<Tel_telaT> list;

  public List<Tel_telaT> getList() {
    return list;
  }
  
  public void setList(List<Tel_telaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void clear() throws Exception {
    
      tel_telaT = new Tel_telaT();	
  } 

  public void delete() throws Exception {
    try {
      if (tel_telaBL.exist(tel_telaT)) {
        if (tel_telaBL.delete(tel_telaT)) {
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
      if (tel_telaBL.exist(tel_telaT)) {
        tel_telaBL.update(tel_telaT);	 
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
      tel_telaT= tel_telaBL.findbyid(tel_telaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
