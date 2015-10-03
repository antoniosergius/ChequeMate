package br.com.antoniosergius.chequemate.gui.dialog;

import br.com.antoniosergius.chequemate.util.ChequeMate;

public class About extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;

    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setupComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new org.jdesktop.swingx.JXPanel();
        header = new org.jdesktop.swingx.JXHeader();
        panelInfo = new org.jdesktop.swingx.JXPanel();
        panelDesenvolvedor = new org.jdesktop.swingx.JXPanel();
        labelNome = new org.jdesktop.swingx.JXLabel();
        labelEmail = new org.jdesktop.swingx.JXLabel();
        labelTelefones = new org.jdesktop.swingx.JXLabel();
        labelNomeDyn = new org.jdesktop.swingx.JXLabel();
        labelEmailDyn = new org.jdesktop.swingx.JXLabel();
        labelTelefonesDyn = new org.jdesktop.swingx.JXLabel();
        labelImagem = new org.jdesktop.swingx.JXLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        labelVersaoChequeMate = new org.jdesktop.swingx.JXLabel();
        labelJavaHome = new org.jdesktop.swingx.JXLabel();
        labelJavaVersao = new org.jdesktop.swingx.JXLabel();
        labelSistemaOperacional = new org.jdesktop.swingx.JXLabel();
        labelDirChequeMate = new org.jdesktop.swingx.JXLabel();
        labelDirUsuario = new org.jdesktop.swingx.JXLabel();
        labelNomeUsuario = new org.jdesktop.swingx.JXLabel();
        labelVersaoChequeMateDyn = new org.jdesktop.swingx.JXLabel();
        labelJavaHomeDyn = new org.jdesktop.swingx.JXLabel();
        labelJavaVersaoDyn = new org.jdesktop.swingx.JXLabel();
        labelSistemaOperacionalDyn = new org.jdesktop.swingx.JXLabel();
        labelDirChequeMateDyn = new org.jdesktop.swingx.JXLabel();
        labelNomeUsuarioDyn = new org.jdesktop.swingx.JXLabel();
        labelDirUsuarioDyn = new org.jdesktop.swingx.JXLabel();
        buttonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre o Sistema e o Desenvolvedor");

        header.setToolTipText("");
        header.setDescription("");
        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x16.info.png"))); // NOI18N
        header.setTitle("ChequeMate - Informações");

        panelDesenvolvedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Desenvolvedor"));

        labelNome.setText("Nome:");

        labelEmail.setText("E-mail:");

        labelTelefones.setText("Telefones:");

        labelNomeDyn.setText("Antônio Sérgio Garcia Ferreira");

        labelEmailDyn.setText("antoniosergio@mail.com");

        labelTelefonesDyn.setText("(37) 8809-1457");

        labelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x64.java.png"))); // NOI18N
        labelImagem.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelDesenvolvedorLayout = new javax.swing.GroupLayout(panelDesenvolvedor);
        panelDesenvolvedor.setLayout(panelDesenvolvedorLayout);
        panelDesenvolvedorLayout.setHorizontalGroup(
            panelDesenvolvedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDesenvolvedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDesenvolvedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDesenvolvedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelNomeDyn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmailDyn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTelefonesDyn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addComponent(labelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDesenvolvedorLayout.setVerticalGroup(
            panelDesenvolvedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDesenvolvedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDesenvolvedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDesenvolvedorLayout.createSequentialGroup()
                        .addGroup(panelDesenvolvedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNomeDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDesenvolvedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmailDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDesenvolvedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTelefonesDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(labelImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sistema"));

        labelVersaoChequeMate.setText("ChequeMate Versão: ");

        labelJavaHome.setText("Diretório Java JRE: ");

        labelJavaVersao.setText("Versão Java:");

        labelSistemaOperacional.setText("Sistema Operacional: ");

        labelDirChequeMate.setText("Diretório do ChequeMate:");

        labelDirUsuario.setText("Diretório do Usuário:");

        labelNomeUsuario.setText("Nome do Usuário:");

        labelVersaoChequeMateDyn.setText(" ");

        labelJavaHomeDyn.setText(" ");

        labelJavaVersaoDyn.setText(" ");

        labelSistemaOperacionalDyn.setText(" ");

        labelDirChequeMateDyn.setText(" ");

        labelNomeUsuarioDyn.setText(" ");

        labelDirUsuarioDyn.setText(" ");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDirChequeMate, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(labelSistemaOperacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelJavaVersao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelJavaHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelVersaoChequeMate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDirUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelVersaoChequeMateDyn, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(labelJavaHomeDyn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelJavaVersaoDyn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSistemaOperacionalDyn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDirChequeMateDyn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNomeUsuarioDyn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDirUsuarioDyn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVersaoChequeMate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelVersaoChequeMateDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJavaVersao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJavaVersaoDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSistemaOperacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSistemaOperacionalDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomeUsuarioDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDirUsuarioDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDirChequeMate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDirChequeMateDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJavaHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJavaHomeDyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        buttonFechar.setText("Fechar");
        buttonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDesenvolvedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addComponent(panelDesenvolvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void buttonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_buttonFecharActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFechar;
    private org.jdesktop.swingx.JXHeader header;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXLabel labelDirChequeMate;
    private org.jdesktop.swingx.JXLabel labelDirChequeMateDyn;
    private org.jdesktop.swingx.JXLabel labelDirUsuario;
    private org.jdesktop.swingx.JXLabel labelDirUsuarioDyn;
    private org.jdesktop.swingx.JXLabel labelEmail;
    private org.jdesktop.swingx.JXLabel labelEmailDyn;
    private org.jdesktop.swingx.JXLabel labelImagem;
    private org.jdesktop.swingx.JXLabel labelJavaHome;
    private org.jdesktop.swingx.JXLabel labelJavaHomeDyn;
    private org.jdesktop.swingx.JXLabel labelJavaVersao;
    private org.jdesktop.swingx.JXLabel labelJavaVersaoDyn;
    private org.jdesktop.swingx.JXLabel labelNome;
    private org.jdesktop.swingx.JXLabel labelNomeDyn;
    private org.jdesktop.swingx.JXLabel labelNomeUsuario;
    private org.jdesktop.swingx.JXLabel labelNomeUsuarioDyn;
    private org.jdesktop.swingx.JXLabel labelSistemaOperacional;
    private org.jdesktop.swingx.JXLabel labelSistemaOperacionalDyn;
    private org.jdesktop.swingx.JXLabel labelTelefones;
    private org.jdesktop.swingx.JXLabel labelTelefonesDyn;
    private org.jdesktop.swingx.JXLabel labelVersaoChequeMate;
    private org.jdesktop.swingx.JXLabel labelVersaoChequeMateDyn;
    private org.jdesktop.swingx.JXPanel panelDesenvolvedor;
    private org.jdesktop.swingx.JXPanel panelInfo;
    private org.jdesktop.swingx.JXPanel panelMain;
    // End of variables declaration//GEN-END:variables

    private void setupComponents() {
        setLocationRelativeTo(null);
        labelDirChequeMateDyn.setText(System.getProperty("user.dir"));
        labelDirUsuarioDyn.setText(System.getProperty("user.home"));
        labelJavaHomeDyn.setText(System.getProperty("java.home"));
        labelJavaVersaoDyn.setText(System.getProperty("java.version"));
        labelNomeUsuarioDyn.setText(System.getProperty("user.name"));
        labelSistemaOperacionalDyn.setText(System.getProperty("os.name")+
                " "+System.getProperty("os.arch"));
        labelVersaoChequeMateDyn.setText(ChequeMate.VERSION);
    }
}
