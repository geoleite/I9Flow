/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client.i9flow.USR_FLUXO.did_documento_identificacao;

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
public class Did_documento_identificacaoInsertGWT extends CadastrarBaseGWT  {
    private Did_documento_identificacaoConsultGWT did_documento_identificacaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Did_documento_identificacaoDAOGWT did_documento_identificacaoDao = new Did_documento_identificacaoDAOGWT();
    private EasyTextField<String> did_nr_id = new EasyTextField<String>();
    private EasyTextField<String> flx_nr_id = new EasyTextField<String>();
    private EasyTextField<String> did_tx_nomecoluna = new EasyTextField<String>();
    private EasyTextField<String> did_tx_valor = new EasyTextField<String>();


    public Did_documento_identificacaoInsertGWT() {
	setHeading("Cadastrar Did_documento_identificacao");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfdid_nr_id = new LabelField("did_nr_id:");
        lfdid_nr_id.setId("lfdid_nr_id");
	getCpMaster().add(lfdid_nr_id);
        did_nr_id.setId("did_nr_id");
        did_nr_id.setMaxLength(22);
        getCpMaster().add(did_nr_id);

	LabelField lfflx_nr_id = new LabelField("flx_nr_id:");
        lfflx_nr_id.setId("lfflx_nr_id");
	getCpMaster().add(lfflx_nr_id);
        flx_nr_id.setId("flx_nr_id");
        flx_nr_id.setMaxLength(22);
        getCpMaster().add(flx_nr_id);

	LabelField lfdid_tx_nomecoluna = new LabelField("did_tx_nomecoluna:");
        lfdid_tx_nomecoluna.setId("lfdid_tx_nomecoluna");
	getCpMaster().add(lfdid_tx_nomecoluna);
        did_tx_nomecoluna.setId("did_tx_nomecoluna");
        did_tx_nomecoluna.setMaxLength(100);
        getCpMaster().add(did_tx_nomecoluna);

	LabelField lfdid_tx_valor = new LabelField("did_tx_valor:");
        lfdid_tx_valor.setId("lfdid_tx_valor");
	getCpMaster().add(lfdid_tx_valor);
        did_tx_valor.setId("did_tx_valor");
        did_tx_valor.setMaxLength(20);
        getCpMaster().add(did_tx_valor);


    }

    public void btnInsertAction(ButtonEvent ce){
	Did_documento_identificacaoTGWT did_documento_identificacaoT = new Did_documento_identificacaoTGWT();
			did_documento_identificacaoT.setDid_nr_id( Integer.parseInt(did_nr_id.getValue()));
		did_documento_identificacaoT.setFlx_nr_id( Integer.parseInt(flx_nr_id.getValue()));
		did_documento_identificacaoT.setDid_tx_nomecoluna(did_tx_nomecoluna.getValue());
		did_documento_identificacaoT.setDid_tx_valor(did_tx_valor.getValue());

        did_documento_identificacaoDao.inserir(did_documento_identificacaoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = did_documento_identificacaoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  did_documento_identificacaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			did_nr_id.setValue("");
		flx_nr_id.setValue("");
		did_tx_nomecoluna.setValue("");
		did_tx_valor.setValue("");

    }

   /**
     * @return the did_documento_identificacaoConsult
     */
    public Did_documento_identificacaoConsultGWT getDid_documento_identificacaoConsult() {
        return did_documento_identificacaoConsult;
    }

    /**
     * @param did_documento_identificacaoConsult the did_documento_identificacaoConsult to set
     */
    public void setDid_documento_identificacaoConsult(Did_documento_identificacaoConsultGWT did_documento_identificacaoConsult) {
        this.did_documento_identificacaoConsult = did_documento_identificacaoConsult;
    }
}

