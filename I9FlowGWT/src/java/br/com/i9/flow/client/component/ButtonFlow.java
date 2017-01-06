/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client.component;

import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Opt_opcao_tramiteTGWT;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 *
 * @author geoleite
 */
public class ButtonFlow extends Button {
    private Opt_opcao_tramiteTGWT opt_opcao_tramiteTGWT;

    public ButtonFlow(String text, AbstractImagePrototype img) {
        super(text, img);
    }
    /**
     * @return the opt_opcao_tramiteTGWT
     */
    public Opt_opcao_tramiteTGWT getOpt_opcao_tramiteTGWT() {
        return opt_opcao_tramiteTGWT;
    }

    /**
     * @param opt_opcao_tramiteTGWT the opt_opcao_tramiteTGWT to set
     */
    public void setOpt_opcao_tramiteTGWT(Opt_opcao_tramiteTGWT opt_opcao_tramiteTGWT) {
        this.opt_opcao_tramiteTGWT = opt_opcao_tramiteTGWT;
    }
}
