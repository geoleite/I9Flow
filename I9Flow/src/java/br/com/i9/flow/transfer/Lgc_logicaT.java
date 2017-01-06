package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Lgc_logicaT { 
	 private int lgc_nr_id;
	 private int tra_nr_id;
	 private String lgc_tx_classe;
	 private String lgc_tx_status;
	 private int lgc_nr_ordem;
	 private String lgc_tx_descricao;
	 public void setLgc_nr_id(int lgc_nr_id) {
		 this.lgc_nr_id=lgc_nr_id;
	}
 
	 public int getLgc_nr_id() {
		 return lgc_nr_id;
 	} 
 	 public void setTra_nr_id(int tra_nr_id) {
		 this.tra_nr_id=tra_nr_id;
	}
 
	 public int getTra_nr_id() {
		 return tra_nr_id;
 	} 
 	 public void setLgc_tx_classe(String lgc_tx_classe) {
		 this.lgc_tx_classe=lgc_tx_classe;
	}
 
	 public String getLgc_tx_classe() {
		 return lgc_tx_classe;
 	} 
 	 public void setLgc_tx_status(String lgc_tx_status) {
		 this.lgc_tx_status=lgc_tx_status;
	}
 
	 public String getLgc_tx_status() {
		 return lgc_tx_status;
 	} 
 	 public void setLgc_nr_ordem(int lgc_nr_ordem) {
		 this.lgc_nr_ordem=lgc_nr_ordem;
	}
 
	 public int getLgc_nr_ordem() {
		 return lgc_nr_ordem;
 	} 
 	 public void setLgc_tx_descricao(String lgc_tx_descricao) {
		 this.lgc_tx_descricao=lgc_tx_descricao;
	}
 
	 public String getLgc_tx_descricao() {
		 return lgc_tx_descricao;
 	} 
 }