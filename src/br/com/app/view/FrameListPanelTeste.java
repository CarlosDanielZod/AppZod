package br.com.app.view;

import br.com.app.model.TicketsManagement;
import br.com.app.jdbc.dao.TicketsManagementDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author carlos
 */
public class FrameListPanelTeste extends javax.swing.JFrame {

public PanelVisualizationHome visualizationHome = new PanelVisualizationHome();
    public PanelVisualizationRegisterClient visualizationRegister = new PanelVisualizationRegisterClient();
    public PanelVisualizationProduct visualizationProduct = new PanelVisualizationProduct();
    public String texto = "  Esta é a tela exclusiva para seus clientes, aqui você"
                    + " pode fazer o que quiser com eles, - no sistema é claro -,"
                    + "desde um simples cadastro até um lindo relatório construído"
                    + " para visualizar todas as informações a respeito deles, de forma simples e rápida.   ";
    
    public Date dateSystem = new Date();
    public TicketsManagementDAO ticketDao;
    public TicketsManagement ticketManager;
    public List<TicketsManagement> ticketList = new ArrayList<TicketsManagement>();
    public JPanel panelTicket;
    public JPanel panelReceiveTickets = new JPanel();
    public int cont = 300;
    public JLabel te;
    public String filtro;
    public Boolean filtroActive;
    

    public FrameListPanelTeste() {
        initComponents();
        
        ticketDao = new TicketsManagementDAO();
        ticketList = ticketDao.getListTicket();
        updateListTicket(ticketList, "update");
    }


        

    
    public void updateListTicket(List<TicketsManagement> listTicketManager, String filtrePor) {
        TicketsManagementDAO updateTicketDao = new TicketsManagementDAO();
        switch(filtrePor) {
//            case "filtroActive":
//                listTicketManager = updateTicketDao.getFilterActivesProd(true);
//                break;
            case "update":
                listTicketManager = updateTicketDao.getListTicket();
                break;
            case "filtroAll":
                listTicketManager = updateTicketDao.getFilterAllTicket(filtro);
                System.out.println("funciona");
                jpaneteste.revalidate();
                break;
            default:
                break;
        }
            ticketList = listTicketManager;
            GridLayoutButtonsTest();
    }
    
      public void personaPanel(JPanel panel) {
            panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.setSize(new Dimension(0, 0));
            panel.setBackground(Color.white);
            panel.setMaximumSize(new Dimension(250, 30));
            panel.setMinimumSize(new Dimension(250, 30));
            panel.setPreferredSize(new Dimension(900, 30));            
            
            panel.setSize(0, 0);
            
            panel.setBorder(BorderFactory.createLineBorder(new Color(150, 160, 255)));
        }
        
        public void personaLabel(JLabel label) {
            Font font = new Font("Segoe UI Light", Font.BOLD, 12);
            label.setFont(font);
            label.setMaximumSize(new Dimension(900, 30));
            label.setMinimumSize(new Dimension(900, 30));
            label.setPreferredSize(new Dimension(900, 30));
        }
    
     public void GridLayoutButtonsTest() {
        panelReceiveTickets = new JPanel();
        panelReceiveTickets.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelReceiveTickets.setPreferredSize(new Dimension(500, cont));

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(300, 1000));
        String teste = "<html><body> <font color='rgb(0,0,153)' font size='5'> Tickets: </font>";
        scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(150, 160, 255)), teste));
        scroll.setBackground(Color.WHITE);
//        scroll.setLocation(200, 500);

        panelReceiveTickets.setLayout(new FlowLayout(200, 5, 5)); //FlowLayout(400, 5, 5)

        for (TicketsManagement tickets : ticketList) {
             
            JPanel p = new JPanel();
            cont += 35;
            panelReceiveTickets.setPreferredSize(new Dimension(500, cont));
            personaPanel(p);
            te = new JLabel("ID: 0001 " + " Nome: " + tickets.getName_client());

            personaLabel(te);
            p.add(te);
            
            p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                onClick2(p);
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0) {
                onHover3(p);
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
                onLeaveHover3(p);
            }
});
            panelReceiveTickets.add(p);
        }
        scroll.setViewportView(panelReceiveTickets);
        jpaneteste.add(scroll);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        btnEntrarTickets = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jpaneteste = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscaFiltro = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 160, 255), 1, true));

        btnEntrarTickets.setBackground(new java.awt.Color(150, 160, 255));
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

        jpaneteste.setLayout(new java.awt.BorderLayout());

        jLabel8.setBackground(new java.awt.Color(150, 160, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 160, 255));
        jLabel8.setText("Buscar:");

        txtBuscaFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jpaneteste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 614, Short.MAX_VALUE)
                        .addComponent(btnEntrarTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEntrarTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtBuscaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(jpaneteste, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Tickets", jPanel9);

        panelRegisterClients.setBackground(new java.awt.Color(255, 255, 255));
        panelRegisterClients.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 160, 255), 1, true));

        javax.swing.GroupLayout panelClientImageLayout = new javax.swing.GroupLayout(panelClientImage);
        panelClientImage.setLayout(panelClientImageLayout);
        panelClientImageLayout.setHorizontalGroup(
            panelClientImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisualizationRegisterClient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        panelClientImageLayout.setVerticalGroup(
            panelClientImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisualizationRegisterClient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        jTextPane1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jTextPane1.setText("\"Esta é a tela exclusiva para seus clientes, aqui você pode fazer o que quiser com eles, - no sistema é claro - , desde um simples cadastro até um lindo relatório construído para visualizar todas as informações a respeito deles, de forma simples e rápida\".\n    ");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout panelClientInfoLayout = new javax.swing.GroupLayout(panelClientInfo);
        panelClientInfo.setLayout(panelClientInfoLayout);
        panelClientInfoLayout.setHorizontalGroup(
            panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );
        panelClientInfoLayout.setVerticalGroup(
            panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btnEntrarClientes.setBackground(new java.awt.Color(150, 160, 255));
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
                    .addGroup(panelRegisterClientsLayout.createSequentialGroup()
                        .addComponent(panelClientImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(panelClientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRegisterClientsLayout.createSequentialGroup()
                        .addComponent(btnEntrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRegisterClientsLayout.setVerticalGroup(
            panelRegisterClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterClientsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRegisterClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelClientImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelClientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Cadastro de Clientes", panelRegisterClients);

        panelRegisterProduct.setBackground(new java.awt.Color(255, 255, 255));
        panelRegisterProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 160, 255), 1, true));

        jPanel1.setPreferredSize(new java.awt.Dimension(596, 431));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisualizationProduct1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisualizationProduct1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(427, 128));

        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        btnEntrarProduto.setBackground(new java.awt.Color(150, 160, 255));
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
                    .addGroup(panelRegisterProductLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegisterProductLayout.createSequentialGroup()
                        .addComponent(btnEntrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRegisterProductLayout.setVerticalGroup(
            panelRegisterProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegisterProductLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRegisterProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Cadastro de Produtos", panelRegisterProduct);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(150, 160, 255), 1, true));

        btnEntrarParceiro.setBackground(new java.awt.Color(150, 160, 255));
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEntrarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(890, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnEntrarParceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Cadastro Parceiro", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarTicketsMouseClicked
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

        filtro = txtBuscaFiltro.getText();
        if(filtro != null) {
            updateListTicket(ticketList, "filtroAll");
        } else {
            updateListTicket(ticketList, "update");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaFiltroKeyReleased

    private void btnEntrarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarClientesMouseClicked

        RegisterClient registerZods = new RegisterClient();
        registerZods.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarClientesMouseClicked

    private void btnEntrarClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarClientesMouseEntered

        onHover2(btnEntrarClientes);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarClientesMouseEntered

    private void btnEntrarClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarClientesMouseExited

        onLeaveHover2(btnEntrarClientes);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarClientesMouseExited

    private void btnEntrarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarProdutoMouseClicked

        onClick2(btnEntrarProduto);

        RegisterProduct product = new RegisterProduct();
        product.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarProdutoMouseClicked

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarParceiroMouseEntered

    private void btnEntrarParceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarParceiroMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarParceiroMouseExited

        private void onHover3(JPanel pane1) {
        pane1.setBackground(new Color(127, 149, 213));
    }
    
    private void onLeaveHover3(JPanel pane1) {
        pane1.setBackground(new Color(255, 255, 255));
    }
    
      private void onClick3(JPanel pane1) {
        pane1.setBackground(new Color(0,0,153));
    }
      
      private void onLeaveClick3(JPanel pane1) {
        pane1.setBackground(new Color(150, 160, 255));
    }
    
    
    
    
    
     private void onHover2(JPanel pane1) {
        pane1.setBackground(new Color(127, 149, 213));
    }
    
    private void onLeaveHover2(JPanel pane1) {
        pane1.setBackground(new Color(150, 160, 255));
    }
    
      private void onClick2(JPanel pane1) {
        pane1.setBackground(new Color(0,0,153));
    }
      
      private void onLeaveClick2(JPanel pane1) {
        pane1.setBackground(new Color(150, 160, 255));
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
            java.util.logging.Logger.getLogger(FrameListPanelTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameListPanelTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameListPanelTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameListPanelTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameListPanelTeste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEntrarClientes;
    private javax.swing.JPanel btnEntrarParceiro;
    private javax.swing.JPanel btnEntrarProduto;
    private javax.swing.JPanel btnEntrarTickets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JPanel jpaneteste;
    private javax.swing.JPanel panelClientImage;
    private javax.swing.JPanel panelClientInfo;
    private javax.swing.JPanel panelRegisterClients;
    private javax.swing.JPanel panelRegisterProduct;
    private br.com.app.view.PanelVisualizationProduct panelVisualizationProduct1;
    private br.com.app.view.PanelVisualizationRegisterClient panelVisualizationRegisterClient1;
    private javax.swing.JTextField txtBuscaFiltro;
    // End of variables declaration//GEN-END:variables
}
