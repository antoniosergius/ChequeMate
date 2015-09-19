package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.obj.Preferences;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.chequemate.util.MyPath;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.util.io.Serialize;
import br.com.antoniosergius.lib.verif.IntegerVerifier;
import br.com.antoniosergius.lib.verif.PercentVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class AlterPreferences extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(AlterPreferences.class.getName());
    
    private Preferences preferences;
    private JFileChooser fileChooser;
    private Serialize<Preferences> serial;
    private File file;

    public AlterPreferences(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        panelForm = new org.jdesktop.swingx.JXPanel();
        labelTaxaPadrao = new org.jdesktop.swingx.JXLabel();
        textFieldDefaultRate = new javax.swing.JTextField();
        labelBackupDir = new org.jdesktop.swingx.JXLabel();
        textFieldBackupPath = new javax.swing.JTextField();
        labelMostrarSplash = new org.jdesktop.swingx.JXLabel();
        checkBoxSplashScreen = new javax.swing.JCheckBox();
        buttonChoosePath = new org.jdesktop.swingx.JXButton();
        labelManterArquivosCadastros = new org.jdesktop.swingx.JXLabel();
        textFieldDaysToKeepRegistries = new javax.swing.JTextField();
        labelDias = new org.jdesktop.swingx.JXLabel();
        buttonCancel = new org.jdesktop.swingx.JXButton();
        buttonApply = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Preferências");

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.preferences.png"))); // NOI18N
        header.setTitle("Preferências");

        labelTaxaPadrao.setText("Taxa de Juros Padrão: ");

        labelBackupDir.setText("Diretório de Backup:");

        labelMostrarSplash.setText("Mostrar Tela de Splash:");

        buttonChoosePath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.open.png"))); // NOI18N
        buttonChoosePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChoosePathActionPerformed(evt);
            }
        });

        labelManterArquivosCadastros.setText("Manter arquivos de cadastros:");

        labelDias.setText("dias");

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelMostrarSplash, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(labelBackupDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTaxaPadrao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelManterArquivosCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(textFieldBackupPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonChoosePath, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldDefaultRate, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(checkBoxSplashScreen)
                            .addComponent(textFieldDaysToKeepRegistries))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDias, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(142, Short.MAX_VALUE))))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelBackupDir, labelManterArquivosCadastros, labelMostrarSplash, labelTaxaPadrao});

        panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textFieldDaysToKeepRegistries, textFieldDefaultRate});

        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTaxaPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldDefaultRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelManterArquivosCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldDaysToKeepRegistries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonChoosePath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelBackupDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldBackupPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkBoxSplashScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMostrarSplash, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {textFieldBackupPath, textFieldDaysToKeepRegistries, textFieldDefaultRate});

        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonApply.setText("Aplicar");
        buttonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonApply, buttonCancel});

        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChoosePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChoosePathActionPerformed
        int returnValue = fileChooser.showDialog(this, "Selecionar");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            textFieldBackupPath.setText(file.getPath());
        }   
    }//GEN-LAST:event_buttonChoosePathActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        try {
            apply();
        } catch (ChequeMateException | IOException ex) {
            if (ex instanceof ChequeMateException) {
                ((ChequeMateException)ex).showExceptionMessage();
            }
            LOG.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonApplyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton buttonApply;
    private org.jdesktop.swingx.JXButton buttonCancel;
    private org.jdesktop.swingx.JXButton buttonChoosePath;
    private javax.swing.JCheckBox checkBoxSplashScreen;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXLabel labelBackupDir;
    private org.jdesktop.swingx.JXLabel labelDias;
    private org.jdesktop.swingx.JXLabel labelManterArquivosCadastros;
    private org.jdesktop.swingx.JXLabel labelMostrarSplash;
    private org.jdesktop.swingx.JXLabel labelTaxaPadrao;
    private org.jdesktop.swingx.JXPanel panelForm;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JTextField textFieldBackupPath;
    private javax.swing.JTextField textFieldDaysToKeepRegistries;
    private javax.swing.JTextField textFieldDefaultRate;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setLocationRelativeTo(null);
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Verifier.set(textFieldDefaultRate, new PercentVerifier());
        Verifier.set(textFieldDaysToKeepRegistries, new IntegerVerifier(3));
        setupFocusComponents();
        serial = new Serialize<>(MyPath.PREFERENCES);
        readFile();
    }

    private void apply() throws ChequeMateException, IOException {
        preferences = getPreferencesFromForm();
        serial = new Serialize<>(preferences, MyPath.PREFERENCES);
        serial.write();
        ChequeMate.showSuccessMessage(this, "Preferências alteradas com sucesso.");
        ChequeMate.setPreferences(preferences);
        dispose();
    }

    private Preferences getPreferencesFromForm() throws ChequeMateException {
        String strDefaultRate = textFieldDefaultRate.getText();
        String strDaysToKeepRegistries = textFieldDaysToKeepRegistries.getText();
        boolean showSplash = checkBoxSplashScreen.isSelected();
        String backupPath = textFieldBackupPath.getText();
        if (strDefaultRate.isEmpty() || strDaysToKeepRegistries.isEmpty() || backupPath.isEmpty()) {
            throw new ChequeMateException("Algum campo ficou vazio!");
        }
        file = new File(backupPath);
        Preferences pref = new Preferences();
        pref.setBackupPath(file);
        pref.setShowSplashScreen(showSplash);
        pref.setDefaultRate(Deformat.andConvertDecimal(strDefaultRate));
        pref.setDaysToKeepRegistries(Integer.parseInt(strDaysToKeepRegistries));
        return pref;
    }

    private void readFile() {
        try {
            preferences = serial.read();
        } catch (ClassNotFoundException | IOException ex) {
            preferences = new Preferences();
            LOG.log(Level.SEVERE, null, ex);
        } finally {
            setupForm(preferences);
        }
    }
    
    private void setupForm(Preferences pref) {
        if (pref.getBackupPath()!=null) {
            textFieldBackupPath.setText(pref.getBackupPath().getPath());
        }
        textFieldDaysToKeepRegistries.setText(Format.number("000", pref.getDaysToKeepRegistries()));
        textFieldDefaultRate.setText(Format.decimal(pref.getDefaultRate()));
        checkBoxSplashScreen.setSelected(pref.isShowSplashScreen());
    }
    
    private void setupFocusComponents() {
        FocusPolicy.setDefaultTrasversalKeys(panelForm, FocusPolicy.BOTH_DIRECTIONS);
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldDefaultRate);
        list.add(textFieldDaysToKeepRegistries);
        list.add(textFieldBackupPath);
        setFocusTraversalPolicy(new FocusPolicy(list));
    }
}
