package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Are_areaInsertJB extends SystemBase {
  private Are_areaBL are_areaBL = new Are_areaBL();
  // Atributos e propriedades
  private Are_areaT are_areaT = new Are_areaT();

  public void setAre_areaT(Are_areaT are_areaT) {
    this.are_areaT = are_areaT;
  }

  public Are_areaT getAre_areaT() {	
    return are_areaT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      are_areaBL.insert(are_areaT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
