package br.com.antoniosergius.chequemate.gui.panel;

import br.com.antoniosergius.chequemate.gui.QueryCheckFrame;
import br.com.antoniosergius.chequemate.gui.QueryExtCheckFrame;
import br.com.antoniosergius.lib.tools.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import org.jdesktop.swingx.JXDatePicker;

public class DatePickerPanel extends javax.swing.JPanel {
    
    private final JXDatePicker datePicker;
    private final QueryCheckFrame queryFrame;
    private final QueryExtCheckFrame queryExtFrame;
    private final JDialog dialog;
    private final String name;
    
    
    
    public DatePickerPanel(JXDatePicker datePicker, QueryCheckFrame queryFrame, String name) {
        this.datePicker = datePicker;
        this.queryFrame = queryFrame;
        this.queryExtFrame = null;
        this.dialog = null;
        this.name = name;
        initComponents();
    }
    
    public DatePickerPanel(JXDatePicker datePicker, QueryExtCheckFrame queryExtFrame, String name) {
        this.datePicker = datePicker;
        this.queryFrame = null;
        this.queryExtFrame = queryExtFrame;
        this.dialog = null;
        this.name = name;
        initComponents();
    }

    public DatePickerPanel(JXDatePicker datePicker, JDialog dialog) {
        this.datePicker = datePicker;
        this.queryFrame = null;
        this.queryExtFrame = null;
        this.name = "";
        this.dialog = dialog;
        initComponents();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hyperlinkToday = new org.jdesktop.swingx.JXHyperlink();
        buttonClear = new javax.swing.JButton();

        hyperlinkToday.setText("Hoje é "+Format.todayDate());
        hyperlinkToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hyperlinkTodayActionPerformed(evt);
            }
        });

        buttonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.clear.png"))); // NOI18N
        buttonClear.setToolTipText("Limpar campo da data");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hyperlinkToday, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hyperlinkToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hyperlinkTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hyperlinkTodayActionPerformed
        datePicker.setDate(new Date());
        try {
            datePicker.commitEdit();
            datePicker.setLightWeightPopupEnabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(DatePickerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hyperlinkTodayActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        datePicker.setDate(null);
        if (dialog==null) {
            
            if (queryFrame != null) {
                switch (name) {
                    case "" : break;
                    case "highest": queryFrame.getQuery().setMaxExpirationDate(); break;
                    case "highestInput": queryFrame.getQuery().setMaxInputDate(); break;
                    case "lowest": queryFrame.getQuery().setMinExpirationDate(); break;
                    case "lowestInput": queryFrame.getQuery().setMinInputDate(); break;   
                    default: break;
                }
                queryFrame.queryAndSetupTableData();
            }
            if (queryExtFrame != null) {
                switch (name) {
                    case "" : break;
                    case "highest": queryExtFrame.getQuery().setMaxExpirationDate(); break;
                    case "highestInput": queryExtFrame.getQuery().setMaxInputDate(); break;
                    case "lowest": queryExtFrame.getQuery().setMinExpirationDate(); break;
                    case "lowestInput": queryExtFrame.getQuery().setMinInputDate(); break;   
                    default: break;
                }
                queryExtFrame.queryAndSetupTableData();
            }
            
        }
        datePicker.setLightWeightPopupEnabled(false);
    }//GEN-LAST:event_buttonClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear;
    private org.jdesktop.swingx.JXHyperlink hyperlinkToday;
    // End of variables declaration//GEN-END:variables

    
}
