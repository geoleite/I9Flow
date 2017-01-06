
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
public class Are_areaTGWT extends BaseModel {
  public Are_areaTGWT() {
  }

  public int getAre_nr_id() {
    return  ((Integer)get("are_nr_id")).intValue();
  }

  public void setAre_nr_id(int are_nr_id) {
    set("are_nr_id", are_nr_id);
  }

  public String getAre_tx_nome() {
    return  get("are_tx_nome");
  }

  public void setAre_tx_nome(String are_tx_nome) {
    set("are_tx_nome", are_tx_nome);
  }



}

