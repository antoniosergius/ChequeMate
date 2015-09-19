package br.com.antoniosergius.chequemate.gui.dialog.query;

import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.lib.tools.Days;
import java.awt.Frame;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JDialog;
import javax.swing.KeyStroke;

public class QueryByInputDate extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;

    
    private GregorianCalendar input;
    private boolean isCanceled = false;
    
    public QueryByInputDate(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDesenho = new javax.swing.JLabel();
        jLabelExplicacao = new javax.swing.JLabel();
        buttonQuery = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        datePickerInput = new org.jdesktop.swingx.JXDatePicker();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ChequeMate - Consulta");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelDesenho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDesenho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x32.date.png"))); // NOI18N
        jLabelDesenho.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelExplicacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExplicacao.setText("Data:");

        buttonQuery.setText("Consultar");
        buttonQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQueryActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        datePickerInput.setFormats(new String[]{"dd/MM/yyyy"});

        jXHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.report.png"))); // NOI18N
        jXHeader1.setTitle("Consulta por Data de Entrada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXHeader1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelExplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datePickerInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(datePickerInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelExplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonQuery)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQueryActionPerformed
        query();
    }//GEN-LAST:event_buttonQueryActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        isCanceled = true;
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        isCanceled = true;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonQuery;
    private org.jdesktop.swingx.JXDatePicker datePickerInput;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelDesenho;
    private javax.swing.JLabel jLabelExplicacao;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    // End of variables declaration//GEN-END:variables

    private void query() {
        Date date = datePickerInput.getDate();
        GregorianCalendar inputDate = new GregorianCalendar();
        inputDate.setTime(date);
        input = inputDate;
        dispose();
    }
    
    public GregorianCalendar getInputDate() {
        return input;
    }

    public void setInputDate(GregorianCalendar input) {
        this.input = input;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        this.isCanceled = canceled;
    }

    private void setupComponents() {
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.date.png")).getImage());
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        datePickerInput.setDate(null);
        datePickerInput.setEditable(false);
        datePickerInput.getMonthView().setEnabled(true);
        datePickerInput.getMonthView().setUpperBound(Days.TODAY.getTime());
        datePickerInput.getMonthView().setLowerBound(ChequeMate.getMinInputDate().getTime());
        InputMap im = buttonQuery.getInputMap();
        im.put( KeyStroke.getKeyStroke( "ENTER" ), "pressed" );
        im.put( KeyStroke.getKeyStroke( "released ENTER" ), "released" );
    }
    
}
