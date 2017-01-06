package br.com.i9.flow.client.i9flow.USR_FLUXO.doc_documento;

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
public class Doc_documentoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Doc_documentoConsultGWT doc_documentoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Doc_documentoDAOGWT doc_documentoDao = new Doc_documentoDAOGWT();
    private Doc_documentoTGWT doc_documentoT;

    private EasyTextField<String> doc_nr_id = new EasyTextField<String>();
    private EasyTextField<String> flx_nr_id = new EasyTextField<String>();


    public Doc_documentoUpdateDeleteGWT() {
        setHeading("Alterar Doc_documento");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);
	LabelField lfdoc_nr_id = new LabelField("doc_nr_id:");
        lfdoc_nr_id.setId("lfdoc_nr_id");
	getCpMaster().add(lfdoc_nr_id);
        doc_nr_id.setId("doc_nr_id");
        doc_nr_id.setMaxLength(22);
        getCpMaster().add(doc_nr_id);

	LabelField lfflx_nr_id = new LabelField("flx_nr_id:");
        lfflx_nr_id.setId("lfflx_nr_id");
	getCpMaster().add(lfflx_nr_id);
        flx_nr_id.setId("flx_nr_id");
        flx_nr_id.setMaxLength(22);
        getCpMaster().add(flx_nr_id);


    }

    public void load(Doc_documentoTGWT doc_documentoT) {
	this.doc_documentoT = doc_documentoT;
		doc_nr_id.setValue(doc_documentoT.getDoc_nr_id() + "");
		flx_nr_id.setValue(doc_documentoT.getFlx_nr_id() + "");

    }
    public void btnUpdateAction(ButtonEvent ce) {
		doc_documentoT.setDoc_nr_id( Integer.parseInt(doc_nr_id.getValue()));
		doc_documentoT.setFlx_nr_id( Integer.parseInt(flx_nr_id.getValue()));

	doc_documentoDao.alterar(doc_documentoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = doc_documentoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  doc_documentoConsult.load();
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
		  doc_documentoDao.excluir(doc_documentoT);
		  Timer timer = new Timer() {
	   	    public void run() {
 	     		String msg = doc_documentoDao.getMsg();
 	     		if (msg == null) {
			  schedule(500);
	     		} else {
			  if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  		MessageBox.alert("Problemas", msg, null);
			  } else {
		  		Info.display("Resultado", msg);
		  		doc_documentoConsult.load();
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
     * @return the doc_documentoConsult
     */
    public Doc_documentoConsultGWT getDoc_documentoConsult() {
        return doc_documentoConsult;
    }

    /**
     * @param doc_documentoConsult the doc_documentoConsult to set
     */
    public void setDoc_documentoConsult(Doc_documentoConsultGWT doc_documentoConsult) {
        this.doc_documentoConsult = doc_documentoConsult;
    }

}

