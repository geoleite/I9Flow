package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tel_telaInsertJB extends SystemBase {
  private Tel_telaBL tel_telaBL = new Tel_telaBL();
  // Atributos e propriedades
  private Tel_telaT tel_telaT = new Tel_telaT();

  public void setTel_telaT(Tel_telaT tel_telaT) {
    this.tel_telaT = tel_telaT;
  }

  public Tel_telaT getTel_telaT() {	
    return tel_telaT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      tel_telaBL.insert(tel_telaT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
