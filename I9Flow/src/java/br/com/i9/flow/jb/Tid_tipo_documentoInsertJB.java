package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipo_documentoInsertJB extends SystemBase {
  private Tid_tipo_documentoBL tid_tipo_documentoBL = new Tid_tipo_documentoBL();
  // Atributos e propriedades
  private Tid_tipo_documentoT tid_tipo_documentoT = new Tid_tipo_documentoT();

  public void setTid_tipo_documentoT(Tid_tipo_documentoT tid_tipo_documentoT) {
    this.tid_tipo_documentoT = tid_tipo_documentoT;
  }

  public Tid_tipo_documentoT getTid_tipo_documentoT() {	
    return tid_tipo_documentoT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      tid_tipo_documentoBL.insert(tid_tipo_documentoT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
