package br.com.app.view;

import br.com.app.model.ProductManagement;
import br.com.app.model.ClientManagement;
import br.com.app.model.TicketsManagement;
import br.com.app.jdbc.dao.ClientManagementDAO;
import br.com.app.jdbc.dao.ProductManagementDAO;
import br.com.app.jdbc.dao.TicketsManagementDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class RegisterClient extends javax.swing.JFrame {

    public ClientManagementDAO clientDao;
    public List<ClientManagement> clientManager;
    public int valueSelectedList;
    public int count = 0;
    public String valueSelectedId;
    public String testando;
    public ProductManagement productManager;
    public String idSelectProduct;
    public List<ProductManagement> listProducts = new ArrayList<ProductManagement>();
    public ProductManagementDAO productDao = new ProductManagementDAO();
//    public TicketManagementDAO ticketDao = new TicketManagementDAO();
//    public TicketsManagement ticketManager;

    
    public RegisterClient() {
        initComponents();
        setIcon();
        
        clientDao = new ClientManagementDAO();
        clientManager = clientDao.getListClients();
        
        for (ClientManagement clientManagement : clientManager) {
            System.out.println(clientManagement.getCreated());
        }
        
        updateList(clientManager, "update");
        
    }
    
    public void setarPurchaseProd(ProductManagement product) {
        this.productManager = product;
    }
    
    public String validateNullString(String texto) {
        if(texto == null || texto.equals("")) {
            texto = "";
        }
        return texto;
    }
    
    public void updateList(List<ClientManagement> listClientManager, String filtrarPor) {
        ClientManagementDAO updateListDao = new ClientManagementDAO();
        switch (filtrarPor) {
            case "filtroActive":
              //  listProductManager = updateListDao.getFilterActivesProd(filtroActive);
                break;
            case "update":
                listClientManager = updateListDao.getListClients();
                break;
            case "updateDESC":
                listClientManager = updateListDao.getListDescClients();
                break;
            case "filtroAll":
              //  listProductManager = updateListDao.getFilterAllProd(filtroAll);
                break;
            default:
                break;
        }
        
        DefaultListModel model = new DefaultListModel();
        for (ClientManagement client : listClientManager) {
            int cod = client.getCode();
            String nameClient = client.getName();
            String name = validateNullString(nameClient);
            String phoneClient = client.getPhone1();
            String phone = validateNullString(phoneClient);
            String emailClient = client.getEmail();
            String email = validateNullString(emailClient);
            String rgClient = client.getRg();
            String rg = validateNullString(rgClient);

            String columnCodigo = "<html><body> <font color='#6E3C55' font size='4'> Código: </font>"; 
            String columnNome = "<html><body> <font color='#6E3C55' font size='4'> Nome: </font>";
            String columnTelefone = "<html><body> <font color='#6E3C55' font size='4'> Telefone: </font>";
            String columnEmail = "<html><body> <font color='#6E3C55' font size='4'> E-mail: </font>";
            String columnRg = "<html><body> <font color='#6E3C55' font size='4'> Rg: </font>";

            String idProduto = client.getE_product_id();
            
            if(idProduto == null || idProduto.equals("")) {
                model.addElement(columnCodigo + cod + "  |  " + columnNome + name + "  |  " + columnTelefone + phone +  "  |  "
                    + columnEmail + email + "  |  " + columnRg + rg);
            } else {
                 String columnProd = "<html><body> <font color='red' font size='4'> # </font>"; 
                    model.addElement(columnProd + columnCodigo + cod + "  |  " + columnNome + name + "  |  " + columnTelefone + phone +  "  |  "
                        + columnEmail + email + "  |  " + columnRg + rg);
              }
         }
        clientManager = listClientManager;
        listClientRegistered.setModel(model);        
    }
    
    public void edit(boolean yesNo) {
        txtName.setEnabled(yesNo);
        txtAdress.setEnabled(yesNo);
        txtPhone1.setEnabled(yesNo);
        txtPhone2.setEnabled(yesNo);
        txtEmail.setEnabled(yesNo);
        txtCpf.setEnabled(yesNo);
        txtRg.setEnabled(yesNo);
        txtDescription.setEnabled(yesNo);
    }
    
    public void clean() {
        txtName.setText("");
        txtAdress.setText("");
        txtPhone1.setText("");
        txtPhone2.setText("");
        txtEmail.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtDescription.setText("");
    }
    
//    public void setProductInClient(ProductManagement product) {
//        idSelectProduct = product.getE_product_id();
//        txtNameProd.setText(product.getName());
//        txtTypeProd.setText(product.getType());
//        txtCod_additional.setText(String.valueOf(product.getCode_additional()));
//        txtPriceProd.setText(product.getPrice());
//        txtQtd.setText(String.valueOf(product.getQty()));
//        txtTotal.setText(product.getTotal());   
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanelButtons = new javax.swing.JPanel();
        jbutton1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbutton2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelForm = new javax.swing.JPanel();
        txtPhone1 = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        lblPhone2 = new javax.swing.JLabel();
        txtPhone2 = new javax.swing.JTextField();
        lblRg = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblPhone1 = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listClientRegistered = new javax.swing.JList<>();
        jPanelButtonForm = new javax.swing.JPanel();
        btnEdit = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        titleCod = new javax.swing.JLabel();
        lblCod_client = new javax.swing.JLabel();
        btnAddClient = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnSaveClient = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.POPUP);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanelButtons.setBackground(new java.awt.Color(255, 255, 255));

        jbutton1.setBackground(new java.awt.Color(23, 35, 51));
        jbutton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbutton1.setPreferredSize(new java.awt.Dimension(168, 38));
        jbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbutton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbutton1MouseEntered(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Clientes");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(23, 35, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(6, 39));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jbutton1Layout = new javax.swing.GroupLayout(jbutton1);
        jbutton1.setLayout(jbutton1Layout);
        jbutton1Layout.setHorizontalGroup(
            jbutton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbutton1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jbutton1Layout.setVerticalGroup(
            jbutton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jbutton1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30))
            .addGroup(jbutton1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jbutton2.setBackground(new java.awt.Color(23, 35, 51));
        jbutton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbutton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbutton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbutton2MouseEntered(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Adicionar Produtos");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jbutton2Layout = new javax.swing.GroupLayout(jbutton2);
        jbutton2.setLayout(jbutton2Layout);
        jbutton2Layout.setHorizontalGroup(
            jbutton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbutton2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jbutton2Layout.setVerticalGroup(
            jbutton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbutton2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 0));

        txtPhone1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        txtPhone1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPhone1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPhone1.setEnabled(false);

        txtName.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtName.setEnabled(false);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtCpf.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        txtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCpf.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCpf.setEnabled(false);

        lblPhone2.setBackground(new java.awt.Color(0, 102, 102));
        lblPhone2.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblPhone2.setForeground(new java.awt.Color(0, 102, 102));
        lblPhone2.setText("Telefone 2:");

        txtPhone2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        txtPhone2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPhone2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPhone2.setEnabled(false);

        lblRg.setBackground(new java.awt.Color(0, 102, 102));
        lblRg.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblRg.setForeground(new java.awt.Color(0, 102, 102));
        lblRg.setText("Rg:");

        lblDescription.setBackground(new java.awt.Color(0, 102, 102));
        lblDescription.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(0, 102, 102));
        lblDescription.setText("Descrição:");

        lblName.setBackground(new java.awt.Color(0, 102, 102));
        lblName.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 102, 102));
        lblName.setText("*Nome:");

        lblEmail.setBackground(new java.awt.Color(0, 102, 102));
        lblEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 102, 102));
        lblEmail.setText("E-mail:");

        lblAdress.setBackground(new java.awt.Color(0, 102, 102));
        lblAdress.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblAdress.setForeground(new java.awt.Color(0, 102, 102));
        lblAdress.setText("Endereço:");

        txtDescription.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        txtDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDescription.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescription.setEnabled(false);
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });

        txtRg.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        txtRg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRg.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRg.setEnabled(false);

        txtAdress.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        txtAdress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAdress.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAdress.setEnabled(false);

        txtEmail.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEmail.setEnabled(false);

        lblPhone1.setBackground(new java.awt.Color(0, 102, 102));
        lblPhone1.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblPhone1.setForeground(new java.awt.Color(0, 102, 102));
        lblPhone1.setText("Telefone 1:");

        lblCpf.setBackground(new java.awt.Color(0, 102, 102));
        lblCpf.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblCpf.setForeground(new java.awt.Color(0, 102, 102));
        lblCpf.setText("Cpf:");

        listClientRegistered.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        listClientRegistered.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listClientRegistered.setSelectionBackground(new java.awt.Color(216, 222, 238));
        listClientRegistered.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listClientRegistered.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClientRegisteredMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listClientRegistered);

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPhone1)
                                    .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPhone2)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelFormLayout.createSequentialGroup()
                                        .addComponent(txtDescription)
                                        .addContainerGap())
                                    .addGroup(jPanelFormLayout.createSequentialGroup()
                                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDescription)
                                            .addGroup(jPanelFormLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblRg))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCpf)
                                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(139, 193, Short.MAX_VALUE))))
                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdress)))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(lblAdress)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRg, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCpf, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescription)
                            .addComponent(lblEmail)
                            .addComponent(lblPhone2)
                            .addComponent(lblPhone1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelButtonForm.setBackground(new java.awt.Color(145, 4, 72));

        btnEdit.setBackground(new java.awt.Color(145, 4, 72));
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Editar");

        javax.swing.GroupLayout btnEditLayout = new javax.swing.GroupLayout(btnEdit);
        btnEdit.setLayout(btnEditLayout);
        btnEditLayout.setHorizontalGroup(
            btnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnEditLayout.setVerticalGroup(
            btnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRemove.setBackground(new java.awt.Color(145, 4, 72));
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoveMouseEntered(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Remover");

        javax.swing.GroupLayout btnRemoveLayout = new javax.swing.GroupLayout(btnRemove);
        btnRemove.setLayout(btnRemoveLayout);
        btnRemoveLayout.setHorizontalGroup(
            btnRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRemoveLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btnRemoveLayout.setVerticalGroup(
            btnRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRemoveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        titleCod.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        titleCod.setForeground(new java.awt.Color(255, 255, 255));
        titleCod.setText("Código Cliente:");

        lblCod_client.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblCod_client.setForeground(new java.awt.Color(255, 255, 255));
        lblCod_client.setText("0");

        btnAddClient.setBackground(new java.awt.Color(145, 4, 72));
        btnAddClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddClientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddClientMouseEntered(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Novo Cliente");

        javax.swing.GroupLayout btnAddClientLayout = new javax.swing.GroupLayout(btnAddClient);
        btnAddClient.setLayout(btnAddClientLayout);
        btnAddClientLayout.setHorizontalGroup(
            btnAddClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAddClientLayout.setVerticalGroup(
            btnAddClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAddClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSaveClient.setBackground(new java.awt.Color(145, 4, 72));
        btnSaveClient.setForeground(new java.awt.Color(0, 51, 153));
        btnSaveClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveClientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveClientMouseEntered(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Salvar");

        javax.swing.GroupLayout btnSaveClientLayout = new javax.swing.GroupLayout(btnSaveClient);
        btnSaveClient.setLayout(btnSaveClientLayout);
        btnSaveClientLayout.setHorizontalGroup(
            btnSaveClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSaveClientLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(32, 32, 32))
        );
        btnSaveClientLayout.setVerticalGroup(
            btnSaveClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSaveClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelButtonFormLayout = new javax.swing.GroupLayout(jPanelButtonForm);
        jPanelButtonForm.setLayout(jPanelButtonFormLayout);
        jPanelButtonFormLayout.setHorizontalGroup(
            jPanelButtonFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonFormLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(titleCod, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCod_client)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelButtonFormLayout.setVerticalGroup(
            jPanelButtonFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonFormLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanelButtonFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelButtonFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleCod, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCod_client))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbutton1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jbutton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(jPanelButtonForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addComponent(jPanelButtonForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelButtonsLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelButtonsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jbutton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbutton1MouseClicked
       
//        onClick(jbutton1);
//        onLeaveClick(jbutton2);
// TODO add your handling code here:
    }//GEN-LAST:event_jbutton1MouseClicked

    private void jbutton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbutton2MouseClicked
                
//        String idteste = teste.getId();
//        onClick(jbutton2);
//        onLeaveClick(jbutton1);
//        ListSelectProd listProduct = new ListSelectProd(this);
//        
//        listProduct.setVisible(true);
//        ProductManagement teste2 = listProduct.testeexport();
//        productManager = teste2;
//        
//valueSelectedId = listProduct.getValueSelected();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jbutton2MouseClicked

    private void jbutton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbutton1MouseEntered
        
        onHover(jbutton1);
        onLeaveHover(jbutton2);
// TODO add your handling code here:
    }//GEN-LAST:event_jbutton1MouseEntered

    private void jbutton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbutton2MouseEntered
    
        onHover(jbutton2);
        onLeaveHover(jbutton1);

// TODO add your handling code here:
    }//GEN-LAST:event_jbutton2MouseEntered

    private void listClientRegisteredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClientRegisteredMouseClicked

        valueSelectedList = listClientRegistered.getSelectedIndex();
        lblCod_client.setText(""+clientManager.get(valueSelectedList).getCode());
                txtName.setText(clientManager.get(valueSelectedList).getName());
                txtPhone1.setText(clientManager.get(valueSelectedList).getPhone1());
                txtPhone2.setText(clientManager.get(valueSelectedList).getPhone2());
                txtAdress.setText(clientManager.get(valueSelectedList).getAddress());
                txtEmail.setText(clientManager.get(valueSelectedList).getEmail());
                txtCpf.setText(clientManager.get(valueSelectedList).getCpf());
                txtRg.setText(clientManager.get(valueSelectedList).getRg());
                txtDescription.setText(clientManager.get(valueSelectedList).getDescription());

        // TODO add your handling code here:
    }//GEN-LAST:event_listClientRegisteredMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        
         String clientId = clientManager.get(valueSelectedList).getE_client_id();
         //se o client selecionado possuir ticket, ele não poderá ser removido, a não ser que remova o ticket antes
        int option = JOptionPane.showConfirmDialog(this, "Remover o cliente selecionado ?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION) {
            clientDao.removeClient(clientId);
            updateList(clientManager, "update");
            clean();
            JOptionPane.showMessageDialog(this, "Removido!", "Atenção!",JOptionPane.INFORMATION_MESSAGE);
        } else {
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void btnRemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseEntered

        onHover2(btnRemove);
        onLeaveHover2(btnAddClient);
//        onLeaveHover2(btnRegister);
        onLeaveHover2(btnEdit);
        onLeaveHover2(btnSaveClient);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveMouseEntered

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
      
//        onClick2(btnEdit);
        edit(true);
//        onLeaveClick2(btnAddClient);
//        onLeaveClick2(btnRegister);
//        onLeaveClick2(btnSaveClient);
//        onLeaveClick2(btnRemove);
//        
// TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
      
        onHover2(btnEdit);
        onLeaveHover2(btnAddClient);
//        onLeaveHover2(btnRegister);
        onLeaveHover2(btnSaveClient);
        onLeaveHover2(btnRemove);

// TODO add your handling code here:
    }//GEN-LAST:event_btnEditMouseEntered

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void btnAddClientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddClientMouseEntered

        onHover2(btnAddClient);
//        onLeaveHover2(btnRegister);
        onLeaveHover2(btnEdit);
        onLeaveHover2(btnSaveClient);
        onLeaveHover2(btnRemove);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddClientMouseEntered

    private void btnAddClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddClientMouseClicked

        edit(true);
        ClientManagement client = new ClientManagement();
        ClientManagementDAO clientData = new ClientManagementDAO();
        
        String clientId = UUID.randomUUID().toString();
        
        ClientManagement clientCode = clientData.returnCodeClient();
        int codeClient = clientCode.getCode();
        codeClient++;
        client.setE_client_id(clientId);
        client.setCode(codeClient);
        clientData.addClientParcial(client);
        updateList(clientManager, "updateDESC");
        listClientRegistered.setSelectedIndex(0);
        int teste = listClientRegistered.getSelectedIndex();
        
        lblCod_client.setText(""+clientManager.get(teste).getCode());
        txtName.setText(clientManager.get(teste).getName());
        txtAdress.setText(clientManager.get(teste).getAddress());
        txtRg.setText(clientManager.get(teste).getRg());
        txtCpf.setText(clientManager.get(teste).getCpf());
        txtPhone1.setText(clientManager.get(teste).getPhone1());
        txtPhone2.setText(clientManager.get(teste).getPhone2());
        txtEmail.setText(clientManager.get(teste).getEmail());
        txtDescription.setText(clientManager.get(teste).getDescription());
    
                TicketsManagement ticketManager = new TicketsManagement();
                TicketsManagementDAO ticketDao = new TicketsManagementDAO();
                String ticketId = UUID.randomUUID().toString();
                
                TicketsManagement codeTicketManager = ticketDao.returnCodeTicket();
                int codeTicket = codeTicketManager.getTicket();
                codeTicket++;
                ticketManager.setE_ticket_id(ticketId);
                ticketManager.setE_client_id(clientId);                
                ticketManager.setTicket(codeTicket);
                ticketManager.setCode_client(codeClient);
                ticketDao.addParcialTicket(ticketManager);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddClientMouseClicked

    private void btnSaveClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveClientMouseClicked
        
        ClientManagementDAO daoClient = new ClientManagementDAO();
        
        valueSelectedList = listClientRegistered.getSelectedIndex();
        String clientId = clientManager.get(valueSelectedList).getE_client_id();
        
        String nome = txtName.getText();
        String endereco = txtAdress.getText();
        String rg = txtRg.getText();
        String cpf = txtCpf.getText();
        String telefone1 = txtPhone1.getText();
        String telefone2 = txtPhone2.getText();
        String email = txtEmail.getText();
        String descricao = txtDescription.getText();
        
        Date utilDate = new Date();
        Timestamp updated = new Timestamp(utilDate.getTime());
        
        TicketsManagementDAO daoTicket = new TicketsManagementDAO();
        TicketsManagement ticketByClient = daoTicket.getTicketByClient(clientId);
          if(nome != null && !nome.equals("")) {
            if(ticketByClient != null) {
                String ticketId = ticketByClient.getE_ticket_id();
                daoTicket.saveTicket(nome, endereco, rg, cpf, telefone1, telefone2, email, descricao, ticketId);
                daoClient.saveClient(null, updated, nome, endereco, rg, cpf,
                    telefone1, telefone2, email, descricao, clientId);
                        edit(false);

                } else {
                    daoClient.saveClient(null, updated, nome, endereco, rg, cpf,
                    telefone1, telefone2, email, descricao, clientId);
                        edit(false);
            }
                 updateList(clientManager, "update");
                 JOptionPane.showMessageDialog(this, "Registro salvo!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "É obrigatório o preenchimento dos campos que possuem asterísco!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }        
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnSaveClientMouseClicked

    private void btnSaveClientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveClientMouseEntered
        
        onHover2(btnSaveClient);
        onLeaveHover2(btnAddClient);
//        onLeaveHover2(btnRegister);
        onLeaveHover2(btnEdit);
        onLeaveHover2(btnRemove);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSaveClientMouseEntered

    
    private void onHover(JPanel pane1) {
        pane1.setBackground(new Color(71, 87, 108));
    }
    
    private void onLeaveHover(JPanel pane1) {
        pane1.setBackground(new Color(23, 35, 51));
    }
    
//      private void onClick(JPanel pane1) {
//        pane1.setBackground(new Color(0,204,255));
//    }
//      
//      private void onLeaveClick(JPanel pane1) {
//        pane1.setBackground(Color.white);
//    }
      
      //
      
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
  
       try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAddClient;
    private javax.swing.JPanel btnEdit;
    private javax.swing.JPanel btnRemove;
    private javax.swing.JPanel btnSaveClient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelButtonForm;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jbutton1;
    private javax.swing.JPanel jbutton2;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblCod_client;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblPhone2;
    private javax.swing.JLabel lblRg;
    private javax.swing.JList<String> listClientRegistered;
    private javax.swing.JLabel titleCod;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone1;
    private javax.swing.JTextField txtPhone2;
    private javax.swing.JTextField txtRg;
    // End of variables declaration//GEN-END:variables
      private void setIcon() {
        setTitle(" Cadastro de Clientes");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
