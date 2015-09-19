package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.obj.Loan;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.verif.MoneyVerifier;
import br.com.antoniosergius.lib.verif.PercentVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoanSimulator extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(LoanSimulator.class.getName());
    
    private JTextField currentTextField;
    
    public LoanSimulator(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        menuItemLimparCampo = new javax.swing.JMenuItem();
        panelMain = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        panelForm = new org.jdesktop.swingx.JXPanel();
        labelValor = new org.jdesktop.swingx.JXLabel();
        labelTaxa = new org.jdesktop.swingx.JXLabel();
        labelMeses = new org.jdesktop.swingx.JXLabel();
        labelParcela = new org.jdesktop.swingx.JXLabel();
        textFieldGross = new javax.swing.JTextField();
        textFieldRate = new javax.swing.JTextField();
        textFieldMonths = new javax.swing.JTextField();
        textFieldFee = new javax.swing.JTextField();
        labelPercent = new javax.swing.JLabel();
        labelRetention = new javax.swing.JLabel();
        labelSomaParcelas = new javax.swing.JLabel();
        labelSomaParcelasDyn = new javax.swing.JLabel();
        labelRetentionDyn = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        buttonCalcular = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();
        buttonFechar = new javax.swing.JButton();

        menuItemLimparCampo.setText("Limpar Campo");
        menuItemLimparCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLimparCampoActionPerformed(evt);
            }
        });
        popupMenu.add(menuItemLimparCampo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Simulador");

        header.setTitle("Financiamento ou Empréstimo");
        header.setToolTipText("");

        labelValor.setText("Capital (R$):");

        labelTaxa.setText("Taxa Juros:");

        labelMeses.setText("Meses:");

        labelParcela.setText("Parcela (R$):");

        textFieldGross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldGrossMouseClicked(evt);
            }
        });

        textFieldRate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldRateMouseClicked(evt);
            }
        });

        textFieldMonths.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldMonthsMouseClicked(evt);
            }
        });

        textFieldFee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldFeeMouseClicked(evt);
            }
        });

        labelPercent.setText("%");

        labelRetention.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelRetention.setForeground(new java.awt.Color(0, 102, 51));
        labelRetention.setText("Retenção: ");

        labelSomaParcelas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelSomaParcelas.setForeground(new java.awt.Color(204, 0, 0));
        labelSomaParcelas.setText("Soma das Parcelas: ");

        labelSomaParcelasDyn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelSomaParcelasDyn.setForeground(new java.awt.Color(204, 0, 0));
        labelSomaParcelasDyn.setText(" ");

        labelRetentionDyn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelRetentionDyn.setForeground(new java.awt.Color(0, 102, 51));
        labelRetentionDyn.setText(" ");

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelMeses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTaxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelParcela, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textFieldMonths, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(labelPercent))
                            .addComponent(textFieldGross, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelSomaParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(labelRetention, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelRetentionDyn, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(labelSomaParcelasDyn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jSeparator1)
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelMeses, labelParcela, labelTaxa, labelValor});

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textFieldFee, textFieldGross, textFieldMonths, textFieldRate});

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelRetention, labelSomaParcelas});

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelRetentionDyn, labelSomaParcelasDyn});

        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldGross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPercent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSomaParcelas)
                    .addComponent(labelSomaParcelasDyn))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRetention)
                    .addComponent(labelRetentionDyn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelMeses, labelParcela, labelTaxa, labelValor});

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {textFieldFee, textFieldGross, textFieldMonths, textFieldRate});

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelRetention, labelSomaParcelas});

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelRetentionDyn, labelSomaParcelasDyn});

        buttonCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.calc.png"))); // NOI18N
        buttonCalcular.setText("Calcular");
        buttonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalcularActionPerformed(evt);
            }
        });

        buttonLimpar.setText("Limpar");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        buttonFechar.setText("Fechar");
        buttonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jXPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonCalcular, buttonFechar, buttonLimpar});

        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLimpar)
                    .addComponent(buttonFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonCalcular, buttonFechar, buttonLimpar});

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        clearFields();
        textFieldGross.requestFocusInWindow();
    }//GEN-LAST:event_buttonLimparActionPerformed

    private void buttonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_buttonFecharActionPerformed

    private void buttonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalcularActionPerformed
        try {
            Loan loan = calculate();
            setForm(loan);
            setRetentionAndFeeSum(loan);
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (ArithmeticException ex) {
            ChequeMate.showErrorMessage(this, ex.getMessage());
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_buttonCalcularActionPerformed

    private void menuItemLimparCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLimparCampoActionPerformed
        currentTextField.setText("");
    }//GEN-LAST:event_menuItemLimparCampoActionPerformed

    private void textFieldGrossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldGrossMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            currentTextField = textFieldGross;
            popupMenu.show(currentTextField, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_textFieldGrossMouseClicked

    private void textFieldRateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldRateMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            currentTextField = textFieldRate;
            popupMenu.show(currentTextField, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_textFieldRateMouseClicked

    private void textFieldMonthsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldMonthsMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            currentTextField = textFieldMonths;
            popupMenu.show(currentTextField, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_textFieldMonthsMouseClicked

    private void textFieldFeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldFeeMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            currentTextField = textFieldFee;
            popupMenu.show(currentTextField, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_textFieldFeeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalcular;
    private javax.swing.JButton buttonFechar;
    private javax.swing.JButton buttonLimpar;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXLabel labelMeses;
    private org.jdesktop.swingx.JXLabel labelParcela;
    private javax.swing.JLabel labelPercent;
    private javax.swing.JLabel labelRetention;
    private javax.swing.JLabel labelRetentionDyn;
    private javax.swing.JLabel labelSomaParcelas;
    private javax.swing.JLabel labelSomaParcelasDyn;
    private org.jdesktop.swingx.JXLabel labelTaxa;
    private org.jdesktop.swingx.JXLabel labelValor;
    private javax.swing.JMenuItem menuItemLimparCampo;
    private org.jdesktop.swingx.JXPanel panelForm;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTextField textFieldFee;
    private javax.swing.JTextField textFieldGross;
    private javax.swing.JTextField textFieldMonths;
    private javax.swing.JTextField textFieldRate;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setLocationRelativeTo(null);
        setResizable(false);
        Verifier.set(textFieldGross, new MoneyVerifier(4));
        Verifier.set(textFieldFee, new MoneyVerifier(4));
        Verifier.set(textFieldMonths, new MoneyVerifier(4));
        Verifier.set(textFieldRate, new PercentVerifier(10));
        
        FocusPolicy.setDefaultTrasversalKeys(panelForm, FocusPolicy.BOTH_DIRECTIONS);
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldGross);
        list.add(textFieldRate);
        list.add(textFieldMonths);
        list.add(textFieldFee);
        setFocusTraversalPolicy(new FocusPolicy(list));
    }
    
    public boolean isEmpty() {
        return textFieldFee.getText().isEmpty() &&
               textFieldGross.getText().isEmpty() &&
               textFieldMonths.getText().isEmpty() &&
               textFieldRate.getText().isEmpty();
    }
    
    public void clearFields() {
        textFieldFee.setText("");
        textFieldGross.setText("");
        textFieldMonths.setText("");
        textFieldRate.setText("");
        labelSomaParcelasDyn.setText("");
        labelRetentionDyn.setText("");
    }

    private Loan calculate() throws ChequeMateException{
        Loan loan = new Loan();
        String strGross = textFieldGross.getText();
        String strRate = textFieldRate.getText();
        String strMonths = textFieldMonths.getText();
        String strFee = textFieldFee.getText();
        int filledFields = 0;
        if (!strGross.isEmpty()) {
            loan.setGross(new BigDecimal(Deformat.decimal(strGross)));
            filledFields++;
        } 
        if (!strRate.isEmpty()) {
            loan.setRate(new BigDecimal(Deformat.decimal(strRate)));
            filledFields++;
        } 
        if (!strFee.isEmpty()) {
            loan.setFee(new BigDecimal(Deformat.decimal(strFee)));
            filledFields++;
        } 
        if (!strMonths.isEmpty()) {
            loan.setMonths(new BigDecimal(Deformat.decimal(strMonths)));
            filledFields++;
        } 
        if (filledFields != 3) {
            throw new ChequeMateException("É necessário que um campo fique vazio.");
        }
        loan.calculate();
        return loan;
    }
    
    private void setForm(Loan loan) {
        textFieldGross.setText(Format.decimal(loan.getGross(),4));
        textFieldFee.setText(Format.decimal(loan.getFee(),4));
        textFieldRate.setText(Format.decimal(loan.getRate(),10));
        textFieldMonths.setText(Format.decimal(loan.getMonths(),4));
        textFieldGross.postActionEvent();
        textFieldFee.postActionEvent();
        textFieldRate.postActionEvent();
        textFieldMonths.postActionEvent();
        
    }
    
    public void setRetentionAndFeeSum(Loan loan) {
        labelRetentionDyn.setText(Format.currency(loan.getRetention()));
        labelSomaParcelasDyn.setText(Format.currency(loan.getFeeSum()));
    }
    
    
}
