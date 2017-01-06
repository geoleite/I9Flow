/*
 * EasyNet JDragon
 */
package br.com.i9.flow.client.i9flow.USR_FLUXO.tra_tramite;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.flow.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;


import br.com.i9.flow.client.i9flow.USR_FLUXO.transfer.*;
import br.com.i9.flow.client.i9flow.USR_FLUXO.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.flow.client.i9flow.USR_FLUXO.lgc_logica.Lgc_logicaConsultGWT;
import br.com.i9.flow.client.icons.Icons;

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
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Tra_tramiteConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private List<ColumnConfig> configsValidacao = new ArrayList<ColumnConfig>();
    private Tra_tramiteDAOGWT tra_tramiteDao = new Tra_tramiteDAOGWT();
    private Tid_tipo_documentoDAOGWT tidDao = new Tid_tipo_documentoDAOGWT();
    private ComboBox<Tid_tipo_documentoTGWT> cbTipoDocumento = new ComboBox<Tid_tipo_documentoTGWT>();
    private Lgc_logicaDAOGWT lgcDao = new Lgc_logicaDAOGWT();

    public Tra_tramiteConsultGWT() {
        setHeaderVisible(false);
        getBtnNovoSuper().setVisible(false);
        getDataEAST().setSize(350);
        add(getCpRight(), getDataEAST());
        getCpRight().setLayout(new FitLayout());
        getCpRight().setHeading("Validações");
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Tra_tramiteTGWT>> numberRenderer = new NumberCellRenderer<Grid<Tra_tramiteTGWT>>(currency);
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

        cbTipoDocumento.setEmptyText("Sel. Tipo de Documento");
        cbTipoDocumento.setDisplayField("tid_tx_nome");
        cbTipoDocumento.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbTipoDocumento.setMinChars(1);
        cbTipoDocumento.setTypeAhead(true);
        cbTipoDocumento.addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<Tid_tipo_documentoTGWT>>() {

            public void handleEvent(SelectionChangedEvent<Tid_tipo_documentoTGWT> be) {
                load();
            }
        });

        GridCellRenderer<Tra_tramiteTGWT> gridProcAutomatico = new GridCellRenderer<Tra_tramiteTGWT>() {

            public Object render(Tra_tramiteTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Tra_tramiteTGWT> store, Grid<Tra_tramiteTGWT> grid) {
                String txt = "<div style='color:cor'>valor</div>";
                String cor = "green";
                String valor = "Automático";
                if ("N".equals(model.getTra_tx_automatico())) {
                    cor = "red";
                    valor = "Manual";
                }
                txt = txt.replaceAll("cor", cor);
                txt = txt.replaceAll("valor", valor);
                return txt;
            }
        };

        getToolBarMaster().add(cbTipoDocumento);

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("tra_tx_nome");
        column.setHeader("Nome Trâmite");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("tra_tx_automatico");
        column.setHeader("Processamento");
        column.setWidth(100);
        column.setRenderer(gridProcAutomatico);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("tra_nr_ordem");
        column.setHeader("Ordem");
        column.setWidth(60);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("colLogicas");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getLogicaRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("colTramite");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        //Definindo colunas para o grid de tramites

        GridCellRenderer<Lgc_logicaTGWT> gridStatus = new GridCellRenderer<Lgc_logicaTGWT>() {

            public Object render(Lgc_logicaTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Lgc_logicaTGWT> store, Grid<Lgc_logicaTGWT> grid) {
                String txt = "<div style='color:cor'>valor</div>";
                String cor = "green";
                String valor = "Ativo";
                if ("I".equals(model.getLgc_tx_status())) {
                    cor = "red";
                    valor = "Inativo";
                }
                txt = txt.replaceAll("cor", cor);
                txt = txt.replaceAll("valor", valor);
                return txt;
            }
        };

        column = new ColumnConfig();
        column.setId("lgc_tx_descricao");
        column.setHeader("Descrição");
        column.setWidth(250);
        column.setAlignment(HorizontalAlignment.LEFT);
        configsValidacao.add(column);

        column = new ColumnConfig();
        column.setId("lgc_tx_status");
        column.setHeader("Status");
        column.setWidth(60);
        column.setRenderer(getStatusRender());
        column.setAlignment(HorizontalAlignment.LEFT);
        configsValidacao.add(column);

        loadTiposDocumentos();
    }

    private void montarTramiteFilhos(Tra_tramiteTGWT traT) {
        //ContentPanel cpTramiteFilhos  = new ContentPanel();
        //ContentPanel cpValidacoes  = new ContentPanel();

        Lgc_logicaTGWT lgcT = new Lgc_logicaTGWT();
        lgcT.setTra_nr_id(traT.getTra_nr_id());

        lgcDao.consultByTramite(lgcT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Lgc_logicaTGWT> list = lgcDao.getList();

                if (list == null) {
                    schedule(500);
                } else {
                    getCpRight().removeAll();

                    ColumnModel cm = new ColumnModel(configsValidacao);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Lgc_logicaTGWT>> loader = new BasePagingLoader<PagingLoadResult<Lgc_logicaTGWT>>(proxy);
                    loader.setRemoteSort(true);

                    ListStore<Lgc_logicaTGWT> store = new ListStore<Lgc_logicaTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);


                    Grid<Lgc_logicaTGWT> grid = new Grid<Lgc_logicaTGWT>(store, cm);
                    grid.setId("grid");
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    getCpRight().add(grid);
                    getCpRight().layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void loadTiposDocumentos() {
        tidDao.consultarTodos();
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Tid_tipo_documentoTGWT> list = tidDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    cbTipoDocumento.setStore(list);
                    cbTipoDocumento.getView().refresh();
                }
            }
        };
        timer.schedule(500);
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Tra_tramiteInsertGWT tra_tramiteInsertGWT = new Tra_tramiteInsertGWT();
        tra_tramiteInsertGWT.setTra_tramiteConsult(this);
        tra_tramiteInsertGWT.setModal(true);
        tra_tramiteInsertGWT.show();

    }

    private GridCellRenderer<Tra_tramiteTGWT> getEditarRender() {
        return new GridCellRenderer<Tra_tramiteTGWT>() {

            public Object render(final Tra_tramiteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tra_tramiteTGWT> store, Grid<Tra_tramiteTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        montarTramiteFilhos(model);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar Trâmite.");
                b.setIcon(Icons.ICONS.tramite());
                b.setId("btnEditar");

                return b;
            }
        };
    }

    private GridCellRenderer<Tra_tramiteTGWT> getLogicaRender() {
        return new GridCellRenderer<Tra_tramiteTGWT>() {

            public Object render(final Tra_tramiteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tra_tramiteTGWT> store, Grid<Tra_tramiteTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Lgc_logicaConsultGWT lgcConsult = new Lgc_logicaConsultGWT();
                        lgcConsult.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Lógicas Validações.");
                b.setIcon(Icons.ICONS.tramite());
                b.setId("btnLogica");
                return b;
            }
        };
    }

    private GridCellRenderer<Lgc_logicaTGWT> getStatusRender() {
        return new GridCellRenderer<Lgc_logicaTGWT>() {

            public Object render(final Lgc_logicaTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Lgc_logicaTGWT> store, Grid<Lgc_logicaTGWT> grid) {

                String txt = "<div style='color:cor'>valor</div>";
                String cor = "yellow";
                String valor = "Ativo";
                if ("I".equals(model.getLgc_tx_status())) {
                    cor = "red";
                    valor = "Inativo";
                }
                txt = txt.replaceAll("cor", cor);
                txt = txt.replaceAll("valor", valor);

                Button b = new Button();
                b.setText(txt);
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        alterarStatusValidacao(model);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar Status");
                //b.setIcon(Icones.ICONS.tramite());
                b.setId("btnStatusLgc");

                return b;
            }
        };
    }

    /**
     * Altera o status da validação com a penas um clique
     * @param lgcT
     */
    private void alterarStatusValidacao(final Lgc_logicaTGWT lgcT) {
        lgcT.setLgc_tx_status("A".equalsIgnoreCase(lgcT.getLgc_tx_status()) ? "I" : "A");
        lgcDao.alterar(lgcT);
        Timer timer = new Timer() {

            public void run() {
                String msg = lgcDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Tra_tramiteTGWT traT = new Tra_tramiteTGWT();
                        traT.setTra_nr_id(lgcT.getTra_nr_id());
                        montarTramiteFilhos(traT);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void load() {
        if (cbTipoDocumento.getValue() == null) {
            MessageBox.alert("ATENÇÃO", "É necessário selecionar um tipo de documento.", null);
            return;
        }
        tra_tramiteDao.consultByTipoDocumento(cbTipoDocumento.getValue().getTid_nr_id());
        Timer timer = new Timer() {

            public void run() {
                ListStore<Tra_tramiteTGWT> list = tra_tramiteDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Tra_tramiteTGWT>> loader = new BasePagingLoader<PagingLoadResult<Tra_tramiteTGWT>>(proxy);
                    loader.setRemoteSort(true);

                    ListStore<Tra_tramiteTGWT> store = new ListStore<Tra_tramiteTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);


                    Grid<Tra_tramiteTGWT> grid = new Grid<Tra_tramiteTGWT>(store, cm);
                    grid.setId("grid");
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

//                    grid.addListener(Events.OnClick, new Listener<GridEvent<Per_perfilTGWT>>() {
//
//                        public void handleEvent(GridEvent<Per_perfilTGWT> be) {
//                            montarAcordion(be.getModel());
//                        }
//                    });

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }
}
