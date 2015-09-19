package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.gui.utils.RetentionTableModel;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Retention;
import br.com.antoniosergius.chequemate.report.RecordDataSource;
import br.com.antoniosergius.chequemate.report.ReportFactory;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.chequemate.util.MyPath;
import br.com.antoniosergius.chequemate.util.io.RecordFile;
import br.com.antoniosergius.chequemate.util.tools.Compare;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.util.io.Serialize;
import java.awt.Cursor;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

public class ViewAllRetentions extends javax.swing.JDialog {
    private static final Logger LOG = Logger.getLogger(ViewAllRetentions.class.getName());

    private Connection conn;
    private ArrayList<Retention> retentionList;
    private HashMap<String, RecordFile> registriesReports;
    private RetentionTableModel model;
    
    public ViewAllRetentions(java.awt.Frame parent, boolean modal, Connection conn) {
        super(parent, modal);
        this.conn = conn;
        retentionList = new ArrayList<>();
        registriesReports = new HashMap<>();
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenuTable = new javax.swing.JPopupMenu();
        menuItemOpenReport = new javax.swing.JMenuItem();
        header = new org.jdesktop.swingx.JXHeader();
        panelMain = new org.jdesktop.swingx.JXPanel();
        scrollPane = new javax.swing.JScrollPane();
        tableRetention = new javax.swing.JTable();
        toolBar = new javax.swing.JToolBar();
        buttonRefresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        buttonClose = new javax.swing.JButton();

        menuItemOpenReport.setText("Abrir Relatório Correspondente");
        menuItemOpenReport.setToolTipText("");
        menuItemOpenReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenReportActionPerformed(evt);
            }
        });
        popupMenuTable.add(menuItemOpenReport);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        header.setTitle("Retenções");

        tableRetention.setModel(new RetentionTableModel());
        tableRetention.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableRetentionMouseReleased(evt);
            }
        });
        scrollPane.setViewportView(tableRetention);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.refresh.png"))); // NOI18N
        buttonRefresh.setToolTipText("Atualizar");
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        toolBar.add(buttonRefresh);
        toolBar.add(jSeparator1);

        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x24.exit.png"))); // NOI18N
        buttonClose.setToolTipText("Fechar Janela");
        buttonClose.setFocusable(false);
        buttonClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        toolBar.add(buttonClose);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void tableRetentionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRetentionMouseReleased
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int rowNumber = tableRetention.rowAtPoint( p );
            if (rowNumber != -1) {
                tableRetention.setRowSelectionInterval(rowNumber, rowNumber);
                if (evt.isPopupTrigger()) {
                    popupMenuTable.show(tableRetention, evt.getX(), evt.getY());
                }
            }    
        }    
    }//GEN-LAST:event_tableRetentionMouseReleased

    private void menuItemOpenReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenReportActionPerformed
        try {
            int selectedRow = tableRetention.convertRowIndexToModel(tableRetention.getSelectedRow());
            String fileName = model.get(selectedRow).getFileName();
            viewReport(registriesReports.get(fileName));
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
        } catch (SQLException | JRException | IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemOpenReportActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        try {
            model.clear();
            setupList();
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonRefresh;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JMenuItem menuItemOpenReport;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JPopupMenu popupMenuTable;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableRetention;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setTitle("Retenções Arquivadas");
        setLocationRelativeTo(null);
        setupTableComponents();
        try {
            setupList();
            model.addList(retentionList);
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    private void setupTableComponents() {
        model = (RetentionTableModel) tableRetention.getModel();
        SubstanceDefaultTableCellRenderer left = new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer center = new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer right = new SubstanceDefaultTableCellRenderer();
        left.setHorizontalAlignment(SwingConstants.LEFT);
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        center.setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)tableRetention.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tableRetention.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(left);
        columnModel.getColumn(1).setCellRenderer(center);
        columnModel.getColumn(2).setCellRenderer(right);
        columnModel.getColumn(3).setCellRenderer(right);
        columnModel.getColumn(4).setCellRenderer(right);
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setResizable(false);
        columnModel.getColumn(2).setPreferredWidth(30);
        columnModel.getColumn(3).setResizable(false);
        columnModel.getColumn(3).setPreferredWidth(30);
        columnModel.getColumn(4).setResizable(false);
        columnModel.getColumn(4).setPreferredWidth(30);
        setupTableSorter();
    }
    
    private void setupList() throws IOException, ClassNotFoundException, SQLException{
        File dir = new File(MyPath.REGISTRIES);
        String file[] = dir.list(new MyPath.FilterFile());
        for (String record : file) {
            Serialize<RecordFile> serial = new Serialize<>(MyPath.REGISTRIES+record);
            RecordFile recordReaded = serial.read();
            double gross = 0.0;
            double net = 0.0;
            for (Check check : recordReaded.getCheckList()) {
                gross += check.getGross();
                net+= check.getNet();
            }
            String client = recordReaded.getClient().getName()+" - "+
                    Format.clientId(recordReaded.getClient().getId());
            Retention retention = new Retention(client, gross, net, gross-net, 
                    recordReaded.getInputTime(), record);
            registriesReports.put(record, recordReaded);
            retentionList.add(retention);
        }
    }
    
    private void setupTableSorter() {
        TableRowSorter<TableModel> sorter = 
                new TableRowSorter<>(tableRetention.getModel());
        List <RowSorter.SortKey> sortKey = new ArrayList<>();
        sortKey.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sorter.setComparator(1, new Compare.StringTimestamp());
        sorter.setComparator(2, new Compare.StringDecimal());
        sorter.setComparator(3, new Compare.StringDecimal());
        sorter.setComparator(4, new Compare.StringDecimal());
        sorter.setSortKeys(sortKey);
        tableRetention.setRowSorter(sorter);
    }
    
    private void viewReport(RecordFile recordFile) throws ChequeMateException, SQLException, JRException, IOException {
        if (recordFile==null) {
            throw new ChequeMateException("Houve algum erro ao ler o arquivo de desconto.");
        }
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        ReportFactory.viewRecord("ReciboChequesDataSource.jasper",
                    recordFile.getClient().getName(), 
                    new RecordDataSource(recordFile.getCheckList()));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
}
