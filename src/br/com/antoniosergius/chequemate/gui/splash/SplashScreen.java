package br.com.antoniosergius.chequemate.gui.splash;

import br.com.antoniosergius.chequemate.gui.MainFrame;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

public class SplashScreen extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(SplashScreen.class.getName());
    
    public SplashScreen() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.chequemate.png")).getImage());
        try {
            imageView.setImage(getClass().getResource("background.png"));
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        imageView = new org.jdesktop.swingx.JXImageView();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelMain.setBackground(new java.awt.Color(0, 0, 0));
        panelMain.setOpaque(false);
        panelMain.setPaintBorderInsets(false);

        imageView.setEditable(false);

        progressBar.setBorderPainted(false);
        progressBar.setIndeterminate(true);

        javax.swing.GroupLayout imageViewLayout = new javax.swing.GroupLayout(imageView);
        imageView.setLayout(imageViewLayout);
        imageViewLayout.setHorizontalGroup(
            imageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
        imageViewLayout.setVerticalGroup(
            imageViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imageViewLayout.createSequentialGroup()
                .addGap(0, 438, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(imageView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        ChequeMate.readPreferences();
        boolean showSplashScreen = ChequeMate.getPreferences().isShowSplashScreen();
        if (showSplashScreen) {
            final SplashScreen splash = new SplashScreen();
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.CremeSkin");
                    splash.setVisible(true);
                }
            });
            try {
                Thread.sleep(1800);
            } catch (InterruptedException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            } finally {
                splash.dispose();
            }    
        }
        MainFrame.init();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXImageView imageView;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
