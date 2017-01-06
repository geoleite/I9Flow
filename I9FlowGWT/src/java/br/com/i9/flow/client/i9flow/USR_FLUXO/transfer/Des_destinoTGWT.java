
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
public class Des_destinoTGWT extends BaseModel {
  public Des_destinoTGWT() {
  }

  public int getDes_nr_id() {
    return  ((Integer)get("des_nr_id")).intValue();
  }

  public void setDes_nr_id(int des_nr_id) {
    set("des_nr_id", des_nr_id);
  }

  public String getDes_tx_tipo() {
    return  get("des_tx_tipo");
  }

  public void setDes_tx_tipo(String des_tx_tipo) {
    set("des_tx_tipo", des_tx_tipo);
  }

  public int getDes_nr_idregistro() {
    return  ((Integer)get("des_nr_idregistro")).intValue();
  }

  public void setDes_nr_idregistro(int des_nr_idregistro) {
    set("des_nr_idregistro", des_nr_idregistro);
  }



}

