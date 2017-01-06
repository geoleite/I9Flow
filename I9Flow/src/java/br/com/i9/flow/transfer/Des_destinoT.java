package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Des_destinoT { 
	 private int des_nr_id;
	 private String des_tx_tipo;
	 private int des_nr_idregistro;
	 public void setDes_nr_id(int des_nr_id) {
		 this.des_nr_id=des_nr_id;
	}
 
	 public int getDes_nr_id() {
		 return des_nr_id;
 	} 
 	 public void setDes_tx_tipo(String des_tx_tipo) {
		 this.des_tx_tipo=des_tx_tipo;
	}
 
	 public String getDes_tx_tipo() {
		 return des_tx_tipo;
 	} 
 	 public void setDes_nr_idregistro(int des_nr_idregistro) {
		 this.des_nr_idregistro=des_nr_idregistro;
	}
 
	 public int getDes_nr_idregistro() {
		 return des_nr_idregistro;
 	} 
 }