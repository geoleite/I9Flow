package br.com.i9.flow.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import java.util.ArrayList;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Tra_tramiteUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private String paramDid;
    private String docTypeName;
    private Tra_tramiteBL tra_tramiteBL = new Tra_tramiteBL();
    private Tra_tramiteT tra_tramiteT = new Tra_tramiteT();
    private boolean firstTramite = false;

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

    public void clear() throws Exception {

        tra_tramiteT = new Tra_tramiteT();
    }

    public void delete() throws Exception {
        try {
            if (tra_tramiteBL.exist(tra_tramiteT)) {
                if (tra_tramiteBL.delete(tra_tramiteT)) {
                    setMsg("Exclusao efetuada com sucesso!");
                    clear();
                } else {
                    setMsg("Falha: Nao foi possivel excluir este registro.");
                }
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            setMsg(ERROR, "Falha: ".concat(e.getMessage()));
        } finally {
            close();
        }
    }

    public void update() throws Exception {
        try {
            if (tra_tramiteBL.exist(tra_tramiteT)) {
                tra_tramiteBL.update(tra_tramiteT);
                setMsg("Alteracao efetuada com sucesso!");
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
        } finally {
            close();
        }
    }

    //Method Download Image e montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            tra_tramiteT = tra_tramiteBL.findbyid(tra_tramiteT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void findByDocTypeNameActual() throws Exception {
        try {
            List<Did_documento_identificacaoT> listIdDoc = null;
            if (paramDid != null) {
                String[] params = paramDid.split(";");
                listIdDoc = new ArrayList<Did_documento_identificacaoT>();
                for (int i = 0; i < params.length; i++) {
                    String[] p = params[i].split("=");
                    Did_documento_identificacaoT didT = new Did_documento_identificacaoT();
                    didT.setDid_tx_nomecoluna(p[0]);
                    didT.setDid_tx_valor(p[1]);
                    listIdDoc.add(didT);
                }
            } else if (getSession().getAttribute(IDS_DOC) != null && !firstTramite) {
                listIdDoc = (List<Did_documento_identificacaoT>) getSession().getAttribute(IDS_DOC);
            }
            tra_tramiteT = tra_tramiteBL.findByDocTypeNameActual(getUsuarioLogado(), docTypeName, listIdDoc);
            Flx_fluxoT flxT = tra_tramiteBL.getFlx_fluxoT();
            if (flxT != null) {
                getSession().setAttribute(FLX_SESSION, flxT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * @return the paramDid
     */
    public String getParamDid() {
        return paramDid;
    }

    /**
     * @param paramDid the paramDid to set
     */
    public void setParamDid(String paramDid) {
        this.paramDid = paramDid;
    }

    /**
     * @return the docTypeName
     */
    public String getDocTypeName() {
        return docTypeName;
    }

    /**
     * @param docTypeName the docTypeName to set
     */
    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    /**
     * @return the firstTramite
     */
    public boolean isFirstTramite() {
        return firstTramite;
    }

    /**
     * @param firstTramite the firstTramite to set
     */
    public void setFirstTramite(boolean firstTramite) {
        this.firstTramite = firstTramite;
    }
}
