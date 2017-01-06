/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.flow.client;

import br.com.i9.flow.client.component.ButtonFlow;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Did_documento_identificacaoTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Tra_tramiteTGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

/**
 *
 * @author geoleite
 */
public interface II9Flow {

    /**
     * inicia o controle do fluxo
     */
    void startFlow(String docTypeName);

    void startFlow(String docTypeName, boolean firstTramite);

    void startFlow(String docTypeName, List<Did_documento_identificacaoTGWT> listDid, boolean firstTramite);

    void saveFlow(ButtonFlow btnSelected);

    void defineComponents(Tra_tramiteTGWT traT);

    void defineFlowOption(Tra_tramiteTGWT traT);

    void waitDefine();

    void flowAction(ButtonEvent be);

    void defineComponent(String componentId, boolean visible, boolean enable, boolean readOnly);

    void addComponent(String id, Widget widget);

    void remComponent(String id);

    Widget getComponent(String id);

}
