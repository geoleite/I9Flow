/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package br.com.i9.flow.client;
  
import br.com.easyportal.gwt.client.accordionModel.AMenuHandlerAccordion;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.tid_tipo_documento.Tid_tipo_documentoConsultGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.tra_tramite.Tra_tramiteConsultGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.vw_tra_flx_usu.Vw_tra_flx_usuConsultByFaseGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.vw_tra_flx_usu.Vw_tra_flx_usuConsultByIdsDocumentoGWT;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Window;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class AdminI9FlowAccordion extends AMenuHandlerAccordion {

    private HashMap<String, TabItem> itens = new HashMap<String, TabItem>();

    public AdminI9FlowAccordion() {
        setSystem("FLUXO");
    }

    @Override
    public void actionEventMenu(Object me, String acao) {
        TabItem tabItem = null;
        tabItem = itens.get(acao);

        if (tabItem == null) {
            tabItem = new TabItem(); 
            tabItem.setClosable(true);
            tabItem.setLayout(new FitLayout());
            ContentPanel cp = new ContentPanel();
            cp.setFrame(false);
            cp.setBorders(false);
            cp.setHeaderVisible(false);
            cp.setBodyBorder(false); 
            cp.setLayout(new FitLayout());
            if ("FLUXO.fluxoFase".equalsIgnoreCase(acao)) {
                tabItem.setText("Documentos Por Fase");
                tabItem.setClosable(true);
                cp.add(new Vw_tra_flx_usuConsultByFaseGWT());
            } else if ("FLUXO.fluxoDocumento".equals(acao)) {
                tabItem.setText("Fases Documento");
                tabItem.setClosable(false);
                cp.add(new Vw_tra_flx_usuConsultByIdsDocumentoGWT());
//            } else if ("FLUXO.configValidacao".equals(acao)) {
//                tabItem.setText("Validação Trâmites");
//                cp.add(new Tra_tramiteConsultGWT());
            } else if ("FLUXO.tid".equals(acao)) {
                tabItem.setText("Tipos Documentos");
                cp.add(new Tid_tipo_documentoConsultGWT());
            } else if ("FLUXO.tra".equals(acao)) {
                tabItem.setText("Tramites");
                cp.add(new Tra_tramiteConsultGWT());
            }else {
                cp = null;
                MessageBox.alert("Opcao ainda nao implementada", "Em breve esta opcao estara disponivel!", null);
            }
            if (cp != null) {
                tabItem.add(cp);
                //Adiciona o tabitem se nÃ£o existir no tabPanel
                getPortalAccordionGWT().getTabPanel().add(tabItem);
                itens.put(acao, tabItem);
            }
        } else {
            TabItem tabTemp = getPortalAccordionGWT().getTabPanel().getItemByItemId(acao);
            if (tabTemp == null) {
                getPortalAccordionGWT().getTabPanel().add(tabItem);
            }
        }
        getPortalAccordionGWT().getTabPanel().setSelection(tabItem);
        getPortalAccordionGWT().layout();
    }
}
