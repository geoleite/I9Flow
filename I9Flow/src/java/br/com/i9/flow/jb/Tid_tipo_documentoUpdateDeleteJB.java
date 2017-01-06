package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipo_documentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Tid_tipo_documentoBL tid_tipo_documentoBL = new Tid_tipo_documentoBL();
  private Tid_tipo_documentoT tid_tipo_documentoT = new Tid_tipo_documentoT();

  public void setTid_tipo_documentoT(Tid_tipo_documentoT tid_tipo_documentoT) {
    this.tid_tipo_documentoT = tid_tipo_documentoT;
  }

  public Tid_tipo_documentoT getTid_tipo_documentoT() {	
    return tid_tipo_documentoT;
  }

	
  private List<Tid_tipo_documentoT> list;

  public List<Tid_tipo_documentoT> getList() {
    return list;
  }
  
  public void setList(List<Tid_tipo_documentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void clear() throws Exception {
    
      tid_tipo_documentoT = new Tid_tipo_documentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (tid_tipo_documentoBL.exist(tid_tipo_documentoT)) {
        if (tid_tipo_documentoBL.delete(tid_tipo_documentoT)) {
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
      if (tid_tipo_documentoBL.exist(tid_tipo_documentoT)) {
        tid_tipo_documentoBL.update(tid_tipo_documentoT);	 
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
      tid_tipo_documentoT= tid_tipo_documentoBL.findbyid(tid_tipo_documentoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
