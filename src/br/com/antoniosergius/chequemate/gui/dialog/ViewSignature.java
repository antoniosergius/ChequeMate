package br.com.antoniosergius.chequemate.gui.dialog;

public class ViewSignature extends javax.swing.JDialog {

   public ViewSignature(java.awt.Frame parent, boolean modal) {
      super(parent, modal);
      initComponents();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      panelMain = new org.jdesktop.swingx.JXPanel();
      header = new org.jdesktop.swingx.JXHeader();
      toolBar = new javax.swing.JToolBar();
      buttonImprimir = new org.jdesktop.swingx.JXButton();
      jXButton2 = new org.jdesktop.swingx.JXButton();
      jXButton3 = new org.jdesktop.swingx.JXButton();
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

      jXButton2.setText("jXButton2");
      jXButton2.setFocusable(false);
      jXButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      jXButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(jXButton2);

      jXButton3.setText("jXButton3");
      jXButton3.setFocusable(false);
      jXButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      jXButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(jXButton3);
      toolBar.add(jSeparator1);

      jXButton4.setText("jXButton4");
      jXButton4.setFocusable(false);
      jXButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      jXButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(ViewSignature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(ViewSignature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(ViewSignature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(ViewSignature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the dialog */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            ViewSignature dialog = new ViewSignature(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
               @Override
               public void windowClosing(java.awt.event.WindowEvent e) {
                  System.exit(0);
               }
            });
            dialog.setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private org.jdesktop.swingx.JXButton buttonImprimir;
   private org.jdesktop.swingx.JXHeader header;
   private javax.swing.JToolBar.Separator jSeparator1;
   private org.jdesktop.swingx.JXButton jXButton2;
   private org.jdesktop.swingx.JXButton jXButton3;
   private org.jdesktop.swingx.JXButton jXButton4;
   private org.jdesktop.swingx.JXImageView jXImageView1;
   private org.jdesktop.swingx.JXPanel panelMain;
   private javax.swing.JToolBar toolBar;
   // End of variables declaration//GEN-END:variables
}
