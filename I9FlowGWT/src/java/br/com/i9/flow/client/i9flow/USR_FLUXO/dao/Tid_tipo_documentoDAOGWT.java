package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Tid_tipo_documentoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Tid_tipo_documentoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/tid_tipo_documento/tid_tipo_documentoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/tid_tipo_documento/tid_tipo_documentoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/tid_tipo_documento/tid_tipo_documentoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Tid_tipo_documentoTGWT tid_tipo_documentoT;

    public void consultarTodos() {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Tid_tipo_documentoTGWT tid_tipo_documentoT) {
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
        param.put("tid_tipo_documentoT.tid_nr_id", tid_tipo_documentoT.getTid_nr_id() + "");
        param.put("tid_tipo_documentoT.tid_tx_nome", tid_tipo_documentoT.getTid_tx_nome() + "");
        param.put("tid_tipo_documentoT.tra_nr_id", tid_tipo_documentoT.getTra_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Tid_tipo_documentoTGWT tid_tipo_documentoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("tid_tipo_documento").isObject();
                    Tid_tipo_documentoDAOGWT.this.tid_tipo_documentoT = lerRegistroJson(registro);
                }
            }
        };
        this.tid_tipo_documentoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("tid_tipo_documentoT.tid_nr_id", tid_tipo_documentoT.getTid_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Tid_tipo_documentoTGWT tid_tipo_documentoT) {
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
        param.put("tid_tipo_documentoT.tid_nr_id", tid_tipo_documentoT.getTid_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Tid_tipo_documentoTGWT tid_tipo_documentoT) {
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
        param.put("tid_tipo_documentoT.tid_nr_id", tid_tipo_documentoT.getTid_nr_id() + "");
        param.put("tid_tipo_documentoT.tid_tx_nome", tid_tipo_documentoT.getTid_tx_nome() + "");
        param.put("tid_tipo_documentoT.tra_nr_id", tid_tipo_documentoT.getTra_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Tid_tipo_documentoTGWT> lista = new ListStore<Tid_tipo_documentoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Tid_tipo_documentoTGWT tid_tipo_documentoT = lerRegistroJson(registro);
                lista.add(tid_tipo_documentoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Tid_tipo_documentoTGWT lerRegistroJson(JSONObject registro) {
        Tid_tipo_documentoTGWT tid_tipo_documentoTGWT = new Tid_tipo_documentoTGWT();
        Integer tid_nr_id = Integer.parseInt(registro.get("tid_nr_id").isString().stringValue());
        tid_tipo_documentoTGWT.setTid_nr_id(tid_nr_id);

        String tid_tx_nome = registro.get("tid_tx_nome").isString().stringValue();
        tid_tipo_documentoTGWT.setTid_tx_nome(tid_tx_nome);

        Integer tra_nr_id = Integer.parseInt(registro.get("tra_nr_id").isString().stringValue());
        tid_tipo_documentoTGWT.setTra_nr_id(tra_nr_id);


        return tid_tipo_documentoTGWT;
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
     * @return the tid_tipo_documentoT
     */
    public Tid_tipo_documentoTGWT getTid_tipo_documentoT() {
        return tid_tipo_documentoT;
    }

    /**
     * @param tid_tipo_documentoTGWT the tid_tipo_documentoTGWT to set
     */
    public void setTid_tipo_documentoTGWT(Tid_tipo_documentoTGWT tid_tipo_documentoT) {
        this.tid_tipo_documentoT = tid_tipo_documentoT;
    }
}
