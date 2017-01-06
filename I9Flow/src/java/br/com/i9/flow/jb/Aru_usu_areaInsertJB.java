package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Aru_usu_areaInsertJB extends SystemBase {
  private Aru_usu_areaBL aru_usu_areaBL = new Aru_usu_areaBL();
  // Atributos e propriedades
  private Aru_usu_areaT aru_usu_areaT = new Aru_usu_areaT();

  public void setAru_usu_areaT(Aru_usu_areaT aru_usu_areaT) {
    this.aru_usu_areaT = aru_usu_areaT;
  }

  public Aru_usu_areaT getAru_usu_areaT() {	
    return aru_usu_areaT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      aru_usu_areaBL.insert(aru_usu_areaT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
