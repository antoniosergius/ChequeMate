package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Format;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class BetweenDates extends javax.swing.JDialog {
    
    private GregorianCalendar beginDate;
    private GregorianCalendar finalDate;

    public BetweenDates(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setupComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new org.jdesktop.swingx.JXHeader();
        panelMain = new javax.swing.JPanel();
        labelBeginDate = new javax.swing.JLabel();
        formattedTextFieldBeginDate = new javax.swing.JFormattedTextField();
        labelFinalDate = new javax.swing.JLabel();
        formattedTextFieldFinalDate = new javax.swing.JFormattedTextField();
        buttonCleanBeginDate = new javax.swing.JButton();
        buttonCleanFinalDate = new javax.swing.JButton();
        panelButtons = new javax.swing.JPanel();
        buttonCalculate = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        labelResult = new javax.swing.JLabel();
        labelResultValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.date.png"))); // NOI18N
        header.setTitle("Calcular Dias Entre Datas");

        labelBeginDate.setText("Data Inicial:");

        try {
            formattedTextFieldBeginDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldBeginDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formattedTextFieldBeginDate.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        formattedTextFieldBeginDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formattedTextFieldBeginDateFocusGained(evt);
            }
        });

        labelFinalDate.setText("Data Final:");

        try {
            formattedTextFieldFinalDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldFinalDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formattedTextFieldFinalDate.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        formattedTextFieldFinalDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formattedTextFieldFinalDateFocusGained(evt);
            }
        });
        formattedTextFieldFinalDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formattedTextFieldFinalDateKeyReleased(evt);
            }
        });

        buttonCleanBeginDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.clear.png"))); // NOI18N
        buttonCleanBeginDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCleanBeginDateActionPerformed(evt);
            }
        });

        buttonCleanFinalDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.clear.png"))); // NOI18N
        buttonCleanFinalDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCleanFinalDateActionPerformed(evt);
            }
        });

        buttonCalculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.valid.png"))); // NOI18N
        buttonCalculate.setText("Calcular");
        buttonCalculate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCalculate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalculateActionPerformed(evt);
            }
        });

        buttonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.delete.png"))); // NOI18N
        buttonClear.setText("Limpar");
        buttonClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.cancel.png"))); // NOI18N
        buttonClose.setText("Fechar");
        buttonClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonCalculate, buttonClear, buttonClose});

        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonCalculate, buttonClear, buttonClose});

        labelResult.setText("Resultado:");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(labelBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(formattedTextFieldBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(labelFinalDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(formattedTextFieldFinalDate)))
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(buttonCleanBeginDate))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonCleanFinalDate))))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(labelResult)
                        .addGap(18, 18, 18)
                        .addComponent(labelResultValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelBeginDate, labelFinalDate, labelResult});

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonCleanBeginDate, buttonCleanFinalDate});

        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formattedTextFieldBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCleanBeginDate)
                    .addComponent(labelBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFinalDate)
                    .addComponent(formattedTextFieldFinalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCleanFinalDate))
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelResult)
                    .addComponent(labelResultValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonCleanBeginDate, buttonCleanFinalDate, formattedTextFieldBeginDate, formattedTextFieldFinalDate, labelBeginDate, labelFinalDate, labelResult, labelResultValue});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        setupInitialDates();
        labelResultValue.setText("");
        formattedTextFieldBeginDate.requestFocus();
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonCleanBeginDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanBeginDateActionPerformed
        setupBeginDate();
        labelResultValue.setText("");
        formattedTextFieldBeginDate.requestFocus();
    }//GEN-LAST:event_buttonCleanBeginDateActionPerformed

    private void buttonCleanFinalDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanFinalDateActionPerformed
        setupFinalDate();
        labelResultValue.setText("");
        formattedTextFieldFinalDate.requestFocus();
    }//GEN-LAST:event_buttonCleanFinalDateActionPerformed

    private void buttonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalculateActionPerformed
        doCalculate();
    }//GEN-LAST:event_buttonCalculateActionPerformed

    private void formattedTextFieldBeginDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formattedTextFieldBeginDateFocusGained
        formattedTextFieldBeginDate.setCaretPosition(0);
    }//GEN-LAST:event_formattedTextFieldBeginDateFocusGained

    private void formattedTextFieldFinalDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formattedTextFieldFinalDateFocusGained
        formattedTextFieldFinalDate.setCaretPosition(0);
    }//GEN-LAST:event_formattedTextFieldFinalDateFocusGained

    private void formattedTextFieldFinalDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formattedTextFieldFinalDateKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            doCalculate();
        }
    }//GEN-LAST:event_formattedTextFieldFinalDateKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalculate;
    private javax.swing.JButton buttonCleanBeginDate;
    private javax.swing.JButton buttonCleanFinalDate;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonClose;
    private javax.swing.JFormattedTextField formattedTextFieldBeginDate;
    private javax.swing.JFormattedTextField formattedTextFieldFinalDate;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel labelBeginDate;
    private javax.swing.JLabel labelFinalDate;
    private javax.swing.JLabel labelResult;
    private javax.swing.JLabel labelResultValue;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables

    private void setupInitialDates() {
        setupBeginDate();
        setupFinalDate();        
    }
    
    private void setupBeginDate() {
        beginDate = Days.TODAY;
        formattedTextFieldBeginDate.setText(Format.todayDate("dd/MM/yy"));
    }
    
    private void setupFinalDate() {
        finalDate = Days.TODAY;
        formattedTextFieldFinalDate.setText(Format.todayDate("dd/MM/yy"));
    }
    
    private void setupComponents() {
        setupInitialDates();
        setupFocusComponents();
    }

    private void setupFocusComponents() {
        setLocationRelativeTo(null);
        FocusPolicy.setDefaultTrasversalKeys(formattedTextFieldBeginDate, FocusPolicy.BOTH_DIRECTIONS);
        FocusPolicy.setDefaultTrasversalKeys(formattedTextFieldFinalDate, FocusPolicy.BACKWARD);
        
        //formattedTextFieldBeginDate.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, 
        //        KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalKeys(
        //        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        
        ArrayList<Component> components = new ArrayList<>();
        components.add(formattedTextFieldBeginDate);
        components.add(formattedTextFieldFinalDate);
        components.add(buttonCleanBeginDate);
        components.add(buttonCleanFinalDate);
        components.add(buttonCalculate);
        components.add(buttonClear);
        components.add(buttonClose);
        this.setFocusTraversalPolicy(new FocusPolicy(components));
    }

    private void doCalculate() {
        beginDate = Convert.toGregorian(formattedTextFieldBeginDate.getText(), "dd/MM/yy");
        finalDate = Convert.toGregorian(formattedTextFieldFinalDate.getText(), "dd/MM/yy");
        if (beginDate == null) {
            ChequeMate.showErrorMessage(formattedTextFieldBeginDate, "Data Inválida");
        } else if (finalDate == null) {
            ChequeMate.showErrorMessage(formattedTextFieldFinalDate, "Data Inválida");
        } else {
            int daysBetween = Days.between(beginDate, finalDate);
            labelResultValue.setText(daysBetween + " dia(s)");
        }
    }
}
