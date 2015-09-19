package br.com.antoniosergius.chequemate.gui.dialog.query;

import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.report.ReportFactory;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.chequemate.util.MyPath;
import br.com.antoniosergius.lib.tools.Days;
import java.awt.Cursor;
import java.awt.Frame;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ReportByClientAndInputDate extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ReportByClientAndInputDate.class.getName());

    private Connection conn;
    private ClientController clientControl;
    private ChequeMateException exception = new ChequeMateException();
    
    public ReportByClientAndInputDate(Frame parent, boolean modal, Connection conn) {
        super(parent, modal);
        this.conn = conn;
        clientControl = new ClientController(conn);
        initComponents();
        setupComponents("Selecione a Data de Entrada dos Cheques e o Cliente:");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanelPaiRelatorios = new org.jdesktop.swingx.JXPanel();
        jXLabelImagem = new org.jdesktop.swingx.JXLabel();
        jButtonGerarRelatorio = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        labelDescription = new org.jdesktop.swingx.JXLabel();
        comboBox = new javax.swing.JComboBox();
        datePickerInput = new org.jdesktop.swingx.JXDatePicker();
        jLabelData = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jXHeader = new org.jdesktop.swingx.JXHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jXLabelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x48.report.png"))); // NOI18N
        jXLabelImagem.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButtonGerarRelatorio.setText("Gerar");
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        labelDescription.setText("Texto descritivo:");

        comboBox.setEditable(true);

        datePickerInput.setFormats(new String[]{"dd/MM/yyyy"});

        jLabelData.setText("Data de Entrada:");

        jLabelCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCliente.setText("Cliente:");

        jXHeader.setDescription("");
        jXHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.report.png"))); // NOI18N
        jXHeader.setTitle("Gerador de Relatório");
        jXHeader.setToolTipText("");

        javax.swing.GroupLayout jXPanelPaiRelatoriosLayout = new javax.swing.GroupLayout(jXPanelPaiRelatorios);
        jXPanelPaiRelatorios.setLayout(jXPanelPaiRelatoriosLayout);
        jXPanelPaiRelatoriosLayout.setHorizontalGroup(
            jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanelPaiRelatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanelPaiRelatoriosLayout.createSequentialGroup()
                        .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addGroup(jXPanelPaiRelatoriosLayout.createSequentialGroup()
                        .addComponent(jXLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jXPanelPaiRelatoriosLayout.createSequentialGroup()
                                .addGroup(jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelData)
                                    .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBox, 0, 253, Short.MAX_VALUE)
                                    .addComponent(datePickerInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
            .addComponent(jXHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jXPanelPaiRelatoriosLayout.setVerticalGroup(
            jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanelPaiRelatoriosLayout.createSequentialGroup()
                .addComponent(jXHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanelPaiRelatoriosLayout.createSequentialGroup()
                        .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePickerInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelData))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox)
                            .addComponent(jLabelCliente)))
                    .addComponent(jXLabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jXPanelPaiRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGerarRelatorio)
                    .addComponent(jButtonCancelar))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXPanelPaiRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanelPaiRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed
        try {
            validateAndShow();
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
            LOG.warning(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBox;
    private org.jdesktop.swingx.JXDatePicker datePickerInput;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelData;
    private org.jdesktop.swingx.JXHeader jXHeader;
    private org.jdesktop.swingx.JXLabel jXLabelImagem;
    private org.jdesktop.swingx.JXPanel jXPanelPaiRelatorios;
    private org.jdesktop.swingx.JXLabel labelDescription;
    // End of variables declaration//GEN-END:variables

     private void setupComponents(String descricao) {
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.report.color.png")).getImage());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Relátorio");
        labelDescription.setText(descricao);
        setupComboBox();
        
        AutoCompleteDecorator.decorate(comboBox);
        comboBox.requestFocusInWindow();
        datePickerInput.setDate(Days.TODAY.getTime());
        JXMonthView monthView = datePickerInput.getMonthView();
        monthView.setUpperBound(Days.TODAY.getTime());
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

    private boolean viewReport(int id, GregorianCalendar inputDate) {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
        ReportFactory report = new ReportFactory(conn, id);
        boolean isDone = true;
        try {
            report.viewByInputDate(MyPath.REPORTS+"ChequesDataEntradaCliente.jasper", inputDate);
        } catch (SQLException | JRException | IOException ex) {
            ChequeMate.showErrorMessage(this, ex.getMessage());
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            isDone = false;
        } finally {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        return isDone;
    }

    private void validateAndShow() throws ChequeMateException {
        ChequeMateException ex = exception;
        Date date = datePickerInput.getDate();
        if (date == null) {
            throw ex.retrieve("Favor preencher a data de entrada dos cheques.", datePickerInput);
        }
        GregorianCalendar input = new GregorianCalendar();
        input.setTime(date);
        if (comboBox.getSelectedIndex() == -1) {
            throw ex.retrieve("Favor escolher o cliente.", comboBox);
        }
        String client = (String) comboBox.getSelectedItem();
        int id = Client.getId(client, Client.ID_SUFFIX);
        if(viewReport(id, input)) {
            dispose();
        }
    }
    
}
