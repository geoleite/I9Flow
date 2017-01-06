/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client.i9flow.USR_FLUXO.tra_tramite;

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
public class Tra_tramiteInsertGWT extends CadastrarBaseGWT  {
    private Tra_tramiteConsultGWT tra_tramiteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Tra_tramiteDAOGWT tra_tramiteDao = new Tra_tramiteDAOGWT();
    private EasyTextField<String> tra_nr_id = new EasyTextField<String>();
    private EasyTextField<String> des_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tid_nr_id = new EasyTextField<String>();
    private EasyTextField<String> usu_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tra_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> tra_tx_automatico = new EasyTextField<String>();


    public Tra_tramiteInsertGWT() {
	setHeading("Cadastrar Tra_tramite");
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

	LabelField lfdes_nr_id = new LabelField("des_nr_id:");
        lfdes_nr_id.setId("lfdes_nr_id");
	getCpMaster().add(lfdes_nr_id);
        des_nr_id.setId("des_nr_id");
        des_nr_id.setMaxLength(22);
        getCpMaster().add(des_nr_id);

	LabelField lftid_nr_id = new LabelField("tid_nr_id:");
        lftid_nr_id.setId("lftid_nr_id");
	getCpMaster().add(lftid_nr_id);
        tid_nr_id.setId("tid_nr_id");
        tid_nr_id.setMaxLength(22);
        getCpMaster().add(tid_nr_id);

	LabelField lfusu_nr_id = new LabelField("usu_nr_id:");
        lfusu_nr_id.setId("lfusu_nr_id");
	getCpMaster().add(lfusu_nr_id);
        usu_nr_id.setId("usu_nr_id");
        usu_nr_id.setMaxLength(22);
        getCpMaster().add(usu_nr_id);

	LabelField lftra_tx_nome = new LabelField("tra_tx_nome:");
        lftra_tx_nome.setId("lftra_tx_nome");
	getCpMaster().add(lftra_tx_nome);
        tra_tx_nome.setId("tra_tx_nome");
        tra_tx_nome.setMaxLength(100);
        getCpMaster().add(tra_tx_nome);

	LabelField lftra_tx_automatico = new LabelField("tra_tx_automatico:");
        lftra_tx_automatico.setId("lftra_tx_automatico");
	getCpMaster().add(lftra_tx_automatico);
        tra_tx_automatico.setId("tra_tx_automatico");
        tra_tx_automatico.setMaxLength(1);
        getCpMaster().add(tra_tx_automatico);


    }

    public void btnInsertAction(ButtonEvent ce){
	Tra_tramiteTGWT tra_tramiteT = new Tra_tramiteTGWT();
			tra_tramiteT.setTra_nr_id( Integer.parseInt(tra_nr_id.getValue()));
		tra_tramiteT.setDes_nr_id( Integer.parseInt(des_nr_id.getValue()));
		tra_tramiteT.setTid_nr_id( Integer.parseInt(tid_nr_id.getValue()));
		tra_tramiteT.setUsu_nr_id( Integer.parseInt(usu_nr_id.getValue()));
		tra_tramiteT.setTra_tx_nome(tra_tx_nome.getValue());
		tra_tramiteT.setTra_tx_automatico(tra_tx_automatico.getValue());

        tra_tramiteDao.inserir(tra_tramiteT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = tra_tramiteDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  tra_tramiteConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			tra_nr_id.setValue("");
		des_nr_id.setValue("");
		tid_nr_id.setValue("");
		usu_nr_id.setValue("");
		tra_tx_nome.setValue("");
		tra_tx_automatico.setValue("");

    }

   /**
     * @return the tra_tramiteConsult
     */
    public Tra_tramiteConsultGWT getTra_tramiteConsult() {
        return tra_tramiteConsult;
    }

    /**
     * @param tra_tramiteConsult the tra_tramiteConsult to set
     */
    public void setTra_tramiteConsult(Tra_tramiteConsultGWT tra_tramiteConsult) {
        this.tra_tramiteConsult = tra_tramiteConsult;
    }
}

