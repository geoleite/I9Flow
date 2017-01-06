package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Tid_tipo_documentoT { 
	 private int tid_nr_id;
	 private String tid_tx_nome;
	 private int tra_nr_id;
	 public void setTid_nr_id(int tid_nr_id) {
		 this.tid_nr_id=tid_nr_id;
	}
 
	 public int getTid_nr_id() {
		 return tid_nr_id;
 	} 
 	 public void setTid_tx_nome(String tid_tx_nome) {
		 this.tid_tx_nome=tid_tx_nome;
	}
 
	 public String getTid_tx_nome() {
		 return tid_tx_nome;
 	} 
 	 public void setTra_nr_id(int tra_nr_id) {
		 this.tra_nr_id=tra_nr_id;
	}
 
	 public int getTra_nr_id() {
		 return tra_nr_id;
 	} 
 }