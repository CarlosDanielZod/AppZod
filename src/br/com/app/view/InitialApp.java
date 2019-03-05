package br.com.app.view;

import br.com.app.model.TicketsManagement;
import br.com.app.jdbc.dao.TicketsManagementDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class InitialApp extends javax.swing.JFrame  {
    
    public String texto = "  Esta é a tela exclusiva para seus clientes, aqui você"
                    + " pode fazer o que quiser com eles, - no sistema é claro -,"
                    + "desde um simples cadastro até um lindo relatório construído"
                    + " para visualizar todas as informações a respeito deles, de forma simples e rápida.   ";
    
    public Date dateSystem = new Date();
    public TicketsManagementDAO ticketDao = new TicketsManagementDAO();
    public TicketsManagement ticketManager;
    public List<TicketsManagement> ticketList;
    public JPanel panelTicket;
    public JPanel panelReceiveTickets = new JPanel();
    public int cont = 300;
    public JLabel te;
    public String filterName;
    public String filtroProduto;
    public String filtroAll;
    
    public InitialApp() {
        initComponents();
        setIcon();
        listaTickets.setFixedCellHeight(30);
        ticketList = ticketDao.getListTicket();
        
        updateTicketList(ticketList, "update");
        
    }
    
    public String validateNullString(String texto) {
        if(texto == null || texto.equals("")) {
            texto = "";
        }
        return texto;
    }
    
    public void updateTicketList(List<TicketsManagement> listTicket, String filtroPor) {
        TicketsManagementDAO updateTicketDao = new TicketsManagementDAO();
        switch(filtroPor) {
            case "update":
                listTicket = updateTicketDao.getListTicket();
                break;
            case "filtroNome":
                String name = "filtroNome";
                listTicket = updateTicketDao.getFilterNameTicket(filterName, name);
                break;
            case "filtroNomeProduto":
                String nameProduct = "filtroNomeProduto";
                listTicket = updateTicketDao.getFilterNameTicket(filtroProduto, nameProduct);
                break;
            case "filtroAll":
                listTicket = updateTicketDao.getFilterAllTicket(filtroAll);
                break;
        }
        
        DefaultListModel model = new DefaultListModel();
        for (TicketsManagement tickets : listTicket) {
            int ticketCode = tickets.getTicket();
            String client = tickets.getName_client();
            String nameClient = validateNullString(client);
            String rg = tickets.getRg();
            String rgClient = validateNullString(rg);
            String phone = tickets.getPhone1();
            String phoneClient = validateNullString(phone);
            
            String columnTicket = "<html><body> <font color='#6E3C55' font size='4'> Ticket: </font>"; 
            String columnNome = "<html><body> <font color='#6E3C55' font size='4'> Nome: </font>";
            String columnRg = "<html><body> <font color='#6E3C55' font size='4'> Rg: </font>";
            String columnPhone = "<html><body> <font color='#6E3C55' font size='4'> Telefone: </font>";
//            String columnProduct = "<html><body> <font color='#6E3C55' font size='4'> Produto: </font>";
//            String columnCodeProduct = "<html><body> <font color='#6E3C55' font size='4'> Código: </font>";
//            String columnType = "<html><body> <font color='#6E3C55' font size='4'> Tipo: </font>";
//            String columnQty = "<html><body> <font color='#6E3C55' font size='4'> Qtde: </font>";
//            String columnPrice = "<html><body> <font color='#6E3C55' font size='4'> Preço: </font>";
//            String columnTotal = "<html><body> <font color='#6E3C55' font size='4'> Total: </font>";
            
            model.addElement(columnTicket + ticketCode + " | " + columnNome + nameClient + " | " + columnRg + rgClient
                    + " | " + columnPhone + phoneClient);
        }
        listaTickets.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panelInit = new javax.swing.JPanel();
        btnReports = new javax.swing.JPanel();
        lblRegisterClient = new javax.swing.JLabel();
        indicator1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        btnEntrarTickets = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscaFiltro = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaTickets = new javax.swing.JList<>();
        checkName = new javax.swing.JCheckBox();
        checkProduct = new javax.swing.JCheckBox();
        panelRegisterClients = new javax.swing.JPanel();
        panelClientImage = new javax.swing.JPanel();
        panelVisualizationRegisterClient1 = new br.com.app.view.PanelVisualizationRegisterClient();
        panelClientInfo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btnEntrarClientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRegisterProduct = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelVisualizationProduct1 = new br.com.app.view.PanelVisualizationProduct();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        btnEntrarProduto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnEntrarParceiro = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnEmail = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cadastro de Clientes");

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(974, 525));

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(974, 500));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInit.setBackground(new java.awt.Color(23, 35, 51));

        btnReports.setBackground(new java.awt.Color(23, 35, 51));
        btnReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportsMouseExited(evt);
            }
        });

        lblRegisterClient.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblRegisterClient.setForeground(new java.awt.Color(255, 255, 255));
        lblRegisterClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/213054-24.png"))); // NOI18N
        lblRegisterClient.setText("Relatórios");

        indicator1.setBackground(new java.awt.Color(23, 35, 51));

        javax.swing.GroupLayout indicator1Layout = new javax.swing.GroupLayout(indicator1);
        indicator1.setLayout(indicator1Layout);
        indicator1Layout.setHorizontalGroup(
            indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        indicator1Layout.setVerticalGroup(
            indicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btnReportsLayout = new javax.swing.GroupLayout(btnReports);
        btnReports.setLayout(btnReportsLayout);
        btnReportsLayout.setHorizontalGroup(
            btnReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReportsLayout.createSequentialGroup()
                .addComponent(indicator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegisterClient)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        btnReportsLayout.setVerticalGroup(
            btnReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(indicator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btnReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegisterClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/287782-64.png"))); // NOI18N

        javax.swing.GroupLayout panelInitLayout = new javax.swing.GroupLayout(panelInit);
        panelInit.setLayout(panelInitLayout);
        panelInitLayout.setHorizontalGroup(
            panelInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelInitLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInitLayout.setVerticalGroup(
            panelInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInitLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(81, 81, 81)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(496, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelInit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 35, 51), 1, true));

        btnEntrarTickets.setBackground(new java.awt.Color(23, 35, 51));
        btnEntrarTickets.setForeground(new java.awt.Color(0, 51, 153));
        btnEntrarTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrarTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarTicketsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarTicketsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarTicketsMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Entrar");

        javax.swing.GroupLayout btnEntrarTicketsLayout = new javax.swing.GroupLayout(btnEntrarTickets);
        btnEntrarTickets.setLayout(btnEntrarTicketsLayout);
        btnEntrarTicketsLayout.setHorizontalGroup(
            btnEntrarTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarTicketsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEntrarTicketsLayout.setVerticalGroup(
            btnEntrarTicketsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarTicketsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setBackground(new java.awt.Color(150, 160, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(110, 60, 85));
        jLabel8.setText("Buscar:");

        txtBuscaFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaFiltroKeyReleased(evt);
            }
        });

        listaTickets.setBackground(new java.awt.Color(247, 249, 255));
        listaTickets.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        listaTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listaTickets.setSelectionBackground(new java.awt.Color(216, 222, 238));
        listaTickets.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaTicketsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listaTicketsMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(listaTickets);

        checkName.setBackground(new java.awt.Color(255, 255, 255));
        checkName.setText("Filtrar por nome");

        checkProduct.setBackground(new java.awt.Color(255, 255, 255));
        checkProduct.setText("Filtrar nome produto");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(checkName)
                        .addGap(18, 18, 18)
                        .addComponent(checkProduct)
                        .addGap(23, 782, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEntrarTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkName)
                    .addComponent(checkProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtBuscaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEntrarTickets, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        jTabbedPane2.addTab("Tickets", jPanel9);

        panelRegisterClients.setBackground(new java.awt.Color(255, 255, 255));
        panelRegisterClients.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 160, 255), 1, true));

        javax.swing.GroupLayout panelClientImageLayout = new javax.swing.GroupLayout(panelClientImage);
        panelClientImage.setLayout(panelClientImageLayout);
        panelClientImageLayout.setHorizontalGroup(
            panelClientImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisualizationRegisterClient1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        panelClientImageLayout.setVerticalGroup(
            panelClientImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisualizationRegisterClient1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, Short.MAX_VALUE)
        );

        jTextPane1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jTextPane1.setText("\"Esta é a tela exclusiva para seus clientes, aqui você pode fazer o que quiser com eles, - no sistema é claro - , desde um simples cadastro até um lindo relatório construído para visualizar todas as informações a respeito deles, de forma simples e rápida\".\n    ");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout panelClientInfoLayout = new javax.swing.GroupLayout(panelClientInfo);
        panelClientInfo.setLayout(panelClientInfoLayout);
        panelClientInfoLayout.setHorizontalGroup(
            panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );
        panelClientInfoLayout.setVerticalGroup(
            panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        btnEntrarClientes.setBackground(new java.awt.Color(23, 35, 51));
        btnEntrarClientes.setForeground(new java.awt.Color(0, 51, 153));
        btnEntrarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarClientesMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrar");

        javax.swing.GroupLayout btnEntrarClientesLayout = new javax.swing.GroupLayout(btnEntrarClientes);
        btnEntrarClientes.setLayout(btnEntrarClientesLayout);
        btnEntrarClientesLayout.setHorizontalGroup(
            btnEntrarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEntrarClientesLayout.setVerticalGroup(
            btnEntrarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRegisterClientsLayout = new javax.swing.GroupLayout(panelRegisterClients);
        panelRegisterClients.setLayout(panelRegisterClientsLayout);
        panelRegisterClientsLayout.setHorizontalGroup(
            panelRegisterClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterClientsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegisterClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelClientImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(panelClientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRegisterClientsLayout.setVerticalGroup(
            panelRegisterClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterClientsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelRegisterClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelClientInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelClientImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jTabbedPane2.addTab("Cadastro de Clientes", panelRegisterClients);

        panelRegisterProduct.setBackground(new java.awt.Color(255, 255, 255));
        panelRegisterProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 160, 255), 1, true));

        jPanel1.setPreferredSize(new java.awt.Dimension(596, 431));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisualizationProduct1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisualizationProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(427, 128));

        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        btnEntrarProduto.setBackground(new java.awt.Color(23, 35, 51));
        btnEntrarProduto.setForeground(new java.awt.Color(0, 51, 153));
        btnEntrarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarProdutoMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Entrar");

        javax.swing.GroupLayout btnEntrarProdutoLayout = new javax.swing.GroupLayout(btnEntrarProduto);
        btnEntrarProduto.setLayout(btnEntrarProdutoLayout);
        btnEntrarProdutoLayout.setHorizontalGroup(
            btnEntrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEntrarProdutoLayout.setVerticalGroup(
            btnEntrarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRegisterProductLayout = new javax.swing.GroupLayout(panelRegisterProduct);
        panelRegisterProduct.setLayout(panelRegisterProductLayout);
        panelRegisterProductLayout.setHorizontalGroup(
            panelRegisterProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegisterProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegisterProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRegisterProductLayout.setVerticalGroup(
            panelRegisterProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterProductLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(panelRegisterProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jTabbedPane2.addTab("Cadastro de Produtos", panelRegisterProduct);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 160, 255), 1, true));

        btnEntrarParceiro.setBackground(new java.awt.Color(23, 35, 51));
        btnEntrarParceiro.setForeground(new java.awt.Color(0, 51, 153));
        btnEntrarParceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrarParceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarParceiroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarParceiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarParceiroMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Entrar");

        javax.swing.GroupLayout btnEntrarParceiroLayout = new javax.swing.GroupLayout(btnEntrarParceiro);
        btnEntrarParceiro.setLayout(btnEntrarParceiroLayout);
        btnEntrarParceiroLayout.setHorizontalGroup(
            btnEntrarParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnEntrarParceiroLayout.setVerticalGroup(
            btnEntrarParceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEntrarParceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jTextPane3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnEntrarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEntrarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cadastro Parceiro", jPanel6);

        panelPrincipal.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, 526));

        jPanel2.setBackground(new java.awt.Color(145, 4, 72));

        btnEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/212937-24.png"))); // NOI18N
        btnEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmailMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1608599-24.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addComponent(btnEmail)
                .addContainerGap(926, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        panelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 0, 1060, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1307, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseClicked

    Reports reports = new Reports();
    reports.setVisible(true);
        
    }//GEN-LAST:event_btnReportsMouseClicked

    private void btnReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseEntered
              
        btnReports.setBackground(new Color(71, 87, 108));
    
    // TODO add your handling code here:
    }//GEN-LAST:event_btnReportsMouseEntered

    private void btnEntrarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarClientesMouseClicked

        RegisterClient registerZods = new RegisterClient();
        registerZods.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarClientesMouseClicked

    private void btnEntrarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarProdutoMouseClicked
        
//        onClick2(btnEntrarProduto);
        
        RegisterProduct product = new RegisterProduct();
        product.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarProdutoMouseClicked

    private void btnEntrarClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarClientesMouseEntered
        
        onHover2(btnEntrarClientes);
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarClientesMouseEntered

    private void btnEntrarClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarClientesMouseExited

        onLeaveHover2(btnEntrarClientes);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarClientesMouseExited

    private void btnEntrarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarProdutoMouseEntered

        onHover2(btnEntrarProduto);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarProdutoMouseEntered

    private void btnEntrarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarProdutoMouseExited

        onLeaveHover2(btnEntrarProduto);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarProdutoMouseExited

    private void btnEntrarParceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarParceiroMouseClicked
        
        RegisterPartner partner = new RegisterPartner();
        partner.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarParceiroMouseClicked

    private void btnEntrarParceiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarParceiroMouseEntered

        onHover2(btnEntrarParceiro);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarParceiroMouseEntered

    private void btnEntrarParceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarParceiroMouseExited
    
        onLeaveHover2(btnEntrarParceiro);
// TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarParceiroMouseExited

    private void btnEntrarTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarTicketsMouseClicked

//    SharedTicket sharedTicket = new SharedTicket();
//    sharedTicket.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarTicketsMouseClicked

    private void btnEntrarTicketsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarTicketsMouseEntered
     
        onHover2(btnEntrarTickets);
// TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarTicketsMouseEntered

    private void btnEntrarTicketsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarTicketsMouseExited
       
            onLeaveHover2(btnEntrarTickets);

// TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarTicketsMouseExited

    private void txtBuscaFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaFiltroKeyReleased

        filterName = txtBuscaFiltro.getText();
        filtroAll = txtBuscaFiltro.getText();
        boolean nameBoo = checkName.isSelected();
        boolean productBoo = checkProduct.isSelected();

        if(nameBoo == false && productBoo == false) {
            updateTicketList(ticketList, "filtroAll");
        }
        
        if(nameBoo == true) {
            if(filterName != null && !filterName.equals("")) {
                updateTicketList(ticketList, "filtroNome");
                } else {
                    updateTicketList(ticketList, "update");
                  }
        } else if(nameBoo == false) {
                if(productBoo == true) {
                    filtroProduto = txtBuscaFiltro.getText();
                    if(filtroProduto != null && !filtroProduto.equals("")) {
                     updateTicketList(ticketList, "filtroNomeProduto");
                    } else {
                        updateTicketList(ticketList, "update");
                      }
                }
            }
        
// TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaFiltroKeyReleased

    private void listaTicketsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTicketsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listaTicketsMouseEntered

    private void listaTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTicketsMouseClicked
        int valueSelectedList = listaTickets.getSelectedIndex();
        TicketsManagement ticketForShared = null;
        if(evt.getClickCount() == 2) {
            ticketForShared = new TicketsManagement();
            ticketForShared.setE_ticket_id(ticketList.get(valueSelectedList).getE_ticket_id());
            ticketForShared.setE_client_id(ticketList.get(valueSelectedList).getE_client_id());
            ticketForShared.setTicket(ticketList.get(valueSelectedList).getTicket());
            ticketForShared.setCode_client(ticketList.get(valueSelectedList).getCode_client());
            ticketForShared.setName_client(ticketList.get(valueSelectedList).getName_client());
            ticketForShared.setAddress(ticketList.get(valueSelectedList).getAddress());
            ticketForShared.setRg(ticketList.get(valueSelectedList).getRg());
            ticketForShared.setCpf(ticketList.get(valueSelectedList).getCpf());
            ticketForShared.setPhone1(ticketList.get(valueSelectedList).getPhone1());
            ticketForShared.setPhone2(ticketList.get(valueSelectedList).getPhone2());
            ticketForShared.setEmail(ticketList.get(valueSelectedList).getEmail());
            ticketForShared.setDescription_client(ticketList.get(valueSelectedList).getDescription_client());
            //Informações Produto, se existirem
        SharedTicket shared = new SharedTicket(ticketForShared);
        shared.setVisible(true);
        }

        
        // TODO add your handling code here:
    }//GEN-LAST:event_listaTicketsMouseClicked

    private void btnEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmailMouseClicked

        FrameEmail email = new FrameEmail();
        email.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmailMouseClicked

    private void btnReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseExited

        btnReports.setBackground(new Color(23, 35, 51));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportsMouseExited

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InitialApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitialApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitialApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitialApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InitialApp().setVisible(true);
            }
        });
    }

     private void onHover2(JPanel pane1) {
        pane1.setBackground(new Color(71, 87, 108));
    }
    
    private void onLeaveHover2(JPanel pane1) {
        pane1.setBackground(new Color(23, 35, 51));
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEmail;
    private javax.swing.JPanel btnEntrarClientes;
    private javax.swing.JPanel btnEntrarParceiro;
    private javax.swing.JPanel btnEntrarProduto;
    private javax.swing.JPanel btnEntrarTickets;
    private javax.swing.JPanel btnReports;
    private javax.swing.JCheckBox checkName;
    private javax.swing.JCheckBox checkProduct;
    private javax.swing.JPanel indicator1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JLabel lblRegisterClient;
    private javax.swing.JList<String> listaTickets;
    private javax.swing.JPanel panelClientImage;
    private javax.swing.JPanel panelClientInfo;
    private javax.swing.JPanel panelInit;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRegisterClients;
    private javax.swing.JPanel panelRegisterProduct;
    private br.com.app.view.PanelVisualizationProduct panelVisualizationProduct1;
    private br.com.app.view.PanelVisualizationRegisterClient panelVisualizationRegisterClient1;
    private javax.swing.JTextField txtBuscaFiltro;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setTitle(" Bem Vindo!");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/287782-32.png")));
    }
}
