package br.com.app.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.MultiPartEmail;
//import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author carlos
 */
public class PanelEmail extends javax.swing.JPanel {

    public String email;
//    public MultiPartEmail emailAnexo;
    public String arquivo;    
    
    public PanelEmail(String email) {
        this.email = email;
        initComponents();
        
        if(email != null & !email.equals("")) {
            txtDestino.setText(email);
        } else {
            this.email = "0";
        }
    }
    
//    public void sendEmail(String destinatario, String mensagem, String assunto) {
//        try {
//            Email emailSubmit = new SimpleEmail();
//            emailSubmit.setHostName("smtp.gmail.com");
//            emailSubmit.setSmtpPort(587);
//            emailSubmit.setAuthenticator(new DefaultAuthenticator("carlosdaniel.projeto128@gmail.com", "zodiaco12"));
//            emailSubmit.setSSLOnConnect(true);
//            emailSubmit.setFrom(destinatario);
//            emailSubmit.setSubject(assunto);
//            emailSubmit.setMsg(mensagem);
//            emailSubmit.addTo(destinatario);
//            
//            JOptionPane.showMessageDialog(this, "Enviando......", "Atenção", JOptionPane.INFORMATION_MESSAGE);
//            emailSubmit.send();
//            JOptionPane.showMessageDialog(this, "E-mail Enviado com sucesso!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
//        } catch (EmailException ex) {
//            Logger.getLogger(FrameEmail.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "Ops, ocorreu um problema", "Atenção!", JOptionPane.WARNING_MESSAGE);
//        }
//    }
//    
//    public void sendEmailAnexo(String destinatario, String mensagem, String assunto, String arquivo) {
//        try {
//            EmailAttachment anexo = new EmailAttachment();
//            anexo.setPath(arquivo); //caminho do arquivo (RAIZ_PROJETO/teste/teste.txt)
//            anexo.setDisposition(EmailAttachment.ATTACHMENT);
////            anexo.setDescription("Exemplo de arquivo anexo");
////            anexo.setName("S.png");
//            // configura o email
//            MultiPartEmail emai1l = new MultiPartEmail();
//
//            emai1l.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
//            emai1l.setSmtpPort(587);
//            emai1l.setAuthenticator(new DefaultAuthenticator("carlosdaniel.projeto128@gmail.com", "zodiaco12"));
//            emai1l.setSSLOnConnect(true);
//            emai1l.addTo(destinatario, ""); //destinatário
//            emai1l.setFrom(destinatario, ""); // remetente
//            emai1l.setSubject(assunto); // assunto do e-mail
//            emai1l.setMsg(mensagem); //conteudo do e-mail
//
//            emai1l.attach(anexo);
//            JOptionPane.showMessageDialog(this, "Enviando......", "Atenção", JOptionPane.INFORMATION_MESSAGE);
//            emai1l.send();
//            JOptionPane.showMessageDialog(this, "E-mail com anexo enviado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
//        } catch (EmailException ex) {
//            Logger.getLogger(PanelEmail.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "Ops, ocorreu um problema!", "Atenção", JOptionPane.WARNING_MESSAGE);
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensagem = new javax.swing.JTextPane();
        btnAnexar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAnexo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAssunto = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(110, 60, 85));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Destino:");

        txtDestino.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDestino.setEnabled(false);

        btnEnviar.setBackground(new java.awt.Color(110, 60, 85));
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviarMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enviar");

        javax.swing.GroupLayout btnEnviarLayout = new javax.swing.GroupLayout(btnEnviar);
        btnEnviar.setLayout(btnEnviarLayout);
        btnEnviarLayout.setHorizontalGroup(
            btnEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEnviarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        btnEnviarLayout.setVerticalGroup(
            btnEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEnviarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mensagem:");

        jScrollPane1.setViewportView(txtMensagem);

        btnAnexar.setBackground(new java.awt.Color(110, 60, 85));
        btnAnexar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnexar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnexarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnexarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnexarMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Anexar");

        javax.swing.GroupLayout btnAnexarLayout = new javax.swing.GroupLayout(btnAnexar);
        btnAnexar.setLayout(btnAnexarLayout);
        btnAnexarLayout.setHorizontalGroup(
            btnAnexarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAnexarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        btnAnexarLayout.setVerticalGroup(
            btnAnexarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAnexarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Anexo:");

        txtAnexo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAnexo.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Assunto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAssunto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnexo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDestino, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(btnAnexar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnexar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked

//        if(arquivo != null && !arquivo.equals("")) {
//            sendEmailAnexo(email, txtMensagem.getText(), "Smoother Systems!", arquivo);
//        } else {
//            sendEmail(email, txtMensagem.getText(), "teste");
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarMouseClicked

    private void btnEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseEntered

        btnEnviar.setBackground(new Color(151, 101, 126));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarMouseEntered

    private void btnEnviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseExited

        btnEnviar.setBackground(new Color(110,60,85));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarMouseExited

    private void btnAnexarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnexarMouseClicked
        
        
         JFileChooser chooser = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & PNG", "jpg", "png");
            chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
             arquivo = chooser.getSelectedFile().getAbsolutePath();
             txtAnexo.setText(arquivo);
        }
    
        
    }//GEN-LAST:event_btnAnexarMouseClicked

    private void btnAnexarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnexarMouseEntered

        btnAnexar.setBackground(new Color(151, 101, 126));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnexarMouseEntered

    private void btnAnexarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnexarMouseExited
    
        btnAnexar.setBackground(new Color(110,60,85));

// TODO add your handling code here:
    }//GEN-LAST:event_btnAnexarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAnexar;
    private javax.swing.JPanel btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAnexo;
    private javax.swing.JTextField txtAssunto;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextPane txtMensagem;
    // End of variables declaration//GEN-END:variables

}
