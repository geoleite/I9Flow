package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Flx_fluxoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Flx_fluxoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/flx_fluxo/flx_fluxoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/flx_fluxo/flx_fluxoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/flx_fluxo/flx_fluxoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Flx_fluxoTGWT flx_fluxoT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Flx_fluxoTGWT flx_fluxoT) {
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
        param.put("flx_fluxoT.flx_tx_obs", flx_fluxoT.getFlx_tx_obs() + "");
        param.put("flx_fluxoT.tra_nr_idorigem", flx_fluxoT.getTra_nr_idorigem() + "");
        param.put("flx_fluxoT.tra_nr_iddestino", flx_fluxoT.getTra_nr_iddestino() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Flx_fluxoTGWT flx_fluxoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("flx_fluxo").isObject();
                    Flx_fluxoDAOGWT.this.flx_fluxoT = lerRegistroJson(registro);
                }
            }
        };
        this.flx_fluxoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("flx_fluxoT.flx_nr_id", flx_fluxoT.getFlx_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Flx_fluxoTGWT flx_fluxoT) {
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
        param.put("flx_fluxoT.flx_nr_id", flx_fluxoT.getFlx_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Flx_fluxoTGWT flx_fluxoT) {
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
        param.put("flx_fluxoT.flx_nr_id", flx_fluxoT.getFlx_nr_id() + "");
        param.put("flx_fluxoT.flx_dt_movimentacao", dtfDate.format(flx_fluxoT.getFlx_dt_movimentacao()));
        param.put("flx_fluxoT.usu_nr_id", flx_fluxoT.getUsu_nr_id() + "");
        param.put("flx_fluxoT.flx_tx_obs", flx_fluxoT.getFlx_tx_obs() + "");
        param.put("flx_fluxoT.flx_dt_finalizado", dtfDate.format(flx_fluxoT.getFlx_dt_finalizado()));
        param.put("flx_fluxoT.flx_nr_idanterior", flx_fluxoT.getFlx_nr_idanterior() + "");
        param.put("flx_fluxoT.tra_nr_idorigem", flx_fluxoT.getTra_nr_idorigem() + "");
        param.put("flx_fluxoT.tra_nr_iddestino", flx_fluxoT.getTra_nr_iddestino() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Flx_fluxoTGWT> lista = new ListStore<Flx_fluxoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Flx_fluxoTGWT flx_fluxoT = lerRegistroJson(registro);
                lista.add(flx_fluxoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Flx_fluxoTGWT lerRegistroJson(JSONObject registro) {
        Flx_fluxoTGWT flx_fluxoTGWT = new Flx_fluxoTGWT();
        Integer flx_nr_id = Integer.parseInt(registro.get("flx_nr_id").isString().stringValue());
        flx_fluxoTGWT.setFlx_nr_id(flx_nr_id);

        Date flx_dt_movimentacao = dtfDateTime.parse(registro.get("flx_dt_movimentacao").isString().stringValue());
        flx_fluxoTGWT.setFlx_dt_movimentacao(flx_dt_movimentacao);

        Integer tra_nr_id = Integer.parseInt(registro.get("usu_nr_id").isString().stringValue());
        flx_fluxoTGWT.setUsu_nr_id(tra_nr_id);

        String flx_tx_obs = registro.get("flx_tx_obs").isString().stringValue();
        flx_fluxoTGWT.setFlx_tx_obs(flx_tx_obs);

        String flx_dt_finalizado = registro.get("flx_dt_finalizado").isString().stringValue();
        if (flx_dt_finalizado != null && !flx_dt_finalizado.trim().isEmpty()) {
            Date dtFlx_dt_finalizado = dtfDateTime.parse(flx_dt_finalizado);
            flx_fluxoTGWT.setFlx_dt_finalizado(dtFlx_dt_finalizado);
        }

        Integer flx_nr_idanterior = Integer.parseInt(registro.get("flx_nr_idanterior").isString().stringValue());
        flx_fluxoTGWT.setFlx_nr_idanterior(flx_nr_idanterior);

        Integer tra_nr_idorigem = Integer.parseInt(registro.get("tra_nr_idorigem").isString().stringValue());
        flx_fluxoTGWT.setTra_nr_idorigem(tra_nr_idorigem);

        Integer tra_nr_iddestino = Integer.parseInt(registro.get("tra_nr_iddestino").isString().stringValue());
        flx_fluxoTGWT.setTra_nr_iddestino(tra_nr_iddestino);


        return flx_fluxoTGWT;
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
     * @return the flx_fluxoT
     */
    public Flx_fluxoTGWT getFlx_fluxoT() {
        return flx_fluxoT;
    }

    /**
     * @param flx_fluxoTGWT the flx_fluxoTGWT to set
     */
    public void setFlx_fluxoTGWT(Flx_fluxoTGWT flx_fluxoT) {
        this.flx_fluxoT = flx_fluxoT;
    }
}
