package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;
import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Doc_documentoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Doc_documentoDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/doc_documento/doc_documentoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/doc_documento/doc_documentoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/doc_documento/doc_documentoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Doc_documentoTGWT doc_documentoT;	
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Doc_documentoTGWT doc_documentoT) {
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
	param.put("doc_documentoT.doc_nr_id" , doc_documentoT.getDoc_nr_id() + "");
param.put("doc_documentoT.flx_nr_id" , doc_documentoT.getFlx_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Doc_documentoTGWT doc_documentoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("doc_documento").isObject();
                    Doc_documentoDAOGWT.this.doc_documentoT = lerRegistroJson(registro);
                }
            }
        };
	this.doc_documentoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("doc_documentoT.doc_nr_id" , doc_documentoT.getDoc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Doc_documentoTGWT doc_documentoT) {
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
        param.put("doc_documentoT.doc_nr_id" , doc_documentoT.getDoc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Doc_documentoTGWT doc_documentoT) {
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
	param.put("doc_documentoT.doc_nr_id" , doc_documentoT.getDoc_nr_id() + "");
param.put("doc_documentoT.flx_nr_id" , doc_documentoT.getFlx_nr_id() + "");

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Doc_documentoTGWT> lista = new ListStore<Doc_documentoTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Doc_documentoTGWT doc_documentoT = lerRegistroJson(registro);
                lista.add(doc_documentoT);            
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conteudo json
     */	
    private Doc_documentoTGWT lerRegistroJson(JSONObject registro) {
	Doc_documentoTGWT doc_documentoTGWT = new Doc_documentoTGWT();
	                Integer doc_nr_id=Integer.parseInt(registro.get("doc_nr_id").isString().stringValue());
                doc_documentoTGWT.setDoc_nr_id(doc_nr_id);

                Integer flx_nr_id=Integer.parseInt(registro.get("flx_nr_id").isString().stringValue());
                doc_documentoTGWT.setFlx_nr_id(flx_nr_id);


	return doc_documentoTGWT;
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
     * @return the doc_documentoT
     */
    public Doc_documentoTGWT getDoc_documentoT() {
        return doc_documentoT;
    }

    /**
     * @param doc_documentoTGWT the doc_documentoTGWT to set
     */
    public void setDoc_documentoTGWT(Doc_documentoTGWT doc_documentoT) {
        this.doc_documentoT = doc_documentoT;
    }
}
