package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;
import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Des_destinoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Des_destinoDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/des_destino/des_destinoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/des_destino/des_destinoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/des_destino/des_destinoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Des_destinoTGWT des_destinoT;	
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Des_destinoTGWT des_destinoT) {
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
	param.put("des_destinoT.des_nr_id" , des_destinoT.getDes_nr_id() + "");
param.put("des_destinoT.des_tx_tipo" , des_destinoT.getDes_tx_tipo() + "");
param.put("des_destinoT.des_nr_idregistro" , des_destinoT.getDes_nr_idregistro() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Des_destinoTGWT des_destinoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("des_destino").isObject();
                    Des_destinoDAOGWT.this.des_destinoT = lerRegistroJson(registro);
                }
            }
        };
	this.des_destinoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("des_destinoT.des_nr_id" , des_destinoT.getDes_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Des_destinoTGWT des_destinoT) {
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
        param.put("des_destinoT.des_nr_id" , des_destinoT.getDes_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Des_destinoTGWT des_destinoT) {
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
	param.put("des_destinoT.des_nr_id" , des_destinoT.getDes_nr_id() + "");
param.put("des_destinoT.des_tx_tipo" , des_destinoT.getDes_tx_tipo() + "");
param.put("des_destinoT.des_nr_idregistro" , des_destinoT.getDes_nr_idregistro() + "");

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Des_destinoTGWT> lista = new ListStore<Des_destinoTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Des_destinoTGWT des_destinoT = lerRegistroJson(registro);
                lista.add(des_destinoT);            
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conteudo json
     */	
    private Des_destinoTGWT lerRegistroJson(JSONObject registro) {
	Des_destinoTGWT des_destinoTGWT = new Des_destinoTGWT();
	                Integer des_nr_id=Integer.parseInt(registro.get("des_nr_id").isString().stringValue());
                des_destinoTGWT.setDes_nr_id(des_nr_id);

                String des_tx_tipo= registro.get("des_tx_tipo").isString().stringValue();
                des_destinoTGWT.setDes_tx_tipo(des_tx_tipo);

                Integer des_nr_idregistro=Integer.parseInt(registro.get("des_nr_idregistro").isString().stringValue());
                des_destinoTGWT.setDes_nr_idregistro(des_nr_idregistro);


	return des_destinoTGWT;
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
     * @return the des_destinoT
     */
    public Des_destinoTGWT getDes_destinoT() {
        return des_destinoT;
    }

    /**
     * @param des_destinoTGWT the des_destinoTGWT to set
     */
    public void setDes_destinoTGWT(Des_destinoTGWT des_destinoT) {
        this.des_destinoT = des_destinoT;
    }
}
