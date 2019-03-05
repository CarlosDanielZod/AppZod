package br.com.app.view;

import br.com.app.utils.Formats;
import br.com.app.model.ProductClousureManagement;
import br.com.app.model.ProductManagement;
import br.com.app.model.ProductSessionManagement;
import br.com.app.model.TicketsManagement;
import br.com.app.jdbc.dao.ProductClousureManagementDAO;
import br.com.app.jdbc.dao.ProductManagementDAO;
import br.com.app.jdbc.dao.ProductSessionManagementDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class SharedTicket extends javax.swing.JFrame {

    private final TicketsManagement sharedTicket;
    private final ProductManagementDAO productDao = new ProductManagementDAO();
    private String idProductPanel;
    private int quantidadeSolicitada = 0;
    private final String idRetorno = "";
    private final ProductSessionManagementDAO productSessionDao = new ProductSessionManagementDAO();
    private final List<String> product_Session_id = new ArrayList<String>();
    private Boolean ok = false;
    private PanelButtonProduct button;        
    private String preco;
    //bug, field qtyStock is used.
    private int qtyStock;
    private final List<PanelButtonProduct> listPanelButton = new ArrayList<PanelButtonProduct>();
    private final ProductClousureManagementDAO productClousureDao = new ProductClousureManagementDAO();
    private int cont = 0;
    
    public SharedTicket(TicketsManagement sharedTicket) {
        this.sharedTicket = sharedTicket;
        initComponents();
        setIcon();
        initSharedTicket(sharedTicket);
        
    addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent evt) {
            if(ok == true) {
                dispose();
            } else {
                int message = JOptionPane.showConfirmDialog(null, "Deseja salvar antes de sair ?");
                switch (message) {
                    case JOptionPane.OK_OPTION:
                        saveTicket();
                        dispose();
                        break;
                    case JOptionPane.NO_OPTION:
                        cancelTicket();
                        dispose();
                        break;  
                    case JOptionPane.CANCEL_OPTION: 
                        break;
                    default:
                        break;
                }
            }
        }
    });
    }
    
    public void initPendencias() {
        if(cont < 1) {
          cont++;
          List<ProductClousureManagement> listProductsClousure = productClousureDao.getProductClousureByTicket(sharedTicket.getE_ticket_id());
            if(listProductsClousure != null) {
                for (ProductClousureManagement productClousure: listProductsClousure) {
                    if(productClousure.getIsSales() == false) {
                      button = new PanelButtonProduct(null, productClousure.getCode(), productClousure.getName(), productClousure.getType(),
                        productClousure.getPrice_sales(), productClousure.getQty(), productClousure.getTotalprice_sales(), productClousure.getProduct_session_id());

                        panelVariable.revalidate();
                        panelVariable.add(button);
                        button.setVisible(true);   
                    } 
                }
            }      
        }
    }
    
    public void initSharedTicket(TicketsManagement sharedTicket) {
        if(sharedTicket != null) {
            txtCodigoCliente.setText(""+sharedTicket.getCode_client());
            txtNomeCliente.setText(sharedTicket.getName_client());
            txtTelefone.setText(sharedTicket.getPhone1());
            txtTelefone2.setText(sharedTicket.getPhone2());
            txtEmail.setText(sharedTicket.getEmail());
        }
    }
    
    public void setProductInClient(ProductSessionManagement productSession, int qtde) {
        
        if(qtde >= 1) {
            if(qtde <= productSession.getQty()) {
                quantidadeSolicitada = qtde;
                qtyStock = productSession.getQty();
                product_Session_id.add(productSession.getProduct_session_id());
                String qtde1 = String.valueOf(qtde);
                preco = productSession.getPrice_sales();
                
                Formats formatCurrency = new Formats();
                double dbQuantidade = Double.parseDouble(qtde1);
                double precoConvertido = formatCurrency.desformatCurrency(preco);
                double dbTotal = precoConvertido * dbQuantidade;
                
                NumberFormat currencyFormatter = formatCurrency.getCurrencyBR();
                String totalFormated = currencyFormatter.format(dbTotal);
                
                    button = new PanelButtonProduct(null, productSession.getCode(), productSession.getName(), productSession.getType(),
                            productSession.getPrice_sales(), qtde, totalFormated, productSession.getProduct_session_id());
                    
                    listPanelButton.add(button);

                    button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent arg0) {

                        idProductPanel = productSession.getProduct_session_id();
                        if(idProductPanel != null && !idProductPanel.equals("")) {
                            ProductSessionManagement productPanel = productSessionDao.getProductSession(idProductPanel);
                            lblProdSelected.setText("Código do selecionado:");
                            int codAlter = productPanel.getCode();
                            txtCodAlter.setText(""+codAlter);
                        }
                    }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
            }
});
            panelVariable.add(button);
            button.setVisible(true);
        } else {
                JOptionPane.showMessageDialog(this, "Ops, não temos essa quantidade no estoque", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
          }
       }
    
    public void cancelTicket() {
        ProductSessionManagement productSessionManager = null;
        String e_product_id = "";
        ProductManagement productForSession = null;
    
        for (String productSession : product_Session_id) {
           productSessionManager = productSessionDao.getProductSession(productSession);
           e_product_id = productSessionManager.getE_product_id();
           productForSession = productDao.getProduct(e_product_id);
          
            productSessionDao.alterProdSession(productForSession.getQty(), "0", productSession);
            
            for (Component component : listPanelButton) {
                    component.setVisible(false);
            }
            panelVariable.revalidate();
        }
    } 
    
    public void cancelSelectedTicket(String idProductSession, List<PanelButtonProduct> panelListButton) {
        ProductSessionManagement productSessionManager = null;
        String e_product_id = "";
        ProductManagement productForSession = null;
    
           productSessionManager = productSessionDao.getProductSession(idProductSession);
           e_product_id = productSessionManager.getE_product_id();
           productForSession = productDao.getProduct(e_product_id);
          
            productSessionDao.alterProdSession(productForSession.getQty(), "0", idProductSession);             

            for (PanelButtonProduct panelButton : listPanelButton) {
                if(idProductSession.equals(panelButton.getName()) || panelButton.getName().equals(idProductSession)) {
                   panelButton.setVisible(false);
                    panelVariable.revalidate();
                    break;
                }
            }
    }
    
    public void saveTicket() {
         if(listPanelButton != null) {
            ProductClousureManagement productClousure = new ProductClousureManagement();
            for(PanelButtonProduct panelButton : listPanelButton) {
                if(panelButton.getName() != null && !panelButton.getName().equals("")) {
                    ProductSessionManagement productSessionFinal = productSessionDao.getProductSession(panelButton.getName());
                    String e_product_clousure_id = UUID.randomUUID().toString();
                    productClousure.setE_product_close_id(e_product_clousure_id);
                    productClousure.setProduct_session_id(panelButton.getName());
                    productClousure.setE_ticket_id(sharedTicket.getE_ticket_id());
                    productClousure.setName(panelButton.productClousureInfo().getName());
                    productClousure.setCode(panelButton.productClousureInfo().getCode());
                    productClousure.setCode_additional(panelButton.productClousureInfo().getCode_additional());
                    productClousure.setDiscount(null);
                    productClousure.setType(panelButton.productClousureInfo().getType());
                    productClousure.setQty(panelButton.productClousureInfo().getQty());
                    productClousure.setLabor(productSessionFinal.getLabor());
                    productClousure.setCost_additional(productSessionFinal.getCost_additional());
                    productClousure.setPrice_sales(panelButton.productClousureInfo().getPrice_sales());
                    productClousure.setTotalprice_sales(panelButton.productClousureInfo().getTotalprice_sales());
                    productClousure.setIsSales(false);
                    productClousureDao.addProductClousure(productClousure);
                }  
            }
            JOptionPane.showMessageDialog(this, "Registro salvo!");
                ok = true;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAdicionarProduto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnConfirmacaoPendente = new javax.swing.JPanel();
        lblConfirmacaoPendente = new javax.swing.JLabel();
        btnHistVendas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelInfoClient = new javax.swing.JPanel();
        txtCodigoCliente = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JLabel();
        lblCodigoCliente = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTelefone2 = new javax.swing.JLabel();
        btnEmail = new javax.swing.JLabel();
        panelVariable = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRemover = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCodAlter = new javax.swing.JLabel();
        lblProdSelected = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnConfirmarVenda = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnSalvarProduto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(23, 35, 51));

        btnAdicionarProduto.setBackground(new java.awt.Color(23, 35, 51));
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

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1608412-24.png"))); // NOI18N
        jLabel2.setText(" - Adicionar Produto");

        javax.swing.GroupLayout btnAdicionarProdutoLayout = new javax.swing.GroupLayout(btnAdicionarProduto);
        btnAdicionarProduto.setLayout(btnAdicionarProdutoLayout);
        btnAdicionarProdutoLayout.setHorizontalGroup(
            btnAdicionarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAdicionarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        btnAdicionarProdutoLayout.setVerticalGroup(
            btnAdicionarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAdicionarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnConfirmacaoPendente.setBackground(new java.awt.Color(23, 35, 51));
        btnConfirmacaoPendente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmacaoPendente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmacaoPendenteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfirmacaoPendenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfirmacaoPendenteMouseExited(evt);
            }
        });

        lblConfirmacaoPendente.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblConfirmacaoPendente.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmacaoPendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1608485-24.png"))); // NOI18N
        lblConfirmacaoPendente.setText("- Confirmar Venda pendente");

        javax.swing.GroupLayout btnConfirmacaoPendenteLayout = new javax.swing.GroupLayout(btnConfirmacaoPendente);
        btnConfirmacaoPendente.setLayout(btnConfirmacaoPendenteLayout);
        btnConfirmacaoPendenteLayout.setHorizontalGroup(
            btnConfirmacaoPendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConfirmacaoPendenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConfirmacaoPendente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnConfirmacaoPendenteLayout.setVerticalGroup(
            btnConfirmacaoPendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConfirmacaoPendenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConfirmacaoPendente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnHistVendas.setBackground(new java.awt.Color(23, 35, 51));
        btnHistVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistVendasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHistVendasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHistVendasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnHistVendasLayout = new javax.swing.GroupLayout(btnHistVendas);
        btnHistVendas.setLayout(btnHistVendasLayout);
        btnHistVendasLayout.setHorizontalGroup(
            btnHistVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        btnHistVendasLayout.setVerticalGroup(
            btnHistVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/287782-64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmacaoPendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmacaoPendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(btnHistVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInfoClient.setBackground(new java.awt.Color(145, 4, 72));
        panelInfoClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelInfoClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelInfoClientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelInfoClientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelInfoClientMouseExited(evt);
            }
        });

        txtCodigoCliente.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtCodigoCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigoCliente.setText("0");

        lblNomeCliente.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblNomeCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeCliente.setText("Nome:");

        txtNomeCliente.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtNomeCliente.setForeground(new java.awt.Color(255, 255, 255));

        lblCodigoCliente.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblCodigoCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoCliente.setText("Código Cliente:");

        lblTelefone.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone:");

        txtTelefone.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtTelefone.setForeground(new java.awt.Color(255, 255, 255));

        lblEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("E-mail:");

        txtEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Telefone 2:");

        txtTelefone2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        txtTelefone2.setForeground(new java.awt.Color(255, 255, 255));

        btnEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/212937-24.png"))); // NOI18N
        btnEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelInfoClientLayout = new javax.swing.GroupLayout(panelInfoClient);
        panelInfoClient.setLayout(panelInfoClientLayout);
        panelInfoClientLayout.setHorizontalGroup(
            panelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoClientLayout.createSequentialGroup()
                        .addComponent(lblNomeCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                    .addGroup(panelInfoClientLayout.createSequentialGroup()
                        .addComponent(lblCodigoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmail)))
                .addContainerGap())
        );
        panelInfoClientLayout.setVerticalGroup(
            panelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodigoCliente)
                        .addComponent(txtCodigoCliente))
                    .addComponent(btnEmail))
                .addGap(18, 18, 18)
                .addGroup(panelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelVariable.setBackground(new java.awt.Color(255, 255, 255));

        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlterarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlterarMouseExited(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/212994-24.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnAlterarLayout = new javax.swing.GroupLayout(btnAlterar);
        btnAlterar.setLayout(btnAlterarLayout);
        btnAlterarLayout.setHorizontalGroup(
            btnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAlterarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnAlterarLayout.setVerticalGroup(
            btnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoverMouseExited(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/213016-24.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnRemoverLayout = new javax.swing.GroupLayout(btnRemover);
        btnRemover.setLayout(btnRemoverLayout);
        btnRemoverLayout.setHorizontalGroup(
            btnRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );
        btnRemoverLayout.setVerticalGroup(
            btnRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtCodAlter.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtCodAlter.setForeground(new java.awt.Color(145, 4, 72));

        lblProdSelected.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N

        btnCancelar.setBackground(new java.awt.Color(23, 35, 51));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cancelar");

        javax.swing.GroupLayout btnCancelarLayout = new javax.swing.GroupLayout(btnCancelar);
        btnCancelar.setLayout(btnCancelarLayout);
        btnCancelarLayout.setHorizontalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCancelarLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(32, 32, 32))
        );
        btnCancelarLayout.setVerticalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSalvar.setBackground(new java.awt.Color(23, 35, 51));
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Salvar");

        javax.swing.GroupLayout btnSalvarLayout = new javax.swing.GroupLayout(btnSalvar);
        btnSalvar.setLayout(btnSalvarLayout);
        btnSalvarLayout.setHorizontalGroup(
            btnSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalvarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        btnSalvarLayout.setVerticalGroup(
            btnSalvarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalvarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnConfirmarVenda.setBackground(new java.awt.Color(23, 35, 51));
        btnConfirmarVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarVendaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfirmarVendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfirmarVendaMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pagamento");

        javax.swing.GroupLayout btnConfirmarVendaLayout = new javax.swing.GroupLayout(btnConfirmarVenda);
        btnConfirmarVenda.setLayout(btnConfirmarVendaLayout);
        btnConfirmarVendaLayout.setHorizontalGroup(
            btnConfirmarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConfirmarVendaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btnConfirmarVendaLayout.setVerticalGroup(
            btnConfirmarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConfirmarVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(541, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

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

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1608823-24.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnSalvarProdutoLayout = new javax.swing.GroupLayout(btnSalvarProduto);
        btnSalvarProduto.setLayout(btnSalvarProdutoLayout);
        btnSalvarProdutoLayout.setHorizontalGroup(
            btnSalvarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSalvarProdutoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnSalvarProdutoLayout.setVerticalGroup(
            btnSalvarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalvarProdutoLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProdSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodAlter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(panelVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelInfoClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfoClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvarProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodAlter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProdSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(panelVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void panelInfoClientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInfoClientMouseEntered
        
        onHover2(panelInfoClient);
        // TODO add your handling code here:
    }//GEN-LAST:event_panelInfoClientMouseEntered

    private void panelInfoClientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInfoClientMouseExited

        onLeaveHover2(panelInfoClient);
        // TODO add your handling code here:
    }//GEN-LAST:event_panelInfoClientMouseExited

    private void btnAdicionarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoMouseClicked

        ListSelectProd listProduct = new ListSelectProd(this, idRetorno, quantidadeSolicitada);
        listProduct.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarProdutoMouseClicked

    private void btnAdicionarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoMouseEntered

        onHover3(btnAdicionarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarProdutoMouseEntered

    private void btnAdicionarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoMouseExited

        onLeaveHover3(btnAdicionarProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarProdutoMouseExited

    private void btnAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseEntered

        btnAlterar.setBackground(new Color(71, 87, 108));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarMouseEntered

    private void btnAlterarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseExited

        btnAlterar.setBackground(new Color(240, 240, 240));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarMouseExited

    private void btnRemoverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverMouseEntered

        btnRemover.setBackground(new Color(71, 87, 108));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverMouseEntered

    private void btnRemoverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverMouseExited

        btnRemover.setBackground(new Color(240, 240, 240));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverMouseExited

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        button.enableQtde(true, idProductPanel, listPanelButton);  

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked

        cancelTicket();
        ok = true;
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked

        saveTicket();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered

        onHover3(btnSalvar);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered

        onHover3(btnCancelar);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited

        onLeaveHover3(btnCancelar);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited

        onLeaveHover3(btnSalvar);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarMouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered

        btnAlterar.setBackground(new Color(71, 87, 108));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered

        btnRemover.setBackground(new Color(71, 87, 108));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        
        btnAlterar.setBackground(new Color(240, 240, 240));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited

        btnRemover.setBackground(new Color(240, 240, 240));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void btnRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverMouseClicked

        cancelSelectedTicket(idProductPanel, listPanelButton);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverMouseClicked

    private void panelInfoClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInfoClientMouseClicked

        FrameInfoClient infoClient = new FrameInfoClient(sharedTicket);
        infoClient.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_panelInfoClientMouseClicked

    private void btnEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmailMouseClicked

        FrameEmailShared email = new FrameEmailShared(sharedTicket.getEmail());
        email.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmailMouseClicked

    private void btnSalvarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseExited

        btnSalvarProduto.setBackground(new Color(240, 240, 240));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseExited

    private void btnSalvarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseEntered

        btnSalvarProduto.setBackground(new Color(71, 87, 108));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseEntered

    private void btnSalvarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseClicked

        for (PanelButtonProduct btn : listPanelButton) {
            if(idProductPanel != null && idProductPanel.equals(btn.getName()) || btn.getName().equals(idProductPanel)) {
                ProductSessionManagement productSessionNew = productSessionDao.getProductSession(idProductPanel);
                ProductManagement productNew = productDao.getProduct(productSessionNew.getE_product_id());
                btn.updateButton(idProductPanel, productSessionNew.getPrice_sales(), productNew.getQty());
                break;
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseClicked

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited

        btnSalvarProduto.setBackground(new Color(240, 240, 240));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered

        btnSalvarProduto.setBackground(new Color(71, 87, 108));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void btnConfirmarVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarVendaMouseClicked

        if(ok == true) {
             List<ProductClousureManagement> productClousure = new ArrayList<ProductClousureManagement>();
        
        for(PanelButtonProduct panelButton : listPanelButton) {
            ProductClousureManagement prodCloseBySession = productClousureDao.getProductClousureBySession(panelButton.getName());
            String panelButtonName = panelButton.getName();
            String productSessionId = prodCloseBySession.getProduct_session_id();
            
            if(panelButtonName.equals(productSessionId) || productSessionId.equals(panelButtonName)) {
                panelButton.updateProductClousure(prodCloseBySession.getE_product_close_id());
                productClousureDao.isSales(true, prodCloseBySession.getE_product_close_id());
                productClousure.add(prodCloseBySession);
            }
        }
        
        PaymentTicket paymentTicket = new PaymentTicket(productClousure);
        paymentTicket.setVisible(true);
        
        } else {
            JOptionPane.showMessageDialog(this, "Salve as informações primeiro!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarVendaMouseClicked

    private void btnConfirmacaoPendenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmacaoPendenteMouseEntered

            btnConfirmacaoPendente.setBackground(new Color(71, 87, 108));
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmacaoPendenteMouseEntered

    private void btnConfirmacaoPendenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmacaoPendenteMouseExited
       
            btnConfirmacaoPendente.setBackground(new Color(23, 35, 51));
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmacaoPendenteMouseExited

    private void btnConfirmacaoPendenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmacaoPendenteMouseClicked

        initPendencias();
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmacaoPendenteMouseClicked

    private void btnHistVendasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistVendasMouseEntered
//
//        btnHistVendas.setBackground(new Color(71, 87, 108));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistVendasMouseEntered

    private void btnHistVendasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistVendasMouseExited

//        btnHistVendas.setBackground(new Color(23, 35, 51));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistVendasMouseExited

    private void btnConfirmarVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarVendaMouseEntered

        btnConfirmarVenda.setBackground(new Color(71, 87, 108));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarVendaMouseEntered

    private void btnConfirmarVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarVendaMouseExited

        btnConfirmarVenda.setBackground(new Color(23, 35, 51));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarVendaMouseExited

    private void btnHistVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistVendasMouseClicked

//        HistoryClients history = new HistoryClients(sharedTicket);
//        history.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistVendasMouseClicked

    private void onHover2(JPanel pane1) {
        pane1.setBackground(new Color(159, 67, 112));
    }
    
    private void onLeaveHover2(JPanel pane1) {
        pane1.setBackground(new Color(145, 4, 72));
    }

    private void onHover3(JPanel pane1) {
        pane1.setBackground(new Color(71, 87, 108));
    }
    
    private void onLeaveHover3(JPanel pane1) {
        pane1.setBackground(new Color(23, 35, 51));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAdicionarProduto;
    private javax.swing.JPanel btnAlterar;
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JPanel btnConfirmacaoPendente;
    private javax.swing.JPanel btnConfirmarVenda;
    private javax.swing.JLabel btnEmail;
    private javax.swing.JPanel btnHistVendas;
    private javax.swing.JPanel btnRemover;
    private javax.swing.JPanel btnSalvar;
    private javax.swing.JPanel btnSalvarProduto;
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
    private javax.swing.JLabel lblCodigoCliente;
    private javax.swing.JLabel lblConfirmacaoPendente;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblProdSelected;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel panelInfoClient;
    private javax.swing.JPanel panelVariable;
    private javax.swing.JLabel txtCodAlter;
    private javax.swing.JLabel txtCodigoCliente;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtNomeCliente;
    private javax.swing.JLabel txtTelefone;
    private javax.swing.JLabel txtTelefone2;
    // End of variables declaration//GEN-END:variables
  private void setIcon() {
        setTitle(" Tickets");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
