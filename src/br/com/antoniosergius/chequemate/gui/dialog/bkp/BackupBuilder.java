package br.com.antoniosergius.chequemate.gui.dialog.bkp;

import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.lib.util.io.BackupService;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class BackupBuilder extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(BackupBuilder.class.getName());
    
    private BackupService backupMySQL;
    private JFileChooser fileChooser;
    private File file;
    
    public BackupBuilder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        backupMySQL = ChequeMate.getBackupService();
        backupMySQL.setDateTime(new GregorianCalendar());
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        panelForm = new org.jdesktop.swingx.JXPanel();
        labelDescription = new org.jdesktop.swingx.JXLabel();
        textFieldFile = new javax.swing.JTextField();
        buttonOpen = new javax.swing.JButton();
        buttonGenerate = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.backup.png"))); // NOI18N
        header.setTitle("Gerador de Backup");

        labelDescription.setText("Digite ou selecione o local para executar o backup:");

        buttonOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.open.png"))); // NOI18N
        buttonOpen.setText("Abrir...");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        buttonGenerate.setText("Gerar");
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        buttonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.remove.png"))); // NOI18N
        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormLayout.createSequentialGroup()
                                .addComponent(buttonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addComponent(textFieldFile, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonCancel, buttonGenerate});

        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGenerate)
                    .addComponent(buttonCancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        int returnValue = fileChooser.showDialog(this, "Selecionar");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            textFieldFile.setText(file.getPath());
        }   
    }//GEN-LAST:event_buttonOpenActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if (textFieldFile.getText().trim().isEmpty()) {
            ChequeMate.showErrorMessage(this, "Favor preencher ou selecionar o arquivo.");
            return;
        }
        if (file == null) {
            file = new File(textFieldFile.getText().trim());
        }
        if (file.exists()) {
            if (file.canWrite()) {
                executeBackup(file, true);
            } else {
                ChequeMate.showErrorMessage(this, "O diretório não possui permissão de escrita.");
            }
        } else {
            executeBackup(file, false);
        }
    }//GEN-LAST:event_buttonGenerateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JButton buttonOpen;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXLabel labelDescription;
    private org.jdesktop.swingx.JXPanel panelForm;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JTextField textFieldFile;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setLocationRelativeTo(null);
        setTitle("Criar Backup");
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(ChequeMate.getPreferences().getBackupPath());
        String fileName = backupMySQL.createFileName();
        textFieldFile.setText(ChequeMate.getPreferences().getBackupPath()+File.separator+fileName);
        fileChooser.setSelectedFile(new File(fileName));
    }
    
    private void executeBackup(File saveFile, boolean exists) {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        try {
            if (!exists) {
                saveFile.createNewFile();
            } 
            backupMySQL.setFile(saveFile);
            if (backupMySQL.commitBackup()) {
                ChequeMate.showSuccessMessage(this, "Backup efetuado com sucesso.");
                dispose();
            } else {
                ChequeMate.showErrorMessage(this, "Houve algum erro ao gravar o arquivo.");
            }
        } catch (InterruptedException | IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            ChequeMate.showErrorMessage(null, "Não foi possível gerar o Backup para o respectivo diretório.");
        } finally {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
}
