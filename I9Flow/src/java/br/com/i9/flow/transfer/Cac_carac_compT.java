package br.com.i9.flow.transfer;

import br.com.easynet.annotation.Conversion;

public class Cac_carac_compT { 
	 private int tra_nr_id;
	 private int tel_nr_id;
	 private int cac_nr_id;
	 private String cac_tx_idcomponente;
	 private String cac_tx_visivel;
	 private String cac_tx_habilitado;
	 private String cac_tx_editavel;
         private int cac_nr_ordem=1;
	 public void setTra_nr_id(int tra_nr_id) {
		 this.tra_nr_id=tra_nr_id;
	}
 
	 public int getTra_nr_id() {
		 return tra_nr_id;
 	} 
 	 public void setTel_nr_id(int tel_nr_id) {
		 this.tel_nr_id=tel_nr_id;
	}
 
	 public int getTel_nr_id() {
		 return tel_nr_id;
 	} 
 	 public void setCac_nr_id(int cac_nr_id) {
		 this.cac_nr_id=cac_nr_id;
	}
 
	 public int getCac_nr_id() {
		 return cac_nr_id;
 	} 
 	 public void setCac_tx_idcomponente(String cac_tx_idcomponente) {
		 this.cac_tx_idcomponente=cac_tx_idcomponente;
	}
 
	 public String getCac_tx_idcomponente() {
		 return cac_tx_idcomponente;
 	} 
 	 public void setCac_tx_visivel(String cac_tx_visivel) {
		 this.cac_tx_visivel=cac_tx_visivel;
	}
 
	 public String getCac_tx_visivel() {
		 return cac_tx_visivel;
 	} 
 	 public void setCac_tx_habilitado(String cac_tx_habilitado) {
		 this.cac_tx_habilitado=cac_tx_habilitado;
	}
 
	 public String getCac_tx_habilitado() {
		 return cac_tx_habilitado;
 	} 
 	 public void setCac_tx_editavel(String cac_tx_editavel) {
		 this.cac_tx_editavel=cac_tx_editavel;
	}
 
	 public String getCac_tx_editavel() {
		 return cac_tx_editavel;
 	}

    /**
     * @return the cac_nr_ordem
     */
    public int getCac_nr_ordem() {
        return cac_nr_ordem;
    }

    /**
     * @param cac_nr_ordem the cac_nr_ordem to set
     */
    public void setCac_nr_ordem(int cac_nr_ordem) {
        this.cac_nr_ordem = cac_nr_ordem;
    }
 }