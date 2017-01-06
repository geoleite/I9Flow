package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cac_carac_compUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Cac_carac_compBL cac_carac_compBL = new Cac_carac_compBL();
  private Cac_carac_compT cac_carac_compT = new Cac_carac_compT();

  public void setCac_carac_compT(Cac_carac_compT cac_carac_compT) {
    this.cac_carac_compT = cac_carac_compT;
  }

  public Cac_carac_compT getCac_carac_compT() {	
    return cac_carac_compT;
  }

	
  private List<Cac_carac_compT> list;

  public List<Cac_carac_compT> getList() {
    return list;
  }
  
  public void setList(List<Cac_carac_compT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void clear() throws Exception {
    
      cac_carac_compT = new Cac_carac_compT();	
  } 

  public void delete() throws Exception {
    try {
      if (cac_carac_compBL.exist(cac_carac_compT)) {
        if (cac_carac_compBL.delete(cac_carac_compT)) {
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
      if (cac_carac_compBL.exist(cac_carac_compT)) {
        cac_carac_compBL.update(cac_carac_compT);	 
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
      cac_carac_compT= cac_carac_compBL.findbyid(cac_carac_compT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
