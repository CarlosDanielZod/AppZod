package br.com.app.view;

import br.com.app.model.ProductManagement;
import br.com.app.model.ProductSessionManagement;
import br.com.app.jdbc.dao.ProductManagementDAO;
import br.com.app.jdbc.dao.ProductSalesManagementDAO;
import br.com.app.jdbc.dao.ProductSessionManagementDAO;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class ListSelectProd extends javax.swing.JFrame {

    public ProductManagementDAO productDao = new ProductManagementDAO();
    public List<ProductManagement> productManager;
    public int valueSelectedList;
    public String productId;
    public ProductManagement newProduct;
    public ProductSalesManagementDAO productSalesDao = new ProductSalesManagementDAO();
    private JFrame parent;
    public int qtdeSolicitada = 0;
    public String idRetorno;
    public Boolean ok = false;
    public List<ProductSessionManagement> productListSession;
    public ProductSessionManagementDAO productSessionDao = new ProductSessionManagementDAO();
    
    public ListSelectProd(JFrame p, String idRetorno, int qtdeSolicitada) {
        this.parent = p;
        this.idRetorno = idRetorno;
        this.qtdeSolicitada = qtdeSolicitada;

        initComponents();
        setIcon();
        productListSession = productSessionDao.getListProductSession();
        updateList(productListSession, "updateDESC");
    }
    
    public void updateList(List<ProductSessionManagement> listProductSession, String filtrePor) {
         switch(filtrePor) {
             case "update":
                 listProductSession = productSessionDao.getListProductSession();
                 break;
             case "filtroAll":
//                 productManagerList = productDao.getFilterAllProd(filtroAll);
                 break;
             case "updateDESC":
                 listProductSession = productSessionDao.getListProductSession();
                 break;
         }
         
        DefaultListModel modelo = new DefaultListModel();
        for (ProductSessionManagement productSession : listProductSession) {
            String nameProd = productSession.getName();
            int codeAddProd = productSession.getCode_additional();
            int cod = productSession.getCode();
            int quantidade = productSession.getQty();
            String costAdd = productSession.getCost_additional();
            String labor = productSession.getLabor();
            String priceSales = productSession.getPrice_sales();
            String totalPriceSales = productSession.getTotalprice_sales();
            
            if(quantidade >= 1) {
                String columnCodigo = "<html><body> <font color='#6E3C55' font size='4'> Código: </font>"; 
                String columnNome = "<html><body> <font color='#6E3C55' font size='4'> Nome: </font>";
                String columnCodigoAdd = "<html><body> <font color='#6E3C55' font size='4'> Cód.Adicional: </font>";
                String columnLabor = "<html><body> <font color='green' font size='4'> Mão obra: </font>";
                String columncostAdd = "<html><body> <font color='green' font size='4'> Custo adicional: </font>";
                String columnPriceSales = "<html><body> <font color='green' font size='4'> Preço Venda: </font>";
                String columnQtde = "<html><body> <font color='green' font size='4'> Qtde: </font>";
                String columnTotalSales = "<html><body> <font color='green' font size='4'> Total Venda: </font>";
                
                        modelo.addElement(columnCodigo + cod + "  |  " + columnNome + nameProd + "  |  " + columnCodigoAdd + codeAddProd +  "  |  " + columnLabor
                                + labor + "  |  " + columncostAdd + costAdd + "  |  " + columnPriceSales + priceSales + "  |  " + columnQtde + quantidade + "  |  " + columnTotalSales + totalPriceSales);                    
                    } 
            }
            listSearchProd.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSearchProd = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lblSearchProd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        listSearchProd.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        listSearchProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listSearchProd.setSelectionBackground(new java.awt.Color(216, 222, 238));
        listSearchProd.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listSearchProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSearchProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listSearchProd);

        jPanel2.setBackground(new java.awt.Color(145, 4, 72));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearchProd.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblSearchProd.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchProd.setText("Pesquisar Produto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblSearchProd)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchProd))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listSearchProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSearchProdMouseClicked

        valueSelectedList = listSearchProd.getSelectedIndex();
//        
        String productSessionId = productListSession.get(valueSelectedList).getProduct_session_id();

        ProductSessionManagement productSessionReturn = productSessionDao.getProductSession(productSessionId);
        
        int qtde = 0;
            qtde = productSessionReturn.getQty();
        
        int qtdeRequisition = 0;
        String teste = JOptionPane.showInputDialog(null, "Quantidade disponível em estoque: " + qtde, 1);
//        
        if(teste != null && !teste.equals("")) {
            qtdeRequisition = Integer.parseInt(teste);
            qtde = qtde - qtdeRequisition;
            productSessionDao.alterProdSession(qtde, "0", productSessionId);
        }
        
            SharedTicket frame = (SharedTicket) parent;
            frame.setProductInClient(productSessionReturn, qtdeRequisition);
            frame.setVisible(true);
            dispose();

  // TODO add your handling code here:
    }//GEN-LAST:event_listSearchProdMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
// TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchProd;
    private javax.swing.JList<String> listSearchProd;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
  private void setIcon() {
        setTitle(" Seleção de Produtos");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
