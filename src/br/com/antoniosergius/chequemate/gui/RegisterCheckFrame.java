package br.com.antoniosergius.chequemate.gui;

import br.com.antoniosergius.chequemate.ctrl.CheckController;
import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.gui.dialog.AddMultipleChecks;
import br.com.antoniosergius.chequemate.gui.dialog.AddSuffixPayee;
import br.com.antoniosergius.chequemate.gui.dialog.AlterRecordCheck;
import br.com.antoniosergius.chequemate.gui.utils.RecordTableModel;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.obj.Parameters;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.chequemate.obj.Query;
import br.com.antoniosergius.chequemate.obj.record.RecordCheck;
import br.com.antoniosergius.chequemate.report.ReportFactory;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.chequemate.util.MyPath;
import br.com.antoniosergius.chequemate.util.io.RecordFile;
import br.com.antoniosergius.chequemate.util.tools.Compare;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.util.io.Serialize;
import br.com.antoniosergius.lib.verif.IntegerVerifier;
import br.com.antoniosergius.lib.verif.MoneyVerifier;
import br.com.antoniosergius.lib.verif.PercentVerifier;
import br.com.antoniosergius.lib.verif.RegistryNumberVerifier;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultEditorKit;
import net.sf.jasperreports.engine.JRException;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

public class RegisterCheckFrame extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(RegisterCheckFrame.class.getName());
    
    private final ArrayList<Check> deletedOnes; 
    private ArrayList<String> registryList;
    private final HashMap<String, String> payeeMap;
    
    private final PayeeController payeeControl;
    private final CheckController checkControl;
    private final ClientController clientControl;
    
    private RecordCheck record;
    private final Connection conn;
    private boolean modified;
    private boolean hasSaved;
    private final MainFrame mainFrame;
    
    private RecordFile recordFile;
    private RecordTableModel model;
    private final GregorianCalendar inputDate;
    
    private final ChequeMateException exception = new ChequeMateException();
    
    public RegisterCheckFrame(MainFrame mainFrame, Connection conn) {
        record = new RecordCheck();
        inputDate = new GregorianCalendar();
        payeeMap = new HashMap<>();
        deletedOnes = new ArrayList<>();
        checkControl = new CheckController(conn);
        payeeControl = new PayeeController(conn);
        clientControl = new ClientController(conn);
        hasSaved = false;
        this.conn = conn;
        this.mainFrame = mainFrame;
        recordFile = null;
        modified = false;
        initComponents();   
        setupComponents();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupTableMenu = new javax.swing.JPopupMenu();
        menuItemRemoveRow = new javax.swing.JMenuItem();
        menuItemVerifyPayee = new javax.swing.JMenuItem();
        scrollPaneCheck = new javax.swing.JScrollPane();
        tableCheck = new javax.swing.JTable();
        panelCheckForm = new javax.swing.JPanel();
        labelNumber = new javax.swing.JLabel();
        labelBank = new javax.swing.JLabel();
        labelAgency = new javax.swing.JLabel();
        labelGross = new javax.swing.JLabel();
        textFieldGross = new javax.swing.JTextField();
        labelRegistryNumber = new javax.swing.JLabel();
        textFieldRegistryNumber = new javax.swing.JTextField();
        labelPayee = new javax.swing.JLabel();
        textFieldPayee = new javax.swing.JTextField();
        formattedTextFieldExpiration = new javax.swing.JFormattedTextField();
        labelExpiration = new javax.swing.JLabel();
        buttonClearForm = new javax.swing.JButton();
        textFieldNumber = new javax.swing.JTextField();
        textFieldBank = new javax.swing.JTextField();
        textFieldAgency = new javax.swing.JTextField();
        labelCheckCount = new org.jdesktop.swingx.JXLabel();
        panelClientData = new javax.swing.JPanel();
        labelClient = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox();
        labelBaseDate = new javax.swing.JLabel();
        datePickerBaseDate = new org.jdesktop.swingx.JXDatePicker();
        labelRate = new javax.swing.JLabel();
        labelPercentage = new javax.swing.JLabel();
        textFieldRate = new javax.swing.JTextField();
        labelMinExpiration = new org.jdesktop.swingx.JXLabel();
        textFieldMinExpirationDays = new javax.swing.JTextField();
        labelDays = new org.jdesktop.swingx.JXLabel();
        header = new org.jdesktop.swingx.JXHeader();
        toolBar = new javax.swing.JToolBar();
        buttonNewRecord = new javax.swing.JButton();
        buttonPrint = new javax.swing.JButton();
        buttonSaveRecord = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        buttonMultipleChecks = new javax.swing.JButton();
        buttonSuffix = new javax.swing.JButton();
        separator = new javax.swing.JToolBar.Separator();
        buttonExit = new javax.swing.JButton();
        panelValues = new javax.swing.JPanel();
        labelRetention = new javax.swing.JLabel();
        labelRetentionDynamic = new javax.swing.JLabel();
        labelNetAmount = new javax.swing.JLabel();
        labelNetDynamic = new javax.swing.JLabel();
        labelGrossDynamic = new javax.swing.JLabel();
        labelGrossAmount = new javax.swing.JLabel();
        labelError = new javax.swing.JLabel();

        menuItemRemoveRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.remove.png"))); // NOI18N
        menuItemRemoveRow.setText("Apagar linha(s)");
        menuItemRemoveRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRemoveRowActionPerformed(evt);
            }
        });
        popupTableMenu.add(menuItemRemoveRow);

        menuItemVerifyPayee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.view.png"))); // NOI18N
        menuItemVerifyPayee.setText("Verificar Emitente...");
        menuItemVerifyPayee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerifyPayeeActionPerformed(evt);
            }
        });
        popupTableMenu.add(menuItemVerifyPayee);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tableCheck.setModel(new RecordTableModel());
        tableCheck.setToolTipText("Cheques");
        tableCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tableCheck.setName(""); // NOI18N
        tableCheck.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableCheck.getTableHeader().setReorderingAllowed(false);
        tableCheck.setUpdateSelectionOnSort(false);
        tableCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCheckMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCheckMouseReleased(evt);
            }
        });
        scrollPaneCheck.setViewportView(tableCheck);
        tableCheck.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelCheckForm.setBorder(javax.swing.BorderFactory.createTitledBorder("Cheque"));

        labelNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumber.setText("Número");

        labelBank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBank.setText("Banco");

        labelAgency.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAgency.setText("Agência");

        labelGross.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGross.setText("Valor");

        textFieldGross.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldGross.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldGrossFocusGained(evt);
            }
        });

        labelRegistryNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRegistryNumber.setText("CPF/CNPJ");

        textFieldRegistryNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldRegistryNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldRegistryNumberFocusLost(evt);
            }
        });

        labelPayee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPayee.setText("Emitente");

        textFieldPayee.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        try {
            formattedTextFieldExpiration.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldExpiration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formattedTextFieldExpiration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formattedTextFieldExpirationFocusGained(evt);
            }
        });
        formattedTextFieldExpiration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formattedTextFieldExpirationKeyReleased(evt);
            }
        });

        labelExpiration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExpiration.setText("Data Boa");

        buttonClearForm.setText("Limpar");
        buttonClearForm.setToolTipText("Limpa os Campos sem apagar a linha na tabela");
        buttonClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearFormActionPerformed(evt);
            }
        });

        textFieldNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldNumberFocusGained(evt);
            }
        });
        textFieldNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldNumberKeyReleased(evt);
            }
        });

        textFieldBank.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldBank.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldBankFocusGained(evt);
            }
        });
        textFieldBank.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldBankKeyReleased(evt);
            }
        });

        textFieldAgency.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldAgency.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldAgencyFocusGained(evt);
            }
        });
        textFieldAgency.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldAgencyKeyReleased(evt);
            }
        });

        labelCheckCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelCheckFormLayout = new javax.swing.GroupLayout(panelCheckForm);
        panelCheckForm.setLayout(panelCheckFormLayout);
        panelCheckFormLayout.setHorizontalGroup(
            panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(textFieldNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelBank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldBank))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelAgency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldAgency))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldGross)
                    .addComponent(labelGross, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldRegistryNumber)
                    .addComponent(labelRegistryNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldPayee)
                    .addComponent(labelPayee, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(formattedTextFieldExpiration)
                    .addComponent(labelExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCheckCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonClearForm)
                .addContainerGap())
        );
        panelCheckFormLayout.setVerticalGroup(
            panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCheckFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNumber)
                            .addComponent(labelBank)
                            .addComponent(labelAgency)
                            .addComponent(labelGross)
                            .addComponent(labelRegistryNumber)
                            .addComponent(labelPayee)
                            .addComponent(labelExpiration))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCheckFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldGross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldRegistryNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPayee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(formattedTextFieldExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldAgency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCheckCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonClearForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelCheckFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {formattedTextFieldExpiration, labelCheckCount});

        panelClientData.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        labelClient.setText("Cliente:");

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

        labelBaseDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBaseDate.setText("Data Base do Cálculo:");

        datePickerBaseDate.setDate(new Date());
        datePickerBaseDate.setFormats(new String[]{"EEEEEE, dd MMMMMMM yyyy"});
        datePickerBaseDate.setEditable(false);
        datePickerBaseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerBaseDateActionPerformed(evt);
            }
        });

        labelRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRate.setText("Taxa:");

        labelPercentage.setText("%");

        labelMinExpiration.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelMinExpiration.setText("Venc. Mínimo:");

        labelDays.setText("dias");

        javax.swing.GroupLayout panelClientDataLayout = new javax.swing.GroupLayout(panelClientData);
        panelClientData.setLayout(panelClientDataLayout);
        panelClientDataLayout.setHorizontalGroup(
            panelClientDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(labelRate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPercentage)
                .addGap(18, 18, 18)
                .addComponent(labelBaseDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datePickerBaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMinExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldMinExpirationDays, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelClientDataLayout.setVerticalGroup(
            panelClientDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldMinExpirationDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMinExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datePickerBaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRate)
                    .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPercentage)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        header.setTitle("Cadastro de Cheques");
        header.setOpaque(false);

        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setBorder(null);
        toolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        buttonNewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.new.png"))); // NOI18N
        buttonNewRecord.setToolTipText("Novo Cadastro");
        buttonNewRecord.setFocusable(false);
        buttonNewRecord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonNewRecord.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewRecordActionPerformed(evt);
            }
        });
        toolBar.add(buttonNewRecord);

        buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.print.png"))); // NOI18N
        buttonPrint.setToolTipText("Imprimir");
        buttonPrint.setFocusable(false);
        buttonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });
        toolBar.add(buttonPrint);

        buttonSaveRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.save.png"))); // NOI18N
        buttonSaveRecord.setToolTipText("Salvar");
        buttonSaveRecord.setFocusable(false);
        buttonSaveRecord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSaveRecord.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonSaveRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveRecordActionPerformed(evt);
            }
        });
        toolBar.add(buttonSaveRecord);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.refresh.png"))); // NOI18N
        buttonRefresh.setToolTipText("Atualizar Valores");
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        toolBar.add(buttonRefresh);

        buttonMultipleChecks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.multiple.png"))); // NOI18N
        buttonMultipleChecks.setToolTipText("Adicionar Multiplos Cheques");
        buttonMultipleChecks.setFocusable(false);
        buttonMultipleChecks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonMultipleChecks.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonMultipleChecks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMultipleChecksActionPerformed(evt);
            }
        });
        toolBar.add(buttonMultipleChecks);

        buttonSuffix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.suffix.png"))); // NOI18N
        buttonSuffix.setToolTipText("Inserir Texto ao Final do Emitente");
        buttonSuffix.setFocusable(false);
        buttonSuffix.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSuffix.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonSuffix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSuffixActionPerformed(evt);
            }
        });
        toolBar.add(buttonSuffix);
        toolBar.add(separator);

        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.exit.png"))); // NOI18N
        buttonExit.setToolTipText("Fechar");
        buttonExit.setFocusable(false);
        buttonExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        toolBar.add(buttonExit);

        labelRetention.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelRetention.setForeground(new java.awt.Color(50, 156, 106));
        labelRetention.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRetention.setText("Retenção:");

        labelRetentionDynamic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelRetentionDynamic.setForeground(new java.awt.Color(50, 156, 106));
        labelRetentionDynamic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelNetAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNetAmount.setForeground(new java.awt.Color(255, 51, 51));
        labelNetAmount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNetAmount.setText("Total Valor Líquido:");

        labelNetDynamic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNetDynamic.setForeground(new java.awt.Color(255, 51, 51));
        labelNetDynamic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelGrossDynamic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelGrossDynamic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelGrossAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelGrossAmount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGrossAmount.setText("Total Valor Bruto: ");

        labelError.setForeground(new java.awt.Color(255, 51, 51));
        labelError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelError.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelValuesLayout = new javax.swing.GroupLayout(panelValues);
        panelValues.setLayout(panelValuesLayout);
        panelValuesLayout.setHorizontalGroup(
            panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValuesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNetAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGrossAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRetention, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelGrossDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNetDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRetentionDynamic, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelValuesLayout.setVerticalGroup(
            panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelValuesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelValuesLayout.createSequentialGroup()
                        .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelGrossAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelGrossDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNetAmount)
                            .addComponent(labelNetDynamic, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRetentionDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelRetention))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelValues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCheckForm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPaneCheck, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelClientData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelClientData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCheckForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearFormActionPerformed
        clearForm();
    }//GEN-LAST:event_buttonClearFormActionPerformed

    private void formattedTextFieldExpirationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formattedTextFieldExpirationKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER && !isToday()) {
            try {
                addTableCheck(getCheckFromForm());
                clearForm();
            } catch (ChequeMateException ex) {
                //LOG.log(Level.WARNING, ex.getMessage(), ex);
                ex.showExceptionMessage(labelError);
                new Thread(new EraseErrorLabel()).start();
            }
        } 
    }//GEN-LAST:event_formattedTextFieldExpirationKeyReleased

    private void formattedTextFieldExpirationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formattedTextFieldExpirationFocusGained
        if (isToday()) {
            formattedTextFieldExpiration.setCaretPosition(0);
        }
    }//GEN-LAST:event_formattedTextFieldExpirationFocusGained

    private void tableCheckMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCheckMouseReleased
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int rowNumber = tableCheck.rowAtPoint( p );
            if (rowNumber != -1) {
                tableCheck.setRowSelectionInterval(rowNumber, rowNumber);
                if (evt.isPopupTrigger()) {
                    popupTableMenu.show(tableCheck, evt.getX(), evt.getY());
                }
            }    
        }    
    }//GEN-LAST:event_tableCheckMouseReleased

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                printRecord();
            } catch (ChequeMateException ex) {
                LOG.log(Level.WARNING, ex.getMessage(), ex);
                ex.showExceptionMessage(); 
            }
        });
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        SwingUtilities.invokeLater(() -> {
            exitForm();
        });
    }//GEN-LAST:event_buttonExitActionPerformed

    private void datePickerBaseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerBaseDateActionPerformed
        if (datePickerBaseDate.getDate() == null) {
            return;
        }
        GregorianCalendar oldDate = record.getBaseDate();
        GregorianCalendar calcDate = new GregorianCalendar();
        calcDate.setTime(datePickerBaseDate.getDate());
        if (!Days.equals(oldDate, calcDate)) {
            record.setBaseDate(calcDate);
            record.recalculate(model);
            updateValueLabels();
            modified = true;
        }
    }//GEN-LAST:event_datePickerBaseDateActionPerformed

    private void textFieldRegistryNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldRegistryNumberFocusLost
        processRegistryInput();
    }//GEN-LAST:event_textFieldRegistryNumberFocusLost

    private void buttonSaveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveRecordActionPerformed
        SwingUtilities.invokeLater(() -> {
            try {
                apply();
            } catch (ChequeMateException ex) {
                LOG.log(Level.WARNING, ex.getMessage(), ex);
                ex.showExceptionMessage();
            }
        });
    }//GEN-LAST:event_buttonSaveRecordActionPerformed

    private void tableCheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCheckMouseClicked
        if (evt.getClickCount() == 2) {
            Point p = evt.getPoint();
            int rowNumber = tableCheck.rowAtPoint( p );
            if (rowNumber != -1) {
                //tableCheck.setRowSelectionInterval(rowNumber, rowNumber);
                int modelIndex = tableCheck.convertRowIndexToModel(tableCheck.getSelectedRow());
                editRow(modelIndex);
            }  
        }
    }//GEN-LAST:event_tableCheckMouseClicked

    private void buttonNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewRecordActionPerformed
        SwingUtilities.invokeLater(() -> {
            newRecord();
        });
    }//GEN-LAST:event_buttonNewRecordActionPerformed

    private void menuItemRemoveRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRemoveRowActionPerformed
        int row = tableCheck.getSelectedRow();
        if (row != -1) {
            Check check = record.getList().get(row);
            deletedOnes.add(check);
            model.remove(row);
            record.getList().remove(row);
            record.updateAmount();
            updateValueLabels();
            modified = true;
        }
    }//GEN-LAST:event_menuItemRemoveRowActionPerformed

    private void textFieldNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNumberFocusGained
        textFieldNumber.setCaretPosition(textFieldNumber.getDocument().getLength());
        textFieldNumber.moveCaretPosition(0);
    }//GEN-LAST:event_textFieldNumberFocusGained

    private void textFieldNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNumberKeyReleased
        if (textFieldNumber.getCaretPosition()==6) {
            textFieldBank.requestFocusInWindow();
        }
    }//GEN-LAST:event_textFieldNumberKeyReleased

    private void textFieldBankKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldBankKeyReleased
        if (textFieldBank.getCaretPosition()==3) {
            textFieldAgency.requestFocusInWindow();
        }
    }//GEN-LAST:event_textFieldBankKeyReleased

    private void textFieldAgencyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldAgencyKeyReleased
        if (textFieldAgency.getCaretPosition()==4) {
            textFieldGross.requestFocusInWindow();
        }
    }//GEN-LAST:event_textFieldAgencyKeyReleased

    private void textFieldBankFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldBankFocusGained
        textFieldBank.setCaretPosition(textFieldBank.getDocument().getLength());
        textFieldBank.moveCaretPosition(0);
    }//GEN-LAST:event_textFieldBankFocusGained

    private void textFieldAgencyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldAgencyFocusGained
        textFieldAgency.setCaretPosition(textFieldAgency.getDocument().getLength());
        textFieldAgency.moveCaretPosition(0);
    }//GEN-LAST:event_textFieldAgencyFocusGained

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void menuItemVerifyPayeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerifyPayeeActionPerformed
        int row = tableCheck.getSelectedRow();
        if (row != -1) {
            QueryCheckFrame queryFrame = new QueryCheckFrame(conn);
            queryFrame.setMainFrame(mainFrame);
            Query query = new Query();
            Payee payee = new Payee(record.getList().get(row).getPayee().getRegistryNumber());
            query.setPayee(payee);
            queryFrame.setQueryObject(query);
            queryFrame.setPayeeInForm(payee);
            queryFrame.queryAndSetupTableData();
            queryFrame.setVisible(true); 
        }
    }//GEN-LAST:event_menuItemVerifyPayeeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        SwingUtilities.invokeLater(this::exitForm);
    }//GEN-LAST:event_formWindowClosing

    private void comboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboBoxPopupMenuWillBecomeInvisible
        int selectedIndex = comboBox.getSelectedIndex();
        if (selectedIndex != -1) {
            try {
                String item = (String) comboBox.getSelectedItem();
                int idClient = Client.getId(item, Client.ID_SUFFIX);
                double rate = clientControl.getRate(idClient);
                textFieldRate.setText(Format.decimal(rate));
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }//GEN-LAST:event_comboBoxPopupMenuWillBecomeInvisible

    private void buttonMultipleChecksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMultipleChecksActionPerformed
        new AddMultipleChecks(this, true, payeeControl).setVisible(true);
    }//GEN-LAST:event_buttonMultipleChecksActionPerformed

    private void buttonSuffixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuffixActionPerformed
        if (model.isEmpty()) {
            ChequeMate.showWarningMessage(null, "Alerta!", "Não existe nenhum cheque cadastrado.");
        } else {
            new AddSuffixPayee(this, true).setVisible(true);
        }
    }//GEN-LAST:event_buttonSuffixActionPerformed

    private void textFieldGrossFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldGrossFocusGained
        textFieldGross.setCaretPosition(textFieldGross.getDocument().getLength());
        textFieldGross.moveCaretPosition(0);
    }//GEN-LAST:event_textFieldGrossFocusGained

    // <editor-fold defaultstate="collapsed" desc="Variables GUI">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClearForm;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonMultipleChecks;
    private javax.swing.JButton buttonNewRecord;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSaveRecord;
    private javax.swing.JButton buttonSuffix;
    private javax.swing.JComboBox comboBox;
    private org.jdesktop.swingx.JXDatePicker datePickerBaseDate;
    private javax.swing.JFormattedTextField formattedTextFieldExpiration;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel labelAgency;
    private javax.swing.JLabel labelBank;
    private javax.swing.JLabel labelBaseDate;
    private org.jdesktop.swingx.JXLabel labelCheckCount;
    private javax.swing.JLabel labelClient;
    private org.jdesktop.swingx.JXLabel labelDays;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelExpiration;
    private javax.swing.JLabel labelGross;
    private javax.swing.JLabel labelGrossAmount;
    private javax.swing.JLabel labelGrossDynamic;
    private org.jdesktop.swingx.JXLabel labelMinExpiration;
    private javax.swing.JLabel labelNetAmount;
    private javax.swing.JLabel labelNetDynamic;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JLabel labelPayee;
    private javax.swing.JLabel labelPercentage;
    private javax.swing.JLabel labelRate;
    private javax.swing.JLabel labelRegistryNumber;
    private javax.swing.JLabel labelRetention;
    private javax.swing.JLabel labelRetentionDynamic;
    private javax.swing.JMenuItem menuItemRemoveRow;
    private javax.swing.JMenuItem menuItemVerifyPayee;
    private javax.swing.JPanel panelCheckForm;
    private javax.swing.JPanel panelClientData;
    private javax.swing.JPanel panelValues;
    private javax.swing.JPopupMenu popupTableMenu;
    private javax.swing.JScrollPane scrollPaneCheck;
    private javax.swing.JToolBar.Separator separator;
    private javax.swing.JTable tableCheck;
    private javax.swing.JTextField textFieldAgency;
    private javax.swing.JTextField textFieldBank;
    private javax.swing.JTextField textFieldGross;
    private javax.swing.JTextField textFieldMinExpirationDays;
    private javax.swing.JTextField textFieldNumber;
    private javax.swing.JTextField textFieldPayee;
    private javax.swing.JTextField textFieldRate;
    private javax.swing.JTextField textFieldRegistryNumber;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Get Check From Form">
    private Check getCheckFromForm() throws ChequeMateException {
        ChequeMateException ex = exception;
        String strNumber = textFieldNumber.getText();
        String strBank = textFieldBank.getText();
        String strAgency = textFieldAgency.getText();
        String registryNumber = textFieldRegistryNumber.getText();
        if (!registryNumber.isEmpty()) {
            registryNumber = Deformat.CPForCNPJ(registryNumber);
        }
        if (strNumber.isEmpty()) {
            strNumber = "000000";
            textFieldNumber.setText(strNumber);
        }
        int number = Integer.parseInt(strNumber);
        if (strBank.isEmpty()) {
            strBank = "000";
            textFieldBank.setText(strBank);
        }
        int bank = Integer.parseInt(strBank);
        if (strAgency.isEmpty()) {
            strAgency = "0000";
            textFieldAgency.setText(strAgency);
        }
        int agency = Integer.parseInt(strAgency);
        String strGross = textFieldGross.getText();
        if (strGross.isEmpty()) {
            throw ex.retrieve("Digite o valor do cheque.", textFieldGross);
        }
        String payeeName = textFieldPayee.getText();
        if (payeeName.isEmpty()) {
            throw ex.retrieve("Digite o emitente do cheque.", textFieldPayee);
        }
        String strExpiration = formattedTextFieldExpiration.getText();
        GregorianCalendar baseDate = getBaseDate();
        GregorianCalendar expiration = setupExpirationStringDate(strExpiration);
        boolean isValidDate = false;
        if (expiration != null) {
            if (expiration.after(baseDate)) {
                isValidDate = true;
            }
        }
        if (!isValidDate || Days.between(Days.TODAY, expiration) > 8*Days.IN_YEAR) {
            throw ex.retrieve("Data inválida.", formattedTextFieldExpiration);
        }
        GregorianCalendar calcDate = new GregorianCalendar();
        calcDate.setTime(ChequeMate.getHolidayControl().nextBusinessDate(expiration.getTime(), Parameters.WITH_MIN_DAYS));
        int daysBetween = Days.between(baseDate, calcDate);
        
        String strRate = textFieldRate.getText();
        strRate = strRate.isEmpty() ? String.valueOf(ChequeMate.getPreferences().getDefaultRate())
                : Deformat.decimal(strRate);
        BigDecimal rate = new BigDecimal(strRate, new MathContext(20));
        BigDecimal gross = new BigDecimal(Deformat.decimal(strGross), new MathContext(20));
        
        BigDecimal net = ChequeMate.calculateInterest(gross, daysBetween, rate);
        payeeName = payeeName.trim().toUpperCase();
        
        Check check = new Check(number, bank, agency, 
                gross.doubleValue(), net.doubleValue(), rate.doubleValue(), 
                new Payee(payeeName, registryNumber), expiration, calcDate);
        
        for (Check c : record.getList()) {
            if (c.hashCode()==check.hashCode()) {
                throw ex.retrieve("Já existe na tabela um cheque com o mesmo número, banco, agência e emitente.", textFieldNumber);
            }
        }
        //checar se existe um cheque com o mesmo número, banco, agência e CPF no BD
        boolean exists = true;
        try {
            exists = checkControl.exists(check);
            System.out.println("existe "+exists);
        } catch (SQLException e) {
            LOG.log(Level.WARNING, e.getMessage(), e);
        }
        if (exists){
            throw ex.retrieve("Já existe no sistema um cheque com o mesmo número, banco, agência e emitente.", textFieldNumber);
        }
        return check;
    }
    // </editor-fold>
    
    @SuppressWarnings("unchecked")
    private void setupComboBox() {
        comboBox.removeAllItems();
        ArrayList<String> list;
        try {
            list = clientControl.getNameList();
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
            return;
        }
        int size = list.size();
        Collections.sort(list);
        for (int i=0; i<size; i++) {
            comboBox.addItem(list.get(i));
        }
        comboBox.setSelectedIndex(-1);
    }
    
    private void apply() throws ChequeMateException{
        ChequeMateException ex = exception;
        if (comboBox.getSelectedIndex()==-1) {
            throw ex.retrieve("O cliente precisa ser escolhido.", comboBox);
        } else {
            String item = (String)comboBox.getSelectedItem();
            int idClient = Client.getId(item, Client.ID_SUFFIX);
            record.setIdClient(idClient);
        }
        if (model.isEmpty() && deletedOnes.isEmpty()) {
            throw ex.retrieve("Não há cheque(s) cadastrado(s).", textFieldNumber);
        }
        saveRecord();
    }
    
    private void saveRecord() {
        try {
            checkControl.doTransaction(record, deletedOnes);
            deletedOnes.clear();
            updateStorageFile();
            modified = false;
            hasSaved = true;
            ChequeMate.showSuccessMessage(this, "Cadastro salvo com sucesso.");
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException | SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        } 
    }
    
    private void exitForm() {
        if (modified){
            int choice = JOptionPane.showConfirmDialog(this, "Deseja salvar os dados antes de sair?",
                    "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                try {
                    apply();
                } catch (ChequeMateException ex) {
                    LOG.log(Level.WARNING, ex.getMessage(), ex);
                    ex.showExceptionMessage();
                }
            } 
        }
        updatePayeesHistory();
        dispose();
        mainFrame.updateSystemInfo(); 
    }
    
    private void newRecord() {
        if (modified) {
            int choice = JOptionPane.showConfirmDialog(this, 
                    "Deseja salvar os dados antes de abrir um novo cadastro?",
                    "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                try {
                    apply();
                } catch (ChequeMateException ex) {
                    LOG.log(Level.WARNING, ex.getMessage(), ex);
                    ex.showExceptionMessage();
                }
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        updatePayeesHistory();
        setFormToNewRecord();
    }

    private void updateStorageFile() throws FileNotFoundException, IOException {
        Client client = Client.getFromString((String)comboBox.getSelectedItem(), Client.ID_SUFFIX);
        recordFile = new RecordFile(client, inputDate, record.getList());
        String path = MyPath.REGISTRIES+recordFile.createFileName();
        Serialize<RecordFile> serial = new Serialize<>(recordFile, path);
        if (record.getList().isEmpty() && Serialize.hasFile(path)) {
            Serialize.delete(path);
        } else {
            serial.write();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Update and others methods">
    public void addTableCheck(Check check) {
        int row = tableCheck.getRowCount();
        model.add(check, row);
        scrollToVisible(tableCheck, row, 0);
        increaseRecordAmount(check.getGross(), check.getNet());
        record.getList().add(check);
        Payee payee = check.getPayee();
        
        payeeMap.put(payee.getRegistryNumber(), payee.getName());
        if (!registryList.contains(payee.getRegistryNumber())) {
            registryList.add(payee.getRegistryNumber());
        }
        modified = true;
    }
    
    public void replaceTableCheck(int row, Check check) {
        record.replaceCheck(row, check, model);
        updateValueLabels();
        modified = true;
    }

    private void increaseRecordAmount(double gross, double net) {
        record.increase(new BigDecimal(gross), new BigDecimal(net));
        updateValueLabels();
    }
    
    public void updateValueLabels() {
        labelGrossDynamic.setText(Format.decimal(record.getGrossAmount().doubleValue()));
        labelNetDynamic.setText(Format.decimal(record.getNetAmount().doubleValue()));
        labelRetentionDynamic.setText(Format.decimal(record.getRetention().doubleValue()));
    }
    
    private boolean isToday() {
        String strDate = formattedTextFieldExpiration.getText();
        GregorianCalendar date = Convert.toGregorian(strDate, "dd/MM/yy");
        if (date == null) {
            formattedTextFieldExpiration.setCaretPosition(0);
            return false;
        }
        boolean isToday = true;
        if (!Days.isToday(date)) {
            formattedTextFieldExpiration.setCaretPosition(0);
            isToday = false;
        }
        return isToday;
    }
    
    private void printRecord() throws ChequeMateException{
        ChequeMateException ex = exception;
        if (model.isEmpty()) {
            throw ex.retrieve("Não existem dados para imprimir.", textFieldNumber);
        }
        if (comboBox.getSelectedIndex()==-1) {
            throw ex.retrieve("O cliente precisa ser escolhido.", comboBox);
        }
        String strClient = (String)comboBox.getSelectedItem();
        ArrayList<Check> checkList = record.getList();
        Collections.sort(checkList, new Compare.CheckExpiration());
        try {
            ReportFactory.viewRecord(strClient, checkList);
        } catch (SQLException | JRException | IOException exc) {
            LOG.log(Level.SEVERE, exc.getMessage(), exc);
        } 
    }
    
    private void updateRateOnTable() throws ChequeMateException {
        ChequeMateException ex = exception;
        Date baseDate = datePickerBaseDate.getDate();
        if (datePickerBaseDate.getDate() == null) {
            baseDate = new Date();
            datePickerBaseDate.setDate(baseDate);
        }
        String strRate = textFieldRate.getText();
        if (strRate.isEmpty()) {
            throw ex.retrieve("Favor preencher a taxa.", textFieldRate);
        } 
        int choice = JOptionPane.showConfirmDialog(this, 
                "Quer realmente atualizar a taxa de todos os cheques da tabela?",
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            double rate = Deformat.andConvertDecimal(strRate);
            GregorianCalendar oldBaseDate = record.getBaseDate();
            GregorianCalendar newBaseDate = new GregorianCalendar();
            newBaseDate.setTime(baseDate);
            if (!Days.equals(oldBaseDate, newBaseDate)) {
                record.setBaseDate(newBaseDate);
            }
            record.recalculate(model, rate);
            updateValueLabels();
            modified = true;
        }
                
    }
    
    public GregorianCalendar getBaseDate() {
        GregorianCalendar baseDate;
        if (datePickerBaseDate.getMonthView().isSelectionEmpty()) {
            baseDate = Days.TODAY;
        } else {
            baseDate = new GregorianCalendar();
            baseDate.setTimeInMillis(datePickerBaseDate.getDate().getTime());
        }
        return baseDate;
    }
    
    private void setupRegistryList() {
        try {
            registryList = payeeControl.getRegistryNumberList();
            AutoCompleteDecorator.decorate(textFieldRegistryNumber, registryList, false); 
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
        }
    }

    private void editRow(int row) {
        Date baseDate = datePickerBaseDate.getDate();
        if (baseDate == null) {
            baseDate = new Date();
        }
        Check check = record.getList().get(row);
        new AlterRecordCheck(this, true, check, baseDate, row).setVisible(true);
    }
    
    private void refresh() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    updateRateOnTable();
                } catch (ChequeMateException ex) {
                    LOG.log(Level.WARNING, ex.getMessage(), ex);
                    ex.showExceptionMessage();
                }
            }
        });
    }

    private GregorianCalendar setupExpirationStringDate(String strExpiration) {
        GregorianCalendar auxDate = Convert.toGregorian(strExpiration, "dd/MM/yy");
        if (auxDate != null) {
            if (auxDate.before(Days.TODAY)) {
                Days.setupExpiration(auxDate);
            }
        }
        return auxDate;
    }

    private int countRegistryChecks(String registryNumber) {
        try {
            return checkControl.countCheckOutstanding(registryNumber);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    private int countTotalPayeeChecks(String registryNumber) {
        try {
            return payeeControl.getCounter(registryNumber);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    private void updatePayeesHistory() {
        if (hasSaved) {
            try {
                payeeControl.updateFromCheckList(record.getList());
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }      
        }
    }

    private void setFormToNewRecord() {
        modified = false;
        hasSaved = false;
        model.clear();
        record = new RecordCheck();
        deletedOnes.clear();
        updateValueLabels();
        comboBox.setSelectedIndex(-1);
        comboBox.requestFocusInWindow();
    }

    private String getStatusString(int activeChecks, int totalChecks) {
        StringBuilder tmp = new StringBuilder();
        if (totalChecks > 0) {
            tmp.append(totalChecks);
            tmp.append(" passado(s)");
        }
        if (activeChecks > 0) {
            tmp.append(tmp.length()!=0 ?"  /  " : "");
            tmp.append(activeChecks);
            tmp.append(" em aberto");
        } 
        return tmp.toString();
    }
    
    private void processRegistryInput() {
        String registryNumber = textFieldRegistryNumber.getText();
        String payeeName = textFieldPayee.getText();
        if (registryNumber.isEmpty() || 
           (Format.isRegistryFormatted(registryNumber) && !payeeName.isEmpty())) {
            return;
        }
        String unformattedRegistry = Deformat.CPForCNPJ(registryNumber);
        
        int activeChecks = countRegistryChecks(unformattedRegistry);
        int totalChecks = countTotalPayeeChecks(unformattedRegistry);
        String status = getStatusString(activeChecks, totalChecks);
        labelCheckCount.setText(status);
        
        String payeeFounded = null;
        if (payeeMap.containsKey(unformattedRegistry)) {
            payeeFounded = payeeMap.get(unformattedRegistry);
        } else {
            try {
                payeeFounded = payeeControl.getName(unformattedRegistry);
            } catch (SQLException ex) {
                LOG.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        if (payeeFounded != null) {
            if (!payeeName.isEmpty()) { // estiver preenchido
                if (!payeeFounded.equals(payeeName)) { //nao for igual
                    textFieldPayee.setText(payeeFounded);
                }
            } else { // estiver vazio
                textFieldPayee.setText(payeeFounded);
            }
            formattedTextFieldExpiration.requestFocus();
        }
    }

    private class EraseErrorLabel implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(4500);
                labelError.setText("");
            } catch (InterruptedException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setup components">
    private void setupComponents() {
       setLocationRelativeTo(null);
       setIconImage(new ImageIcon(getClass().getResource("/img/x16.calc.png")).getImage());
       setTitle("Cadastro de Cheques");
       setupFocusComponents();
       setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       formattedTextFieldExpiration.setFocusLostBehavior(JFormattedTextField.COMMIT);
       formattedTextFieldExpiration.setText(Format.todayDate("dd/MM/yy"));
       
       Verifier.set(textFieldGross, new MoneyVerifier());
       Verifier.set(textFieldRegistryNumber, new RegistryNumberVerifier(true, true));
       Verifier.set(textFieldBank, new IntegerVerifier(3));
       Verifier.set(textFieldNumber, new IntegerVerifier(6));
       Verifier.set(textFieldAgency, new IntegerVerifier(4));
       Verifier.set(textFieldPayee, new TextVerifier());
       Verifier.set(textFieldMinExpirationDays, new IntegerVerifier(2));
       Verifier.set(textFieldRate, new PercentVerifier());
       
       datePickerBaseDate.setEditable(false);
       datePickerBaseDate.getMonthView().setEnabled(true);
       
       Date calcDate = datePickerBaseDate.getDate();
       record.setBaseDate(calcDate != null ? calcDate : new Date());
       
       setupTableComponents();
       setupComboBox();
       AutoCompleteDecorator.decorate(comboBox);
       comboBox.requestFocusInWindow();
       
       int minDays = ChequeMate.getParameters().getMinExpirationDays();
       textFieldMinExpirationDays.setText(String.valueOf(minDays));
       textFieldRate.setText(Format.decimal(ChequeMate.getPreferences().getDefaultRate()));
       
       InputMap map = ((JComponent) textFieldRegistryNumber).getInputMap();
       map.put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, 0), 
                    DefaultEditorKit.deletePrevCharAction);
       setupRegistryList();
    }
    
    private void setupFocusComponents() {
        FocusPolicy.setDefaultTrasversalKeys(panelCheckForm, FocusPolicy.BOTH_DIRECTIONS);
        FocusPolicy.setDefaultTrasversalKeys(comboBox, FocusPolicy.FORWARD);
        
        formattedTextFieldExpiration.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, 
                KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalKeys(
                KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));

        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldNumber);
        list.add(textFieldBank);
        list.add(textFieldAgency);
        list.add(textFieldGross);
        list.add(textFieldRegistryNumber);
        list.add(textFieldPayee);
        list.add(formattedTextFieldExpiration);
        setFocusTraversalPolicy(new FocusPolicy(list));
    }
     
    private void clearForm() {
        textFieldNumber.setText("");
        textFieldBank.setText("");
        textFieldAgency.setText("");
        textFieldGross.setText("");
        textFieldRegistryNumber.setText("");
        textFieldPayee.setText("");
        labelCheckCount.setText("");
        formattedTextFieldExpiration.setText(Format.todayDate("dd/MM/yy"));
        textFieldNumber.requestFocusInWindow();
    }
    
    public void addToDeletedOnes(Check check) {
        deletedOnes.add(check);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setup Table Components">
    private void setupTableComponents() {
        model = (RecordTableModel) tableCheck.getModel();
        SubstanceDefaultTableCellRenderer left = new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer center = new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer right = new SubstanceDefaultTableCellRenderer();
        left.setHorizontalAlignment(SwingConstants.LEFT);
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        center.setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)tableCheck.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tableCheck.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(center);
        columnModel.getColumn(1).setCellRenderer(center);
        columnModel.getColumn(2).setCellRenderer(center);
        columnModel.getColumn(3).setCellRenderer(center);
        columnModel.getColumn(4).setCellRenderer(right);
        columnModel.getColumn(5).setCellRenderer(right);
        columnModel.getColumn(6).setCellRenderer(center);
        columnModel.getColumn(7).setCellRenderer(center);
        columnModel.getColumn(8).setCellRenderer(center);
        columnModel.getColumn(9).setCellRenderer(center);
        columnModel.getColumn(10).setCellRenderer(center);    
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(1).setPreferredWidth(23);
        columnModel.getColumn(2).setResizable(false);
        columnModel.getColumn(2).setPreferredWidth(17);
        columnModel.getColumn(3).setResizable(false);
        columnModel.getColumn(3).setPreferredWidth(25);
        columnModel.getColumn(4).setResizable(false);
        columnModel.getColumn(4).setPreferredWidth(40);
        columnModel.getColumn(5).setResizable(false);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setResizable(false);
        columnModel.getColumn(6).setPreferredWidth(90);
        columnModel.getColumn(7).setResizable(false);
        columnModel.getColumn(7).setPreferredWidth(225);
        columnModel.getColumn(8).setResizable(false);
        columnModel.getColumn(8).setPreferredWidth(35);
        columnModel.getColumn(9).setResizable(false);
        columnModel.getColumn(9).setPreferredWidth(35);
        columnModel.getColumn(10).setResizable(false);
        columnModel.getColumn(10).setPreferredWidth(5);
        tableCheck.setRowSorter(null);
    }
    
    public void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
            return;
        }
        JViewport viewPort = (JViewport)table.getParent();
        Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);
        Point pt = viewPort.getViewPosition();
        // Translate the cell location so that it is relative
        // to the view, assuming the northwest corner of the
        // view is (0,0)
        rect.setLocation(rect.x-pt.x, rect.y-pt.y);
        viewPort.scrollRectToVisible(rect);
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Table Row Sorter">
    private void setupRowSorter() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableCheck.getModel());
        List <RowSorter.SortKey> sortKey = new ArrayList<>();
        sortKey.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKey);
        Compare.StringDate dateCompare = new Compare.StringDate();
        Compare.StringDecimal decimalCompare = new Compare.StringDecimal();
        sorter.setComparator( 4, decimalCompare);
        sorter.setComparator( 5, decimalCompare);
        sorter.setComparator( 8, dateCompare);
        sorter.setComparator( 9, dateCompare);
        sorter.setComparator(10, decimalCompare);
        tableCheck.setRowSorter(sorter);
    }// </editor-fold>
    
    public RecordCheck getRecordCheck() {
        return record;
    }

    public RecordTableModel getModel() {
        return model;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }

    public ArrayList<String> getRegistryList() {
        return registryList;
    }
}
