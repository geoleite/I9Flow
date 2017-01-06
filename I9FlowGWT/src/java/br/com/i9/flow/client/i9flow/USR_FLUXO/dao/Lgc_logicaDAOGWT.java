package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Lgc_logicaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Lgc_logicaDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/lgc_logica/lgc_logicaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/lgc_logica/lgc_logicaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/lgc_logica/lgc_logicaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Lgc_logicaTGWT lgc_logicaT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultByTramite(Lgc_logicaTGWT lgcT) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByTramite");
        param.put("lgc_logicaT.tra_nr_id", lgcT.getTra_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Lgc_logicaTGWT lgc_logicaT) {
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
        param.put("lgc_logicaT.lgc_nr_id", lgc_logicaT.getLgc_nr_id() + "");
        param.put("lgc_logicaT.tra_nr_id", lgc_logicaT.getTra_nr_id() + "");
        param.put("lgc_logicaT.lgc_tx_classe", lgc_logicaT.getLgc_tx_classe() + "");
        param.put("lgc_logicaT.lgc_tx_status", lgc_logicaT.getLgc_tx_status() + "");
        param.put("lgc_logicaT.lgc_nr_ordem", lgc_logicaT.getLgc_nr_ordem() + "");
        param.put("lgc_logicaT.lgc_tx_descricao", lgc_logicaT.getLgc_tx_descricao() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Lgc_logicaTGWT lgc_logicaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("lgc_logica").isObject();
                    Lgc_logicaDAOGWT.this.lgc_logicaT = lerRegistroJson(registro);
                }
            }
        };
        this.lgc_logicaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("lgc_logicaT.lgc_nr_id", lgc_logicaT.getLgc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Lgc_logicaTGWT lgc_logicaT) {
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
        param.put("lgc_logicaT.lgc_nr_id", lgc_logicaT.getLgc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Lgc_logicaTGWT lgc_logicaT) {
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
        param.put("lgc_logicaT.lgc_nr_id", lgc_logicaT.getLgc_nr_id() + "");
        param.put("lgc_logicaT.tra_nr_id", lgc_logicaT.getTra_nr_id() + "");
        param.put("lgc_logicaT.lgc_tx_classe", lgc_logicaT.getLgc_tx_classe() + "");
        param.put("lgc_logicaT.lgc_tx_status", lgc_logicaT.getLgc_tx_status() + "");
        param.put("lgc_logicaT.lgc_nr_ordem", lgc_logicaT.getLgc_nr_ordem() + "");
        param.put("lgc_logicaT.lgc_tx_descricao", lgc_logicaT.getLgc_tx_descricao() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Lgc_logicaTGWT> lista = new ListStore<Lgc_logicaTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Lgc_logicaTGWT lgc_logicaT = lerRegistroJson(registro);
                lista.add(lgc_logicaT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Lgc_logicaTGWT lerRegistroJson(JSONObject registro) {
        Lgc_logicaTGWT lgc_logicaTGWT = new Lgc_logicaTGWT();
        Integer lgc_nr_id = Integer.parseInt(registro.get("lgc_nr_id").isString().stringValue());
        lgc_logicaTGWT.setLgc_nr_id(lgc_nr_id);

        Integer tra_nr_id = Integer.parseInt(registro.get("tra_nr_id").isString().stringValue());
        lgc_logicaTGWT.setTra_nr_id(tra_nr_id);

        String lgc_tx_classe = registro.get("lgc_tx_classe").isString().stringValue();
        lgc_logicaTGWT.setLgc_tx_classe(lgc_tx_classe);

        String lgc_tx_status = registro.get("lgc_tx_status").isString().stringValue();
        lgc_logicaTGWT.setLgc_tx_status(lgc_tx_status);

        Integer lgc_nr_ordem = Integer.parseInt(registro.get("lgc_nr_ordem").isString().stringValue());
        lgc_logicaTGWT.setLgc_nr_ordem(lgc_nr_ordem);

        String lgc_tx_descricao = registro.get("lgc_tx_descricao").isString().stringValue();
        lgc_logicaTGWT.setLgc_tx_descricao(lgc_tx_descricao);


        return lgc_logicaTGWT;
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
     * @return the lgc_logicaT
     */
    public Lgc_logicaTGWT getLgc_logicaT() {
        return lgc_logicaT;
    }

    /**
     * @param lgc_logicaTGWT the lgc_logicaTGWT to set
     */
    public void setLgc_logicaTGWT(Lgc_logicaTGWT lgc_logicaT) {
        this.lgc_logicaT = lgc_logicaT;
    }
}
