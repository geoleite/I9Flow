package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cac_carac_compInsertJB extends SystemBase {
  private Cac_carac_compBL cac_carac_compBL = new Cac_carac_compBL();
  // Atributos e propriedades
  private Cac_carac_compT cac_carac_compT = new Cac_carac_compT();

  public void setCac_carac_compT(Cac_carac_compT cac_carac_compT) {
    this.cac_carac_compT = cac_carac_compT;
  }

  public Cac_carac_compT getCac_carac_compT() {	
    return cac_carac_compT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      cac_carac_compBL.insert(cac_carac_compT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
