
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
public class Doc_documentoTGWT extends BaseModel {
  public Doc_documentoTGWT() {
  }

  public int getDoc_nr_id() {
    return  ((Integer)get("doc_nr_id")).intValue();
  }

  public void setDoc_nr_id(int doc_nr_id) {
    set("doc_nr_id", doc_nr_id);
  }

  public int getFlx_nr_id() {
    return  ((Integer)get("flx_nr_id")).intValue();
  }

  public void setFlx_nr_id(int flx_nr_id) {
    set("flx_nr_id", flx_nr_id);
  }



}

