package br.com.i9.flow.client.i9flow.USR_FLUXO.lgc_logica;

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
public class Lgc_logicaUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Lgc_logicaConsultGWT lgc_logicaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Lgc_logicaDAOGWT lgc_logicaDao = new Lgc_logicaDAOGWT();
    private Lgc_logicaTGWT lgc_logicaT;

    private EasyTextField<String> lgc_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tra_nr_id = new EasyTextField<String>();
    private EasyTextField<String> lgc_tx_classe = new EasyTextField<String>();
    private EasyTextField<String> lgc_tx_status = new EasyTextField<String>();
    private EasyTextField<String> lgc_nr_ordem = new EasyTextField<String>();
    private EasyTextField<String> lgc_tx_descricao = new EasyTextField<String>();


    public Lgc_logicaUpdateDeleteGWT() {
        setHeading("Alterar Lgc_logica");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);
	LabelField lflgc_nr_id = new LabelField("lgc_nr_id:");
        lflgc_nr_id.setId("lflgc_nr_id");
	getCpMaster().add(lflgc_nr_id);
        lgc_nr_id.setId("lgc_nr_id");
        lgc_nr_id.setMaxLength(22);
        getCpMaster().add(lgc_nr_id);

	LabelField lftra_nr_id = new LabelField("tra_nr_id:");
        lftra_nr_id.setId("lftra_nr_id");
	getCpMaster().add(lftra_nr_id);
        tra_nr_id.setId("tra_nr_id");
        tra_nr_id.setMaxLength(22);
        getCpMaster().add(tra_nr_id);

	LabelField lflgc_tx_classe = new LabelField("lgc_tx_classe:");
        lflgc_tx_classe.setId("lflgc_tx_classe");
	getCpMaster().add(lflgc_tx_classe);
        lgc_tx_classe.setId("lgc_tx_classe");
        lgc_tx_classe.setMaxLength(200);
        getCpMaster().add(lgc_tx_classe);

	LabelField lflgc_tx_status = new LabelField("lgc_tx_status:");
        lflgc_tx_status.setId("lflgc_tx_status");
	getCpMaster().add(lflgc_tx_status);
        lgc_tx_status.setId("lgc_tx_status");
        lgc_tx_status.setMaxLength(1);
        getCpMaster().add(lgc_tx_status);

	LabelField lflgc_nr_ordem = new LabelField("lgc_nr_ordem:");
        lflgc_nr_ordem.setId("lflgc_nr_ordem");
	getCpMaster().add(lflgc_nr_ordem);
        lgc_nr_ordem.setId("lgc_nr_ordem");
        lgc_nr_ordem.setMaxLength(22);
        getCpMaster().add(lgc_nr_ordem);

	LabelField lflgc_tx_descricao = new LabelField("lgc_tx_descricao:");
        lflgc_tx_descricao.setId("lflgc_tx_descricao");
	getCpMaster().add(lflgc_tx_descricao);
        lgc_tx_descricao.setId("lgc_tx_descricao");
        lgc_tx_descricao.setMaxLength(500);
        getCpMaster().add(lgc_tx_descricao);


    }

    public void load(Lgc_logicaTGWT lgc_logicaT) {
	this.lgc_logicaT = lgc_logicaT;
		lgc_nr_id.setValue(lgc_logicaT.getLgc_nr_id() + "");
		tra_nr_id.setValue(lgc_logicaT.getTra_nr_id() + "");
		lgc_tx_classe.setValue(lgc_logicaT.getLgc_tx_classe());
		lgc_tx_status.setValue(lgc_logicaT.getLgc_tx_status());
		lgc_nr_ordem.setValue(lgc_logicaT.getLgc_nr_ordem() + "");
		lgc_tx_descricao.setValue(lgc_logicaT.getLgc_tx_descricao());

    }
    public void btnUpdateAction(ButtonEvent ce) {
		lgc_logicaT.setLgc_nr_id( Integer.parseInt(lgc_nr_id.getValue()));
		lgc_logicaT.setTra_nr_id( Integer.parseInt(tra_nr_id.getValue()));
		lgc_logicaT.setLgc_tx_classe(lgc_tx_classe.getValue());
		lgc_logicaT.setLgc_tx_status(lgc_tx_status.getValue());
		lgc_logicaT.setLgc_nr_ordem( Integer.parseInt(lgc_nr_ordem.getValue()));
		lgc_logicaT.setLgc_tx_descricao(lgc_tx_descricao.getValue());

	lgc_logicaDao.alterar(lgc_logicaT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = lgc_logicaDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  lgc_logicaConsult.load();
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
		  lgc_logicaDao.excluir(lgc_logicaT);
		  Timer timer = new Timer() {
	   	    public void run() {
 	     		String msg = lgc_logicaDao.getMsg();
 	     		if (msg == null) {
			  schedule(500);
	     		} else {
			  if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  		MessageBox.alert("Problemas", msg, null);
			  } else {
		  		Info.display("Resultado", msg);
		  		lgc_logicaConsult.load();
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
     * @return the lgc_logicaConsult
     */
    public Lgc_logicaConsultGWT getLgc_logicaConsult() {
        return lgc_logicaConsult;
    }

    /**
     * @param lgc_logicaConsult the lgc_logicaConsult to set
     */
    public void setLgc_logicaConsult(Lgc_logicaConsultGWT lgc_logicaConsult) {
        this.lgc_logicaConsult = lgc_logicaConsult;
    }

}

