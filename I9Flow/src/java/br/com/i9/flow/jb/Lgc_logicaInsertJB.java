package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Lgc_logicaInsertJB extends SystemBase {
  private Lgc_logicaBL lgc_logicaBL = new Lgc_logicaBL();
  // Atributos e propriedades
  private Lgc_logicaT lgc_logicaT = new Lgc_logicaT();

  public void setLgc_logicaT(Lgc_logicaT lgc_logicaT) {
    this.lgc_logicaT = lgc_logicaT;
  }

  public Lgc_logicaT getLgc_logicaT() {	
    return lgc_logicaT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      lgc_logicaBL.insert(lgc_logicaT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
