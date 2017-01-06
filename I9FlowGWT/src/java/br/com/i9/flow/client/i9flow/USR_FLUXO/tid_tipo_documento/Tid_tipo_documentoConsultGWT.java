/*
 * EasyNet JDragon
 */
package br.com.i9.flow.client.i9flow.USR_FLUXO.tid_tipo_documento;

import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;


import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.*;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
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
public class Tid_tipo_documentoConsultGWT extends ConsultarBaseGWT {

    private Grid<Tid_tipo_documentoTGWT> grid = null;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Tid_tipo_documentoDAOGWT tid_tipo_documentoDao = new Tid_tipo_documentoDAOGWT();

    public Tid_tipo_documentoConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Tid_tipo_documentoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Tid_tipo_documentoTGWT>>(currency);
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
        column.setId("tid_tx_nome");
        column.setHeader("Nome");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);


        column = new ColumnConfig();
        column.setId("colEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        load();
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Tid_tipo_documentoInsertGWT tid_tipo_documentoInsertGWT = new Tid_tipo_documentoInsertGWT();
        tid_tipo_documentoInsertGWT.setTid_tipo_documentoConsult(this);
        tid_tipo_documentoInsertGWT.setModal(true);
        tid_tipo_documentoInsertGWT.show();
    }

    private GridCellRenderer<Tid_tipo_documentoTGWT> getEditarRender() {
        return new GridCellRenderer<Tid_tipo_documentoTGWT>() {

            public Object render(final Tid_tipo_documentoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tid_tipo_documentoTGWT> store, Grid<Tid_tipo_documentoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Tid_tipo_documentoUpdateDeleteGWT tid_tipo_documentoUpdateDeleteGWT = new Tid_tipo_documentoUpdateDeleteGWT();
                        tid_tipo_documentoUpdateDeleteGWT.setTid_tipo_documentoConsult(Tid_tipo_documentoConsultGWT.this);
                        tid_tipo_documentoUpdateDeleteGWT.load(model);
                        tid_tipo_documentoUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());
                b.setId("btnEditar");

                return b;
            }
        };
    }

    public void load() {
        tid_tipo_documentoDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Tid_tipo_documentoTGWT> list = tid_tipo_documentoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {

                    if (grid != null) {
                        grid.removeFromParent();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Tid_tipo_documentoTGWT>> loader = new BasePagingLoader<PagingLoadResult<Tid_tipo_documentoTGWT>>(proxy);
                    loader.setRemoteSort(true);

                    ListStore<Tid_tipo_documentoTGWT> store = new ListStore<Tid_tipo_documentoTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    grid = new Grid<Tid_tipo_documentoTGWT>(store, cm);
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
