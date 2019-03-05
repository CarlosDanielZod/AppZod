package br.com.app.jdbc.dao;

import br.com.app.model.ProductSalesManagement;
import connection.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class ProductSalesManagementDAO {
    
    public Connection connection;
    
        public ProductSalesManagementDAO() {
         this.connection = new ConnectionFactory().getConnection();
    }
        
    public void addProductSales(ProductSalesManagement productSales) {
        try {
            String sql = "INSERT INTO e_product_sales (e_product_sales_id, labor, cost_additional, price_sales, totalprice_sales) VALUES(?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, productSales.getProduct_sales_id());
            stmt.setString(2, productSales.getLabor());
            stmt.setString(3, productSales.getCost_additional());
            stmt.setString(4, productSales.getPrice_sales());
            stmt.setString(5, productSales.getTotalPrice_sales());
            
            stmt.execute();
            stmt.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(ProductSalesManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public List<ProductSalesManagement> getListProductSales() {
        try {
           List<ProductSalesManagement> productSalesList = new ArrayList<ProductSalesManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_product_sales");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     ProductSalesManagement productSalesManager = new ProductSalesManagement();
                     productSalesManager.setProduct_sales_id(rs.getString("e_product_sales_id"));
                     productSalesManager.setLabor(rs.getString("labor"));
                     productSalesManager.setCost_additional(rs.getString("cost_additional"));
                     productSalesManager.setPrice_sales(rs.getString("price_sales"));
                     productSalesManager.setTotalPrice_sales(rs.getString("totalprice_sales"));

                     productSalesList.add(productSalesManager);
                 }
                 rs.close();
                 stmt.close();
                 return productSalesList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
        }
    
    public ProductSalesManagement getProductSales(String productSalesId) {
        try {
           ProductSalesManagement productSales = new ProductSalesManagement();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_product_sales WHERE e_product_sales_id='" + productSalesId + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     productSales.setProduct_sales_id(rs.getString("e_product_sales_id"));
                     productSales.setLabor(rs.getString("labor"));
                     productSales.setCost_additional(rs.getString("cost_additional"));
                     productSales.setPrice_sales(rs.getString("price_sales"));
                     productSales.setTotalPrice_sales(rs.getString("totalprice_sales"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return productSales;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
         public void removeProductSales(String id) {
             try {
                 String sql = "DELETE FROM e_product_sales WHERE e_product_sales_id=?";
                 PreparedStatement stmt = connection.prepareStatement(sql);
                 
                 stmt.setString(1, id);
                 
                 stmt.executeUpdate();
                 stmt.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    public void updateRemoveProd(String nulo, String e_product_id) {
             try {        
                 String sql = "UPDATE e_product SET e_product_sales_id=? WHERE e_product_id ='" + e_product_id + "'";
                      PreparedStatement stmt = connection.prepareStatement(sql);
  
                            stmt.setString(1, nulo);
                      
                stmt.executeUpdate();
                stmt.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
        public void updateProductSales(String labor, String custoAdicional, String precoVenda, String totalVenda, String e_product_sales_id) {
             try {        
                 String sql = "UPDATE e_product_sales SET labor=?, cost_additional=?, price_sales=?, totalprice_sales=?"
                         + " WHERE e_product_sales_id ='" + e_product_sales_id + "'";
                      PreparedStatement stmt = connection.prepareStatement(sql);
  
                            stmt.setString(1, labor);
                            stmt.setString(2, custoAdicional);
                            stmt.setString(3, precoVenda);
                            stmt.setString(4, totalVenda);
                            
                            stmt.executeUpdate();
                            stmt.close();
                            
                } catch (SQLException ex) {
                     Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
    }
}
