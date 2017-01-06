package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tra_tramiteConsultJB extends SystemBase {

  private Tra_tramiteBL tra_tramiteBL = new Tra_tramiteBL();
  // Atributos e propriedades
  private Tra_tramiteT tra_tramiteT = new Tra_tramiteT();

  public void setTra_tramiteT(Tra_tramiteT tra_tramiteT) {
    this.tra_tramiteT = tra_tramiteT;
  }

  public Tra_tramiteT getTra_tramiteT() {	
    return tra_tramiteT;
  }

	
  private List<Tra_tramiteT> list;

  public List<Tra_tramiteT> getList() {
    return list;
  }
  
  public void setList(List<Tra_tramiteT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
    super.pageLoad();
  }

  public void consult() throws Exception {
    try {      
      list = tra_tramiteBL.consult();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    }
  }

    public void consultTramiteManualByTipoDocumento() {
        try {
            list = tra_tramiteBL.consultTramiteManualByTipoDocumento(tra_tramiteT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByTipoDocumento() {
        try {
            list = tra_tramiteBL.consultTramiteManualByTipoDocumento(tra_tramiteT);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


  public void delete() throws Exception {
    try {
      if (tra_tramiteBL.delete(tra_tramiteT)) {
        setMsg("Exclusao efetuada com sucesso!");
      } else {
        setMsg("Falha: Nao foi possivel excluir este registro.");
      }
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  
}
