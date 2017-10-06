package br.com.antoniosergius.chequemate.gui;

import br.com.antoniosergius.chequemate.ctrl.CheckController;
import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.gui.dialog.AlterCheck;
import br.com.antoniosergius.chequemate.gui.dialog.ViewAllPayees;
import br.com.antoniosergius.chequemate.gui.dialog.query.QueryByInputDate;
import br.com.antoniosergius.chequemate.gui.panel.DatePickerPanel;
import br.com.antoniosergius.chequemate.gui.utils.QueryTableModel;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.chequemate.obj.Query;
import br.com.antoniosergius.chequemate.report.ReportFactory;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.chequemate.util.tools.Compare;
import br.com.antoniosergius.chequemate.util.tools.Sort;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.verif.IntegerVerifier;
import br.com.antoniosergius.lib.verif.MoneyVerifier;
import br.com.antoniosergius.lib.verif.RegistryNumberVerifier;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.joda.time.DateMidnight;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

public class QueryCheckFrame extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(QueryCheckFrame.class.getName());
    
    private Query query;
    private final Connection conn;
    private final CheckController checkControl;
    private QueryCheckFrame thisFrame;
    private ArrayList<Check> checkList;
    private ArrayList<String> clientList;
    private QueryTableModel model;
    private MainFrame mainFrame;
    private final Compare.StringDate dateCompare = new Compare.StringDate();
    private final Compare.StringClient clientCompare = new Compare.StringClient();
    private final Compare.StringDecimal decimalCompare = new Compare.StringDecimal();
    private final Compare.IntegerCompare integerCompare = new Compare.IntegerCompare();
    
    
    public QueryCheckFrame(Connection conn) {
        this.query = new Query();
        this.conn = conn;
        this.checkControl = new CheckController(conn);
        initComponents();
        setupComponents();  
    }
    
    public QueryCheckFrame(Connection conn, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.query = new Query();
        this.conn = conn;
        this.checkControl = new CheckController(conn);
        initComponents();
        setupComponents();  
    }
    
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenuTable = new javax.swing.JPopupMenu();
        menuItemVerifyPayee = new javax.swing.JMenuItem();
        menuItemVerifyPayeeHistory = new javax.swing.JMenuItem();
        deleteSeparator = new javax.swing.JPopupMenu.Separator();
        menuItemRemove = new javax.swing.JMenuItem();
        popupMenuMultiple = new javax.swing.JPopupMenu();
        menuItemDeleteAll = new javax.swing.JMenuItem();
        panelForm = new javax.swing.JPanel();
        labelRegistryNumber = new javax.swing.JLabel();
        textFieldRegistryNumber = new javax.swing.JTextField();
        labelLowestGross = new javax.swing.JLabel();
        labelLowestExpiration = new javax.swing.JLabel();
        labelPayee = new javax.swing.JLabel();
        labelHighestGross = new javax.swing.JLabel();
        labelHighestExpiration = new javax.swing.JLabel();
        textFieldPayee = new javax.swing.JTextField();
        labelClient = new javax.swing.JLabel();
        labelNumber = new javax.swing.JLabel();
        buttonClear = new javax.swing.JButton();
        labelBank = new javax.swing.JLabel();
        datePickerLowest = new org.jdesktop.swingx.JXDatePicker();
        textFieldLowestGross = new javax.swing.JTextField();
        textFieldHighestGross = new javax.swing.JTextField();
        datePickerHighest = new org.jdesktop.swingx.JXDatePicker();
        comboBox = new javax.swing.JComboBox();
        textFieldNumber = new javax.swing.JTextField();
        textFieldBank = new javax.swing.JTextField();
        labelLowestInput = new org.jdesktop.swingx.JXLabel();
        datePickerLowestInput = new org.jdesktop.swingx.JXDatePicker();
        labelHighestInput = new org.jdesktop.swingx.JXLabel();
        datePickerHighestInput = new org.jdesktop.swingx.JXDatePicker();
        buttonClearClient = new javax.swing.JButton();
        panelTable = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tableCheck = new javax.swing.JTable();
        labelGrossAmount = new javax.swing.JLabel();
        labelListedAmount = new javax.swing.JLabel();
        labelNumChequesListados = new javax.swing.JLabel();
        labelListedChecks = new javax.swing.JLabel();
        toolBar = new javax.swing.JToolBar();
        buttonPrint = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        buttonClearAll = new javax.swing.JButton();
        separatorToolBar = new javax.swing.JToolBar.Separator();
        buttonClose = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuExibir = new javax.swing.JMenu();
        menuItemCadastradosHoje = new javax.swing.JMenuItem();
        menuItemVencimentoHoje = new javax.swing.JMenuItem();
        menuItemCadastradosDataEspecifica = new javax.swing.JMenuItem();
        menuOrdenar = new javax.swing.JMenu();
        menuItemOrdenaClienteValor = new javax.swing.JMenuItem();
        menuItemOrdenaClienteDataBoa = new javax.swing.JMenuItem();
        separator = new javax.swing.JPopupMenu.Separator();
        menuItemOrdenaEmitenteDataBoa = new javax.swing.JMenuItem();

        menuItemVerifyPayee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.view.png"))); // NOI18N
        menuItemVerifyPayee.setText("Buscar Cheques deste Emitente...");
        menuItemVerifyPayee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerifyPayeeActionPerformed(evt);
            }
        });
        popupMenuTable.add(menuItemVerifyPayee);

        menuItemVerifyPayeeHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.payee.png"))); // NOI18N
        menuItemVerifyPayeeHistory.setText("Verificar Histórico do Emitente");
        menuItemVerifyPayeeHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerifyPayeeHistoryActionPerformed(evt);
            }
        });
        popupMenuTable.add(menuItemVerifyPayeeHistory);
        popupMenuTable.add(deleteSeparator);

        menuItemRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.remove.png"))); // NOI18N
        menuItemRemove.setText("Deletar registro selecionado (CUIDADO!)");
        menuItemRemove.setToolTipText("");
        menuItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRemoveActionPerformed(evt);
            }
        });
        popupMenuTable.add(menuItemRemove);

        menuItemDeleteAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.remove.png"))); // NOI18N
        menuItemDeleteAll.setText("Deletar Todos Cheques Selecionados");
        menuItemDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDeleteAllActionPerformed(evt);
            }
        });
        popupMenuMultiple.add(menuItemDeleteAll);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas");
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.search.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cheque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.darkGray));

        labelRegistryNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRegistryNumber.setText("CPF/CNPJ:");

        textFieldRegistryNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldRegistryNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldRegistryNumberKeyReleased(evt);
            }
        });

        labelLowestGross.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLowestGross.setText("Valor Menor:");

        labelLowestExpiration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLowestExpiration.setText("Data Boa Menor:");

        labelPayee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPayee.setText("Emitente:");

        labelHighestGross.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHighestGross.setText("Valor Maior:");

        labelHighestExpiration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHighestExpiration.setText("Data Boa Maior:");

        textFieldPayee.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textFieldPayee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldPayeeKeyReleased(evt);
            }
        });

        labelClient.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelClient.setText("Cliente:");

        labelNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNumber.setText("Nº Cheque:");

        buttonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.delete.png"))); // NOI18N
        buttonClear.setText("Limpar Tudo");
        buttonClear.setToolTipText("Limpa o formulário para uma nova pesquisa.");
        buttonClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        labelBank.setText("Banco:");

        datePickerLowest.setFormats(new String[]{"dd/MM/yyyy"});
        datePickerLowest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerLowestActionPerformed(evt);
            }
        });

        textFieldLowestGross.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldLowestGross.setText(" ");
        textFieldLowestGross.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldLowestGrossFocusLost(evt);
            }
        });

        textFieldHighestGross.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldHighestGross.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldHighestGrossFocusLost(evt);
            }
        });

        datePickerHighest.setFormats(new String[]{"dd/MM/yyyy"});
        datePickerHighest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerHighestActionPerformed(evt);
            }
        });

        comboBox.setEditable(true);
        comboBox.setMaximumRowCount(15);
        comboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        textFieldNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldNumberKeyReleased(evt);
            }
        });

        textFieldBank.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldBank.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldBankKeyReleased(evt);
            }
        });

        labelLowestInput.setText("Entrada Menor:");

        datePickerLowestInput.setFormats(new String[]{"dd/MM/yyyy"});
        datePickerLowestInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerLowestInputActionPerformed(evt);
            }
        });

        labelHighestInput.setText("Entrada Maior:");

        datePickerHighestInput.setFormats(new String[]{"dd/MM/yyyy"});
        datePickerHighestInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerHighestInputActionPerformed(evt);
            }
        });

        buttonClearClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.clear.png"))); // NOI18N
        buttonClearClient.setToolTipText("Limpar Campo do Cliente");
        buttonClearClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelLowestInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRegistryNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLowestExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(labelLowestGross, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datePickerLowest, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(textFieldRegistryNumber)
                    .addComponent(textFieldLowestGross)
                    .addComponent(datePickerLowestInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelHighestGross, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHighestExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(labelPayee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHighestInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(datePickerHighestInput, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldHighestGross)
                                    .addComponent(datePickerHighest, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelFormLayout.createSequentialGroup()
                                        .addComponent(textFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelBank)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldBank))
                                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(textFieldPayee))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonClearClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(buttonClear)))
                .addContainerGap())
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {datePickerHighest, datePickerHighestInput, datePickerLowest, datePickerLowestInput, textFieldHighestGross, textFieldLowestGross, textFieldRegistryNumber});

        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPayee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPayee)
                            .addComponent(textFieldRegistryNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRegistryNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelLowestGross)
                                    .addComponent(textFieldLowestGross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelLowestExpiration)
                                    .addComponent(labelHighestExpiration)
                                    .addComponent(datePickerLowest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datePickerHighest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelClient)))
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelHighestGross)
                                    .addComponent(textFieldHighestGross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNumber)
                                    .addComponent(labelBank)
                                    .addComponent(textFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonClearClient, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(buttonClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLowestInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerLowestInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHighestInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerHighestInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {datePickerHighest, datePickerHighestInput, datePickerLowest, datePickerLowestInput});

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonClearClient, comboBox});

        panelTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabela de Cheques", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.darkGray));

        tableCheck.setModel(new QueryTableModel());
        tableCheck.setToolTipText("Clique duas vezes em uma linha caso queira alterar algum dado do cheque.");
        tableCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableCheck.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableCheck.getTableHeader().setResizingAllowed(false);
        tableCheck.getTableHeader().setReorderingAllowed(false);
        tableCheck.setVerifyInputWhenFocusTarget(false);
        tableCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCheckMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCheckMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tableCheck);
        tableCheck.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        labelGrossAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelGrossAmount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        labelListedAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelListedAmount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.red.calc.png"))); // NOI18N
        labelListedAmount.setText("Valor Total Listado:");

        labelNumChequesListados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNumChequesListados.setText("Número de Cheques Listados:");

        labelListedChecks.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTableLayout.createSequentialGroup()
                        .addComponent(labelListedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelGrossAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelNumChequesListados, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelListedChecks, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPane))
                .addContainerGap())
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelListedAmount)
                        .addComponent(labelGrossAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelListedChecks)
                        .addComponent(labelNumChequesListados))))
        );

        panelTableLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelGrossAmount, labelListedAmount, labelListedChecks, labelNumChequesListados});

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.print.png"))); // NOI18N
        buttonPrint.setToolTipText("Imprimir Tabela");
        buttonPrint.setFocusable(false);
        buttonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });
        toolBar.add(buttonPrint);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.refresh.png"))); // NOI18N
        buttonRefresh.setToolTipText("Atualizar");
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        toolBar.add(buttonRefresh);

        buttonClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.delete.png"))); // NOI18N
        buttonClearAll.setToolTipText("Limpar Campos");
        buttonClearAll.setFocusable(false);
        buttonClearAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClearAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearAllActionPerformed(evt);
            }
        });
        toolBar.add(buttonClearAll);
        toolBar.add(separatorToolBar);

        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.exit.png"))); // NOI18N
        buttonClose.setToolTipText("Fechar");
        buttonClose.setFocusable(false);
        buttonClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        toolBar.add(buttonClose);

        menuExibir.setText("Exibir");

        menuItemCadastradosHoje.setText("Cheques Cadastrados Hoje");
        menuItemCadastradosHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastradosHojeActionPerformed(evt);
            }
        });
        menuExibir.add(menuItemCadastradosHoje);

        menuItemVencimentoHoje.setText("Cheques com Vencimento para Hoje");
        menuItemVencimentoHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVencimentoHojeActionPerformed(evt);
            }
        });
        menuExibir.add(menuItemVencimentoHoje);

        menuItemCadastradosDataEspecifica.setText("Cheques Cadastrados em uma Data Específica");
        menuItemCadastradosDataEspecifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastradosDataEspecificaActionPerformed(evt);
            }
        });
        menuExibir.add(menuItemCadastradosDataEspecifica);

        menuBar.add(menuExibir);

        menuOrdenar.setText("Ordenar");

        menuItemOrdenaClienteValor.setText("Por Cliente e Valor");
        menuItemOrdenaClienteValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOrdenaClienteValorActionPerformed(evt);
            }
        });
        menuOrdenar.add(menuItemOrdenaClienteValor);

        menuItemOrdenaClienteDataBoa.setText("Por Cliente e Data Boa");
        menuItemOrdenaClienteDataBoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOrdenaClienteDataBoaActionPerformed(evt);
            }
        });
        menuOrdenar.add(menuItemOrdenaClienteDataBoa);
        menuOrdenar.add(separator);

        menuItemOrdenaEmitenteDataBoa.setText("Por Emitente e Data Boa");
        menuItemOrdenaEmitenteDataBoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOrdenaEmitenteDataBoaActionPerformed(evt);
            }
        });
        menuOrdenar.add(menuItemOrdenaEmitenteDataBoa);

        menuBar.add(menuOrdenar);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        queryAndSetupTableData();
    }//GEN-LAST:event_formWindowOpened
    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        clearForm(true);
        sortByColumn(6);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonClearActionPerformed
    private void menuItemCadastradosHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastradosHojeActionPerformed
        clearForm(false);
        query = new Query();
        GregorianCalendar max = new GregorianCalendar();
        Days.setToLastMinute(max);
        Days.setTodayToMidnight();
        query.setLowestInput(Days.TODAY);
        query.setHighestInput(max);
        datePickerLowestInput.setDate(Days.TODAY.getTime());
        datePickerHighestInput.setDate(max.getTime());
        queryAndSetupTableData();
        sortByColumn(6);
    }//GEN-LAST:event_menuItemCadastradosHojeActionPerformed

    private void menuItemCadastradosDataEspecificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastradosDataEspecificaActionPerformed
        queryByInputDate();
    }//GEN-LAST:event_menuItemCadastradosDataEspecificaActionPerformed

    private void menuItemOrdenaClienteValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOrdenaClienteValorActionPerformed
        tableCheck.getRowSorter().setSortKeys(null);
        try {
            Sort.byClientAndGross(checkList);
        } catch (ChequeMateException ex) {}
        setTableData(checkList);
    }//GEN-LAST:event_menuItemOrdenaClienteValorActionPerformed

    private void menuItemOrdenaClienteDataBoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOrdenaClienteDataBoaActionPerformed
        tableCheck.getRowSorter().setSortKeys(null);
        try {
            Sort.byClientAndExpiration(checkList);
        } catch (ChequeMateException ex) {}
        setTableData(checkList);
    }//GEN-LAST:event_menuItemOrdenaClienteDataBoaActionPerformed

    private void menuItemOrdenaEmitenteDataBoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOrdenaEmitenteDataBoaActionPerformed
        tableCheck.getRowSorter().setSortKeys(null);
        try {
            Sort.byPayeeAndExpiration(checkList);
        } catch (ChequeMateException ex) {}
        setTableData(checkList);
    }//GEN-LAST:event_menuItemOrdenaEmitenteDataBoaActionPerformed

    @SuppressWarnings("unchecked")
    private void tableCheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCheckMouseClicked
        if (evt.getClickCount() == 2 && tableCheck.getSelectedRowCount() == 1) {
            int modelIndex = tableCheck.convertRowIndexToModel(tableCheck.getSelectedRow());
            Check check = checkList.get(modelIndex);
            new AlterCheck(this, true, check, conn, comboBox.getModel(), modelIndex).setVisible(true);
        }
    }//GEN-LAST:event_tableCheckMouseClicked

    private void textFieldRegistryNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldRegistryNumberKeyReleased
        query.getPayee().setRegistryNumber(textFieldRegistryNumber.getText());
        queryAndSetupTableData();
        sortByColumn(2);
    }//GEN-LAST:event_textFieldRegistryNumberKeyReleased

    private void textFieldPayeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldPayeeKeyReleased
        query.getPayee().setName(textFieldPayee.getText());
        queryAndSetupTableData();
        sortByColumn(1);
    }//GEN-LAST:event_textFieldPayeeKeyReleased

    private void datePickerLowestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerLowestActionPerformed
        Date date = datePickerLowest.getDate();
        if (date != null) {
            query.setLowestExpiration(date.getTime());
            queryAndSetupTableData();
            sortByColumn(6);
        } 
    }//GEN-LAST:event_datePickerLowestActionPerformed

    private void datePickerHighestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerHighestActionPerformed
        Date date = datePickerHighest.getDate();
        if (date != null) {
            query.setHighestExpiration(date.getTime());
            queryAndSetupTableData();
            sortByColumn(6);
        }
    }//GEN-LAST:event_datePickerHighestActionPerformed

    private void textFieldNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNumberKeyReleased
        query.setNumber(stringToInt(textFieldNumber.getText()));
        queryAndSetupTableData();
    }//GEN-LAST:event_textFieldNumberKeyReleased

    private void textFieldBankKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldBankKeyReleased
        query.setBank(stringToInt(textFieldBank.getText()));
        queryAndSetupTableData();
    }//GEN-LAST:event_textFieldBankKeyReleased

    private void comboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBoxPopupMenuWillBecomeInvisible
        int index = comboBox.getSelectedIndex();
        int idClient = 0;
        if (index > 0) {
            String item = (String)comboBox.getItemAt(index);
            idClient = Client.getId(item, Client.ID_SUFFIX);
        }
        query.setIdClient(idClient);
        queryAndSetupTableData();
    }//GEN-LAST:event_comboBoxPopupMenuWillBecomeInvisible

    private void textFieldLowestGrossFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldLowestGrossFocusLost
        query.setLowestValue(stringToDouble(textFieldLowestGross.getText(), false));
        queryAndSetupTableData();
        sortByColumn(6);
    }//GEN-LAST:event_textFieldLowestGrossFocusLost

    private void textFieldHighestGrossFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldHighestGrossFocusLost
        query.setHighestValue(stringToDouble(textFieldHighestGross.getText(), true));
        queryAndSetupTableData();
        sortByColumn(6);
    }//GEN-LAST:event_textFieldHighestGrossFocusLost

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        queryAndSetupTableData();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        if (mainFrame != null) {
            mainFrame.updateSystemInfo();
        }
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void datePickerLowestInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerLowestInputActionPerformed
        Date date = datePickerLowestInput.getDate();
        if (date != null) {
            DateMidnight midnight = new DateMidnight(date.getTime());
            query.setLowestInput(midnight.toGregorianCalendar());
            queryAndSetupTableData();
        }
    }//GEN-LAST:event_datePickerLowestInputActionPerformed

    private void datePickerHighestInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerHighestInputActionPerformed
        Date date = datePickerHighestInput.getDate();
        if (date != null) {
            date = Days.setToLastMinute(date);
            query.setHighestInput(date.getTime());
            queryAndSetupTableData();
        }
    }//GEN-LAST:event_datePickerHighestInputActionPerformed

    private void buttonClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearAllActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        clearForm(true);
        sortByColumn(6);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonClearAllActionPerformed

    private void tableCheckMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCheckMouseReleased
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int rowNumber = tableCheck.rowAtPoint( p );
            if (rowNumber != -1) {
                if (tableCheck.getSelectedRowCount() > 1) {
                    if (evt.isPopupTrigger()) {
                        popupMenuMultiple.show(tableCheck, evt.getX(), evt.getY());
                    }
                } else {
                    tableCheck.setRowSelectionInterval(rowNumber, rowNumber);
                    if (evt.isPopupTrigger()) {
                        popupMenuTable.show(tableCheck, evt.getX(), evt.getY());
                    }
                }
            }    
        }    
    }//GEN-LAST:event_tableCheckMouseReleased

    private void menuItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRemoveActionPerformed
        removeTableRow();
    }//GEN-LAST:event_menuItemRemoveActionPerformed

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            Sort.byExpiration(checkList);
        } catch (ChequeMateException ex) {}
        try {
            ReportFactory.viewQuery(checkList);
        } catch (SQLException | JRException | IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void menuItemVerifyPayeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerifyPayeeActionPerformed
        int row = tableCheck.getSelectedRow();
        if (row!=-1) {
            int modelIndex = tableCheck.convertRowIndexToModel(tableCheck.getSelectedRow());
            Payee payee = new Payee(checkList.get(modelIndex).getPayee().getRegistryNumber());
            clearForm(false);
            textFieldRegistryNumber.setText(payee.getRegistryNumber());
            textFieldPayee.setText(payee.getName());
            query.setPayee(payee);
            queryAndSetupTableData();
        }
    }//GEN-LAST:event_menuItemVerifyPayeeActionPerformed

    private void menuItemVencimentoHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVencimentoHojeActionPerformed
        clearForm(false);
        query = new Query();
        query.setLowestExpiration(Days.TODAY);
        query.setHighestExpiration(Days.TODAY);
        datePickerLowest.setDate(Days.TODAY.getTime());
        datePickerHighest.setDate(Days.TODAY.getTime());
        queryAndSetupTableData();
        sortByColumn(6);
    }//GEN-LAST:event_menuItemVencimentoHojeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (mainFrame != null) {
            mainFrame.updateSystemInfo();
        }
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void menuItemDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDeleteAllActionPerformed
        deleteSelectedRows();
    }//GEN-LAST:event_menuItemDeleteAllActionPerformed

    private void menuItemVerifyPayeeHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerifyPayeeHistoryActionPerformed
        if (tableCheck.getSelectedRowCount() == 1) {
            ViewAllPayees payeesDialog = new ViewAllPayees(this, true, conn);
            int modelIndex = tableCheck.convertRowIndexToModel(tableCheck.getSelectedRow());
            String registry = checkList.get(modelIndex).getPayee().getRegistryNumber();
            payeesDialog.setRegistryNumber(registry);
            payeesDialog.setVisible(true);
            payeesDialog.queryAndSetupTableData();
        }
    }//GEN-LAST:event_menuItemVerifyPayeeHistoryActionPerformed

    private void buttonClearClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearClientActionPerformed
        if (comboBox.getSelectedIndex() > 0) {
            comboBox.setSelectedIndex(0);
            query.setIdClient(0);
            queryAndSetupTableData();
        }
    }//GEN-LAST:event_buttonClearClientActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Variables GUI">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonClearAll;
    private javax.swing.JButton buttonClearClient;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JComboBox comboBox;
    private org.jdesktop.swingx.JXDatePicker datePickerHighest;
    private org.jdesktop.swingx.JXDatePicker datePickerHighestInput;
    private org.jdesktop.swingx.JXDatePicker datePickerLowest;
    private org.jdesktop.swingx.JXDatePicker datePickerLowestInput;
    private javax.swing.JPopupMenu.Separator deleteSeparator;
    private javax.swing.JLabel labelBank;
    private javax.swing.JLabel labelClient;
    private javax.swing.JLabel labelGrossAmount;
    private javax.swing.JLabel labelHighestExpiration;
    private javax.swing.JLabel labelHighestGross;
    private org.jdesktop.swingx.JXLabel labelHighestInput;
    private javax.swing.JLabel labelListedAmount;
    private javax.swing.JLabel labelListedChecks;
    private javax.swing.JLabel labelLowestExpiration;
    private javax.swing.JLabel labelLowestGross;
    private org.jdesktop.swingx.JXLabel labelLowestInput;
    private javax.swing.JLabel labelNumChequesListados;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JLabel labelPayee;
    private javax.swing.JLabel labelRegistryNumber;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuExibir;
    private javax.swing.JMenuItem menuItemCadastradosDataEspecifica;
    private javax.swing.JMenuItem menuItemCadastradosHoje;
    private javax.swing.JMenuItem menuItemDeleteAll;
    private javax.swing.JMenuItem menuItemOrdenaClienteDataBoa;
    private javax.swing.JMenuItem menuItemOrdenaClienteValor;
    private javax.swing.JMenuItem menuItemOrdenaEmitenteDataBoa;
    private javax.swing.JMenuItem menuItemRemove;
    private javax.swing.JMenuItem menuItemVencimentoHoje;
    private javax.swing.JMenuItem menuItemVerifyPayee;
    private javax.swing.JMenuItem menuItemVerifyPayeeHistory;
    private javax.swing.JMenu menuOrdenar;
    private javax.swing.JPanel panelForm;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPopupMenu popupMenuMultiple;
    private javax.swing.JPopupMenu popupMenuTable;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPopupMenu.Separator separator;
    private javax.swing.JToolBar.Separator separatorToolBar;
    private javax.swing.JTable tableCheck;
    private javax.swing.JTextField textFieldBank;
    private javax.swing.JTextField textFieldHighestGross;
    private javax.swing.JTextField textFieldLowestGross;
    private javax.swing.JTextField textFieldNumber;
    private javax.swing.JTextField textFieldPayee;
    private javax.swing.JTextField textFieldRegistryNumber;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
    
    public void setTableData(ArrayList<Check> list) {
        model.clear();
        if (list == null || list.isEmpty()) {
            labelGrossAmount.setText("0,00");
            labelListedChecks.setText("0");
            checkList = null;
            return;
        }
        model.addList(list);
        
        labelGrossAmount.setText(Format.decimal(model.getGrossAmount()));
        labelListedChecks.setText(String.valueOf(model.getRowCount()));
        checkList = list;
    }
    
    public ArrayList<Check> queryAll() {
        ArrayList<Check> list;
        try {
            list = checkControl.getAll();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            model.clear();
            return null;
        }
        Collections.sort(list);
        setTableData(list);
        checkList = list;
        return list;
    }
    
    private void queryByInputDate() {
        QueryByInputDate dialog = new QueryByInputDate(this, true);
        dialog.setVisible(true);
        boolean isSelected = false;
        Date min = new Date();
        Date max = new Date();
        GregorianCalendar selectedDate;
        while (!isSelected) {
            if (dialog.isCanceled()) {
                return;
            }
            selectedDate = dialog.getInputDate();
            min = new DateMidnight(selectedDate.getTimeInMillis()).toDate();
            Days.setToLastMinute(selectedDate);
            max = selectedDate.getTime();
            query = new Query();
            
            query.setLowestInput(min.getTime());
            query.setHighestInput(max.getTime());
            isSelected = true;
        }
        datePickerLowestInput.setDate(min);
        datePickerHighestInput.setDate(max);
        queryAndSetupTableData();
        sortByColumn(6);
    }
    
    public void setQueryObject(Query query) {
        this.query = query;
    }
    
    public void queryAndSetupTableData() {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (query.isEmpty()){
            queryAll();
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        ArrayList<Check> list = null;
        try {
            list = checkControl.query(query);
        } catch (SQLException ex) {}
        setTableData(list);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    public void clearForm(boolean willUpdate) {
        if (willUpdate) {
            queryAll();
        }
        query = new Query();
        textFieldRegistryNumber.setText("");
        textFieldPayee.setText("");
        textFieldBank.setText("");
        textFieldHighestGross.setText("");
        textFieldLowestGross.setText("");
        textFieldNumber.setText("");
        datePickerHighest.setDate(null);
        datePickerLowest.setDate(null);
        datePickerHighestInput.setDate(null);
        datePickerLowestInput.setDate(null);
        comboBox.setSelectedIndex(0);
        textFieldRegistryNumber.requestFocus();
    }
    
    public void deleteFromModel(int modelIndex) {
        model.remove(modelIndex);
        checkList.remove(modelIndex);
    }
    
    public void updateFromModel(Check check, int modelIndex) {
        model.setValueAt(check, modelIndex);
        Check fromList = checkList.get(modelIndex);
        fromList.setAgency(check.getAgency());
        fromList.setBank(check.getBank());
        fromList.setCalcDate(check.getCalcDate());
        fromList.setExpiration(check.getExpiration());
        fromList.setGross(check.getGross());
        fromList.setNet(check.getNet());
        fromList.setPayee(check.getPayee());
        fromList.setNumber(check.getNumber());
        fromList.setClientName(check.getClientName());
        fromList.setIdClient(check.getIdClient());
    }
    
    // <editor-fold defaultstate="collapsed" desc="Setup Form">
    @SuppressWarnings("unchecked")
    private void setupComboBox() {
        comboBox.removeAllItems();
        comboBox.addItem(" - Todos - ");
        ClientController clientControl = new ClientController(conn);
        try {
            clientList = clientControl.getNameList();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return;
        }
        for(String cliente : clientList) {
            comboBox.addItem(cliente);
        }
        comboBox.setSelectedIndex(0);
    }
    
    private void setupComponents() {
        thisFrame = this;
        setLocationRelativeTo(null);
        setupFocusComponents();
        
        Verifier.set(textFieldLowestGross, new MoneyVerifier());
        Verifier.set(textFieldHighestGross, new MoneyVerifier());
        Verifier.set(textFieldRegistryNumber, new RegistryNumberVerifier());
        Verifier.set(textFieldBank, new IntegerVerifier(3));
        Verifier.set(textFieldNumber, new IntegerVerifier(6));
        Verifier.set(textFieldPayee, new TextVerifier());
        
        setupComboBox();
        AutoCompleteDecorator.decorate(comboBox);
        
        JXMonthView monthViewHigherExp = datePickerHighest.getMonthView();
        monthViewHigherExp.setLowerBound(ChequeMate.getMinExpirationDate().getTime());
        monthViewHigherExp.setUpperBound(ChequeMate.getMaxDate().getTime());
        monthViewHigherExp.setEnabled(true);

        JXMonthView monthViewLowerExp = datePickerLowest.getMonthView();
        monthViewLowerExp.setLowerBound(ChequeMate.getMinExpirationDate().getTime());
        monthViewLowerExp.setUpperBound(ChequeMate.getMaxDate().getTime());
        monthViewLowerExp.setEnabled(true);
        
        JXMonthView monthViewHigherInput = datePickerHighestInput.getMonthView();
        monthViewHigherInput.setLowerBound(ChequeMate.getMinInputDate().getTime());
        monthViewHigherInput.setUpperBound(Days.TODAY.getTime());
        monthViewHigherInput.setEnabled(true);

        JXMonthView monthViewLowerInput = datePickerLowestInput.getMonthView();
        monthViewLowerInput.setLowerBound(ChequeMate.getMinInputDate().getTime());
        monthViewLowerInput.setUpperBound(Days.TODAY.getTime());
        monthViewLowerInput.setEnabled(true);

        DatePickerPanel datePickerPanelHighest = new DatePickerPanel(datePickerHighest, this, "highest");
        DatePickerPanel datePickerPanelHighestInput = new DatePickerPanel(datePickerHighestInput, this, "highestInput");
        DatePickerPanel datePickerPanelLowest = new DatePickerPanel(datePickerLowest, this, "lowest");
        DatePickerPanel datePickerPanelLowestInput = new DatePickerPanel(datePickerLowestInput, this, "lowestInput");
        
        datePickerHighest.setLinkPanel(datePickerPanelHighest);
        datePickerHighestInput.setLinkPanel(datePickerPanelHighestInput);
        datePickerLowest.setLinkPanel(datePickerPanelLowest);
        datePickerLowestInput.setLinkPanel(datePickerPanelLowestInput);
        
        
        datePickerHighest.setEditable(false);
        datePickerHighestInput.setEditable(false);
        datePickerLowest.setEditable(false);
        datePickerLowestInput.setEditable(false);
        
        datePickerHighest.getMonthView().setEnabled(true);
        datePickerHighestInput.getMonthView().setEnabled(true);
        datePickerLowest.getMonthView().setEnabled(true);
        datePickerLowestInput.getMonthView().setEnabled(true);
        
        menuItemCadastradosHoje.setText("Cheques Cadastrados Hoje ("+
               Format.todayDate("dd/MM/yy") +")");
       
        menuItemVencimentoHoje.setText("Cheques com Vencimento para Hoje ("+
               Format.todayDate("dd/MM/yy") +")");
        
        setupTable();
        clearForm(false);
    }
    
   private void setupTable() {
        model = (QueryTableModel) tableCheck.getModel();
        setupTableSorter();
        SubstanceDefaultTableCellRenderer left = 
                new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer center = 
                new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer right = 
                new SubstanceDefaultTableCellRenderer();
        left.setHorizontalAlignment(SwingConstants.LEFT);
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        center.setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)tableCheck.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tableCheck.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(left);
        columnModel.getColumn(1).setCellRenderer(left);
        columnModel.getColumn(2).setCellRenderer(center);
        columnModel.getColumn(3).setCellRenderer(center);
        columnModel.getColumn(4).setCellRenderer(center);
        columnModel.getColumn(5).setCellRenderer(right);
        columnModel.getColumn(6).setCellRenderer(center);
        columnModel.getColumn(7).setCellRenderer(left); 
        columnModel.getColumn(8).setCellRenderer(center);
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(0).setPreferredWidth(210);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(1).setPreferredWidth(85);
        columnModel.getColumn(2).setResizable(false);
        columnModel.getColumn(2).setPreferredWidth(10);
        columnModel.getColumn(3).setResizable(false);
        columnModel.getColumn(3).setPreferredWidth(15);
        columnModel.getColumn(4).setResizable(false);
        columnModel.getColumn(4).setPreferredWidth(30);
        columnModel.getColumn(5).setResizable(false);
        columnModel.getColumn(5).setPreferredWidth(35);
        columnModel.getColumn(6).setResizable(false);
        columnModel.getColumn(6).setPreferredWidth(40);
        columnModel.getColumn(7).setResizable(false);
        columnModel.getColumn(7).setPreferredWidth(150);
        columnModel.getColumn(8).setResizable(false);
        columnModel.getColumn(8).setPreferredWidth(40);
    }
        
    private void setupFocusComponents(){
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldRegistryNumber);
        list.add(textFieldPayee);
        list.add(textFieldLowestGross);
        list.add(textFieldHighestGross);
        list.add(textFieldNumber);
        list.add(textFieldBank);
        list.add(comboBox);
        list.add(buttonClear);
        list.add(buttonRefresh);
        
        setFocusTraversalPolicy(new FocusPolicy(list));
        
        FocusPolicy.setDefaultTrasversalKeys(panelForm, FocusPolicy.BOTH_DIRECTIONS);
        FocusPolicy.setDefaultTrasversalKeys(comboBox, FocusPolicy.FORWARD); 
    }
    
    
    private void setupTableSorter() {
        TableRowSorter<TableModel> sorter = 
                new TableRowSorter<>(tableCheck.getModel());
        List <RowSorter.SortKey> sortKey = new ArrayList<>();
        sortKey.add(new RowSorter.SortKey(5, SortOrder.ASCENDING));
        sorter.setComparator(5, decimalCompare);
        sorter.setComparator(6, dateCompare);
        sorter.setComparator(7, clientCompare);
        sorter.setComparator(8, dateCompare);
        sorter.setSortKeys(sortKey);
        tableCheck.setRowSorter(sorter);
    }
    
    private void sortByColumn(int index) {
        tableCheck.getRowSorter().setSortKeys(null);
        TableRowSorter<TableModel> sorter = 
                new TableRowSorter<>(tableCheck.getModel());
        List <RowSorter.SortKey> sortKey = new ArrayList<>();
        sortKey.add(new RowSorter.SortKey(index, SortOrder.ASCENDING));
        sorter.setComparator(5, decimalCompare);
        sorter.setComparator(6, dateCompare);
        sorter.setComparator(7, clientCompare);
        sorter.setComparator(8, dateCompare);
        sorter.setSortKeys(sortKey);
        tableCheck.setRowSorter(sorter);
    } 
    
    private double stringToDouble(String strValor, boolean valorMaior) {
        String str = strValor;
        if (str.isEmpty() || str.length()<3) {
            return valorMaior? 2000000.0 : 0.0;
        } else {
            return Deformat.andConvertDecimal(strValor);
        }
        
    }

    private int stringToInt(String str) {
        if (str.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(str);
        }
    }

    public void setPayeeInForm(Payee payee) {
        textFieldRegistryNumber.setText(payee.getRegistryNumber());
    }
    
    // </editor-fold>

    private void removeTableRow() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int row = tableCheck.getSelectedRow();
                int modelIndex = tableCheck.convertRowIndexToModel(row);
                Check check = checkList.get(modelIndex);
                StringBuilder msg = new StringBuilder();
                msg.append("Dados do Cheque:\n\n");
                msg.append("Emitente: ");
                msg.append(check.getPayee().getName());
                msg.append("\nValor: ");
                msg.append(Format.currency(check.getGross()));
                msg.append("\nVencimento: ");
                msg.append(Format.date(check.getExpiration()));
                msg.append("\nCliente: ");
                msg.append(check.getClientName());
                msg.append("\n\nDeseja realmente apagar o cheque selecionado?\nEste processo é irreversível.\n\n");
                int choice = JOptionPane.showConfirmDialog(thisFrame, msg.toString(),
                        "Exclusão", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    try {
                        checkControl.delete(check.getId());
                        new PayeeController(conn).decrementCounter(check.getPayee().getRegistryNumber());
                        model.remove(modelIndex);
                        checkList.remove(modelIndex);
                        labelGrossAmount.setText(Format.decimal(model.getGrossAmount()));
                    } catch (SQLException ex) {
                        LOG.log(Level.SEVERE, null, ex);
                    }
                } 
            }
        });
    }

    private void deleteSelectedRows() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StringBuilder msg = new StringBuilder();
                msg.append("ATENÇÃO:\n\n");
                msg.append("Você selecionou ");
                msg.append(tableCheck.getSelectedRowCount());
                msg.append(" linhas para exclusão.");
                msg.append("\n\nDeseja realmente APAGAR PERMANENTEMENTE os cheques selecionados?\n\nEste processo é IRREVERSÍVEL.\n\n");
                int choice = JOptionPane.showConfirmDialog(thisFrame, msg.toString(),
                        "Exclusão", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice != JOptionPane.YES_OPTION) {
                    return;
                } 
                try {
                    int selected[] = tableCheck.getSelectedRows();
                    for (int i=0; i<selected.length; i++) {
                        int modelIndex = tableCheck.convertRowIndexToModel(selected[0]);
                        Check check = checkList.get(modelIndex);
                        checkControl.delete(check.getId());
                        new PayeeController(conn).decrementCounter(check.getPayee().getRegistryNumber());
                        checkList.remove(modelIndex);
                        model.remove(modelIndex);
                    } 
                    labelGrossAmount.setText(Format.decimal(model.getGrossAmount()));
                } catch (SQLException ex) {
                    LOG.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        });
    }
    
}
