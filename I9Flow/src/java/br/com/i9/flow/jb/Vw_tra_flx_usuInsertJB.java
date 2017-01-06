package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_tra_flx_usuInsertJB extends SystemBase {
  private Vw_tra_flx_usuBL vw_tra_flx_usuBL = new Vw_tra_flx_usuBL();
  // Atributos e propriedades
  private Vw_tra_flx_usuT vw_tra_flx_usuT = new Vw_tra_flx_usuT();

  public void setVw_tra_flx_usuT(Vw_tra_flx_usuT vw_tra_flx_usuT) {
    this.vw_tra_flx_usuT = vw_tra_flx_usuT;
  }

  public Vw_tra_flx_usuT getVw_tra_flx_usuT() {	
    return vw_tra_flx_usuT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      vw_tra_flx_usuBL.insert(vw_tra_flx_usuT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
