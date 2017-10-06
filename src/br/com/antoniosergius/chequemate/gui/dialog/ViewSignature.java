package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.obj.PayeeExt;
import java.sql.Connection;
import javax.swing.ImageIcon;

public class ViewSignature extends javax.swing.JDialog {

   private Connection conn;
   private PayeeController payeeControl;
   private PayeeExt payee;
   
   public ViewSignature(java.awt.Frame parent, boolean modal, Connection conn, PayeeExt payee) {
      super(parent, modal);
      this.conn = conn;
      this.payee = payee;
      payeeControl = new PayeeController(conn);
      initComponents();
      setupComponents();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      panelMain = new org.jdesktop.swingx.JXPanel();
      header = new org.jdesktop.swingx.JXHeader();
      toolBar = new javax.swing.JToolBar();
      buttonImprimir = new org.jdesktop.swingx.JXButton();
      separador1 = new javax.swing.JToolBar.Separator();
      buttonAdicionar = new org.jdesktop.swingx.JXButton();
      buttonRemover = new org.jdesktop.swingx.JXButton();
      buttonSubstituir = new org.jdesktop.swingx.JXButton();
      buttonEscanear = new org.jdesktop.swingx.JXButton();
      separador2 = new javax.swing.JToolBar.Separator();
      buttonSair = new org.jdesktop.swingx.JXButton();
      imageView = new org.jdesktop.swingx.JXImageView();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      header.setDescriptionFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
      header.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

      toolBar.setFloatable(false);
      toolBar.setRollover(true);

      buttonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.print.png"))); // NOI18N
      buttonImprimir.setText("Imprimir");
      buttonImprimir.setToolTipText("Imprimir");
      buttonImprimir.setFocusable(false);
      buttonImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(buttonImprimir);
      toolBar.add(separador1);

      buttonAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.add.png"))); // NOI18N
      buttonAdicionar.setText("Adicionar");
      buttonAdicionar.setToolTipText("Adicionar");
      buttonAdicionar.setFocusable(false);
      buttonAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(buttonAdicionar);

      buttonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.remove.png"))); // NOI18N
      buttonRemover.setText("Remover");
      buttonRemover.setToolTipText("Remover");
      buttonRemover.setFocusable(false);
      buttonRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(buttonRemover);

      buttonSubstituir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.openimage.png"))); // NOI18N
      buttonSubstituir.setText("Substituir");
      buttonSubstituir.setToolTipText("Substituir");
      buttonSubstituir.setFocusable(false);
      buttonSubstituir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonSubstituir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(buttonSubstituir);

      buttonEscanear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.printer.png"))); // NOI18N
      buttonEscanear.setText("Escanear");
      buttonEscanear.setToolTipText("Escanear");
      buttonEscanear.setFocusable(false);
      buttonEscanear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonEscanear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(buttonEscanear);
      toolBar.add(separador2);

      buttonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.exit.png"))); // NOI18N
      buttonSair.setText("Sair");
      buttonSair.setToolTipText("Sair");
      buttonSair.setFocusable(false);
      buttonSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      buttonSair.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonSairActionPerformed(evt);
         }
      });
      toolBar.add(buttonSair);

      javax.swing.GroupLayout imageViewLayout = new javax.swing.GroupLayout(imageView);
      imageView.setLayout(imageViewLayout);
      imageViewLayout.setHorizontalGroup(
         imageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 0, Short.MAX_VALUE)
      );
      imageViewLayout.setVerticalGroup(
         imageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 319, Short.MAX_VALUE)
      );

      javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
      panelMain.setLayout(panelMainLayout);
      panelMainLayout.setHorizontalGroup(
         panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
         .addComponent(imageView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      panelMainLayout.setVerticalGroup(
         panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelMainLayout.createSequentialGroup()
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(imageView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 6, Short.MAX_VALUE))
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

   private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
      dispose();
   }//GEN-LAST:event_buttonSairActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private org.jdesktop.swingx.JXButton buttonAdicionar;
   private org.jdesktop.swingx.JXButton buttonEscanear;
   private org.jdesktop.swingx.JXButton buttonImprimir;
   private org.jdesktop.swingx.JXButton buttonRemover;
   private org.jdesktop.swingx.JXButton buttonSair;
   private org.jdesktop.swingx.JXButton buttonSubstituir;
   private org.jdesktop.swingx.JXHeader header;
   private org.jdesktop.swingx.JXImageView imageView;
   private org.jdesktop.swingx.JXPanel panelMain;
   private javax.swing.JToolBar.Separator separador1;
   private javax.swing.JToolBar.Separator separador2;
   private javax.swing.JToolBar toolBar;
   // End of variables declaration//GEN-END:variables

   private void setupComponents() {
      setTitle("Assinatura");
      setIconImage(new ImageIcon(getClass().getResource("/img/x16.signature.png")).getImage());
      header.setTitle(payee.getName());
      setLocationRelativeTo(null);
   }
}
