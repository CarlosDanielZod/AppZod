package br.com.app.view;

import br.com.app.utils.Formats;
import br.com.app.model.ProductClousureManagement;
import br.com.app.jdbc.dao.ProductSessionManagementDAO;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class PanelButtonProduct extends javax.swing.JPanel {

    private ProductSessionManagementDAO productSessionDao = new ProductSessionManagementDAO();
    private String qtdeCurrent;
    private Formats formats = new Formats();
    
    public PanelButtonProduct(Color color, int codigo, String nome, String tipo, String preco, int qtde, String total, String idProductSession) {
        initComponents();
        setName(idProductSession);
        txtCod.setText(""+codigo);
        txtNome.setText(nome);
        txtTipo.setText(tipo);
        txtPreco.setText(preco);
        txtQtde.setText(""+qtde);
        txtTotal.setText(total);
        panelPayment.setBackground(color);
                
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
            }
                    
            @Override
            public void mouseEntered(MouseEvent arg0) {
                setBackground(new Color(213, 210, 210));
                personaOnHoverLeaveHover(panelCod, panelNome, panelTipo, panelPreco, panelQtde, jPanel1);
            }
            
            @Override
            public void mouseExited(MouseEvent arg0) {
                setBackground(new Color(240, 240, 240));
                personaOnHoverLeaveHover(panelCod, panelNome, panelTipo, panelPreco, panelQtde, jPanel1);
            }
        });

        txtQtde.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                qtdeCurrent = txtQtde.getText();
                String totalFormated = "";
                NumberFormat currencyFormatter = formats.getCurrencyBR();
                String precoFormated = txtPreco.getText();
                
                if(precoFormated != null && !precoFormated.equals("")) {
                   double dbPrice = formats.desformatCurrency(precoFormated);
                   double dbQtde = Double.parseDouble(qtdeCurrent);
                   double dbTotal = 0;
                  
                   if(dbQtde == 1) {
                       dbTotal = dbPrice;
                   } else if(dbQtde > 1) {
                        dbTotal = dbPrice * dbQtde;
                     }
                   
                    totalFormated = currencyFormatter.format(dbTotal);
                    txtTotal.setText(totalFormated);
                }
            }
        });
    }
    
    public void personaOnHoverLeaveHover(JPanel panel, JPanel panel2, JPanel panel3, JPanel panel4, JPanel panel5, JPanel panel6) {
        panel.setBackground(new Color(213, 210, 210));
        panel2.setBackground(new Color(213, 210, 210));
        panel3.setBackground(new Color(213, 210, 210));
        panel4.setBackground(new Color(213, 210, 210));
        panel5.setBackground(new Color(213, 210, 210));
        panel6.setBackground(new Color(213, 210, 210));
    }
    
    public void personaHoverPanel(JPanel panel) {
        panel.setBackground(new Color(213, 210, 210));
    }
    
    public void personaLeaveHoverPanel(JPanel panel) {
        panel.setBackground(new Color(240, 240, 240));
    }
    
    public void updateProductClousure(String e_product_close_id) {
        setName(e_product_close_id);
    }
    
    public ProductClousureManagement productClousureInfo() {
        ProductClousureManagement productClose = new ProductClousureManagement();
        productClose.setE_product_close_id(getName());
        productClose.setName(txtNome.getText());
        productClose.setCode(Integer.parseInt(txtCod.getText()));
        productClose.setType(txtTipo.getText());
        productClose.setPrice_sales(txtPreco.getText());
        productClose.setQty(Integer.parseInt(txtQtde.getText()));
        productClose.setTotalprice_sales(txtTotal.getText());
        
        return productClose;
    }
    
    public void enableQtde(Boolean yesNo, String idSelectedButton, List<PanelButtonProduct> listProductComponent) {
        for (PanelButtonProduct listId : listProductComponent) {
                if(idSelectedButton != null && idSelectedButton.equals(listId.getName()) || listId.getName().equals(idSelectedButton)) {
                    listId.txtQtde.setEnabled(yesNo);
                    break;
                } else {
                    System.out.println("ish, Deu erro");
                }
        }
    }
    
    public void updateButton(String idProductPanel, String preco, int qtdeEstoque) {
        
            String qtde1 = txtQtde.getText();
            int validation = Integer.parseInt(qtde1);
            
            if(validation <= qtdeEstoque) {
                  String totalFormated = "";
                  NumberFormat currencyFormatter = formats.getCurrencyBR();
                  String qtde = String.valueOf(qtdeEstoque);
                  
                if(preco != null && !preco.equals("")) {
                  double dbPrice = formats.desformatCurrency(preco);
                  double dbQtde = Double.parseDouble(qtde);
                  double dbTotal = 0;

                   if(dbQtde == 1) {
                       dbTotal = dbPrice;
                   } else if(dbQtde > 1) {
                        dbTotal = dbPrice * dbQtde;
                   }
                   
                  totalFormated = currencyFormatter.format(dbTotal);
                  txtTotal.setText(totalFormated);
                  
                } else {
                  }
                
                if(qtde1 != null && !qtde1.equals("")) {
                   int qtdeInt = Integer.parseInt(qtde1); 
                    productSessionDao.alterProdSession(qtdeInt, "0", idProductPanel);
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "Ops, não temos esta quantidade do produto");
                txtQtde.setText(String.valueOf(qtdeEstoque));
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCod = new javax.swing.JPanel();
        panelPayment = new javax.swing.JPanel();
        lblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JLabel();
        panelNome = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        panelTipo = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JLabel();
        panelPreco = new javax.swing.JPanel();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JLabel();
        panelQtde = new javax.swing.JPanel();
        lblQtde = new javax.swing.JLabel();
        txtQtde = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(110, 60, 85), 1, true));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        panelCod.setDoubleBuffered(false);
        panelCod.setMaximumSize(new java.awt.Dimension(80, 50));
        panelCod.setMinimumSize(new java.awt.Dimension(80, 50));
        panelCod.setPreferredSize(new java.awt.Dimension(80, 50));
        panelCod.setLayout(new javax.swing.BoxLayout(panelCod, javax.swing.BoxLayout.LINE_AXIS));
        panelCod.add(panelPayment);

        lblCod.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblCod.setText("Código:  ");
        panelCod.add(lblCod);

        txtCod.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtCod.setText("10");
        txtCod.setMaximumSize(new java.awt.Dimension(20, 18));
        txtCod.setMinimumSize(new java.awt.Dimension(20, 18));
        txtCod.setPreferredSize(new java.awt.Dimension(20, 18));
        panelCod.add(txtCod);

        add(panelCod);

        panelNome.setMaximumSize(new java.awt.Dimension(230, 50));
        panelNome.setMinimumSize(new java.awt.Dimension(230, 50));
        panelNome.setPreferredSize(new java.awt.Dimension(230, 50));
        panelNome.setLayout(new javax.swing.BoxLayout(panelNome, javax.swing.BoxLayout.LINE_AXIS));

        lblNome.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblNome.setText("Nome:  ");
        lblNome.setMinimumSize(new java.awt.Dimension(40, 18));
        lblNome.setPreferredSize(new java.awt.Dimension(40, 18));
        panelNome.add(lblNome);

        txtNome.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtNome.setText("Produto para teste teste teste teste teste");
        txtNome.setMaximumSize(new java.awt.Dimension(180, 16));
        txtNome.setMinimumSize(new java.awt.Dimension(180, 16));
        txtNome.setPreferredSize(new java.awt.Dimension(180, 16));
        panelNome.add(txtNome);

        add(panelNome);

        panelTipo.setMaximumSize(new java.awt.Dimension(160, 50));
        panelTipo.setMinimumSize(new java.awt.Dimension(160, 50));
        panelTipo.setPreferredSize(new java.awt.Dimension(160, 50));
        panelTipo.setLayout(new javax.swing.BoxLayout(panelTipo, javax.swing.BoxLayout.LINE_AXIS));

        lblTipo.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblTipo.setText("Tipo:  ");
        panelTipo.add(lblTipo);

        txtTipo.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtTipo.setText("teste teste teste teste");
        panelTipo.add(txtTipo);

        add(panelTipo);

        panelPreco.setMaximumSize(new java.awt.Dimension(110, 50));
        panelPreco.setMinimumSize(new java.awt.Dimension(110, 50));
        panelPreco.setPreferredSize(new java.awt.Dimension(110, 50));
        panelPreco.setLayout(new javax.swing.BoxLayout(panelPreco, javax.swing.BoxLayout.LINE_AXIS));

        lblPreco.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblPreco.setText("Preço:  ");
        panelPreco.add(lblPreco);

        txtPreco.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtPreco.setText("R$ 100,00");
        panelPreco.add(txtPreco);

        add(panelPreco);

        panelQtde.setMaximumSize(new java.awt.Dimension(70, 55));
        panelQtde.setMinimumSize(new java.awt.Dimension(70, 55));
        panelQtde.setPreferredSize(new java.awt.Dimension(70, 55));
        panelQtde.setLayout(new javax.swing.BoxLayout(panelQtde, javax.swing.BoxLayout.LINE_AXIS));

        lblQtde.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        lblQtde.setText("Qtde:  ");
        panelQtde.add(lblQtde);

        txtQtde.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtQtde.setText("20");
        txtQtde.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQtde.setEnabled(false);
        txtQtde.setMaximumSize(new java.awt.Dimension(27, 25));
        txtQtde.setMinimumSize(new java.awt.Dimension(27, 25));
        txtQtde.setPreferredSize(new java.awt.Dimension(27, 25));
        panelQtde.add(txtQtde);

        add(panelQtde);

        jPanel1.setMaximumSize(new java.awt.Dimension(120, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(120, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel1.setText("  Total:  ");
        jPanel1.add(jLabel1);

        txtTotal.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        txtTotal.setText("R$ 100.00,00");
        jPanel1.add(txtTotal);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQtde;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel panelCod;
    private javax.swing.JPanel panelNome;
    private javax.swing.JPanel panelPayment;
    private javax.swing.JPanel panelPreco;
    private javax.swing.JPanel panelQtde;
    private javax.swing.JPanel panelTipo;
    private javax.swing.JLabel txtCod;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtPreco;
    private javax.swing.JTextField txtQtde;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
