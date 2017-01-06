package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Des_destinoInsertJB extends SystemBase {
  private Des_destinoBL des_destinoBL = new Des_destinoBL();
  // Atributos e propriedades
  private Des_destinoT des_destinoT = new Des_destinoT();

  public void setDes_destinoT(Des_destinoT des_destinoT) {
    this.des_destinoT = des_destinoT;
  }

  public Des_destinoT getDes_destinoT() {	
    return des_destinoT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      des_destinoBL.insert(des_destinoT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
