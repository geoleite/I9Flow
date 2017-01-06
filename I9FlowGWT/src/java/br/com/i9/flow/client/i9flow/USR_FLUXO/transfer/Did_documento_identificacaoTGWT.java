
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
public class Did_documento_identificacaoTGWT extends BaseModel {
  public Did_documento_identificacaoTGWT() {
  }

  public int getDid_nr_id() {
    return  ((Integer)get("did_nr_id")).intValue();
  }

  public void setDid_nr_id(int did_nr_id) {
    set("did_nr_id", did_nr_id);
  }

  public int getFlx_nr_id() {
    return  ((Integer)get("flx_nr_id")).intValue();
  }

  public void setFlx_nr_id(int flx_nr_id) {
    set("flx_nr_id", flx_nr_id);
  }

  public String getDid_tx_nomecoluna() {
    return  get("did_tx_nomecoluna");
  }

  public void setDid_tx_nomecoluna(String did_tx_nomecoluna) {
    set("did_tx_nomecoluna", did_tx_nomecoluna);
  }

  public String getDid_tx_valor() {
    return  get("did_tx_valor");
  }

  public void setDid_tx_valor(String did_tx_valor) {
    set("did_tx_valor", did_tx_valor);
  }



}

