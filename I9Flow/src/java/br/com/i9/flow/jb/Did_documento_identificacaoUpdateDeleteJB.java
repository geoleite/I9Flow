package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Did_documento_identificacaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
  private Did_documento_identificacaoBL did_documento_identificacaoBL = new Did_documento_identificacaoBL();
  private Did_documento_identificacaoT did_documento_identificacaoT = new Did_documento_identificacaoT();

  public void setDid_documento_identificacaoT(Did_documento_identificacaoT did_documento_identificacaoT) {
    this.did_documento_identificacaoT = did_documento_identificacaoT;
  }

  public Did_documento_identificacaoT getDid_documento_identificacaoT() {	
    return did_documento_identificacaoT;
  }

	
  private List<Did_documento_identificacaoT> list;

  public List<Did_documento_identificacaoT> getList() {
    return list;
  }
  
  public void setList(List<Did_documento_identificacaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void clear() throws Exception {
    
      did_documento_identificacaoT = new Did_documento_identificacaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (did_documento_identificacaoBL.exist(did_documento_identificacaoT)) {
        if (did_documento_identificacaoBL.delete(did_documento_identificacaoT)) {
          setMsg("Exclusao efetuada com sucesso!");
          clear();
        } else {
          setMsg("Falha: Nao foi possivel excluir este registro.");
        }
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      setMsg(ERROR,"Falha: ".concat(e.getMessage()) );
    } finally {
	close();
    }
  } 

  public void update() throws Exception {
    try {
      if (did_documento_identificacaoBL.exist(did_documento_identificacaoT)) {
        did_documento_identificacaoBL.update(did_documento_identificacaoT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      did_documento_identificacaoT= did_documento_identificacaoBL.findbyid(did_documento_identificacaoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  
}
