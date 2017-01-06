
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
public class Tid_tipo_documentoTGWT extends BaseModel {
  public Tid_tipo_documentoTGWT() {
  }

  public int getTid_nr_id() {
    return  ((Integer)get("tid_nr_id")).intValue();
  }

  public void setTid_nr_id(int tid_nr_id) {
    set("tid_nr_id", tid_nr_id);
  }

  public String getTid_tx_nome() {
    return  get("tid_tx_nome");
  }

  public void setTid_tx_nome(String tid_tx_nome) {
    set("tid_tx_nome", tid_tx_nome);
  }

  public int getTra_nr_id() {
    return  ((Integer)get("tra_nr_id")).intValue();
  }

  public void setTra_nr_id(int tra_nr_id) {
    set("tra_nr_id", tra_nr_id);
  }



}

