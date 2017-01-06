package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_tra_flx_usuUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Vw_tra_flx_usuBL vw_tra_flx_usuBL = new Vw_tra_flx_usuBL();
  private Vw_tra_flx_usuT vw_tra_flx_usuT = new Vw_tra_flx_usuT();

  public void setVw_tra_flx_usuT(Vw_tra_flx_usuT vw_tra_flx_usuT) {
    this.vw_tra_flx_usuT = vw_tra_flx_usuT;
  }

  public Vw_tra_flx_usuT getVw_tra_flx_usuT() {	
    return vw_tra_flx_usuT;
  }

	
  private List<Vw_tra_flx_usuT> list;

  public List<Vw_tra_flx_usuT> getList() {
    return list;
  }
  
  public void setList(List<Vw_tra_flx_usuT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void clear() throws Exception {
    
      vw_tra_flx_usuT = new Vw_tra_flx_usuT();	
  } 

  public void delete() throws Exception {
    try {
      if (vw_tra_flx_usuBL.exist(vw_tra_flx_usuT)) {
        if (vw_tra_flx_usuBL.delete(vw_tra_flx_usuT)) {
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
      if (vw_tra_flx_usuBL.exist(vw_tra_flx_usuT)) {
        vw_tra_flx_usuBL.update(vw_tra_flx_usuT);	 
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
      vw_tra_flx_usuT= vw_tra_flx_usuBL.findbyid(vw_tra_flx_usuT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
