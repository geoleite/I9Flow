/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//br.com.i9.flow.client.ExemploFlow
package br.com.i9.flow.client;

import br.com.easynet.gwt.client.component.EasyTextField;
import com.extjs.gxt.ui.client.widget.Info;

/**
 *
 * @author geoleite
 */
public class ExemploFlow extends CPI9FlowBase {
    private String nomeTipoDocumento="Guia ITBI";
    private EasyTextField<String> nome = new EasyTextField<String>();
    public ExemploFlow() {
        setSize(800, 600);
        getCpMaster().add(nome);
        startFlow(nomeTipoDocumento);
        setVisible(true);
    }

    public void waitDefine() {
        Info.display("DEBUG", "ok");
        setVisible(true);
    }

}
