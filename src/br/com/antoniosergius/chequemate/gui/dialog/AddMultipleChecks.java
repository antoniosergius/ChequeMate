package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.gui.RegisterCheckFrame;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.MultipleCheck;
import br.com.antoniosergius.chequemate.obj.Parameters;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.verif.IntegerVerifier;
import br.com.antoniosergius.lib.verif.MoneyVerifier;
import br.com.antoniosergius.lib.verif.RegistryNumberVerifier;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class AddMultipleChecks extends javax.swing.JDialog {
    private static final Logger LOG = Logger.getLogger(AddMultipleChecks.class.getName());

    private RegisterCheckFrame parent;
    private PayeeController payeeControl;
    
    public AddMultipleChecks(java.awt.Frame parent, boolean modal, PayeeController payeeControl) {
        super(parent, modal);
        this.parent = (RegisterCheckFrame) parent;
        this.payeeControl = payeeControl;
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new org.jdesktop.swingx.JXHeader();
        panelForm = new org.jdesktop.swingx.JXPanel();
        labelNumeroPrimeiro = new org.jdesktop.swingx.JXLabel();
        labelValor = new org.jdesktop.swingx.JXLabel();
        labelDataInicial = new org.jdesktop.swingx.JXLabel();
        labelTipoPeriodo = new org.jdesktop.swingx.JXLabel();
        labelQuantidade = new org.jdesktop.swingx.JXLabel();
        textFieldCount = new org.jdesktop.swingx.JXTextField();
        textFieldFirstNumber = new org.jdesktop.swingx.JXTextField();
        textFieldValue = new org.jdesktop.swingx.JXTextField();
        datePickerBegin = new org.jdesktop.swingx.JXDatePicker();
        comboBoxPeriodType = new javax.swing.JComboBox();
        labelCPF = new org.jdesktop.swingx.JXLabel();
        textFieldRegistry = new org.jdesktop.swingx.JXTextField();
        labelEmitente = new org.jdesktop.swingx.JXLabel();
        textFieldPayee = new org.jdesktop.swingx.JXTextField();
        labelNotaPromissoria = new org.jdesktop.swingx.JXLabel();
        checkBoxPromissoryNote = new javax.swing.JCheckBox();
        labelBanco = new org.jdesktop.swingx.JXLabel();
        labelAgencia = new org.jdesktop.swingx.JXLabel();
        textFieldBank = new org.jdesktop.swingx.JXTextField();
        textFieldAgency = new org.jdesktop.swingx.JXTextField();
        panelButtons = new org.jdesktop.swingx.JXPanel();
        buttonApply = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setTitle("Adicionar Multiplos Cheques");
        header.setToolTipText("");

        labelNumeroPrimeiro.setText("Número do Primeiro: ");

        labelValor.setText("Valor de Cada Cheque:");

        labelDataInicial.setText("Data Inicial:");

        labelTipoPeriodo.setText("Tipo de Período:");

        labelQuantidade.setText("Quantidade:");

        comboBoxPeriodType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mensal" }));
        comboBoxPeriodType.setSelectedItem("Mensal");

        labelCPF.setText("CPF/CNPJ:");

        textFieldRegistry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldRegistryFocusLost(evt);
            }
        });

        labelEmitente.setText("Emitente:");

        labelNotaPromissoria.setText("É Nota Promissória?");

        labelBanco.setText("Banco:");

        labelAgencia.setText("Agência:");

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNumeroPrimeiro, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(labelBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelValor, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(labelDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTipoPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmitente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNotaPromissoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPromissoryNote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldPayee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldRegistry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxPeriodType, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datePickerBegin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(textFieldValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldAgency, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldBank, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldFirstNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelCPF, labelDataInicial, labelEmitente, labelNotaPromissoria, labelNumeroPrimeiro, labelQuantidade, labelTipoPeriodo, labelValor});

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {checkBoxPromissoryNote, comboBoxPeriodType, datePickerBegin, textFieldAgency, textFieldBank, textFieldCount, textFieldFirstNumber, textFieldPayee, textFieldRegistry, textFieldValue});

        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldCount, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(labelQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumeroPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldFirstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldAgency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPeriodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldRegistry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPayee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNotaPromissoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPromissoryNote))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {checkBoxPromissoryNote, comboBoxPeriodType, datePickerBegin, labelAgencia, labelBanco, labelCPF, labelDataInicial, labelEmitente, labelNotaPromissoria, labelNumeroPrimeiro, labelQuantidade, labelTipoPeriodo, labelValor, textFieldAgency, textFieldBank, textFieldCount, textFieldFirstNumber, textFieldPayee, textFieldRegistry, textFieldValue});

        buttonApply.setText("Aplicar");
        buttonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancelar");

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonApply)
                .addContainerGap())
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonApply, buttonCancel});

        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonApply)
                    .addComponent(buttonCancel))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonApply, buttonCancel});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        try {
            addToTable();
        } catch (ChequeMateException ex) {
            LOG.log(Level.SEVERE, null, ex);
            ex.showExceptionMessage();
        }
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void textFieldRegistryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldRegistryFocusLost
        String registryNumber = textFieldRegistry.getText();
        if (registryNumber.isEmpty()) {
            return;
        }
        String unformattedRegistry = Deformat.CPForCNPJ(registryNumber);
        String payee = null;
        try {
            payee = payeeControl.getName(unformattedRegistry);
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
        }
        if (payee != null) {
            if (!textFieldPayee.getText().isEmpty()) { // estiver preenchido
                if (!payee.equals(textFieldPayee.getText())) {
                    textFieldPayee.setText(payee);
                }
            } else { // estiver vazio
                textFieldPayee.setText(payee);
            }
        }
    }//GEN-LAST:event_textFieldRegistryFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JCheckBox checkBoxPromissoryNote;
    private javax.swing.JComboBox comboBoxPeriodType;
    private org.jdesktop.swingx.JXDatePicker datePickerBegin;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXLabel labelAgencia;
    private org.jdesktop.swingx.JXLabel labelBanco;
    private org.jdesktop.swingx.JXLabel labelCPF;
    private org.jdesktop.swingx.JXLabel labelDataInicial;
    private org.jdesktop.swingx.JXLabel labelEmitente;
    private org.jdesktop.swingx.JXLabel labelNotaPromissoria;
    private org.jdesktop.swingx.JXLabel labelNumeroPrimeiro;
    private org.jdesktop.swingx.JXLabel labelQuantidade;
    private org.jdesktop.swingx.JXLabel labelTipoPeriodo;
    private org.jdesktop.swingx.JXLabel labelValor;
    private org.jdesktop.swingx.JXPanel panelButtons;
    private org.jdesktop.swingx.JXPanel panelForm;
    private org.jdesktop.swingx.JXTextField textFieldAgency;
    private org.jdesktop.swingx.JXTextField textFieldBank;
    private org.jdesktop.swingx.JXTextField textFieldCount;
    private org.jdesktop.swingx.JXTextField textFieldFirstNumber;
    private org.jdesktop.swingx.JXTextField textFieldPayee;
    private org.jdesktop.swingx.JXTextField textFieldRegistry;
    private org.jdesktop.swingx.JXTextField textFieldValue;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setTitle("Adição Múltipla");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.add.png")).getImage());
        
        Verifier.set(textFieldCount, new IntegerVerifier(2));
        Verifier.set(textFieldFirstNumber, new IntegerVerifier(6));
        Verifier.set(textFieldAgency, new IntegerVerifier(4));
        Verifier.set(textFieldBank, new IntegerVerifier(3));
        Verifier.set(textFieldValue, new MoneyVerifier());
        Verifier.set(textFieldPayee, new TextVerifier());
        Verifier.set(textFieldRegistry, new RegistryNumberVerifier(true, true));
        
        datePickerBegin.setEditable(false);
        datePickerBegin.getMonthView().setEnabled(true);
        
        setupFocusComponents();
        AutoCompleteDecorator.decorate(textFieldRegistry, parent.getRegistryList(), false); 
    }

    private void setupFocusComponents() {
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldCount);
        list.add(textFieldFirstNumber);
        list.add(textFieldBank);
        list.add(textFieldAgency);
        list.add(textFieldValue);
        list.add(datePickerBegin);
        list.add(comboBoxPeriodType);
        list.add(textFieldRegistry);
        list.add(textFieldPayee);
        list.add(checkBoxPromissoryNote);
        list.add(buttonApply);
        setFocusTraversalPolicy(new FocusPolicy(list));
        FocusPolicy.setDefaultTrasversalKeys(panelForm, FocusPolicy.BOTH_DIRECTIONS);
    }
    
    private void addToTable() throws ChequeMateException {
        MultipleCheck multipleCheck = getObjectFromForm();
        int count = multipleCheck.getCount();
        GregorianCalendar expiration = multipleCheck.getExpiration();
        GregorianCalendar newExpiration;
        if (multipleCheck.isPromissoryNote()) {
            String strCount = String.valueOf(count);
            int aux = (int)Math.pow(10, strCount.length());
            for (int i=1; i<=count; i++) {
                newExpiration = new GregorianCalendar();
                newExpiration.setTime(expiration.getTime());
                newExpiration.add(GregorianCalendar.MONTH, i-1);
                Date calcDate = ChequeMate.getHolidayControl().nextBusinessDate(
                        newExpiration.getTime(), Parameters.WITH_MIN_DAYS);
                GregorianCalendar gCalcDate = new GregorianCalendar();
                gCalcDate.setTime(calcDate);
                int daysBetween = Days.between(Days.TODAY, gCalcDate);
                BigDecimal rate = new BigDecimal(ChequeMate.getPreferences().getDefaultRate());
                BigDecimal gross = new BigDecimal(multipleCheck.getGross());
                BigDecimal net = ChequeMate.calculateInterest(gross, daysBetween, rate);
                
                Check check = new Check(aux*i+multipleCheck.getCount(),
                        multipleCheck.getBank(), multipleCheck.getAgency(), 
                        gross.doubleValue(), net.doubleValue(), rate.doubleValue(),
                        multipleCheck.getPayee(), newExpiration, gCalcDate);
                parent.addTableCheck(check);
            }
        } else {
            for (int i=0; i<count; i++) {
                newExpiration = new GregorianCalendar();
                newExpiration.setTime(expiration.getTime());
                newExpiration.add(GregorianCalendar.MONTH, i);
                Date calcDate = ChequeMate.getHolidayControl().nextBusinessDate(
                        newExpiration.getTime(), Parameters.WITH_MIN_DAYS);
                GregorianCalendar gCalcDate = new GregorianCalendar();
                gCalcDate.setTime(calcDate);
                int daysBetween = Days.between(Days.TODAY, gCalcDate);
                BigDecimal rate = new BigDecimal(ChequeMate.getPreferences().getDefaultRate());
                BigDecimal gross = new BigDecimal(multipleCheck.getGross());
                BigDecimal net = ChequeMate.calculateInterest(gross, daysBetween, rate);
                
                Check check = new Check(multipleCheck.getNumber()+i, 
                        multipleCheck.getBank(), multipleCheck.getAgency(), 
                        gross.doubleValue(), net.doubleValue(), rate.doubleValue(),
                        multipleCheck.getPayee(), newExpiration, gCalcDate);
                parent.addTableCheck(check);
            }
        }
        dispose();
    }

    private MultipleCheck getObjectFromForm() throws ChequeMateException{
        String strCount = textFieldCount.getText();
        String strNumber = textFieldFirstNumber.getText();
        String strBank = textFieldBank.getText();
        String strAgency = textFieldAgency.getText();
        String registryNumber = textFieldRegistry.getText();
        if (strCount.isEmpty()) {
            throw new ChequeMateException("Favor preencher a quantidade de cheques.", textFieldCount);
        }
        int count = Integer.parseInt(strCount);
        if (strNumber.isEmpty()) {
            throw new ChequeMateException("Favor preencher o primeiro número do cheque.", textFieldRegistry);
        }
        if (!registryNumber.isEmpty()) {
            registryNumber = Deformat.CPForCNPJ(registryNumber);
        }
        if (strNumber.isEmpty()) {
            throw new ChequeMateException("Favor preencher o primeiro número do cheque.", textFieldRegistry);
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
        String strGross = textFieldValue.getText();
        if (strGross.isEmpty()) {
            throw new ChequeMateException("Digite o valor dos cheques.", textFieldValue);
        }
        String payeeName = textFieldPayee.getText();
        if (payeeName.isEmpty()) {
            throw new ChequeMateException("Digite o emitente do cheque.", textFieldPayee);
        }
        GregorianCalendar expiration = new GregorianCalendar();
        Date firstExpirationDate = datePickerBegin.getDate();
        boolean isValidDate = false;
        if (firstExpirationDate != null) {
            if (firstExpirationDate.after(Days.TODAY.getTime())) {
                expiration.setTime(firstExpirationDate);
                isValidDate = true;
            }
        }
        if (!isValidDate) {
            throw new ChequeMateException("Data inicial inválida.");
        }
        boolean isPromissoryNote = checkBoxPromissoryNote.isSelected();
        String periodType = "";
        if (comboBoxPeriodType.getSelectedIndex()==-1) {
            throw new ChequeMateException("Favor preencher o tipo de período.");
        } else {
            periodType = (String) comboBoxPeriodType.getSelectedItem();
            periodType = periodType.toUpperCase();
        }
        payeeName = payeeName.trim().toUpperCase();
        
        return new MultipleCheck(count, periodType, isPromissoryNote,
                number, bank, agency, Deformat.andConvertDecimal(strGross),
                new Payee(payeeName, registryNumber), expiration);
    }

}
