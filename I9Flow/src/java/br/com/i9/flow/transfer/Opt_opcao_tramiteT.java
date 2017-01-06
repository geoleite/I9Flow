package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Opt_opcao_tramiteT { 
	 private int tra_nr_idorigem;
	 private int tra_nr_iddestino;
	 private int opt_nr_ordem;
	 private String opt_tx_retorno;
	 private String opt_tx_nome;
	 public void setTra_nr_idorigem(int tra_nr_idorigem) {
		 this.tra_nr_idorigem=tra_nr_idorigem;
	}
 
	 public int getTra_nr_idorigem() {
		 return tra_nr_idorigem;
 	} 
 	 public void setTra_nr_iddestino(int tra_nr_iddestino) {
		 this.tra_nr_iddestino=tra_nr_iddestino;
	}
 
	 public int getTra_nr_iddestino() {
		 return tra_nr_iddestino;
 	} 
 	 public void setOpt_nr_ordem(int opt_nr_ordem) {
		 this.opt_nr_ordem=opt_nr_ordem;
	}
 
	 public int getOpt_nr_ordem() {
		 return opt_nr_ordem;
 	} 
 	 public void setOpt_tx_retorno(String opt_tx_retorno) {
		 this.opt_tx_retorno=opt_tx_retorno;
	}
 
	 public String getOpt_tx_retorno() {
		 return opt_tx_retorno;
 	} 
 	 public void setOpt_tx_nome(String opt_tx_nome) {
		 this.opt_tx_nome=opt_tx_nome;
	}
 
	 public String getOpt_tx_nome() {
		 return opt_tx_nome;
 	} 
 }