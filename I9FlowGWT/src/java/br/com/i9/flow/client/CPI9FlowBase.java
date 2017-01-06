/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.flow.client;

import br.com.easynet.gwt.client.CPBaseGWT;
import br.com.easynet.gwt.client.debug.DebugMessage;
import br.com.i9.flow.client.component.ButtonFlow;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.Cac_carac_compDAOGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.Flx_fluxoDAOGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.Opt_opcao_tramiteDAOGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.Tra_tramiteDAOGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Cac_carac_compTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Did_documento_identificacaoTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Flx_fluxoTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Opt_opcao_tramiteTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Tra_tramiteTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.vw_tra_flx_usu.Vw_tra_flx_usuConsultGWT;
import br.com.i9.flow.client.icons.Icons;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.BoxComponentEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;

import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class CPI9FlowBase extends CPBaseGWT implements II9Flow {

    private String docTypeName;
    private List<Did_documento_identificacaoTGWT> listDid;
    private Cac_carac_compDAOGWT cacDao = new Cac_carac_compDAOGWT();
    private Opt_opcao_tramiteDAOGWT optDao = new Opt_opcao_tramiteDAOGWT();
    private Tra_tramiteDAOGWT traDao = new Tra_tramiteDAOGWT();
    private Flx_fluxoDAOGWT flxDao = new Flx_fluxoDAOGWT();
    //private HtmlEditor heObs = new HtmlEditor();
    private TextArea heObs = new TextArea();
    private ToolBar toolBarBotton = new ToolBar();
    private TabPanel tabPanel = new TabPanel();
    private TabItem tabItemObservacao = new TabItem("Observação");
    private TabItem tabItemListaObservacoes = new TabItem("Lista Observações");
    private Tra_tramiteTGWT traActual;
    private boolean waitDefineComponents = false, waitDefineFlowOption = false;
    private Button btnEmpty = new Button("Empty");
    private TreeMap<String, Widget> components = new TreeMap<String, Widget>();

    public CPI9FlowBase() {
        getCpTop().setVisible(false);
        getCpLeft().setVisible(false);
        getCpRight().setVisible(false);

        getCpBotton().setLayout(new FitLayout());
        //getCpBotton().add(heObs);
        getCpBotton().add(tabPanel);
        tabItemObservacao.setLayout(new FitLayout());
        tabItemListaObservacoes.setLayout(new FitLayout());
        tabItemObservacao.add(heObs);
        tabPanel.add(tabItemListaObservacoes);
        tabPanel.add(tabItemObservacao);
        tabPanel.setSelection(tabItemListaObservacoes);

        setBottomComponent(toolBarBotton);
        getDataSOUTH().setSize(140);
        getCpBotton().setHeading("Area para Observações");

        toolBarBotton.add(btnEmpty);

    }

    /**
     * @return the docTypeName
     */
    public String getDocTypeName() {
        return docTypeName;
    }

    /**
     * @param docTypeName the docTypeName to set
     */
    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    public void startFlow(String docTypeName) {
        startFlow(docTypeName, null, false);
    }

    public void startFlow(String docTypeName, boolean firstTramite) {
        startFlow(docTypeName, null, firstTramite);
    }

    public void startFlow(String docTypeName, List<Did_documento_identificacaoTGWT> listDid, boolean firstTramite) {
        setDocTypeName(docTypeName);
        setListDid(listDid);
        consultDocumentFlow(listDid);
        traDao.findByDocTypeNameActual(docTypeName, listDid, firstTramite);
        Timer timer = new Timer() {

            @Override
            public void run() {
                traActual = traDao.getTra_tramiteT();
                if (traActual == null) {
                    schedule(500);
                } else {
                    defineComponents(traActual);
                    defineFlowOption(traActual);
                    waitReponse();
                }
            }
        };
        timer.schedule(100);
    }

    private void waitReponse() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!waitDefineComponents || !waitDefineFlowOption) {
                    schedule(500);
                } else {
                    waitDefine();
                }
            }
        };
        timer.schedule(100);
    }

    public void saveFlow(ButtonFlow btnSelected) {
        if (btnSelected != null) {
            Flx_fluxoTGWT flxT = new Flx_fluxoTGWT();
            flxT.setTra_nr_idorigem(traActual.getTra_nr_id());
            flxT.setFlx_tx_obs(getHeObs().getValue());
            Opt_opcao_tramiteTGWT optT = btnSelected.getOpt_opcao_tramiteTGWT();
            flxT.setTra_nr_iddestino(optT.getTra_nr_iddestino());
            flxDao.inserir(flxT);
        } else {
            MessageBox.alert("ATENCAO", "Nao foi informado corretamente a origem e destino do tramite.", null);
        }
    }

    public void defineComponents(Tra_tramiteTGWT traT) {
        if (docTypeName == null) {
            //MessageBox.alert("ATENÇÃO", "Nao foi definido o nome do tipo de documento!", null);
            return;
        }

        waitDefineComponents = false;
        //Obtendo a lista de componentes que devem ser afetados
        cacDao.consultByDocTypeNameAndFlowId(traT.getTra_nr_id(), this.getClass().getName());
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Cac_carac_compTGWT> listCac = cacDao.getList();
                if (listCac == null) {
                    schedule(500);
                } else {

                    for (int i = 0; i < listCac.getCount(); i++) {
                        try {
                            Cac_carac_compTGWT cacT = listCac.getAt(i);
                            splitParameterComponents(cacT);
                        } catch (Exception e) {
                            DebugMessage.message(DebugMessage.ERROR, e.getMessage());
                        }
                    }
                    layout();
                    waitDefineComponents = true;
                }
            }
        };
        timer.schedule(500);
    }

    public void defineFlowOption(Tra_tramiteTGWT traT) {
        waitDefineFlowOption = false;
        optDao.consultByFlowId(traT.getTra_nr_id());
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Opt_opcao_tramiteTGWT> listOpt = optDao.getList();
                if (listOpt == null) {
                    schedule(500);
                } else {

                    for (int i = 0; i < listOpt.getCount(); i++) {
                        Opt_opcao_tramiteTGWT optT = listOpt.getAt(i);
                        ButtonFlow btnTramite = new ButtonFlow(optT.getOpt_tx_nome(), "S".equals(optT.getOpt_tx_retorno()) ? Icons.ICONS.retornar() : Icons.ICONS.encaminhar());
                        btnTramite.setOpt_opcao_tramiteTGWT(optT);
                        getToolBarBotton().add(btnTramite);
                        getToolBarBotton().add(new SeparatorToolItem());
                        btnTramite.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                            public void handleEvent(ButtonEvent be) {
                                flowAction(be);
                            }
                        });
                    }
                    getToolBarBotton().layout();
                    layout();
                    waitDefineFlowOption = true;
                }
            }
        };
        timer.schedule(500);
    }

    public void addComponent(String id, Widget widget) {
        if (!components.containsKey(id)) {
            components.put(id, widget);
        }
    }

    public void remComponent(String id) {
        components.remove(id);
    }

    public Widget getComponent(String id) {
        return components.get(id);
    }

    public void waitDefine() {
        btnEmpty.setVisible(false);
        getToolBarBotton().layout();
        layout();
    }

    public void defineComponent(String componentId, boolean visible, boolean enable, boolean readOnly) {
        Widget widget = getWidget(componentId);
        modifyComponent(widget, visible, enable, readOnly);
        /*
        if (widget != null) {
        widget.setVisible(visible);
        if (widget instanceof Component) {
        Component component = (Component) widget;
        component.setEnabled(enable);
        if (widget instanceof Container) {
        Container c = (Container) widget;
        List list = c.getItems();
        if (list != null) {
        defineComponent(componentId, visible, enable, readOnly);
        }
        }
        }
        if (widget instanceof Field) {
        Field field = (Field) widget;
        field.setReadOnly(readOnly);
        }
        }
         */
    }

    private void modifyComponent(Widget component, boolean visible, boolean enable, boolean readOnly) {
        try {
            
            if (component != null) {
                component.setVisible(visible);
                if (component instanceof Component) {
                    try {
                        Component comp = (Component) component;
                        comp.setEnabled(enable);
                    } catch (Exception e) {
                        DebugMessage.message(DebugMessage.ERROR, " Verificando se é component " + e.getMessage());
                    }
                }
                if (component instanceof Container) {
                    Container<Component> c = (Container<Component>) component;
                    List<Component> list = c.getItems();
                    if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                            try {
                                Component comp1 = list.get(i);
                                modifyComponent(comp1, visible, enable, readOnly);
                            } catch (Exception e) {
                                DebugMessage.message(DebugMessage.ERROR, " verificando componentes filhos" + e.getMessage());
                            }
                        }
                    }
                } else {
                    if (component instanceof Field) {
                        try {
                            Field field = (Field) component;
                            field.setReadOnly(readOnly);
                        } catch (Exception e) {
                            DebugMessage.message(DebugMessage.ERROR, " Verificando field " + e.getMessage());
                        }
                    }
                }
            }
        } catch (Exception e) {
            DebugMessage.message(DebugMessage.ERROR," redefinido em modifyComponent " + e.getMessage() );
        }

    }

    public void flowAction(ButtonEvent be) {
    }

    public void consultDocumentFlow(List<Did_documento_identificacaoTGWT> listDid) {
        //flxDao.consultByIdDocumento(listDid);
        Vw_tra_flx_usuConsultGWT vwConsult = new Vw_tra_flx_usuConsultGWT();
        vwConsult.load(listDid);
        ContentPanel cp = new ContentPanel();
        cp.setFrame(false);
        cp.setBorders(false);
        cp.setHeaderVisible(false);
        cp.setBodyBorder(false);
        cp.setLayout(new FitLayout());
        cp.add(vwConsult);
        tabItemListaObservacoes.add(cp);
        tabItemListaObservacoes.layout();
    }

    public Widget getWidget(String name) {
        if (components.containsKey(name)) {
            return components.get(name);
        } else {
            return getWidget(this, name);
        }
    }

    public Widget getWidget(Widget widget, String name) {
        if (widget != null) {
            if (widget instanceof Container) {
                Container cp = (Container) widget;
                if (name.equalsIgnoreCase(cp.getId())) {
                    return cp;
                }
                List<Component> list = cp.getItems();
                for (Component component : list) {
                    Widget w = getWidget(component, name);
                    if (w != null) {
                        //MessageBox.confirm("ComponentW", "ok", null);
                        return w;
                    }
                }
            } else {
                if (widget instanceof Component) {
                    Component component = (Component) widget;
                    if (name.equalsIgnoreCase(component.getId())) {
                        return component;
                    }
                }
            }
        }
        return null;
    }

    public void splitParameterComponents(Cac_carac_compTGWT cacT) {
        boolean visible = "S".equalsIgnoreCase(cacT.getCac_tx_visivel());
        boolean enable = "S".equalsIgnoreCase(cacT.getCac_tx_habilitado());
        boolean readOnly = "N".equalsIgnoreCase(cacT.getCac_tx_editavel());
        try {

            if (cacT.getCac_tx_idcomponente().indexOf("#") > 0) {
                String paramsId = cacT.getCac_tx_idcomponente();
                String params[] = paramsId.split("#");
                String gridId = params[0];
                String[] paramsColumns = new String[params.length - 1];
                System.arraycopy(params, 1, paramsColumns, 0, paramsColumns.length);
                defineColumnGrid(gridId, paramsColumns, visible, enable, readOnly);
            } else {
                defineComponent(cacT.getCac_tx_idcomponente(), visible, enable, readOnly);
            }
        } catch (Exception e) {
            DebugMessage.message(DebugMessage.ERROR," redefinido componente " + e.getMessage());
        }
    }

    private Grid cloneGrid(Grid grid) {
        //MessageBox.alert("DEBUG", grid.getStore().getCount() + "", null);
        Grid gridNew = new Grid(grid.getStore(), grid.getColumnModel());
        gridNew.setId(grid.getId());
        gridNew.setLoadMask(grid.isLoadMask());
        gridNew.setStyleAttribute("borderTop", "none");
        gridNew.setBorders(grid.getBorders());
        gridNew.setSelectionModel(grid.getSelectionModel());
        //gridNew.setHeight(grid.getHeight());
        return gridNew;
    }

    private ColumnModel getNewColumnModel(ColumnModel cm) {
        ColumnModel columnModel = new ColumnModel(cm.getColumns());
        return columnModel;
    }

    private ListStore getNewListStore(ListStore ls) {
        ListStore listStore = new ListStore(ls.getLoader());
        return listStore;
    }

    public void defineColumnGrid(String gridId, String[] paramaColuns, boolean visible, boolean enable, boolean readOnly) {
        Widget widget = getWidget(gridId);
        if (widget instanceof Grid) {
            Grid grid = (Grid) widget;
            LayoutContainer lc = null;
            int cont = 0;
            for (int k = 0; k < paramaColuns.length; k++) {
                String columnId = paramaColuns[k];

                ColumnConfig columnConfig = grid.getColumnModel().getColumnById(columnId);
                if (columnConfig != null) {
                    if (!visible) {
                        columnConfig.setHidden(true);
                        //MessageBox.alert("Colunas", grid.getColumnModel().getColumns().size() + "", null);
                        grid.getColumnModel().getColumns().remove(columnConfig);
                    } else {
                        Widget w = columnConfig.getWidget();
                        if (w instanceof Component) {
                            ((Component) w).setEnabled(enable);
                        }
                        if (w instanceof Field) {
                            ((Field) w).setReadOnly(readOnly);
                        }
                    }
                }
            }
            if (lc != null) {
                Widget container = grid.getParent();
                lc = (LayoutContainer) container;
                List<Component> listComp = lc.getItems();

                for (int i = 0; i < listComp.size(); i++) {
                    Component component = listComp.get(i);
                    if (grid == component) {
                        cont = i;
                        break;
                    }
                }
                grid.removeFromParent();
                //lc.insert(cloneGrid(grid), cont, new RowData(1, .3, null));
                lc.insert(cloneGrid(grid), cont);
                lc.layout();
            }
        }
    }

    /**
     * @return the listDid
     */
    public List<Did_documento_identificacaoTGWT> getListDid() {
        return listDid;
    }

    /**
     * @param listDid the listDid to set
     */
    public void setListDid(List<Did_documento_identificacaoTGWT> listDid) {
        this.listDid = listDid;
    }

    /**
     * @return the traActual
     */
    public Tra_tramiteTGWT getTraActual() {
        return traActual;
    }

    /**
     * @param traActual the traActual to set
     */
    public void setTraActual(Tra_tramiteTGWT traActual) {
        this.traActual = traActual;
    }

    /**
     * @return the heObs
     */
    public TextArea getHeObs() {
        return heObs;
    }

    /**
     * @param heObs the heObs to set
     */
    public void setHeObs(TextArea heObs) {
        this.heObs = heObs;
    }

    /**
     * @return the toolBarBotton
     */
    public ToolBar getToolBarBotton() {
        return toolBarBotton;
    }

    /**
     * @param toolBarBotton the toolBarBotton to set
     */
    public void setToolBarBotton(ToolBar toolBarBotton) {
        this.toolBarBotton = toolBarBotton;
    }

    /**
     * @return the tabPanel
     */
    public TabPanel getTabPanel() {
        return tabPanel;
    }

    /**
     * @param tabPanel the tabPanel to set
     */
    public void setTabPanel(TabPanel tabPanel) {
        this.tabPanel = tabPanel;
    }

    /**
     * @return the tabItemObservacao
     */
    public TabItem getTabItemObservacao() {
        return tabItemObservacao;
    }

    /**
     * @param tabItemObservacao the tabItemObservacao to set
     */
    public void setTabItemObservacao(TabItem tabItemObservacao) {
        this.tabItemObservacao = tabItemObservacao;
    }

    /**
     * @return the tabItemListaObservacoes
     */
    public TabItem getTabItemListaObservacoes() {
        return tabItemListaObservacoes;
    }

    /**
     * @param tabItemListaObservacoes the tabItemListaObservacoes to set
     */
    public void setTabItemListaObservacoes(TabItem tabItemListaObservacoes) {
        this.tabItemListaObservacoes = tabItemListaObservacoes;
    }
}
