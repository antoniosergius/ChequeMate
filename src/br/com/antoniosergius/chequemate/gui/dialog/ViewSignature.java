package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.obj.PayeeExt;
import java.sql.Connection;

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
      jSeparator1 = new javax.swing.JToolBar.Separator();
      jXButton4 = new org.jdesktop.swingx.JXButton();
      jXImageView1 = new org.jdesktop.swingx.JXImageView();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      toolBar.setRollover(true);

      buttonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.print.png"))); // NOI18N
      buttonImprimir.setFocusable(false);
      buttonImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(buttonImprimir);
      toolBar.add(jSeparator1);

      jXButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.exit.png"))); // NOI18N
      jXButton4.setFocusable(false);
      jXButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      jXButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      jXButton4.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jXButton4ActionPerformed(evt);
         }
      });
      toolBar.add(jXButton4);

      javax.swing.GroupLayout jXImageView1Layout = new javax.swing.GroupLayout(jXImageView1);
      jXImageView1.setLayout(jXImageView1Layout);
      jXImageView1Layout.setHorizontalGroup(
         jXImageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 0, Short.MAX_VALUE)
      );
      jXImageView1Layout.setVerticalGroup(
         jXImageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 319, Short.MAX_VALUE)
      );

      javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
      panelMain.setLayout(panelMainLayout);
      panelMainLayout.setHorizontalGroup(
         panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
         .addComponent(jXImageView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      panelMainLayout.setVerticalGroup(
         panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelMainLayout.createSequentialGroup()
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jXImageView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 40, Short.MAX_VALUE))
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

   private void jXButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton4ActionPerformed
      dispose();
   }//GEN-LAST:event_jXButton4ActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private org.jdesktop.swingx.JXButton buttonImprimir;
   private org.jdesktop.swingx.JXHeader header;
   private javax.swing.JToolBar.Separator jSeparator1;
   private org.jdesktop.swingx.JXButton jXButton4;
   private org.jdesktop.swingx.JXImageView jXImageView1;
   private org.jdesktop.swingx.JXPanel panelMain;
   private javax.swing.JToolBar toolBar;
   // End of variables declaration//GEN-END:variables

   private void setupComponents() {
      header.setTitle(payee.getName());
      setLocationRelativeTo(null);
   }
}
