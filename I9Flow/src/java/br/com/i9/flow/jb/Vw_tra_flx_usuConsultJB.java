package br.com.i9.flow.jb;

import br.com.easynet.easylog.jb.INotLog;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.flow.bl.*;
import br.com.i9.flow.dao.*;
import br.com.i9.flow.transfer.*;
import java.util.ArrayList;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Vw_tra_flx_usuConsultJB extends SystemBase {

    private String paramDid;
    private Vw_tra_flx_usuBL vw_tra_flx_usuBL = new Vw_tra_flx_usuBL();
    // Atributos e propriedades
    private Vw_tra_flx_usuT vw_tra_flx_usuT = new Vw_tra_flx_usuT();

    public void setVw_tra_flx_usuT(Vw_tra_flx_usuT vw_tra_flx_usuT) {
        this.vw_tra_flx_usuT = vw_tra_flx_usuT;
    }

        public Vw_tra_flx_usuT getVw_tra_flx_usuT() {
        return vw_tra_flx_usuT;
    }
    private List<Vw_tra_flx_usuT> list;

    public List<Vw_tra_flx_usuT> getList() {
        return list;
    }

    public void setList(List<Vw_tra_flx_usuT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        vw_tra_flx_usuBL.setTypeDatabase(TYPE_DATABASE);
    }

    public void consult() throws Exception {
        try {
            list = vw_tra_flx_usuBL.consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        }
    }

    public void consultByStatusTramites() {
        try {

            List<Integer> listInts = (List<Integer>)getSession().getAttribute(LIST_USER_PROCURATOR);
            if (listInts != null) {
                list = vw_tra_flx_usuBL.consultByStatusTramites(listInts);
            } else {
                list = vw_tra_flx_usuBL.consultByStatusTramites(getUsuarioLogado());
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByTramitadoPeloUsuario() {
        try {
            if (getUsuarioLogado() != null) {
                vw_tra_flx_usuT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());
                list = vw_tra_flx_usuBL.consultByTramitadoPeloUsuario(vw_tra_flx_usuT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByIdDocumento() {
        try {
            if (paramDid != null && !paramDid.trim().isEmpty()) {
                String[] params = getParamDid().split(";");
                List<Did_documento_identificacaoT> listDid = new ArrayList<Did_documento_identificacaoT>();
                for (int i = 0; i < params.length; i++) {
                    String[] p = params[i].split("=");
                    Did_documento_identificacaoT didT = new Did_documento_identificacaoT();
                    didT.setDid_tx_nomecoluna(p[0]);
                    didT.setDid_tx_valor(p[1]);
                    listDid.add(didT);
                }
                list = vw_tra_flx_usuBL.consultByIdDocumento(listDid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void consultByStatusTramite() throws Exception {
        try {
            list = vw_tra_flx_usuBL.consultByStatusTramite(vw_tra_flx_usuT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            if (vw_tra_flx_usuBL.delete(vw_tra_flx_usuT)) {
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
}