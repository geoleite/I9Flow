package br.com.i9.flow.client.i9flow.USR_FLUXO.vw_tra_flx_usu;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.*;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import com.extjs.gxt.ui.client.Style.Orientation;

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
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;

/**
 *
 * @author geoleite
 */
public class Vw_tra_flx_usuUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Vw_tra_flx_usuConsultGWT vw_tra_flx_usuConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Vw_tra_flx_usuDAOGWT vw_tra_flx_usuDao = new Vw_tra_flx_usuDAOGWT();
    private Vw_tra_flx_usuTGWT vw_tra_flx_usuT;
    private EasyTextField<String> tra_tx_nome = new EasyTextField<String>();
    private DateField flx_dt_movimentacao = new DateField();
    private DateField flx_dt_finalizado = new DateField();
    private TextArea flx_tx_obs = new TextArea();
    private EasyTextField<String> usu_tx_nome = new EasyTextField<String>();

    public Vw_tra_flx_usuUpdateDeleteGWT() {
        setHeading("Visualisar Tramite");
        this.setSize("500", "400");
        setModal(true);
        getBtnUpdate().setVisible(false);
        getBtnDel().setVisible(false);
//        TableLayout tl = new TableLayout(2);
//        tl.setCellPadding(4);
//        getCpMaster().setLayout(tl);

        getCpMaster().setLayout(new RowLayout(Orientation.VERTICAL));
        
        LabelField lftra_tx_nome = new LabelField("Nome:");
        lftra_tx_nome.setId("lftra_tx_nome");
        getCpMaster().add(lftra_tx_nome);
        tra_tx_nome.setId("tra_tx_nome");
        tra_tx_nome.setMaxLength(100);
        getCpMaster().add(tra_tx_nome);

        LabelField lfflx_dt_movimentacao = new LabelField("Recebido:");
        lfflx_dt_movimentacao.setId("lfflx_dt_movimentacao");
        getCpMaster().add(lfflx_dt_movimentacao);
        flx_dt_movimentacao.setId("flx_dt_movimentacao");
        flx_dt_movimentacao.setMaxLength(11);
        getCpMaster().add(flx_dt_movimentacao);

        LabelField lfflx_dt_finalizado = new LabelField("Finalizado:");
        lfflx_dt_finalizado.setId("lfflx_dt_finalizado");
        getCpMaster().add(lfflx_dt_finalizado);
        flx_dt_finalizado.setId("flx_dt_finalizado");
        flx_dt_finalizado.setMaxLength(11);
        getCpMaster().add(flx_dt_finalizado);

        LabelField lfusu_tx_nome = new LabelField("Usuário:");
        lfusu_tx_nome.setId("lfusu_tx_nome");
        getCpMaster().add(lfusu_tx_nome);
        usu_tx_nome.setId("usu_tx_nome");
        usu_tx_nome.setMaxLength(80);
        getCpMaster().add(usu_tx_nome);

        LabelField lfflx_tx_obs = new LabelField("Observação:");
        lfflx_tx_obs.setId("lfflx_tx_obs");
        getCpMaster().add(lfflx_tx_obs);
        flx_tx_obs.setId("flx_tx_obs");
        flx_tx_obs.setMaxLength(4000);
        flx_tx_obs.setWidth(400);
        
        getCpMaster().add(flx_tx_obs);

        tra_tx_nome.setReadOnly(true);
        flx_dt_movimentacao.setReadOnly(true);
        flx_dt_finalizado.setReadOnly(true);
        usu_tx_nome.setReadOnly(true);
        flx_tx_obs.setReadOnly(true);

    }

    public void load(Vw_tra_flx_usuTGWT vw_tra_flx_usuT) {
        tra_tx_nome.setValue(vw_tra_flx_usuT.getTra_tx_nome());
        flx_dt_movimentacao.setValue(vw_tra_flx_usuT.getFlx_dt_movimentacao());
        if (vw_tra_flx_usuT.getFlx_dt_finalizado() != null) {
            flx_dt_finalizado.setValue(vw_tra_flx_usuT.getFlx_dt_finalizado());
        }
        usu_tx_nome.setValue(vw_tra_flx_usuT.getUsu_tx_nome());
        String obs = vw_tra_flx_usuT.getFlx_tx_obs();
        if (obs == null) {
            obs = "";
        } else {
            obs = obs.replaceAll("#", "\n\r");
        }
        flx_tx_obs.setValue(obs);
    }

    public void btnUpdateAction(ButtonEvent ce) {

    }

    public void btnDeltAction(ButtonEvent ce) {

        MessageBox.confirm("Aviso", "Tem certeza que deseja excluir registro?", new Listener<MessageBoxEvent>() {

            public void handleEvent(MessageBoxEvent be) {

                if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {
                    vw_tra_flx_usuDao.excluir(vw_tra_flx_usuT);
                    Timer timer = new Timer() {

                        public void run() {
                            String msg = vw_tra_flx_usuDao.getMsg();
                            if (msg == null) {
                                schedule(500);
                            } else {
                                if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                    MessageBox.alert("Problemas", msg, null);
                                } else {
                                    Info.display("Resultado", msg);
                                    vw_tra_flx_usuConsult.load();
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
     * @return the vw_tra_flx_usuConsult
     */
    public Vw_tra_flx_usuConsultGWT getVw_tra_flx_usuConsult() {
        return vw_tra_flx_usuConsult;
    }

    /**
     * @param vw_tra_flx_usuConsult the vw_tra_flx_usuConsult to set
     */
    public void setVw_tra_flx_usuConsult(Vw_tra_flx_usuConsultGWT vw_tra_flx_usuConsult) {
        this.vw_tra_flx_usuConsult = vw_tra_flx_usuConsult;
    }
}
