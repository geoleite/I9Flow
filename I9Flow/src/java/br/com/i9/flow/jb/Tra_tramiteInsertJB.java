package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tra_tramiteInsertJB extends SystemBase {
  private Tra_tramiteBL tra_tramiteBL = new Tra_tramiteBL();
  // Atributos e propriedades
  private Tra_tramiteT tra_tramiteT = new Tra_tramiteT();

  public void setTra_tramiteT(Tra_tramiteT tra_tramiteT) {
    this.tra_tramiteT = tra_tramiteT;
  }

  public Tra_tramiteT getTra_tramiteT() {	
    return tra_tramiteT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      tra_tramiteBL.insert(tra_tramiteT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
