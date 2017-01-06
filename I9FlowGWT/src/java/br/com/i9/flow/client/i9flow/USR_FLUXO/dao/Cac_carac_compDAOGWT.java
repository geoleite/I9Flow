package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Cac_carac_compTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Cac_carac_compDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/cac_carac_comp/cac_carac_compInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/cac_carac_comp/cac_carac_compConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/cac_carac_comp/cac_carac_compUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Cac_carac_compTGWT cac_carac_compT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultByDocTypeNameAndFlowId(int flowId, String className) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByDocTypeNameAndFlowId");
        param.put("cac_carac_compT.tra_nr_id", flowId + "");
        param.put("className", className);

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Cac_carac_compTGWT cac_carac_compT) {
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
        param.put("cac_carac_compT.tra_nr_id", cac_carac_compT.getTra_nr_id() + "");
        param.put("cac_carac_compT.tel_nr_id", cac_carac_compT.getTel_nr_id() + "");
        param.put("cac_carac_compT.cac_nr_id", cac_carac_compT.getCac_nr_id() + "");
        param.put("cac_carac_compT.cac_tx_idcomponente", cac_carac_compT.getCac_tx_idcomponente() + "");
        param.put("cac_carac_compT.cac_tx_visivel", cac_carac_compT.getCac_tx_visivel() + "");
        param.put("cac_carac_compT.cac_tx_habilitado", cac_carac_compT.getCac_tx_habilitado() + "");
        param.put("cac_carac_compT.cac_tx_editavel", cac_carac_compT.getCac_tx_editavel() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Cac_carac_compTGWT cac_carac_compT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("cac_carac_comp").isObject();
                    Cac_carac_compDAOGWT.this.cac_carac_compT = lerRegistroJson(registro);
                }
            }
        };
        this.cac_carac_compT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("cac_carac_compT.tra_nr_id", cac_carac_compT.getTra_nr_id() + "");
        param.put("cac_carac_compT.tel_nr_id", cac_carac_compT.getTel_nr_id() + "");
        param.put("cac_carac_compT.cac_nr_id", cac_carac_compT.getCac_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Cac_carac_compTGWT cac_carac_compT) {
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
        param.put("cac_carac_compT.tra_nr_id", cac_carac_compT.getTra_nr_id() + "");
        param.put("cac_carac_compT.tel_nr_id", cac_carac_compT.getTel_nr_id() + "");
        param.put("cac_carac_compT.cac_nr_id", cac_carac_compT.getCac_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Cac_carac_compTGWT cac_carac_compT) {
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
        param.put("cac_carac_compT.tra_nr_id", cac_carac_compT.getTra_nr_id() + "");
        param.put("cac_carac_compT.tel_nr_id", cac_carac_compT.getTel_nr_id() + "");
        param.put("cac_carac_compT.cac_nr_id", cac_carac_compT.getCac_nr_id() + "");
        param.put("cac_carac_compT.cac_tx_idcomponente", cac_carac_compT.getCac_tx_idcomponente() + "");
        param.put("cac_carac_compT.cac_tx_visivel", cac_carac_compT.getCac_tx_visivel() + "");
        param.put("cac_carac_compT.cac_tx_habilitado", cac_carac_compT.getCac_tx_habilitado() + "");
        param.put("cac_carac_compT.cac_tx_editavel", cac_carac_compT.getCac_tx_editavel() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Cac_carac_compTGWT> lista = new ListStore<Cac_carac_compTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Cac_carac_compTGWT cac_carac_compT = lerRegistroJson(registro);
                lista.add(cac_carac_compT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Cac_carac_compTGWT lerRegistroJson(JSONObject registro) {
        Cac_carac_compTGWT cac_carac_compTGWT = new Cac_carac_compTGWT();
        Integer tra_nr_id = Integer.parseInt(registro.get("tra_nr_id").isString().stringValue());
        cac_carac_compTGWT.setTra_nr_id(tra_nr_id);

        Integer tel_nr_id = Integer.parseInt(registro.get("tel_nr_id").isString().stringValue());
        cac_carac_compTGWT.setTel_nr_id(tel_nr_id);

        Integer cac_nr_id = Integer.parseInt(registro.get("cac_nr_id").isString().stringValue());
        cac_carac_compTGWT.setCac_nr_id(cac_nr_id);

        String cac_tx_idcomponente = registro.get("cac_tx_idcomponente").isString().stringValue();
        cac_carac_compTGWT.setCac_tx_idcomponente(cac_tx_idcomponente);

        String cac_tx_visivel = registro.get("cac_tx_visivel").isString().stringValue();
        cac_carac_compTGWT.setCac_tx_visivel(cac_tx_visivel);

        String cac_tx_habilitado = registro.get("cac_tx_habilitado").isString().stringValue();
        cac_carac_compTGWT.setCac_tx_habilitado(cac_tx_habilitado);

        String cac_tx_editavel = registro.get("cac_tx_editavel").isString().stringValue();
        cac_carac_compTGWT.setCac_tx_editavel(cac_tx_editavel);


        return cac_carac_compTGWT;
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
     * @return the cac_carac_compT
     */
    public Cac_carac_compTGWT getCac_carac_compT() {
        return cac_carac_compT;
    }

    /**
     * @param cac_carac_compTGWT the cac_carac_compTGWT to set
     */
    public void setCac_carac_compTGWT(Cac_carac_compTGWT cac_carac_compT) {
        this.cac_carac_compT = cac_carac_compT;
    }
}
