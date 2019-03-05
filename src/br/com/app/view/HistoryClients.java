package br.com.app.view;

import br.com.app.model.ProductClousureManagement;
import br.com.app.model.TicketsManagement;
import br.com.app.jdbc.dao.ProductClousureManagementDAO;
import br.com.app.jdbc.dao.TicketsManagementDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author carlos
 */
public class HistoryClients extends javax.swing.JFrame {

    public TicketsManagement sharedTicket = null;
    public TicketsManagementDAO ticketDao = new TicketsManagementDAO();
    public List<ProductClousureManagement> productClousureList = new ArrayList<ProductClousureManagement>();
    public ProductClousureManagementDAO productClousureDao = new ProductClousureManagementDAO();
    public PanelReceiveClients panelReceiveClients;        
    public PanelButtonProduct buttonProduct;
    public JPanel panelReceiveTickets = new JPanel();

    
    public HistoryClients(TicketsManagement sharedTicket) {
        this.sharedTicket = sharedTicket;
        initComponents();

        panelReceiveClients = new PanelReceiveClients(this.sharedTicket.getTicket(), this.sharedTicket.getName_client(), 
                this.sharedTicket.getPhone1(), this.sharedTicket.getEmail());
        
        panelReceiveClient.add(panelReceiveClients);
        panelReceiveClients.setVisible(true);
        initHistory();
    }
    
    public void personaPanel(JPanel panel) {
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.setSize(new Dimension(0, 0));
        panel.setMaximumSize(new Dimension(250, 3000));
        panel.setMinimumSize(new Dimension(250, 3000));
        panel.setPreferredSize(new Dimension(900, 3000));                    
    }
        
    public void initHistory() {

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(300, 1000));
        JPanel p = new JPanel();
        personaPanel(p);
        panelReceiveTickets = new JPanel();
        panelReceiveTickets.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelReceiveTickets.setPreferredSize(new Dimension(500, 1000));
        
        panelReceiveTickets.setLayout(new FlowLayout(0, -60, 5)); //FlowLayout(400, 5, 5)

        productClousureList = productClousureDao.getProductClousureByTicket(sharedTicket.getE_ticket_id());
        List<String> productSessionPoint = new ArrayList<String>();
        Color color = null;
        
        for(ProductClousureManagement productClousure : productClousureList) {
            String productSessionId = productClousure.getProduct_session_id();

            buttonProduct = new PanelButtonProduct(color, productClousure.getCode(), productClousure.getName(), productClousure.getType(),
                    productClousure.getPrice_sales(), productClousure.getQty(), productClousure.getTotalprice_sales(), productClousure.getE_product_close_id());
            productSessionPoint.add(productClousure.getProduct_session_id());
            
            p.add(buttonProduct);         
            panelReceiveTickets.add(p);
            scroll.setViewportView(panelReceiveTickets);
            panelReceiveProducts.add(scroll);
        }
    }
//                            color = new Color(145, 4, 72);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelReceiveProductPayment = new javax.swing.JPanel();
        panelReceiveClient = new javax.swing.JPanel();
        panelReceiveProducts = new javax.swing.JPanel();
        panelPayment = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(145, 4, 72));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Histórico");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1173, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelReceiveProductPayment.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelReceiveProductPaymentLayout = new javax.swing.GroupLayout(panelReceiveProductPayment);
        panelReceiveProductPayment.setLayout(panelReceiveProductPaymentLayout);
        panelReceiveProductPaymentLayout.setHorizontalGroup(
            panelReceiveProductPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1254, Short.MAX_VALUE)
        );
        panelReceiveProductPaymentLayout.setVerticalGroup(
            panelReceiveProductPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        panelReceiveClient.setLayout(new java.awt.BorderLayout());

        panelReceiveProducts.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelPaymentLayout = new javax.swing.GroupLayout(panelPayment);
        panelPayment.setLayout(panelPaymentLayout);
        panelPaymentLayout.setHorizontalGroup(
            panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPaymentLayout.setVerticalGroup(
            panelPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelReceiveProductPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelReceiveClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelReceiveProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelReceiveClient, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelReceiveProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelReceiveProductPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelPayment;
    private javax.swing.JPanel panelReceiveClient;
    private javax.swing.JPanel panelReceiveProductPayment;
    private javax.swing.JPanel panelReceiveProducts;
    // End of variables declaration//GEN-END:variables
}
