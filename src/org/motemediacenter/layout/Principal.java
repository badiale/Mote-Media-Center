/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 26/05/2011, 11:44:44
 */

package org.motemediacenter.layout;

import java.io.File;
import org.motemediacenter.core.MoteSearch;

/**
 *
 * @author badiale
 */
public class Principal extends javax.swing.JFrame {
    private MoteSearch ms;

    /** Creates new form Principal */
    public Principal() {
        ms = new MoteSearch();

        initComponents();

        lstRecent.addFile(new File("/dados/Música/Escolher/Nightwish/Once/02 - Wish I Had An Angel.mp3"));
        lstRecent.addFile(new File("/dados/Vídeos/Cade meu Headphone (completo).avi"));
        lstFile.loadPath(System.getProperty("user.dir"));
        lstFile.setShowNavigation(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMote = new javax.swing.JPanel();
        lblMoteStatus = new javax.swing.JLabel();
        lblMoteStatusText = new javax.swing.JLabel();
        lblMoteBatery = new javax.swing.JLabel();
        lblMoteBateryText = new javax.swing.JLabel();
        panRecent = new javax.swing.JPanel();
        lstRecent = new org.motemediacenter.layout.ListaArquivos();
        panFile = new javax.swing.JPanel();
        lstFile = new org.motemediacenter.layout.ListaArquivos();
        mnuPrincipal = new javax.swing.JMenuBar();
        mnuPrincipalArquivo = new javax.swing.JMenu();
        mnuPrincipalConectar = new javax.swing.JMenuItem();
        mnuPrincipalSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mote Media Center");
        setName("frmPrincipal"); // NOI18N

        panMote.setBorder(javax.swing.BorderFactory.createTitledBorder("Wii Mote"));
        panMote.setName("panMote"); // NOI18N

        lblMoteStatus.setText("Estado do controle");
        lblMoteStatus.setName("lblMoteStatus"); // NOI18N

        lblMoteStatusText.setText("Ok");
        lblMoteStatusText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblMoteStatusText.setName("lblMoteStatusText"); // NOI18N

        lblMoteBatery.setText("Bateria");
        lblMoteBatery.setName("lblMoteBatery"); // NOI18N

        lblMoteBateryText.setText("100%");
        lblMoteBateryText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblMoteBateryText.setName("lblMoteBateryText"); // NOI18N

        javax.swing.GroupLayout panMoteLayout = new javax.swing.GroupLayout(panMote);
        panMote.setLayout(panMoteLayout);
        panMoteLayout.setHorizontalGroup(
            panMoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMoteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMoteBatery)
                    .addComponent(lblMoteStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addGroup(panMoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblMoteStatusText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMoteBateryText, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addContainerGap())
        );
        panMoteLayout.setVerticalGroup(
            panMoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMoteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoteStatus)
                    .addComponent(lblMoteStatusText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panMoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoteBatery)
                    .addComponent(lblMoteBateryText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panRecent.setBorder(javax.swing.BorderFactory.createTitledBorder("Arquivos recentes"));
        panRecent.setName("panRecent"); // NOI18N

        lstRecent.setName("lstRecent"); // NOI18N

        javax.swing.GroupLayout panRecentLayout = new javax.swing.GroupLayout(panRecent);
        panRecent.setLayout(panRecentLayout);
        panRecentLayout.setHorizontalGroup(
            panRecentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRecentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lstRecent, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        panRecentLayout.setVerticalGroup(
            panRecentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRecentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lstRecent, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        panFile.setBorder(javax.swing.BorderFactory.createTitledBorder("Escolher um arquivo"));
        panFile.setName("panFile"); // NOI18N

        lstFile.setName("lstFile"); // NOI18N

        javax.swing.GroupLayout panFileLayout = new javax.swing.GroupLayout(panFile);
        panFile.setLayout(panFileLayout);
        panFileLayout.setHorizontalGroup(
            panFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lstFile, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        panFileLayout.setVerticalGroup(
            panFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFileLayout.createSequentialGroup()
                .addComponent(lstFile, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        mnuPrincipal.setName("mnuPrincipal"); // NOI18N

        mnuPrincipalArquivo.setText("Arquivo");
        mnuPrincipalArquivo.setName("mnuPrincipalArquivo"); // NOI18N

        mnuPrincipalConectar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        mnuPrincipalConectar.setText("Conectar Wii Mote");
        mnuPrincipalConectar.setName("mnuPrincipalConectar"); // NOI18N
        mnuPrincipalConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrincipalConectarActionPerformed(evt);
            }
        });
        mnuPrincipalArquivo.add(mnuPrincipalConectar);

        mnuPrincipalSair.setText("Sair");
        mnuPrincipalSair.setName("mnuPrincipalSair"); // NOI18N
        mnuPrincipalSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrincipalSairActionPerformed(evt);
            }
        });
        mnuPrincipalArquivo.add(mnuPrincipalSair);

        mnuPrincipal.add(mnuPrincipalArquivo);

        setJMenuBar(mnuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panRecent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panMote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panMote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panRecent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuPrincipalSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPrincipalSairActionPerformed
        ms.disconnect();
        this.dispose();
    }//GEN-LAST:event_mnuPrincipalSairActionPerformed

    private void mnuPrincipalConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPrincipalConectarActionPerformed
        // TODO exibir uma janelinha com ajuda
        ms.connect();
    }//GEN-LAST:event_mnuPrincipalConectarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMoteBatery;
    private javax.swing.JLabel lblMoteBateryText;
    private javax.swing.JLabel lblMoteStatus;
    private javax.swing.JLabel lblMoteStatusText;
    private org.motemediacenter.layout.ListaArquivos lstFile;
    private org.motemediacenter.layout.ListaArquivos lstRecent;
    private javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JMenu mnuPrincipalArquivo;
    private javax.swing.JMenuItem mnuPrincipalConectar;
    private javax.swing.JMenuItem mnuPrincipalSair;
    private javax.swing.JPanel panFile;
    private javax.swing.JPanel panMote;
    private javax.swing.JPanel panRecent;
    // End of variables declaration//GEN-END:variables

}
