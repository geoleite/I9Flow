package br.com.i9.flow.client.i9flow.USR_FLUXO.des_destino;

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
public class Des_destinoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Des_destinoConsultGWT des_destinoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Des_destinoDAOGWT des_destinoDao = new Des_destinoDAOGWT();
    private Des_destinoTGWT des_destinoT;

    private EasyTextField<String> des_nr_id = new EasyTextField<String>();
    private EasyTextField<String> des_tx_tipo = new EasyTextField<String>();
    private EasyTextField<String> des_nr_idregistro = new EasyTextField<String>();


    public Des_destinoUpdateDeleteGWT() {
        setHeading("Alterar Des_destino");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);
	LabelField lfdes_nr_id = new LabelField("des_nr_id:");
        lfdes_nr_id.setId("lfdes_nr_id");
	getCpMaster().add(lfdes_nr_id);
        des_nr_id.setId("des_nr_id");
        des_nr_id.setMaxLength(22);
        getCpMaster().add(des_nr_id);

	LabelField lfdes_tx_tipo = new LabelField("des_tx_tipo:");
        lfdes_tx_tipo.setId("lfdes_tx_tipo");
	getCpMaster().add(lfdes_tx_tipo);
        des_tx_tipo.setId("des_tx_tipo");
        des_tx_tipo.setMaxLength(1);
        getCpMaster().add(des_tx_tipo);

	LabelField lfdes_nr_idregistro = new LabelField("des_nr_idregistro:");
        lfdes_nr_idregistro.setId("lfdes_nr_idregistro");
	getCpMaster().add(lfdes_nr_idregistro);
        des_nr_idregistro.setId("des_nr_idregistro");
        des_nr_idregistro.setMaxLength(22);
        getCpMaster().add(des_nr_idregistro);


    }

    public void load(Des_destinoTGWT des_destinoT) {
	this.des_destinoT = des_destinoT;
		des_nr_id.setValue(des_destinoT.getDes_nr_id() + "");
		des_tx_tipo.setValue(des_destinoT.getDes_tx_tipo());
		des_nr_idregistro.setValue(des_destinoT.getDes_nr_idregistro() + "");

    }
    public void btnUpdateAction(ButtonEvent ce) {
		des_destinoT.setDes_nr_id( Integer.parseInt(des_nr_id.getValue()));
		des_destinoT.setDes_tx_tipo(des_tx_tipo.getValue());
		des_destinoT.setDes_nr_idregistro( Integer.parseInt(des_nr_idregistro.getValue()));

	des_destinoDao.alterar(des_destinoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = des_destinoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  des_destinoConsult.load();
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
		  des_destinoDao.excluir(des_destinoT);
		  Timer timer = new Timer() {
	   	    public void run() {
 	     		String msg = des_destinoDao.getMsg();
 	     		if (msg == null) {
			  schedule(500);
	     		} else {
			  if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  		MessageBox.alert("Problemas", msg, null);
			  } else {
		  		Info.display("Resultado", msg);
		  		des_destinoConsult.load();
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
     * @return the des_destinoConsult
     */
    public Des_destinoConsultGWT getDes_destinoConsult() {
        return des_destinoConsult;
    }

    /**
     * @param des_destinoConsult the des_destinoConsult to set
     */
    public void setDes_destinoConsult(Des_destinoConsultGWT des_destinoConsult) {
        this.des_destinoConsult = des_destinoConsult;
    }

}

