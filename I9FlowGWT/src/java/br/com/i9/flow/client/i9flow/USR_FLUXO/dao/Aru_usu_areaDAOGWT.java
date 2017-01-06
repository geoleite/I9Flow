package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;
import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Aru_usu_areaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Aru_usu_areaDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/aru_usu_area/aru_usu_areaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/aru_usu_area/aru_usu_areaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/aru_usu_area/aru_usu_areaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Aru_usu_areaTGWT aru_usu_areaT;	
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Aru_usu_areaTGWT aru_usu_areaT) {
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
	param.put("aru_usu_areaT.usu_nr_id" , aru_usu_areaT.getUsu_nr_id() + "");
param.put("aru_usu_areaT.are_nr_id" , aru_usu_areaT.getAre_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Aru_usu_areaTGWT aru_usu_areaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("aru_usu_area").isObject();
                    Aru_usu_areaDAOGWT.this.aru_usu_areaT = lerRegistroJson(registro);
                }
            }
        };
	this.aru_usu_areaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("aru_usu_areaT.usu_nr_id" , aru_usu_areaT.getUsu_nr_id() + "");
param.put("aru_usu_areaT.are_nr_id" , aru_usu_areaT.getAre_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Aru_usu_areaTGWT aru_usu_areaT) {
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
        param.put("aru_usu_areaT.usu_nr_id" , aru_usu_areaT.getUsu_nr_id() + "");
param.put("aru_usu_areaT.are_nr_id" , aru_usu_areaT.getAre_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Aru_usu_areaTGWT aru_usu_areaT) {
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
	param.put("aru_usu_areaT.usu_nr_id" , aru_usu_areaT.getUsu_nr_id() + "");
param.put("aru_usu_areaT.are_nr_id" , aru_usu_areaT.getAre_nr_id() + "");

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Aru_usu_areaTGWT> lista = new ListStore<Aru_usu_areaTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Aru_usu_areaTGWT aru_usu_areaT = lerRegistroJson(registro);
                lista.add(aru_usu_areaT);            
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conteudo json
     */	
    private Aru_usu_areaTGWT lerRegistroJson(JSONObject registro) {
	Aru_usu_areaTGWT aru_usu_areaTGWT = new Aru_usu_areaTGWT();
	                Integer usu_nr_id=Integer.parseInt(registro.get("usu_nr_id").isString().stringValue());
                aru_usu_areaTGWT.setUsu_nr_id(usu_nr_id);

                Integer are_nr_id=Integer.parseInt(registro.get("are_nr_id").isString().stringValue());
                aru_usu_areaTGWT.setAre_nr_id(are_nr_id);


	return aru_usu_areaTGWT;
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
     * @return the aru_usu_areaT
     */
    public Aru_usu_areaTGWT getAru_usu_areaT() {
        return aru_usu_areaT;
    }

    /**
     * @param aru_usu_areaTGWT the aru_usu_areaTGWT to set
     */
    public void setAru_usu_areaTGWT(Aru_usu_areaTGWT aru_usu_areaT) {
        this.aru_usu_areaT = aru_usu_areaT;
    }
}
