package br.com.app.view;

import br.com.app.utils.PrintReport;
import br.com.app.model.TemporaryPriceTag;
import br.com.app.jdbc.dao.TemporaryPriceTagDAO;
import connection.connectionFactory.ConnectionFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author carlos
 */
public class BoxDialog extends javax.swing.JFrame {

    public String typeReport;
    public JTextField txtDateInitial;
    public JTextField txtDateEnd;
    public JTextField txtCode;
    public TemporaryPriceTagDAO priceTagDao = new TemporaryPriceTagDAO();
    public TemporaryPriceTag listPriceTag = new TemporaryPriceTag();
    
    public BoxDialog(String typeReport) {
        this.typeReport = typeReport;
        initComponents();
        setIcon();
        constructorParameters();
    }
    
    public void constructorParameters() {
            Font font = new Font("Segoe UI Light", Font.PLAIN, 13);
        switch(this.typeReport) {
            case "ProductStockReport":
                lblTitle.setText("Relatório Estoque de Produtos");
                JLabel lblDataInicial = new JLabel("Data Inicial: ");
                lblDataInicial.setFont(font);
                txtDateInitial = new JTextField();
                txtDateInitial.setPreferredSize(new Dimension(100, 23));
                JLabel lblDataFinal = new JLabel("Data Final: ");
                lblDataFinal.setFont(font);
                txtDateEnd = new JTextField();
                txtDateEnd.setPreferredSize(new Dimension(100, 23));
                panelParameters.add(lblDataInicial);
                panelParameters.add(txtDateInitial);
                panelParameters.add(lblDataFinal);
                panelParameters.add(txtDateEnd);
                break;
                
            case "PriceProduct":
                lblTitle.setText("Etiqueta de Produtos");
                font = new Font("Segoe UI Light", Font.PLAIN, 13);
                JLabel lblCodigo = new JLabel("Quantidade: ");
                lblCodigo.setFont(font);
                txtCode = new JTextField();
                txtCode.setPreferredSize(new Dimension(100, 23));
                panelParameters.add(lblCodigo);
                panelParameters.add(txtCode);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelParameters = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(145, 4, 72));

        lblTitle.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnImprimir.setBackground(new java.awt.Color(23, 35, 51));
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImprimirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnImprimirMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Imprimir");

        javax.swing.GroupLayout btnImprimirLayout = new javax.swing.GroupLayout(btnImprimir);
        btnImprimir.setLayout(btnImprimirLayout);
        btnImprimirLayout.setHorizontalGroup(
            btnImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnImprimirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnImprimirLayout.setVerticalGroup(
            btnImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnImprimirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cancelar");

        javax.swing.GroupLayout btnCancelarLayout = new javax.swing.GroupLayout(btnCancelar);
        btnCancelar.setLayout(btnCancelarLayout);
        btnCancelarLayout.setHorizontalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCancelarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        btnCancelarLayout.setVerticalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelParameters.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelParameters, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(panelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseClicked

        switch(this.typeReport) {
            case "ProductStockReport":
        new Thread() {
            @Override
            public void run() {
            try {
                Connection conn = new ConnectionFactory().getConnection();
                JasperPrint print = null;
               InputStream src = getClass().getResourceAsStream("ProductStockReport_1.jasper"); 
 
                Map parameters = new HashMap();
                
               String dateInitial = txtDateInitial.getText();
               String dateEnd =  txtDateEnd.getText();
               SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                
                Date dateInitialFormat = null;
                Date dateEndFormat = null;
                
                if(dateInitial == null || dateInitial.equals("")) {
                    dateInitialFormat = format.parse("01/01/2015");
                } else {
                    dateInitialFormat = format.parse(dateInitial);
                }
                
                if(dateEnd == null || dateEnd.equals("")) {
                   dateEndFormat = new Date();
                } else {
                   dateEndFormat = format.parse(dateEnd); 
                }
                                 
                parameters.put("dateInitial", dateInitialFormat);
                parameters.put("dateEnd", dateEndFormat);
                
                try {
                    print = JasperFillManager.fillReport(src, parameters, conn);
                } catch (JRException ex) {
                    Logger.getLogger(InitialApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JasperViewer view = new JasperViewer(print, false);
                view.setVisible(true);
                
            } catch (ParseException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                }.start();
                        break;
                    case "PriceProduct":
            new Thread() {
                @Override
                public void run() {
                    
                    String codePrint = txtCode.getText();
                    PrintReport print = new PrintReport();
                    int qtyTags = 0;
                    if(codePrint != null && !codePrint.equals("")) {
                        qtyTags = Integer.parseInt(codePrint);
                    }
                    List list = getParameters(qtyTags);
                    print.printReports(list);
                }
            }.start();
                break;
        }
        
    }//GEN-LAST:event_btnImprimirMouseClicked

    private void btnImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseEntered

        btnImprimir.setBackground(new Color(71, 87, 108));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirMouseEntered

    private void btnImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseExited

        btnImprimir.setBackground(new Color(23, 35, 51));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered

        btnCancelar.setBackground(new Color(71, 87, 108));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited

        btnCancelar.setBackground(new Color(23, 35, 51));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnImprimir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelParameters;
    // End of variables declaration//GEN-END:variables
  private void setIcon() {
        setTitle("");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("287782-32.png")));
    }
  
  public List getParameters(int qty) {
      List list = new ArrayList();
      for(int i = 0; i < qty; i++) {
        String test = "test";
        list.add(test); 
      }
        return list;
  }
}
