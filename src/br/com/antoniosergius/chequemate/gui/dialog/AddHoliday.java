package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.HolidayController;
import br.com.antoniosergius.chequemate.obj.Holiday;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.tools.Parse;
import br.com.antoniosergius.lib.verif.IntegerVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.joda.time.DateMidnight;

public class AddHoliday extends javax.swing.JDialog {
    private static final Logger LOG = Logger.getLogger(AddHoliday.class.getName());
    private static final long serialVersionUID = 1L;
    
    private Holiday holiday;
    private HolidayController holidayControl; 
    private ViewAllHolidays parentDialog;
    private ChequeMateException exception = new ChequeMateException();
    
    public AddHoliday(java.awt.Frame parent, boolean modal, HolidayController holidayControl, Dialog parentDialog) {
        super(parent, modal);
        this.holidayControl = holidayControl;
        this.parentDialog = (ViewAllHolidays)parentDialog;
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        panelData = new org.jdesktop.swingx.JXPanel();
        labelDay = new org.jdesktop.swingx.JXLabel();
        textFieldDay = new javax.swing.JTextField();
        labelMonth = new org.jdesktop.swingx.JXLabel();
        textFieldMonth = new javax.swing.JTextField();
        labelYear = new org.jdesktop.swingx.JXLabel();
        textFieldYear = new javax.swing.JTextField();
        textFieldDescription = new javax.swing.JTextField();
        labelDescription = new org.jdesktop.swingx.JXLabel();
        labelDetails = new org.jdesktop.swingx.JXLabel();
        buttonApply = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Feriado");

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.date.png"))); // NOI18N
        header.setTitle("Modo de Adição");

        labelDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDay.setText("Dia");

        labelMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMonth.setText("Mês");

        labelYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelYear.setText("Ano*");

        labelDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDescription.setText("Descrição");

        labelDetails.setText("* Caso seja um feriado fixo, deixe o ano em branco ou preencha-o com zero.");

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldDay)
                            .addComponent(labelDay, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldMonth)
                            .addComponent(labelMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldYear)
                            .addComponent(labelYear, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelDataLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelDay, labelMonth, labelYear, textFieldDay, textFieldMonth, textFieldYear});

        panelDataLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelDescription, textFieldDescription});

        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonApply)
                .addContainerGap())
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonApply, buttonCancel});

        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonApply)
                    .addComponent(buttonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        if (apply()) {
            if (parentDialog != null) {
                parentDialog.refresh();
            }
            dispose();
        }
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonCancel;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXLabel labelDay;
    private org.jdesktop.swingx.JXLabel labelDescription;
    private org.jdesktop.swingx.JXLabel labelDetails;
    private org.jdesktop.swingx.JXLabel labelMonth;
    private org.jdesktop.swingx.JXLabel labelYear;
    private org.jdesktop.swingx.JXPanel panelData;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JTextField textFieldDay;
    private javax.swing.JTextField textFieldDescription;
    private javax.swing.JTextField textFieldMonth;
    private javax.swing.JTextField textFieldYear;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.date.png")).getImage());
        setupFocusComponents();
        Verifier.set(textFieldDay, new IntegerVerifier(2));
        Verifier.set(textFieldMonth, new IntegerVerifier(2));
        Verifier.set(textFieldYear, new IntegerVerifier(4));
        clearForm();
        textFieldDay.requestFocusInWindow();
    }
    
    private boolean apply() {
        boolean isValid = validate(false);
        if (isValid) {
            try {
                add();
                return true;
            } catch (SQLException ex) {
                LOG.warning(ex.getMessage());
            } 
        } 
        return false;
    }

    private void setupFocusComponents() {
        FocusPolicy.setDefaultTrasversalKeys(panelData, FocusPolicy.BOTH_DIRECTIONS);
        ArrayList<Component> components = new ArrayList<>();
        components.add(textFieldDay);
        components.add(textFieldMonth);
        components.add(textFieldYear);
        components.add(textFieldDescription);
        panelData.setFocusTraversalPolicy(new FocusPolicy(components));
    }
    
    private Holiday getHolidayFromForm() throws ChequeMateException {
        ChequeMateException ex = exception;
        if (isEmpty()) {
            throw ex.retrieve("Favor preencher os campos.", textFieldDay);
        }
        String strDay = textFieldDay.getText();
        String strMonth = textFieldMonth.getText();
        String strYear = textFieldYear.getText();
        
        if (strDay.isEmpty()) {
            throw ex.retrieve("Favor preencher o dia.", textFieldDay);
        }
        if (strMonth.isEmpty()) {
            throw ex.retrieve("Favor preencher o mês.", textFieldMonth);
        }
        int day = Integer.parseInt(strDay);
        if (day<1 || day>31) {
            throw ex.retrieve("Dia do mês inválido.", textFieldDay);
        }
        int month = Integer.parseInt(strMonth);
        if (month<1 || month>12) {
            throw ex.retrieve("Mês inválido", textFieldMonth);
        }
        int year = strYear.equals("") ? 0 : Integer.parseInt(strYear);
        if (year != 0) {
            if (year<Days.TODAY.get(GregorianCalendar.YEAR)) {
                throw ex.retrieve("O ano digitado já passou.", textFieldYear);
            }
        }
        String description = textFieldDescription.getText();
        if (description.isEmpty()) {
            throw ex.retrieve("Digite a descrição do feriado.", textFieldDescription);
        }
        StringBuilder date = new StringBuilder();
        date.append(day).append("/").append(month).append("/").append(year == 0 ? Days.TODAY.get(GregorianCalendar.YEAR) : year);
        if (!Parse.date(date.toString())) {
            throw ex.retrieve("A data digitada não é válida.", textFieldDay);
        }
        GregorianCalendar gDate = Convert.toGregorian(date.toString());
        System.out.println(Format.date(gDate));
        if (holidayControl.getMap().containsKey(new DateMidnight(gDate.getTimeInMillis()))) {
            throw ex.retrieve("Já contém uma data igual cadastrada no sistema.", textFieldDay);
        }
        return new Holiday(day, month, year, description);
    }

    private void add() throws SQLException{
        holidayControl.insert(holiday);
        ChequeMate.showSuccessMessage(this, "Feriado adicionado com sucesso.");
        dispose();
    }
    
    private boolean validate(boolean warn) {
        try {
            holiday = getHolidayFromForm();
            if (warn) {
                ChequeMate.showSuccessMessage(this, "Todos os valores foram validados com sucesso.");
            }
            return true;
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
            return false;
        }
    }

    private void clearForm() {
        textFieldYear.setText("");
        textFieldDescription.setText("");
        textFieldDay.setText("");
        textFieldMonth.setText("");
    }
    
    private boolean isEmpty() {
        return  textFieldDay.getText().isEmpty() &&
                textFieldMonth.getText().isEmpty() &&
                textFieldYear.getText().isEmpty() &&
                textFieldDescription.getText().isEmpty();
    }
}
