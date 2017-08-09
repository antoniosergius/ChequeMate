package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.gui.MainFrame;
import br.com.antoniosergius.chequemate.gui.QueryCheckFrame;
import br.com.antoniosergius.chequemate.gui.utils.PayeeExtTableModel;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.chequemate.obj.PayeeExt;
import br.com.antoniosergius.chequemate.obj.Query;
import br.com.antoniosergius.chequemate.util.tools.Compare;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.verif.RegistryNumberVerifier;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

public class ViewAllPayees extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ViewAllPayees.class.getName());
    
    private Connection conn;
    private Payee searchObj;
    private PayeeController payeeControl;
    private ArrayList<PayeeExt> payeeExtList;
    private PayeeExtTableModel model;
    

    public ViewAllPayees(java.awt.Frame parent, boolean modal, Connection conn) {
        super(parent, modal);
        this.conn = conn;
        searchObj = new Payee();
        payeeControl = new PayeeController(conn);
        initComponents();
        setupComponents();                
    }

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      popupTableMenu = new javax.swing.JPopupMenu();
      menuItemVerifyPayee = new javax.swing.JMenuItem();
      menuItemVerifySignature = new javax.swing.JMenuItem();
      panelMain = new org.jdesktop.swingx.JXPanel();
      header = new org.jdesktop.swingx.JXHeader();
      panelForm = new org.jdesktop.swingx.JXPanel();
      labelName = new org.jdesktop.swingx.JXLabel();
      labelRegistry = new org.jdesktop.swingx.JXLabel();
      textFieldName = new org.jdesktop.swingx.JXTextField();
      textFieldRegistry = new org.jdesktop.swingx.JXTextField();
      buttonClean1 = new org.jdesktop.swingx.JXButton();
      buttonClean2 = new org.jdesktop.swingx.JXButton();
      jXLabelImagem = new org.jdesktop.swingx.JXLabel();
      toolBar = new javax.swing.JToolBar();
      buttonPrint = new org.jdesktop.swingx.JXButton();
      buttonRefresh = new org.jdesktop.swingx.JXButton();
      separator = new javax.swing.JToolBar.Separator();
      buttonClose = new org.jdesktop.swingx.JXButton();
      panelResults = new org.jdesktop.swingx.JXPanel();
      labelTotalListado = new org.jdesktop.swingx.JXLabel();
      labelTotalDin = new org.jdesktop.swingx.JXLabel();
      scrollPane = new javax.swing.JScrollPane();
      tablePayeeExt = new javax.swing.JTable();

      menuItemVerifyPayee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.view.png"))); // NOI18N
      menuItemVerifyPayee.setText("Verificar Cheques em Aberto...");
      menuItemVerifyPayee.setToolTipText("Abre a tela de consulta de cheques com o CPF/CNPJ do emitente selecionado");
      menuItemVerifyPayee.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuItemVerifyPayeeActionPerformed(evt);
         }
      });
      popupTableMenu.add(menuItemVerifyPayee);

      menuItemVerifySignature.setText("Verificar Imagem da Assinatura ...");
      menuItemVerifySignature.setToolTipText("Mostra a imagem que contém a assinatura do emitente");
      menuItemVerifySignature.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuItemVerifySignatureActionPerformed(evt);
         }
      });
      popupTableMenu.add(menuItemVerifySignature);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
         }
      });

      header.setToolTipText("");
      header.setTitle("Lista de Emitentes");

      panelForm.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar na Tabela"));

      labelName.setText("Nome:");

      labelRegistry.setText("CPF/CNPJ:");

      textFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyReleased(java.awt.event.KeyEvent evt) {
            textFieldNameKeyReleased(evt);
         }
      });

      textFieldRegistry.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyReleased(java.awt.event.KeyEvent evt) {
            textFieldRegistryKeyReleased(evt);
         }
      });

      buttonClean1.setText("Limpar");
      buttonClean1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonClean1ActionPerformed(evt);
         }
      });

      buttonClean2.setText("Limpar");
      buttonClean2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonClean2ActionPerformed(evt);
         }
      });

      jXLabelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x48.payee.png"))); // NOI18N
      jXLabelImagem.setVerticalAlignment(javax.swing.SwingConstants.TOP);

      javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
      panelForm.setLayout(panelFormLayout);
      panelFormLayout.setHorizontalGroup(
         panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelFormLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(panelFormLayout.createSequentialGroup()
                  .addComponent(labelRegistry, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(textFieldRegistry, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(buttonClean2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(panelFormLayout.createSequentialGroup()
                  .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(buttonClean1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
            .addComponent(jXLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );

      panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelName, labelRegistry});

      panelFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textFieldName, textFieldRegistry});

      panelFormLayout.setVerticalGroup(
         panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelFormLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(labelRegistry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(textFieldRegistry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(buttonClean2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(buttonClean1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 19, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormLayout.createSequentialGroup()
            .addComponent(jXLabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );

      panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelName, labelRegistry});

      panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {textFieldName, textFieldRegistry});

      toolBar.setFloatable(false);
      toolBar.setRollover(true);

      buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.print.png"))); // NOI18N
      buttonPrint.setToolTipText("Imprimir");
      buttonPrint.setFocusable(false);
      buttonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      toolBar.add(buttonPrint);

      buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.refresh.png"))); // NOI18N
      buttonRefresh.setToolTipText("Atualizar Tabela");
      buttonRefresh.setFocusable(false);
      buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
      buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
      buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonRefreshActionPerformed(evt);
         }
      });
      toolBar.add(buttonRefresh);
      toolBar.add(separator);

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

      labelTotalListado.setForeground(new java.awt.Color(255, 0, 0));
      labelTotalListado.setText("Total de Emitentes Listados :");
      labelTotalListado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

      labelTotalDin.setForeground(new java.awt.Color(255, 0, 0));
      labelTotalDin.setText(" ");
      labelTotalDin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

      javax.swing.GroupLayout panelResultsLayout = new javax.swing.GroupLayout(panelResults);
      panelResults.setLayout(panelResultsLayout);
      panelResultsLayout.setHorizontalGroup(
         panelResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelResultsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labelTotalListado, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(labelTotalDin, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      panelResultsLayout.setVerticalGroup(
         panelResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelResultsLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(labelTotalListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(labelTotalDin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      panelResultsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelTotalDin, labelTotalListado});

      tablePayeeExt.setModel(new PayeeExtTableModel());
      tablePayeeExt.getTableHeader().setReorderingAllowed(false);
      tablePayeeExt.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablePayeeExtMouseClicked(evt);
         }
         public void mouseReleased(java.awt.event.MouseEvent evt) {
            tablePayeeExtMouseReleased(evt);
         }
      });
      scrollPane.setViewportView(tablePayeeExt);
      tablePayeeExt.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

      javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
      panelMain.setLayout(panelMainLayout);
      panelMainLayout.setHorizontalGroup(
         panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addGroup(panelMainLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(scrollPane)
               .addComponent(panelResults, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
      );
      panelMainLayout.setVerticalGroup(
         panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelMainLayout.createSequentialGroup()
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(8, 8, 8)
            .addComponent(panelResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
         .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        queryAndSetupTableData();
    }//GEN-LAST:event_formWindowOpened

    private void buttonClean1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClean1ActionPerformed
        searchObj.setName("");
        textFieldName.setText("");
        queryAndSetupTableData();
    }//GEN-LAST:event_buttonClean1ActionPerformed

    private void buttonClean2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClean2ActionPerformed
        searchObj.setRegistryNumber("");
        textFieldRegistry.setText("");
        queryAndSetupTableData();
    }//GEN-LAST:event_buttonClean2ActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        queryAndSetupTableData();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void textFieldNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNameKeyReleased
        searchObj.setName(textFieldName.getText());
        queryAndSetupTableData();
    }//GEN-LAST:event_textFieldNameKeyReleased

    private void textFieldRegistryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldRegistryKeyReleased
        searchObj.setRegistryNumber(textFieldRegistry.getText());
        queryAndSetupTableData();
    }//GEN-LAST:event_textFieldRegistryKeyReleased

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void menuItemVerifyPayeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerifyPayeeActionPerformed
        int row = tablePayeeExt.getSelectedRow();
        if (row != -1) {
            QueryCheckFrame queryFrame = new QueryCheckFrame(conn);
            queryFrame.setMainFrame((MainFrame)getParent());
            Query query = new Query();
            Payee payee = new Payee(model.get(tablePayeeExt.convertRowIndexToModel(row)).getRegistryNumber());
            query.setPayee(payee);
            queryFrame.setQueryObject(query);
            queryFrame.setPayeeInForm(payee);
            queryFrame.queryAndSetupTableData();
            queryFrame.setVisible(true);
        }
    }//GEN-LAST:event_menuItemVerifyPayeeActionPerformed

    private void tablePayeeExtMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePayeeExtMouseReleased
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int rowNumber = tablePayeeExt.rowAtPoint( p );
            if (rowNumber != -1) {
                tablePayeeExt.setRowSelectionInterval(rowNumber, rowNumber);
                if (evt.isPopupTrigger()) {
                    popupTableMenu.show(tablePayeeExt, evt.getX(), evt.getY());
                }
            }    
        }    
    }//GEN-LAST:event_tablePayeeExtMouseReleased

    private void tablePayeeExtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePayeeExtMouseClicked
        if (evt.getClickCount() == 2 && tablePayeeExt.getSelectedRowCount() == 1) {
            int modelIndex = tablePayeeExt.convertRowIndexToModel(tablePayeeExt.getSelectedRow());
            PayeeExt payee = payeeExtList.get(modelIndex);
            new AlterPayee(this, true, conn, payee, modelIndex).setVisible(true);
        }
    }//GEN-LAST:event_tablePayeeExtMouseClicked

   private void menuItemVerifySignatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerifySignatureActionPerformed
      openSignature();
   }//GEN-LAST:event_menuItemVerifySignatureActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private org.jdesktop.swingx.JXButton buttonClean1;
   private org.jdesktop.swingx.JXButton buttonClean2;
   private org.jdesktop.swingx.JXButton buttonClose;
   private org.jdesktop.swingx.JXButton buttonPrint;
   private org.jdesktop.swingx.JXButton buttonRefresh;
   private org.jdesktop.swingx.JXHeader header;
   private org.jdesktop.swingx.JXLabel jXLabelImagem;
   private org.jdesktop.swingx.JXLabel labelName;
   private org.jdesktop.swingx.JXLabel labelRegistry;
   private org.jdesktop.swingx.JXLabel labelTotalDin;
   private org.jdesktop.swingx.JXLabel labelTotalListado;
   private javax.swing.JMenuItem menuItemVerifyPayee;
   private javax.swing.JMenuItem menuItemVerifySignature;
   private org.jdesktop.swingx.JXPanel panelForm;
   private org.jdesktop.swingx.JXPanel panelMain;
   private org.jdesktop.swingx.JXPanel panelResults;
   private javax.swing.JPopupMenu popupTableMenu;
   private javax.swing.JScrollPane scrollPane;
   private javax.swing.JToolBar.Separator separator;
   private javax.swing.JTable tablePayeeExt;
   private org.jdesktop.swingx.JXTextField textFieldName;
   private org.jdesktop.swingx.JXTextField textFieldRegistry;
   private javax.swing.JToolBar toolBar;
   // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setTitle("Emitentes de Cheques Passados Pelo ChequeMate");
        setResizable(false);
        setLocationRelativeTo(null);
        Verifier.set(textFieldName, new TextVerifier());
        Verifier.set(textFieldRegistry, new RegistryNumberVerifier(false, false));
        setupFocusComponents();
        setupTable();
    }

    private void setupFocusComponents() {
        FocusPolicy.setDefaultTrasversalKeys(panelForm, FocusPolicy.BOTH_DIRECTIONS);
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldRegistry);
        list.add(textFieldName);
        setFocusTraversalPolicy(new FocusPolicy(list));
    }

    private void setupTable() {
        model = (PayeeExtTableModel) tablePayeeExt.getModel();
        setupTableSorter();
        SubstanceDefaultTableCellRenderer center = new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer left = new SubstanceDefaultTableCellRenderer();
        SubstanceDefaultTableCellRenderer right = new SubstanceDefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        left.setHorizontalAlignment(SwingConstants.LEFT);
        right.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel tableHeader = (JLabel) tablePayeeExt.getTableHeader().getDefaultRenderer();
        tableHeader.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tablePayeeExt.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(left); //nome
        columnModel.getColumn(1).setCellRenderer(left); //cpf
        columnModel.getColumn(2).setCellRenderer(center); //data
        columnModel.getColumn(3).setCellRenderer(center); //data
        columnModel.getColumn(4).setCellRenderer(right); //valor
        columnModel.getColumn(5).setCellRenderer(center); //totalcheques
        columnModel.getColumn(0).setResizable(false);
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setResizable(false);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setResizable(false);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setResizable(false);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setResizable(false);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setResizable(false);
        columnModel.getColumn(5).setPreferredWidth(60);
    }
    
    private void setupTableSorter() {
        TableRowSorter<TableModel> sorter = 
                new TableRowSorter<>(tablePayeeExt.getModel());
        List <RowSorter.SortKey> sortKey = new ArrayList<>();
        sorter.setComparator(1, new Compare.RegistryNumber());
        sorter.setComparator(2, new Compare.StringDate());
        sorter.setComparator(3, new Compare.StringDate());
        sorter.setComparator(4, new Compare.StringDecimal());
        sorter.setComparator(5, new Compare.StringInteger());
        sorter.setSortKeys(sortKey);
        tablePayeeExt.setRowSorter(sorter);
    }
    
    public void queryAndSetupTableData() {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (searchObj.isEmpty()){
            queryAll();
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        ArrayList<PayeeExt> list = null;
        try {
            list = payeeControl.query(searchObj);
        } catch (SQLException ex) {}
        setTableData(list);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private ArrayList<PayeeExt> queryAll() {
        ArrayList<PayeeExt> list;
        try {
            list = payeeControl.getAll();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            model.clear();
            return null;
        }
        Collections.sort(list);
        setTableData(list);
        payeeExtList = list;
        return list;
    }

    private void setTableData(ArrayList<PayeeExt> list) {
        model.clear();
        if (list == null || list.isEmpty()) {
            payeeExtList = null;
            setPayeeCount(0);
            return;
        }
        model.addList(list);
        payeeExtList = list;
        setPayeeCount(list.size());
    }
    
    public void clearSearchObj() {
        searchObj.setName("");
        searchObj.setRegistryNumber("");
    }
    
    public void setPayeeCount(int n) {
        labelTotalDin.setText(String.valueOf(n));
    }
    
    public void updateFromModel(PayeeExt payeeExt, int modelIndex) {
        model.setValueAt(payeeExt, modelIndex);
        PayeeExt fromList = payeeExtList.get(modelIndex);
        fromList.setName(payeeExt.getName());
        
    }

    public void setRegistryNumber(String registryNumber) {
        searchObj.setRegistryNumber(registryNumber);
        textFieldRegistry.setText(registryNumber);
    }

   private void openSignature() {
      new ViewSignature(null, true).setVisible(true);
   }
}
