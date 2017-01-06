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
import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.Did_documento_identificacaoTGWT;
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
public class Vw_tra_flx_usuConsultByIdsDocumentoGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Vw_tra_flx_usuDAOGWT vw_tra_flx_usuDao = new Vw_tra_flx_usuDAOGWT();
    private Tra_tramiteDAOGWT traDao = new Tra_tramiteDAOGWT();
    private Tid_tipo_documentoDAOGWT tidDao = new Tid_tipo_documentoDAOGWT();

    public Vw_tra_flx_usuConsultByIdsDocumentoGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");

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
        column.setId("flx_dt_finalizado");
        column.setHeader("Finalizado em");
        column.setWidth(120);
        column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy HH:mm"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("flx_tx_obs");
        column.setHeader("Observação");
        column.setWidth(350);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

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

    public void load(List<Did_documento_identificacaoTGWT> listDid) {
        if (listDid == null || listDid.size() == 0) {
            MessageBox.alert("Falha", "É necessário informar o(s) IDs do Documento.", null);
            return;
        }
        vw_tra_flx_usuDao.consultByIdDocumento(listDid);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Vw_tra_flx_usuTGWT> list = vw_tra_flx_usuDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

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
}