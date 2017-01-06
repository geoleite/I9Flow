/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.flow.client.i9flow.USR_FLUXO.vw_tra_flx_usu;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.Vw_tra_flx_usuDAOGWT;

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
public class Vw_tra_flx_usuInsertGWT extends CadastrarBaseGWT {

    private Vw_tra_flx_usuConsultGWT vw_tra_flx_usuConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Vw_tra_flx_usuDAOGWT vw_tra_flx_usuDao = new Vw_tra_flx_usuDAOGWT();
    private EasyTextField<String> tra_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tra_nr_idsuper = new EasyTextField<String>();
    private EasyTextField<String> des_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tra_nr_ordem = new EasyTextField<String>();
    private EasyTextField<String> tra_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> tra_usu_nr_id = new EasyTextField<String>();
    private DateField flx_dt_movimentacao = new DateField();
    private DateField flx_dt_finalizado = new DateField();
    private EasyTextField<String> flx_tx_obs = new EasyTextField<String>();
    private EasyTextField<String> usu_nr_id = new EasyTextField<String>();
    private EasyTextField<String> usu_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> usu_tx_login = new EasyTextField<String>();
    private EasyTextField<String> usu_tx_senha = new EasyTextField<String>();
    private EasyTextField<String> usu_tx_status = new EasyTextField<String>();
    private EasyTextField<String> usu_tx_email = new EasyTextField<String>();

    public Vw_tra_flx_usuInsertGWT() {
        setHeading("Cadastrar Vw_tra_flx_usu");
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

        LabelField lftra_nr_idsuper = new LabelField("tra_nr_idsuper:");
        lftra_nr_idsuper.setId("lftra_nr_idsuper");
        getCpMaster().add(lftra_nr_idsuper);
        tra_nr_idsuper.setId("tra_nr_idsuper");
        tra_nr_idsuper.setMaxLength(22);
        getCpMaster().add(tra_nr_idsuper);

        LabelField lfdes_nr_id = new LabelField("des_nr_id:");
        lfdes_nr_id.setId("lfdes_nr_id");
        getCpMaster().add(lfdes_nr_id);
        des_nr_id.setId("des_nr_id");
        des_nr_id.setMaxLength(22);
        getCpMaster().add(des_nr_id);

        LabelField lftra_nr_ordem = new LabelField("tra_nr_ordem:");
        lftra_nr_ordem.setId("lftra_nr_ordem");
        getCpMaster().add(lftra_nr_ordem);
        tra_nr_ordem.setId("tra_nr_ordem");
        tra_nr_ordem.setMaxLength(22);
        getCpMaster().add(tra_nr_ordem);

        LabelField lftra_tx_nome = new LabelField("tra_tx_nome:");
        lftra_tx_nome.setId("lftra_tx_nome");
        getCpMaster().add(lftra_tx_nome);
        tra_tx_nome.setId("tra_tx_nome");
        tra_tx_nome.setMaxLength(100);
        getCpMaster().add(tra_tx_nome);

        LabelField lftra_usu_nr_id = new LabelField("tra_usu_nr_id:");
        lftra_usu_nr_id.setId("lftra_usu_nr_id");
        getCpMaster().add(lftra_usu_nr_id);
        tra_usu_nr_id.setId("tra_usu_nr_id");
        tra_usu_nr_id.setMaxLength(22);
        getCpMaster().add(tra_usu_nr_id);

        LabelField lfflx_dt_movimentacao = new LabelField("flx_dt_movimentacao:");
        lfflx_dt_movimentacao.setId("lfflx_dt_movimentacao");
        getCpMaster().add(lfflx_dt_movimentacao);
        flx_dt_movimentacao.setId("flx_dt_movimentacao");
        flx_dt_movimentacao.setMaxLength(11);
        getCpMaster().add(flx_dt_movimentacao);

        LabelField lfflx_dt_finalizado = new LabelField("flx_dt_finalizado:");
        lfflx_dt_finalizado.setId("lfflx_dt_finalizado");
        getCpMaster().add(lfflx_dt_finalizado);
        flx_dt_finalizado.setId("flx_dt_finalizado");
        flx_dt_finalizado.setMaxLength(11);
        getCpMaster().add(flx_dt_finalizado);

        LabelField lfflx_tx_obs = new LabelField("flx_tx_obs:");
        lfflx_tx_obs.setId("lfflx_tx_obs");
        getCpMaster().add(lfflx_tx_obs);
        flx_tx_obs.setId("flx_tx_obs");
        flx_tx_obs.setMaxLength(4000);
        getCpMaster().add(flx_tx_obs);

        LabelField lfusu_nr_id = new LabelField("usu_nr_id:");
        lfusu_nr_id.setId("lfusu_nr_id");
        getCpMaster().add(lfusu_nr_id);
        usu_nr_id.setId("usu_nr_id");
        usu_nr_id.setMaxLength(22);
        getCpMaster().add(usu_nr_id);

        LabelField lfusu_tx_nome = new LabelField("usu_tx_nome:");
        lfusu_tx_nome.setId("lfusu_tx_nome");
        getCpMaster().add(lfusu_tx_nome);
        usu_tx_nome.setId("usu_tx_nome");
        usu_tx_nome.setMaxLength(80);
        getCpMaster().add(usu_tx_nome);

        LabelField lfusu_tx_login = new LabelField("usu_tx_login:");
        lfusu_tx_login.setId("lfusu_tx_login");
        getCpMaster().add(lfusu_tx_login);
        usu_tx_login.setId("usu_tx_login");
        usu_tx_login.setMaxLength(20);
        getCpMaster().add(usu_tx_login);

        LabelField lfusu_tx_senha = new LabelField("usu_tx_senha:");
        lfusu_tx_senha.setId("lfusu_tx_senha");
        getCpMaster().add(lfusu_tx_senha);
        usu_tx_senha.setId("usu_tx_senha");
        usu_tx_senha.setMaxLength(4000);
        getCpMaster().add(usu_tx_senha);

        LabelField lfusu_tx_status = new LabelField("usu_tx_status:");
        lfusu_tx_status.setId("lfusu_tx_status");
        getCpMaster().add(lfusu_tx_status);
        usu_tx_status.setId("usu_tx_status");
        usu_tx_status.setMaxLength(1);
        getCpMaster().add(usu_tx_status);

        LabelField lfusu_tx_email = new LabelField("usu_tx_email:");
        lfusu_tx_email.setId("lfusu_tx_email");
        getCpMaster().add(lfusu_tx_email);
        usu_tx_email.setId("usu_tx_email");
        usu_tx_email.setMaxLength(150);
        getCpMaster().add(usu_tx_email);


    }

    public void btnInsertAction(ButtonEvent ce) {
    }

    public void btnLimpartAction(ButtonEvent ce) {
        tra_nr_id.setValue("");
        tra_nr_idsuper.setValue("");
        des_nr_id.setValue("");
        tra_nr_ordem.setValue("");
        tra_tx_nome.setValue("");
        tra_usu_nr_id.setValue("");
        flx_dt_movimentacao.setValue(null);
        flx_dt_finalizado.setValue(null);
        flx_tx_obs.setValue("");
        usu_nr_id.setValue("");
        usu_tx_nome.setValue("");
        usu_tx_login.setValue("");
        usu_tx_senha.setValue("");
        usu_tx_status.setValue("");
        usu_tx_email.setValue("");

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
