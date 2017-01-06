/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client.i9flow.USR_FLUXO.are_area;

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
public class Are_areaInsertGWT extends CadastrarBaseGWT  {
    private Are_areaConsultGWT are_areaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Are_areaDAOGWT are_areaDao = new Are_areaDAOGWT();
    private EasyTextField<String> are_nr_id = new EasyTextField<String>();
    private EasyTextField<String> are_tx_nome = new EasyTextField<String>();


    public Are_areaInsertGWT() {
	setHeading("Cadastrar Are_area");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfare_nr_id = new LabelField("are_nr_id:");
        lfare_nr_id.setId("lfare_nr_id");
	getCpMaster().add(lfare_nr_id);
        are_nr_id.setId("are_nr_id");
        are_nr_id.setMaxLength(22);
        getCpMaster().add(are_nr_id);

	LabelField lfare_tx_nome = new LabelField("are_tx_nome:");
        lfare_tx_nome.setId("lfare_tx_nome");
	getCpMaster().add(lfare_tx_nome);
        are_tx_nome.setId("are_tx_nome");
        are_tx_nome.setMaxLength(100);
        getCpMaster().add(are_tx_nome);


    }

    public void btnInsertAction(ButtonEvent ce){
	Are_areaTGWT are_areaT = new Are_areaTGWT();
			are_areaT.setAre_nr_id( Integer.parseInt(are_nr_id.getValue()));
		are_areaT.setAre_tx_nome(are_tx_nome.getValue());

        are_areaDao.inserir(are_areaT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = are_areaDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  are_areaConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			are_nr_id.setValue("");
		are_tx_nome.setValue("");

    }

   /**
     * @return the are_areaConsult
     */
    public Are_areaConsultGWT getAre_areaConsult() {
        return are_areaConsult;
    }

    /**
     * @param are_areaConsult the are_areaConsult to set
     */
    public void setAre_areaConsult(Are_areaConsultGWT are_areaConsult) {
        this.are_areaConsult = are_areaConsult;
    }
}

