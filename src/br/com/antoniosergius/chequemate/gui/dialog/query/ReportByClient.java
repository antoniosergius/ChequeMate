package br.com.antoniosergius.chequemate.gui.dialog.query;

import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.report.ReportFactory;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.MyPath;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ReportByClient extends javax.swing.JDialog {
    private static final Logger LOG = Logger.getLogger(ReportByClient.class.getName());
    private static final long serialVersionUID = 1L;

    private String jasperFile;
    private Connection conn;
    private ClientController clientControl;

    public ReportByClient(Frame parent, boolean modal, Connection conn, String description) {
        super(parent, modal);
        this.conn = conn;
        clientControl = new ClientController(conn);
        this.jasperFile = MyPath.REPORTS+"ChequesPorCliente.jasper";
        initComponents();
        setupComponents(description);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        labelImage = new org.jdesktop.swingx.JXLabel();
        buttonGenerate = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelDescription = new org.jdesktop.swingx.JXLabel();
        comboBox = new javax.swing.JComboBox();
        labelClient = new javax.swing.JLabel();
        header = new org.jdesktop.swingx.JXHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x48.report.png"))); // NOI18N
        labelImage.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        buttonGenerate.setText("Gerar");
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        labelDescription.setText("Texto descritivo:");

        comboBox.setEditable(true);
        comboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboBoxKeyReleased(evt);
            }
        });

        labelClient.setText("Cliente:");

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.report.png"))); // NOI18N
        header.setTitle("Gerador de Relatório");
        header.setToolTipText("");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                .addComponent(labelClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(buttonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonCancel, buttonGenerate});

        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(labelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBox)
                            .addComponent(labelClient, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGenerate)
                    .addComponent(buttonCancel))
                .addContainerGap())
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

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if(viewReport()) {
            dispose();
        }
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void comboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBoxKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if (viewReport()) {
                dispose();
            }
        }
    }//GEN-LAST:event_comboBoxKeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JComboBox comboBox;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel labelClient;
    private org.jdesktop.swingx.JXLabel labelDescription;
    private org.jdesktop.swingx.JXLabel labelImage;
    private org.jdesktop.swingx.JXPanel panelMain;
    // End of variables declaration//GEN-END:variables

    private void setupComponents(String description) {
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.report.color.png")).getImage());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Relatório");
        
        labelDescription.setText(description);
        setupComboBox();
        
        AutoCompleteDecorator.decorate(comboBox);
        comboBox.requestFocusInWindow();
    }
    
    @SuppressWarnings("unchecked")
    private void setupComboBox() {
        comboBox.removeAllItems();
        ArrayList<String> list;
        try {
            list = clientControl.getNameList();
        } catch (SQLException ex) {
            LOG.warning(ex.getMessage());
            return;
        }
        int size = list.size();
        Collections.sort(list);
        for (int i=0; i<size; i++) {
            comboBox.addItem(list.get(i));
        }
        comboBox.setSelectedIndex(-1);
    }

    private boolean viewReport() {
        if (comboBox.getSelectedIndex() == -1) {
            return false;
        }
        String client = (String) comboBox.getSelectedItem();
        int id = Client.getId(client, Client.ID_SUFFIX);
        
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
        ReportFactory report = new ReportFactory(conn, id);
        boolean isDone = true;
        try {
            report.view(jasperFile);
        } catch (SQLException | JRException | IOException ex) {
            ChequeMate.showErrorMessage(this, ex.getMessage());
            LOG.log(Level.WARNING, ex.getMessage(), ex);
            isDone = false;
        } finally {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        return isDone;
    }
    
}
