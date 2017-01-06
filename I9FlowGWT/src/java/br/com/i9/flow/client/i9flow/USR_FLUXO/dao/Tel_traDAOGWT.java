package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;
import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Tel_traTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Tel_traDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/tel_tra/tel_traInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/tel_tra/tel_traConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/tel_tra/tel_traUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Tel_traTGWT tel_traT;	
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Tel_traTGWT tel_traT) {
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
	param.put("tel_traT.tra_nr_id" , tel_traT.getTra_nr_id() + "");
param.put("tel_traT.tel_nr_id" , tel_traT.getTel_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Tel_traTGWT tel_traT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("tel_tra").isObject();
                    Tel_traDAOGWT.this.tel_traT = lerRegistroJson(registro);
                }
            }
        };
	this.tel_traT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("tel_traT.tra_nr_id" , tel_traT.getTra_nr_id() + "");
param.put("tel_traT.tel_nr_id" , tel_traT.getTel_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Tel_traTGWT tel_traT) {
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
        param.put("tel_traT.tra_nr_id" , tel_traT.getTra_nr_id() + "");
param.put("tel_traT.tel_nr_id" , tel_traT.getTel_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Tel_traTGWT tel_traT) {
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
	param.put("tel_traT.tra_nr_id" , tel_traT.getTra_nr_id() + "");
param.put("tel_traT.tel_nr_id" , tel_traT.getTel_nr_id() + "");

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Tel_traTGWT> lista = new ListStore<Tel_traTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Tel_traTGWT tel_traT = lerRegistroJson(registro);
                lista.add(tel_traT);            
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conteudo json
     */	
    private Tel_traTGWT lerRegistroJson(JSONObject registro) {
	Tel_traTGWT tel_traTGWT = new Tel_traTGWT();
	                Integer tra_nr_id=Integer.parseInt(registro.get("tra_nr_id").isString().stringValue());
                tel_traTGWT.setTra_nr_id(tra_nr_id);

                Integer tel_nr_id=Integer.parseInt(registro.get("tel_nr_id").isString().stringValue());
                tel_traTGWT.setTel_nr_id(tel_nr_id);


	return tel_traTGWT;
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
     * @return the tel_traT
     */
    public Tel_traTGWT getTel_traT() {
        return tel_traT;
    }

    /**
     * @param tel_traTGWT the tel_traTGWT to set
     */
    public void setTel_traTGWT(Tel_traTGWT tel_traT) {
        this.tel_traT = tel_traT;
    }
}
