package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Did_documento_identificacaoTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Vw_tra_flx_usuTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Vw_tra_flx_usuDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/vw_tra_flx_usu/vw_tra_flx_usuInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/vw_tra_flx_usu/vw_tra_flx_usuConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/vw_tra_flx_usu/vw_tra_flx_usuUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Vw_tra_flx_usuTGWT vw_tra_flx_usuT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultByTramitadoPeloUsuario() {
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByTramitadoPeloUsuario");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(url, param);
    }

    public void consultByIdDocumento(List<Did_documento_identificacaoTGWT> listDid) {
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByIdDocumento");
        String paramDid = "";
        if (listDid != null) {
            for (int i = 0; i < listDid.size(); i++) {
                Did_documento_identificacaoTGWT didT = listDid.get(i);
                paramDid += didT.getDid_tx_nomecoluna() + "=" + didT.getDid_tx_valor() + ";";
            }
        }
        param.put("paramDid", paramDid);
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(url, param);
    }

    public void consultByStatusTramite(Vw_tra_flx_usuTGWT vwTFUT) {
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByStatusTramite");
        param.put("vw_tra_flx_usuT.tra_nr_id", vwTFUT.getTra_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(url, param);
    }

    public void consultByStatusTramites() {
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByStatusTramites");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(url, param);
    }

    public void inserir(Vw_tra_flx_usuTGWT vw_tra_flx_usuT) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").isString().stringValue();
                    msg = result;
                }
            }
        };
        String url = Constantes.URL + PAGE_INSERIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "insert");
        param.put("vw_tra_flx_usuT.tra_nr_id", vw_tra_flx_usuT.getTra_nr_id() + "");
        param.put("vw_tra_flx_usuT.des_nr_id", vw_tra_flx_usuT.getDes_nr_id() + "");
        param.put("vw_tra_flx_usuT.tid_nr_id", vw_tra_flx_usuT.getTid_nr_id() + "");
        param.put("vw_tra_flx_usuT.usu_nr_idowner", vw_tra_flx_usuT.getUsu_nr_idowner() + "");
        param.put("vw_tra_flx_usuT.tra_tx_nome", vw_tra_flx_usuT.getTra_tx_nome() + "");
        param.put("vw_tra_flx_usuT.tra_tx_automatico", vw_tra_flx_usuT.getTra_tx_automatico() + "");
        param.put("vw_tra_flx_usuT.flx_nr_id", vw_tra_flx_usuT.getFlx_nr_id() + "");
        param.put("vw_tra_flx_usuT.flx_dt_movimentacao", dtfDate.format(vw_tra_flx_usuT.getFlx_dt_movimentacao()));
        param.put("vw_tra_flx_usuT.flx_tx_obs", vw_tra_flx_usuT.getFlx_tx_obs() + "");
        param.put("vw_tra_flx_usuT.flx_dt_finalizado", dtfDate.format(vw_tra_flx_usuT.getFlx_dt_finalizado()));
        param.put("vw_tra_flx_usuT.flx_nr_idanterior", vw_tra_flx_usuT.getFlx_nr_idanterior() + "");
        param.put("vw_tra_flx_usuT.tra_nr_idorigem", vw_tra_flx_usuT.getTra_nr_idorigem() + "");
        param.put("vw_tra_flx_usuT.tra_nr_iddestino", vw_tra_flx_usuT.getTra_nr_iddestino() + "");
        param.put("vw_tra_flx_usuT.usu_nr_id", vw_tra_flx_usuT.getUsu_nr_id() + "");
        param.put("vw_tra_flx_usuT.usu_tx_nome", vw_tra_flx_usuT.getUsu_tx_nome() + "");
        param.put("vw_tra_flx_usuT.usu_tx_login", vw_tra_flx_usuT.getUsu_tx_login() + "");
        param.put("vw_tra_flx_usuT.usu_tx_status", vw_tra_flx_usuT.getUsu_tx_status() + "");
        param.put("vw_tra_flx_usuT.usu_tx_email", vw_tra_flx_usuT.getUsu_tx_email() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Vw_tra_flx_usuTGWT vw_tra_flx_usuT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("vw_tra_flx_usu").isObject();
                    Vw_tra_flx_usuDAOGWT.this.vw_tra_flx_usuT = lerRegistroJson(registro);
                }
            }
        };
        this.vw_tra_flx_usuT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Vw_tra_flx_usuTGWT vw_tra_flx_usuT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Vw_tra_flx_usuTGWT vw_tra_flx_usuT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };
        msg = null;
        list = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("vw_tra_flx_usuT.tra_nr_id", vw_tra_flx_usuT.getTra_nr_id() + "");
        param.put("vw_tra_flx_usuT.des_nr_id", vw_tra_flx_usuT.getDes_nr_id() + "");
        param.put("vw_tra_flx_usuT.tid_nr_id", vw_tra_flx_usuT.getTid_nr_id() + "");
        param.put("vw_tra_flx_usuT.usu_nr_idowner", vw_tra_flx_usuT.getUsu_nr_idowner() + "");
        param.put("vw_tra_flx_usuT.tra_tx_nome", vw_tra_flx_usuT.getTra_tx_nome() + "");
        param.put("vw_tra_flx_usuT.tra_tx_automatico", vw_tra_flx_usuT.getTra_tx_automatico() + "");
        param.put("vw_tra_flx_usuT.flx_nr_id", vw_tra_flx_usuT.getFlx_nr_id() + "");
        param.put("vw_tra_flx_usuT.flx_dt_movimentacao", dtfDate.format(vw_tra_flx_usuT.getFlx_dt_movimentacao()));
        param.put("vw_tra_flx_usuT.flx_tx_obs", vw_tra_flx_usuT.getFlx_tx_obs() + "");
        param.put("vw_tra_flx_usuT.flx_dt_finalizado", dtfDate.format(vw_tra_flx_usuT.getFlx_dt_finalizado()));
        param.put("vw_tra_flx_usuT.flx_nr_idanterior", vw_tra_flx_usuT.getFlx_nr_idanterior() + "");
        param.put("vw_tra_flx_usuT.tra_nr_idorigem", vw_tra_flx_usuT.getTra_nr_idorigem() + "");
        param.put("vw_tra_flx_usuT.tra_nr_iddestino", vw_tra_flx_usuT.getTra_nr_iddestino() + "");
        param.put("vw_tra_flx_usuT.usu_nr_id", vw_tra_flx_usuT.getUsu_nr_id() + "");
        param.put("vw_tra_flx_usuT.usu_tx_nome", vw_tra_flx_usuT.getUsu_tx_nome() + "");
        param.put("vw_tra_flx_usuT.usu_tx_login", vw_tra_flx_usuT.getUsu_tx_login() + "");
        param.put("vw_tra_flx_usuT.usu_tx_status", vw_tra_flx_usuT.getUsu_tx_status() + "");
        param.put("vw_tra_flx_usuT.usu_tx_email", vw_tra_flx_usuT.getUsu_tx_email() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Vw_tra_flx_usuTGWT> lista = new ListStore<Vw_tra_flx_usuTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Vw_tra_flx_usuTGWT vw_tra_flx_usuT = lerRegistroJson(registro);
                lista.add(vw_tra_flx_usuT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Vw_tra_flx_usuTGWT lerRegistroJson(JSONObject registro) {
        Vw_tra_flx_usuTGWT vw_tra_flx_usuTGWT = new Vw_tra_flx_usuTGWT();
        Integer tra_nr_id = Integer.parseInt(registro.get("tra_nr_id").isString().stringValue());
        vw_tra_flx_usuTGWT.setTra_nr_id(tra_nr_id);
        Integer des_nr_id = Integer.parseInt(registro.get("des_nr_id").isString().stringValue());
        vw_tra_flx_usuTGWT.setDes_nr_id(des_nr_id);
        Integer tid_nr_id = Integer.parseInt(registro.get("tid_nr_id").isString().stringValue());
        vw_tra_flx_usuTGWT.setTid_nr_id(tid_nr_id);

        Integer usu_nr_idowner = Integer.parseInt(registro.get("usu_nr_idowner").isString().stringValue());
        vw_tra_flx_usuTGWT.setUsu_nr_idowner(usu_nr_idowner);

        String tra_tx_nome = registro.get("tra_tx_nome").isString().stringValue();
        vw_tra_flx_usuTGWT.setTra_tx_nome(tra_tx_nome);
        String tra_tx_automatico = registro.get("tra_tx_automatico").isString().stringValue();
        vw_tra_flx_usuTGWT.setTra_tx_automatico(tra_tx_automatico);

        Integer flx_nr_id = Integer.parseInt(registro.get("flx_nr_id").isString().stringValue());
        vw_tra_flx_usuTGWT.setFlx_nr_id(flx_nr_id);

        String strDtMovimentacao = registro.get("flx_dt_movimentacao").isString().stringValue();
        if (strDtMovimentacao != null && !strDtMovimentacao.trim().isEmpty()) {
            Date flx_dt_movimentacao = dtfDateTime.parse(strDtMovimentacao);
            vw_tra_flx_usuTGWT.setFlx_dt_movimentacao(flx_dt_movimentacao);
        }
        String flx_tx_obs = registro.get("flx_tx_obs").isString().stringValue();
        if (flx_tx_obs == null || flx_tx_obs.trim().length() ==0 || flx_tx_obs.trim().equalsIgnoreCase("null")) {
            vw_tra_flx_usuTGWT.setFlx_tx_obs("");
        } else {
            vw_tra_flx_usuTGWT.setFlx_tx_obs(flx_tx_obs);
        }

        String strDtFinalizado = registro.get("flx_dt_finalizado").isString().stringValue();
        if (strDtFinalizado != null && !strDtFinalizado.trim().isEmpty()) {
            Date flx_dt_finalizado = dtfDateTime.parse(strDtFinalizado);
            vw_tra_flx_usuTGWT.setFlx_dt_finalizado(flx_dt_finalizado);
        }
        Integer flx_nr_idanterior = Integer.parseInt(registro.get("flx_nr_idanterior").isString().stringValue());
        vw_tra_flx_usuTGWT.setFlx_nr_idanterior(flx_nr_idanterior);

        Integer tra_nr_idorigem = Integer.parseInt(registro.get("tra_nr_idorigem").isString().stringValue());
        vw_tra_flx_usuTGWT.setTra_nr_idorigem(tra_nr_idorigem);

        String traNrIdDestino = registro.get("tra_nr_iddestino").isString().stringValue();
        if (traNrIdDestino != null && traNrIdDestino.trim().length() > 0) {
            Integer tra_nr_iddestino = Integer.parseInt(traNrIdDestino);
            vw_tra_flx_usuTGWT.setTra_nr_iddestino(tra_nr_iddestino);
        }

        String usuNrId = registro.get("usu_nr_id").isString().stringValue();

        String ids = registro.get("ids").isString().stringValue();
        if (ids == null) {
            ids = "";
        }
        vw_tra_flx_usuTGWT.setIds(ids);
        if ((usuNrId != null && !usuNrId.trim().isEmpty()) || !"0".equals(usuNrId)) {
            Integer usu_nr_id = Integer.parseInt(usuNrId);
            vw_tra_flx_usuTGWT.setUsu_nr_id(usu_nr_id);
            String usu_tx_nome = registro.get("usu_tx_nome").isString().stringValue();
            vw_tra_flx_usuTGWT.setUsu_tx_nome(usu_tx_nome);

            String usu_tx_login = registro.get("usu_tx_login").isString().stringValue();
            vw_tra_flx_usuTGWT.setUsu_tx_login(usu_tx_login);

            String usu_tx_status = registro.get("usu_tx_status").isString().stringValue();
            vw_tra_flx_usuTGWT.setUsu_tx_status(usu_tx_status);
            String usu_tx_email = registro.get("usu_tx_email").isString().stringValue();
            vw_tra_flx_usuTGWT.setUsu_tx_email(usu_tx_email);
        } else {
            vw_tra_flx_usuTGWT.setUsu_nr_id(0);
            vw_tra_flx_usuTGWT.setUsu_tx_nome("");
            vw_tra_flx_usuTGWT.setUsu_tx_login("");
            vw_tra_flx_usuTGWT.setUsu_tx_status("");
            vw_tra_flx_usuTGWT.setUsu_tx_email("");
        }
        return vw_tra_flx_usuTGWT;
    }

    /**
     * @return the list
     */
    public ListStore getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ListStore list) {
        this.list = list;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the vw_tra_flx_usuT
     */
    public Vw_tra_flx_usuTGWT getVw_tra_flx_usuT() {
        return vw_tra_flx_usuT;
    }

    /**
     * @param vw_tra_flx_usuTGWT the vw_tra_flx_usuTGWT to set
     */
    public void setVw_tra_flx_usuTGWT(Vw_tra_flx_usuTGWT vw_tra_flx_usuT) {
        this.vw_tra_flx_usuT = vw_tra_flx_usuT;
    }
}