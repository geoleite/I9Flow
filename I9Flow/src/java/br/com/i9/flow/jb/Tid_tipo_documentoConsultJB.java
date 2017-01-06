package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipo_documentoConsultJB extends SystemBase {

  private Tid_tipo_documentoBL tid_tipo_documentoBL = new Tid_tipo_documentoBL();
  // Atributos e propriedades
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

  public void consult() throws Exception {
    try {      
      list = tid_tipo_documentoBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }  

  public void delete() throws Exception {
    try {
      if (tid_tipo_documentoBL.delete(tid_tipo_documentoT)) {
        setMsg("Exclusao efetuada com sucesso!");
      } else {
        setMsg("Falha: Nao foi possivel excluir este registro.");
      }
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  
}
