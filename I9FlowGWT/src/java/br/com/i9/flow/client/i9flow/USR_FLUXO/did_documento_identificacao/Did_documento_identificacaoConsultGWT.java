/*
 * EasyNet JDragon
 */
package br.com.i9.flow.client.i9flow.USR_FLUXO.did_documento_identificacao;

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
public class Did_documento_identificacaoConsultGWT extends ConsultarBaseGWT {

  private Grid<Did_documento_identificacaoTGWT> grid = null;
  private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
  private Did_documento_identificacaoDAOGWT did_documento_identificacaoDao = new Did_documento_identificacaoDAOGWT();

  public Did_documento_identificacaoConsultGWT() {
    setHeaderVisible(false);
    this.setSize("500", "400");
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Did_documento_identificacaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Did_documento_identificacaoTGWT>>(currency);
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
            column.setId("did_nr_id");
            column.setHeader("Did_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("flx_nr_id");
            column.setHeader("Flx_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("did_tx_nomecoluna");
            column.setHeader("Did_tx_nomecoluna");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("did_tx_valor");
            column.setHeader("Did_tx_valor");
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
    Did_documento_identificacaoInsertGWT did_documento_identificacaoInsertGWT = new Did_documento_identificacaoInsertGWT();
    did_documento_identificacaoInsertGWT.setDid_documento_identificacaoConsult(this);
    did_documento_identificacaoInsertGWT.setModal(true);
    did_documento_identificacaoInsertGWT.show();
  }
  private GridCellRenderer<Did_documento_identificacaoTGWT> getEditarRender() {
    return new GridCellRenderer<Did_documento_identificacaoTGWT>() {

      public Object render(final Did_documento_identificacaoTGWT model, String property, ColumnData config, final int rowIndex,
        final int colIndex, ListStore<Did_documento_identificacaoTGWT> store, Grid<Did_documento_identificacaoTGWT> grid) {

        Button b = new Button();
        b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

        public void handleEvent(ButtonEvent be) {
          Did_documento_identificacaoUpdateDeleteGWT did_documento_identificacaoUpdateDeleteGWT = new Did_documento_identificacaoUpdateDeleteGWT();
          did_documento_identificacaoUpdateDeleteGWT.setDid_documento_identificacaoConsult(Did_documento_identificacaoConsultGWT.this);
          did_documento_identificacaoUpdateDeleteGWT.load(model);
          did_documento_identificacaoUpdateDeleteGWT.setVisible(true);
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
    did_documento_identificacaoDao.consultarTodos();
    Timer timer = new Timer() {
      public void run() {
        ListStore<Did_documento_identificacaoTGWT> list = did_documento_identificacaoDao.getList();
        if (list == null) {
          schedule(500);
        } else {
          
          if (grid !=  null) {
            grid.removeFromParent();
          }

          ColumnModel cm = new ColumnModel(configs);

          PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
          PagingLoader<PagingLoadResult<Did_documento_identificacaoTGWT>> loader = new BasePagingLoader<PagingLoadResult<Did_documento_identificacaoTGWT>>(proxy);
          loader.setRemoteSort(true);

          ListStore<Did_documento_identificacaoTGWT> store = new ListStore<Did_documento_identificacaoTGWT>(loader);
          store.add(list.getModels());

          getToolBarPage().setPageSize(20);
          getToolBarPage().bind(loader);
          loader.load(0, 20);

          grid = new Grid<Did_documento_identificacaoTGWT>(store, cm);
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
