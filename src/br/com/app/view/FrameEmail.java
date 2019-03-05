package br.com.app.view;

import br.com.app.model.ClientManagement;
import br.com.app.jdbc.dao.ClientManagementDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class FrameEmail extends javax.swing.JFrame {

    public List<ClientManagement> clientList = new ArrayList<ClientManagement>();
    public ClientManagementDAO clientDao = new ClientManagementDAO();
    public int valueSelectedList;
    public String email;
            
    public FrameEmail() {
        initComponents();
        setIcon();
        clientList = clientDao.getClientEmails();
        
        DefaultListModel model = new DefaultListModel();
        
        for (ClientManagement client : clientList) {
                int code = client.getCode();    
                String emailColumn = client.getEmail();

                String columnCode = "<html><body> <font color='#6E3C55' font size='4'> Código: </font>";
                String columnEmail = "<html><body> <font color='#6E3C55' font size='4'> E-mail: </font>";

                model.addElement(columnCode + code + " | " + columnEmail + emailColumn);
        }        
        listEmails.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnListaEmails = new javax.swing.JPanel();
        lblRegisterClient = new javax.swing.JLabel();
        indicator1 = new javax.swing.JPanel();
        btnEnvioEmail = new javax.swing.JPanel();
        lblRegisterClient1 = new javax.swing.JLabel();
        indicator2 = new javax.swing.JPanel();
        btnEmailAjuda = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelTroca = new javax.swing.JPanel();
        panelVariant = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEmails = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(23, 35, 51));

        btnListaEmails.setBackground(new java.awt.Color(23, 35, 51));
        btnListaEmails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListaEmails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListaEmailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnListaEmailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListaEmailsMouseExited(evt);
            }
        });

        lblRegisterClient.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblRegisterClient.setForeground(new java.awt.Color(255, 255, 255));
        lblRegisterClient.setText("Lista de E-mails");

        indicator1.setBackground(new java.awt.Color(23, 35, 51));

        javax.swing.GroupLayout indicator1Layout = new javax.swing.GroupLayout(indicator1);
        indicator1.setLayout(indicator1Layout);
        indicator1Layout.setHorizontalGroup(
            indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        indicator1Layout.setVerticalGroup(
            indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnListaEmailsLayout = new javax.swing.GroupLayout(btnListaEmails);
        btnListaEmails.setLayout(btnListaEmailsLayout);
        btnListaEmailsLayout.setHorizontalGroup(
            btnListaEmailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListaEmailsLayout.createSequentialGroup()
                .addComponent(indicator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegisterClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnListaEmailsLayout.setVerticalGroup(
            btnListaEmailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(indicator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnListaEmailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegisterClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEnvioEmail.setBackground(new java.awt.Color(23, 35, 51));
        btnEnvioEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnvioEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnvioEmailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnvioEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnvioEmailMouseExited(evt);
            }
        });

        lblRegisterClient1.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblRegisterClient1.setForeground(new java.awt.Color(255, 255, 255));
        lblRegisterClient1.setText("Envio de Email");

        indicator2.setBackground(new java.awt.Color(23, 35, 51));

        javax.swing.GroupLayout indicator2Layout = new javax.swing.GroupLayout(indicator2);
        indicator2.setLayout(indicator2Layout);
        indicator2Layout.setHorizontalGroup(
            indicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        indicator2Layout.setVerticalGroup(
            indicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnEnvioEmailLayout = new javax.swing.GroupLayout(btnEnvioEmail);
        btnEnvioEmail.setLayout(btnEnvioEmailLayout);
        btnEnvioEmailLayout.setHorizontalGroup(
            btnEnvioEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEnvioEmailLayout.createSequentialGroup()
                .addComponent(indicator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegisterClient1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnEnvioEmailLayout.setVerticalGroup(
            btnEnvioEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(indicator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnEnvioEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegisterClient1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEmailAjuda.setBackground(new java.awt.Color(23, 35, 51));
        btnEmailAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmailAjudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmailAjudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmailAjudaMouseExited(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ocorreu um erro ?, Quer tirar uma dúvida ?");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nos envie um E-mail!");

        javax.swing.GroupLayout btnEmailAjudaLayout = new javax.swing.GroupLayout(btnEmailAjuda);
        btnEmailAjuda.setLayout(btnEmailAjudaLayout);
        btnEmailAjudaLayout.setHorizontalGroup(
            btnEmailAjudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEmailAjudaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(55, 55, 55))
        );
        btnEmailAjudaLayout.setVerticalGroup(
            btnEmailAjudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEmailAjudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmailAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaEmails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEnvioEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnListaEmails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnvioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(btnEmailAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTroca.setLayout(new java.awt.BorderLayout());

        panelVariant.setBackground(new java.awt.Color(145, 4, 72));

        listEmails.setSelectionBackground(new java.awt.Color(216, 222, 238));
        listEmails.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listEmails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listEmailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listEmails);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");

        jCheckBox1.setBackground(new java.awt.Color(145, 4, 72));
        jCheckBox1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Selecionar Todos");

        javax.swing.GroupLayout panelVariantLayout = new javax.swing.GroupLayout(panelVariant);
        panelVariant.setLayout(panelVariantLayout);
        panelVariantLayout.setHorizontalGroup(
            panelVariantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVariantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panelVariantLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jCheckBox1)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        panelVariantLayout.setVerticalGroup(
            panelVariantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVariantLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelVariantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTroca.add(panelVariant, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTroca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTroca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaEmailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaEmailsMouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_btnListaEmailsMouseClicked

    private void btnListaEmailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaEmailsMouseEntered

        onHover2(btnListaEmails);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnListaEmailsMouseEntered

    private void btnListaEmailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaEmailsMouseExited

        onLeaveHover2(btnListaEmails);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnListaEmailsMouseExited

    private void btnEnvioEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnvioEmailMouseClicked
    
    if(email != null && !email.equals("")) {
            PanelEmail panelEmail = new PanelEmail(email);
            panelVariant.setVisible(false);
            panelTroca.add(panelEmail);
            panelTroca.revalidate();
            panelEmail.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um E-mail da lista!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }
             
// TODO add your handling code here:
    }//GEN-LAST:event_btnEnvioEmailMouseClicked

    private void btnEnvioEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnvioEmailMouseEntered

        onHover2(btnEnvioEmail);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnvioEmailMouseEntered

    private void btnEnvioEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnvioEmailMouseExited
      
        onLeaveHover2(btnEnvioEmail);

// TODO add your handling code here:
    }//GEN-LAST:event_btnEnvioEmailMouseExited

    private void listEmailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listEmailsMouseClicked
        
        valueSelectedList = listEmails.getSelectedIndex();
        if(evt.getClickCount() == 2) {
            email = clientList.get(valueSelectedList).getEmail();
            JOptionPane.showMessageDialog(this, "Preparado para envio");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_listEmailsMouseClicked

    private void btnEmailAjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmailAjudaMouseClicked

         PanelEmail panelEmail = new PanelEmail("carlosdaniel.araujo@hotmail.com.br");
            panelVariant.setVisible(false);
            panelTroca.add(panelEmail);
            panelTroca.revalidate();
            panelEmail.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmailAjudaMouseClicked

    private void btnEmailAjudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmailAjudaMouseEntered

        onHover2(btnEmailAjuda);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmailAjudaMouseEntered

    private void btnEmailAjudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmailAjudaMouseExited

        onLeaveHover2(btnEmailAjuda);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmailAjudaMouseExited

    private void onHover2(JPanel pane1) {
        pane1.setBackground(new Color(71, 87, 108));
    }
    
    private void onLeaveHover2(JPanel pane1) {
        pane1.setBackground(new Color(23, 35, 51));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEmailAjuda;
    private javax.swing.JPanel btnEnvioEmail;
    private javax.swing.JPanel btnListaEmails;
    private javax.swing.JPanel indicator1;
    private javax.swing.JPanel indicator2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblRegisterClient;
    private javax.swing.JLabel lblRegisterClient1;
    private javax.swing.JList<String> listEmails;
    private javax.swing.JPanel panelTroca;
    private javax.swing.JPanel panelVariant;
    // End of variables declaration//GEN-END:variables
  private void setIcon() {
        setTitle(" Sent a e-mail");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
