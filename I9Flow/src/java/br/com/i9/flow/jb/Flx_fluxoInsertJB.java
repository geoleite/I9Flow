package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Flx_fluxoInsertJB extends SystemBase {

    private Flx_fluxoBL flx_fluxoBL = new Flx_fluxoBL();
    // Atributos e propriedades
    private Flx_fluxoT flx_fluxoT = new Flx_fluxoT();

    public void setFlx_fluxoT(Flx_fluxoT flx_fluxoT) {
        this.flx_fluxoT = flx_fluxoT;
    }

    public Flx_fluxoT getFlx_fluxoT() {
        return flx_fluxoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // Metodos de Eventos
    public void insert() throws Exception {
        try {
            List<Did_documento_identificacaoT> listDid = (List<Did_documento_identificacaoT>) getSession().getAttribute(IDS_DOC);
            flx_fluxoBL.insert(getUsuarioLogado(), flx_fluxoT, listDid);
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            //Testar
            getSession().removeAttribute(Flx_fluxoInsertJB.IDS_DOC);
        } catch (Exception e) {
            setMsg(ERROR, "Falha: ".concat(e.getMessage()));
        } finally {
            close();
        }
    }
}