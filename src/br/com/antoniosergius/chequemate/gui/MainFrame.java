package br.com.antoniosergius.chequemate.gui;

import br.com.antoniosergius.chequemate.ctrl.CheckController;
import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.gui.dialog.About;
import br.com.antoniosergius.chequemate.gui.dialog.AddClient;
import br.com.antoniosergius.chequemate.gui.dialog.AlterLookAndFeel;
import br.com.antoniosergius.chequemate.gui.dialog.AlterMySQLParameter;
import br.com.antoniosergius.chequemate.gui.dialog.AlterParameters;
import br.com.antoniosergius.chequemate.gui.dialog.AlterPreferences;
import br.com.antoniosergius.chequemate.gui.dialog.BetweenDates;
import br.com.antoniosergius.chequemate.gui.dialog.CheckCashing;
import br.com.antoniosergius.chequemate.gui.dialog.LoanSimulator;
import br.com.antoniosergius.chequemate.gui.dialog.LoginSystem;
import br.com.antoniosergius.chequemate.gui.dialog.ViewAllClients;
import br.com.antoniosergius.chequemate.gui.dialog.ViewAllHolidays;
import br.com.antoniosergius.chequemate.gui.dialog.ViewAllPayees;
import br.com.antoniosergius.chequemate.gui.dialog.ViewAllRetentions;
import br.com.antoniosergius.chequemate.gui.dialog.bkp.BackupBuilder;
import br.com.antoniosergius.chequemate.gui.dialog.bkp.RestoreBuilder;
import br.com.antoniosergius.chequemate.gui.dialog.query.ReportByClient;
import br.com.antoniosergius.chequemate.gui.dialog.query.ReportByClientAndInputDate;
import br.com.antoniosergius.chequemate.gui.dialog.query.ReportByClientAndInputRange;
import br.com.antoniosergius.chequemate.obj.Holiday;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.MyPath;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Format;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.border.DropShadowBorder;
import org.joda.time.DateMidnight;

public class MainFrame extends javax.swing.JFrame {
   private static final long serialVersionUID = 1L;
   private static final Logger LOG = Logger.getLogger(MainFrame.class.getName());

   private Connection conn;
   private ClientController clientControl;
   private CheckController checkControl;
   private final GregorianCalendar selectedDate = new GregorianCalendar();
   private MainFrame mainFrame;

   public MainFrame() {
      initComponents();
      setupComponents();
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        toolBar = new javax.swing.JToolBar();
        buttonClientes = new javax.swing.JButton();
        buttonConsultas = new javax.swing.JButton();
        buttonCadastrar = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        iconesSeparator = new javax.swing.JToolBar.Separator();
        buttonSair = new javax.swing.JButton();
        monthView = new org.jdesktop.swingx.JXMonthView();
        labelDaysBetween = new org.jdesktop.swingx.JXLabel();
        labelConsultar = new org.jdesktop.swingx.JXLabel();
        labelClientes = new org.jdesktop.swingx.JXLabel();
        labelCadastrar = new org.jdesktop.swingx.JXLabel();
        labelCalcularDesconto = new org.jdesktop.swingx.JXLabel();
        labelSimularEmprestimo = new org.jdesktop.swingx.JXLabel();
        labelEmitentes = new org.jdesktop.swingx.JXLabel();
        labelConsultaExtendida = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        taskPane = new org.jdesktop.swingx.JXTaskPane();
        labelTotalGeral = new org.jdesktop.swingx.JXLabel();
        labelTotalMes = new org.jdesktop.swingx.JXLabel();
        labelTotalCheques = new org.jdesktop.swingx.JXLabel();
        labelMediaCliente = new org.jdesktop.swingx.JXLabel();
        labelMediaPorCheque = new org.jdesktop.swingx.JXLabel();
        labelPrimeiroCliente = new org.jdesktop.swingx.JXLabel();
        labelUltimoCliente = new org.jdesktop.swingx.JXLabel();
        labelGrossAmount = new org.jdesktop.swingx.JXLabel();
        labelGrossByMonth = new org.jdesktop.swingx.JXLabel();
        labelCheckAmount = new org.jdesktop.swingx.JXLabel();
        labelAverageByClient = new org.jdesktop.swingx.JXLabel();
        labelAverageByCheck = new org.jdesktop.swingx.JXLabel();
        labelHigherClient = new org.jdesktop.swingx.JXLabel();
        labelLowerClient = new org.jdesktop.swingx.JXLabel();
        labelTotalClientes = new org.jdesktop.swingx.JXLabel();
        labelClientAmount = new org.jdesktop.swingx.JXLabel();
        labelClientesAtivos = new org.jdesktop.swingx.JXLabel();
        labelActiveClientAmount = new org.jdesktop.swingx.JXLabel();
        labelGeralAVencer = new org.jdesktop.swingx.JXLabel();
        labelAmountUnexpired = new org.jdesktop.swingx.JXLabel();
        labelCadastradoHoje = new org.jdesktop.swingx.JXLabel();
        labelAmountRecordedToday = new org.jdesktop.swingx.JXLabel();
        labelQuantCadastradoHoje = new org.jdesktop.swingx.JXLabel();
        labelRecordedToday = new org.jdesktop.swingx.JXLabel();
        labelRetencaoHoje = new org.jdesktop.swingx.JXLabel();
        labelTodayRetention = new org.jdesktop.swingx.JXLabel();
        labelTotalRestanteMes = new org.jdesktop.swingx.JXLabel();
        labelMonthAmountLeft = new javax.swing.JLabel();
        statusBar = new org.jdesktop.swingx.JXStatusBar();
        labelDataBase = new org.jdesktop.swingx.JXLabel();
        labelTodayDate = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuItemExit = new javax.swing.JMenuItem();
        menuCheques = new javax.swing.JMenu();
        menuItemOpenChecks = new javax.swing.JMenuItem();
        menuItemConsultaExt = new javax.swing.JMenuItem();
        menuItemRecordCheck = new javax.swing.JMenuItem();
        menuItemCalcularDesconto = new javax.swing.JMenuItem();
        menuItemBetweenDates = new javax.swing.JMenuItem();
        menuItemEmitentes = new javax.swing.JMenuItem();
        menuItemSimuladorEmprestimo = new javax.swing.JMenuItem();
        menuItemVisualizarRetencoes = new javax.swing.JMenuItem();
        separatorCheques = new javax.swing.JPopupMenu.Separator();
        menuItemCheckByClient = new javax.swing.JMenuItem();
        menuItemQueryInputAndClient = new javax.swing.JMenuItem();
        menuItemInputRangeAndClient = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenu();
        menuItemOpenClients = new javax.swing.JMenuItem();
        menuItemAddClient = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuItemHolidays = new javax.swing.JMenuItem();
        menuItemParameters = new javax.swing.JMenuItem();
        menuItemPreferences = new javax.swing.JMenuItem();
        menuSistema = new javax.swing.JMenu();
        menuItemChangeLAF = new javax.swing.JMenuItem();
        menuItemSetDataBaseParam = new javax.swing.JMenuItem();
        separatorSistema = new javax.swing.JPopupMenu.Separator();
        menuBackup = new javax.swing.JMenu();
        menuItemBackupCreate = new javax.swing.JMenuItem();
        menuItemBackupRestore = new javax.swing.JMenuItem();
        menuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        buttonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.client.png"))); // NOI18N
        buttonClientes.setToolTipText("Visualizar Clientes");
        buttonClientes.setFocusable(false);
        buttonClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });
        toolBar.add(buttonClientes);

        buttonConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.search.png"))); // NOI18N
        buttonConsultas.setToolTipText("Abrir / Localizar Cheques");
        buttonConsultas.setFocusable(false);
        buttonConsultas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonConsultas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultasActionPerformed(evt);
            }
        });
        toolBar.add(buttonConsultas);

        buttonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.calc.png"))); // NOI18N
        buttonCadastrar.setToolTipText("Novo Cadastro de Cheques");
        buttonCadastrar.setFocusable(false);
        buttonCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCadastrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });
        toolBar.add(buttonCadastrar);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.refresh.png"))); // NOI18N
        buttonRefresh.setToolTipText("Atualizar Informações do Sistema");
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        toolBar.add(buttonRefresh);
        toolBar.add(iconesSeparator);

        buttonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.exit.png"))); // NOI18N
        buttonSair.setToolTipText("Fechar Aplicativo");
        buttonSair.setFocusable(false);
        buttonSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });
        toolBar.add(buttonSair);

        monthView.setForeground(new java.awt.Color(51, 51, 51));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        monthView.setBorder(dropShadowBorder1);
        monthView.setBoxPaddingX(2);
        monthView.setBoxPaddingY(1);
        monthView.setDaysOfTheWeekForeground(new java.awt.Color(255, 102, 0));
        monthView.setMonthStringInsets(new java.awt.Insets(1, 1, 1, 1));
        monthView.setTodayBackground(new java.awt.Color(255, 102, 0));
        monthView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthViewActionPerformed(evt);
            }
        });

        labelDaysBetween.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDaysBetween.setText("         ");
        labelDaysBetween.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelConsultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.search.png"))); // NOI18N
        labelConsultar.setMaxLineSpan(0);
        labelConsultar.setText("Consulta");
        labelConsultar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelConsultar.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        labelConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        labelConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelConsultarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelConsultarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelConsultarMousePressed(evt);
            }
        });

        labelClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.client.png"))); // NOI18N
        labelClientes.setText("Clientes");
        labelClientes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelClientes.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.JUSTIFY);
        labelClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        labelClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelClientesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelClientesMousePressed(evt);
            }
        });

        labelCadastrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.calc.png"))); // NOI18N
        labelCadastrar.setText("Cadastrar Cheques");
        labelCadastrar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelCadastrar.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        labelCadastrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        labelCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCadastrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCadastrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelCadastrarMousePressed(evt);
            }
        });

        labelCalcularDesconto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCalcularDesconto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.cash.png"))); // NOI18N
        labelCalcularDesconto.setText("Calcular Desconto");
        labelCalcularDesconto.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelCalcularDesconto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelCalcularDesconto.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        labelCalcularDesconto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        labelCalcularDesconto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCalcularDescontoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCalcularDescontoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelCalcularDescontoMousePressed(evt);
            }
        });

        labelSimularEmprestimo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSimularEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.loan.png"))); // NOI18N
        labelSimularEmprestimo.setText("Simular Empréstimo");
        labelSimularEmprestimo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelSimularEmprestimo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelSimularEmprestimo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        labelSimularEmprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelSimularEmprestimoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelSimularEmprestimoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelSimularEmprestimoMousePressed(evt);
            }
        });

        labelEmitentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmitentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.payee.png"))); // NOI18N
        labelEmitentes.setText("Emitentes");
        labelEmitentes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelEmitentes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelEmitentes.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);
        labelEmitentes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        labelEmitentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelEmitentesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelEmitentesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelEmitentesMousePressed(evt);
            }
        });

        labelConsultaExtendida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelConsultaExtendida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.search.ext.png"))); // NOI18N
        labelConsultaExtendida.setText("Consulta extendida");
        labelConsultaExtendida.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelConsultaExtendida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelConsultaExtendida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        labelConsultaExtendida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelConsultaExtendidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelConsultaExtendidaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelConsultaExtendidaMousePressed(evt);
            }
        });

        taskPane.setCollapsed(true);
        taskPane.setScrollOnExpand(true);
        taskPane.setSpecial(true);
        taskPane.setTitle("Informações do Sistema");

        labelTotalGeral.setForeground(new java.awt.Color(255, 102, 0));
        labelTotalGeral.setText("Total Geral: ");
        labelTotalGeral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelTotalMes.setText("Total do Mês: ");
        labelTotalMes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelTotalCheques.setText("Quantidade de Cheques: ");
        labelTotalCheques.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelMediaCliente.setForeground(new java.awt.Color(255, 102, 0));
        labelMediaCliente.setText("Média por Cliente Ativo: ");
        labelMediaCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelMediaPorCheque.setText("Média por Cheque: ");
        labelMediaPorCheque.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelPrimeiroCliente.setForeground(new java.awt.Color(255, 102, 0));
        labelPrimeiroCliente.setText("Primeiro Cliente: ");
        labelPrimeiroCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelUltimoCliente.setText("Último Cliente Ativo: ");
        labelUltimoCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelGrossAmount.setForeground(new java.awt.Color(255, 102, 0));
        labelGrossAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelGrossAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelGrossByMonth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelGrossByMonth.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelCheckAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCheckAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelAverageByClient.setForeground(new java.awt.Color(255, 102, 0));
        labelAverageByClient.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAverageByClient.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelAverageByCheck.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAverageByCheck.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelHigherClient.setForeground(new java.awt.Color(255, 102, 0));
        labelHigherClient.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelHigherClient.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelLowerClient.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelLowerClient.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelTotalClientes.setForeground(new java.awt.Color(255, 102, 0));
        labelTotalClientes.setText("Quantidade de Clientes:");
        labelTotalClientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelClientAmount.setForeground(new java.awt.Color(255, 102, 0));
        labelClientAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelClientAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelClientesAtivos.setText("Quant.  Clientes Ativos:");
        labelClientesAtivos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelActiveClientAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelActiveClientAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelGeralAVencer.setText("Total Geral a Vencer:");
        labelGeralAVencer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelAmountUnexpired.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAmountUnexpired.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelCadastradoHoje.setForeground(new java.awt.Color(255, 102, 0));
        labelCadastradoHoje.setText("Total Cadastrado Hoje:");
        labelCadastradoHoje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelAmountRecordedToday.setForeground(new java.awt.Color(255, 102, 0));
        labelAmountRecordedToday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAmountRecordedToday.setText(" ");
        labelAmountRecordedToday.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelQuantCadastradoHoje.setText("Quant. Cadastrados Hoje:");
        labelQuantCadastradoHoje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelRecordedToday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelRecordedToday.setText(" ");
        labelRecordedToday.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelRetencaoHoje.setForeground(new java.awt.Color(255, 102, 0));
        labelRetencaoHoje.setText("Retenção de Hoje:");
        labelRetencaoHoje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelTodayRetention.setForeground(new java.awt.Color(255, 102, 0));
        labelTodayRetention.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTodayRetention.setText(" ");
        labelTodayRetention.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelTotalRestanteMes.setForeground(new java.awt.Color(255, 102, 0));
        labelTotalRestanteMes.setText("Total Restante do Mês:");
        labelTotalRestanteMes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labelMonthAmountLeft.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelMonthAmountLeft.setForeground(new java.awt.Color(255, 102, 0));
        labelMonthAmountLeft.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelMonthAmountLeft.setText(" ");

        javax.swing.GroupLayout taskPaneLayout = new javax.swing.GroupLayout(taskPane.getContentPane());
        taskPane.getContentPane().setLayout(taskPaneLayout);
        taskPaneLayout.setHorizontalGroup(
            taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskPaneLayout.createSequentialGroup()
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelRetencaoHoje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelQuantCadastradoHoje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(labelCadastradoHoje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGeralAVencer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPrimeiroCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMediaPorCheque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMediaCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotalCheques, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotalMes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotalClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelClientesAtivos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelUltimoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotalRestanteMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotalGeral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelHigherClient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAverageByCheck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAverageByClient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelActiveClientAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCheckAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGrossByMonth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGrossAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLowerClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelClientAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAmountUnexpired, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAmountRecordedToday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRecordedToday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTodayRetention, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMonthAmountLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
        );

        taskPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelActiveClientAmount, labelAmountRecordedToday, labelAmountUnexpired, labelAverageByCheck, labelAverageByClient, labelCadastradoHoje, labelCheckAmount, labelClientAmount, labelClientesAtivos, labelGeralAVencer, labelGrossAmount, labelGrossByMonth, labelHigherClient, labelLowerClient, labelMediaCliente, labelMediaPorCheque, labelMonthAmountLeft, labelPrimeiroCliente, labelQuantCadastradoHoje, labelRecordedToday, labelRetencaoHoje, labelTodayRetention, labelTotalCheques, labelTotalClientes, labelTotalGeral, labelTotalMes, labelTotalRestanteMes, labelUltimoCliente});

        taskPaneLayout.setVerticalGroup(
            taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskPaneLayout.createSequentialGroup()
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelGrossAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTotalMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGrossByMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotalRestanteMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMonthAmountLeft))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelGeralAVencer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAmountUnexpired, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCadastradoHoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAmountRecordedToday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantCadastradoHoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRecordedToday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRetencaoHoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTodayRetention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTotalCheques, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCheckAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTotalClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelClientAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelActiveClientAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMediaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAverageByClient, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMediaPorCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAverageByCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrimeiroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHigherClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taskPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLowerClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUltimoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        taskPaneLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelActiveClientAmount, labelAmountRecordedToday, labelAmountUnexpired, labelAverageByCheck, labelAverageByClient, labelCadastradoHoje, labelCheckAmount, labelClientAmount, labelClientesAtivos, labelGeralAVencer, labelGrossAmount, labelGrossByMonth, labelHigherClient, labelLowerClient, labelMediaCliente, labelMediaPorCheque, labelMonthAmountLeft, labelPrimeiroCliente, labelQuantCadastradoHoje, labelRecordedToday, labelRetencaoHoje, labelTodayRetention, labelTotalCheques, labelTotalClientes, labelTotalGeral, labelTotalMes, labelTotalRestanteMes, labelUltimoCliente});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(taskPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(taskPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelConsultaExtendida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmitentes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSimularEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCalcularDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monthView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDaysBetween, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelCadastrar, labelCalcularDesconto, labelConsultaExtendida, labelConsultar, labelEmitentes, labelSimularEmprestimo});

        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCalcularDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSimularEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(labelCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmitentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelConsultaExtendida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(labelDaysBetween, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthView, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelCadastrar, labelCalcularDesconto, labelClientes, labelConsultaExtendida, labelConsultar, labelEmitentes, labelSimularEmprestimo});

        statusBar.setBackground(new java.awt.Color(204, 204, 204));

        labelDataBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.connected.png"))); // NOI18N
        labelDataBase.setText("     ");
        labelDataBase.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.desconnected.png"))); // NOI18N
        labelDataBase.setEnabled(false);

        labelTodayDate.setText("dataHoje");

        javax.swing.GroupLayout statusBarLayout = new javax.swing.GroupLayout(statusBar);
        statusBar.setLayout(statusBarLayout);
        statusBarLayout.setHorizontalGroup(
            statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusBarLayout.createSequentialGroup()
                .addComponent(labelDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTodayDate)
                .addContainerGap())
        );
        statusBarLayout.setVerticalGroup(
            statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labelDataBase, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelTodayDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuArquivo.setText("Arquivo");

        menuItemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.close.png"))); // NOI18N
        menuItemExit.setText("Fechar");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuArquivo.add(menuItemExit);

        menuBar.add(menuArquivo);

        menuCheques.setText("Cheques");
        menuCheques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChequesActionPerformed(evt);
            }
        });

        menuItemOpenChecks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.search.png"))); // NOI18N
        menuItemOpenChecks.setText("Abrir Consulta...");
        menuItemOpenChecks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenChecksActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemOpenChecks);

        menuItemConsultaExt.setText("Abrir Consulta Extendida...");
        menuItemConsultaExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConsultaExtActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemConsultaExt);

        menuItemRecordCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.calc.png"))); // NOI18N
        menuItemRecordCheck.setText("Cadastrar Cheques...");
        menuItemRecordCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRecordCheckActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemRecordCheck);

        menuItemCalcularDesconto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.cash.png"))); // NOI18N
        menuItemCalcularDesconto.setText("Calcular Desconto...");
        menuItemCalcularDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCalcularDescontoActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemCalcularDesconto);

        menuItemBetweenDates.setText("Calcular Dias Entre Datas...");
        menuItemBetweenDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBetweenDatesActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemBetweenDates);

        menuItemEmitentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.payee.png"))); // NOI18N
        menuItemEmitentes.setText("Emitentes Cadastrados...");
        menuItemEmitentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEmitentesActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemEmitentes);

        menuItemSimuladorEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.loan.png"))); // NOI18N
        menuItemSimuladorEmprestimo.setText("Simular Empréstimo...");
        menuItemSimuladorEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSimuladorEmprestimoActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemSimuladorEmprestimo);

        menuItemVisualizarRetencoes.setText("Visualizar Retenções");
        menuItemVisualizarRetencoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVisualizarRetencoesActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemVisualizarRetencoes);
        menuCheques.add(separatorCheques);

        menuItemCheckByClient.setText("Consultar por Cliente");
        menuItemCheckByClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCheckByClientActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemCheckByClient);

        menuItemQueryInputAndClient.setText("Consultar por Data de Entrada e Cliente");
        menuItemQueryInputAndClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQueryInputAndClientActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemQueryInputAndClient);

        menuItemInputRangeAndClient.setText("Consultar por Intervalo de Data de Entrada e Cliente");
        menuItemInputRangeAndClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInputRangeAndClientActionPerformed(evt);
            }
        });
        menuCheques.add(menuItemInputRangeAndClient);

        menuBar.add(menuCheques);

        menuClientes.setText("Clientes");

        menuItemOpenClients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.client.png"))); // NOI18N
        menuItemOpenClients.setText("Abrir...");
        menuItemOpenClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenClientsActionPerformed(evt);
            }
        });
        menuClientes.add(menuItemOpenClients);

        menuItemAddClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.add.png"))); // NOI18N
        menuItemAddClient.setText("Adicionar...");
        menuItemAddClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAddClientActionPerformed(evt);
            }
        });
        menuClientes.add(menuItemAddClient);

        menuBar.add(menuClientes);

        menuEditar.setText("Editar");

        menuItemHolidays.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.date.png"))); // NOI18N
        menuItemHolidays.setText("Feriados...");
        menuItemHolidays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHolidaysActionPerformed(evt);
            }
        });
        menuEditar.add(menuItemHolidays);

        menuItemParameters.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.edit.png"))); // NOI18N
        menuItemParameters.setText("Parametros...");
        menuItemParameters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemParametersActionPerformed(evt);
            }
        });
        menuEditar.add(menuItemParameters);

        menuItemPreferences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.preferences.png"))); // NOI18N
        menuItemPreferences.setText("Preferências...");
        menuItemPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPreferencesActionPerformed(evt);
            }
        });
        menuEditar.add(menuItemPreferences);

        menuBar.add(menuEditar);

        menuSistema.setText("Sistema");

        menuItemChangeLAF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.theme.png"))); // NOI18N
        menuItemChangeLAF.setText("Alterar Tema...");
        menuItemChangeLAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemChangeLAFActionPerformed(evt);
            }
        });
        menuSistema.add(menuItemChangeLAF);

        menuItemSetDataBaseParam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.gear.png"))); // NOI18N
        menuItemSetDataBaseParam.setText("Banco de Dados...");
        menuItemSetDataBaseParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSetDataBaseParamActionPerformed(evt);
            }
        });
        menuSistema.add(menuItemSetDataBaseParam);
        menuSistema.add(separatorSistema);

        menuBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.save.png"))); // NOI18N
        menuBackup.setText("Backup");

        menuItemBackupCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.backup.png"))); // NOI18N
        menuItemBackupCreate.setText("Criar...");
        menuItemBackupCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBackupCreateActionPerformed(evt);
            }
        });
        menuBackup.add(menuItemBackupCreate);

        menuItemBackupRestore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.restore.png"))); // NOI18N
        menuItemBackupRestore.setText("Restaurar...");
        menuItemBackupRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBackupRestoreActionPerformed(evt);
            }
        });
        menuBackup.add(menuItemBackupRestore);

        menuSistema.add(menuBackup);

        menuItemSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.info.png"))); // NOI18N
        menuItemSobre.setText("Sobre o ChequeMate...");
        menuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSobreActionPerformed(evt);
            }
        });
        menuSistema.add(menuItemSobre);

        menuBar.add(menuSistema);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      SwingUtilities.invokeLater(() -> {
         LoginSystem loginDialog = new LoginSystem(this, true);
         loginDialog.setLocationRelativeTo(this);
         loginDialog.setVisible(true);
      });
    }//GEN-LAST:event_formWindowOpened

    private void menuItemRecordCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRecordCheckActionPerformed
      SwingUtilities.invokeLater(() -> {
         openRecordCheck();
      });
    }//GEN-LAST:event_menuItemRecordCheckActionPerformed

    private void menuItemCheckByClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCheckByClientActionPerformed
      SwingUtilities.invokeLater(() -> {
         new ReportByClient(this, false, conn, "Relação de Cheques por Cliente:").setVisible(true);
      });
    }//GEN-LAST:event_menuItemCheckByClientActionPerformed

    private void menuItemQueryInputAndClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQueryInputAndClientActionPerformed
      SwingUtilities.invokeLater(() -> {
         new ReportByClientAndInputDate(this, false, conn).setVisible(true);
      });
    }//GEN-LAST:event_menuItemQueryInputAndClientActionPerformed

    private void menuItemInputRangeAndClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInputRangeAndClientActionPerformed
      SwingUtilities.invokeLater(() -> {
         new ReportByClientAndInputRange(this, false, conn).setVisible(true);
      });
    }//GEN-LAST:event_menuItemInputRangeAndClientActionPerformed

    private void menuItemOpenClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenClientsActionPerformed
      SwingUtilities.invokeLater(() -> {
         openClients();
      });
    }//GEN-LAST:event_menuItemOpenClientsActionPerformed

    private void menuItemSetDataBaseParamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSetDataBaseParamActionPerformed
      SwingUtilities.invokeLater(() -> {
         new AlterMySQLParameter(this, false).setVisible(true);
      });
    }//GEN-LAST:event_menuItemSetDataBaseParamActionPerformed

    private void menuItemChangeLAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemChangeLAFActionPerformed
      SwingUtilities.invokeLater(() -> {
         new AlterLookAndFeel(this, true).setVisible(true);
      });
    }//GEN-LAST:event_menuItemChangeLAFActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
      quitApp();
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemOpenChecksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenChecksActionPerformed
      SwingUtilities.invokeLater(() -> {
         openSearch();
      });
    }//GEN-LAST:event_menuItemOpenChecksActionPerformed

    private void buttonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultasActionPerformed
      SwingUtilities.invokeLater(() -> {
         openSearch();
      });
    }//GEN-LAST:event_buttonConsultasActionPerformed

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
      quitApp();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
      SwingUtilities.invokeLater(() -> {
         openRecordCheck();
      });
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void buttonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClientesActionPerformed
      SwingUtilities.invokeLater(() -> {
         openClients();
      });
    }//GEN-LAST:event_buttonClientesActionPerformed

    private void monthViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthViewActionPerformed
      SwingUtilities.invokeLater(() -> {
         selectDate();
      });
    }//GEN-LAST:event_monthViewActionPerformed

    private void menuItemParametersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemParametersActionPerformed
      SwingUtilities.invokeLater(() -> {
         new AlterParameters(this, true, conn).setVisible(true);
      });
    }//GEN-LAST:event_menuItemParametersActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      quitApp();
    }//GEN-LAST:event_formWindowClosing

    private void menuItemHolidaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHolidaysActionPerformed
      SwingUtilities.invokeLater(() -> {
         new ViewAllHolidays(this, false).setVisible(true);
      }); 
    }//GEN-LAST:event_menuItemHolidaysActionPerformed

    private void labelConsultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelConsultarMouseEntered
      setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labelConsultarMouseEntered

    private void labelConsultarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelConsultarMouseExited
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelConsultarMouseExited

    private void labelClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelClientesMouseEntered
      setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labelClientesMouseEntered

    private void labelClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelClientesMouseExited
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelClientesMouseExited

    private void labelCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCadastrarMouseEntered
      setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labelCadastrarMouseEntered

    private void labelCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCadastrarMouseExited
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelCadastrarMouseExited

    private void menuItemAddClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAddClientActionPerformed
      SwingUtilities.invokeLater(() -> {
         new AddClient(this, false, conn, null).setVisible(true);
      });
    }//GEN-LAST:event_menuItemAddClientActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
      SwingUtilities.invokeLater(() -> {
         updateSystemInfo();
      });
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void menuItemBackupCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBackupCreateActionPerformed
      SwingUtilities.invokeLater(() -> {
         openBackup();
      });
    }//GEN-LAST:event_menuItemBackupCreateActionPerformed

    private void menuItemBackupRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBackupRestoreActionPerformed
      SwingUtilities.invokeLater(() -> {
         new RestoreBuilder(this, true).setVisible(true);
      });
    }//GEN-LAST:event_menuItemBackupRestoreActionPerformed

    private void menuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSobreActionPerformed
      SwingUtilities.invokeLater(() -> {
         new About(this, true).setVisible(true);
      });
    }//GEN-LAST:event_menuItemSobreActionPerformed

    private void menuItemSimuladorEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSimuladorEmprestimoActionPerformed
      SwingUtilities.invokeLater(() -> {
         new LoanSimulator(this, true).setVisible(true);
      });
    }//GEN-LAST:event_menuItemSimuladorEmprestimoActionPerformed

    private void menuItemCalcularDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCalcularDescontoActionPerformed
      SwingUtilities.invokeLater(() -> {
         new CheckCashing(this, false).setVisible(true);
      });
    }//GEN-LAST:event_menuItemCalcularDescontoActionPerformed

    private void labelCalcularDescontoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCalcularDescontoMouseEntered
      SwingUtilities.invokeLater(() -> {
         setCursor(new Cursor(Cursor.HAND_CURSOR));
      });
    }//GEN-LAST:event_labelCalcularDescontoMouseEntered

    private void labelCalcularDescontoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCalcularDescontoMouseExited
      SwingUtilities.invokeLater(() -> {
         setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      });
    }//GEN-LAST:event_labelCalcularDescontoMouseExited

    private void labelSimularEmprestimoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimularEmprestimoMouseEntered
      SwingUtilities.invokeLater(() -> {
         setCursor(new Cursor(Cursor.HAND_CURSOR));
      });
    }//GEN-LAST:event_labelSimularEmprestimoMouseEntered

    private void labelSimularEmprestimoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimularEmprestimoMouseExited
      SwingUtilities.invokeLater(() -> {
         setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      });       
    }//GEN-LAST:event_labelSimularEmprestimoMouseExited

    private void menuItemPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPreferencesActionPerformed
      SwingUtilities.invokeLater(() -> {
         new AlterPreferences(this, true).setVisible(true);
      });  
    }//GEN-LAST:event_menuItemPreferencesActionPerformed

    private void menuItemEmitentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEmitentesActionPerformed
      SwingUtilities.invokeLater(() -> {
         openPayees();
      });
    }//GEN-LAST:event_menuItemEmitentesActionPerformed

    private void labelEmitentesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEmitentesMouseEntered
      SwingUtilities.invokeLater(() -> {
         setCursor(new Cursor(Cursor.HAND_CURSOR));
      });
    }//GEN-LAST:event_labelEmitentesMouseEntered

    private void labelEmitentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEmitentesMouseExited
      SwingUtilities.invokeLater(() -> {
         setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      });
    }//GEN-LAST:event_labelEmitentesMouseExited

    private void labelEmitentesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEmitentesMousePressed
      SwingUtilities.invokeLater(() -> {
         openPayees();
      });
    }//GEN-LAST:event_labelEmitentesMousePressed

    private void labelClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelClientesMousePressed
      SwingUtilities.invokeLater(() -> {
         openClients();
      });
    }//GEN-LAST:event_labelClientesMousePressed
    private void labelConsultarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelConsultarMousePressed
      SwingUtilities.invokeLater(() -> {
         openSearch();
      });
    }//GEN-LAST:event_labelConsultarMousePressed

    private void labelCadastrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCadastrarMousePressed
      SwingUtilities.invokeLater(() -> {
         openRecordCheck();
      });
    }//GEN-LAST:event_labelCadastrarMousePressed

    private void labelSimularEmprestimoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSimularEmprestimoMousePressed
      SwingUtilities.invokeLater(() -> {
         new LoanSimulator(this, true).setVisible(true);
      });
    }//GEN-LAST:event_labelSimularEmprestimoMousePressed

    private void labelCalcularDescontoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCalcularDescontoMousePressed
      SwingUtilities.invokeLater(() -> {
         new CheckCashing(this, false).setVisible(true);
      });
    }//GEN-LAST:event_labelCalcularDescontoMousePressed

    private void menuItemVisualizarRetencoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVisualizarRetencoesActionPerformed
      SwingUtilities.invokeLater(() -> {
         openRetentions();
      });
    }//GEN-LAST:event_menuItemVisualizarRetencoesActionPerformed

    private void menuItemBetweenDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBetweenDatesActionPerformed
      SwingUtilities.invokeLater(() -> {
         new BetweenDates(this, true).setVisible(true);
      });
    }//GEN-LAST:event_menuItemBetweenDatesActionPerformed

    private void menuItemConsultaExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConsultaExtActionPerformed
      SwingUtilities.invokeLater(() -> {
         openExtendedSearch();
      });
    }//GEN-LAST:event_menuItemConsultaExtActionPerformed

    private void labelConsultaExtendidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelConsultaExtendidaMouseEntered
      SwingUtilities.invokeLater(() -> {
         setCursor(new Cursor(Cursor.HAND_CURSOR));
      });
    }//GEN-LAST:event_labelConsultaExtendidaMouseEntered

    private void labelConsultaExtendidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelConsultaExtendidaMouseExited
      SwingUtilities.invokeLater(() -> {
         setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      });
    }//GEN-LAST:event_labelConsultaExtendidaMouseExited

    private void labelConsultaExtendidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelConsultaExtendidaMousePressed
      SwingUtilities.invokeLater(() -> {
         openExtendedSearch();
      });
    }//GEN-LAST:event_labelConsultaExtendidaMousePressed

    private void menuChequesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChequesActionPerformed
      SwingUtilities.invokeLater(() -> {
         openRecordCheck();
      });
    }//GEN-LAST:event_menuChequesActionPerformed

   public static void init() {
      java.awt.EventQueue.invokeLater(new Main());
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonConsultas;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSair;
    private javax.swing.JToolBar.Separator iconesSeparator;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXLabel labelActiveClientAmount;
    private org.jdesktop.swingx.JXLabel labelAmountRecordedToday;
    private org.jdesktop.swingx.JXLabel labelAmountUnexpired;
    private org.jdesktop.swingx.JXLabel labelAverageByCheck;
    private org.jdesktop.swingx.JXLabel labelAverageByClient;
    private org.jdesktop.swingx.JXLabel labelCadastradoHoje;
    private org.jdesktop.swingx.JXLabel labelCadastrar;
    private org.jdesktop.swingx.JXLabel labelCalcularDesconto;
    private org.jdesktop.swingx.JXLabel labelCheckAmount;
    private org.jdesktop.swingx.JXLabel labelClientAmount;
    private org.jdesktop.swingx.JXLabel labelClientes;
    private org.jdesktop.swingx.JXLabel labelClientesAtivos;
    private javax.swing.JLabel labelConsultaExtendida;
    private org.jdesktop.swingx.JXLabel labelConsultar;
    private org.jdesktop.swingx.JXLabel labelDataBase;
    private org.jdesktop.swingx.JXLabel labelDaysBetween;
    private org.jdesktop.swingx.JXLabel labelEmitentes;
    private org.jdesktop.swingx.JXLabel labelGeralAVencer;
    private org.jdesktop.swingx.JXLabel labelGrossAmount;
    private org.jdesktop.swingx.JXLabel labelGrossByMonth;
    private org.jdesktop.swingx.JXLabel labelHigherClient;
    private org.jdesktop.swingx.JXLabel labelLowerClient;
    private org.jdesktop.swingx.JXLabel labelMediaCliente;
    private org.jdesktop.swingx.JXLabel labelMediaPorCheque;
    private javax.swing.JLabel labelMonthAmountLeft;
    private org.jdesktop.swingx.JXLabel labelPrimeiroCliente;
    private org.jdesktop.swingx.JXLabel labelQuantCadastradoHoje;
    private org.jdesktop.swingx.JXLabel labelRecordedToday;
    private org.jdesktop.swingx.JXLabel labelRetencaoHoje;
    private org.jdesktop.swingx.JXLabel labelSimularEmprestimo;
    private javax.swing.JLabel labelTodayDate;
    private org.jdesktop.swingx.JXLabel labelTodayRetention;
    private org.jdesktop.swingx.JXLabel labelTotalCheques;
    private org.jdesktop.swingx.JXLabel labelTotalClientes;
    private org.jdesktop.swingx.JXLabel labelTotalGeral;
    private org.jdesktop.swingx.JXLabel labelTotalMes;
    private org.jdesktop.swingx.JXLabel labelTotalRestanteMes;
    private org.jdesktop.swingx.JXLabel labelUltimoCliente;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuBackup;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCheques;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuItemAddClient;
    private javax.swing.JMenuItem menuItemBackupCreate;
    private javax.swing.JMenuItem menuItemBackupRestore;
    private javax.swing.JMenuItem menuItemBetweenDates;
    private javax.swing.JMenuItem menuItemCalcularDesconto;
    private javax.swing.JMenuItem menuItemChangeLAF;
    private javax.swing.JMenuItem menuItemCheckByClient;
    private javax.swing.JMenuItem menuItemConsultaExt;
    private javax.swing.JMenuItem menuItemEmitentes;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemHolidays;
    private javax.swing.JMenuItem menuItemInputRangeAndClient;
    private javax.swing.JMenuItem menuItemOpenChecks;
    private javax.swing.JMenuItem menuItemOpenClients;
    private javax.swing.JMenuItem menuItemParameters;
    private javax.swing.JMenuItem menuItemPreferences;
    private javax.swing.JMenuItem menuItemQueryInputAndClient;
    private javax.swing.JMenuItem menuItemRecordCheck;
    private javax.swing.JMenuItem menuItemSetDataBaseParam;
    private javax.swing.JMenuItem menuItemSimuladorEmprestimo;
    private javax.swing.JMenuItem menuItemSobre;
    private javax.swing.JMenuItem menuItemVisualizarRetencoes;
    private javax.swing.JMenu menuSistema;
    private org.jdesktop.swingx.JXMonthView monthView;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JPopupMenu.Separator separatorCheques;
    private javax.swing.JPopupMenu.Separator separatorSistema;
    private org.jdesktop.swingx.JXStatusBar statusBar;
    private org.jdesktop.swingx.JXTaskPane taskPane;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

   private void openRecordCheck() {
      SwingUtilities.invokeLater(() -> {
         try {
            if (hasClient()) {
               new RegisterCheckFrame(mainFrame, conn).setVisible(true);
            }
         } catch (SQLException ex) {
            sqlExceptionMessage(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
         }
      });
   }

   private void openClients() {
      SwingUtilities.invokeLater(() -> {
         try {
            if (hasClient()) {
               new ViewAllClients(mainFrame, false, conn).setVisible(true);
            }
         } catch (SQLException ex) {
            sqlExceptionMessage(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
         }
      });
   }

   private void openSearch() {
      SwingUtilities.invokeLater(() -> {
         try {
            if (hasClient()) {
               new QueryCheckFrame(conn, mainFrame).setVisible(true);
            }
         } catch (SQLException ex) {
            sqlExceptionMessage(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
         }
      });
   }

   private void openExtendedSearch() {
      SwingUtilities.invokeLater(() -> {
         try {
            if (hasClient()) {
               new QueryExtCheckFrame(conn, mainFrame).setVisible(true);
            }
         } catch (SQLException ex) {
            sqlExceptionMessage(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
         }
      });
   }

   private void openPayees() {
      SwingUtilities.invokeLater(() -> {
         try {
            if (hasClient()) {
               new ViewAllPayees(mainFrame, false, conn).setVisible(true);
            }
         } catch (SQLException ex) {
            sqlExceptionMessage(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
         }
      });
   }

   private void quitApp() {
      try {
         ChequeMate.disconnectDB(conn);
      } catch (SQLException ex) {
         LOG.log(Level.SEVERE, ex.getMessage(), ex);
      } finally {
         System.exit(0);
      }
   }

   private void openRetentions() {
      SwingUtilities.invokeLater(() -> {
         try {
            if (hasClient()) {
               try {
                  if (MyPath.hasRegistriesFiles()) {
                     new ViewAllRetentions(mainFrame, false, conn).setVisible(true);
                  } else {
                     ChequeMate.showWarningMessage(mainFrame,
                             "Aviso", "Não foi encontrado arquivo de cadastro recente.");
                  }
               } catch (IOException ex) {
                  LOG.log(Level.SEVERE, ex.getMessage(), ex);
               }
            }
         } catch (SQLException ex) {
            sqlExceptionMessage(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
         }
      });
   }

   private void openBackup() {
      SwingUtilities.invokeLater(() -> {
         try {
            if (hasClient()) {
               new BackupBuilder(mainFrame, true).setVisible(true);
            }
         } catch (SQLException ex) {
            sqlExceptionMessage(ex.getMessage());
            LOG.log(Level.SEVERE, null, ex);
         }
      });
   }

   private static class Main implements Runnable {
      @Override
      public void run() {
         try {
            ChequeMate.setConfiguration(ChequeMate.XSTREAM.read());
            ChequeMate.verifyFolders();
            ChequeMate.applyLAF();
         } catch (IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            ChequeMate.showErrorMessage(null, ex.getMessage());
            System.exit(-1);
         }
         new MainFrame().setVisible(true);
      }
   }

   private void setupComponents() {
      taskPane.setBorder(new DropShadowBorder());
      monthView.setVisible(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setTitle("ChequeMate - Descontos e Cadastro de Cheques - Versão " + ChequeMate.VERSION);
      setIconImage(new ImageIcon(getClass().getResource("/img/ico.chequemate.png")).getImage());
      labelTodayDate.setText(Format.todayDate());
      labelDataBase.setText("Esperando");
      mainFrame = this;
   }

   public void updateSystemInfo() {
      setCursor(new Cursor(Cursor.WAIT_CURSOR));
      double grossAmount = 0;
      double grossByMonth = 0;
      int checkAmount = 0;
      int activeClients = 0;
      int clientAmount = 0;
      String higherClient = "";
      String lowerClient = "";
      int recordedToday = 0;
      double amountRecordedToday = 0;
      double amountUnexpired = 0;
      double todayRetention = 0;
      double leftInMonth = 0;
      try {
         grossAmount = checkControl.getGrossAmount();
         grossByMonth = checkControl.getGrossAmount(Days.TODAY.get(GregorianCalendar.MONTH));
         checkAmount = checkControl.count();
         clientAmount = clientControl.count();
         activeClients = clientControl.countActive();
         higherClient = clientControl.getHigher();
         lowerClient = clientControl.getLower();
         recordedToday = checkControl.countRegisteredToday();
         amountRecordedToday = checkControl.sumGrossRegisteredToday();
         amountUnexpired = checkControl.getGrossAmountUnexpired();
         todayRetention = checkControl.getTodayRetention();

         GregorianCalendar date = new GregorianCalendar();
         int currentMonth = date.get(GregorianCalendar.MONTH);
         while (date.get(GregorianCalendar.MONTH) == currentMonth) {
            date.add(GregorianCalendar.DAY_OF_YEAR, 1);
         }
         leftInMonth = checkControl.sumGrossLeftInMonth(date);
      } catch (SQLException ex) {
         LOG.log(Level.SEVERE, ex.getMessage(), ex);
      }
      double averageClient = 0;
      double averageCheck = 0;
      if (activeClients != 0) {
         averageClient = grossAmount / activeClients;
      }
      if (checkAmount != 0) {
         averageCheck = grossAmount / checkAmount;
      }
      labelGrossAmount.setText(Format.decimal(grossAmount));
      labelGrossByMonth.setText(Format.decimal(grossByMonth));
      labelCheckAmount.setText(String.valueOf(checkAmount));
      labelAverageByClient.setText(Format.decimal(averageClient));
      labelAverageByCheck.setText(Format.decimal(averageCheck));
      labelHigherClient.setText(higherClient);
      labelClientAmount.setText(String.valueOf(clientAmount));
      labelLowerClient.setText(lowerClient);
      labelActiveClientAmount.setText(String.valueOf(activeClients));
      labelAmountUnexpired.setText(Format.decimal(amountUnexpired));
      labelAmountRecordedToday.setText(Format.decimal(amountRecordedToday));
      labelTodayRetention.setText(Format.decimal(todayRetention));
      labelRecordedToday.setText(String.valueOf(recordedToday));
      labelMonthAmountLeft.setText(Format.decimal(leftInMonth));
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
   }

   private void selectDate() {
      Date date = monthView.getSelectionDate();
      if (monthView.getToday().before(date)) {
         selectedDate.setTime(date);
         int daysBetween = Days.between(Days.TODAY, selectedDate);
         if (daysBetween != 1) {
            StringBuilder temp = new StringBuilder();
            temp.append("De hoje até dia ");
            temp.append(Format.date(date));
            temp.append(" são ");
            temp.append(daysBetween);
            temp.append(" dias.");
            labelDaysBetween.setText(temp.toString());
         }
      } else {
         labelDaysBetween.setText("");
      }
   }

   private void showToolTipHoliday(MouseEvent evt) {
      Date date = monthView.getDayAtLocation(evt.getX(), evt.getY());
      if (date != null) {
         selectedDate.setTime(date);
         HashMap<DateMidnight, Holiday> holidayMap = ChequeMate.getHolidayControl().getMap();
         DateMidnight dateMid = new DateMidnight(selectedDate.getTimeInMillis());
         if (holidayMap.containsKey(dateMid)) {
            monthView.setToolTipText(holidayMap.get(dateMid).getDescription());
            monthView.createToolTip().setVisible(true);
         }
      }
   }

   public void setConnection(Connection conn) {
      this.conn = conn;
      clientControl = new ClientController(conn);
      checkControl = new CheckController(conn);
      monthView.setVisible(true);
      monthView.setFlaggedDates(ChequeMate.getHolidayControl().getArrayDate());
      monthView.setFlaggedDayForeground(Color.red);
      try {
         ChequeMate.deleteOldRecords(checkControl);
      } catch (SQLException ex) {
         LOG.log(Level.SEVERE, ex.getMessage(), ex);
      }
      setStatusBarMessage("Conectado");
      updateSystemInfo();
   }

   public void setStatusBarMessage(String message) {
      if (message.equals("Conectado")) {
         labelDataBase.setEnabled(true);
      } else {
         labelDataBase.setEnabled(false);
      }
      labelDataBase.setText(message);
   }

   private boolean hasClient() throws SQLException {
      int countClients = clientControl.count();
      if (countClients == 0) {
         int choice = JOptionPane.showConfirmDialog(this,
                 "O sistema não possui cliente cadastrado. Deseja incluir agora?",
                 "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (choice == JOptionPane.YES_OPTION) {
            AddClient addClient = new AddClient(this, false, conn, null);
            addClient.setVisible(true);
         }
         return false;
      } else {
         return true;
      }
   }

   public void sqlExceptionMessage(String exMessage) {
      StringBuilder errorMsg = new StringBuilder();
      errorMsg.append("O conexão com o banco de dados caiu.");
      errorMsg.append(" O sistema tentará reconectar. Caso o erro persista entre em contato com o administrador.");
      errorMsg.append("\n\nMensagem do sistema: ");
      errorMsg.append(exMessage);
      ChequeMate.showErrorMessage(mainFrame, "Erro no Banco de dados", errorMsg.toString());
   }
}
