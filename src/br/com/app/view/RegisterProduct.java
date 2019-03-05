package br.com.app.view;

import br.com.app.model.ClientManagement;
import br.com.app.model.PartnerManagement;
import br.com.app.model.ProductManagement;
import br.com.app.jdbc.dao.ClientManagementDAO;
import br.com.app.jdbc.dao.PartnerManagementDAO;
import br.com.app.jdbc.dao.ProductManagementDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author carlos
 */
public class RegisterProduct extends javax.swing.JFrame {

    public ProductManagementDAO productDao;
    public List<ProductManagement> productManager;
    public ProductManagement productManagement;
    public int valueSelectedList;
    public int count = 0;
    public boolean filtroActive;
    public String filtroAll;
    public String initList = "update";
    public List<PartnerManagement> listPartner = new ArrayList<PartnerManagement>();
    public PartnerManagementDAO partnerDao = new PartnerManagementDAO();
    public ClientManagement clientManager;
    public ClientManagementDAO clientDao = new ClientManagementDAO();
    public String e_partner_id;
    public int valueSelectedPartner;
    public int contador;
    public int guardaCont;
    
    public RegisterProduct() {
        
        initComponents();
        setIcon();
        clean();

        listPartner = partnerDao.getListPartner();
        jcbParceiro.addItem("");
        for (PartnerManagement partner : listPartner) {
            jcbParceiro.addItem(partner.getName());
            e_partner_id = partner.getE_partner_id();
        }
        
        jcbTipoProduto.setEnabled(false);

        jcbTipoProduto.addItem("");
        jcbTipoProduto.addItem("Tipo 1");
        jcbTipoProduto.addItem("Tipo 2");
        
         productDao = new ProductManagementDAO();
         productManager = productDao.getListProduct();
        
         updateList(productManager, initList);
         activateList(0);
    }
    
    public String validateNullString(String texto) {
        if(texto == null || texto.equals("")) {
            texto = "";
        }
        return texto;
    }
    
     public void updateList(List<ProductManagement> listProductManager, String filtrarPor) {
        ProductManagementDAO updateListDao = new ProductManagementDAO();
        switch (filtrarPor) {
            case "filtroActive":
                listProductManager = updateListDao.getFilterActivesProd(filtroActive);
                break;
            case "update":
                listProductManager = updateListDao.getListProduct();
                break;
            case "updateDESC":
                listProductManager = updateListDao.getListDescProduct();
                break;
            case "filtroAll":
                listProductManager = updateListDao.getFilterAllProd(filtroAll);
                break;
            default:
                break;
        }
        
        DefaultListModel model = new DefaultListModel();
        for (ProductManagement product : listProductManager) {
            int cod = product.getCode();
            String name = product.getName();
            String nameProd = validateNullString(name);
            String type = product.getType();
            String typeProd = validateNullString(type);
            int codAdd = product.getCode_additional();
            String codAdditional = validateNullString(String.valueOf(codAdd));
            String price = product.getPrice();
            String priceProd = validateNullString(price);
            int qtyProd = product.getQty();
            String totalProd = product.getTotal();
            String total = validateNullString(totalProd);
            boolean active = product.isIsActive();
            
            String columnCodigo = "<html><body> <font color='#6E3C55' font size='4'> Código: </font>"; 
            String columnNome = "<html><body> <font color='#6E3C55' font size='4'> Nome: </font>";
            String columnTipo = "<html><body> <font color='#6E3C55' font size='4'> Tipo: </font>";
            String columnAdicional = "<html><body> <font color='#6E3C55' font size='4'> Cód.Adicional: </font>";
            String columnPreco = "<html><body> <font color='#6E3C55' font size='4'> Preço: </font>";
            String columnQuantidade = "<html><body> <font color='#6E3C55' font size='4'> Qtde: </font>";
            String columnTotal = "<html><body> <font color='#6E3C55' font size='4'> Total: </font>";
            String columnIsActive = "<html><body> <font color='#6E3C55' font size='4'> Ativo: </font>";
            String isActive;
            
            if(active == true) {
                isActive = "Sim";
            } else {
                isActive = "Não";
            }

            model.addElement(columnCodigo + cod + "  |  " + columnNome + nameProd + "  |  " + columnTipo + typeProd +  "  |  "
                    + columnAdicional + codAdditional + "  |  " + columnPreco + priceProd + "  |  " + columnQuantidade + qtyProd
                    + "  |  " + columnTotal + total + "  |  " + columnIsActive + isActive);
         }
        productManager = listProductManager;
        listaProdutos.setModel(model);        
    }
     
     public void clean() {
         txtNomeProduto.setText("");
         txtPrecoProduto.setText("");
         jcbTipoProduto.setSelectedItem("");
         txtCodigoAdicional.setText("");
         txtQuantidade.setText("");
         txtTotal.setText("");
         jcbParceiro.setSelectedItem("");
         lblCodigoProduto.setText("");
         txtDescription.setText("");
     }
     
     public void edit(boolean yesNo) {
         txtNomeProduto.setEnabled(yesNo);
         txtCodigoAdicional.setEnabled(yesNo);
         txtTotal.setEnabled(yesNo);
         txtQuantidade.setEnabled(yesNo);
         txtPrecoProduto.setEnabled(yesNo);
         jcbTipoProduto.setEnabled(yesNo);
         jcbParceiro.setEnabled(yesNo);
         checkIsActive.setEnabled(yesNo);
         txtDescription.setEnabled(yesNo);
     }
     
    public void teste(JTextField campo, JLabel jlabel) {
        String campoValidation = campo.getText();
         if(campoValidation == null || campoValidation.equals("")) {
            jlabel.setForeground(Color.red);
        } else {
            jlabel.setForeground(new Color(0, 102, 102));
            }
        }
    
    public void activateList(int inteiro) {
        listaProdutos.setSelectedIndex(inteiro);
        valueSelectedList = listaProdutos.getSelectedIndex();
        if(valueSelectedList == -1) {
            lblNomeProduto.setForeground(Color.red);
            lblPrecoProduto.setForeground(Color.red);
            lblQuantidade.setForeground(Color.red);
            lblTotal.setForeground(Color.red);
        
            productManagement = new ProductManagement();
            ProductManagementDAO productManagerDao = new ProductManagementDAO();
        
            ProductManagement testw2 = productManagerDao.returnCodeProduct();
            String productId = UUID.randomUUID().toString();
            int cont = testw2.getCode();
            cont++;

            productManagement.setCode(cont);

            productManagement.setE_product_id(productId);

            productManagerDao.addProductParcial(productManagement);
            updateList(productManager, "updateDESC");
            listaProdutos.setSelectedIndex(0);      
            int valorSelecionado = listaProdutos.getSelectedIndex();
            selectedItemList(valorSelecionado);

        } else {
            selectedItemList(0);
        }
    }
    public void selectedItemList(int selector) {
        lblCodigoProduto.setText(""+productManager.get(selector).getCode());
            txtNomeProduto.setText(productManager.get(selector).getName());
            txtPrecoProduto.setText(productManager.get(selector).getPrice());
            jcbTipoProduto.setSelectedItem(productManager.get(selector).getType());
            txtQuantidade.setText(""+productManager.get(selector).getQty());
            txtCodigoAdicional.setText(""+ productManager.get(selector).getCode_additional());
            txtTotal.setText(productManager.get(selector).getTotal());

            String partnerProduct = productManager.get(selector).getE_partner_id();

            if (partnerProduct != null) {
                for (PartnerManagement partner : listPartner) {
                    String partner_id = partner.getE_partner_id();
                    if(partner_id.equals(partnerProduct) || partnerProduct.equals(partner_id)) {
                        jcbParceiro.setSelectedItem(partner.getName());
                        break;
                }
            }
        } else {
            jcbParceiro.setSelectedItem("");
          }
        
        txtDescription.setText(productManager.get(selector).getDescription());
        checkIsActive.setSelected(productManager.get(selector).isIsActive());
        }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarProduto = new javax.swing.JTextField();
        lblBuscarProduto = new javax.swing.JLabel();
        btnAdicionarProduto = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnSalvarProduto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnEditarProduto = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnRemoverProduto = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblCodigoProduto = new javax.swing.JLabel();
        checkAtivos = new javax.swing.JCheckBox();
        btnAddPriceSales = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutos = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        txtPrecoProduto = new javax.swing.JTextField();
        txtNomeProduto = new javax.swing.JTextField();
        lblNomeProduto = new javax.swing.JLabel();
        lblPrecoProduto = new javax.swing.JLabel();
        lblTipoProduto = new javax.swing.JLabel();
        jcbTipoProduto = new javax.swing.JComboBox<>();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblCodigoAdicional = new javax.swing.JLabel();
        txtCodigoAdicional = new javax.swing.JTextField();
        checkIsActive = new javax.swing.JCheckBox();
        jcbParceiro = new javax.swing.JComboBox<>();
        lblParceiro = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(826, 472));

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

        btnAdicionarProduto.setBackground(new java.awt.Color(145, 4, 72));
        btnAdicionarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdicionarProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdicionarProdutoMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Adicionar Produto");

        javax.swing.GroupLayout btnAdicionarProdutoLayout = new javax.swing.GroupLayout(btnAdicionarProduto);
        btnAdicionarProduto.setLayout(btnAdicionarProdutoLayout);
        btnAdicionarProdutoLayout.setHorizontalGroup(
            btnAdicionarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAdicionarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAdicionarProdutoLayout.setVerticalGroup(
            btnAdicionarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAdicionarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Editar");

        javax.swing.GroupLayout btnEditarProdutoLayout = new javax.swing.GroupLayout(btnEditarProduto);
        btnEditarProduto.setLayout(btnEditarProdutoLayout);
        btnEditarProdutoLayout.setHorizontalGroup(
            btnEditarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarProdutoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnEditarProdutoLayout.setVerticalGroup(
            btnEditarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18))
        );
        btnRemoverProdutoLayout.setVerticalGroup(
            btnRemoverProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRemoverProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblCodigoProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblCodigoProduto.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoProduto.setText("10");

        checkAtivos.setBackground(new java.awt.Color(145, 4, 72));
        checkAtivos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkAtivos.setForeground(new java.awt.Color(255, 255, 255));
        checkAtivos.setText("Ativos");
        checkAtivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAtivosActionPerformed(evt);
            }
        });

        btnAddPriceSales.setBackground(new java.awt.Color(145, 4, 72));
        btnAddPriceSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddPriceSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddPriceSalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddPriceSalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddPriceSalesMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Adicionar Preço de Venda");

        javax.swing.GroupLayout btnAddPriceSalesLayout = new javax.swing.GroupLayout(btnAddPriceSales);
        btnAddPriceSales.setLayout(btnAddPriceSalesLayout);
        btnAddPriceSalesLayout.setHorizontalGroup(
            btnAddPriceSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddPriceSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAddPriceSalesLayout.setVerticalGroup(
            btnAddPriceSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAddPriceSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblBuscarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkAtivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(lblCodigoProduto)
                .addGap(55, 55, 55)
                .addComponent(btnAddPriceSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemoverProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkAtivos))
                    .addComponent(lblCodigoProduto)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAddPriceSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoverProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        listaProdutos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        listaProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listaProdutos.setSelectionBackground(new java.awt.Color(216, 222, 238));
        listaProdutos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProdutosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listaProdutosMouseEntered(evt);
            }
        });
        listaProdutos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaProdutosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaProdutos);

        txtPrecoProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecoProduto.setEnabled(false);
        txtPrecoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecoProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoProdutoFocusLost(evt);
            }
        });

        txtNomeProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNomeProduto.setEnabled(false);
        txtNomeProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeProdutoFocusLost(evt);
            }
        });

        lblNomeProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblNomeProduto.setForeground(new java.awt.Color(0, 102, 102));
        lblNomeProduto.setText("*Nome Produto:");
        lblNomeProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblNomeProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblNomeProdutoFocusLost(evt);
            }
        });

        lblPrecoProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblPrecoProduto.setForeground(new java.awt.Color(0, 102, 102));
        lblPrecoProduto.setText("*Preço:");

        lblTipoProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblTipoProduto.setForeground(new java.awt.Color(0, 102, 102));
        lblTipoProduto.setText("Tipo Produto:");

        jcbTipoProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbTipoProduto.setEnabled(false);

        lblQuantidade.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblQuantidade.setForeground(new java.awt.Color(0, 102, 102));
        lblQuantidade.setText("*Quantidade:");

        txtQuantidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQuantidade.setEnabled(false);
        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusLost(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 102, 102));
        lblTotal.setText("*Total:");

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

        checkIsActive.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        checkIsActive.setForeground(new java.awt.Color(0, 102, 102));
        checkIsActive.setText("Ativo");
        checkIsActive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkIsActive.setEnabled(false);

        jcbParceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbParceiro.setEnabled(false);

        lblParceiro.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblParceiro.setForeground(new java.awt.Color(0, 102, 102));
        lblParceiro.setText("Nome Parceiro:");

        lblDescription.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(0, 102, 102));
        lblDescription.setText("Descrição:");

        txtDescription.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescription.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcbParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNomeProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTipoProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCodigoAdicional)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblParceiro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPrecoProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkIsActive))
                            .addComponent(lblDescription))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkIsActive))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParceiro)
                    .addComponent(lblDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
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

    private void listaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProdutosMouseClicked

        String validateNome = txtNomeProduto.getText();
        String validatePreco = txtPrecoProduto.getText();
        String validateQtd = txtQuantidade.getText();
        String validateTotal = txtTotal.getText();
        if(validateNome != null && !validateNome.equals("") && validatePreco != null && !validatePreco.equals("") && validateQtd != null &&
                !validateQtd.equals("") && validateTotal != null && !validateTotal.equals("")) {
        
        edit(false);
        valueSelectedList = listaProdutos.getSelectedIndex();
        lblCodigoProduto.setText(""+productManager.get(valueSelectedList).getCode());
        txtNomeProduto.setText(productManager.get(valueSelectedList).getName());
        txtPrecoProduto.setText(productManager.get(valueSelectedList).getPrice());
        jcbTipoProduto.setSelectedItem(productManager.get(valueSelectedList).getType());
        txtQuantidade.setText(""+productManager.get(valueSelectedList).getQty());
        txtCodigoAdicional.setText(""+ productManager.get(valueSelectedList).getCode_additional());
        txtTotal.setText(productManager.get(valueSelectedList).getTotal());
        
        String partnerProduct = productManager.get(valueSelectedList).getE_partner_id();
        
        if (partnerProduct != null) {
            for (PartnerManagement partner : listPartner) {
                String partner_id = partner.getE_partner_id();
                if(partner_id.equals(partnerProduct) || partnerProduct.equals(partner_id)) {
                    jcbParceiro.setSelectedItem(partner.getName());
                    break;
                }
            }
        } else {
            jcbParceiro.setSelectedItem("");
        }
        
        txtDescription.setText(productManager.get(valueSelectedList).getDescription());
        checkIsActive.setSelected(productManager.get(valueSelectedList).isIsActive());

        } else {   
            activateList(valueSelectedList);
            teste(txtNomeProduto, lblNomeProduto);
            teste(txtPrecoProduto, lblPrecoProduto);
            teste(txtQuantidade, lblQuantidade);
            teste(txtTotal, lblTotal);
            edit(true);
            JOptionPane.showMessageDialog(this, "É obrigatório o preenchimento dos campos que possuem asterísco!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }        
    
        // TODO add your handling code here:
    }//GEN-LAST:event_listaProdutosMouseClicked

    private void btnAdicionarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoMouseClicked

        lblNomeProduto.setForeground(Color.red);
        lblPrecoProduto.setForeground(Color.red);
        lblQuantidade.setForeground(Color.red);
        lblTotal.setForeground(Color.red);
        
        productManagement = new ProductManagement();
        ProductManagementDAO productManagerDao = new ProductManagementDAO();
        
        ProductManagement testw2 = productManagerDao.returnCodeProduct();
        String productId = UUID.randomUUID().toString();
        int cont = testw2.getCode();
        cont++;

        productManagement.setCode(cont);
        
        productManagement.setE_product_id(productId);

        productManagerDao.addProductParcial(productManagement);
        updateList(productManager, "updateDESC");
        listaProdutos.setSelectedIndex(0);
        int teste = listaProdutos.getSelectedIndex();
        
        lblCodigoProduto.setText(""+productManager.get(teste).getCode());
        txtNomeProduto.setText(productManager.get(teste).getName());
        txtPrecoProduto.setText(productManager.get(teste).getPrice());
        jcbTipoProduto.setSelectedItem(productManager.get(teste).getType());
        txtQuantidade.setText(""+productManager.get(teste).getQty());
        txtCodigoAdicional.setText(""+ productManager.get(teste).getCode_additional());
        txtTotal.setText(productManager.get(teste).getTotal());
        
        String partnerProduct = productManager.get(teste).getE_partner_id();
        
        if (partnerProduct != null) {
            for (PartnerManagement partner : listPartner) {
                String partner_id = partner.getE_partner_id();
                if(partner_id.equals(partnerProduct) || partnerProduct.equals(partner_id)) {
                    jcbParceiro.setSelectedItem(partner.getName());
                    break;
                }
            }
        } else {
            jcbParceiro.setSelectedItem("");
        }
        
        checkIsActive.setSelected(productManager.get(teste).isIsActive());
        edit(true);
        
//        JOptionPane.showMessageDialog(this, "É obrigatório o preenchimento dos campos que possuem asterísco!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAdicionarProdutoMouseClicked

    private void btnAdicionarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoMouseEntered
        onHover2(btnAdicionarProduto);
// TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarProdutoMouseEntered

    private void btnSalvarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseClicked

        ProductManagementDAO teste = new ProductManagementDAO();
        
       valueSelectedList = listaProdutos.getSelectedIndex();
       
          String valorSelecionado = jcbParceiro.getSelectedItem().toString();
          
        String idDomaluco = "";
        
        for (PartnerManagement partner : listPartner) {
            String parName = partner.getName();
            if(parName != null && !parName.equals("")) {
              if(parName.equals(valorSelecionado) || valorSelecionado.equals(parName)) {
                idDomaluco = partner.getE_partner_id();
                break;
               }
            }
        }
//validar id
        String id = productManager.get(valueSelectedList).getE_product_id(); 
        String nomeProduto = txtNomeProduto.getText();
        String precoProduto = txtPrecoProduto.getText();
        Object tipoProduto = jcbTipoProduto.getSelectedItem();
        
        String quantidadeProduto = txtQuantidade.getText();
                
        String codigoAddProduto = txtCodigoAdicional.getText();
        
        int codigoAddProdInt = Integer.parseInt(codigoAddProduto);
        String totalProduto = txtTotal.getText();
        boolean isActive = checkIsActive.isSelected();
        String description = txtDescription.getText();
        Date utilDate = new Date();
        Timestamp updated = new Timestamp(utilDate.getTime());
        
        if(nomeProduto != null && !nomeProduto.equals("") && precoProduto != null && !precoProduto.equals("")
                && quantidadeProduto != null && !quantidadeProduto.equals("") && totalProduto != null && !totalProduto.equals("")) {
            int quantidadeProdutoInt = Integer.parseInt(quantidadeProduto);
            teste.saveProd(idDomaluco, updated, isActive, nomeProduto, codigoAddProdInt, (String) tipoProduto,
                quantidadeProdutoInt, precoProduto, totalProduto, description, id);
                edit(false);
                 updateList(productManager, "update");
                 JOptionPane.showMessageDialog(this, "Registro salvo!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

        } else {
            activateList(valueSelectedList);
            teste(txtNomeProduto, lblNomeProduto);
            teste(txtPrecoProduto, lblPrecoProduto);
            teste(txtQuantidade, lblQuantidade);
            teste(txtTotal, lblTotal);
            edit(true);
            JOptionPane.showMessageDialog(this, "É obrigatório o preenchimento dos campos que possuem asterísco!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseClicked

    private void btnSalvarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseEntered
        onHover2(btnSalvarProduto);
 // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseEntered

    private void btnEditarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseClicked

//        onClick2(btnEditarProduto);
        edit(true);
//        onLeaveClick2(btnAdicionarProduto);
//        onLeaveClick2(btnSalvarProduto);
//        onLeaveClick2(btnRemoverProduto);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseClicked

    private void btnEditarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseEntered
        onHover2(btnEditarProduto);
// TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseEntered

    private void btnRemoverProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseClicked

        String product_id = productManager.get(valueSelectedList).getE_product_id();

        clientManager = clientDao.getProductInClient(product_id);
        String productInClient = clientManager.getE_product_id();
        
        if(productInClient != null && !productInClient.equals("")){ 
            if(product_id.equals(productInClient) || productInClient.equals(product_id)) {
                JOptionPane.showMessageDialog(this, "Produto está vinculado a um cliente!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            } 
        } else {
             int option = JOptionPane.showConfirmDialog(this, "Remover o produto selecionado?", "Atenção!", JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION) {
                    productDao.removeProduct(product_id);
                    updateList(productManager, "update");
                } else {
                    }
          }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseClicked

    private void btnRemoverProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseEntered

        onHover2(btnRemoverProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseEntered

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyReleased

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained

    lblTotal.setForeground(new Color(0, 102, 102));
        if(txtPrecoProduto.getText() != null && !txtPrecoProduto.getText().equals("") &&
                txtQuantidade.getText() != null && !txtQuantidade.getText().equals("")) {
            
            String preco = txtPrecoProduto.getText();
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
            txtTotal.setText(totalFormated);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusGained

    private void txtTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusLost

        teste(txtTotal, lblTotal);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalFocusLost

    private void btnSalvarProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseMoved
// TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseMoved

    private void btnRemoverProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseMoved
// TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseMoved

    private void btnEditarProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseMoved

    private void txtBuscarProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdutoKeyReleased
            
        filtroAll = txtBuscarProduto.getText();

        if(filtroAll != null && !filtroAll.equals("")) {
            updateList(productManager, "filtroAll");
        } else {
            updateList(productManager, "update");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProdutoKeyReleased

    private void checkAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAtivosActionPerformed
    
         filtroActive = checkAtivos.isSelected();
         if(filtroActive == true) {
            updateList(productManager, "filtroActive");
         } else {
             updateList(productManager, "update");
         }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_checkAtivosActionPerformed

    private void listaProdutosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProdutosMouseEntered
 // TODO add your handling code here:
    }//GEN-LAST:event_listaProdutosMouseEntered

    private void btnAddPriceSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPriceSalesMouseClicked

        RegisterProductSales productSales = new RegisterProductSales();
        productSales.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPriceSalesMouseClicked

    private void btnAddPriceSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPriceSalesMouseEntered
        onHover2(btnAddPriceSales);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPriceSalesMouseEntered

    private void btnAddPriceSalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPriceSalesMouseExited
        onLeaveHover2(btnAddPriceSales);
// TODO add your handling code here:
    }//GEN-LAST:event_btnAddPriceSalesMouseExited

    private void btnAdicionarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoMouseExited
        onLeaveHover2(btnAdicionarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarProdutoMouseExited

    private void btnSalvarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseExited
        onLeaveHover2(btnSalvarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseExited

    private void btnEditarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseExited
        onLeaveHover2(btnEditarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseExited

    private void btnRemoverProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseExited
        onLeaveHover2(btnRemoverProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseExited

    private void lblNomeProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblNomeProdutoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNomeProdutoFocusGained

    private void lblNomeProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblNomeProdutoFocusLost
// TODO add your handling code here:
    }//GEN-LAST:event_lblNomeProdutoFocusLost

    private void txtNomeProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeProdutoFocusGained
     
    lblNomeProduto.setForeground(new Color(0, 102, 102));
// TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdutoFocusGained

    private void txtNomeProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeProdutoFocusLost

        teste(txtNomeProduto, lblNomeProduto);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdutoFocusLost

    private void txtPrecoProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoProdutoFocusGained

        lblPrecoProduto.setForeground(new Color(0, 102, 102));
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoProdutoFocusGained

    private void txtPrecoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoProdutoFocusLost

        teste(txtPrecoProduto, lblPrecoProduto);
         Locale locale = new Locale("pt", "BR");
         NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
         String precoFormated = txtPrecoProduto.getText();
         if(precoFormated != null && !precoFormated.equals("")) {
            String ttt1 = precoFormated.replace("R$", " ");
            String teste1234 = ttt1.replaceAll("\\.", "");
            String ttt = teste1234.replace(",", ".");
            double teste11 = Double.parseDouble(ttt);
            String precoFormatedd = currencyFormatter.format(teste11);
            txtPrecoProduto.setText(precoFormatedd); 
            
         } else {
             double teste11 = Double.parseDouble("0");
            String precoFormatedd = currencyFormatter.format(teste11);
            txtPrecoProduto.setText(precoFormatedd); 
         }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoProdutoFocusLost

    private void txtQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusGained

        lblQuantidade.setForeground(new Color(0, 102, 102));
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeFocusGained

    private void txtQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusLost

        teste(txtQuantidade, lblQuantidade);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeFocusLost

    private void listaProdutosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProdutosValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaProdutosValueChanged

    private void onHover2(JPanel pane1) {
        pane1.setBackground(new Color(159, 67, 112));
    }
    
    private void onLeaveHover2(JPanel pane1) {
        pane1.setBackground(new Color(145, 4, 72));
    }
    
//    private void onClick2(JPanel pane1) {
//        pane1.setBackground(new Color(151,180,255));
//    }
//      
//    private void onLeaveClick2(JPanel pane1) {
//        pane1.setBackground(new Color(127,149,213));
//    }

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
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAddPriceSales;
    private javax.swing.JPanel btnAdicionarProduto;
    private javax.swing.JPanel btnEditarProduto;
    private javax.swing.JPanel btnRemoverProduto;
    private javax.swing.JPanel btnSalvarProduto;
    private javax.swing.JCheckBox checkAtivos;
    private javax.swing.JCheckBox checkIsActive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbParceiro;
    private javax.swing.JComboBox<String> jcbTipoProduto;
    private javax.swing.JLabel lblBuscarProduto;
    private javax.swing.JLabel lblCodigoAdicional;
    private javax.swing.JLabel lblCodigoProduto;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblParceiro;
    private javax.swing.JLabel lblPrecoProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTipoProduto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<String> listaProdutos;
    private javax.swing.JTextField txtBuscarProduto;
    private javax.swing.JTextField txtCodigoAdicional;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
  private void setIcon() {
        setTitle(" Cadastro de Produtos");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
