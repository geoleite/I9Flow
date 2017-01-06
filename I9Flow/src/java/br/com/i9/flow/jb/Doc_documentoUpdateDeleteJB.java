package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Doc_documentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Doc_documentoBL doc_documentoBL = new Doc_documentoBL();
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

  public void clear() throws Exception {
    
      doc_documentoT = new Doc_documentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (doc_documentoBL.exist(doc_documentoT)) {
        if (doc_documentoBL.delete(doc_documentoT)) {
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
      if (doc_documentoBL.exist(doc_documentoT)) {
        doc_documentoBL.update(doc_documentoT);	 
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
      doc_documentoT= doc_documentoBL.findbyid(doc_documentoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
