/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client.i9flow.USR_FLUXO.opt_opcao_tramite;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.*;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Opt_opcao_tramiteInsertGWT extends CadastrarBaseGWT  {
    private Opt_opcao_tramiteConsultGWT opt_opcao_tramiteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Opt_opcao_tramiteDAOGWT opt_opcao_tramiteDao = new Opt_opcao_tramiteDAOGWT();
    private EasyTextField<String> tra_nr_idorigem = new EasyTextField<String>();
    private EasyTextField<String> tra_nr_iddestino = new EasyTextField<String>();
    private EasyTextField<String> opt_nr_ordem = new EasyTextField<String>();
    private EasyTextField<String> opt_tx_retorno = new EasyTextField<String>();
    private EasyTextField<String> opt_tx_nome = new EasyTextField<String>();


    public Opt_opcao_tramiteInsertGWT() {
	setHeading("Cadastrar Opt_opcao_tramite");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lftra_nr_idorigem = new LabelField("tra_nr_idorigem:");
        lftra_nr_idorigem.setId("lftra_nr_idorigem");
	getCpMaster().add(lftra_nr_idorigem);
        tra_nr_idorigem.setId("tra_nr_idorigem");
        tra_nr_idorigem.setMaxLength(22);
        getCpMaster().add(tra_nr_idorigem);

	LabelField lftra_nr_iddestino = new LabelField("tra_nr_iddestino:");
        lftra_nr_iddestino.setId("lftra_nr_iddestino");
	getCpMaster().add(lftra_nr_iddestino);
        tra_nr_iddestino.setId("tra_nr_iddestino");
        tra_nr_iddestino.setMaxLength(22);
        getCpMaster().add(tra_nr_iddestino);

	LabelField lfopt_nr_ordem = new LabelField("opt_nr_ordem:");
        lfopt_nr_ordem.setId("lfopt_nr_ordem");
	getCpMaster().add(lfopt_nr_ordem);
        opt_nr_ordem.setId("opt_nr_ordem");
        opt_nr_ordem.setMaxLength(22);
        getCpMaster().add(opt_nr_ordem);

	LabelField lfopt_tx_retorno = new LabelField("opt_tx_retorno:");
        lfopt_tx_retorno.setId("lfopt_tx_retorno");
	getCpMaster().add(lfopt_tx_retorno);
        opt_tx_retorno.setId("opt_tx_retorno");
        opt_tx_retorno.setMaxLength(1);
        getCpMaster().add(opt_tx_retorno);

	LabelField lfopt_tx_nome = new LabelField("opt_tx_nome:");
        lfopt_tx_nome.setId("lfopt_tx_nome");
	getCpMaster().add(lfopt_tx_nome);
        opt_tx_nome.setId("opt_tx_nome");
        opt_tx_nome.setMaxLength(30);
        getCpMaster().add(opt_tx_nome);


    }

    public void btnInsertAction(ButtonEvent ce){
	Opt_opcao_tramiteTGWT opt_opcao_tramiteT = new Opt_opcao_tramiteTGWT();
			opt_opcao_tramiteT.setTra_nr_idorigem( Integer.parseInt(tra_nr_idorigem.getValue()));
		opt_opcao_tramiteT.setTra_nr_iddestino( Integer.parseInt(tra_nr_iddestino.getValue()));
		opt_opcao_tramiteT.setOpt_nr_ordem( Integer.parseInt(opt_nr_ordem.getValue()));
		opt_opcao_tramiteT.setOpt_tx_retorno(opt_tx_retorno.getValue());
		opt_opcao_tramiteT.setOpt_tx_nome(opt_tx_nome.getValue());

        opt_opcao_tramiteDao.inserir(opt_opcao_tramiteT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = opt_opcao_tramiteDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  opt_opcao_tramiteConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			tra_nr_idorigem.setValue("");
		tra_nr_iddestino.setValue("");
		opt_nr_ordem.setValue("");
		opt_tx_retorno.setValue("");
		opt_tx_nome.setValue("");

    }

   /**
     * @return the opt_opcao_tramiteConsult
     */
    public Opt_opcao_tramiteConsultGWT getOpt_opcao_tramiteConsult() {
        return opt_opcao_tramiteConsult;
    }

    /**
     * @param opt_opcao_tramiteConsult the opt_opcao_tramiteConsult to set
     */
    public void setOpt_opcao_tramiteConsult(Opt_opcao_tramiteConsultGWT opt_opcao_tramiteConsult) {
        this.opt_opcao_tramiteConsult = opt_opcao_tramiteConsult;
    }
}

