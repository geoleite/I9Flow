
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
public class Opt_opcao_tramiteTGWT extends BaseModel {
  public Opt_opcao_tramiteTGWT() {
  }

  public int getTra_nr_idorigem() {
    return  ((Integer)get("tra_nr_idorigem")).intValue();
  }

  public void setTra_nr_idorigem(int tra_nr_idorigem) {
    set("tra_nr_idorigem", tra_nr_idorigem);
  }

  public int getTra_nr_iddestino() {
    return  ((Integer)get("tra_nr_iddestino")).intValue();
  }

  public void setTra_nr_iddestino(int tra_nr_iddestino) {
    set("tra_nr_iddestino", tra_nr_iddestino);
  }

  public int getOpt_nr_ordem() {
    return  ((Integer)get("opt_nr_ordem")).intValue();
  }

  public void setOpt_nr_ordem(int opt_nr_ordem) {
    set("opt_nr_ordem", opt_nr_ordem);
  }

  public String getOpt_tx_retorno() {
    return  get("opt_tx_retorno");
  }

  public void setOpt_tx_retorno(String opt_tx_retorno) {
    set("opt_tx_retorno", opt_tx_retorno);
  }

  public String getOpt_tx_nome() {
    return  get("opt_tx_nome");
  }

  public void setOpt_tx_nome(String opt_tx_nome) {
    set("opt_tx_nome", opt_tx_nome);
  }



}

