package br.com.antoniosergius.chequemate.gui.dialog;


import br.com.antoniosergius.chequemate.gui.RegisterCheckFrame;
import br.com.antoniosergius.chequemate.gui.panel.DatePickerPanel;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Parameters;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
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
import java.awt.Frame;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXMonthView;

public class AlterRecordCheck extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(AlterRecordCheck.class.getName());
    
    private final int row;
    private Check check;
    private Check newCheck;
    private final RegisterCheckFrame recordFrame;
    private final GregorianCalendar baseDate = new GregorianCalendar();
    private final ChequeMateException exception = new ChequeMateException();
    
    public AlterRecordCheck(Frame parent, boolean modal, Check check, Date base, int row) {
        super(parent, modal);
        initComponents();
        this.check = check;
        this.row = row;
        recordFrame = (RegisterCheckFrame)parent;
        baseDate.setTime(base);
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        panelButtons = new org.jdesktop.swingx.JXPanel();
        buttonApply = new javax.swing.JButton();
        buttonRevert = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        panelForm = new org.jdesktop.swingx.JXPanel();
        labelNumber = new javax.swing.JLabel();
        labelBank = new javax.swing.JLabel();
        labelAgency = new javax.swing.JLabel();
        labelGross = new javax.swing.JLabel();
        labelRegistryNumber = new javax.swing.JLabel();
        labelPayee = new javax.swing.JLabel();
        textFieldPayee = new javax.swing.JTextField();
        labelExpiration = new javax.swing.JLabel();
        textFieldNumber = new javax.swing.JTextField();
        textFieldBank = new javax.swing.JTextField();
        textFieldAgency = new javax.swing.JTextField();
        textFieldGross = new javax.swing.JTextField();
        textFieldRegistryNumber = new javax.swing.JTextField();
        datePickerExpiration = new org.jdesktop.swingx.JXDatePicker();
        labelCalcDate = new org.jdesktop.swingx.JXLabel();
        labelTaxa = new org.jdesktop.swingx.JXLabel();
        textFieldRate = new javax.swing.JTextField();
        labelPercent = new javax.swing.JLabel();
        datePickerCalcDate = new org.jdesktop.swingx.JXDatePicker();
        labelObs = new javax.swing.JLabel();
        textFieldObs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        buttonApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.valid.png"))); // NOI18N
        buttonApply.setText("Aplicar");
        buttonApply.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonApply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyActionPerformed(evt);
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

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRevert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCancel)
                .addContainerGap())
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonApply, buttonCancel, buttonDelete, buttonRevert});

        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRevert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonApply, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonApply, buttonCancel, buttonDelete, buttonRevert});

        panelForm.setBorder(javax.swing.BorderFactory.createTitledBorder("Linha da Tabela"));

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
        labelGross.setText("Valor (R$):");
        labelGross.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelRegistryNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRegistryNumber.setText("CPF/CNPJ:");
        labelRegistryNumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelPayee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPayee.setText("Emitente:");
        labelPayee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        textFieldPayee.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        textFieldPayee.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textFieldPayee.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        labelExpiration.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelExpiration.setText("Data Boa:");
        labelExpiration.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        datePickerExpiration.setFormats(new String[]{"EEEEE, dd/MM/yyyy"});
        datePickerExpiration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerExpirationActionPerformed(evt);
            }
        });

        labelCalcDate.setText("Data Cálc.:");

        labelTaxa.setText("Taxa: ");

        labelPercent.setText("%");

        datePickerCalcDate.setFormats(new String[]{"EEEEE dd/MM/yyyy"});

        labelObs.setText("Obs:");

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBank)
                            .addComponent(labelAgency)
                            .addComponent(labelGross)
                            .addComponent(labelRegistryNumber)
                            .addComponent(labelPayee)
                            .addComponent(labelTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCalcDate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldRegistryNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPayee, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldGross, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldAgency, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePickerExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datePickerCalcDate, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(labelObs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldObs)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelAgency, labelBank, labelCalcDate, labelExpiration, labelGross, labelNumber, labelObs, labelPayee, labelRegistryNumber, labelTaxa});

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {datePickerCalcDate, datePickerExpiration, textFieldAgency, textFieldBank, textFieldGross, textFieldNumber, textFieldObs, textFieldPayee, textFieldRate, textFieldRegistryNumber});

        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldNumber)
                    .addComponent(labelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldBank)
                    .addComponent(labelBank, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldAgency)
                    .addComponent(labelAgency, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldGross)
                    .addComponent(labelGross, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldRegistryNumber)
                    .addComponent(labelRegistryNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldPayee)
                    .addComponent(labelPayee, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTaxa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPercent)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerExpiration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCalcDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerCalcDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelObs)
                    .addComponent(textFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelAgency, labelBank, labelGross, labelNumber, labelPayee, labelRegistryNumber, labelTaxa, textFieldAgency, textFieldBank, textFieldGross, textFieldNumber, textFieldObs, textFieldPayee, textFieldRate, textFieldRegistryNumber});

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {datePickerCalcDate, datePickerExpiration, labelCalcDate, labelExpiration, labelObs});

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datePickerExpirationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerExpirationActionPerformed
        Date date = datePickerExpiration.getDate();
        if (date!=null) {
            date = ChequeMate.getHolidayControl().nextBusinessDate(date, Parameters.WITH_MIN_DAYS);
            datePickerCalcDate.setDate(date);
        }    
    }//GEN-LAST:event_datePickerExpirationActionPerformed

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        if (apply()) {
            dispose();
        }
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonRevertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRevertActionPerformed
        revert();
    }//GEN-LAST:event_buttonRevertActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        delete();
    }//GEN-LAST:event_buttonDeleteActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Variables GUI">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonRevert;
    private org.jdesktop.swingx.JXDatePicker datePickerCalcDate;
    private org.jdesktop.swingx.JXDatePicker datePickerExpiration;
    private javax.swing.JLabel labelAgency;
    private javax.swing.JLabel labelBank;
    private org.jdesktop.swingx.JXLabel labelCalcDate;
    private javax.swing.JLabel labelExpiration;
    private javax.swing.JLabel labelGross;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelPayee;
    private javax.swing.JLabel labelPercent;
    private javax.swing.JLabel labelRegistryNumber;
    private org.jdesktop.swingx.JXLabel labelTaxa;
    private org.jdesktop.swingx.JXPanel panelButtons;
    private org.jdesktop.swingx.JXPanel panelForm;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JTextField textFieldAgency;
    private javax.swing.JTextField textFieldBank;
    private javax.swing.JTextField textFieldGross;
    private javax.swing.JTextField textFieldNumber;
    private javax.swing.JTextField textFieldObs;
    private javax.swing.JTextField textFieldPayee;
    private javax.swing.JTextField textFieldRate;
    private javax.swing.JTextField textFieldRegistryNumber;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
    
    public Check getCheckFromForm() throws ChequeMateException{
        ChequeMateException ex = exception;
        String registryNumber = textFieldRegistryNumber.getText();
        registryNumber = registryNumber.isEmpty() ? "" : Deformat.CPForCNPJ(registryNumber);
        
        String strNumber = textFieldNumber.getText();
        String strBank = textFieldBank.getText();
        String strAgency = textFieldAgency.getText();
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
        
        Date date = datePickerExpiration.getDate();
        GregorianCalendar expiration = new GregorianCalendar();
        if (date!=null) {
            expiration.setTime(date);
        }
        Date calcDate = datePickerCalcDate.getDate();
        GregorianCalendar gCalcDate = new GregorianCalendar();
        boolean isDateValid = false;
        if (calcDate != null) {
            gCalcDate.setTime(calcDate);
            if (gCalcDate.after(Days.TODAY)){
                isDateValid = true;
            } 
        }
        if (!isDateValid) {
            throw ex.retrieve("Data inválida.", datePickerExpiration);
        }
        String strGross = textFieldGross.getText();
        String strRate = textFieldRate.getText();
        strRate = strRate.isEmpty() ? "5.00" : Deformat.decimal(strRate);
        
        BigDecimal rate = new BigDecimal(strRate, new MathContext(20));
        BigDecimal gross = new BigDecimal(Deformat.decimal(strGross), new MathContext(20));
        int daysBetween = Days.between(baseDate, gCalcDate);
        BigDecimal net = ChequeMate.calculateInterest(gross, daysBetween, rate);
        
        String payeeName = textFieldPayee.getText().toUpperCase();
        String obs = textFieldObs.getText();
        
        Check newOne = new Check(number, bank, agency, gross.doubleValue(), net.doubleValue(), 
                rate.doubleValue(), new Payee(payeeName, registryNumber), expiration, gCalcDate);
        newOne.setId(check.getId());
        newOne.setObs(obs);
        return newOne;
    }
    
    private boolean validateData() {
        try {
            newCheck = getCheckFromForm();
            return true;
        } catch (ChequeMateException ex) {
            LOG.warning(ex.getMessage());
            ex.showExceptionMessage();
            return false;
        } 
    }
    
    private boolean apply() {
        boolean isValid = validateData();
        if (isValid && !check.equals(newCheck)) {
            recordFrame.replaceTableCheck(row, newCheck);
            recordFrame.setModified(true);
            check = newCheck;
        } 
        return isValid;
    }
    
    private void delete() {
        int choice = JOptionPane.showConfirmDialog(this, "Deseja excluir o cheque do cadastro corrente?", 
                "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (choice == JOptionPane.YES_OPTION){
            recordFrame.getRecordCheck().removeCheck(row, recordFrame.getModel());
            recordFrame.updateValueLabels();
            if (check.getId() != 0) {
                recordFrame.addToDeletedOnes(check);
            }
            recordFrame.setModified(true);
            dispose();
        }
    }
    
    private void revert() {
        validateData();
        if (check.equals(newCheck)) {
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "Deseja desfazer todas as modificações?", 
                "Desfazer", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (choice == JOptionPane.YES_OPTION){
            setupForm();
            newCheck = null;
            textFieldNumber.requestFocusInWindow();
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
        Verifier.set(textFieldObs, new TextVerifier());
        
        datePickerExpiration.setEditable(false);
        datePickerCalcDate.setEditable(false);
        
        JXMonthView expMonthView = datePickerExpiration.getMonthView();
        expMonthView.setLowerBound(Days.TODAY.getTime());
        expMonthView.setEnabled(true);
        expMonthView.setFlaggedDates(ChequeMate.getHolidayControl().getArrayDate());
        expMonthView.setFlaggedDayForeground(Color.red);
        
        JXMonthView calcMonthView = datePickerCalcDate.getMonthView();
        calcMonthView.setLowerBound(Days.TODAY.getTime());
        calcMonthView.setEnabled(true);
        calcMonthView.setUnselectableDates(ChequeMate.getHolidayControl().getArrayDate());
        
        datePickerExpiration.setEditable(false);
        datePickerCalcDate.setEditable(false);
        
        DatePickerPanel pickerPanelExp = new DatePickerPanel(datePickerExpiration, this);
        datePickerExpiration.setLinkPanel(pickerPanelExp);
        DatePickerPanel pickerPanelCalc = new DatePickerPanel(datePickerExpiration, this);
        datePickerExpiration.setLinkPanel(pickerPanelCalc);
        
        setupForm();
    }
    
    private void setupFocusComponents() {
       FocusPolicy.setDefaultTrasversalKeys(panelForm, FocusPolicy.BOTH_DIRECTIONS);
       ArrayList<Component> componentList = new ArrayList<>();
       componentList.add(textFieldNumber);
       componentList.add(textFieldBank);
       componentList.add(textFieldAgency);
       componentList.add(textFieldGross);
       componentList.add(textFieldRegistryNumber);
       componentList.add(textFieldPayee);
       componentList.add(textFieldRate);
       componentList.add(textFieldObs);
       componentList.add(buttonApply);
       setFocusTraversalPolicy(new FocusPolicy(componentList));
    }
    
    private void setupForm() {
        textFieldAgency.setText(String.valueOf(check.getAgency()));
        textFieldBank.setText(String.valueOf(check.getBank()));
        textFieldNumber.setText(String.valueOf(check.getNumber()));
        textFieldGross.setText(String.valueOf(check.getGross()));
        textFieldRegistryNumber.setText(check.getPayee().getRegistryNumber());
        textFieldPayee.setText(check.getPayee().getName());
        textFieldRate.setText(String.valueOf(check.getRate()));
        datePickerExpiration.setDate(check.getExpiration().getTime());
        datePickerCalcDate.setDate(check.getCalcDate().getTime());
        textFieldObs.setText(check.getObs());
        
        textFieldNumber.postActionEvent();
        textFieldBank.postActionEvent();
        textFieldAgency.postActionEvent();
        textFieldRegistryNumber.postActionEvent();
        textFieldPayee.postActionEvent();
        textFieldGross.postActionEvent();
        textFieldRate.postActionEvent();
        textFieldObs.postActionEvent();
    }
    // </editor-fold>

}
