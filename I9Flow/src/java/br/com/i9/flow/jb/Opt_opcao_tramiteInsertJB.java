package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Opt_opcao_tramiteInsertJB extends SystemBase {
  private Opt_opcao_tramiteBL opt_opcao_tramiteBL = new Opt_opcao_tramiteBL();
  // Atributos e propriedades
  private Opt_opcao_tramiteT opt_opcao_tramiteT = new Opt_opcao_tramiteT();

  public void setOpt_opcao_tramiteT(Opt_opcao_tramiteT opt_opcao_tramiteT) {
    this.opt_opcao_tramiteT = opt_opcao_tramiteT;
  }

  public Opt_opcao_tramiteT getOpt_opcao_tramiteT() {	
    return opt_opcao_tramiteT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      opt_opcao_tramiteBL.insert(opt_opcao_tramiteT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
