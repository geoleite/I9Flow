package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;
import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Are_areaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Are_areaDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/are_area/are_areaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/are_area/are_areaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/are_area/are_areaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Are_areaTGWT are_areaT;	
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Are_areaTGWT are_areaT) {
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
	param.put("are_areaT.are_nr_id" , are_areaT.getAre_nr_id() + "");
param.put("are_areaT.are_tx_nome" , are_areaT.getAre_tx_nome() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Are_areaTGWT are_areaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("are_area").isObject();
                    Are_areaDAOGWT.this.are_areaT = lerRegistroJson(registro);
                }
            }
        };
	this.are_areaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("are_areaT.are_nr_id" , are_areaT.getAre_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Are_areaTGWT are_areaT) {
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
        param.put("are_areaT.are_nr_id" , are_areaT.getAre_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Are_areaTGWT are_areaT) {
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
	param.put("are_areaT.are_nr_id" , are_areaT.getAre_nr_id() + "");
param.put("are_areaT.are_tx_nome" , are_areaT.getAre_tx_nome() + "");

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Are_areaTGWT> lista = new ListStore<Are_areaTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Are_areaTGWT are_areaT = lerRegistroJson(registro);
                lista.add(are_areaT);            
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conteudo json
     */	
    private Are_areaTGWT lerRegistroJson(JSONObject registro) {
	Are_areaTGWT are_areaTGWT = new Are_areaTGWT();
	                Integer are_nr_id=Integer.parseInt(registro.get("are_nr_id").isString().stringValue());
                are_areaTGWT.setAre_nr_id(are_nr_id);

                String are_tx_nome= registro.get("are_tx_nome").isString().stringValue();
                are_areaTGWT.setAre_tx_nome(are_tx_nome);


	return are_areaTGWT;
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
     * @return the are_areaT
     */
    public Are_areaTGWT getAre_areaT() {
        return are_areaT;
    }

    /**
     * @param are_areaTGWT the are_areaTGWT to set
     */
    public void setAre_areaTGWT(Are_areaTGWT are_areaT) {
        this.are_areaT = are_areaT;
    }
}
