/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.flow;

import br.com.i9.flow.transfer.Did_documento_identificacaoT;
import java.util.List;

/**
 *
 * @author geoleite
 */
public abstract class AModeloProcAutomatico {

    private List<Did_documento_identificacaoT> listDid;

    public abstract boolean execute();

    public String getValor(String nomeColuna) {
        for (int i = 0; i < getListDid().size(); i++) {
            Did_documento_identificacaoT didT = getListDid().get(i);
            if (nomeColuna.equals(didT.getDid_tx_nomecoluna())) {
                return didT.getDid_tx_valor();
            }
        }
        return null;
    }

    /**
     * @return the listDid
     */
    public List<Did_documento_identificacaoT> getListDid() {
        return listDid;
    }

    /**
     * @param listDid the listDid to set
     */
    public void setListDid(List<Did_documento_identificacaoT> listDid) {
        this.listDid = listDid;
    }
}
