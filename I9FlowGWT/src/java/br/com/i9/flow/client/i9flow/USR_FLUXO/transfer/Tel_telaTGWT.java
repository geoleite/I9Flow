
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
public class Tel_telaTGWT extends BaseModel {
  public Tel_telaTGWT() {
  }

  public int getTel_nr_id() {
    return  ((Integer)get("tel_nr_id")).intValue();
  }

  public void setTel_nr_id(int tel_nr_id) {
    set("tel_nr_id", tel_nr_id);
  }

  public String getTel_tx_nome() {
    return  get("tel_tx_nome");
  }

  public void setTel_tx_nome(String tel_tx_nome) {
    set("tel_tx_nome", tel_tx_nome);
  }



}

