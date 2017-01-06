package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;
import java.io.Serializable;

public class Did_documento_identificacaoT implements Serializable {
	 private int did_nr_id;
	 private int flx_nr_id;
	 private String did_tx_nomecoluna;
	 private String did_tx_valor;
	 public void setDid_nr_id(int did_nr_id) {
		 this.did_nr_id=did_nr_id;
	}
 
	 public int getDid_nr_id() {
		 return did_nr_id;
 	} 
 	 public void setFlx_nr_id(int flx_nr_id) {
		 this.flx_nr_id=flx_nr_id;
	}
 
	 public int getFlx_nr_id() {
		 return flx_nr_id;
 	} 
 	 public void setDid_tx_nomecoluna(String did_tx_nomecoluna) {
		 this.did_tx_nomecoluna=did_tx_nomecoluna;
	}
 
	 public String getDid_tx_nomecoluna() {
		 return did_tx_nomecoluna;
 	} 
 	 public void setDid_tx_valor(String did_tx_valor) {
		 this.did_tx_valor=did_tx_valor;
	}
 
	 public String getDid_tx_valor() {
		 return did_tx_valor;
 	} 
 }