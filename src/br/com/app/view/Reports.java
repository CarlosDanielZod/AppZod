package br.com.app.view;

import java.awt.Color;
import java.awt.Toolkit;

/**
 *
 * @author carlos
 */
public class Reports extends javax.swing.JFrame {
    
    public Reports() {
        initComponents();
        setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnReportStock = new javax.swing.JPanel();
        lblReportStock = new javax.swing.JLabel();
        btnTags = new javax.swing.JPanel();
        lblTags = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data Inicial");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data Final");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Código");

        jPanel1.setBackground(new java.awt.Color(145, 4, 72));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Relatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnReportStock.setBackground(new java.awt.Color(255, 255, 255));
        btnReportStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportStockMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportStockMouseExited(evt);
            }
        });

        lblReportStock.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblReportStock.setForeground(new java.awt.Color(145, 4, 72));
        lblReportStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1886533-64.png"))); // NOI18N
        lblReportStock.setText("  Relatório Estoque de Produtos");
        lblReportStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReportStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReportStockMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReportStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReportStockMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnReportStockLayout = new javax.swing.GroupLayout(btnReportStock);
        btnReportStock.setLayout(btnReportStockLayout);
        btnReportStockLayout.setHorizontalGroup(
            btnReportStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReportStock, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        btnReportStockLayout.setVerticalGroup(
            btnReportStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReportStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnTags.setBackground(new java.awt.Color(255, 255, 255));
        btnTags.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTagsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTagsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTagsMousePressed(evt);
            }
        });

        lblTags.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lblTags.setForeground(new java.awt.Color(145, 4, 72));
        lblTags.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/if_tag1_216756 (1).png"))); // NOI18N
        lblTags.setText("  Etiquetas de Produtos");
        lblTags.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTags.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTagsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTagsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTagsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnTagsLayout = new javax.swing.GroupLayout(btnTags);
        btnTags.setLayout(btnTagsLayout);
        btnTagsLayout.setHorizontalGroup(
            btnTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnTagsLayout.setVerticalGroup(
            btnTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTags, javax.swing.GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(btnReportStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnReportStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblReportStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportStockMouseEntered

        btnReportStock.setBackground(new Color(240, 240, 240));
        // TODO add your handling code here:
    }//GEN-LAST:event_lblReportStockMouseEntered

    private void lblTagsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTagsMouseEntered

        btnTags.setBackground(new Color(240, 240, 240));

        // TODO add your handling code here:
    }//GEN-LAST:event_lblTagsMouseEntered

    private void lblReportStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportStockMouseExited

        btnReportStock.setBackground(new Color(255, 255, 255));

        // TODO add your handling code here:
    }//GEN-LAST:event_lblReportStockMouseExited

    private void lblTagsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTagsMouseExited

        btnTags.setBackground(new Color(255, 255, 255));

        // TODO add your handling code here:
    }//GEN-LAST:event_lblTagsMouseExited

    private void btnReportStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportStockMouseEntered

        btnReportStock.setBackground(new Color(240, 240, 240));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportStockMouseEntered

    private void btnReportStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportStockMouseExited

        btnReportStock.setBackground(new Color(255, 255, 255));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportStockMouseExited

    private void btnTagsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTagsMouseEntered

        btnTags.setBackground(new Color(240, 240, 240));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTagsMouseEntered

    private void btnTagsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTagsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTagsMousePressed

    private void btnTagsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTagsMouseExited

        btnTags.setBackground(new Color(255, 255, 255));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTagsMouseExited

    private void btnReportStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportStockMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportStockMouseClicked

    private void lblReportStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportStockMouseClicked
        
        BoxDialog boxDialog = new BoxDialog("ProductStockReport");
        boxDialog.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lblReportStockMouseClicked

    private void lblTagsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTagsMouseClicked

        BoxDialog boxDialog = new BoxDialog("PriceProduct");
        boxDialog.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTagsMouseClicked

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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnReportStock;
    private javax.swing.JPanel btnTags;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblReportStock;
    private javax.swing.JLabel lblTags;
    // End of variables declaration//GEN-END:variables
  private void setIcon() {
        setTitle(" Relatórios");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
