/*
 * EasyNet JDragon
 */
package br.com.i9.flow.client.i9flow.USR_FLUXO.vw_tra_flx_usu;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;


import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.Tid_tipo_documentoDAOGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.Tra_tramiteDAOGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.Vw_tra_flx_usuDAOGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Tid_tipo_documentoTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Tra_tramiteTGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Vw_tra_flx_usuTGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Vw_tra_flx_usuConsultByFaseGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Vw_tra_flx_usuDAOGWT vw_tra_flx_usuDao = new Vw_tra_flx_usuDAOGWT();
    private Tra_tramiteDAOGWT traDao = new Tra_tramiteDAOGWT();
    private Tid_tipo_documentoDAOGWT tidDao = new Tid_tipo_documentoDAOGWT();
    private ComboBox<Tra_tramiteTGWT> cbTramite = new ComboBox<Tra_tramiteTGWT>();
    private ComboBox<Tid_tipo_documentoTGWT> cbTipoDocumento = new ComboBox<Tid_tipo_documentoTGWT>();

    public Vw_tra_flx_usuConsultByFaseGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        
        getToolBarMaster().add(cbTipoDocumento);
        getToolBarMaster().add(cbTramite);

        getBtnNovoSuper().setVisible(false);
        
        setHeaderVisible(false);
        setBorders(false);
        setBodyBorder(false);
        setFrame(false);
        //getToolBarPage().setVisible(false);

        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Vw_tra_flx_usuTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_tra_flx_usuTGWT>>(currency);
        /*
        GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
        public String render(Stock model, String property, ColumnData config, int rowIndex,
        int colIndex, ListStore<Stock> store) {
        double val = (Double) model.get(property);
        String style = val < 0 ? "red" : "green";
        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
        }
        };
        GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
        public String render(Stock model, String property, ColumnData config, int rowIndex,
        int colIndex, ListStore<Stock> store) {
        return numberRenderer.render(null, property, model.get(property));
        }
        };
         */
        ColumnConfig column = null;   

        column = new ColumnConfig();
        column.setId("ids");
        column.setHeader("Identificação");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("tra_tx_nome");
        column.setHeader("Tramite");
        column.setWidth(150);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("usu_tx_nome");
        column.setHeader("Responsável");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("flx_dt_movimentacao");
        column.setHeader("Recebido em");
        column.setWidth(120);
        column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy HH:mm"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("flx_tx_obs");
        column.setHeader("Observação");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        cbTipoDocumento.setEditable(false);
        cbTipoDocumento.setEmptyText("Sel. Tipo Documento");
        cbTipoDocumento.setDisplayField("tid_tx_nome");
        cbTipoDocumento.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbTipoDocumento.setTypeAhead(true);

        cbTipoDocumento.addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<Tid_tipo_documentoTGWT>>() {

            public void handleEvent(SelectionChangedEvent<Tid_tipo_documentoTGWT> be) {
                loadTramite(be.getSelectedItem());
            }
        });

        cbTramite.setEditable(false);
        cbTramite.setEmptyText("Sel. Tramite");
        cbTramite.setDisplayField("tra_tx_nome");
        cbTramite.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbTramite.setTypeAhead(true);

        cbTramite.addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<Tra_tramiteTGWT>>() {

            public void handleEvent(SelectionChangedEvent<Tra_tramiteTGWT> be) {
                load();
            }
        });

        loadTipoDocumento();
    }

    private void loadTipoDocumento() {
        tidDao.consultarTodos();
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Tid_tipo_documentoTGWT> list = tidDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    getCbTipoDocumento().setStore(list);
                    if (list.getCount() == 1) {
                        getCbTipoDocumento().setValue(list.getAt(0));
                        loadTramite(list.getAt(0));
                    }
                    getCbTipoDocumento().getView().refresh();
                }
            }
        };
        timer.schedule(500);
    }

    private void loadTramite(Tid_tipo_documentoTGWT tidT) {
        Tra_tramiteTGWT traT = new Tra_tramiteTGWT();
        traT.setTid_nr_id(tidT.getTid_nr_id());
        traDao.consultTramiteManualByTipoDocumento(traT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Tra_tramiteTGWT> list = traDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    getCbTramite().setStore(list);
                    if (list.getCount() == 1) {
                        getCbTramite().setValue(list.getAt(0));
                        load();
                    } else {
                        getCbTramite().setValue(null);
                    }
                    getCbTramite().getView().refresh();
                }
            }
        };
        timer.schedule(500);
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
    }

    private GridCellRenderer<Vw_tra_flx_usuTGWT> getEditarRender() {
        return new GridCellRenderer<Vw_tra_flx_usuTGWT>() {

            public Object render(final Vw_tra_flx_usuTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_tra_flx_usuTGWT> store, Grid<Vw_tra_flx_usuTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
//                        Vw_tra_flx_usuUpdateDeleteGWT vw_tra_flx_usuUpdateDeleteGWT = new Vw_tra_flx_usuUpdateDeleteGWT();
//                        vw_tra_flx_usuUpdateDeleteGWT.load(model);
//                        vw_tra_flx_usuUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Visualizar dados.");
                b.setIcon(ICONS.edit());
                b.setId("btnEditar");

                return b;
            }
        };
    }

    public void load() {
        if (cbTramite.getValue() == null) {
            MessageBox.alert("Falha", "Selecione um Trâmite", null);
            return;
        }        
        Vw_tra_flx_usuTGWT vwTFUT = new Vw_tra_flx_usuTGWT();
        vwTFUT.setTra_nr_id(cbTramite.getValue().getTra_nr_id());
        getVw_tra_flx_usuDao().consultByStatusTramite(vwTFUT);

        Timer timer = new Timer() {

            public void run() {
                ListStore<Vw_tra_flx_usuTGWT> list = getVw_tra_flx_usuDao().getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(getConfigs());

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Vw_tra_flx_usuTGWT>> loader = new BasePagingLoader<PagingLoadResult<Vw_tra_flx_usuTGWT>>(proxy);
                    loader.setRemoteSort(true);

                    ListStore<Vw_tra_flx_usuTGWT> store = new ListStore<Vw_tra_flx_usuTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);


                    Grid<Vw_tra_flx_usuTGWT> grid = new Grid<Vw_tra_flx_usuTGWT>(store, cm);
                    grid.setId("grid");
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the cbTramite
     */
    public ComboBox<Tra_tramiteTGWT> getCbTramite() {
        return cbTramite;
    }

    /**
     * @param cbTramite the cbTramite to set
     */
    public void setCbTramite(ComboBox<Tra_tramiteTGWT> cbTramite) {
        this.cbTramite = cbTramite;
    }

    /**
     * @return the cbTipoDocumento
     */
    public ComboBox<Tid_tipo_documentoTGWT> getCbTipoDocumento() {
        return cbTipoDocumento;
    }

    /**
     * @param cbTipoDocumento the cbTipoDocumento to set
     */
    public void setCbTipoDocumento(ComboBox<Tid_tipo_documentoTGWT> cbTipoDocumento) {
        this.cbTipoDocumento = cbTipoDocumento;
    }

    /**
     * @return the vw_tra_flx_usuDao
     */
    public Vw_tra_flx_usuDAOGWT getVw_tra_flx_usuDao() {
        return vw_tra_flx_usuDao;
    }

    /**
     * @param vw_tra_flx_usuDao the vw_tra_flx_usuDao to set
     */
    public void setVw_tra_flx_usuDao(Vw_tra_flx_usuDAOGWT vw_tra_flx_usuDao) {
        this.vw_tra_flx_usuDao = vw_tra_flx_usuDao;
    }

    /**
     * @return the configs
     */
    public List<ColumnConfig> getConfigs() {
        return configs;
    }

    /**
     * @param configs the configs to set
     */
    public void setConfigs(List<ColumnConfig> configs) {
        this.configs = configs;
    }
}
