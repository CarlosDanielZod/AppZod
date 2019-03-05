package br.com.app.jdbc.dao;

import br.com.app.model.ProductSessionManagement;
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
public class ProductSessionManagementDAO {
        private Connection connection;
    
    public ProductSessionManagementDAO() {
         this.connection = new ConnectionFactory().getConnection();
    }
    
     public void addProductSession(ProductSessionManagement productSession) {
        try {
            String sql = "INSERT INTO e_product_session (e_product_session_id, e_product_id, name, code, code_additional, discount, type, qty, labor,"
                    + " cost_additional, price_sales, totalprice_sales) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, productSession.getProduct_session_id());
            stmt.setString(2, productSession.getE_product_id());
            stmt.setString(3, productSession.getName());
            stmt.setInt(4, productSession.getCode());
            stmt.setInt(5, productSession.getCode_additional());
            stmt.setString(6, productSession.getDiscount());
            stmt.setString(7, productSession.getType());
            stmt.setInt(8, productSession.getQty());
            stmt.setString(9, productSession.getLabor());
            stmt.setString(10, productSession.getCost_additional());
            stmt.setString(11, productSession.getPrice_sales());
            stmt.setString(12, productSession.getTotalprice_sales());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public List<ProductSessionManagement> getListProductSession() {
        try {
           List<ProductSessionManagement> productSessionList = new ArrayList<ProductSessionManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_product_session WHERE qty >= 1");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     ProductSessionManagement productSessionManager = new ProductSessionManagement();
                     productSessionManager.setProduct_session_id(rs.getString("e_product_session_id"));
                     productSessionManager.setE_product_id(rs.getString("e_product_id"));
                     productSessionManager.setCreated(rs.getTimestamp("created"));
                     productSessionManager.setName(rs.getString("name"));
                     productSessionManager.setCode(rs.getInt("code"));
                     productSessionManager.setCode_additional(rs.getInt("code_additional"));
                     productSessionManager.setDiscount(rs.getString("discount"));
                     productSessionManager.setType(rs.getString("type"));
                     productSessionManager.setQty(rs.getInt("qty"));
                     productSessionManager.setLabor(rs.getString("labor"));
                     productSessionManager.setCost_additional(rs.getString("cost_additional"));
                     productSessionManager.setPrice_sales(rs.getString("price_sales"));
                     productSessionManager.setTotalprice_sales(rs.getString("totalprice_sales"));

                     productSessionList.add(productSessionManager);
                 }
                 rs.close();
                 stmt.close();
                 return productSessionList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
      
       public ProductSessionManagement getProductSession(String product_session_id) {
        try {
           ProductSessionManagement productSessionManager = new ProductSessionManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT * FROM e_product_session WHERE e_product_session_id ='" + product_session_id + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     productSessionManager.setProduct_session_id(rs.getString("e_product_session_id"));
                     productSessionManager.setE_product_id(rs.getString("e_product_id"));
                     productSessionManager.setCreated(rs.getTimestamp("created"));
                     productSessionManager.setName(rs.getString("name"));
                     productSessionManager.setCode(rs.getInt("code"));
                     productSessionManager.setCode_additional(rs.getInt("code_additional"));
                     productSessionManager.setDiscount(rs.getString("discount"));
                     productSessionManager.setType(rs.getString("type"));
                     productSessionManager.setQty(rs.getInt("qty"));
                     productSessionManager.setLabor(rs.getString("labor"));
                     productSessionManager.setCost_additional(rs.getString("cost_additional"));
                     productSessionManager.setPrice_sales(rs.getString("price_sales"));
                     productSessionManager.setTotalprice_sales(rs.getString("totalprice_sales"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return productSessionManager;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
       
       public void alterProdSession(int qty, String discount, String product_session_id) {
             try {        
                 String sql = "UPDATE e_product_session SET qty=?, "
                         + "discount=?"
                         + " WHERE e_product_session_id ='" + product_session_id + "'";
                      PreparedStatement stmt = connection.prepareStatement(sql);

                            stmt.setInt(1, qty);
                            stmt.setString(2, discount);

                stmt.executeUpdate();
                stmt.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
}
