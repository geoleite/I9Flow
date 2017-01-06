package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Vw_tra_flx_usuT {

    private int tra_nr_id;
    private int des_nr_id;
    private int tid_nr_id;
    private int usu_nr_idowner;
    private String tra_tx_nome;
    private String tra_tx_automatico;
    private int flx_nr_id;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy HH:mm")
    private java.util.Date flx_dt_movimentacao;
    private String flx_tx_obs;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy HH:mm")
    private java.util.Date flx_dt_finalizado;
    private int flx_nr_idanterior;
    private int tra_nr_idorigem;
    private int tra_nr_iddestino;
    private int usu_nr_id;
    private String usu_tx_nome;
    private String usu_tx_login;
    private String usu_tx_status;
    private String usu_tx_email;
    private String ids="";

    public void setTra_nr_id(int tra_nr_id) {
        this.tra_nr_id = tra_nr_id;
    }

    public int getTra_nr_id() {
        return tra_nr_id;
    }

    public void setDes_nr_id(int des_nr_id) {
        this.des_nr_id = des_nr_id;
    }

    public int getDes_nr_id() {
        return des_nr_id;
    }

    public void setTid_nr_id(int tid_nr_id) {
        this.tid_nr_id = tid_nr_id;
    }

    public int getTid_nr_id() {
        return tid_nr_id;
    }

    public void setUsu_nr_idowner(int usu_nr_idowner) {
        this.usu_nr_idowner = usu_nr_idowner;
    }

    public int getUsu_nr_idowner() {
        return usu_nr_idowner;
    }

    public void setTra_tx_nome(String tra_tx_nome) {
        this.tra_tx_nome = tra_tx_nome;
    }

    public String getTra_tx_nome() {
        return tra_tx_nome;
    }

    public void setTra_tx_automatico(String tra_tx_automatico) {
        this.tra_tx_automatico = tra_tx_automatico;
    }

    public String getTra_tx_automatico() {
        return tra_tx_automatico;
    }

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

    public void setUsu_nr_id(int usu_nr_id) {
        this.usu_nr_id = usu_nr_id;
    }

    public int getUsu_nr_id() {
        return usu_nr_id;
    }

    public void setUsu_tx_nome(String usu_tx_nome) {
        this.usu_tx_nome = usu_tx_nome;
    }

    public String getUsu_tx_nome() {
        return usu_tx_nome;
    }

    public void setUsu_tx_login(String usu_tx_login) {
        this.usu_tx_login = usu_tx_login;
    }

    public String getUsu_tx_login() {
        return usu_tx_login;
    }

    public void setUsu_tx_status(String usu_tx_status) {
        this.usu_tx_status = usu_tx_status;
    }

    public String getUsu_tx_status() {
        return usu_tx_status;
    }

    public void setUsu_tx_email(String usu_tx_email) {
        this.usu_tx_email = usu_tx_email;
    }

    public String getUsu_tx_email() {
        return usu_tx_email;
    }

    /**
     * @return the ids
     */
    public String getIds() {
        return ids;
    }

    /**
     * @param ids the ids to set
     */
    public void setIds(String ids) {
        this.ids = ids;
    }
}
