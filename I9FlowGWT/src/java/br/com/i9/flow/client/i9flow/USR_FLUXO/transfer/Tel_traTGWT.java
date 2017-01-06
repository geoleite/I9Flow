
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
public class Tel_traTGWT extends BaseModel {
  public Tel_traTGWT() {
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



}

