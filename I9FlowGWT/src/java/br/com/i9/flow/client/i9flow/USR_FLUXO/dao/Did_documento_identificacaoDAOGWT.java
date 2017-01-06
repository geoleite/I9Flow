package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Did_documento_identificacaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Did_documento_identificacaoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/did_documento_identificacao/did_documento_identificacaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/did_documento_identificacao/did_documento_identificacaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/did_documento_identificacao/did_documento_identificacaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Did_documento_identificacaoTGWT did_documento_identificacaoT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultByFluxo(Did_documento_identificacaoTGWT didT) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByFluxo");
        param.put("did_documento_identificacaoT.flx_nr_id", didT.getFlx_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultByFluxos(String idsFluxo) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByFluxos");
        param.put("idsFluxo", idsFluxo);

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Did_documento_identificacaoTGWT did_documento_identificacaoT) {
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
        param.put("did_documento_identificacaoT.did_nr_id", did_documento_identificacaoT.getDid_nr_id() + "");
        param.put("did_documento_identificacaoT.flx_nr_id", did_documento_identificacaoT.getFlx_nr_id() + "");
        param.put("did_documento_identificacaoT.did_tx_nomecoluna", did_documento_identificacaoT.getDid_tx_nomecoluna() + "");
        param.put("did_documento_identificacaoT.did_tx_valor", did_documento_identificacaoT.getDid_tx_valor() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMapNoMessage(url, param);
    }

    public void pesquisar(Did_documento_identificacaoTGWT did_documento_identificacaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("did_documento_identificacao").isObject();
                    Did_documento_identificacaoDAOGWT.this.did_documento_identificacaoT = lerRegistroJson(registro);
                }
            }
        };
        this.did_documento_identificacaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("did_documento_identificacaoT.did_nr_id", did_documento_identificacaoT.getDid_nr_id() + "");
        param.put("did_documento_identificacaoT.flx_nr_id", did_documento_identificacaoT.getFlx_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Did_documento_identificacaoTGWT did_documento_identificacaoT) {
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
        param.put("did_documento_identificacaoT.did_nr_id", did_documento_identificacaoT.getDid_nr_id() + "");
        param.put("did_documento_identificacaoT.flx_nr_id", did_documento_identificacaoT.getFlx_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Did_documento_identificacaoTGWT did_documento_identificacaoT) {
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
        param.put("did_documento_identificacaoT.did_nr_id", did_documento_identificacaoT.getDid_nr_id() + "");
        param.put("did_documento_identificacaoT.flx_nr_id", did_documento_identificacaoT.getFlx_nr_id() + "");
        param.put("did_documento_identificacaoT.did_tx_nomecoluna", did_documento_identificacaoT.getDid_tx_nomecoluna() + "");
        param.put("did_documento_identificacaoT.did_tx_valor", did_documento_identificacaoT.getDid_tx_valor() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Did_documento_identificacaoTGWT> lista = new ListStore<Did_documento_identificacaoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Did_documento_identificacaoTGWT did_documento_identificacaoT = lerRegistroJson(registro);
                lista.add(did_documento_identificacaoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Did_documento_identificacaoTGWT lerRegistroJson(JSONObject registro) {
        Did_documento_identificacaoTGWT did_documento_identificacaoTGWT = new Did_documento_identificacaoTGWT();
        Integer did_nr_id = Integer.parseInt(registro.get("did_nr_id").isString().stringValue());
        did_documento_identificacaoTGWT.setDid_nr_id(did_nr_id);

        Integer flx_nr_id = Integer.parseInt(registro.get("flx_nr_id").isString().stringValue());
        did_documento_identificacaoTGWT.setFlx_nr_id(flx_nr_id);

        String did_tx_nomecoluna = registro.get("did_tx_nomecoluna").isString().stringValue();
        did_documento_identificacaoTGWT.setDid_tx_nomecoluna(did_tx_nomecoluna);

        String did_tx_valor = registro.get("did_tx_valor").isString().stringValue();
        did_documento_identificacaoTGWT.setDid_tx_valor(did_tx_valor);


        return did_documento_identificacaoTGWT;
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
     * @return the did_documento_identificacaoT
     */
    public Did_documento_identificacaoTGWT getDid_documento_identificacaoT() {
        return did_documento_identificacaoT;
    }

    /**
     * @param did_documento_identificacaoTGWT the did_documento_identificacaoTGWT to set
     */
    public void setDid_documento_identificacaoTGWT(Did_documento_identificacaoTGWT did_documento_identificacaoT) {
        this.did_documento_identificacaoT = did_documento_identificacaoT;
    }
}
