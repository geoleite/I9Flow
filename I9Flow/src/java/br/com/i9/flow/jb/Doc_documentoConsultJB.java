package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Doc_documentoConsultJB extends SystemBase {

  private Doc_documentoBL doc_documentoBL = new Doc_documentoBL();
  // Atributos e propriedades
  private Doc_documentoT doc_documentoT = new Doc_documentoT();

  public void setDoc_documentoT(Doc_documentoT doc_documentoT) {
    this.doc_documentoT = doc_documentoT;
  }

  public Doc_documentoT getDoc_documentoT() {	
    return doc_documentoT;
  }

	
  private List<Doc_documentoT> list;

  public List<Doc_documentoT> getList() {
    return list;
  }
  
  public void setList(List<Doc_documentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void consult() throws Exception {
    try {      
      list = doc_documentoBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }  

  public void delete() throws Exception {
    try {
      if (doc_documentoBL.delete(doc_documentoT)) {
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
