/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client.i9flow.USR_FLUXO.aru_usu_area;

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
public class Aru_usu_areaInsertGWT extends CadastrarBaseGWT  {
    private Aru_usu_areaConsultGWT aru_usu_areaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Aru_usu_areaDAOGWT aru_usu_areaDao = new Aru_usu_areaDAOGWT();
    private EasyTextField<String> usu_nr_id = new EasyTextField<String>();
    private EasyTextField<String> are_nr_id = new EasyTextField<String>();


    public Aru_usu_areaInsertGWT() {
	setHeading("Cadastrar Aru_usu_area");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfusu_nr_id = new LabelField("usu_nr_id:");
        lfusu_nr_id.setId("lfusu_nr_id");
	getCpMaster().add(lfusu_nr_id);
        usu_nr_id.setId("usu_nr_id");
        usu_nr_id.setMaxLength(22);
        getCpMaster().add(usu_nr_id);

	LabelField lfare_nr_id = new LabelField("are_nr_id:");
        lfare_nr_id.setId("lfare_nr_id");
	getCpMaster().add(lfare_nr_id);
        are_nr_id.setId("are_nr_id");
        are_nr_id.setMaxLength(22);
        getCpMaster().add(are_nr_id);


    }

    public void btnInsertAction(ButtonEvent ce){
	Aru_usu_areaTGWT aru_usu_areaT = new Aru_usu_areaTGWT();
			aru_usu_areaT.setUsu_nr_id( Integer.parseInt(usu_nr_id.getValue()));
		aru_usu_areaT.setAre_nr_id( Integer.parseInt(are_nr_id.getValue()));

        aru_usu_areaDao.inserir(aru_usu_areaT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = aru_usu_areaDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  aru_usu_areaConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			usu_nr_id.setValue("");
		are_nr_id.setValue("");

    }

   /**
     * @return the aru_usu_areaConsult
     */
    public Aru_usu_areaConsultGWT getAru_usu_areaConsult() {
        return aru_usu_areaConsult;
    }

    /**
     * @param aru_usu_areaConsult the aru_usu_areaConsult to set
     */
    public void setAru_usu_areaConsult(Aru_usu_areaConsultGWT aru_usu_areaConsult) {
        this.aru_usu_areaConsult = aru_usu_areaConsult;
    }
}

