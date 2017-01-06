package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Tel_telaT { 
	 private int tel_nr_id;
	 private String tel_tx_nome;
	 public void setTel_nr_id(int tel_nr_id) {
		 this.tel_nr_id=tel_nr_id;
	}
 
	 public int getTel_nr_id() {
		 return tel_nr_id;
 	} 
 	 public void setTel_tx_nome(String tel_tx_nome) {
		 this.tel_tx_nome=tel_tx_nome;
	}
 
	 public String getTel_tx_nome() {
		 return tel_tx_nome;
 	} 
 }