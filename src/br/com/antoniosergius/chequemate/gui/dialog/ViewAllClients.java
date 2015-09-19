package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.gui.utils.ClientTableModel;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

public class ViewAllClients extends javax.swing.JDialog {
    private static final Logger LOG = Logger.getLogger(ViewAllClients.class.getName());
    private static final long serialVersionUID = 1L;
    
    private Connection conn;
    private ClientController clientControl;
    private ArrayList<Client> clientList;
    private HashMap<String, Client> clientMap;
    private ClientTableModel model;
    
    public ViewAllClients(Frame parent, boolean modal, Connection conn) {
        super(parent, modal);
        this.conn = conn;
        clientControl = new ClientController(conn);
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new org.jdesktop.swingx.JXHeader();
        panelTable = new org.jdesktop.swingx.JXPanel();
        scrollPane = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();
        buttonClose = new javax.swing.JButton();
        toolbar = new javax.swing.JToolBar();
        buttonAdd = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        labelSearch = new org.jdesktop.swingx.JXLabel();
        textFieldSearch = new javax.swing.JTextField();
        buttonClean = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes - Visualizador");

        header.setTitle("Tabela de Registros");

        tableClients.setModel(new ClientTableModel());
        tableClients.getTableHeader().setReorderingAllowed(false);
        tableClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientsMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tableClients);
        tableClients.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonClose.setText("Fechar");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.add.png"))); // NOI18N
        buttonAdd.setFocusable(false);
        buttonAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        toolbar.add(buttonAdd);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.refresh.png"))); // NOI18N
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        toolbar.add(buttonRefresh);

        labelSearch.setText("Pesquisar: ");

        textFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldSearchKeyReleased(evt);
            }
        });

        buttonClean.setText("Limpar");
        buttonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonClean, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClean))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        new AddClient(null, true, conn, this).setVisible(true);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanActionPerformed
        pressClear();
    }//GEN-LAST:event_buttonCleanActionPerformed

    private void textFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldSearchKeyReleased
        setupClientList(textFieldSearch.getText().toUpperCase());
    }//GEN-LAST:event_textFieldSearchKeyReleased

    private void tableClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientsMouseClicked
        if (evt.getClickCount() == 2) {
            String name = (String) model.getValueAt(tableClients.getSelectedRow(), 1);
            Client client = clientMap.get(name);
            new ViewClient(null, this, true, conn, client).setVisible(true);
        }
    }//GEN-LAST:event_tableClientsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonClean;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonRefresh;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXLabel labelSearch;
    private org.jdesktop.swingx.JXPanel panelTable;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableClients;
    private javax.swing.JTextField textFieldSearch;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.client.png")).getImage());
        model = (ClientTableModel) tableClients.getModel();
        Verifier.set(textFieldSearch, new TextVerifier());
        setupClientList();
        setupClientMap();
        setupTable();
    }
    
    public void setupClientMap() {
        try {
            clientMap = clientControl.getMap();
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
        }
    }
    
    public void setupClientList() {
        try {
            clientList = clientControl.getAll();
            model.clear();
            Collections.sort(clientList);
            model.addList(clientList);
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
        }
    }
    
    private void setupClientList(String part) {
        try {
            clientList = clientControl.getAll(part);
            model.clear();
            Collections.sort(clientList);
            model.addList(clientList);
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, ex.getMessage(), ex);
        }
    }
    
    private void setupTable() {
        SubstanceDefaultTableCellRenderer centerAlign = 
                new SubstanceDefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(SwingConstants.CENTER);
        SubstanceDefaultTableCellRenderer leftAlign = 
                new SubstanceDefaultTableCellRenderer();
        leftAlign.setHorizontalAlignment(SwingConstants.LEFT);
        ((JLabel)tableClients.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tableClients.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerAlign);
        columnModel.getColumn(1).setCellRenderer(leftAlign);
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(1).setPreferredWidth(400);
        tableClients.setRowSorter(null);
    }
    
    private void pressClear() {
        textFieldSearch.setText("");
        textFieldSearch.requestFocusInWindow();
        setupClientList();
    }

    public void refresh() {
        pressClear();
        setupClientList();
        setupClientMap();
    }
}
