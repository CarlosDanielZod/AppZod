package br.com.app.view;

import br.com.app.model.PartnerManagement;
import br.com.app.model.ProductManagement;
import br.com.app.jdbc.dao.PartnerManagementDAO;
import br.com.app.jdbc.dao.ProductManagementDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class RegisterPartner extends javax.swing.JFrame {

    public PartnerManagement partnerManager;
    public PartnerManagementDAO partnerDao = new PartnerManagementDAO();
    public List<PartnerManagement> partnerList;
    public int valueSelectedList;
    public List<ProductManagement> productManager = new ArrayList<ProductManagement>();
    public ProductManagementDAO productDao;
    
    public RegisterPartner() {
        initComponents();
        setIcon();
        updateList(partnerList, "update");
    }
    
         public void updateList(List<PartnerManagement> listPartnerManager, String filtrarPor) {
        PartnerManagementDAO updateListDao = new PartnerManagementDAO();
        switch (filtrarPor) {
            case "filtroActive":
              //  listPartnerManager = updateListDao.getListPartner(filtroActive);
                break;
            case "update":
                listPartnerManager = updateListDao.getListPartner();
                break;
            case "filtroAll":
               // listPartnerManager = updateListDao.getFilterAllProd(filtroAll);
                break;
            default:
                break;
        }
        
        DefaultListModel model = new DefaultListModel();
        for (PartnerManagement partner : listPartnerManager) {
            String namePartner = partner.getName();
            String addressPartner = partner.getAddress();
            String phonePartner = partner.getPhone1();
            String emailPartner = partner.getEmail();
            String cnpjPartner = partner.getCnpj();
            String descriptionPartner = partner.getDescription();
            
            String columnNome = "<html><body> <font color='#6E3C55' font size='4'> Nome: </font>";
            String columnEndeco = "<html><body> <font color='#6E3C55' font size='4'> Endereço: </font>";
            String columnTelefone = "<html><body> <font color='#6E3C55' font size='4'> Telefone: </font>";
            String columnEmail = "<html><body> <font color='#6E3C55' font size='4'> Email: </font>";
            String columnCnpj = "<html><body> <font color='#6E3C55' font size='4'> Cnpj: </font>";
            String columnDescription = "<html><body> <font color='#6E3C55' font size='4'> Descrição: </font>";

            model.addElement(columnNome + namePartner + "  |  " + columnEndeco + addressPartner + "  |  " + columnTelefone + phonePartner +  "  |  "
                    + columnEmail + emailPartner + "  |  " + columnCnpj + cnpjPartner + "  |  " + columnDescription + descriptionPartner);
 
         }
        partnerList = listPartnerManager;
        listPartner.setModel(model);
    }
    
    public void edit(boolean yesNo) {
        txtNomeParceiro.setEnabled(yesNo);
        txtEndereco.setEnabled(yesNo);
        txtTelefone.setEnabled(yesNo);
        txtTelefone2.setEnabled(yesNo);
        txtEmail.setEnabled(yesNo);
        txtCnpj.setEnabled(yesNo);
        txtDescricao.setEnabled(yesNo);
    }
    
    public boolean forValidationPartner(String partner) {
        boolean yesNo = false;
        for (ProductManagement product : productManager) {
            String partnerId = product.getE_partner_id();
            if(partnerId.equals(partner) || partner.equals(partnerId)) {
                yesNo = true;
            } else {
                yesNo = false;
            }
        } 
        
        return yesNo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBuscarProduto = new javax.swing.JLabel();
        txtBuscarProduto = new javax.swing.JTextField();
        checkAtivos = new javax.swing.JCheckBox();
        lblCodigoProduto = new javax.swing.JLabel();
        btnSalvarProduto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAdicionarProduto = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnEditarProduto = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnRemoverProduto = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblBuscarParceiro = new javax.swing.JLabel();
        txtBuscarParceiro = new javax.swing.JTextField();
        btnSalvarParceiro = new javax.swing.JPanel();
        lblSalvarParceiro = new javax.swing.JLabel();
        btnAdicionarParceiro = new javax.swing.JPanel();
        lblAdicionarParceiro = new javax.swing.JLabel();
        btnEditarParceiro = new javax.swing.JPanel();
        lblEditarParceiro = new javax.swing.JLabel();
        btnRemoverParceiro = new javax.swing.JPanel();
        lblRemoverParceiro = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNomeParceiro = new javax.swing.JTextField();
        lblNomeParceiro = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblTelefone2 = new javax.swing.JLabel();
        txtTelefone2 = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPartner = new javax.swing.JList<>();

        lblBuscarProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblBuscarProduto.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscarProduto.setText("Filtre Por:");

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

        checkAtivos.setBackground(new java.awt.Color(0, 51, 153));
        checkAtivos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkAtivos.setForeground(new java.awt.Color(255, 255, 255));
        checkAtivos.setText("Ativos");
        checkAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAtivosActionPerformed(evt);
            }
        });

        lblCodigoProduto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblCodigoProduto.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoProduto.setText("Cod");

        btnSalvarProduto.setBackground(new java.awt.Color(0, 51, 153));
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
                .addContainerGap(24, Short.MAX_VALUE)
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

        btnAdicionarProduto.setBackground(new java.awt.Color(0, 51, 153));
        btnAdicionarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdicionarProdutoMouseEntered(evt);
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
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAdicionarProdutoLayout.setVerticalGroup(
            btnAdicionarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAdicionarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEditarProduto.setBackground(new java.awt.Color(0, 51, 153));
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
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Editar");

        javax.swing.GroupLayout btnEditarProdutoLayout = new javax.swing.GroupLayout(btnEditarProduto);
        btnEditarProduto.setLayout(btnEditarProdutoLayout);
        btnEditarProdutoLayout.setHorizontalGroup(
            btnEditarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditarProdutoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
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

        btnRemoverProduto.setBackground(new java.awt.Color(0, 51, 153));
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
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Remover");

        javax.swing.GroupLayout btnRemoverProdutoLayout = new javax.swing.GroupLayout(btnRemoverProduto);
        btnRemoverProduto.setLayout(btnRemoverProdutoLayout);
        btnRemoverProdutoLayout.setHorizontalGroup(
            btnRemoverProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRemoverProdutoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btnRemoverProdutoLayout.setVerticalGroup(
            btnRemoverProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRemoverProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(969, 521));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(145, 4, 72));

        lblBuscarParceiro.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblBuscarParceiro.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscarParceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/212936-24.png"))); // NOI18N

        txtBuscarParceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarParceiroActionPerformed(evt);
            }
        });
        txtBuscarParceiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarParceiroKeyReleased(evt);
            }
        });

        btnSalvarParceiro.setBackground(new java.awt.Color(145, 4, 72));
        btnSalvarParceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvarParceiro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSalvarParceiroMouseMoved(evt);
            }
        });
        btnSalvarParceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarParceiroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarParceiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarParceiroMouseExited(evt);
            }
        });

        lblSalvarParceiro.setBackground(new java.awt.Color(0, 102, 102));
        lblSalvarParceiro.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblSalvarParceiro.setForeground(new java.awt.Color(255, 255, 255));
        lblSalvarParceiro.setText("Salvar");

        javax.swing.GroupLayout btnSalvarParceiroLayout = new javax.swing.GroupLayout(btnSalvarParceiro);
        btnSalvarParceiro.setLayout(btnSalvarParceiroLayout);
        btnSalvarParceiroLayout.setHorizontalGroup(
            btnSalvarParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalvarParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSalvarParceiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSalvarParceiroLayout.setVerticalGroup(
            btnSalvarParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalvarParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSalvarParceiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAdicionarParceiro.setBackground(new java.awt.Color(145, 4, 72));
        btnAdicionarParceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionarParceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarParceiroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdicionarParceiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdicionarParceiroMouseExited(evt);
            }
        });

        lblAdicionarParceiro.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblAdicionarParceiro.setForeground(new java.awt.Color(255, 255, 255));
        lblAdicionarParceiro.setText("Adicionar Parceiro");

        javax.swing.GroupLayout btnAdicionarParceiroLayout = new javax.swing.GroupLayout(btnAdicionarParceiro);
        btnAdicionarParceiro.setLayout(btnAdicionarParceiroLayout);
        btnAdicionarParceiroLayout.setHorizontalGroup(
            btnAdicionarParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAdicionarParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdicionarParceiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAdicionarParceiroLayout.setVerticalGroup(
            btnAdicionarParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAdicionarParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdicionarParceiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEditarParceiro.setBackground(new java.awt.Color(145, 4, 72));
        btnEditarParceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarParceiro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEditarParceiroMouseMoved(evt);
            }
        });
        btnEditarParceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarParceiroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarParceiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarParceiroMouseExited(evt);
            }
        });

        lblEditarParceiro.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblEditarParceiro.setForeground(new java.awt.Color(255, 255, 255));
        lblEditarParceiro.setText("Editar");

        javax.swing.GroupLayout btnEditarParceiroLayout = new javax.swing.GroupLayout(btnEditarParceiro);
        btnEditarParceiro.setLayout(btnEditarParceiroLayout);
        btnEditarParceiroLayout.setHorizontalGroup(
            btnEditarParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEditarParceiroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEditarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnEditarParceiroLayout.setVerticalGroup(
            btnEditarParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEditarParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEditarParceiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRemoverParceiro.setBackground(new java.awt.Color(145, 4, 72));
        btnRemoverParceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemoverParceiro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRemoverParceiroMouseMoved(evt);
            }
        });
        btnRemoverParceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoverParceiroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoverParceiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoverParceiroMouseExited(evt);
            }
        });

        lblRemoverParceiro.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblRemoverParceiro.setForeground(new java.awt.Color(255, 255, 255));
        lblRemoverParceiro.setText("Remover");

        javax.swing.GroupLayout btnRemoverParceiroLayout = new javax.swing.GroupLayout(btnRemoverParceiro);
        btnRemoverParceiro.setLayout(btnRemoverParceiroLayout);
        btnRemoverParceiroLayout.setHorizontalGroup(
            btnRemoverParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRemoverParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRemoverParceiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnRemoverParceiroLayout.setVerticalGroup(
            btnRemoverParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRemoverParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRemoverParceiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblBuscarParceiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                .addComponent(btnAdicionarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemoverParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuscarParceiro)
                            .addComponent(txtBuscarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnRemoverParceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarParceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvarParceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdicionarParceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        txtNomeParceiro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNomeParceiro.setEnabled(false);
        txtNomeParceiro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeParceiroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeParceiroFocusLost(evt);
            }
        });

        lblNomeParceiro.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblNomeParceiro.setForeground(new java.awt.Color(0, 102, 102));
        lblNomeParceiro.setText("*Nome Parceiro:");

        lblEndereco.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(0, 102, 102));
        lblEndereco.setText("Endereço:");

        txtEndereco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEndereco.setEnabled(false);

        lblTelefone.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(0, 102, 102));
        lblTelefone.setText("Telefone 1:");

        txtTelefone.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefone.setEnabled(false);

        lblTelefone2.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblTelefone2.setForeground(new java.awt.Color(0, 102, 102));
        lblTelefone2.setText("Telefone 2:");

        txtTelefone2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefone2.setEnabled(false);

        lblEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 102, 102));
        lblEmail.setText("E-mail:");

        txtEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEmail.setEnabled(false);

        lblCnpj.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblCnpj.setForeground(new java.awt.Color(0, 102, 102));
        lblCnpj.setText("Cnpj:");

        txtCnpj.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCnpj.setEnabled(false);

        lblDescricao.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(0, 102, 102));
        lblDescricao.setText("Descrição:");

        txtDescricao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescricao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                        .addComponent(txtNomeParceiro, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNomeParceiro, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(lblEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescricao))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblEndereco)
                                        .addGap(153, 153, 153)
                                        .addComponent(lblTelefone))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(lblTelefone2))
                                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCnpj)
                                .addGap(142, 142, 142)
                                .addComponent(lblDescricao)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTelefone2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEndereco)
                            .addComponent(lblTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNomeParceiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblCnpj)
                    .addComponent(lblDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        listPartner.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        listPartner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listPartner.setSelectionBackground(new java.awt.Color(216, 222, 238));
        listPartner.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listPartner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPartnerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listPartner);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
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
// TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProdutoKeyReleased

    private void checkAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAtivosActionPerformed
  // TODO add your handling code here:
    }//GEN-LAST:event_checkAtivosActionPerformed

    private void btnSalvarProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseMoved

    private void btnSalvarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseClicked

    private void btnSalvarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseEntered



        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarProdutoMouseEntered

    private void btnAdicionarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoMouseClicked


 
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarProdutoMouseClicked

    private void btnAdicionarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoMouseEntered
// TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarProdutoMouseEntered

    private void btnEditarProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseMoved

    private void btnEditarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseClicked

    private void btnEditarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProdutoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProdutoMouseEntered

    private void btnRemoverProdutoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseMoved

    private void btnRemoverProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseClicked

    private void btnRemoverProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverProdutoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverProdutoMouseEntered

    private void txtBuscarParceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarParceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarParceiroActionPerformed

    private void txtBuscarParceiroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarParceiroKeyReleased
    // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarParceiroKeyReleased

    private void btnSalvarParceiroMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarParceiroMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarParceiroMouseMoved

    private void btnSalvarParceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarParceiroMouseClicked

 
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarParceiroMouseClicked

    private void btnSalvarParceiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarParceiroMouseEntered

        onHover2(btnSalvarParceiro);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarParceiroMouseEntered

    private void btnAdicionarParceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarParceiroMouseClicked

        edit(true);
        String partnerId = UUID.randomUUID().toString();
        partnerManager = new PartnerManagement();
        partnerManager.setE_partner_id(partnerId);
        partnerDao.addParcialPartner(partnerManager);
        lblNomeParceiro.setForeground(Color.red);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarParceiroMouseClicked

    private void btnAdicionarParceiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarParceiroMouseEntered

        onHover2(btnAdicionarParceiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarParceiroMouseEntered

    private void btnEditarParceiroMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarParceiroMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarParceiroMouseMoved

    private void btnEditarParceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarParceiroMouseClicked
        
        edit(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarParceiroMouseClicked

    private void btnEditarParceiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarParceiroMouseEntered
        
        onHover2(btnEditarParceiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarParceiroMouseEntered

    private void btnRemoverParceiroMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverParceiroMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverParceiroMouseMoved

    private void btnRemoverParceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverParceiroMouseClicked

        String idPartner = partnerList.get(valueSelectedList).getE_partner_id();
               
        productDao = new ProductManagementDAO();
        productManager = productDao.getListProduct();
        
            boolean yesNo = forValidationPartner(idPartner);
            
            if(yesNo == true) {
                JOptionPane.showMessageDialog(this, "Parceiro está vinculado a um produto!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Remover o produto selecionado?", "Atenção!", JOptionPane.YES_NO_OPTION);
                  if(option == JOptionPane.YES_OPTION) {
                    partnerDao.removePartner(idPartner);
                    updateList(partnerList, "update");
                  } else {
                    }  
              }
                
 // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverParceiroMouseClicked

    private void btnRemoverParceiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverParceiroMouseEntered
        
        onHover2(btnRemoverParceiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverParceiroMouseEntered

    private void listPartnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPartnerMouseClicked

        valueSelectedList = listPartner.getSelectedIndex();
        
        txtNomeParceiro.setText(partnerList.get(valueSelectedList).getName());
        txtEndereco.setText(partnerList.get(valueSelectedList).getAddress());
        txtTelefone.setText(partnerList.get(valueSelectedList).getPhone1());
        txtTelefone2.setText(partnerList.get(valueSelectedList).getPhone2());
        txtEmail.setText(partnerList.get(valueSelectedList).getEmail());
        txtCnpj.setText(partnerList.get(valueSelectedList).getCnpj());
        txtDescricao.setText(partnerList.get(valueSelectedList).getDescription());

        // TODO add your handling code here:
    }//GEN-LAST:event_listPartnerMouseClicked

    private void btnAdicionarParceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarParceiroMouseExited

        onLeaveHover2(btnAdicionarParceiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarParceiroMouseExited

    private void btnSalvarParceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarParceiroMouseExited

        onLeaveHover2(btnSalvarParceiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarParceiroMouseExited

    private void btnEditarParceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarParceiroMouseExited

        onLeaveHover2(btnEditarParceiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarParceiroMouseExited

    private void btnRemoverParceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverParceiroMouseExited

        onLeaveHover2(btnRemoverParceiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverParceiroMouseExited

    private void txtNomeParceiroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeParceiroFocusGained

        lblNomeParceiro.setForeground(new Color(0, 102, 102));
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeParceiroFocusGained

    private void txtNomeParceiroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeParceiroFocusLost

        String nometeste = txtNomeParceiro.getText();
        if(nometeste == null || nometeste.equals("")){
            lblNomeParceiro.setForeground(Color.red);
        } else {
            lblNomeParceiro.setForeground(new Color(0, 102, 102));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeParceiroFocusLost

    private void onHover2(JPanel pane1) {
        pane1.setBackground(new Color(159, 67, 112));
    }
    
    private void onLeaveHover2(JPanel pane1) {
        pane1.setBackground(new Color(145, 4, 72));
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
            java.util.logging.Logger.getLogger(RegisterPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterPartner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAdicionarParceiro;
    private javax.swing.JPanel btnAdicionarProduto;
    private javax.swing.JPanel btnEditarParceiro;
    private javax.swing.JPanel btnEditarProduto;
    private javax.swing.JPanel btnRemoverParceiro;
    private javax.swing.JPanel btnRemoverProduto;
    private javax.swing.JPanel btnSalvarParceiro;
    private javax.swing.JPanel btnSalvarProduto;
    private javax.swing.JCheckBox checkAtivos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdicionarParceiro;
    private javax.swing.JLabel lblBuscarParceiro;
    private javax.swing.JLabel lblBuscarProduto;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCodigoProduto;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEditarParceiro;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNomeParceiro;
    private javax.swing.JLabel lblRemoverParceiro;
    private javax.swing.JLabel lblSalvarParceiro;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefone2;
    private javax.swing.JList<String> listPartner;
    private javax.swing.JTextField txtBuscarParceiro;
    private javax.swing.JTextField txtBuscarProduto;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeParceiro;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTelefone2;
    // End of variables declaration//GEN-END:variables
     private void setIcon() {
        setTitle(" Cadastro de Parceiros");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
