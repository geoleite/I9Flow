
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
public class Tra_tramiteTGWT extends BaseModel {
  public Tra_tramiteTGWT() {
  }

  public int getTra_nr_id() {
    return  ((Integer)get("tra_nr_id")).intValue();
  }

  public void setTra_nr_id(int tra_nr_id) {
    set("tra_nr_id", tra_nr_id);
  }

  public int getDes_nr_id() {
    return  ((Integer)get("des_nr_id")).intValue();
  }

  public void setDes_nr_id(int des_nr_id) {
    set("des_nr_id", des_nr_id);
  }

  public int getTid_nr_id() {
    return  ((Integer)get("tid_nr_id")).intValue();
  }

  public void setTid_nr_id(int tid_nr_id) {
    set("tid_nr_id", tid_nr_id);
  }

  public int getUsu_nr_id() {
    return  ((Integer)get("usu_nr_id")).intValue();
  }

  public void setUsu_nr_id(int usu_nr_id) {
    set("usu_nr_id", usu_nr_id);
  }

  public String getTra_tx_nome() {
    return  get("tra_tx_nome");
  }

  public void setTra_tx_nome(String tra_tx_nome) {
    set("tra_tx_nome", tra_tx_nome);
  }

  public String getTra_tx_automatico() {
    return  get("tra_tx_automatico");
  }

  public void setTra_tx_automatico(String tra_tx_automatico) {
    set("tra_tx_automatico", tra_tx_automatico);
  }



}

