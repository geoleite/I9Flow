/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client.i9flow.USR_FLUXO.cac_carac_comp;

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
public class Cac_carac_compInsertGWT extends CadastrarBaseGWT  {
    private Cac_carac_compConsultGWT cac_carac_compConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Cac_carac_compDAOGWT cac_carac_compDao = new Cac_carac_compDAOGWT();
    private EasyTextField<String> tra_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tel_nr_id = new EasyTextField<String>();
    private EasyTextField<String> cac_nr_id = new EasyTextField<String>();
    private EasyTextField<String> cac_tx_idcomponente = new EasyTextField<String>();
    private EasyTextField<String> cac_tx_visivel = new EasyTextField<String>();
    private EasyTextField<String> cac_tx_habilitado = new EasyTextField<String>();
    private EasyTextField<String> cac_tx_editavel = new EasyTextField<String>();


    public Cac_carac_compInsertGWT() {
	setHeading("Cadastrar Cac_carac_comp");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lftra_nr_id = new LabelField("tra_nr_id:");
        lftra_nr_id.setId("lftra_nr_id");
	getCpMaster().add(lftra_nr_id);
        tra_nr_id.setId("tra_nr_id");
        tra_nr_id.setMaxLength(22);
        getCpMaster().add(tra_nr_id);

	LabelField lftel_nr_id = new LabelField("tel_nr_id:");
        lftel_nr_id.setId("lftel_nr_id");
	getCpMaster().add(lftel_nr_id);
        tel_nr_id.setId("tel_nr_id");
        tel_nr_id.setMaxLength(22);
        getCpMaster().add(tel_nr_id);

	LabelField lfcac_nr_id = new LabelField("cac_nr_id:");
        lfcac_nr_id.setId("lfcac_nr_id");
	getCpMaster().add(lfcac_nr_id);
        cac_nr_id.setId("cac_nr_id");
        cac_nr_id.setMaxLength(22);
        getCpMaster().add(cac_nr_id);

	LabelField lfcac_tx_idcomponente = new LabelField("cac_tx_idcomponente:");
        lfcac_tx_idcomponente.setId("lfcac_tx_idcomponente");
	getCpMaster().add(lfcac_tx_idcomponente);
        cac_tx_idcomponente.setId("cac_tx_idcomponente");
        cac_tx_idcomponente.setMaxLength(100);
        getCpMaster().add(cac_tx_idcomponente);

	LabelField lfcac_tx_visivel = new LabelField("cac_tx_visivel:");
        lfcac_tx_visivel.setId("lfcac_tx_visivel");
	getCpMaster().add(lfcac_tx_visivel);
        cac_tx_visivel.setId("cac_tx_visivel");
        cac_tx_visivel.setMaxLength(1);
        getCpMaster().add(cac_tx_visivel);

	LabelField lfcac_tx_habilitado = new LabelField("cac_tx_habilitado:");
        lfcac_tx_habilitado.setId("lfcac_tx_habilitado");
	getCpMaster().add(lfcac_tx_habilitado);
        cac_tx_habilitado.setId("cac_tx_habilitado");
        cac_tx_habilitado.setMaxLength(1);
        getCpMaster().add(cac_tx_habilitado);

	LabelField lfcac_tx_editavel = new LabelField("cac_tx_editavel:");
        lfcac_tx_editavel.setId("lfcac_tx_editavel");
	getCpMaster().add(lfcac_tx_editavel);
        cac_tx_editavel.setId("cac_tx_editavel");
        cac_tx_editavel.setMaxLength(1);
        getCpMaster().add(cac_tx_editavel);


    }

    public void btnInsertAction(ButtonEvent ce){
	Cac_carac_compTGWT cac_carac_compT = new Cac_carac_compTGWT();
			cac_carac_compT.setTra_nr_id( Integer.parseInt(tra_nr_id.getValue()));
		cac_carac_compT.setTel_nr_id( Integer.parseInt(tel_nr_id.getValue()));
		cac_carac_compT.setCac_nr_id( Integer.parseInt(cac_nr_id.getValue()));
		cac_carac_compT.setCac_tx_idcomponente(cac_tx_idcomponente.getValue());
		cac_carac_compT.setCac_tx_visivel(cac_tx_visivel.getValue());
		cac_carac_compT.setCac_tx_habilitado(cac_tx_habilitado.getValue());
		cac_carac_compT.setCac_tx_editavel(cac_tx_editavel.getValue());

        cac_carac_compDao.inserir(cac_carac_compT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = cac_carac_compDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  cac_carac_compConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			tra_nr_id.setValue("");
		tel_nr_id.setValue("");
		cac_nr_id.setValue("");
		cac_tx_idcomponente.setValue("");
		cac_tx_visivel.setValue("");
		cac_tx_habilitado.setValue("");
		cac_tx_editavel.setValue("");

    }

   /**
     * @return the cac_carac_compConsult
     */
    public Cac_carac_compConsultGWT getCac_carac_compConsult() {
        return cac_carac_compConsult;
    }

    /**
     * @param cac_carac_compConsult the cac_carac_compConsult to set
     */
    public void setCac_carac_compConsult(Cac_carac_compConsultGWT cac_carac_compConsult) {
        this.cac_carac_compConsult = cac_carac_compConsult;
    }
}

