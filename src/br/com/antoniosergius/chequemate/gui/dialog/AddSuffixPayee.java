package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.gui.RegisterCheckFrame;
import br.com.antoniosergius.chequemate.obj.record.RecordCheck;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddSuffixPayee extends javax.swing.JDialog {
    private static final Logger LOG = Logger.getLogger(AddSuffixPayee.class.getName());

    private RegisterCheckFrame parent;
    
    public AddSuffixPayee(RegisterCheckFrame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSufixo = new org.jdesktop.swingx.JXLabel();
        textFieldSuffix = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelSufixo.setText("Adicionar Sufixo no Emitente:");

        buttonAdd.setText("Adicionar");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelSufixo, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonCancel)
                        .addGap(5, 5, 5)
                        .addComponent(buttonAdd)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonAdd, buttonCancel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSufixo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonAdd, buttonCancel});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelSufixo, textFieldSuffix});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        try {
            addSuffix();
        } catch (ChequeMateException ex) {
            LOG.log(Level.SEVERE, null, ex);
            ex.showExceptionMessage();
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private org.jdesktop.swingx.JXLabel labelSufixo;
    private javax.swing.JTextField textFieldSuffix;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setTitle("Adicionar Sufixo");
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonAdd);
        Verifier.set(textFieldSuffix, new TextVerifier(20));
    }

    private void addSuffix() throws ChequeMateException {
        String suffix = textFieldSuffix.getText();
        if (suffix.isEmpty()) {
            throw new ChequeMateException("Digite o texte que deseja adicionar.", textFieldSuffix);
        } else {
            RecordCheck record = parent.getRecordCheck();
            int listSize = record.getList().size();
            for (int i=0; i<listSize; i++) {
                record.addPayeeSuffix(i, suffix, parent.getModel());
            }
        }
        dispose();
    }
}
