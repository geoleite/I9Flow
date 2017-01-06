/*
 * EasyNet JDragon
 */
package br.com.i9.flow.client.i9flow.USR_FLUXO.lgc_logica;

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
public class Lgc_logicaConsultGWT extends ConsultarBaseGWT {

  private Grid<Lgc_logicaTGWT> grid = null;
  private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
  private Lgc_logicaDAOGWT lgc_logicaDao = new Lgc_logicaDAOGWT();

  public Lgc_logicaConsultGWT() {
    this.setSize("500", "400");
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Lgc_logicaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Lgc_logicaTGWT>>(currency);
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
            column.setId("lgc_nr_id");
            column.setHeader("Lgc_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("tra_nr_id");
            column.setHeader("Tra_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("lgc_tx_classe");
            column.setHeader("Lgc_tx_classe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("lgc_tx_status");
            column.setHeader("Lgc_tx_status");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("lgc_nr_ordem");
            column.setHeader("Lgc_nr_ordem");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("lgc_tx_descricao");
            column.setHeader("Lgc_tx_descricao");
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

  public void btnAtualizarAction(ButtonEvent be){
    super.btnAtualizarAction(be);
  }

  public void btnNovoAction(ButtonEvent be) {
    Lgc_logicaInsertGWT lgc_logicaInsertGWT = new Lgc_logicaInsertGWT();
    lgc_logicaInsertGWT.setLgc_logicaConsult(this);
    lgc_logicaInsertGWT.setModal(true);
    lgc_logicaInsertGWT.show();
  }
  private GridCellRenderer<Lgc_logicaTGWT> getEditarRender() {
    return new GridCellRenderer<Lgc_logicaTGWT>() {

      public Object render(final Lgc_logicaTGWT model, String property, ColumnData config, final int rowIndex,
        final int colIndex, ListStore<Lgc_logicaTGWT> store, Grid<Lgc_logicaTGWT> grid) {

        Button b = new Button();
        b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

        public void handleEvent(ButtonEvent be) {
          Lgc_logicaUpdateDeleteGWT lgc_logicaUpdateDeleteGWT = new Lgc_logicaUpdateDeleteGWT();
          lgc_logicaUpdateDeleteGWT.setLgc_logicaConsult(Lgc_logicaConsultGWT.this);
          lgc_logicaUpdateDeleteGWT.load(model);
          lgc_logicaUpdateDeleteGWT.setVisible(true);
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
    lgc_logicaDao.consultarTodos();
    Timer timer = new Timer() {
      public void run() {
        ListStore<Lgc_logicaTGWT> list = lgc_logicaDao.getList();
        if (list == null) {
          schedule(500);
        } else {
          
          if (grid !=  null) {
            grid.removeFromParent();
          }

          ColumnModel cm = new ColumnModel(configs);

          PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
          PagingLoader<PagingLoadResult<Lgc_logicaTGWT>> loader = new BasePagingLoader<PagingLoadResult<Lgc_logicaTGWT>>(proxy);
          loader.setRemoteSort(true);

          ListStore<Lgc_logicaTGWT> store = new ListStore<Lgc_logicaTGWT>(loader);
          store.add(list.getModels());

          getToolBarPage().setPageSize(20);
          getToolBarPage().bind(loader);
          loader.load(0, 20);

          grid = new Grid<Lgc_logicaTGWT>(store, cm);
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
