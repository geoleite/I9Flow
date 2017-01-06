package br.com.i9.flow.client.i9flow.USR_FLUXO.tid_tipo_documento;

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
public class Tid_tipo_documentoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Tid_tipo_documentoConsultGWT tid_tipo_documentoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Tid_tipo_documentoDAOGWT tid_tipo_documentoDao = new Tid_tipo_documentoDAOGWT();
    private Tid_tipo_documentoTGWT tid_tipo_documentoT;

    private EasyTextField<String> tid_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tid_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> tra_nr_id = new EasyTextField<String>();


    public Tid_tipo_documentoUpdateDeleteGWT() {
        setHeading("Alterar Tid_tipo_documento");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);
	LabelField lftid_nr_id = new LabelField("tid_nr_id:");
        lftid_nr_id.setId("lftid_nr_id");
	getCpMaster().add(lftid_nr_id);
        tid_nr_id.setId("tid_nr_id");
        tid_nr_id.setMaxLength(22);
        getCpMaster().add(tid_nr_id);

	LabelField lftid_tx_nome = new LabelField("tid_tx_nome:");
        lftid_tx_nome.setId("lftid_tx_nome");
	getCpMaster().add(lftid_tx_nome);
        tid_tx_nome.setId("tid_tx_nome");
        tid_tx_nome.setMaxLength(100);
        getCpMaster().add(tid_tx_nome);

	LabelField lftra_nr_id = new LabelField("tra_nr_id:");
        lftra_nr_id.setId("lftra_nr_id");
	getCpMaster().add(lftra_nr_id);
        tra_nr_id.setId("tra_nr_id");
        tra_nr_id.setMaxLength(22);
        getCpMaster().add(tra_nr_id);


    }

    public void load(Tid_tipo_documentoTGWT tid_tipo_documentoT) {
	this.tid_tipo_documentoT = tid_tipo_documentoT;
		tid_nr_id.setValue(tid_tipo_documentoT.getTid_nr_id() + "");
		tid_tx_nome.setValue(tid_tipo_documentoT.getTid_tx_nome());
		tra_nr_id.setValue(tid_tipo_documentoT.getTra_nr_id() + "");

    }
    public void btnUpdateAction(ButtonEvent ce) {
		tid_tipo_documentoT.setTid_nr_id( Integer.parseInt(tid_nr_id.getValue()));
		tid_tipo_documentoT.setTid_tx_nome(tid_tx_nome.getValue());
		tid_tipo_documentoT.setTra_nr_id( Integer.parseInt(tra_nr_id.getValue()));

	tid_tipo_documentoDao.alterar(tid_tipo_documentoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = tid_tipo_documentoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  tid_tipo_documentoConsult.load();
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
		  tid_tipo_documentoDao.excluir(tid_tipo_documentoT);
		  Timer timer = new Timer() {
	   	    public void run() {
 	     		String msg = tid_tipo_documentoDao.getMsg();
 	     		if (msg == null) {
			  schedule(500);
	     		} else {
			  if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  		MessageBox.alert("Problemas", msg, null);
			  } else {
		  		Info.display("Resultado", msg);
		  		tid_tipo_documentoConsult.load();
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
     * @return the tid_tipo_documentoConsult
     */
    public Tid_tipo_documentoConsultGWT getTid_tipo_documentoConsult() {
        return tid_tipo_documentoConsult;
    }

    /**
     * @param tid_tipo_documentoConsult the tid_tipo_documentoConsult to set
     */
    public void setTid_tipo_documentoConsult(Tid_tipo_documentoConsultGWT tid_tipo_documentoConsult) {
        this.tid_tipo_documentoConsult = tid_tipo_documentoConsult;
    }

}

