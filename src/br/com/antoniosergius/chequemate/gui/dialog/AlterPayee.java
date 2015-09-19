package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.obj.PayeeExt;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AlterPayee extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(AlterPayee.class.getName());

    private Connection conn;
    private int modelIndex;
    private ViewAllPayees parent;
    private PayeeExt oldPayee;
    private PayeeExt newPayee;
    private PayeeController payeeControl;
    
    public AlterPayee(ViewAllPayees parent, boolean modal, Connection conn, PayeeExt oldPayee, int modelIndex) {
        super(parent, modal);
        this.parent = parent;
        this.conn = conn;
        this.modelIndex = modelIndex;
        this.oldPayee = oldPayee;
        this.newPayee = oldPayee;
        payeeControl = new PayeeController(conn);
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        panelForm = new org.jdesktop.swingx.JXPanel();
        labelNome = new org.jdesktop.swingx.JXLabel();
        textFieldName = new javax.swing.JTextField();
        panelButtons = new org.jdesktop.swingx.JXPanel();
        buttonApply = new org.jdesktop.swingx.JXButton();
        buttonCancel = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setTitle("Alterar Emitente");

        labelNome.setText("Nome:");

        textFieldName.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldName)
                .addContainerGap())
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonApply, buttonCancel});

        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonApply, buttonCancel});

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (apply()) {
                    dispose();
                }
            }
        });  
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton buttonApply;
    private org.jdesktop.swingx.JXButton buttonCancel;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXLabel labelNome;
    private org.jdesktop.swingx.JXPanel panelButtons;
    private org.jdesktop.swingx.JXPanel panelForm;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JTextField textFieldName;
    // End of variables declaration//GEN-END:variables

    private int updatePayeeExt() throws SQLException {
        int choice = JOptionPane.showConfirmDialog(this, "Deseja salvar as alterações feitas?", "Salvar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if (choice == JOptionPane.YES_OPTION) {
            payeeControl.updateName(newPayee.getId(), newPayee.getName());
            parent.updateFromModel(newPayee, modelIndex);
        }
        return choice;
    }
    
    private boolean apply() {
        boolean isValid = validateData();
        if (isValid) {
            try {
                if (updatePayeeExt() == JOptionPane.YES_OPTION) {
                    ChequeMate.showSuccessMessage(this, "Emitente alterado com sucesso.");
                    oldPayee = newPayee;
                    return true;
                } else {
                    textFieldName.requestFocusInWindow();
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            } 
        } 
        return false;
    }

    private boolean validateData() {
        try {
            newPayee = getPayeeFromForm();
            return true;
        } catch (ChequeMateException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
            ex.showExceptionMessage();
            return false;
        } 
    }

    private PayeeExt getPayeeFromForm() throws ChequeMateException{
        String name = textFieldName.getText();
        if ("".equals(name)) {
            throw new ChequeMateException("Nome inválido.", textFieldName);
        }
        return new PayeeExt(name, oldPayee.getRegistryNumber(), oldPayee.getId(),
                oldPayee.getHigherCheckValue(), oldPayee.getFirstCheckInput(), 
                oldPayee.getLastCheckInput(), oldPayee.getCheckCount());
    }

    private void setupComponents() {
        setTitle(oldPayee.getName());
        setLocationRelativeTo(null);
        setResizable(false);
        Verifier.set(textFieldName, new TextVerifier());
        textFieldName.setText(oldPayee.getName());
    }
}
