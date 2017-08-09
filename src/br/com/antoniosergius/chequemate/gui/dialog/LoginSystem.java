package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.gui.MainFrame;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import br.com.antoniosergius.lib.util.MySQLParameters;
import br.com.antoniosergius.lib.util.PasswordService;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginSystem extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(LoginSystem.class.getName());
    
    private MySQLParameters mysqlParameters;
    private final MainFrame mainFrame;
    
    public LoginSystem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        setResizable(false);
        setTitle("Credenciais");
        getRootPane().setDefaultButton(buttonLogar);
        this.mainFrame = (MainFrame) parent;
        mysqlParameters = ChequeMate.getConfiguration().getMysqlParameters();
    }
    
    public void setUser(String user) {
        textFieldUser.setText(user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        panelLogin = new org.jdesktop.swingx.JXPanel();
        labelUsuario = new org.jdesktop.swingx.JXLabel();
        labelSenha = new org.jdesktop.swingx.JXLabel();
        textFieldUser = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        labelCapsLock = new org.jdesktop.swingx.JXLabel();
        buttonLogar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.colorlock.png"))); // NOI18N
        header.setTitle("Login");
        header.setToolTipText("");

        labelUsuario.setText("Usuário:");

        labelSenha.setText("Senha:");

        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });

        labelCapsLock.setForeground(new java.awt.Color(255, 0, 0));
        labelCapsLock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCapsLock.setText("  ");
        labelCapsLock.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCapsLock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(labelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldUser)
                            .addComponent(passwordField))))
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCapsLock, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        buttonLogar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonLogar.setText("Logar");
        buttonLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonAlterar.setText("Editar");
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(buttonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(buttonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonAlterar, buttonCancelar, buttonLogar});

        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogar)
                    .addComponent(buttonCancelar))
                .addContainerGap())
        );

        panelPrincipalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonAlterar, buttonCancelar, buttonLogar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogarActionPerformed
        pressLogin();
    }//GEN-LAST:event_buttonLogarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
        textFieldUser.setText(mysqlParameters.getUser());
        passwordField.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed
        AlterMySQLParameter alterDataDialog = new AlterMySQLParameter(null, true);
        alterDataDialog.setVisible(true);
        mysqlParameters = ChequeMate.getConfiguration().getMysqlParameters();
        textFieldUser.setText(mysqlParameters.getUser());
        passwordField.setText(String.copyValueOf(alterDataDialog.getPassword()));
        buttonLogar.requestFocus();
    }//GEN-LAST:event_buttonAlterarActionPerformed

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        capsLockDetect();
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        capsLockDetect();
    }//GEN-LAST:event_passwordFieldKeyTyped

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_CAPS_LOCK) { 
            capsLockDetect();
        }
    }//GEN-LAST:event_passwordFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlterar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonLogar;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXLabel labelCapsLock;
    private org.jdesktop.swingx.JXLabel labelSenha;
    private org.jdesktop.swingx.JXLabel labelUsuario;
    private org.jdesktop.swingx.JXPanel panelLogin;
    private org.jdesktop.swingx.JXPanel panelPrincipal;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField textFieldUser;
    // End of variables declaration//GEN-END:variables

    private void login() throws ChequeMateException, SQLException, IOException, InterruptedException {
        String user = textFieldUser.getText();
        if (!mysqlParameters.getUser().equals(user)) {
            throw new ChequeMateException("Usuário inválido.");
        } 
        String encryptedPassword = PasswordService.encrypt(String.copyValueOf(passwordField.getPassword()));
        if (!mysqlParameters.getEncryptedPassword().equals(encryptedPassword)) {
            throw new ChequeMateException("Senha inválida.");
        }
        ChequeMate.setMysqlPassword(passwordField.getPassword());
        Connection conn = ChequeMate.init(mysqlParameters, passwordField.getPassword());
        if (conn.isValid(1000)) {
            dispose();
            mainFrame.setConnection(conn);
        }
    }
    
    public void pressLogin(){
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        try {
            login();
        } catch (ChequeMateException ex) {
            LOG.log(Level.INFO, ex.getMessage(), ex);
            ex.showExceptionMessage();
        } catch (SQLException ex) {
            mainFrame.setStatusBarMessage("Não Conectado");
            ChequeMate.showErrorMessage(mainFrame, 
            "Não foi possível estabelecer a conexão com o banco de dados.\n\n"
            + "Mensagem do sistema: "+ex.getMessage());
            LOG.log(Level.WARNING, ex.getMessage(), ex);
        } catch (IOException ex) {
            ChequeMate.showErrorMessage(mainFrame, 
            "Erro ao ler o arquivo de configuração.\n\n"
            + "Mensagem do sistema: "+ex.getMessage());
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            System.exit(-1);
        } catch (InterruptedException ex) {
            ChequeMate.showErrorMessage(mainFrame, 
            "Erro na Thread de criação do banco de dados.\n\n"
            + "Mensagem do sistema: "+ex.getMessage());
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            System.exit(-1);
        } finally {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    private void capsLockDetect() {
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
           labelCapsLock.setText("*A tecla CAPS LOCK está ativada!");
        } else {
           labelCapsLock.setText("");
        }
    }
}
