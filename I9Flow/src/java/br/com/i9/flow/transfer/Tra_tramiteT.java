package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Tra_tramiteT { 
	 private int tra_nr_id;
	 private int des_nr_id;
	 private int tid_nr_id;
	 private int usu_nr_id;
	 private String tra_tx_nome;
	 private String tra_tx_automatico;
	 public void setTra_nr_id(int tra_nr_id) {
		 this.tra_nr_id=tra_nr_id;
	}
 
	 public int getTra_nr_id() {
		 return tra_nr_id;
 	} 
 	 public void setDes_nr_id(int des_nr_id) {
		 this.des_nr_id=des_nr_id;
	}
 
	 public int getDes_nr_id() {
		 return des_nr_id;
 	} 
 	 public void setTid_nr_id(int tid_nr_id) {
		 this.tid_nr_id=tid_nr_id;
	}
 
	 public int getTid_nr_id() {
		 return tid_nr_id;
 	} 
 	 public void setUsu_nr_id(int usu_nr_id) {
		 this.usu_nr_id=usu_nr_id;
	}
 
	 public int getUsu_nr_id() {
		 return usu_nr_id;
 	} 
 	 public void setTra_tx_nome(String tra_tx_nome) {
		 this.tra_tx_nome=tra_tx_nome;
	}
 
	 public String getTra_tx_nome() {
		 return tra_tx_nome;
 	} 
 	 public void setTra_tx_automatico(String tra_tx_automatico) {
		 this.tra_tx_automatico=tra_tx_automatico;
	}
 
	 public String getTra_tx_automatico() {
		 return tra_tx_automatico;
 	} 
 }