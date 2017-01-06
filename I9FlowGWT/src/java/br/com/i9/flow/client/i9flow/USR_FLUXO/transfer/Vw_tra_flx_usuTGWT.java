
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
public class Vw_tra_flx_usuTGWT extends BaseModel {
  public Vw_tra_flx_usuTGWT() {
  }

  public int getTra_nr_id() {
    return  ((Integer)get("tra_nr_id")).intValue();
  }

  public void setTra_nr_id(int tra_nr_id) {
    set("tra_nr_id", tra_nr_id);
  }

  public int getDes_nr_id() {
    return  ((Integer)get("des_nr_id")).intValue();
  }

  public void setDes_nr_id(int des_nr_id) {
    set("des_nr_id", des_nr_id);
  }

  public int getTid_nr_id() {
    return  ((Integer)get("tid_nr_id")).intValue();
  }

  public void setTid_nr_id(int tid_nr_id) {
    set("tid_nr_id", tid_nr_id);
  }

  public int getUsu_nr_idowner() {
    return  ((Integer)get("usu_nr_idowner")).intValue();
  }

  public void setUsu_nr_idowner(int usu_nr_idowner) {
    set("usu_nr_idowner", usu_nr_idowner);
  }

  public String getTra_tx_nome() {
    return  get("tra_tx_nome");
  }

  public void setTra_tx_nome(String tra_tx_nome) {
    set("tra_tx_nome", tra_tx_nome);
  }

  public String getTra_tx_automatico() {
    return  get("tra_tx_automatico");
  }

  public void setTra_tx_automatico(String tra_tx_automatico) {
    set("tra_tx_automatico", tra_tx_automatico);
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

  public int getUsu_nr_id() {
    return  ((Integer)get("usu_nr_id")).intValue();
  }

  public void setUsu_nr_id(int usu_nr_id) {
    set("usu_nr_id", usu_nr_id);
  }

  public String getUsu_tx_nome() {
    return  get("usu_tx_nome");
  }

  public void setUsu_tx_nome(String usu_tx_nome) {
    set("usu_tx_nome", usu_tx_nome);
  }

  public String getUsu_tx_login() {
    return  get("usu_tx_login");
  }

  public void setUsu_tx_login(String usu_tx_login) {
    set("usu_tx_login", usu_tx_login);
  }

  public String getUsu_tx_status() {
    return  get("usu_tx_status");
  }

  public void setUsu_tx_status(String usu_tx_status) {
    set("usu_tx_status", usu_tx_status);
  }

  public String getUsu_tx_email() {
    return  get("usu_tx_email");
  }

  public void setUsu_tx_email(String usu_tx_email) {
    set("usu_tx_email", usu_tx_email);
  }

  public void setIds(String ids) {
    set("ids", ids);
  }

  public String getIds() {
    return get("ids");
  }
}

