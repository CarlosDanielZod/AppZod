package br.com.app.jdbc.dao;

import br.com.app.model.ProductClousureManagement;
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
public class ProductClousureManagementDAO {
    
    private Connection connection;
    
    public ProductClousureManagementDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void addProductClousure(ProductClousureManagement productClousure) {
        try {
            String sql = "INSERT INTO e_product_close (e_product_close_id, e_product_session_id, e_ticket_id, name, code, code_additional, discount, type, qty, labor,"
                    + " cost_additional, price_sales, totalprice_sales, issales) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, productClousure.getE_product_close_id());
            stmt.setString(2, productClousure.getProduct_session_id());
            stmt.setString(3, productClousure.getE_ticket_id());
            stmt.setString(4, productClousure.getName());
            stmt.setInt(5, productClousure.getCode());
            stmt.setInt(6, productClousure.getCode_additional());
            stmt.setString(7, productClousure.getDiscount());
            stmt.setString(8, productClousure.getType());
            stmt.setInt(9, productClousure.getQty());
            stmt.setString(10, productClousure.getLabor());
            stmt.setString(11, productClousure.getCost_additional());
            stmt.setString(12, productClousure.getPrice_sales());
            stmt.setString(13, productClousure.getTotalprice_sales());
            stmt.setBoolean(14, productClousure.getIsSales());
                   
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductClousureManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ProductClousureManagement getProductClousure(String product_close_id) {
        try {
           ProductClousureManagement productClousure = new ProductClousureManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT * FROM e_product_close WHERE e_product_close_id ='" + product_close_id + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     productClousure.setE_product_close_id(rs.getString("e_product_close_id"));
                     productClousure.setE_ticket_id(rs.getString("e_ticket_id"));
                     productClousure.setCreated(rs.getTimestamp("created"));
                     productClousure.setName(rs.getString("name"));
                     productClousure.setCode(rs.getInt("code"));
                     productClousure.setCode_additional(rs.getInt("code_additional"));
                     productClousure.setDiscount(rs.getString("discount"));
                     productClousure.setType(rs.getString("type"));
                     productClousure.setQty(rs.getInt("qty"));
                     productClousure.setLabor(rs.getString("labor"));
                     productClousure.setCost_additional(rs.getString("cost_additional"));
                     productClousure.setPrice_sales(rs.getString("price_sales"));
                     productClousure.setTotalprice_sales(rs.getString("totalprice_sales"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return productClousure;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
     public List<ProductClousureManagement> getProductClousureByTicket(String e_ticket_id) {
        try {
           List<ProductClousureManagement> productClousureList = new ArrayList<ProductClousureManagement>();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT * FROM e_product_close WHERE e_ticket_id ='" + e_ticket_id + "' ORDER BY code DESC");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                    ProductClousureManagement productClousure = new ProductClousureManagement();
                     productClousure.setE_product_close_id(rs.getString("e_product_close_id"));
                     productClousure.setProduct_session_id(rs.getString("e_product_session_id"));
                     productClousure.setE_ticket_id(rs.getString("e_ticket_id"));
                     productClousure.setCreated(rs.getTimestamp("created"));
                     productClousure.setName(rs.getString("name"));
                     productClousure.setCode(rs.getInt("code"));
                     productClousure.setCode_additional(rs.getInt("code_additional"));
                     productClousure.setDiscount(rs.getString("discount"));
                     productClousure.setType(rs.getString("type"));
                     productClousure.setQty(rs.getInt("qty"));
                     productClousure.setLabor(rs.getString("labor"));
                     productClousure.setCost_additional(rs.getString("cost_additional"));
                     productClousure.setPrice_sales(rs.getString("price_sales"));
                     productClousure.setTotalprice_sales(rs.getString("totalprice_sales"));
                     productClousure.setIsSales(rs.getBoolean("issales"));
                     productClousureList.add(productClousure);
                 }
                 
                 rs.close();
                 stmt.close();
                 return productClousureList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
    public void saveProdClousure(int code, String name, String type,
            int qty, String price, String total, String e_product_close_id) {
             try {        
                 String sql = "UPDATE e_product_close SET qty=?, totalprice_sales=?"
                         + " WHERE e_product_id ='" + e_product_close_id + "'";
                      PreparedStatement stmt = connection.prepareStatement(sql);

                            stmt.setInt(1, qty);
                            stmt.setString(2, total);
                stmt.executeUpdate();
                stmt.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProductClousureManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    
    public void isSales(Boolean trueOrFalse, String e_product_close_id) {
          try {        
            String sql = "UPDATE e_product_close SET issales=?"
                + " WHERE e_product_close_id ='" + e_product_close_id + "'";
            PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setBoolean(1, trueOrFalse);
                
                stmt.executeUpdate();
                stmt.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProductClousureManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    
     public ProductClousureManagement getProductClousureBySession(String product_session_id) {
        try {
           ProductClousureManagement productClousure = new ProductClousureManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT * FROM e_product_close WHERE e_product_session_id ='" + product_session_id + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     productClousure.setE_product_close_id(rs.getString("e_product_close_id"));
                     productClousure.setProduct_session_id(rs.getString("e_product_session_id"));
                     productClousure.setE_ticket_id(rs.getString("e_ticket_id"));
                     productClousure.setCreated(rs.getTimestamp("created"));
                     productClousure.setName(rs.getString("name"));
                     productClousure.setCode(rs.getInt("code"));
                     productClousure.setCode_additional(rs.getInt("code_additional"));
                     productClousure.setDiscount(rs.getString("discount"));
                     productClousure.setType(rs.getString("type"));
                     productClousure.setQty(rs.getInt("qty"));
                     productClousure.setLabor(rs.getString("labor"));
                     productClousure.setCost_additional(rs.getString("cost_additional"));
                     productClousure.setPrice_sales(rs.getString("price_sales"));
                     productClousure.setTotalprice_sales(rs.getString("totalprice_sales"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return productClousure;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
}
