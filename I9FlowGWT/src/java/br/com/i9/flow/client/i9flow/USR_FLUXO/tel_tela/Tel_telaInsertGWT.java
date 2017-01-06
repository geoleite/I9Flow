/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client.i9flow.USR_FLUXO.tel_tela;

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
public class Tel_telaInsertGWT extends CadastrarBaseGWT  {
    private Tel_telaConsultGWT tel_telaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Tel_telaDAOGWT tel_telaDao = new Tel_telaDAOGWT();
    private EasyTextField<String> tel_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tel_tx_nome = new EasyTextField<String>();


    public Tel_telaInsertGWT() {
	setHeading("Cadastrar Tel_tela");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lftel_nr_id = new LabelField("tel_nr_id:");
        lftel_nr_id.setId("lftel_nr_id");
	getCpMaster().add(lftel_nr_id);
        tel_nr_id.setId("tel_nr_id");
        tel_nr_id.setMaxLength(22);
        getCpMaster().add(tel_nr_id);

	LabelField lftel_tx_nome = new LabelField("tel_tx_nome:");
        lftel_tx_nome.setId("lftel_tx_nome");
	getCpMaster().add(lftel_tx_nome);
        tel_tx_nome.setId("tel_tx_nome");
        tel_tx_nome.setMaxLength(100);
        getCpMaster().add(tel_tx_nome);


    }

    public void btnInsertAction(ButtonEvent ce){
	Tel_telaTGWT tel_telaT = new Tel_telaTGWT();
			tel_telaT.setTel_nr_id( Integer.parseInt(tel_nr_id.getValue()));
		tel_telaT.setTel_tx_nome(tel_tx_nome.getValue());

        tel_telaDao.inserir(tel_telaT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = tel_telaDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  tel_telaConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			tel_nr_id.setValue("");
		tel_tx_nome.setValue("");

    }

   /**
     * @return the tel_telaConsult
     */
    public Tel_telaConsultGWT getTel_telaConsult() {
        return tel_telaConsult;
    }

    /**
     * @param tel_telaConsult the tel_telaConsult to set
     */
    public void setTel_telaConsult(Tel_telaConsultGWT tel_telaConsult) {
        this.tel_telaConsult = tel_telaConsult;
    }
}

