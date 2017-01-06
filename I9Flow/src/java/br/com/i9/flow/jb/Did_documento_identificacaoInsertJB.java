package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Did_documento_identificacaoInsertJB extends SystemBase {
  private Did_documento_identificacaoBL did_documento_identificacaoBL = new Did_documento_identificacaoBL();
  // Atributos e propriedades
  private Did_documento_identificacaoT did_documento_identificacaoT = new Did_documento_identificacaoT();

  public void setDid_documento_identificacaoT(Did_documento_identificacaoT did_documento_identificacaoT) {
    this.did_documento_identificacaoT = did_documento_identificacaoT;
  }

  public Did_documento_identificacaoT getDid_documento_identificacaoT() {	
    return did_documento_identificacaoT;
  }

	
  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    try {
      did_documento_identificacaoBL.insert(did_documento_identificacaoT);
      setMsg(INFO,"Cadastro efetuado com sucesso!");
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );	
    } finally {
      close();
    }
  } 
}
