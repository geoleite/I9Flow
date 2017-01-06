package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Doc_documentoInsertJB extends SystemBase {
  private Doc_documentoBL doc_documentoBL = new Doc_documentoBL();
  // Atributos e propriedades
  private Doc_documentoT doc_documentoT = new Doc_documentoT();

  public void setDoc_documentoT(Doc_documentoT doc_documentoT) {
    this.doc_documentoT = doc_documentoT;
  }

  public Doc_documentoT getDoc_documentoT() {	
    return doc_documentoT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      doc_documentoBL.insert(doc_documentoT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
