package br.com.i9.flow.client.i9flow.USR_FLUXO.dao;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Opt_opcao_tramiteTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Opt_opcao_tramiteDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9flow/USR_FLUXO/opt_opcao_tramite/opt_opcao_tramiteInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9flow/USR_FLUXO/opt_opcao_tramite/opt_opcao_tramiteConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9flow/USR_FLUXO/opt_opcao_tramite/opt_opcao_tramiteUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Opt_opcao_tramiteTGWT opt_opcao_tramiteT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultByFlowId(int flowId) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByFlowId");
        param.put("opt_opcao_tramiteT.tra_nr_idorigem", flowId + "");

        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Opt_opcao_tramiteTGWT opt_opcao_tramiteT) {
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
        param.put("opt_opcao_tramiteT.tra_nr_idorigem", opt_opcao_tramiteT.getTra_nr_idorigem() + "");
        param.put("opt_opcao_tramiteT.tra_nr_iddestino", opt_opcao_tramiteT.getTra_nr_iddestino() + "");
        param.put("opt_opcao_tramiteT.opt_nr_ordem", opt_opcao_tramiteT.getOpt_nr_ordem() + "");
        param.put("opt_opcao_tramiteT.opt_tx_retorno", opt_opcao_tramiteT.getOpt_tx_retorno() + "");
        param.put("opt_opcao_tramiteT.opt_tx_nome", opt_opcao_tramiteT.getOpt_tx_nome() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Opt_opcao_tramiteTGWT opt_opcao_tramiteT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("opt_opcao_tramite").isObject();
                    Opt_opcao_tramiteDAOGWT.this.opt_opcao_tramiteT = lerRegistroJson(registro);
                }
            }
        };
        this.opt_opcao_tramiteT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("opt_opcao_tramiteT.tra_nr_idorigem", opt_opcao_tramiteT.getTra_nr_idorigem() + "");
        param.put("opt_opcao_tramiteT.tra_nr_iddestino", opt_opcao_tramiteT.getTra_nr_iddestino() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Opt_opcao_tramiteTGWT opt_opcao_tramiteT) {
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
        param.put("opt_opcao_tramiteT.tra_nr_idorigem", opt_opcao_tramiteT.getTra_nr_idorigem() + "");
        param.put("opt_opcao_tramiteT.tra_nr_iddestino", opt_opcao_tramiteT.getTra_nr_iddestino() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Opt_opcao_tramiteTGWT opt_opcao_tramiteT) {
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
        param.put("opt_opcao_tramiteT.tra_nr_idorigem", opt_opcao_tramiteT.getTra_nr_idorigem() + "");
        param.put("opt_opcao_tramiteT.tra_nr_iddestino", opt_opcao_tramiteT.getTra_nr_iddestino() + "");
        param.put("opt_opcao_tramiteT.opt_nr_ordem", opt_opcao_tramiteT.getOpt_nr_ordem() + "");
        param.put("opt_opcao_tramiteT.opt_tx_retorno", opt_opcao_tramiteT.getOpt_tx_retorno() + "");
        param.put("opt_opcao_tramiteT.opt_tx_nome", opt_opcao_tramiteT.getOpt_tx_nome() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Opt_opcao_tramiteTGWT> lista = new ListStore<Opt_opcao_tramiteTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Opt_opcao_tramiteTGWT opt_opcao_tramiteT = lerRegistroJson(registro);
                lista.add(opt_opcao_tramiteT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Opt_opcao_tramiteTGWT lerRegistroJson(JSONObject registro) {
        Opt_opcao_tramiteTGWT opt_opcao_tramiteTGWT = new Opt_opcao_tramiteTGWT();
        Integer tra_nr_idorigem = Integer.parseInt(registro.get("tra_nr_idorigem").isString().stringValue());
        opt_opcao_tramiteTGWT.setTra_nr_idorigem(tra_nr_idorigem);

        Integer tra_nr_iddestino = Integer.parseInt(registro.get("tra_nr_iddestino").isString().stringValue());
        opt_opcao_tramiteTGWT.setTra_nr_iddestino(tra_nr_iddestino);

        Integer opt_nr_ordem = Integer.parseInt(registro.get("opt_nr_ordem").isString().stringValue());
        opt_opcao_tramiteTGWT.setOpt_nr_ordem(opt_nr_ordem);

        String opt_tx_retorno = registro.get("opt_tx_retorno").isString().stringValue();
        opt_opcao_tramiteTGWT.setOpt_tx_retorno(opt_tx_retorno);

        String opt_tx_nome = registro.get("opt_tx_nome").isString().stringValue();
        opt_opcao_tramiteTGWT.setOpt_tx_nome(opt_tx_nome);


        return opt_opcao_tramiteTGWT;
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
     * @return the opt_opcao_tramiteT
     */
    public Opt_opcao_tramiteTGWT getOpt_opcao_tramiteT() {
        return opt_opcao_tramiteT;
    }

    /**
     * @param opt_opcao_tramiteTGWT the opt_opcao_tramiteTGWT to set
     */
    public void setOpt_opcao_tramiteTGWT(Opt_opcao_tramiteTGWT opt_opcao_tramiteT) {
        this.opt_opcao_tramiteT = opt_opcao_tramiteT;
    }
}
