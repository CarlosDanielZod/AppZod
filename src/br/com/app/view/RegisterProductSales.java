package br.com.app.view;

import br.com.app.model.ProductManagement;
import br.com.app.model.ProductSalesManagement;
import br.com.app.model.ProductSessionManagement;
import br.com.app.model.TemporaryPriceTag;
import br.com.app.jdbc.dao.ProductManagementDAO;
import br.com.app.jdbc.dao.ProductSalesManagementDAO;
import br.com.app.jdbc.dao.ProductSessionManagementDAO;
import br.com.app.jdbc.dao.TemporaryPriceTagDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class RegisterProductSales extends javax.swing.JFrame {

    public ProductManagementDAO productDao = new ProductManagementDAO();
    public List<ProductManagement> productManager;
    public int valueSelectedList;
    public ProductSalesManagement productSales;
    public ProductSalesManagementDAO productSalesDao = new ProductSalesManagementDAO();
    public List<ProductSalesManagement> productSalesList = new ArrayList<ProductSalesManagement>();
    public String productSelectedId;
    public List<String> listSalesProductId = new ArrayList<String>();
    public String precoCompra;
    public String filtroAll;
    public TemporaryPriceTag priceTag = new TemporaryPriceTag();
    public TemporaryPriceTagDAO priceTagDao = new TemporaryPriceTagDAO();
    
    public RegisterProductSales() {
        initComponents();
        setIcon();
        productManager = productDao.getListProduct();
        updateList(productManager, "update");
    }
    
    public void edit(boolean yesNo) {
         txtLabor.setEnabled(yesNo);
         txtCostAdditional.setEnabled(yesNo);
         txtPriceSales.setEnabled(yesNo);
         txtTotalSales.setEnabled(yesNo);
     }
    
    public void updateList(List<ProductManagement> productManagerList, String filtrePor) {
        productDao = new ProductManagementDAO();
        productSalesDao = new ProductSalesManagementDAO();
         switch(filtrePor) {
             case "update":
                 productManagerList = productDao.getListProduct();
                 break;
             case "filtroAll":
                 productManagerList = productDao.getFilterAllProd(filtroAll);
                 break;
             case "updateDESC":
                 productManagerList = productDao.getListDescProduct();
                 break;
         }
         
        DefaultListModel modelo = new DefaultListModel();
        for (ProductManagement product : productManagerList) {
            String productSalesId = product.getE_product_sales_id();
            String nameProd = product.getName();
            int codeAddProd = product.getCode_additional();
            int cod = product.getCode();
            boolean isActive = product.isIsActive();
            
            if(isActive == true) {
                String columnCodigo = "<html><body> <font color='#6E3C55' font size='4'> Código: </font>"; 
                String columnNome = "<html><body> <font color='#6E3C55' font size='4'> Nome: </font>";
                String columnCodigoAdd = "<html><body> <font color='#6E3C55' font size='4'> Cód.Adicional: </font>";

                ProductSalesManagement productSalesInit = productSalesDao.getProductSales(productSalesId);
                String pr = productSalesInit.getProduct_sales_id();
                String labor = productSalesInit.getLabor();
                String costAdd = productSalesInit.getCost_additional();
                String priceSales = productSalesInit.getPrice_sales();
                String totalPriceSales = productSalesInit.getTotalPrice_sales();
                
                if(pr != null && !pr.equals("")) {
                    if(pr.equals(productSalesId) || productSalesId.equals(pr)) {
                        String columnLabor = "<html><body> <font color='green' font size='4'> Mão obra: </font>";
                        String columncostAdd = "<html><body> <font color='green' font size='4'> Custo adicional: </font>";
                        String columnPriceSales = "<html><body> <font color='green' font size='4'> Preço Venda: </font>";
                        String columnTotalSales = "<html><body> <font color='green' font size='4'> Total Venda: </font>";
                
                        modelo.addElement(columnCodigo + cod + "  |  " + columnNome + nameProd + "  |  " + columnCodigoAdd + codeAddProd +  "  |  " + columnLabor
                                + labor + "  |  " + columncostAdd + costAdd + "  |  " + columnPriceSales + priceSales + "  |  " + columnTotalSales + totalPriceSales);                    
                    } 
                } else {
                    modelo.addElement(columnCodigo + cod + "  |  " + columnNome + nameProd + "  |  " + columnCodigoAdd + codeAddProd);
                  }
            }
        }
            listaProdutosEstoque.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarProduto = new javax.swing.JTextField();
        lblBuscarProduto = new javax.swing.JLabel();
        btnRemoverProduto = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblCodigoProduto = new javax.swing.JLabel();
        btnSalvarProduto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnEditarProduto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutosEstoque = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        txtPrecoProduto = new javax.swing.JTextField();
        txtNomeProduto = new javax.swing.JTextField();
        lblNomeProduto = new javax.swing.JLabel();
        lblPrecoProduto = new javax.swing.JLabel();
        lblTipoProduto = new javax.swing.JLabel();
        jcbTipoProduto1 = new javax.swing.JComboBox<>();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblCodigoAdicional = new javax.swing.JLabel();
        txtCodigoAdicional = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtLabor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCostAdditional = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPriceSales = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalSales = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(145, 4, 72));

        txtBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProdutoActionPerformed(evt);
            }
        });
        txtBuscarProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProdutoKeyReleased(evt);
            }
        });

        lblBuscarProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblBuscarProduto.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/212936-24.png"))); // NOI18N

        btnRemoverProduto.setBackground(new java.awt.Color(145, 4, 72));
        btnRemoverProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoverProduto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRemoverProdutoMouseMoved(evt);
            }
        });
        btnRemoverProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoverProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoverProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoverProdutoMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Remover");

        javax.swing.GroupLayout btnRemoverProdutoLayout = new javax.swing.GroupLayout(btnRemoverProduto);
        btnRemoverProduto.setLayout(btnRemoverProdutoLayout);
        btnRemoverProdutoLayout.setHorizontalGroup(
            btnRemoverProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRemoverProdutoLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18))
        );
        btnRemoverProdutoLayout.setVerticalGroup(
            btnRemoverProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRemoverProdutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        lblCodigoProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblCodigoProduto.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoProduto.setText("Cod");

        btnSalvarProduto.setBackground(new java.awt.Color(145, 4, 72));
        btnSalvarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvarProduto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSalvarProdutoMouseMoved(evt);
            }
        });
        btnSalvarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarProdutoMouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Salvar");

        javax.swing.GroupLayout btnSalvarProdutoLayout = new javax.swing.GroupLayout(btnSalvarProduto);
        btnSalvarProduto.setLayout(btnSalvarProdutoLayout);
        btnSalvarProdutoLayout.setHorizontalGroup(
            btnSalvarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalvarProdutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        btnSalvarProdutoLayout.setVerticalGroup(
            btnSalvarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalvarProdutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        btnEditarProduto.setBackground(new java.awt.Color(145, 4, 72));
        btnEditarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProduto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEditarProdutoMouseMoved(evt);
            }
        });
        btnEditarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarProdutoMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Editar");

        javax.swing.GroupLayout btnEditarProdutoLayout = new javax.swing.GroupLayout(btnEditarProduto);
        btnEditarProduto.setLayout(btnEditarProdutoLayout);
        btnEditarProdutoLayout.setHorizontalGroup(
            btnEditarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarProdutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnEditarProdutoLayout.setVerticalGroup(
            btnEditarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(lblBuscarProduto)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(lblCodigoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoProduto)
                            .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBuscarProduto))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnEditarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoverProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        listaProdutosEstoque.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        listaProdutosEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listaProdutosEstoque.setSelectionBackground(new java.awt.Color(216, 222, 238));
        listaProdutosEstoque.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listaProdutosEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProdutosEstoqueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listaProdutosEstoqueMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(listaProdutosEstoque);

        txtPrecoProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecoProduto.setEnabled(false);

        txtNomeProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNomeProduto.setEnabled(false);

        lblNomeProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblNomeProduto.setForeground(new java.awt.Color(0, 102, 102));
        lblNomeProduto.setText("Nome Produto:");

        lblPrecoProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblPrecoProduto.setForeground(new java.awt.Color(0, 102, 102));
        lblPrecoProduto.setText("Preço Compra:");

        lblTipoProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblTipoProduto.setForeground(new java.awt.Color(0, 102, 102));
        lblTipoProduto.setText("Tipo Produto:");

        jcbTipoProduto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbTipoProduto1.setEnabled(false);

        lblQuantidade.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblQuantidade.setForeground(new java.awt.Color(0, 102, 102));
        lblQuantidade.setText("Quantidade:");

        txtQuantidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQuantidade.setEnabled(false);

        lblTotal.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 102, 102));
        lblTotal.setText("Total da Compra:");

        txtTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotal.setEnabled(false);
        txtTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalFocusLost(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });

        lblCodigoAdicional.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblCodigoAdicional.setForeground(new java.awt.Color(0, 102, 102));
        lblCodigoAdicional.setText("Código Adicional:");

        txtCodigoAdicional.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigoAdicional.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Mão de Obra:");

        txtLabor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLabor.setEnabled(false);
        txtLabor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLaborFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Custo Adicional:");

        txtCostAdditional.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCostAdditional.setEnabled(false);
        txtCostAdditional.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCostAdditionalFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Preço Venda:");

        txtPriceSales.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPriceSales.setEnabled(false);
        txtPriceSales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceSalesFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Total Venda:");

        txtTotalSales.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalSales.setEnabled(false);
        txtTotalSales.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalSalesFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblNomeProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeProduto))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCodigoAdicional)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPrecoProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblTipoProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbTipoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCostAdditional, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPriceSales)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoProduto)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeProduto))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoProduto)
                    .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal)
                    .addComponent(lblCodigoAdicional)
                    .addComponent(txtCodigoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCostAdditional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPriceSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProdutoActionPerformed

    private void txtBuscarProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdutoKeyReleased

//        filtroAll = txtBuscarProduto.getText();
//
//        if(filtroAll != null) {
//            updateList(productManager, "filtroAll");
//        } else {
//            updateList(productManager, "update");
//        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProdutoKeyReleased

    private void btnSalvarProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseMoved

    private void btnSalvarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseClicked

        String product_id = productManager.get(valueSelectedList).getE_product_id();
        String product_sales_id = productManager.get(valueSelectedList).getE_product_sales_id();
        
        ProductSessionManagement productSession = new ProductSessionManagement();
        ProductSessionManagementDAO productSessionDao = new ProductSessionManagementDAO();
        
        if(product_sales_id != null && !product_sales_id.equals("")) {
            String labor = txtLabor.getText();
            String custoAdicional = txtCostAdditional.getText();
            String precoVenda = txtPriceSales.getText();
            String totalVenda = txtTotalSales.getText();
            productSalesDao.updateProductSales(labor, custoAdicional, precoVenda, totalVenda, product_sales_id);
            updateList(productManager, "update");
            JOptionPane.showMessageDialog(this, "Registro salvo!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            ProductManagement productForSession = productDao.getProduct(product_id);
            priceTagDao.updatePriceTag(precoVenda, productForSession.getCode());
            edit(false);
        } else {
            String testeId = UUID.randomUUID().toString();
        
            if(product_id != null) {
                productSales = new ProductSalesManagement();
                productSalesDao = new ProductSalesManagementDAO();
                productSales.setProduct_sales_id(testeId);
                productSales.setLabor(txtLabor.getText());
                productSales.setCost_additional(txtCostAdditional.getText());
                productSales.setPrice_sales(txtPriceSales.getText());
                productSales.setTotalPrice_sales(txtTotalSales.getText()); 

                productSalesDao.addProductSales(productSales);

                productDao.addProductPriceSales(testeId, product_id);

                String product_session_id = UUID.randomUUID().toString();
                ProductManagement productForSession = productDao.getProduct(product_id);

                productSession.setProduct_session_id(product_session_id);
                productSession.setE_product_id(product_id);
                productSession.setName(productForSession.getName());
                productSession.setCode(productForSession.getCode());
                productSession.setCode_additional(productForSession.getCode_additional());
                String discount = "0";
                productSession.setDiscount(discount);
                productSession.setType(productForSession.getType());
                productSession.setQty(productForSession.getQty());
                productSession.setLabor(txtLabor.getText());
                productSession.setCost_additional(txtCostAdditional.getText());
                productSession.setPrice_sales(txtPriceSales.getText());
                productSession.setTotalprice_sales(txtTotalSales.getText());
                
                productSessionDao.addProductSession(productSession);
                                productManager = productDao.getListProduct(); 
                JOptionPane.showMessageDialog(this, "Registro salvo!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                updateList(productManager, "update");
                edit(false);

                int qtdeNew = productForSession.getQty();
                for (int i = 0; i < qtdeNew; i++) {
                    priceTag.setCode(productForSession.getCode());
                    priceTag.setName(productForSession.getName());
                    priceTag.setType(productForSession.getType());
                    priceTag.setSalesPrice(txtPriceSales.getText());
                    priceTagDao.addPriceTag(priceTag);
                }
            } 
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseClicked

    private void btnSalvarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseEntered

        onHover2(btnSalvarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseEntered

    private void btnRemoverProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseMoved

    private void btnRemoverProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseClicked

        String product_sales_id = productManager.get(valueSelectedList).getE_product_sales_id();
        String product_id = productManager.get(valueSelectedList).getE_product_id();

            int option = JOptionPane.showConfirmDialog(this, "Remover o produto selecionado?", "Atenção!", JOptionPane.YES_NO_OPTION);

            if(option == JOptionPane.YES_OPTION) {
                productSalesDao.updateRemoveProd(null, product_id);
                productSalesDao.removeProductSales(product_sales_id);
                updateList(productManager, "update");
            }else {
            }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseClicked

    private void btnRemoverProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseEntered

        onHover2(btnRemoverProduto);
// TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseEntered

    private void listaProdutosEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProdutosEstoqueMouseClicked
       
        edit(false);
        valueSelectedList = listaProdutosEstoque.getSelectedIndex();
                
        productSalesDao = new ProductSalesManagementDAO();
        lblCodigoProduto.setText(""+productManager.get(valueSelectedList).getCode());
        txtNomeProduto.setText(productManager.get(valueSelectedList).getName());
        precoCompra = productManager.get(valueSelectedList).getPrice();
        txtPrecoProduto.setText(precoCompra);
        jcbTipoProduto1.setSelectedItem(productManager.get(valueSelectedList).getType());
        txtQuantidade.setText(""+productManager.get(valueSelectedList).getQty());
        txtCodigoAdicional.setText(""+ productManager.get(valueSelectedList).getCode_additional());
        txtTotal.setText(productManager.get(valueSelectedList).getTotal());
        
        String productSalesId = productManager.get(valueSelectedList).getE_product_sales_id();
        
        ProductSalesManagement productTSales = productSalesDao.getProductSales(productSalesId);
        txtLabor.setText(productTSales.getLabor());
        txtCostAdditional.setText(productTSales.getCost_additional());
        txtPriceSales.setText(productTSales.getPrice_sales());
        txtTotalSales.setText(productTSales.getTotalPrice_sales());

        // TODO add your handling code here:
    }//GEN-LAST:event_listaProdutosEstoqueMouseClicked

    private void listaProdutosEstoqueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProdutosEstoqueMouseEntered

        // TODO add your handling code here:
    }//GEN-LAST:event_listaProdutosEstoqueMouseEntered

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained

        if(txtPrecoProduto.getText() != null && txtQuantidade.getText() != null) {
            String preco = txtPrecoProduto.getText();
            String qty = txtQuantidade.getText();

            double dbPreco = Double.parseDouble(preco);
            double dbQty = Double.parseDouble(qty);

            double totaldb = dbPreco * dbQty;
            String total =  String.valueOf(totaldb);

            txtTotal.setText(total);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusGained

    private void txtTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusLost

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyReleased

    private void btnSalvarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseExited

        onLeaveHover2(btnSalvarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseExited

    private void btnRemoverProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseExited

        onLeaveHover2(btnRemoverProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseExited

    private void btnEditarProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseMoved

    private void btnEditarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseClicked

        edit(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseClicked

    private void btnEditarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseEntered
        onHover2(btnEditarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseEntered

    private void btnEditarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseExited
        onLeaveHover2(btnEditarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseExited

    private void txtLaborFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLaborFocusLost

         Locale locale = new Locale("pt", "BR");
         NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
         String precoFormated = txtLabor.getText();
         if(precoFormated != null && !precoFormated.equals("")) {
            String ttt = precoFormated.replace("R$", " ");
            String teste1234 = ttt.replaceAll("\\.", "");
            String ttt1 = teste1234.replace(",", ".");
            
            double teste11 = Double.parseDouble(ttt1);
            String precoFormatedd = currencyFormatter.format(teste11);
            txtLabor.setText(precoFormatedd); 
         } else {
             double teste11 = Double.parseDouble("0");
            String precoFormatedd = currencyFormatter.format(teste11);
            txtLabor.setText(precoFormatedd); 
         }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtLaborFocusLost

    private void txtCostAdditionalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCostAdditionalFocusLost

         Locale locale = new Locale("pt", "BR");
         NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
         String precoFormated = txtCostAdditional.getText();
         if(precoFormated != null && !precoFormated.equals("")) {
            String ttte = precoFormated.replace("R$", " ");
            String ttt = ttte.replaceAll("\\.", "");
            String teste1234 = ttt.replace(",", ".");
            double teste11 = Double.parseDouble(teste1234);
            String precoFormatedd = currencyFormatter.format(teste11);
            txtCostAdditional.setText(precoFormatedd); 
         } else {
             double teste11 = Double.parseDouble("0");
            String precoFormatedd = currencyFormatter.format(teste11);
            txtCostAdditional.setText(precoFormatedd); 
         }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostAdditionalFocusLost

    private void txtPriceSalesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceSalesFocusGained

        if(txtPrecoProduto != null && !txtPrecoProduto.getText().equals("") &&
                txtLabor.getText() != null && !txtLabor.getText().equals("") &&
                txtCostAdditional.getText() != null && !txtCostAdditional.getText().equals("")) {
            
            String precoProduto = txtPrecoProduto.getText();
            String maoObra = txtLabor.getText();
            String custoAdd = txtCostAdditional.getText();
            
            String precoProdutoReplace;
            String maoObraReplace;
            String custoAddReplace;

            if(precoProduto != null && !precoProduto.equals("")) {
                 precoProdutoReplace = precoProduto.replace("R$", " ");
            } else {
                precoProdutoReplace = "0";
            }
             String z = precoProdutoReplace;
             z = z.replaceAll("\\.", "");
             z = z.replace(',', '.');
                System.out.println(Double.parseDouble(z));
            
            if(maoObra != null && !maoObra.equals("")) {
                 maoObraReplace = maoObra.replace("R$", " ");
            } else {
                maoObraReplace = "0";
            }
             String x = maoObraReplace;
             x = x.replaceAll("\\.", "");
             x = x.replace(',', '.');
                System.out.println(Double.parseDouble(x));
                
            if(custoAdd != null && !custoAdd.equals("")) {
                 custoAddReplace = custoAdd.replace("R$", " ");
            } else {
                custoAddReplace = "0";
            }
             String y = custoAddReplace;
             y = y.replaceAll("\\.", "");
             y = y.replace(',', '.');
                System.out.println(Double.parseDouble(y));
            
            double dbPreco = Double.parseDouble(z);
            double dbMaoObra = Double.parseDouble(x);
            double dbCustoAdd = Double.parseDouble(y);
            double dbTotalPreco;
     
            dbTotalPreco = dbPreco + dbMaoObra + dbCustoAdd;
                    
            Locale locale = new Locale("pt", "BR");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            String totalFormated = currencyFormatter.format(dbTotalPreco);
            txtPriceSales.setText(totalFormated);
        }
         
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceSalesFocusGained

    private void txtTotalSalesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalSalesFocusGained

         if(txtPrecoProduto != null && !txtPrecoProduto.getText().equals("") &&
                txtLabor.getText() != null && !txtLabor.getText().equals("") &&
                txtCostAdditional.getText() != null && !txtCostAdditional.getText().equals("")) {
          
            String preco = txtPriceSales.getText();
            String qty = txtQuantidade.getText();
            String precoReplace;
            if(preco != null && !preco.equals("")) {
                 precoReplace = preco.replace("R$", " ");
            } else {
                precoReplace = "0";
            }
             String x = precoReplace;
             x = x.replaceAll("\\.", "");
             x = x.replace(',', '.');
        System.out.println(Double.parseDouble(x));
            
            double dbPreco = Double.parseDouble(x);
            double dbQty = Double.parseDouble(qty);
            double totaldb;
            if(dbQty == 0) {
                totaldb = dbPreco;
            } else {
                totaldb = dbPreco * dbQty;
            }
            Locale locale = new Locale("pt", "BR");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            String totalFormated = currencyFormatter.format(totaldb);
            txtTotalSales.setText(totalFormated);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalSalesFocusGained

    private void onHover2(JPanel pane1) {
        pane1.setBackground(new Color(159, 67, 112));
    }
    
    private void onLeaveHover2(JPanel pane1) {
        pane1.setBackground(new Color(145, 4, 72));
    }
    
    private void onClick2(JPanel pane1) {
        pane1.setBackground(new Color(151,180,255));
    }
      
    private void onLeaveClick2(JPanel pane1) {
        pane1.setBackground(new Color(127,149,213));
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
            java.util.logging.Logger.getLogger(RegisterProductSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterProductSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterProductSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterProductSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterProductSales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEditarProduto;
    private javax.swing.JPanel btnRemoverProduto;
    private javax.swing.JPanel btnSalvarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoProduto1;
    private javax.swing.JLabel lblBuscarProduto;
    private javax.swing.JLabel lblCodigoAdicional;
    private javax.swing.JLabel lblCodigoProduto;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblPrecoProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTipoProduto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<String> listaProdutosEstoque;
    private javax.swing.JTextField txtBuscarProduto;
    private javax.swing.JTextField txtCodigoAdicional;
    private javax.swing.JTextField txtCostAdditional;
    private javax.swing.JTextField txtLabor;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JTextField txtPriceSales;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalSales;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
        setTitle(" Cadastro de Preço de Vendas");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
