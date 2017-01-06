package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Did_documento_identificacaoConsultJB extends SystemBase {

    private String idsFluxo;
    private Did_documento_identificacaoBL did_documento_identificacaoBL = new Did_documento_identificacaoBL();
    // Atributos e propriedades
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

    public void consult() throws Exception {
        try {
            list = did_documento_identificacaoBL.consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        }
    }

    public void consultByFluxos() {
        try {
            list = did_documento_identificacaoBL.consultByFluxos(idsFluxo);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByFluxo() {
        try {
            list = did_documento_identificacaoBL.consultByFluxo(did_documento_identificacaoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            if (did_documento_identificacaoBL.delete(did_documento_identificacaoT)) {
                setMsg("Exclusao efetuada com sucesso!");
            } else {
                setMsg("Falha: Nao foi possivel excluir este registro.");
            }
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    /**
     * @return the idsFluxo
     */
    public String getIdsFluxo() {
        return idsFluxo;
    }

    /**
     * @param idsFluxo the idsFluxo to set
     */
    public void setIdsFluxo(String idsFluxo) {
        this.idsFluxo = idsFluxo;
    }
}
