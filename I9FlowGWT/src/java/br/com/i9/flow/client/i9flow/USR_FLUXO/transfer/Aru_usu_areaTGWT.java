
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
public class Aru_usu_areaTGWT extends BaseModel {
  public Aru_usu_areaTGWT() {
  }

  public int getUsu_nr_id() {
    return  ((Integer)get("usu_nr_id")).intValue();
  }

  public void setUsu_nr_id(int usu_nr_id) {
    set("usu_nr_id", usu_nr_id);
  }

  public int getAre_nr_id() {
    return  ((Integer)get("are_nr_id")).intValue();
  }

  public void setAre_nr_id(int are_nr_id) {
    set("are_nr_id", are_nr_id);
  }



}

