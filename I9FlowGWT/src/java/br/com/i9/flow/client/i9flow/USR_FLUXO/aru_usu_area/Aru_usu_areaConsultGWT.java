/*
 * EasyNet JDragon
 */
package br.com.i9.flow.client.i9flow.USR_FLUXO.aru_usu_area;

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
public class Aru_usu_areaConsultGWT extends ConsultarBaseGWT {

  private Grid<Aru_usu_areaTGWT> grid = null;
  private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
  private Aru_usu_areaDAOGWT aru_usu_areaDao = new Aru_usu_areaDAOGWT();

  public Aru_usu_areaConsultGWT() {
    setHeaderVisible(false);
    this.setSize("500", "400");
    final NumberFormat currency = NumberFormat.getCurrencyFormat();
    final NumberFormat number = NumberFormat.getFormat("0.00");
    final NumberCellRenderer<Grid<Aru_usu_areaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Aru_usu_areaTGWT>>(currency);
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
            column.setId("usu_nr_id");
            column.setHeader("Usu_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("are_nr_id");
            column.setHeader("Are_nr_id");
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
    Aru_usu_areaInsertGWT aru_usu_areaInsertGWT = new Aru_usu_areaInsertGWT();
    aru_usu_areaInsertGWT.setAru_usu_areaConsult(this);
    aru_usu_areaInsertGWT.setModal(true);
    aru_usu_areaInsertGWT.show();
  }
  private GridCellRenderer<Aru_usu_areaTGWT> getEditarRender() {
    return new GridCellRenderer<Aru_usu_areaTGWT>() {

      public Object render(final Aru_usu_areaTGWT model, String property, ColumnData config, final int rowIndex,
        final int colIndex, ListStore<Aru_usu_areaTGWT> store, Grid<Aru_usu_areaTGWT> grid) {

        Button b = new Button();
        b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

        public void handleEvent(ButtonEvent be) {
          Aru_usu_areaUpdateDeleteGWT aru_usu_areaUpdateDeleteGWT = new Aru_usu_areaUpdateDeleteGWT();
          aru_usu_areaUpdateDeleteGWT.setAru_usu_areaConsult(Aru_usu_areaConsultGWT.this);
          aru_usu_areaUpdateDeleteGWT.load(model);
          aru_usu_areaUpdateDeleteGWT.setVisible(true);
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
    aru_usu_areaDao.consultarTodos();
    Timer timer = new Timer() {
      public void run() {
        ListStore<Aru_usu_areaTGWT> list = aru_usu_areaDao.getList();
        if (list == null) {
          schedule(500);
        } else {
          
          if (grid !=  null) {
            grid.removeFromParent();
          }

          ColumnModel cm = new ColumnModel(configs);

          PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
          PagingLoader<PagingLoadResult<Aru_usu_areaTGWT>> loader = new BasePagingLoader<PagingLoadResult<Aru_usu_areaTGWT>>(proxy);
          loader.setRemoteSort(true);

          ListStore<Aru_usu_areaTGWT> store = new ListStore<Aru_usu_areaTGWT>(loader);
          store.add(list.getModels());

          getToolBarPage().setPageSize(20);
          getToolBarPage().bind(loader);
          loader.load(0, 20);

          grid = new Grid<Aru_usu_areaTGWT>(store, cm);
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
