package br.com.i9.flow.client.i9flow.USR_FLUXO.tel_tra;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.*;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

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
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.Dialog;

/**
 *
 * @author geoleite
 */
public class Tel_traUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Tel_traConsultGWT tel_traConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Tel_traDAOGWT tel_traDao = new Tel_traDAOGWT();
    private Tel_traTGWT tel_traT;

    private EasyTextField<String> tra_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tel_nr_id = new EasyTextField<String>();


    public Tel_traUpdateDeleteGWT() {
        setHeading("Alterar Tel_tra");
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


    }

    public void load(Tel_traTGWT tel_traT) {
	this.tel_traT = tel_traT;
		tra_nr_id.setValue(tel_traT.getTra_nr_id() + "");
		tel_nr_id.setValue(tel_traT.getTel_nr_id() + "");

    }
    public void btnUpdateAction(ButtonEvent ce) {
		tel_traT.setTra_nr_id( Integer.parseInt(tra_nr_id.getValue()));
		tel_traT.setTel_nr_id( Integer.parseInt(tel_nr_id.getValue()));

	tel_traDao.alterar(tel_traT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = tel_traDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  tel_traConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        MessageBox.confirm("Aviso", "Tem certeza que deseja excluir registro?", new Listener<MessageBoxEvent>() {

            public void handleEvent(MessageBoxEvent be) {

                if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {
		  tel_traDao.excluir(tel_traT);
		  Timer timer = new Timer() {
	   	    public void run() {
 	     		String msg = tel_traDao.getMsg();
 	     		if (msg == null) {
			  schedule(500);
	     		} else {
			  if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  		MessageBox.alert("Problemas", msg, null);
			  } else {
		  		Info.display("Resultado", msg);
		  		tel_traConsult.load();
		  		setVisible(false);
			  }
	     		}
	   	  }
        	};
		timer.schedule(500);                    
                }
            }
        });
    }


   /**
     * @return the tel_traConsult
     */
    public Tel_traConsultGWT getTel_traConsult() {
        return tel_traConsult;
    }

    /**
     * @param tel_traConsult the tel_traConsult to set
     */
    public void setTel_traConsult(Tel_traConsultGWT tel_traConsult) {
        this.tel_traConsult = tel_traConsult;
    }

}

