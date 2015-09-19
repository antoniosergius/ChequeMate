package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.obj.Address;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.obj.Phone;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.verif.EmailVerifier;
import br.com.antoniosergius.lib.verif.PercentVerifier;
import br.com.antoniosergius.lib.verif.RegistryNumberVerifier;
import br.com.antoniosergius.lib.verif.StateVerifier;
import br.com.antoniosergius.lib.verif.TextVerifier;
import br.com.antoniosergius.lib.verif.Verifier;
import java.awt.Component;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class ViewClient extends javax.swing.JDialog {
    private static final Logger LOG = Logger.getLogger(ViewClient.class.getName());
    private static final long serialVersionUID = 1L;

    private Client newOne;
    private Client client;
    private final ViewAllClients parent;
    private final ClientController clientControl;
    private boolean editing;
    
    public ViewClient(Frame owner, JDialog parent, boolean modal, Connection conn, Client client) {
        super(owner, modal);
        this.client = client;
        this.newOne = client;
        this.parent = (ViewAllClients)parent;
        clientControl = new ClientController(conn);
        editing = false;
        initComponents();
        setupComponents();
        setTitle(client.getName());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        panelForm = new org.jdesktop.swingx.JXPanel();
        panelAddress = new org.jdesktop.swingx.JXPanel();
        labelStreet = new org.jdesktop.swingx.JXLabel();
        textFieldStreet = new javax.swing.JTextField();
        labelCity = new org.jdesktop.swingx.JXLabel();
        textFieldCity = new javax.swing.JTextField();
        labelDistrict = new org.jdesktop.swingx.JXLabel();
        textFieldDistrict = new javax.swing.JTextField();
        labelZipcode = new org.jdesktop.swingx.JXLabel();
        formattedTextFieldZipCode = new javax.swing.JFormattedTextField();
        labelState = new org.jdesktop.swingx.JXLabel();
        textFieldState = new javax.swing.JTextField();
        panelData = new org.jdesktop.swingx.JXPanel();
        labelId = new org.jdesktop.swingx.JXLabel();
        textFieldId = new javax.swing.JTextField();
        labelName = new org.jdesktop.swingx.JXLabel();
        textFieldName = new javax.swing.JTextField();
        labelEmail = new org.jdesktop.swingx.JXLabel();
        textFieldEmail = new javax.swing.JTextField();
        labelRegistry = new org.jdesktop.swingx.JXLabel();
        textFieldRegistry = new javax.swing.JTextField();
        labelBirthDate = new org.jdesktop.swingx.JXLabel();
        labelRate = new org.jdesktop.swingx.JXLabel();
        textFieldRate = new javax.swing.JTextField();
        formattedTextFieldBirthDate = new javax.swing.JFormattedTextField();
        panelObs = new org.jdesktop.swingx.JXPanel();
        scrollPane = new javax.swing.JScrollPane();
        textAreaObs = new javax.swing.JTextArea();
        panelPhones = new org.jdesktop.swingx.JXPanel();
        labelHome = new org.jdesktop.swingx.JXLabel();
        labelBusiness = new org.jdesktop.swingx.JXLabel();
        labelCel = new org.jdesktop.swingx.JXLabel();
        textFieldHome = new javax.swing.JTextField();
        textFieldCel = new javax.swing.JTextField();
        textFieldBusiness = new javax.swing.JTextField();
        buttonCancel = new javax.swing.JButton();
        buttonApply = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        buttonPrint = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonRevert = new javax.swing.JButton();
        header = new org.jdesktop.swingx.JXHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        panelAddress.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        labelStreet.setText("Logradouro:");

        labelCity.setText("Cidade:");

        labelDistrict.setText("Bairro:");

        labelZipcode.setText("CEP:");

        try {
            formattedTextFieldZipCode.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldZipCode.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelState.setText("Estado:");

        javax.swing.GroupLayout panelAddressLayout = new javax.swing.GroupLayout(panelAddress);
        panelAddress.setLayout(panelAddressLayout);
        panelAddressLayout.setHorizontalGroup(
            panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStreet, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(labelDistrict, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textFieldStreet, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddressLayout.createSequentialGroup()
                        .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFieldCity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldDistrict))
                        .addGap(18, 18, 18)
                        .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelState, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(labelZipcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(formattedTextFieldZipCode, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(textFieldState))))
                .addContainerGap())
        );
        panelAddressLayout.setVerticalGroup(
            panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStreet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedTextFieldZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelData.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        labelId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelId.setText("Código:");

        textFieldId.setEnabled(false);

        labelName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelName.setText("Nome:");

        labelEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelEmail.setText("E-mail:");

        labelRegistry.setText("CPF/CNPJ:");

        labelBirthDate.setText("Data Nasc.:");

        labelRate.setText("Taxa de Juros:");

        try {
            formattedTextFieldBirthDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRegistry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldName)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addComponent(textFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createSequentialGroup()
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formattedTextFieldBirthDate)
                            .addComponent(textFieldRegistry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldRate, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(textFieldEmail))))
                .addContainerGap())
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRegistry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldRegistry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedTextFieldBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelObs.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));

        textAreaObs.setColumns(20);
        textAreaObs.setRows(5);
        scrollPane.setViewportView(textAreaObs);

        javax.swing.GroupLayout panelObsLayout = new javax.swing.GroupLayout(panelObs);
        panelObs.setLayout(panelObsLayout);
        panelObsLayout.setHorizontalGroup(
            panelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelObsLayout.setVerticalGroup(
            panelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObsLayout.createSequentialGroup()
                .addComponent(scrollPane)
                .addContainerGap())
        );

        panelPhones.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefones"));

        labelHome.setText("Residencial: ");

        labelBusiness.setText("Comercial: ");

        labelCel.setText("Celular:");

        javax.swing.GroupLayout panelPhonesLayout = new javax.swing.GroupLayout(panelPhones);
        panelPhones.setLayout(panelPhonesLayout);
        panelPhonesLayout.setHorizontalGroup(
            panelPhonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPhonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPhonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelCel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelBusiness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHome, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPhonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldCel, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(textFieldBusiness)
                    .addComponent(textFieldHome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPhonesLayout.setVerticalGroup(
            panelPhonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPhonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPhonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPhonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPhonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBusiness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldBusiness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormLayout.createSequentialGroup()
                        .addComponent(panelPhones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelPhones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panelObs, panelPhones});

        buttonCancel.setText("Cancelar");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonApply.setText("Aplicar");
        buttonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyActionPerformed(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.print.png"))); // NOI18N
        buttonPrint.setFocusable(false);
        buttonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(buttonPrint);

        buttonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.delete.png"))); // NOI18N
        buttonRemove.setToolTipText("Deletar");
        buttonRemove.setFocusable(false);
        buttonRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonRemove);

        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.edit.png"))); // NOI18N
        buttonEdit.setToolTipText("Editar");
        buttonEdit.setFocusable(false);
        buttonEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonEdit);

        buttonRevert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x22.revert.png"))); // NOI18N
        buttonRevert.setToolTipText("Reverter");
        buttonRevert.setFocusable(false);
        buttonRevert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRevert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(buttonRevert);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonApply, buttonCancel});

        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonApply)
                    .addComponent(buttonCancel))
                .addContainerGap())
        );

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.client.png"))); // NOI18N
        header.setTitle("Visualizar Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        if (editing) {
            if (apply()) {
                editing = false;
                setFormEnable(editing);
                buttonRevert.setEnabled(editing);
                buttonApply.setText("Fechar");
            }   
        } else {
            dispose();
        }
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        if (!editing || client.equals(newOne)) {
            cancel();
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Realmente deseja cancelar as alterações?",
                    "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                cancel();
                revert(false);
            }
        }
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        editing = true;
        buttonRevert.setEnabled(editing);
        setFormEnable(true);
        buttonApply.setText("Aplicar");
        textFieldName.requestFocusInWindow();
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        delete();
    }//GEN-LAST:event_buttonRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonRevert;
    private javax.swing.JFormattedTextField formattedTextFieldBirthDate;
    private javax.swing.JFormattedTextField formattedTextFieldZipCode;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.swingx.JXLabel labelBirthDate;
    private org.jdesktop.swingx.JXLabel labelBusiness;
    private org.jdesktop.swingx.JXLabel labelCel;
    private org.jdesktop.swingx.JXLabel labelCity;
    private org.jdesktop.swingx.JXLabel labelDistrict;
    private org.jdesktop.swingx.JXLabel labelEmail;
    private org.jdesktop.swingx.JXLabel labelHome;
    private org.jdesktop.swingx.JXLabel labelId;
    private org.jdesktop.swingx.JXLabel labelName;
    private org.jdesktop.swingx.JXLabel labelRate;
    private org.jdesktop.swingx.JXLabel labelRegistry;
    private org.jdesktop.swingx.JXLabel labelState;
    private org.jdesktop.swingx.JXLabel labelStreet;
    private org.jdesktop.swingx.JXLabel labelZipcode;
    private org.jdesktop.swingx.JXPanel panelAddress;
    private org.jdesktop.swingx.JXPanel panelData;
    private org.jdesktop.swingx.JXPanel panelForm;
    private org.jdesktop.swingx.JXPanel panelMain;
    private org.jdesktop.swingx.JXPanel panelObs;
    private org.jdesktop.swingx.JXPanel panelPhones;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textAreaObs;
    private javax.swing.JTextField textFieldBusiness;
    private javax.swing.JTextField textFieldCel;
    private javax.swing.JTextField textFieldCity;
    private javax.swing.JTextField textFieldDistrict;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldHome;
    private javax.swing.JTextField textFieldId;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldRate;
    private javax.swing.JTextField textFieldRegistry;
    private javax.swing.JTextField textFieldState;
    private javax.swing.JTextField textFieldStreet;
    // End of variables declaration//GEN-END:variables
    
    private boolean validate(boolean warn) {
        try {
            newOne = getClientFromForm();
            if (warn) {
                ChequeMate.showSuccessMessage(this, "Todos os valores foram validados com sucesso.");
            }
            return true;
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
            return false;
        }
    }
    
    private void revert(boolean ask) {
        if (ask) {
            int choice = JOptionPane.showConfirmDialog(this, "Todas as alterações serão desfeitas. Confirma?", 
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice==JOptionPane.NO_OPTION){
                return;
            }
        } 
        setupForm();
        newOne = client;
    }
    
    private void clearForm() {
        textFieldName.setText("");
        textFieldDistrict.setText("");
        textFieldStreet.setText("");
        textFieldCity.setText("");
        textFieldState.setText("");
        textFieldRegistry.setText("");
        textFieldCel.setText("");
        textFieldHome.setText("");
        textFieldBusiness.setText("");        
        textAreaObs.setText("");
        textFieldId.setText("");
        textFieldEmail.setText("");
        formattedTextFieldZipCode.setText("");
        textFieldRate.setText("");
        formattedTextFieldBirthDate.setText("");
    }
    
    private Client getClientFromForm() throws ChequeMateException {
        if (isEmpty()) {
            throw new ChequeMateException("Todos os campos estão vazios.", textFieldName);
        }
        String name = textFieldName.getText().toUpperCase();
        String registryNumber = Deformat.CPForCNPJ(textFieldRegistry.getText());
        String street = textFieldStreet.getText().trim();
        String district = textFieldDistrict.getText().trim();
        String city = textFieldCity.getText().trim();
        String state = textFieldState.getText().trim();        
        String zipcode = formattedTextFieldZipCode.getText().trim().replace("-", "");
        String obs = textAreaObs.getText().trim();
        String celPhone = textFieldCel.getText().trim();
        String businessPhone = textFieldBusiness.getText().trim();
        String homePhone = textFieldHome.getText().trim();
        String email = textFieldEmail.getText().trim();
        
        Client cli = new Client(name, registryNumber, new Address(street, district, city, state, zipcode),
                    new Phone(businessPhone, homePhone, celPhone), obs, email); 
        
        String strRate = textFieldRate.getText();
        if (!strRate.isEmpty()) {
            double rate = Double.parseDouble(Deformat.decimal(strRate));
            cli.setRate(rate);
        }    
        String strBirthDate = formattedTextFieldBirthDate.getText();
        GregorianCalendar birthDate = Convert.toGregorian(strBirthDate);
        if (birthDate != null) {
            cli.setBirthDate(birthDate);
        }
        String strId = textFieldId.getText().trim();
        cli.setId(Integer.parseInt(strId));
        return cli; 
    }
    
    private void setupForm() {
        textFieldId.setText(Format.clientId(client.getId()));
        textFieldName.setText(client.getName());
        textFieldDistrict.setText(client.getAddress().getDistrict());
        textFieldStreet.setText(client.getAddress().getStreet());
        textFieldCity.setText(client.getAddress().getCity());
        textFieldState.setText(client.getAddress().getState());
        textFieldRegistry.setText(client.getRegistryNumber());
        textFieldRegistry.postActionEvent();
        formattedTextFieldZipCode.setText(client.getAddress().getZipcode());
        textFieldCel.setText(client.getPhones().getCel());
        textFieldHome.setText(client.getPhones().getHome());
        textFieldBusiness.setText(client.getPhones().getBusiness());        
        textAreaObs.setText(client.getObs());
        textFieldEmail.setText(client.getEmail());
        if (client.getBirthDate()!=null) {
            formattedTextFieldBirthDate.setText(Format.date(client.getBirthDate()));
        }
        textFieldRate.setText(Format.decimal(client.getRate()));
    }
    
    private boolean isEmpty() {
        return (textFieldName.getText().isEmpty() &&
                textFieldDistrict.getText().isEmpty() &&
                textFieldStreet.getText().isEmpty() &&
                textFieldCity.getText().isEmpty() &&
                textFieldState.getText().isEmpty() &&
                textFieldRegistry.getText().isEmpty() &&
                textFieldCel.getText().isEmpty() &&
                textFieldHome.getText().isEmpty() &&
                textFieldBusiness.getText().isEmpty() &&        
                textAreaObs.getText().isEmpty() &&
                textFieldId.getText().isEmpty() && 
                formattedTextFieldZipCode.getText().contains(" ") && 
                formattedTextFieldBirthDate.getText().contains(" ") &&
                textFieldRate.getText().isEmpty());
    }
    
    
    private void setupComponents() {
        header.setTitle("Modo de Visualização e Edição");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/img/x16.client.png")).getImage());
        setupFocusComponents();
        textAreaObs.setLineWrap(true);
        textAreaObs.setWrapStyleWord(true);
        
        Verifier.set(textFieldRegistry, new RegistryNumberVerifier(true,true));
        Verifier.set(textFieldName, new TextVerifier());
        Verifier.set(textFieldCity, new TextVerifier());
        Verifier.set(textFieldStreet, new TextVerifier());
        Verifier.set(textFieldDistrict, new TextVerifier());
        Verifier.set(textFieldState, new StateVerifier());
        Verifier.set(textFieldEmail, new EmailVerifier());
        Verifier.set(textFieldRate, new PercentVerifier());
        
        textFieldRegistry.postActionEvent();
        formattedTextFieldBirthDate.setFocusLostBehavior(JFormattedTextField.COMMIT);
        formattedTextFieldZipCode.setFocusLostBehavior(JFormattedTextField.COMMIT);
        
        clearForm();
        setFormEnable(false);
        setupForm();
        buttonRevert.setEnabled(editing);
        buttonApply.setText("Fechar");
    }

    private void delete() {
        int choice = JOptionPane.showConfirmDialog(this, 
                "Realmente deseja excluir o cliente? Todos os cheques relacionados a ele serão apagados.",
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                clientControl.delete(client.getId());
                if (parent != null) {
                    parent.refresh();
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
            dispose();
        }   
    }
    
    private boolean apply() {
        boolean isValid = validate(false);
        if (client.equals(newOne)) {
            return true;
        }
        if (isValid) {
            try {
                if (update() == JOptionPane.YES_OPTION) {
                    ChequeMate.showSuccessMessage(this, "Cliente alterado com sucesso.");
                    client = newOne;
                    return true;
                } else {
                    textFieldName.requestFocusInWindow();
                }
            } catch (SQLException ex) {
                LOG.log(Level.WARNING, ex.getMessage(), ex);
            } 
        } 
        return false;
    }
    
    private int update() throws SQLException {
        int id = client.getId();
        int choice = JOptionPane.showConfirmDialog(this, "Deseja salvar as alterações feitas?",
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            clientControl.update(newOne);
            client = clientControl.get(id);
            if (parent != null) {
                parent.refresh();
            }
        } 
        return choice;
    }
    
    private void setupFocusComponents() {
        FocusPolicy.setDefaultTrasversalKeys(panelForm, FocusPolicy.BOTH_DIRECTIONS);
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldName);
        list.add(textFieldRegistry);
        list.add(textFieldEmail);
        list.add(formattedTextFieldBirthDate);
        list.add(textFieldRate);
        list.add(textFieldStreet);
        list.add(textFieldCity);
        list.add(textFieldState);
        list.add(textFieldDistrict);
        list.add(formattedTextFieldZipCode);
        list.add(textFieldHome);
        list.add(textFieldCel);
        list.add(textFieldBusiness);
        list.add(textAreaObs);
        list.add(buttonApply);
        setFocusTraversalPolicy(new FocusPolicy(list));     
    }
    
    private void setFormEnable(boolean b) {
        textFieldName.setEnabled(b);
        textFieldRegistry.setEnabled(b);
        textFieldEmail.setEnabled(b);
        formattedTextFieldBirthDate.setEnabled(b);
        textFieldRate.setEnabled(b);
        textFieldStreet.setEnabled(b);
        textFieldCity.setEnabled(b);       
        textFieldState.setEnabled(b);        
        textFieldDistrict.setEnabled(b);        
        formattedTextFieldZipCode.setEnabled(b);        
        textFieldHome.setEnabled(b);        
        textFieldCel.setEnabled(b);
        textFieldBusiness.setEnabled(b);
        textAreaObs.setEnabled(b); 
        buttonCancel.setEnabled(b);
    }

    private void cancel() {
        setFormEnable(false);
        revert(false);
        buttonApply.setText("Fechar");
        editing = false;
        buttonRevert.setEnabled(editing);
    }
    
}
