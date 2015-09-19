package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.HolidayController;
import br.com.antoniosergius.chequemate.gui.utils.HolidayTableModel;
import br.com.antoniosergius.chequemate.obj.Holiday;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

public class ViewAllHolidays extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ViewAllHolidays.class.getName());
    
    private ArrayList<Holiday> holidayList;
    private HolidayTableModel holidayModel;
    private HolidayController holidayControl;
    
    public ViewAllHolidays(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        holidayControl = ChequeMate.getHolidayControl();
        holidayList = holidayControl.getList();
        Collections.sort(holidayList);
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        toolBar = new javax.swing.JToolBar();
        buttonAdd = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tableHoliday = new javax.swing.JTable();
        panelButtons = new org.jdesktop.swingx.JXPanel();
        buttonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Feriados - Visualizador");

        header.setDescription("");
        header.setTitle("Tabela de Registros");

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.add.png"))); // NOI18N
        buttonAdd.setFocusable(false);
        buttonAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        toolBar.add(buttonAdd);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.refresh.png"))); // NOI18N
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        toolBar.add(buttonRefresh);

        tableHoliday.setModel(new HolidayTableModel());
        tableHoliday.getTableHeader().setReorderingAllowed(false);
        tableHoliday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHolidayMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tableHoliday);
        tableHoliday.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        buttonClose.setText("Fechar");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap(471, Short.MAX_VALUE)
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        new AddHoliday(null, true, holidayControl, this).setVisible(true);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void tableHolidayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHolidayMouseClicked
        if (evt.getClickCount() == 2) {
            Holiday holiday = holidayModel.get(tableHoliday.getSelectedRow());
            new AlterHoliday(null, true, this, holidayControl, holiday).setVisible(true);
        }
    }//GEN-LAST:event_tableHolidayMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonRefresh;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXPanel panelButtons;
    private org.jdesktop.swingx.JXPanel panelMain;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableHoliday;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.date.png")).getImage());
        holidayModel = (HolidayTableModel) tableHoliday.getModel();
        holidayModel.clear();
        holidayModel.addList(holidayList);
        setupTableComponents();
    }

    private void setupTableComponents() {
        SubstanceDefaultTableCellRenderer centerAlign = 
                new SubstanceDefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(SwingConstants.CENTER);
        SubstanceDefaultTableCellRenderer leftAlign = 
                new SubstanceDefaultTableCellRenderer();
        leftAlign.setHorizontalAlignment(SwingConstants.LEFT);
        ((JLabel)tableHoliday.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tableHoliday.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerAlign);
        columnModel.getColumn(1).setCellRenderer(centerAlign);
        columnModel.getColumn(2).setCellRenderer(leftAlign);
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(1).setPreferredWidth(60);
        columnModel.getColumn(2).setResizable(false);
        columnModel.getColumn(2).setPreferredWidth(200);
    }
    
    public void add(Holiday holiday) {
       holidayModel.add(holiday);
    }
    
    public void delete(int row) {
        holidayModel.remove(row);
    }
    
    public void update(Holiday holiday, int row) {
        holidayModel.setValueAt(holiday, row);
    }

    public void refresh() {
        holidayModel.clear();
        try {
            holidayControl.setupCollections();
            holidayList = holidayControl.getList();
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
        }
        Collections.sort(holidayList);
        holidayModel.addList(holidayList);
    }


}
