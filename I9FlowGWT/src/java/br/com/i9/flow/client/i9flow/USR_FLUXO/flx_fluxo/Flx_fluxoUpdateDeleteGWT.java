package br.com.i9.flow.client.i9flow.USR_FLUXO.flx_fluxo;

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
public class Flx_fluxoUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Flx_fluxoConsultGWT flx_fluxoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Flx_fluxoDAOGWT flx_fluxoDao = new Flx_fluxoDAOGWT();
    private Flx_fluxoTGWT flx_fluxoT;
    private EasyTextField<String> flx_nr_id = new EasyTextField<String>();
    private DateField flx_dt_movimentacao = new DateField();
    private EasyTextField<String> tra_nr_id = new EasyTextField<String>();
    private EasyTextField<String> flx_tx_obs = new EasyTextField<String>();
    private DateField flx_dt_finalizado = new DateField();
    private EasyTextField<String> flx_nr_idanterior = new EasyTextField<String>();
    private EasyTextField<String> tra_nr_idorigem = new EasyTextField<String>();
    private EasyTextField<String> tra_nr_iddestino = new EasyTextField<String>();

    public Flx_fluxoUpdateDeleteGWT() {
        setHeading("Alterar Flx_fluxo");
        this.setSize("500", "400");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);
        LabelField lfflx_nr_id = new LabelField("flx_nr_id:");
        lfflx_nr_id.setId("lfflx_nr_id");
        getCpMaster().add(lfflx_nr_id);
        flx_nr_id.setId("flx_nr_id");
        flx_nr_id.setMaxLength(22);
        getCpMaster().add(flx_nr_id);

        LabelField lfflx_dt_movimentacao = new LabelField("flx_dt_movimentacao:");
        lfflx_dt_movimentacao.setId("lfflx_dt_movimentacao");
        getCpMaster().add(lfflx_dt_movimentacao);
        flx_dt_movimentacao.setId("flx_dt_movimentacao");
        flx_dt_movimentacao.setMaxLength(11);
        getCpMaster().add(flx_dt_movimentacao);

        LabelField lftra_nr_id = new LabelField("tra_nr_id:");
        lftra_nr_id.setId("lftra_nr_id");
        getCpMaster().add(lftra_nr_id);
        tra_nr_id.setId("tra_nr_id");
        tra_nr_id.setMaxLength(22);
        getCpMaster().add(tra_nr_id);

        LabelField lfflx_tx_obs = new LabelField("flx_tx_obs:");
        lfflx_tx_obs.setId("lfflx_tx_obs");
        getCpMaster().add(lfflx_tx_obs);
        flx_tx_obs.setId("flx_tx_obs");
        flx_tx_obs.setMaxLength(4000);
        getCpMaster().add(flx_tx_obs);

        LabelField lfflx_dt_finalizado = new LabelField("flx_dt_finalizado:");
        lfflx_dt_finalizado.setId("lfflx_dt_finalizado");
        getCpMaster().add(lfflx_dt_finalizado);
        flx_dt_finalizado.setId("flx_dt_finalizado");
        flx_dt_finalizado.setMaxLength(11);
        getCpMaster().add(flx_dt_finalizado);

        LabelField lfflx_nr_idanterior = new LabelField("flx_nr_idanterior:");
        lfflx_nr_idanterior.setId("lfflx_nr_idanterior");
        getCpMaster().add(lfflx_nr_idanterior);
        flx_nr_idanterior.setId("flx_nr_idanterior");
        flx_nr_idanterior.setMaxLength(22);
        getCpMaster().add(flx_nr_idanterior);

        LabelField lftra_nr_idorigem = new LabelField("tra_nr_idorigem:");
        lftra_nr_idorigem.setId("lftra_nr_idorigem");
        getCpMaster().add(lftra_nr_idorigem);
        tra_nr_idorigem.setId("tra_nr_idorigem");
        tra_nr_idorigem.setMaxLength(22);
        getCpMaster().add(tra_nr_idorigem);

        LabelField lftra_nr_iddestino = new LabelField("tra_nr_iddestino:");
        lftra_nr_iddestino.setId("lftra_nr_iddestino");
        getCpMaster().add(lftra_nr_iddestino);
        tra_nr_iddestino.setId("tra_nr_iddestino");
        tra_nr_iddestino.setMaxLength(22);
        getCpMaster().add(tra_nr_iddestino);


    }

    public void load(Flx_fluxoTGWT flx_fluxoT) {
        this.flx_fluxoT = flx_fluxoT;
        flx_nr_id.setValue(flx_fluxoT.getFlx_nr_id() + "");
        flx_dt_movimentacao.setValue(flx_fluxoT.getFlx_dt_movimentacao());
        tra_nr_id.setValue(flx_fluxoT.getUsu_nr_id() + "");
        flx_tx_obs.setValue(flx_fluxoT.getFlx_tx_obs());
        flx_dt_finalizado.setValue(flx_fluxoT.getFlx_dt_finalizado());
        flx_nr_idanterior.setValue(flx_fluxoT.getFlx_nr_idanterior() + "");
        tra_nr_idorigem.setValue(flx_fluxoT.getTra_nr_idorigem() + "");
        tra_nr_iddestino.setValue(flx_fluxoT.getTra_nr_iddestino() + "");

    }

    public void btnUpdateAction(ButtonEvent ce) {
        flx_fluxoT.setFlx_nr_id(Integer.parseInt(flx_nr_id.getValue()));
        flx_fluxoT.setFlx_dt_movimentacao(flx_dt_movimentacao.getValue());
        flx_fluxoT.setUsu_nr_id(Integer.parseInt(tra_nr_id.getValue()));
        flx_fluxoT.setFlx_tx_obs(flx_tx_obs.getValue());
        flx_fluxoT.setFlx_dt_finalizado(flx_dt_finalizado.getValue());
        flx_fluxoT.setFlx_nr_idanterior(Integer.parseInt(flx_nr_idanterior.getValue()));
        flx_fluxoT.setTra_nr_idorigem(Integer.parseInt(tra_nr_idorigem.getValue()));
        flx_fluxoT.setTra_nr_iddestino(Integer.parseInt(tra_nr_iddestino.getValue()));

        flx_fluxoDao.alterar(flx_fluxoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = flx_fluxoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        flx_fluxoConsult.load();
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
                    flx_fluxoDao.excluir(flx_fluxoT);
                    Timer timer = new Timer() {

                        public void run() {
                            String msg = flx_fluxoDao.getMsg();
                            if (msg == null) {
                                schedule(500);
                            } else {
                                if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                    MessageBox.alert("Problemas", msg, null);
                                } else {
                                    Info.display("Resultado", msg);
                                    flx_fluxoConsult.load();
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
     * @return the flx_fluxoConsult
     */
    public Flx_fluxoConsultGWT getFlx_fluxoConsult() {
        return flx_fluxoConsult;
    }

    /**
     * @param flx_fluxoConsult the flx_fluxoConsult to set
     */
    public void setFlx_fluxoConsult(Flx_fluxoConsultGWT flx_fluxoConsult) {
        this.flx_fluxoConsult = flx_fluxoConsult;
    }
}
