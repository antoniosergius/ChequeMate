package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.gui.utils.FocusPolicy;
import br.com.antoniosergius.lib.util.MySQLParameters;
import br.com.antoniosergius.lib.util.PasswordService;
import br.com.antoniosergius.lib.util.io.Configuration;
import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class AlterMySQLParameter extends javax.swing.JDialog {
private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(AlterMySQLParameter.class.getName());
    
    private MySQLParameters current;
    private MySQLParameters newOne;
    private final LoginSystem login;
    private char[] password;
    private final ChequeMateException exception = new ChequeMateException();
    
    public AlterMySQLParameter(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setupComponents();
        login = null;
    }

    public AlterMySQLParameter(LoginSystem login, Frame owner, boolean modal) {
        super(owner, modal);
        this.login = login;
        initComponents();
        setupComponents();
    }
    
    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelServidor = new javax.swing.JLabel();
        labelPorta = new javax.swing.JLabel();
        labelBancoDeDados = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        textFieldServer = new javax.swing.JTextField();
        formattedTextFieldPort = new javax.swing.JFormattedTextField();
        textFieldDatabase = new javax.swing.JTextField();
        textFieldUser = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        buttonAplicar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        header = new org.jdesktop.swingx.JXHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Banco de Dados");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        labelServidor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelServidor.setText("Servidor:");

        labelPorta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPorta.setText("Porta:");

        labelBancoDeDados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBancoDeDados.setText("Base de Dados:");

        labelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelUsuario.setText("Usuário:");

        labelSenha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSenha.setText("Senha:");

        try {
            formattedTextFieldPort.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldPort.setToolTipText("");

        buttonAplicar.setText("Aplicar");
        buttonAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAplicarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.gear.png"))); // NOI18N
        header.setTitle("Configurações do MySQL");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(header, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(buttonAplicar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(buttonCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(23, 23, 23)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(labelBancoDeDados, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelServidor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelPorta, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelUsuario, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, labelSenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, textFieldUser)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, textFieldDatabase)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, formattedTextFieldPort)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, textFieldServer)
                            .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 158, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {buttonAplicar, buttonCancelar}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(header, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelServidor)
                    .add(textFieldServer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelPorta)
                    .add(formattedTextFieldPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelBancoDeDados)
                    .add(textFieldDatabase, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelUsuario)
                    .add(textFieldUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelSenha)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonAplicar)
                    .add(buttonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAplicarActionPerformed
        apply();
    }//GEN-LAST:event_buttonAplicarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        current = ChequeMate.getConfiguration().getMysqlParameters();
        if (current == null) {
            current = new MySQLParameters("localhost", 3306, "database", "user", "********");
        } 
        newOne = current.copy();
        setupForm(current);
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAplicar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JFormattedTextField formattedTextFieldPort;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel labelBancoDeDados;
    private javax.swing.JLabel labelPorta;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelServidor;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField textFieldDatabase;
    private javax.swing.JTextField textFieldServer;
    private javax.swing.JTextField textFieldUser;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setLocationRelativeTo(null);
        setResizable(false);
        setupFocusComponents();
        passwordField.requestFocusInWindow();
        formattedTextFieldPort.setFocusLostBehavior(JFormattedTextField.COMMIT);
    }
    
    private void setupForm(MySQLParameters mysqlParameters) {
        textFieldServer.setText(mysqlParameters.getServer());
        textFieldDatabase.setText(mysqlParameters.getDatabase());
        formattedTextFieldPort.setText(String.valueOf(mysqlParameters.getPort()));
        textFieldUser.setText(mysqlParameters.getUser());
        passwordField.requestFocusInWindow();
    }
    
    private MySQLParameters getFormData() throws ChequeMateException{
        ChequeMateException ex = exception;
        String server = textFieldServer.getText().trim();
        if (server.isEmpty()) {
            throw ex.retrieve("Favor digitar o servidor.", textFieldServer);
        } 
        String strPort = formattedTextFieldPort.getText().trim();
        if (strPort.isEmpty()) {
            throw ex.retrieve("Favor digitar a porta de comunicação.", formattedTextFieldPort);
        }    
        int port = Integer.parseInt(strPort);
        String database = textFieldDatabase.getText().trim();
        if (database.isEmpty()) {
            throw ex.retrieve("Favor digitar o nome do banco de dados.", textFieldDatabase);
        }
        String user = textFieldUser.getText().trim();
        if (user.isEmpty()) {
            throw ex.retrieve("Favor digitar o usuário do MySQL.", textFieldUser);
        }
        this.password = passwordField.getPassword();
        if (password.length==0) {
            throw ex.retrieve("Favor digitar a senha do usuário.", passwordField);
        }
        String encryptedPassword = PasswordService.encrypt(String.copyValueOf(password));
        return new MySQLParameters(server, port, database, user, encryptedPassword);
    }
    
    private boolean parseFormData(boolean warn) {
        try {
            newOne = getFormData();
            if (warn) {
                ChequeMate.showSuccessMessage(this, "Todos os valores foram validados com sucesso.");
            }
            return true;
        } catch (ChequeMateException ex) {
            ex.showExceptionMessage();
            return false;
        } 
    }
    
    private boolean apply() {
        boolean isValid = parseFormData(false);
        if (isValid) {
            try {
                if (saveConfigurationFile() == JOptionPane.YES_OPTION) {
                    ChequeMate.showSuccessMessage(this, "Configurações aplicadas com sucesso.");
                    current = newOne;
                    if (login != null) {
                        login.setUser(current.getUser());
                    }
                    dispose();
                    return true;
                } else {
                    passwordField.requestFocusInWindow();
                }
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            } 
        } 
        return false;
    }
    
    private int saveConfigurationFile() throws IOException {
        int choice = JOptionPane.showConfirmDialog(this, "Deseja salvar as novas configurações?", 
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            Configuration newConfig = new Configuration(newOne);
            newConfig.setLookAndFeel(ChequeMate.getConfiguration().getLookAndFeel());
            ChequeMate.XSTREAM.write(newConfig);
            ChequeMate.setConfiguration(newConfig);
        }
        return choice;
    }

    private void setupFocusComponents() {
        FocusPolicy.setDefaultTrasversalKeys(getRootPane(), FocusPolicy.BOTH_DIRECTIONS);
        ArrayList<Component> list = new ArrayList<>();
        list.add(textFieldServer);
        list.add(formattedTextFieldPort);
        list.add(textFieldDatabase);
        list.add(textFieldUser);
        list.add(passwordField);
        setFocusTraversalPolicy(new FocusPolicy(list));
    }

    
}
