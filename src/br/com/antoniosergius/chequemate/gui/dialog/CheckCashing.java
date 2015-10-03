package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.gui.utils.CashingTableModel;
import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.chequemate.obj.Parameters;
import br.com.antoniosergius.chequemate.obj.record.RecordCashing;
import br.com.antoniosergius.chequemate.report.ReportFactory;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.chequemate.util.MyPath;
import br.com.antoniosergius.chequemate.util.io.CashingFile;
import br.com.antoniosergius.chequemate.util.tools.Compare;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.util.io.Serialize;
import br.com.antoniosergius.lib.verif.MoneyVerifier;
import br.com.antoniosergius.lib.verif.PercentVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

public class CheckCashing extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(CheckCashing.class.getName());

    private RecordCashing record;
    private CashingTableModel model;
    private ChequeMateException exception = new ChequeMateException();
    
    public CheckCashing(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        record = new RecordCashing();
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupTableMenu = new javax.swing.JPopupMenu();
        menuItemRemoveRow = new javax.swing.JMenuItem();
        panelMain = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        toolbar = new javax.swing.JToolBar();
        buttonNew = new org.jdesktop.swingx.JXButton();
        buttonPrint = new org.jdesktop.swingx.JXButton();
        buttonRefresh = new org.jdesktop.swingx.JXButton();
        separator = new javax.swing.JToolBar.Separator();
        buttonClose = new org.jdesktop.swingx.JXButton();
        scrollPane = new javax.swing.JScrollPane();
        tableCashing = new javax.swing.JTable();
        panelCheck = new org.jdesktop.swingx.JXPanel();
        labelGross = new javax.swing.JLabel();
        textFieldValue = new javax.swing.JTextField();
        labelDate = new javax.swing.JLabel();
        formattedTextFieldExpiration = new javax.swing.JFormattedTextField();
        panelRate = new org.jdesktop.swingx.JXPanel();
        textFieldRate = new javax.swing.JTextField();
        labelPorcentagem = new org.jdesktop.swingx.JXLabel();
        panelSum = new org.jdesktop.swingx.JXPanel();
        labelGrossAmount = new javax.swing.JLabel();
        labelGrossDynamic = new javax.swing.JLabel();
        labelNetDynamic = new javax.swing.JLabel();
        labelNetAmount = new javax.swing.JLabel();
        labelRetention = new javax.swing.JLabel();
        labelRetentionDynamic = new javax.swing.JLabel();
        labelError = new org.jdesktop.swingx.JXLabel();

        menuItemRemoveRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.remove.png"))); // NOI18N
        menuItemRemoveRow.setText("Apagar linha(s)");
        menuItemRemoveRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRemoveRowActionPerformed(evt);
            }
        });
        popupTableMenu.add(menuItemRemoveRow);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        header.setToolTipText("");
        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.cash.png"))); // NOI18N
        header.setTitle("Cálculo de Desconto de Cheques");

        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        buttonNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.new.png"))); // NOI18N
        buttonNew.setToolTipText("Novo Cálculo de Desconto");
        buttonNew.setFocusable(false);
        buttonNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });
        toolbar.add(buttonNew);

        buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.print.png"))); // NOI18N
        buttonPrint.setToolTipText("Imprimir");
        buttonPrint.setFocusable(false);
        buttonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });
        toolbar.add(buttonPrint);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.refresh.png"))); // NOI18N
        buttonRefresh.setToolTipText("Atualizar Valores da Tabela");
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        toolbar.add(buttonRefresh);
        toolbar.add(separator);

        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.exit.png"))); // NOI18N
        buttonClose.setToolTipText("Fechar Cálculo de Descontos");
        buttonClose.setFocusable(false);
        buttonClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        toolbar.add(buttonClose);

        tableCashing.setModel(new CashingTableModel());
        tableCashing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCashingMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCashingMouseReleased(evt);
            }
        });
        scrollPane.setViewportView(tableCashing);

        panelCheck.setBorder(javax.swing.BorderFactory.createTitledBorder("Cheque"));

        labelGross.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGross.setText("Valor");

        labelDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDate.setText("Data");

        try {
            formattedTextFieldExpiration.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldExpiration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formattedTextFieldExpiration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formattedTextFieldExpirationFocusGained(evt);
            }
        });
        formattedTextFieldExpiration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formattedTextFieldExpirationKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelCheckLayout = new javax.swing.GroupLayout(panelCheck);
        panelCheck.setLayout(panelCheckLayout);
        panelCheckLayout.setHorizontalGroup(
            panelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGross, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedTextFieldExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCheckLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {formattedTextFieldExpiration, labelDate, labelGross, textFieldValue});

        panelCheckLayout.setVerticalGroup(
            panelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCheckLayout.createSequentialGroup()
                .addGroup(panelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGross)
                    .addComponent(labelDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCheckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedTextFieldExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        panelCheckLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {formattedTextFieldExpiration, labelDate, labelGross, textFieldValue});

        panelRate.setBorder(javax.swing.BorderFactory.createTitledBorder("Taxa"));

        textFieldRate.setText("5,00");
        textFieldRate.setToolTipText("");

        labelPorcentagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPorcentagem.setText("Porcentagem");

        javax.swing.GroupLayout panelRateLayout = new javax.swing.GroupLayout(panelRate);
        panelRate.setLayout(panelRateLayout);
        panelRateLayout.setHorizontalGroup(
            panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPorcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(textFieldRate))
                .addContainerGap())
        );
        panelRateLayout.setVerticalGroup(
            panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRateLayout.createSequentialGroup()
                .addComponent(labelPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelRateLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelPorcentagem, textFieldRate});

        labelGrossAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelGrossAmount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGrossAmount.setText("Total Valor Bruto: ");

        labelGrossDynamic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelGrossDynamic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelNetDynamic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNetDynamic.setForeground(new java.awt.Color(255, 51, 51));
        labelNetDynamic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelNetAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNetAmount.setForeground(new java.awt.Color(255, 51, 51));
        labelNetAmount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNetAmount.setText("Total Valor Líquido:");

        labelRetention.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelRetention.setForeground(new java.awt.Color(50, 156, 106));
        labelRetention.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRetention.setText("Retenção:");

        labelRetentionDynamic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelRetentionDynamic.setForeground(new java.awt.Color(50, 156, 106));
        labelRetentionDynamic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelError.setForeground(new java.awt.Color(255, 51, 51));
        labelError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelError.setTextAlignment(null);

        javax.swing.GroupLayout panelSumLayout = new javax.swing.GroupLayout(panelSum);
        panelSum.setLayout(panelSumLayout);
        panelSumLayout.setHorizontalGroup(
            panelSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNetAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGrossAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRetention, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelGrossDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNetDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRetentionDynamic, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelSumLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelGrossDynamic, labelNetDynamic, labelRetentionDynamic});

        panelSumLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelGrossAmount, labelNetAmount, labelRetention});

        panelSumLayout.setVerticalGroup(
            panelSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelGrossAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGrossDynamic, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNetAmount)
                    .addComponent(labelNetDynamic, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRetentionDynamic, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRetention))
                .addContainerGap())
        );

        panelSumLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelError, labelGrossDynamic, labelNetDynamic, labelRetentionDynamic});

        panelSumLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelGrossAmount, labelNetAmount, labelRetention});

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(panelCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelSum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void formattedTextFieldExpirationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formattedTextFieldExpirationKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER && !isToday()) {
            try {
                addTableCashing(getCashingFromForm());
                clearForm();
            } catch (ChequeMateException ex) {
                LOG.log(Level.WARNING, ex.getMessage(), ex);
                ex.showExceptionMessage(labelError);
                new Thread(new EraseErrorLabel()).start();
            }
        } 
    }//GEN-LAST:event_formattedTextFieldExpirationKeyReleased

    private void formattedTextFieldExpirationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formattedTextFieldExpirationFocusGained
        if (isToday()) {
            formattedTextFieldExpiration.setCaretPosition(0);
        }
    }//GEN-LAST:event_formattedTextFieldExpirationFocusGained

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        newCashingCheck();
    }//GEN-LAST:event_buttonNewActionPerformed

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    printCashingCheck();
                } catch (ChequeMateException ex) {
                    LOG.log(Level.WARNING, ex.getMessage(), ex);
                    ex.showExceptionMessage();
                } 
            }
        });
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                exitForm();
            }
        });
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void menuItemRemoveRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRemoveRowActionPerformed
        int row = tableCashing.getSelectedRow();
        if (row != -1) {
            model.remove(row);
            record.getList().remove(row);
            record.updateAmount();
            updateValueLabels();
        }
    }//GEN-LAST:event_menuItemRemoveRowActionPerformed

    private void tableCashingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCashingMouseReleased
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int rowNumber = tableCashing.rowAtPoint( p );
            if (rowNumber != -1) {
                tableCashing.setRowSelectionInterval(rowNumber, rowNumber);
                if (evt.isPopupTrigger()) {
                    popupTableMenu.show(tableCashing, evt.getX(), evt.getY());
                }
            }    
        }    
    }//GEN-LAST:event_tableCashingMouseReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                exitForm();
            }
        });
    }//GEN-LAST:event_formWindowClosing

    private void tableCashingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCashingMouseClicked
        if (evt.getClickCount() == 2) {
            editRow();
        }
    }//GEN-LAST:event_tableCashingMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton buttonClose;
    private org.jdesktop.swingx.JXButton buttonNew;
    private org.jdesktop.swingx.JXButton buttonPrint;
    private org.jdesktop.swingx.JXButton buttonRefresh;
    private javax.swing.JFormattedTextField formattedTextFieldExpiration;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel labelDate;
    private org.jdesktop.swingx.JXLabel labelError;
    private javax.swing.JLabel labelGross;
    private javax.swing.JLabel labelGrossAmount;
    private javax.swing.JLabel labelGrossDynamic;
    private javax.swing.JLabel labelNetAmount;
    private javax.swing.JLabel labelNetDynamic;
    private org.jdesktop.swingx.JXLabel labelPorcentagem;
    private javax.swing.JLabel labelRetention;
    private javax.swing.JLabel labelRetentionDynamic;
    private javax.swing.JMenuItem menuItemRemoveRow;
    private org.jdesktop.swingx.JXPanel panelCheck;
    private org.jdesktop.swingx.JXPanel panelMain;
    private org.jdesktop.swingx.JXPanel panelRate;
    private org.jdesktop.swingx.JXPanel panelSum;
    private javax.swing.JPopupMenu popupTableMenu;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JToolBar.Separator separator;
    private javax.swing.JTable tableCashing;
    private javax.swing.JTextField textFieldRate;
    private javax.swing.JTextField textFieldValue;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables
    
    
    private void setupComponents() {
        setLocationRelativeTo(null);
        setTitle("Calculadora de Descontos");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.cash.png")).getImage());

        formattedTextFieldExpiration.setFocusLostBehavior(JFormattedTextField.COMMIT);
        formattedTextFieldExpiration.setText(Format.todayDate("dd/MM/yy"));
        textFieldRate.setText(Format.decimal(ChequeMate.getPreferences().getDefaultRate()));
       
        Verifier.set(textFieldRate, new PercentVerifier());
        Verifier.set(textFieldValue, new MoneyVerifier());
        
        setupFocusComponents();
        setupTableComponents();    
        try {
            readFile();
        } catch (IOException | ClassNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    private void setupFocusComponents() {
        FocusPolicy.setDefaultTrasversalKeys(panelCheck, FocusPolicy.BOTH_DIRECTIONS);
        
        formattedTextFieldExpiration.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, 
                KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalKeys(
                KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldValue);
        list.add(formattedTextFieldExpiration);
        setFocusTraversalPolicy(new FocusPolicy(list));
    }
    
    private void setupTableComponents() {
        model = (CashingTableModel) tableCashing.getModel();
        SubstanceDefaultTableCellRenderer left = new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer center = new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer right = new SubstanceDefaultTableCellRenderer();
        left.setHorizontalAlignment(SwingConstants.LEFT);
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        center.setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)tableCashing.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tableCashing.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(center);
        columnModel.getColumn(1).setCellRenderer(right);
        columnModel.getColumn(2).setCellRenderer(right);
        columnModel.getColumn(3).setCellRenderer(right);
        columnModel.getColumn(4).setCellRenderer(center);
        columnModel.getColumn(5).setCellRenderer(center);
        columnModel.getColumn(6).setCellRenderer(right);
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(0).setPreferredWidth(15);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setResizable(false);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setResizable(false);
        columnModel.getColumn(3).setPreferredWidth(65);
        columnModel.getColumn(4).setResizable(false);
        columnModel.getColumn(4).setPreferredWidth(75);
        columnModel.getColumn(5).setResizable(false);
        columnModel.getColumn(5).setPreferredWidth(75);
        columnModel.getColumn(6).setResizable(false);
        columnModel.getColumn(6).setPreferredWidth(40);
        tableCashing.setRowSorter(null);
    }
    
    public void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
            return;
        }
        JViewport viewPort = (JViewport)table.getParent();
        Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);
        Point pt = viewPort.getViewPosition();
        // Translate the cell location so that it is relative
        // to the view, assuming the northwest corner of the
        // view is (0,0)
        rect.setLocation(rect.x-pt.x, rect.y-pt.y);
        viewPort.scrollRectToVisible(rect);
    }
    
    private void addTableCashing(Cashing cashingCheck) {
        int row = tableCashing.getRowCount();
        model.add(cashingCheck, row);
        scrollToVisible(tableCashing, row, 0);
        record.getList().add(cashingCheck);
        increaseRecordAmount(cashingCheck.getGross(), cashingCheck.getNet());
    }
    
    private void increaseRecordAmount(double gross, double net) {
        record.increase(new BigDecimal(gross), new BigDecimal(net));
        updateValueLabels();
    }
    
    public void updateValueLabels() {
        labelGrossDynamic.setText(Format.decimal(record.getGrossAmount().doubleValue()));
        labelNetDynamic.setText(Format.decimal(record.getNetAmount().doubleValue()));
        labelRetentionDynamic.setText(Format.decimal(record.getRetention().doubleValue()));
    }
    
    public void replaceTableCashing(int row, Cashing cashing) {
        record.replaceCashing(row, cashing, model);
        updateValueLabels();
    }
    
    private Cashing getCashingFromForm() throws ChequeMateException {
        ChequeMateException ex = exception;
        String strGross = textFieldValue.getText();
        if (strGross.isEmpty()) {
            throw ex.retrieve("Digite o valor do cheque.", textFieldValue);
        }
        String strExpiration = formattedTextFieldExpiration.getText();
        GregorianCalendar expiration = Convert.toGregorian(strExpiration, "dd/MM/yy");
        if (expiration == null) {
            throw ex.retrieve("Data inválida.", formattedTextFieldExpiration);
        }
        GregorianCalendar calcDate = new GregorianCalendar();
        calcDate.setTime(ChequeMate.getHolidayControl().nextBusinessDate(
                expiration.getTime(), Parameters.WITH_MIN_DAYS));
        int daysBetween = Days.between(Days.TODAY, calcDate);
        String strRate = textFieldRate.getText();
        strRate = strRate.isEmpty() ? String.valueOf(ChequeMate.getPreferences().getDefaultRate())
                : Deformat.decimal(strRate);
        BigDecimal rate = new BigDecimal(strRate, new MathContext(20));
        BigDecimal gross = new BigDecimal(Deformat.decimal(strGross), new MathContext(20));
        BigDecimal net = ChequeMate.calculateInterest(gross, daysBetween, rate);
        return new Cashing(expiration, gross.doubleValue(), 
                net.doubleValue(), rate.doubleValue(), calcDate);
    }
    
    private boolean isToday() {
        String strDate = formattedTextFieldExpiration.getText();
        GregorianCalendar date = Convert.toGregorian(strDate, "dd/MM/yy");
        if (date == null) {
            formattedTextFieldExpiration.setCaretPosition(0);
            return false;
        }
        boolean isToday = true;
        if (!Days.isToday(date)) {
            formattedTextFieldExpiration.setCaretPosition(0);
            isToday = false;
        }
        return isToday;
    }
    
    private void updateRateOnTable() throws ChequeMateException {
        ChequeMateException ex = exception;
        String strRate = textFieldRate.getText();
        if (strRate.isEmpty()) {
            throw ex.retrieve("Favor preencher a taxa.", textFieldRate);
        } 
        int choice = JOptionPane.showConfirmDialog(this, 
                "Quer realmente atualizar a taxa de todos os cheques da tabela?",
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            double rate = Deformat.andConvertDecimal(strRate);
            record.recalculate(model, rate);
            updateValueLabels();
        }       
    }
    
    private void refresh() {
        try {
            updateRateOnTable();
        } catch (ChequeMateException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
            ex.showExceptionMessage();
        }
    }
    
    private void clearForm() {
        textFieldValue.setText("");
        formattedTextFieldExpiration.setText(Format.todayDate("dd/MM/yy"));
        textFieldValue.requestFocusInWindow();
    }

    private void newCashingCheck() {
        int choice = JOptionPane.showConfirmDialog(this, "Deseja apagar este cálculo e começar outro?",
                        "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            model.clear();
            record = new RecordCashing();
            updateValueLabels();
            textFieldValue.requestFocusInWindow();
        }
    }

    private void printCashingCheck() throws ChequeMateException{
        ChequeMateException ex = exception;
        if (model.isEmpty()) {
            throw ex.retrieve("Não existem dados para imprimir.", null);
        }
        ArrayList<Cashing> cashingList = record.getList();
        Collections.sort(cashingList, new Compare.CashingExpiration());
        try {
            ReportFactory.viewCashing(cashingList);
        } catch (SQLException | JRException | IOException exc) {
            LOG.log(Level.SEVERE, exc.getMessage(), exc);
        } 
    }

    private void exitForm() {
        if (!model.isEmpty()) {
            writeFile();
        } else {
            if (Serialize.hasFile(MyPath.CASHING_FILE)) {
                try {
                    Serialize.delete(MyPath.CASHING_FILE);
                } catch (FileNotFoundException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                }
            }
        }
        dispose();
    }
    
    private void editRow() {
        int row = tableCashing.getSelectedRow();
        Cashing cashing = record.getList().get(row);
        new AlterCashingCheck(null, this, true, row, cashing).setVisible(true);
    }

    private void writeFile() {
        CashingFile cashingFile = new CashingFile(
                Deformat.andConvertDecimal(textFieldRate.getText()), record);
        Serialize<CashingFile> serial = new Serialize<>(cashingFile, MyPath.CASHING_FILE);
        try {
            serial.write();
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    private void readFile() throws IOException, ClassNotFoundException {
        if (Serialize.hasFile(MyPath.CASHING_FILE)) {
            Serialize<CashingFile> serial = new Serialize<>(MyPath.CASHING_FILE);
            setupForm(serial.read());
        } else {
            textFieldRate.setText(Format.decimal(ChequeMate.getPreferences().getDefaultRate()));
        }
    }

    private void setupForm(CashingFile cashingFile) {
        record = cashingFile.getRecordCashing();
        model.addList(record.getList());
        textFieldRate.setText(Format.decimal(cashingFile.getRate()));
        updateValueLabels();
    }
    
    private class EraseErrorLabel implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(4500);
                labelError.setText("");
            } catch (InterruptedException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    
    
    
}
