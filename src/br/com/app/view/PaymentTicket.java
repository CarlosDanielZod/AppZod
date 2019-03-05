package br.com.app.view;

import br.com.app.model.PaymentsManagement;
import br.com.app.model.ProductClousureManagement;
import br.com.app.jdbc.dao.PaymentsManagementDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class PaymentTicket extends javax.swing.JFrame {

    public List<ProductClousureManagement> ListProductClousure = null;
    Date dateCurrent = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Locale local = new Locale("pt", "BR");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(local);
    public double dbTotalFinal = 0;
    public double sinal = 0;
 
    public PaymentTicket(List<ProductClousureManagement> ListProductClousure) {
        this.ListProductClousure = ListProductClousure;
        setIcon();
        initComponents();
        txtDateCurrent.setText(dateFormat.format(dateCurrent));
        initPayments();
    }
    
    public void initPayments() {
        for(ProductClousureManagement productClousure : ListProductClousure) {
            String totalFormated = productClousure.getPrice_sales();
            int qtde = productClousure.getQty();
            String qtdeString = String.valueOf(qtde);
            double qty = Double.parseDouble(qtdeString);
            String totalDesigned1 = totalFormated.replace("R$", "");
            String totalDesigned2 = totalDesigned1.replaceAll("\\.", "");
            String totalOk = totalDesigned2.replace(",", ".");
            
            double dbTotal = Double.parseDouble(totalOk);
            dbTotalFinal += dbTotal * qty;
        }
        
        txtTotal.setText(currencyFormatter.format(dbTotalFinal));
        txtTotalRest.setText(currencyFormatter.format(dbTotalFinal));
    }

      public String formataData(String texto, char keyChar) {
        try {
            Integer.parseInt(keyChar + "");
        } catch (NumberFormatException e) {
        }
        if (texto != null) {
            if (keyChar != '\u0008' && keyChar != '\u007F') {
                if (texto.length() == 2 && !texto.contains("/")) {
                    texto = texto + "/";
                }
                if (texto.length() == 5 && !texto.endsWith("/")) {
                    texto = texto + "/";
                }
            }
        }
        return texto;
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDateCurrent = new javax.swing.JLabel();
        panelAlternative = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtSinal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalRest = new javax.swing.JLabel();
        btnOk = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtDataEntrega = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        checkDinheiro = new javax.swing.JCheckBox();
        checkCartaoCredito = new javax.swing.JCheckBox();
        checkCartaoDebito = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(145, 4, 72));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pagamento");

        txtDateCurrent.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtDateCurrent.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDateCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(145, 4, 72));
        jLabel2.setText("Formas de Pagamento");

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Total a pagar:");

        txtTotal.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(145, 4, 72));

        txtSinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSinalFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sinal:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setText("Total Restante:");

        txtTotalRest.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtTotalRest.setForeground(new java.awt.Color(145, 4, 72));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalRest, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalRest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnOk.setBackground(new java.awt.Color(23, 35, 51));
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOkMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("OK");

        javax.swing.GroupLayout btnOkLayout = new javax.swing.GroupLayout(btnOk);
        btnOk.setLayout(btnOkLayout);
        btnOkLayout.setHorizontalGroup(
            btnOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnOkLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(32, 32, 32))
        );
        btnOkLayout.setVerticalGroup(
            btnOkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnOkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCancelar.setBackground(new java.awt.Color(23, 35, 51));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cancelar");

        javax.swing.GroupLayout btnCancelarLayout = new javax.swing.GroupLayout(btnCancelar);
        btnCancelar.setLayout(btnCancelarLayout);
        btnCancelarLayout.setHorizontalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCancelarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        btnCancelarLayout.setVerticalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtDataEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataEntregaKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Prazo Entrega:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(145, 4, 72));
        jLabel9.setText("* É importante que informe o prazo de entrega");

        checkDinheiro.setText("Dinheiro");

        checkCartaoCredito.setText("Cartão - Crédito");

        checkCartaoDebito.setText("Cartão - Débito");

        javax.swing.GroupLayout panelAlternativeLayout = new javax.swing.GroupLayout(panelAlternative);
        panelAlternative.setLayout(panelAlternativeLayout);
        panelAlternativeLayout.setHorizontalGroup(
            panelAlternativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlternativeLayout.createSequentialGroup()
                .addGroup(panelAlternativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlternativeLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAlternativeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(panelAlternativeLayout.createSequentialGroup()
                .addGroup(panelAlternativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlternativeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(panelAlternativeLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAlternativeLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(checkDinheiro)
                        .addGap(10, 10, 10)
                        .addComponent(checkCartaoCredito)
                        .addGap(10, 10, 10)
                        .addComponent(checkCartaoDebito)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        panelAlternativeLayout.setVerticalGroup(
            panelAlternativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlternativeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(panelAlternativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDinheiro)
                    .addComponent(checkCartaoCredito)
                    .addComponent(checkCartaoDebito))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelAlternativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAlternativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelAlternativeLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(panelAlternativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAlternative, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAlternative, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered

        btnCancelar.setBackground(new Color(71, 87, 108));
    
            // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited

        btnCancelar.setBackground(new Color(23, 35, 51));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseEntered
      
        btnOk.setBackground(new Color(71, 87, 108));
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnOkMouseEntered

    private void btnOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseExited

        btnOk.setBackground(new Color(23, 35, 51));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkMouseExited

    private void txtSinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSinalFocusLost

        String sinalString = txtSinal.getText();
        String sinalDesigned1 = sinalString.replace("R$", "");
        String sinalDesigned2 = sinalDesigned1.replaceAll("\\.", "");
        String sinalNotFormated = sinalDesigned2.replace(",", ".");
        
        sinal = Double.parseDouble(sinalNotFormated);
        
        txtSinal.setText(currencyFormatter.format(sinal));
        
        double dbTotalRest = dbTotalFinal - sinal;
        txtTotalRest.setText(currencyFormatter.format(dbTotalRest));
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSinalFocusLost

    private void txtDataEntregaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataEntregaKeyReleased

        String dataFormtada = formataData(txtDataEntrega.getText(), evt.getKeyChar());
        txtDataEntrega.setText(dataFormtada);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataEntregaKeyReleased

    private void btnOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseClicked
       
        PaymentsManagementDAO paymentDao = new PaymentsManagementDAO();
        PaymentsManagement payments = new PaymentsManagement();
        
        for (ProductClousureManagement productClousure : ListProductClousure) {
            String e_payments_id = UUID.randomUUID().toString();
            payments.setE_payments_id(e_payments_id);
            payments.setE_product_close_id(productClousure.getE_product_close_id());
            
            if(checkDinheiro.isSelected()) {
                payments.setForm_payment("Dinheiro");
            } else if(checkCartaoCredito.isSelected()) {
                payments.setForm_payment("Credito");
            } else if(checkCartaoDebito.isSelected()) {
                payments.setForm_payment("Debito");
            } else if(checkDinheiro.isSelected() && checkCartaoCredito.isSelected()) {
                payments.setForm_payment("Dinheiro - Credito");
            } else if(checkDinheiro.isSelected() && checkCartaoDebito.isSelected()) {
                payments.setForm_payment("Dinheiro - Debito");
            }
            
            payments.setSinal(txtSinal.getText());
            payments.setTotal_payable(txtTotal.getText());
            payments.setTotal_reimaning(txtTotalRest.getText());
           
            if(txtDataEntrega.getText() != null) {
                payments.setDate_delivery(txtDataEntrega.getText());
            }
            if(dbTotalFinal == sinal) {
                payments.setIsPaid(true);    
                System.out.println("está tudo pago");
            } else {
                payments.setIsPaid(false);
            }
            
            paymentDao.addPayments(payments);
            JOptionPane.showMessageDialog(this, "Venda confirmada!, não se esqueça de agradecer o cliente!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnOk;
    private javax.swing.JCheckBox checkCartaoCredito;
    private javax.swing.JCheckBox checkCartaoDebito;
    private javax.swing.JCheckBox checkDinheiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelAlternative;
    private javax.swing.JTextField txtDataEntrega;
    private javax.swing.JLabel txtDateCurrent;
    private javax.swing.JTextField txtSinal;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JLabel txtTotalRest;
    // End of variables declaration//GEN-END:variables
  private void setIcon() {
        setTitle(" Pagamento");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
