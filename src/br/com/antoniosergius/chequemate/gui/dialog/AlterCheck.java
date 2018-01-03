package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.CheckController;
import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.gui.QueryCheckFrame;
import br.com.antoniosergius.chequemate.gui.panel.DatePickerPanel;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.obj.Parameters;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.verif.IntegerVerifier;
import br.com.antoniosergius.lib.verif.MoneyVerifier;
import br.com.antoniosergius.lib.verif.PercentVerifier;
import br.com.antoniosergius.lib.verif.RegistryNumberVerifier;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class AlterCheck extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(AlterCheck.class.getName());
    
    private Check check;
    private Check newCheck;
    private int indexClient;
    private final Connection conn;
    private final QueryCheckFrame queryFrame;
    private final CheckController checkControl;
    private final ComboBoxModel<String> boxModel;
    private final int modelIndex;
    
    public AlterCheck(java.awt.Frame parent, boolean modal, Check check, Connection conn, ComboBoxModel<String> boxModel, int modelIndex) {
        super(parent, modal);
        this.check = check;
        this.newCheck = null;
        this.conn = conn;
        this.checkControl = new CheckController(conn);
        this.queryFrame = (QueryCheckFrame)parent;
        this.boxModel = boxModel;
        this.modelIndex = modelIndex;
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSave = new javax.swing.JButton();
        buttonRevert = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        panelForm = new javax.swing.JPanel();
        labelNumber = new javax.swing.JLabel();
        labelBank = new javax.swing.JLabel();
        labelAgency = new javax.swing.JLabel();
        labelGross = new javax.swing.JLabel();
        labelRegistryNumber = new javax.swing.JLabel();
        labelPayee = new javax.swing.JLabel();
        textFieldPayee = new javax.swing.JTextField();
        labelExpiration = new javax.swing.JLabel();
        labelInputDate = new javax.swing.JLabel();
        formattedTextFieldInputDate = new javax.swing.JFormattedTextField();
        comboBox = new javax.swing.JComboBox();
        labelClient = new javax.swing.JLabel();
        buttonDetails = new javax.swing.JButton();
        textFieldNumber = new javax.swing.JTextField();
        textFieldBank = new javax.swing.JTextField();
        textFieldAgency = new javax.swing.JTextField();
        textFieldGross = new javax.swing.JTextField();
        textFieldRegistryNumber = new javax.swing.JTextField();
        datePickerExpiration = new org.jdesktop.swingx.JXDatePicker();
        labelCalcDate = new org.jdesktop.swingx.JXLabel();
        textFieldCalcDate = new javax.swing.JTextField();
        labelNet = new org.jdesktop.swingx.JXLabel();
        textFieldNet = new javax.swing.JTextField();
        labelRate = new org.jdesktop.swingx.JXLabel();
        textFieldRate = new javax.swing.JTextField();
        labelObs = new javax.swing.JLabel();
        textFieldObs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        buttonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.save.png"))); // NOI18N
        buttonSave.setText("Salvar");
        buttonSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonRevert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.revert.png"))); // NOI18N
        buttonRevert.setText("Reverter");
        buttonRevert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRevert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRevert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRevertActionPerformed(evt);
            }
        });

        buttonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.cancel.png"))); // NOI18N
        buttonCancel.setText("Cancelar");
        buttonCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.delete.png"))); // NOI18N
        buttonDelete.setText("Excluir");
        buttonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        panelForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cheque Selecionado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.gray));

        labelNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNumber.setText("Número:");
        labelNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelBank.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBank.setText("Banco:");
        labelBank.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelAgency.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAgency.setText("Agência:");
        labelAgency.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelGross.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGross.setText("Bruto R$:");
        labelGross.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelRegistryNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRegistryNumber.setText("CPF/CNPJ:");
        labelRegistryNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelPayee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPayee.setText("Emitente:");
        labelPayee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        textFieldPayee.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textFieldPayee.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        labelExpiration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelExpiration.setText("Data Boa:");
        labelExpiration.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelInputDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelInputDate.setText("Entrada:");
        labelInputDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        formattedTextFieldInputDate.setEditable(false);
        formattedTextFieldInputDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        formattedTextFieldInputDate.setEnabled(false);

        comboBox.setEditable(true);

        labelClient.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelClient.setText("Cliente:");
        labelClient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        buttonDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.open.png"))); // NOI18N
        buttonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetailsActionPerformed(evt);
            }
        });

        textFieldGross.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldGrossFocusLost(evt);
            }
        });

        datePickerExpiration.setFormats(new String[]{"EEEEE, dd/MM/yy"});
        datePickerExpiration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerExpirationActionPerformed(evt);
            }
        });

        labelCalcDate.setText("Data Cálc.:");

        textFieldCalcDate.setEditable(false);
        textFieldCalcDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textFieldCalcDate.setEnabled(false);

        labelNet.setText("Líquido R$:");

        textFieldNet.setEditable(false);
        textFieldNet.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textFieldNet.setEnabled(false);

        labelRate.setText("Taxa:");

        textFieldRate.setEditable(false);
        textFieldRate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textFieldRate.setEnabled(false);

        labelObs.setText("Obs:");

        org.jdesktop.layout.GroupLayout panelFormLayout = new org.jdesktop.layout.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelFormLayout.createSequentialGroup()
                        .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(labelNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(labelBank, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelAgency, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelRegistryNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(labelPayee, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelGross, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(labelNet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(labelRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(labelExpiration)
                            .add(labelCalcDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(labelInputDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(labelClient, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 0, Short.MAX_VALUE)
                        .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(textFieldNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textFieldBank, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textFieldAgency, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textFieldRegistryNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textFieldPayee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textFieldGross, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textFieldNet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textFieldRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(datePickerExpiration, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textFieldCalcDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(formattedTextFieldInputDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(comboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 287, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(panelFormLayout.createSequentialGroup()
                        .add(labelObs)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(textFieldObs)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(buttonDetails, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10))
        );

        panelFormLayout.linkSize(new java.awt.Component[] {labelAgency, labelBank, labelCalcDate, labelClient, labelExpiration, labelGross, labelInputDate, labelNet, labelNumber, labelObs, labelPayee, labelRate, labelRegistryNumber}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        panelFormLayout.linkSize(new java.awt.Component[] {comboBox, datePickerExpiration, formattedTextFieldInputDate, textFieldAgency, textFieldBank, textFieldCalcDate, textFieldGross, textFieldNet, textFieldNumber, textFieldPayee, textFieldRate, textFieldRegistryNumber}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(textFieldNumber)
                    .add(labelNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(textFieldBank)
                    .add(labelBank, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelAgency, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(textFieldAgency, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(textFieldRegistryNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelRegistryNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textFieldPayee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelPayee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(textFieldGross)
                    .add(labelGross, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelNet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(textFieldNet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(textFieldRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelExpiration, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(datePickerExpiration, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelCalcDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(textFieldCalcDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelInputDate)
                    .add(formattedTextFieldInputDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(labelClient)
                        .add(comboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(buttonDetails))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelObs)
                    .add(textFieldObs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelFormLayout.linkSize(new java.awt.Component[] {buttonDetails, comboBox}, org.jdesktop.layout.GroupLayout.VERTICAL);

        panelFormLayout.linkSize(new java.awt.Component[] {labelCalcDate, labelExpiration, labelPayee, labelRegistryNumber}, org.jdesktop.layout.GroupLayout.VERTICAL);

        panelFormLayout.linkSize(new java.awt.Component[] {datePickerExpiration, formattedTextFieldInputDate, textFieldAgency, textFieldBank, textFieldCalcDate, textFieldGross, textFieldNet, textFieldNumber, textFieldPayee, textFieldRate, textFieldRegistryNumber}, org.jdesktop.layout.GroupLayout.VERTICAL);

        panelFormLayout.linkSize(new java.awt.Component[] {labelClient, labelGross, labelInputDate, labelNet, labelObs, labelRate}, org.jdesktop.layout.GroupLayout.VERTICAL);

        panelFormLayout.linkSize(new java.awt.Component[] {labelAgency, labelBank, labelNumber}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelForm, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(buttonSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonRevert, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {buttonCancel, buttonDelete, buttonRevert, buttonSave}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(panelForm, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, buttonDelete, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, buttonRevert, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, buttonSave, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, buttonCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {buttonCancel, buttonDelete, buttonRevert, buttonSave}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (apply()) {
                    dispose();
                }
            }
        });   
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonRevertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRevertActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (!check.equals(newCheck)) {
                    revert();
                }    
            }
        });
    }//GEN-LAST:event_buttonRevertActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                delete();    
            }
        });
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetailsActionPerformed
        Client client;
        try {
            client = new ClientController(conn).get(check.getIdClient());
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return;
        }
        new ViewClient(queryFrame, null, true, conn, client).setVisible(true);
    }//GEN-LAST:event_buttonDetailsActionPerformed

    private void datePickerExpirationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerExpirationActionPerformed
        Date date = datePickerExpiration.getDate();
        if (date != null) {
            try {
                date = ChequeMate.getHolidayControl().nextBusinessDate(date, Parameters.WITHOUT_MIN_DAYS);
                textFieldCalcDate.setText(Format.date(date));
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }//GEN-LAST:event_datePickerExpirationActionPerformed

    private void textFieldGrossFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldGrossFocusLost
        String strGross = textFieldGross.getText();
        double gross = Deformat.andConvertDecimal(strGross);
        BigDecimal rate = new BigDecimal(Deformat.decimal(textFieldRate.getText()));
        GregorianCalendar calcDateGreg = Convert.toGregorian(textFieldCalcDate.getText());
        if (gross != check.getGross()) {
            int days = Days.between(check.getInputDate(), calcDateGreg);
            double net = ChequeMate.calculateInterest(new BigDecimal(gross), days, rate).doubleValue();
            textFieldNet.setText(Format.decimal(net));
        }
    }//GEN-LAST:event_textFieldGrossFocusLost

    // <editor-fold defaultstate="collapsed" desc="Variables GUI">
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonDetails;
    private javax.swing.JButton buttonRevert;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox comboBox;
    private org.jdesktop.swingx.JXDatePicker datePickerExpiration;
    private javax.swing.JFormattedTextField formattedTextFieldInputDate;
    private javax.swing.JLabel labelAgency;
    private javax.swing.JLabel labelBank;
    private org.jdesktop.swingx.JXLabel labelCalcDate;
    private javax.swing.JLabel labelClient;
    private javax.swing.JLabel labelExpiration;
    private javax.swing.JLabel labelGross;
    private javax.swing.JLabel labelInputDate;
    private org.jdesktop.swingx.JXLabel labelNet;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelPayee;
    private org.jdesktop.swingx.JXLabel labelRate;
    private javax.swing.JLabel labelRegistryNumber;
    private javax.swing.JPanel panelForm;
    private javax.swing.JTextField textFieldAgency;
    private javax.swing.JTextField textFieldBank;
    private javax.swing.JTextField textFieldCalcDate;
    private javax.swing.JTextField textFieldGross;
    private javax.swing.JTextField textFieldNet;
    private javax.swing.JTextField textFieldNumber;
    private javax.swing.JTextField textFieldObs;
    private javax.swing.JTextField textFieldPayee;
    private javax.swing.JTextField textFieldRate;
    private javax.swing.JTextField textFieldRegistryNumber;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
    public Check getCheckFromForm() throws ChequeMateException{
        String registryNumber = Deformat.CPForCNPJ(textFieldRegistryNumber.getText());
        String strGross = textFieldGross.getText();
        double gross = Deformat.andConvertDecimal(strGross);
        
        String strNumber = textFieldNumber.getText();
        String strBank = textFieldBank.getText();
        String strAgency = textFieldAgency.getText();
        
        int number = strNumber.equals("") ? 0 : Integer.parseInt(strNumber);
        int bank = strBank.equals("") ? 0 : Integer.parseInt(strBank);
        int agency = strAgency.equals("") ? 0 : Integer.parseInt(strAgency);
        Date date = datePickerExpiration.getDate();
        
        if (date==null) {
            date = new Date();
        }
        GregorianCalendar expiration = new GregorianCalendar();
        expiration.setTime(date);
        
        Date calcDate = ChequeMate.getHolidayControl().nextBusinessDate(date, Parameters.WITHOUT_MIN_DAYS);
        GregorianCalendar calcDateGreg = new GregorianCalendar();
        calcDateGreg.setTime(calcDate);
        
        BigDecimal rate = new BigDecimal(Deformat.decimal(textFieldRate.getText()));
                
        double net = check.getNet();
        if (gross != check.getGross()) {
            int days = Days.between(check.getInputDate(), calcDateGreg);
            net = ChequeMate.calculateInterest(new BigDecimal(gross), days, rate).doubleValue();
        }
        
        String payeeName = textFieldPayee.getText().toUpperCase();
        String item = (String)comboBox.getSelectedItem();
        String obs = textFieldObs.getText();
        
        Client client = Client.getFromString(item, Client.ID_SUFFIX);
        Check newOne = new Check(check.getId(), number, bank, agency, gross, net, rate.doubleValue(), new Payee(payeeName, registryNumber), 
                expiration, calcDateGreg, check.getInputDate(),  client.getId(), client.getName());
        newOne.setObs(obs);
        return newOne;
    }
    
    private int updateCheck() throws SQLException {
        int choice = JOptionPane.showConfirmDialog(this, "Deseja salvar as alterações feitas?", "Salvar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if (choice == JOptionPane.YES_OPTION) {
            checkControl.update(newCheck);
            queryFrame.updateFromModel(newCheck, modelIndex);
        }
        return choice;
    }
    
    private boolean validateData() {
        try {
            newCheck = getCheckFromForm();
            return true;
        } catch (ChequeMateException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
            ex.showExceptionMessage();
            return false;
        } 
    }
    
    private boolean apply() {
        boolean isValid = validateData();
        if (isValid) {
            try {
                if (updateCheck() == JOptionPane.YES_OPTION) {
                    ChequeMate.showSuccessMessage(this, "Cheque alterado com sucesso.");
                    check = newCheck;
                    return true;
                } else {
                    textFieldNumber.requestFocusInWindow();
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            } 
        } 
        return false;
    }
    
    private void revert() {
        int choice = JOptionPane.showConfirmDialog(this, "Deseja desfazer todas as alterações?", 
            "Reverter", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice==JOptionPane.YES_OPTION) {
            setupForm();
            newCheck = null;
            textFieldNumber.requestFocusInWindow();
        }
    }
    
    private void delete() {
        int choice = JOptionPane.showConfirmDialog(this, 
                "Realmente deseja apagar o registro? Este processo é irreversível.", 
                "Excluir Registro",
               JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (choice == JOptionPane.YES_OPTION){
            try {
                checkControl.delete(check.getId());
                new PayeeController(conn).decrementCounter(check.getPayee().getRegistryNumber());
                queryFrame.deleteFromModel(modelIndex);
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Setup Components">
    private void setupComponents() {
        setLocationRelativeTo(null);
        setTitle("Cheque nº "+Format.checkNumber(check.getNumber())+" - Alteração");
        
        setupFocusComponents();
        
        Verifier.set(textFieldGross, new MoneyVerifier());
        Verifier.set(textFieldRegistryNumber, new RegistryNumberVerifier(true, true));
        Verifier.set(textFieldBank, new IntegerVerifier(3));
        Verifier.set(textFieldNumber, new IntegerVerifier(6));
        Verifier.set(textFieldAgency, new IntegerVerifier(4));
        Verifier.set(textFieldPayee, new TextVerifier());
        Verifier.set(textFieldRate, new PercentVerifier());
        Verifier.set(textFieldNet, new MoneyVerifier());
        Verifier.set(textFieldObs, new TextVerifier());
        
        datePickerExpiration.setEditable(false);
        JXMonthView monthView = datePickerExpiration.getMonthView();
        GregorianCalendar date = new GregorianCalendar();
        int checkDeletion = ChequeMate.getParameters().getMinExpirationDays();
        date.roll(GregorianCalendar.DAY_OF_YEAR, -checkDeletion);
        GregorianCalendar expiration = new GregorianCalendar();
        expiration.set(GregorianCalendar.DAY_OF_MONTH, checkDeletion+1);
        if (Days.TODAY.before(expiration))
           date.add(GregorianCalendar.YEAR, -1);
        monthView.setLowerBound(date.getTime());
        monthView.setEnabled(true);
        monthView.setFlaggedDates(ChequeMate.getHolidayControl().getArrayDate());
        monthView.setFlaggedDayForeground(Color.red);
        
        datePickerExpiration.getEditor().setHorizontalAlignment(JTextField.LEFT);
        datePickerExpiration.setEditable(false);
        
        DatePickerPanel pickerPanel = new DatePickerPanel(datePickerExpiration, this);
        datePickerExpiration.setLinkPanel(pickerPanel);
        
        setupComboBox();
        AutoCompleteDecorator.decorate(comboBox);
        setupForm();
    }
    
    private void setupForm() {
        textFieldCalcDate.setText(Format.date(check.getCalcDate()));
        textFieldRate.setText(Format.decimal(check.getRate()));
        textFieldNet.setText(Format.decimal(check.getNet()));
        textFieldAgency.setText(String.valueOf(check.getAgency()));
        textFieldBank.setText(String.valueOf(check.getBank()));
        textFieldNumber.setText(String.valueOf(check.getNumber()));
        textFieldGross.setText(String.valueOf(check.getGross()));
        textFieldRegistryNumber.setText(check.getPayee().getRegistryNumber());
        textFieldPayee.setText(check.getPayee().getName());
        
        textFieldObs.setText(check.getObs());
        
        formattedTextFieldInputDate.setText(Format.timestamp(check.getInputDate()));
        datePickerExpiration.setDate(check.getExpiration().getTime());
        comboBox.setSelectedIndex(indexClient);
        textFieldNet.postActionEvent();
        textFieldRate.postActionEvent();
        textFieldNumber.postActionEvent();
        textFieldBank.postActionEvent();
        textFieldAgency.postActionEvent();
        textFieldRegistryNumber.postActionEvent();
        textFieldPayee.postActionEvent();
        textFieldGross.postActionEvent();
        
        textFieldObs.postActionEvent();
    }
    
    @SuppressWarnings("unchecked")
    private void setupComboBox() {
        comboBox.removeAllItems();
        String idClient = Format.clientId(check.getIdClient());
        indexClient = 0;
        int size = boxModel.getSize();
        for(int i=0; i<size; i++) {
            String str = boxModel.getElementAt(i);
            comboBox.addItem(str);
            if (str.contains(idClient)){
                indexClient = i;
            }
        }
    }
    
    private void setupFocusComponents() {
        FocusPolicy.setDefaultTrasversalKeys(panelForm, FocusPolicy.BOTH_DIRECTIONS);
        FocusPolicy.setDefaultTrasversalKeys(comboBox, FocusPolicy.FORWARD);
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldNumber);
        list.add(textFieldBank);
        list.add(textFieldAgency);
        list.add(textFieldRegistryNumber);
        list.add(textFieldPayee);
        list.add(textFieldGross);
        list.add(comboBox);
        list.add(textFieldObs);
        setFocusTraversalPolicy(new FocusPolicy(list));
    }
    // </editor-fold>
    
}
