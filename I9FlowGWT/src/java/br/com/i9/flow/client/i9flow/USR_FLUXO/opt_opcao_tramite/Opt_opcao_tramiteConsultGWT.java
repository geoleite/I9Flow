/*
 * EasyNet JDragon
 */
package br.com.i9.flow.client.i9flow.USR_FLUXO.opt_opcao_tramite;

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
public class Opt_opcao_tramiteConsultGWT extends ConsultarBaseGWT {

  private Grid<Opt_opcao_tramiteTGWT> grid = null;
  private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
  private Opt_opcao_tramiteDAOGWT opt_opcao_tramiteDao = new Opt_opcao_tramiteDAOGWT();

  public Opt_opcao_tramiteConsultGWT() {
    setHeaderVisible(false);
    this.setSize("500", "400");
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Opt_opcao_tramiteTGWT>> numberRenderer = new NumberCellRenderer<Grid<Opt_opcao_tramiteTGWT>>(currency);
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
            column.setId("tra_nr_idorigem");
            column.setHeader("Tra_nr_idorigem");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("tra_nr_iddestino");
            column.setHeader("Tra_nr_iddestino");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("opt_nr_ordem");
            column.setHeader("Opt_nr_ordem");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("opt_tx_retorno");
            column.setHeader("Opt_tx_retorno");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("opt_tx_nome");
            column.setHeader("Opt_tx_nome");
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
    Opt_opcao_tramiteInsertGWT opt_opcao_tramiteInsertGWT = new Opt_opcao_tramiteInsertGWT();
    opt_opcao_tramiteInsertGWT.setOpt_opcao_tramiteConsult(this);
    opt_opcao_tramiteInsertGWT.setModal(true);
    opt_opcao_tramiteInsertGWT.show();
  }
  private GridCellRenderer<Opt_opcao_tramiteTGWT> getEditarRender() {
    return new GridCellRenderer<Opt_opcao_tramiteTGWT>() {

      public Object render(final Opt_opcao_tramiteTGWT model, String property, ColumnData config, final int rowIndex,
        final int colIndex, ListStore<Opt_opcao_tramiteTGWT> store, Grid<Opt_opcao_tramiteTGWT> grid) {

        Button b = new Button();
        b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

        public void handleEvent(ButtonEvent be) {
          Opt_opcao_tramiteUpdateDeleteGWT opt_opcao_tramiteUpdateDeleteGWT = new Opt_opcao_tramiteUpdateDeleteGWT();
          opt_opcao_tramiteUpdateDeleteGWT.setOpt_opcao_tramiteConsult(Opt_opcao_tramiteConsultGWT.this);
          opt_opcao_tramiteUpdateDeleteGWT.load(model);
          opt_opcao_tramiteUpdateDeleteGWT.setVisible(true);
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
    opt_opcao_tramiteDao.consultarTodos();
    Timer timer = new Timer() {
      public void run() {
        ListStore<Opt_opcao_tramiteTGWT> list = opt_opcao_tramiteDao.getList();
        if (list == null) {
          schedule(500);
        } else {
          
          if (grid !=  null) {
            grid.removeFromParent();
          }

          ColumnModel cm = new ColumnModel(configs);

          PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
          PagingLoader<PagingLoadResult<Opt_opcao_tramiteTGWT>> loader = new BasePagingLoader<PagingLoadResult<Opt_opcao_tramiteTGWT>>(proxy);
          loader.setRemoteSort(true);

          ListStore<Opt_opcao_tramiteTGWT> store = new ListStore<Opt_opcao_tramiteTGWT>(loader);
          store.add(list.getModels());

          getToolBarPage().setPageSize(20);
          getToolBarPage().bind(loader);
          loader.load(0, 20);

          grid = new Grid<Opt_opcao_tramiteTGWT>(store, cm);
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
