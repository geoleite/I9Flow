package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Flx_fluxoT {

    private int flx_nr_id;
    private int usu_nr_id;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date flx_dt_movimentacao;
    private String flx_tx_obs;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date flx_dt_finalizado;
    private int flx_nr_idanterior;
    private int tra_nr_idorigem;
    private int tra_nr_iddestino;

    public void setFlx_nr_id(int flx_nr_id) {
        this.flx_nr_id = flx_nr_id;
    }

    public int getFlx_nr_id() {
        return flx_nr_id;
    }

    public void setFlx_dt_movimentacao(java.util.Date flx_dt_movimentacao) {
        this.flx_dt_movimentacao = flx_dt_movimentacao;
    }

    public java.util.Date getFlx_dt_movimentacao() {
        return flx_dt_movimentacao;
    }

    public void setFlx_tx_obs(String flx_tx_obs) {
        this.flx_tx_obs = flx_tx_obs;
    }

    public String getFlx_tx_obs() {
        return flx_tx_obs;
    }

    public void setFlx_dt_finalizado(java.util.Date flx_dt_finalizado) {
        this.flx_dt_finalizado = flx_dt_finalizado;
    }

    public java.util.Date getFlx_dt_finalizado() {
        return flx_dt_finalizado;
    }

    public void setFlx_nr_idanterior(int flx_nr_idanterior) {
        this.flx_nr_idanterior = flx_nr_idanterior;
    }

    public int getFlx_nr_idanterior() {
        return flx_nr_idanterior;
    }

    public void setTra_nr_idorigem(int tra_nr_idorigem) {
        this.tra_nr_idorigem = tra_nr_idorigem;
    }

    public int getTra_nr_idorigem() {
        return tra_nr_idorigem;
    }

    public void setTra_nr_iddestino(int tra_nr_iddestino) {
        this.tra_nr_iddestino = tra_nr_iddestino;
    }

    public int getTra_nr_iddestino() {
        return tra_nr_iddestino;
    }

    /**
     * @return the usu_nr_id
     */
    public int getUsu_nr_id() {
        return usu_nr_id;
    }

    /**
     * @param usu_nr_id the usu_nr_id to set
     */
    public void setUsu_nr_id(int usu_nr_id) {
        this.usu_nr_id = usu_nr_id;
    }
}
