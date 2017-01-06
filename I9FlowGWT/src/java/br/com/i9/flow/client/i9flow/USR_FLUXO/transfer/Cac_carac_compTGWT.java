
/*
 * EasyNet JDragon
 */

package br.com.i9.flow.client.i9flow.USR_FLUXO.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Cac_carac_compTGWT extends BaseModel {
  public Cac_carac_compTGWT() {
  }

  public int getTra_nr_id() {
    return  ((Integer)get("tra_nr_id")).intValue();
  }

  public void setTra_nr_id(int tra_nr_id) {
    set("tra_nr_id", tra_nr_id);
  }

  public int getTel_nr_id() {
    return  ((Integer)get("tel_nr_id")).intValue();
  }

  public void setTel_nr_id(int tel_nr_id) {
    set("tel_nr_id", tel_nr_id);
  }

  public int getCac_nr_id() {
    return  ((Integer)get("cac_nr_id")).intValue();
  }

  public void setCac_nr_id(int cac_nr_id) {
    set("cac_nr_id", cac_nr_id);
  }

  public String getCac_tx_idcomponente() {
    return  get("cac_tx_idcomponente");
  }

  public void setCac_tx_idcomponente(String cac_tx_idcomponente) {
    set("cac_tx_idcomponente", cac_tx_idcomponente);
  }

  public String getCac_tx_visivel() {
    return  get("cac_tx_visivel");
  }

  public void setCac_tx_visivel(String cac_tx_visivel) {
    set("cac_tx_visivel", cac_tx_visivel);
  }

  public String getCac_tx_habilitado() {
    return  get("cac_tx_habilitado");
  }

  public void setCac_tx_habilitado(String cac_tx_habilitado) {
    set("cac_tx_habilitado", cac_tx_habilitado);
  }

  public String getCac_tx_editavel() {
    return  get("cac_tx_editavel");
  }

  public void setCac_tx_editavel(String cac_tx_editavel) {
    set("cac_tx_editavel", cac_tx_editavel);
  }



}

