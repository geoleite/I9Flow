
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
public class Flx_fluxoTGWT extends BaseModel {
  public Flx_fluxoTGWT() {
  }

  public int getFlx_nr_id() {
    return  ((Integer)get("flx_nr_id")).intValue();
  }

  public void setFlx_nr_id(int flx_nr_id) {
    set("flx_nr_id", flx_nr_id);
  }

  public Date getFlx_dt_movimentacao() {
    return  (Date)get("flx_dt_movimentacao");
  }

  public void setFlx_dt_movimentacao(Date flx_dt_movimentacao) {
    set("flx_dt_movimentacao", flx_dt_movimentacao);
  }

  public int getUsu_nr_id() {
    return  ((Integer)get("usu_nr_id")).intValue();
  }

  public void setUsu_nr_id(int usu_nr_id) {
    set("usu_nr_id", usu_nr_id);
  }

  public String getFlx_tx_obs() {
    return  get("flx_tx_obs");
  }

  public void setFlx_tx_obs(String flx_tx_obs) {
    set("flx_tx_obs", flx_tx_obs);
  }

  public Date getFlx_dt_finalizado() {
    return  (Date)get("flx_dt_finalizado");
  }

  public void setFlx_dt_finalizado(Date flx_dt_finalizado) {
    set("flx_dt_finalizado", flx_dt_finalizado);
  }

  public int getFlx_nr_idanterior() {
    return  ((Integer)get("flx_nr_idanterior")).intValue();
  }

  public void setFlx_nr_idanterior(int flx_nr_idanterior) {
    set("flx_nr_idanterior", flx_nr_idanterior);
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



}

