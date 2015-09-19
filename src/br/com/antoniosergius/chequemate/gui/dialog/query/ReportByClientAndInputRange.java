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

public class ReportByClientAndInputRange extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ReportByClientAndInputRange.class.getName());

    private Connection conn;
    private ClientController clientControl;
    private ChequeMateException exception = new ChequeMateException();
    
    public ReportByClientAndInputRange(Frame parent, boolean modal, Connection conn) {
        super(parent, modal);
        this.conn = conn;
        clientControl = new ClientController(conn);
        initComponents();
        setupComponents("Selecione o Intervalo de Entrada dos Cheques e o Cliente:");  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        panelMain = new org.jdesktop.swingx.JXPanel();
        labelImage = new org.jdesktop.swingx.JXLabel();
        buttonGenerate = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelDescription = new org.jdesktop.swingx.JXLabel();
        comboBox = new javax.swing.JComboBox();
        datePickerInputBegin = new org.jdesktop.swingx.JXDatePicker();
        labelFromDay = new javax.swing.JLabel();
        labelToDay = new javax.swing.JLabel();
        datePickerInputEnd = new org.jdesktop.swingx.JXDatePicker();
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

        datePickerInputBegin.setFormats(new String[]{"dd/MM/yyyy"});

        labelFromDay.setText("Do dia:");

        labelToDay.setText("até o dia:");

        datePickerInputEnd.setFormats(new String[]{"dd/MM/yyyy"});

        labelClient.setText("Cliente: ");

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
                        .addComponent(buttonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFromDay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelClient))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addComponent(datePickerInputBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelToDay, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(datePickerInputEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))))
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonCancel, buttonGenerate});

        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFromDay)
                            .addComponent(datePickerInputBegin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelToDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datePickerInputEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBox)
                            .addComponent(labelClient, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        try {
            validateAndShow();
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
            LOG.warning(ex.getMessage());
        }
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JComboBox comboBox;
    private org.jdesktop.swingx.JXDatePicker datePickerInputBegin;
    private org.jdesktop.swingx.JXDatePicker datePickerInputEnd;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel labelClient;
    private org.jdesktop.swingx.JXLabel labelDescription;
    private javax.swing.JLabel labelFromDay;
    private org.jdesktop.swingx.JXLabel labelImage;
    private javax.swing.JLabel labelToDay;
    private org.jdesktop.swingx.JXPanel panelMain;
    private org.jdesktop.swingx.VerticalLayout verticalLayout1;
    // End of variables declaration//GEN-END:variables

    private void setupComponents(String description) {
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.report.color.png")).getImage());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Relátorio");
        
        labelDescription.setText(description);
        setupComboBox();
        
        AutoCompleteDecorator.decorate(comboBox);
        comboBox.requestFocus();
        datePickerInputEnd.setDate(new Date());
        JXMonthView monthView = datePickerInputBegin.getMonthView();
        monthView.setUpperBound(Days.TODAY.getTime());
        
        JXMonthView monthViewFim = datePickerInputEnd.getMonthView();
        monthViewFim.setUpperBound(Days.TODAY.getTime());
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
    
    private boolean viewReport(int id, GregorianCalendar begin, GregorianCalendar end) {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        ReportFactory report = new ReportFactory(conn, id);
        boolean isDone = true;
        try {
            report.viewByInputRange(MyPath.REPORTS+"ChequesIntervaloDataEntradaCliente.jasper", begin, end);
        } catch (SQLException | JRException | IOException ex) {
            ChequeMate.showErrorMessage(this, ex.getMessage());
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            isDone = false;
        } finally {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return isDone;
        }
    }
    
    private void validateAndShow() throws ChequeMateException {
        ChequeMateException ex = exception;
        Date beginDate = datePickerInputBegin.getDate();
        if (beginDate == null) {
            throw ex.retrieve("Favor preencher a data inicial do intervalo.", datePickerInputBegin);
        }
        Date endDate = datePickerInputEnd.getDate();
        if (endDate == null) {
            throw ex.retrieve("Favor preencher a data final do intervalo.", datePickerInputEnd);
        }
        GregorianCalendar begin = new GregorianCalendar();
        GregorianCalendar end = new GregorianCalendar();
        begin.setTime(beginDate);
        end.setTime(endDate);
        if (comboBox.getSelectedIndex() == -1) {
            throw ex.retrieve("Favor escolher o cliente.", comboBox);
        }
        String client = (String) comboBox.getSelectedItem();
        int id = Client.getId(client, Client.ID_SUFFIX);
        if (viewReport(id, begin, end)) {
            dispose();
        }
    }
}
