package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.report.RecordDataSource;
import br.com.antoniosergius.chequemate.report.ReportFactory;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.chequemate.util.MyPath;
import br.com.antoniosergius.chequemate.util.io.RecordFile;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Days;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.util.io.Serialize;
import br.com.antoniosergius.lib.verif.PercentVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Cursor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JRException;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ViewRecords extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(ViewRecords.class.getName());
    
    private Connection conn;
    private RecordFile recordFile;
    private HashMap<String, String> fileMap;
    
    public ViewRecords(java.awt.Frame parent, boolean modal, Connection conn) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        fileMap = new HashMap<>();
        recordFile = null;
        this.conn = conn;
        Verifier.set(textFieldRate, new PercentVerifier());
        setupComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new org.jdesktop.swingx.JXPanel();
        labelImagem = new org.jdesktop.swingx.JXLabel();
        buttonGerarRelatorio = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        labelDescricao = new org.jdesktop.swingx.JXLabel();
        labelArquivos = new javax.swing.JLabel();
        header = new org.jdesktop.swingx.JXHeader();
        comboBox = new javax.swing.JComboBox();
        labelTaxa = new org.jdesktop.swingx.JXLabel();
        textFieldRate = new javax.swing.JTextField();
        labelDicas = new org.jdesktop.swingx.JXLabel();
        checkBoxSameRate = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastros");
        setResizable(false);

        labelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x48.report.png"))); // NOI18N
        labelImagem.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        buttonGerarRelatorio.setText("Gerar");
        buttonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGerarRelatorioActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        labelDescricao.setText("Selecione o cadastro o qual deseja visualizar o relatório:");

        labelArquivos.setText("Arquivos: ");

        header.setDescription("");
        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.report.png"))); // NOI18N
        header.setTitle("Gerador de Relatório");
        header.setToolTipText("");

        comboBox.setEditable(true);

        labelTaxa.setText("Taxa:");

        textFieldRate.setText("Não alterado");
        textFieldRate.setEnabled(false);

        labelDicas.setLineWrap(true);
        labelDicas.setMaxLineSpan(0);
        labelDicas.setText("* É possível alterar a taxa apenas para visualização.  Os valores dos cheques continuarão os mesmos. Caso queira alterar algum cheque vá na tela principal no menu \"Cheques\" > \"Abrir\", em seguida clique duas vezes no registro desejado.");

        checkBoxSameRate.setSelected(true);
        checkBoxSameRate.setText("Manter taxa original *");
        checkBoxSameRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSameRateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(buttonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(labelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addComponent(labelArquivos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(labelTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxSameRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldRate)))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDicas, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE)))))
                .addGap(11, 11, 11))
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelArquivos, labelTaxa});

        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelArquivos)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkBoxSameRate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(labelDicas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGerarRelatorio)
                    .addComponent(buttonCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGerarRelatorioActionPerformed
        readFile();
        try {
            recalculateRecordChecks(recordFile);
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
            return;
        }
        try {
            viewReport();
            dispose();
        } catch (ChequeMateException | SQLException | JRException | IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_buttonGerarRelatorioActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void checkBoxSameRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSameRateActionPerformed
        if (!checkBoxSameRate.isSelected()) {
            textFieldRate.setEnabled(true);
            textFieldRate.setText("");
            textFieldRate.requestFocusInWindow();
        } else {
            textFieldRate.setEnabled(false);
            textFieldRate.setText("Não alterado");
        }
    }//GEN-LAST:event_checkBoxSameRateActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonGerarRelatorio;
    private javax.swing.JCheckBox checkBoxSameRate;
    private javax.swing.JComboBox comboBox;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel labelArquivos;
    private org.jdesktop.swingx.JXLabel labelDescricao;
    private org.jdesktop.swingx.JXLabel labelDicas;
    private org.jdesktop.swingx.JXLabel labelImagem;
    private org.jdesktop.swingx.JXLabel labelTaxa;
    private org.jdesktop.swingx.JXPanel panelPrincipal;
    private javax.swing.JTextField textFieldRate;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("unchecked")
    private void setupComboBox() {
        File dir = new File(MyPath.REGISTRIES);
        String file[] = dir.list(new MyPath.FilterFile());
        String names[] = new String[file.length];
        ClientController clientControl = new ClientController(conn);
        int tot = file.length;
        StringBuilder element = new StringBuilder();
        
        for (int i=0; i<tot; i++) {
            String piece[] = file[i].split("-");
            int idClient = Integer.parseInt(piece[0]);
            Client client = null;
            try {
                client = clientControl.get(idClient);
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
            if (client!=null) {
                String[] strDate = piece[1].split("~");
                strDate[0] = strDate[0].replaceAll("\\.", "/");
                String hours[] = strDate[1].split("\\.");
                element.append(strDate[0]);
                element.append(" ");
                element.append(hours[0]);
                element.append(":");
                element.append(hours[1]);
                element.append(" - ");
                String name = client.getFirstName();
                element.append(name);
                element.append(" - ");
                element.append(piece[0]);
                names[i] = element.toString();
                fileMap.put(names[i], file[i]);
            }
            element.delete(0, element.length());
        }
        sortByDate(names);
        comboBox.setModel(new DefaultComboBoxModel(names));
        AutoCompleteDecorator.decorate(comboBox);
        comboBox.setSelectedIndex(-1);
    }

    private void readFile() {
        if (comboBox.getSelectedIndex()!=-1) {
            String element = (String) comboBox.getSelectedItem();
            String file = fileMap.get(element);
            Serialize<RecordFile> serial = new Serialize<>(MyPath.REGISTRIES+file);
            try {
                recordFile = serial.read();
            } catch (FileNotFoundException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            } catch (IOException | ClassNotFoundException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

    private void viewReport() throws ChequeMateException, SQLException, JRException, IOException {
        if (recordFile==null) {
            throw new ChequeMateException("Houve algum erro ao ler o arquivo de desconto.");
        }
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        ReportFactory.viewRecord("ReciboChequesDataSource.jasper",
                    recordFile.getClient().getName(), 
                    new RecordDataSource(recordFile.getCheckList()));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    public void recalculateRecordChecks(RecordFile recordFile) throws ChequeMateException {
        if (checkBoxSameRate.isSelected()) {
            return;
        }
        String strRate = textFieldRate.getText();
        if (strRate.isEmpty()) {
            throw new ChequeMateException("Favor preencher a taxa de juros.", textFieldRate);
        }
        BigDecimal rate = new BigDecimal(Deformat.decimal(strRate));
        GregorianCalendar date = recordFile.getInputTime();
        ArrayList<Check> checkList = recordFile.getCheckList();
        int daysBetween;
        for (Check cheque : checkList) {
            BigDecimal gross = new BigDecimal(cheque.getGross());
            daysBetween = Days.between(date, cheque.getCalcDate());
            BigDecimal newNet = ChequeMate.calculateInterest(gross, daysBetween, rate);
            cheque.setNet(newNet.doubleValue());
        }    
    }

    private void sortByDate(String[] names) {
        if (names == null) {
            return;
        }
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                GregorianCalendar d1 = Convert.toGregorianTimestamp(o1.split(" - ")[0]);
                GregorianCalendar d2 = Convert.toGregorianTimestamp(o2.split(" - ")[0]);
                return d1.compareTo(d2);
            }
        });
    }
}
