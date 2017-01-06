package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Did_documento_identificacaoTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Tra_tramiteTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Tra_tramiteDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/tra_tramite/tra_tramiteInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/tra_tramite/tra_tramiteConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/tra_tramite/tra_tramiteUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Tra_tramiteTGWT tra_tramiteT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultTramiteManualByTipoDocumento(Tra_tramiteTGWT traT) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultTramiteManualByTipoDocumento");
        param.put("tra_tramiteT.tid_nr_id", traT.getTid_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultByTipoDocumento(int tidNrId) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByTipoDocumento");
        param.put("tra_tramiteT.tid_nr_id", tidNrId + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void findByDocTypeNameActual(String docTypeName, List<Did_documento_identificacaoTGWT> listIdDoc, boolean firstTramite) {
        list = null;
        msg = null;
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("tra_tramite").isObject();
                    Tra_tramiteDAOGWT.this.tra_tramiteT = lerRegistroJson(registro);
                }
            }
        };

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findByDocTypeNameActual");
        param.put("firstTramite", firstTramite + "");
        param.put("docTypeName", docTypeName);
        String paramDid = "";
        if (listIdDoc != null) {
            for (int i = 0; i < listIdDoc.size(); i++) {
                Did_documento_identificacaoTGWT didT = listIdDoc.get(i);
                paramDid += didT.getDid_tx_nomecoluna() + "=" + didT.getDid_tx_valor() + ";";
            }
            param.put("paramDid", paramDid);
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_ALTERAR_EXCLUIR, param);
    }

    public void inserir(Tra_tramiteTGWT tra_tramiteT) {
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
        param.put("tra_tramiteT.tra_nr_id", tra_tramiteT.getTra_nr_id() + "");
        param.put("tra_tramiteT.des_nr_id", tra_tramiteT.getDes_nr_id() + "");
        param.put("tra_tramiteT.tid_nr_id", tra_tramiteT.getTid_nr_id() + "");
        param.put("tra_tramiteT.usu_nr_id", tra_tramiteT.getUsu_nr_id() + "");
        param.put("tra_tramiteT.tra_tx_nome", tra_tramiteT.getTra_tx_nome() + "");
        param.put("tra_tramiteT.tra_tx_automatico", tra_tramiteT.getTra_tx_automatico() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Tra_tramiteTGWT tra_tramiteT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("tra_tramite").isObject();
                    Tra_tramiteDAOGWT.this.tra_tramiteT = lerRegistroJson(registro);
                }
            }
        };
        this.tra_tramiteT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("tra_tramiteT.tra_nr_id", tra_tramiteT.getTra_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Tra_tramiteTGWT tra_tramiteT) {
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
        param.put("tra_tramiteT.tra_nr_id", tra_tramiteT.getTra_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Tra_tramiteTGWT tra_tramiteT) {
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
        param.put("tra_tramiteT.tra_nr_id", tra_tramiteT.getTra_nr_id() + "");
        param.put("tra_tramiteT.des_nr_id", tra_tramiteT.getDes_nr_id() + "");
        param.put("tra_tramiteT.tid_nr_id", tra_tramiteT.getTid_nr_id() + "");
        param.put("tra_tramiteT.usu_nr_id", tra_tramiteT.getUsu_nr_id() + "");
        param.put("tra_tramiteT.tra_tx_nome", tra_tramiteT.getTra_tx_nome() + "");
        param.put("tra_tramiteT.tra_tx_automatico", tra_tramiteT.getTra_tx_automatico() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Tra_tramiteTGWT> lista = new ListStore<Tra_tramiteTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Tra_tramiteTGWT tra_tramiteT = lerRegistroJson(registro);
                lista.add(tra_tramiteT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Tra_tramiteTGWT lerRegistroJson(JSONObject registro) {
        Tra_tramiteTGWT tra_tramiteTGWT = new Tra_tramiteTGWT();
        Integer tra_nr_id = Integer.parseInt(registro.get("tra_nr_id").isString().stringValue());
        tra_tramiteTGWT.setTra_nr_id(tra_nr_id);

        Integer des_nr_id = Integer.parseInt(registro.get("des_nr_id").isString().stringValue());
        tra_tramiteTGWT.setDes_nr_id(des_nr_id);

        Integer tid_nr_id = Integer.parseInt(registro.get("tid_nr_id").isString().stringValue());
        tra_tramiteTGWT.setTid_nr_id(tid_nr_id);

        Integer usu_nr_id = Integer.parseInt(registro.get("usu_nr_id").isString().stringValue());
        tra_tramiteTGWT.setUsu_nr_id(usu_nr_id);

        String tra_tx_nome = registro.get("tra_tx_nome").isString().stringValue();
        tra_tramiteTGWT.setTra_tx_nome(tra_tx_nome);

        String tra_tx_automatico = registro.get("tra_tx_automatico").isString().stringValue();
        tra_tramiteTGWT.setTra_tx_automatico(tra_tx_automatico);


        return tra_tramiteTGWT;
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
     * @return the tra_tramiteT
     */
    public Tra_tramiteTGWT getTra_tramiteT() {
        return tra_tramiteT;
    }

    /**
     * @param tra_tramiteTGWT the tra_tramiteTGWT to set
     */
    public void setTra_tramiteTGWT(Tra_tramiteTGWT tra_tramiteT) {
        this.tra_tramiteT = tra_tramiteT;
    }
}
