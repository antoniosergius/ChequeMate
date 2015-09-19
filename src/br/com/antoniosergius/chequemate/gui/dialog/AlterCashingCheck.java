package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.gui.panel.DatePickerPanel;
import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.chequemate.obj.Parameters;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;

public class AlterCashingCheck extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;

    private final int rowIndex;
    private Cashing newCashing;
    private Cashing currentCashing;
    private final CheckCashing parentFrame;
    
    public AlterCashingCheck(java.awt.Frame parent, CheckCashing parentFrame, boolean modal, int rowIndex, Cashing cashing) {
        super(parent, modal);
        this.rowIndex = rowIndex;
        this.parentFrame = parentFrame;
        currentCashing = cashing;
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        panelCashingCheck = new org.jdesktop.swingx.JXPanel();
        labelValorBruto = new org.jdesktop.swingx.JXLabel();
        labelVencimento = new org.jdesktop.swingx.JXLabel();
        labelTaxa = new org.jdesktop.swingx.JXLabel();
        textFieldGross = new javax.swing.JTextField();
        datePickerExpiration = new org.jdesktop.swingx.JXDatePicker();
        textFieldRate = new javax.swing.JTextField();
        buttonApply = new org.jdesktop.swingx.JXButton();
        buttonCancel = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setIconImages(null);

        panelCashingCheck.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Item Desconto"));

        labelValorBruto.setText("Valor Bruto (R$):");

        labelVencimento.setText("Vencimento: ");

        labelTaxa.setText("Taxa (%):");

        datePickerExpiration.setFormats(new String[]{"dd/MM/yyyy"});

        javax.swing.GroupLayout panelCashingCheckLayout = new javax.swing.GroupLayout(panelCashingCheck);
        panelCashingCheck.setLayout(panelCashingCheckLayout);
        panelCashingCheckLayout.setHorizontalGroup(
            panelCashingCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCashingCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCashingCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelValorBruto, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(labelVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTaxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCashingCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldGross)
                    .addComponent(datePickerExpiration, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(textFieldRate))
                .addContainerGap())
        );
        panelCashingCheckLayout.setVerticalGroup(
            panelCashingCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCashingCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCashingCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValorBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldGross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCashingCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCashingCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonApply.setText("Aplicar");
        buttonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCashingCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonApply, buttonCancel});

        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCashingCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonApply, buttonCancel});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        if (apply()) {
            dispose();
        }
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton buttonApply;
    private org.jdesktop.swingx.JXButton buttonCancel;
    private org.jdesktop.swingx.JXDatePicker datePickerExpiration;
    private org.jdesktop.swingx.JXLabel labelTaxa;
    private org.jdesktop.swingx.JXLabel labelValorBruto;
    private org.jdesktop.swingx.JXLabel labelVencimento;
    private org.jdesktop.swingx.JXPanel panelCashingCheck;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JTextField textFieldGross;
    private javax.swing.JTextField textFieldRate;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setTitle("Alterando Linha nº "+(rowIndex+1));
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.cash.png")).getImage());

        setLocationRelativeTo(null);
        datePickerExpiration.setEditable(false);
        DatePickerPanel pickerPanelExp = new DatePickerPanel(datePickerExpiration, this);
        datePickerExpiration.setLinkPanel(pickerPanelExp);
        
        setupForm(currentCashing);
    }

    private void setupForm(Cashing currentCashing) {
        textFieldGross.setText(Format.decimal(currentCashing.getGross()));
        textFieldRate.setText(Format.decimal(currentCashing.getRate()));
        datePickerExpiration.setDate(currentCashing.getExpiration().getTime());
    }
    
    private boolean validateData() {
        try {
            newCashing = getCashingCheckFromForm();
            return true;
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
            return false;
        } 
    }
    
    public Cashing getCashingCheckFromForm() throws ChequeMateException{
        Date date = datePickerExpiration.getDate();
        if (date==null) {
            throw new ChequeMateException("Data inválida.");
        } 
        GregorianCalendar expiration = new GregorianCalendar();
        expiration.setTime(date);
        GregorianCalendar calcDate = new GregorianCalendar();
        calcDate.setTime(ChequeMate.getHolidayControl().nextBusinessDate(
                expiration.getTime(), Parameters.WITH_MIN_DAYS));
        String strGross = textFieldGross.getText();
        String strRate = textFieldRate.getText();
        strRate = strRate.isEmpty() ? String.valueOf(ChequeMate.getPreferences().getDefaultRate())
                : Deformat.decimal(strRate);
        
        BigDecimal rate = new BigDecimal(strRate, new MathContext(20));
        BigDecimal gross = new BigDecimal(Deformat.decimal(strGross), new MathContext(20));
        int daysBetween = Days.between(Days.TODAY, calcDate);
        BigDecimal net = ChequeMate.calculateInterest(gross, daysBetween, rate);
        
        return new Cashing(expiration, gross.doubleValue(), net.doubleValue(),
                rate.doubleValue(), calcDate);
    }

    private boolean apply() {
        boolean isValid = validateData();
        if (isValid && !currentCashing.equals(newCashing)) {
            parentFrame.replaceTableCashing(rowIndex, newCashing);
            currentCashing = newCashing;
        } 
        return isValid;
    }
    
    
}
