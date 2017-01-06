
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
public class Lgc_logicaTGWT extends BaseModel {
  public Lgc_logicaTGWT() {
  }

  public int getLgc_nr_id() {
    return  ((Integer)get("lgc_nr_id")).intValue();
  }

  public void setLgc_nr_id(int lgc_nr_id) {
    set("lgc_nr_id", lgc_nr_id);
  }

  public int getTra_nr_id() {
    return  ((Integer)get("tra_nr_id")).intValue();
  }

  public void setTra_nr_id(int tra_nr_id) {
    set("tra_nr_id", tra_nr_id);
  }

  public String getLgc_tx_classe() {
    return  get("lgc_tx_classe");
  }

  public void setLgc_tx_classe(String lgc_tx_classe) {
    set("lgc_tx_classe", lgc_tx_classe);
  }

  public String getLgc_tx_status() {
    return  get("lgc_tx_status");
  }

  public void setLgc_tx_status(String lgc_tx_status) {
    set("lgc_tx_status", lgc_tx_status);
  }

  public int getLgc_nr_ordem() {
    return  ((Integer)get("lgc_nr_ordem")).intValue();
  }

  public void setLgc_nr_ordem(int lgc_nr_ordem) {
    set("lgc_nr_ordem", lgc_nr_ordem);
  }

  public String getLgc_tx_descricao() {
    return  get("lgc_tx_descricao");
  }

  public void setLgc_tx_descricao(String lgc_tx_descricao) {
    set("lgc_tx_descricao", lgc_tx_descricao);
  }



}

