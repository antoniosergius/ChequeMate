package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.lib.util.io.Configuration;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;

public class AlterLookAndFeel extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(AlterLookAndFeel.class.getName());

    private LookAndFeel current;
    private HashMap<String, String> map = new HashMap<>();
    private String clazz;
    private String name;

    
    @SuppressWarnings("unchecked")
    public AlterLookAndFeel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        DefaultListModel<String> modelList = new DefaultListModel<>();
        for (SkinInfo info : SubstanceLookAndFeel.getAllSkins().values()) {
            modelList.addElement(info.getDisplayName());
            map.put(info.getDisplayName(), info.getClassName());
        }
        
        listTemas.setModel(modelList);
        current = UIManager.getLookAndFeel();
        name = current.getName();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPadrao = new javax.swing.JButton();
        buttonAplicar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        scrollPaneTemas = new javax.swing.JScrollPane();
        listTemas = new javax.swing.JList();
        header = new org.jdesktop.swingx.JXHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aparência");
        setModal(true);
        setResizable(false);

        buttonPadrao.setText("Padrão");
        buttonPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPadraoActionPerformed(evt);
            }
        });

        buttonAplicar.setText("Salvar");
        buttonAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAplicarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        listTemas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listTemas.setToolTipText("Só clique em um tema se tiver certeza. A mudança será instantânea.");
        listTemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listTemasMouseReleased(evt);
            }
        });
        scrollPaneTemas.setViewportView(listTemas);

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.laf.png"))); // NOI18N
        header.setTitle("Escolha o tema:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneTemas))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonAplicar, buttonCancelar, buttonPadrao});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPadrao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listTemasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTemasMouseReleased
        String element = (String) listTemas.getSelectedValue();
        if (this.name.equals(element)) {
            return;
        }
        this.name = element;
        this.clazz = this.map.get(element);
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SubstanceLookAndFeel.setSkin(clazz);
            }
        });
    }//GEN-LAST:event_listTemasMouseReleased

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPadraoActionPerformed
       int choice = JOptionPane.showConfirmDialog(this, "O tema padrão requer reinicialização do sistema. Confirma a escolha?",
           "Aviso",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       if (choice == JOptionPane.YES_OPTION) {
           ChequeMate.getConfiguration().setLookAndFeel(
                   new br.com.antoniosergius.lib.gui.utils.LookAndFeel("Windows"));
           try {
                ChequeMate.XSTREAM.write(ChequeMate.getConfiguration());
                dispose();
            } catch (IOException ex) {
                ChequeMate.showErrorMessage(this, "Não foi possível gravar o arquivo de configuração");
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }//GEN-LAST:event_buttonPadraoActionPerformed

    private void buttonAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAplicarActionPerformed
        aplicar();
    }//GEN-LAST:event_buttonAplicarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAplicar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonPadrao;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JList listTemas;
    private javax.swing.JScrollPane scrollPaneTemas;
    // End of variables declaration//GEN-END:variables

    private void aplicar() {
        Configuration configuration = ChequeMate.getConfiguration();
        String element = (String) listTemas.getSelectedValue();
        clazz = map.get(element);
        configuration.setLookAndFeel(new br.com.antoniosergius.lib.gui.utils.LookAndFeel(clazz));
        try {
            ChequeMate.XSTREAM.write(configuration);
            dispose();
        } catch (IOException ex) {
            ChequeMate.showErrorMessage(this, "Não foi possível gravar o arquivo de configuração");
            LOG.log(Level.WARNING, ex.getMessage(), ex);
        }
    }
}
