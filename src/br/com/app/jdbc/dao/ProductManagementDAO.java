package br.com.app.jdbc.dao;

import br.com.app.model.ProductManagement;
import connection.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class ProductManagementDAO {
 
    private Connection connection;
    
    public ProductManagementDAO() {
         this.connection = new ConnectionFactory().getConnection();
    }
    
    public void addProduct(ProductManagement product) {
        try {
            String sql = "INSERT INTO e_product (e_product_id, e_product_sales_id, e_partner_id, updated, isactive, name, code, code_additional, type, qty, price,"
                    + " total, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, product.getE_product_id());
            stmt.setString(2, product.getE_product_sales_id());
            stmt.setString(3, product.getE_partner_id());
            stmt.setTimestamp(4, product.getUpdated());
            stmt.setBoolean(5, product.isIsActive());
            stmt.setString(6, product.getName());
            stmt.setInt(7, product.getCode());
            stmt.setInt(8, product.getCode_additional());
            stmt.setString(9, product.getType());
            stmt.setInt(10, product.getQty());
            stmt.setString(11, product.getPrice());
            stmt.setString(12, product.getTotal());
            stmt.setString(13, product.getDescription());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void addProductParcial(ProductManagement product) {
        try {
            String sql = "INSERT INTO e_product (e_product_id, code) VALUES (?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getE_product_id());
            stmt.setInt(2, product.getCode());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ProductManagement>getListProduct() {
        try {
           List<ProductManagement> productList = new ArrayList<ProductManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_product ORDER BY code ASC");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     ProductManagement productManager = new ProductManagement();
                     productManager.setE_product_id(rs.getString("e_product_id"));
                     productManager.setE_product_sales_id(rs.getString("e_product_sales_id"));
                     productManager.setE_partner_id(rs.getString("e_partner_id"));
                     productManager.setCreated(rs.getTimestamp("created"));
                     productManager.setUpdated(rs.getTimestamp("updated"));
                     productManager.setIsActive(rs.getBoolean("isactive"));
                     productManager.setName(rs.getString("name"));
                     productManager.setCode(rs.getInt("code"));
                     productManager.setCode_additional(rs.getInt("code_additional"));
                     productManager.setType(rs.getString("type"));
                     productManager.setQty(rs.getInt("qty"));
                     productManager.setPrice(rs.getString("price"));
                     productManager.setTotal(rs.getString("total"));
                     productManager.setDescription(rs.getString("description"));

                     productList.add(productManager);
                 }
                 rs.close();
                 stmt.close();
                 return productList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
    public List<ProductManagement>getListDescProduct() {
        try {
           List<ProductManagement> productList = new ArrayList<ProductManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_product ORDER BY code DESC");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     ProductManagement productManager = new ProductManagement();
                     productManager.setE_product_id(rs.getString("e_product_id"));
                     productManager.setE_product_sales_id(rs.getString("e_product_sales_id"));
                     productManager.setE_partner_id(rs.getString("e_partner_id"));
                     productManager.setCreated(rs.getTimestamp("created"));
                     productManager.setUpdated(rs.getTimestamp("updated"));
                     productManager.setIsActive(rs.getBoolean("isactive"));
                     productManager.setName(rs.getString("name"));
                     productManager.setCode(rs.getInt("code"));
                     productManager.setCode_additional(rs.getInt("code_additional"));
                     productManager.setType(rs.getString("type"));
                     productManager.setQty(rs.getInt("qty"));
                     productManager.setPrice(rs.getString("price"));
                     productManager.setTotal(rs.getString("total"));
                     productManager.setDescription(rs.getString("description"));

                     productList.add(productManager);
                 }
                 rs.close();
                 stmt.close();
                 return productList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
    public List<ProductManagement> getFilterActivesProd(boolean isactive) {
           try {
           List<ProductManagement> productList = new ArrayList<ProductManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_product WHERE isactive='" + isactive + "' ORDER BY code ASC");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     ProductManagement productManager = new ProductManagement();
                     productManager.setE_product_id(rs.getString("e_product_id"));
                     productManager.setE_product_sales_id(rs.getString("e_product_sales_id"));
                     productManager.setE_partner_id(rs.getString("e_partner_id"));
                     productManager.setCreated(rs.getTimestamp("created"));
                     productManager.setUpdated(rs.getTimestamp("updated"));
                     productManager.setIsActive(rs.getBoolean("isactive"));
                     productManager.setName(rs.getString("name"));
                     productManager.setCode(rs.getInt("code"));
                     productManager.setCode_additional(rs.getInt("code_additional"));
                     productManager.setType(rs.getString("type"));
                     productManager.setQty(rs.getInt("qty"));
                     productManager.setPrice(rs.getString("price"));
                     productManager.setTotal(rs.getString("total"));
                     productManager.setDescription(rs.getString("description"));

                     productList.add(productManager);
                 }
                 rs.close();
                 stmt.close();
                 return productList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
    public List<ProductManagement> getFilterAllProd(String filtroAll) {
           try {
           List<ProductManagement> productList = new ArrayList<ProductManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_product WHERE name ILIKE '%" + filtroAll + "%' OR cast(code_additional as varchar(42))"
                                 + " LIKE '%" + filtroAll + "%' OR type ILIKE '%" + filtroAll + "%' ORDER BY code ASC");

                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     ProductManagement productManager = new ProductManagement();
                     productManager.setE_product_id(rs.getString("e_product_id"));
                     productManager.setE_product_sales_id(rs.getString("e_product_sales_id"));
                     productManager.setE_partner_id(rs.getString("e_partner_id"));
                     productManager.setCreated(rs.getTimestamp("created"));
                     productManager.setUpdated(rs.getTimestamp("updated"));
                     productManager.setIsActive(rs.getBoolean("isactive"));
                     productManager.setName(rs.getString("name"));
                     productManager.setCode(rs.getInt("code"));
                     productManager.setCode_additional(rs.getInt("code_additional"));
                     productManager.setType(rs.getString("type"));
                     productManager.setQty(rs.getInt("qty"));
                     productManager.setPrice(rs.getString("price"));
                     productManager.setTotal(rs.getString("total"));
                     productManager.setDescription(rs.getString("description"));

                     productList.add(productManager);
                 }
                 rs.close();
                 stmt.close();
                 return productList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }

    
    public ProductManagement getProduct(String product_id) {
        try {
           ProductManagement productManager = new ProductManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT * FROM e_product WHERE e_product_id ='" + product_id + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                   
                     productManager.setE_product_id(rs.getString("e_product_id"));
                     productManager.setE_product_sales_id(rs.getString("e_product_sales_id"));
                     productManager.setE_partner_id(rs.getString("e_partner_id"));
                     productManager.setCreated(rs.getTimestamp("created"));
                     productManager.setUpdated(rs.getTimestamp("updated"));
                     productManager.setIsActive(rs.getBoolean("isactive"));
                     productManager.setName(rs.getString("name"));
                     productManager.setCode(rs.getInt("code"));
                     productManager.setCode_additional(rs.getInt("code_additional"));
                     productManager.setType(rs.getString("type"));
                     productManager.setQty(rs.getInt("qty"));
                     productManager.setPrice(rs.getString("price"));
                     productManager.setTotal(rs.getString("total"));
                     productManager.setDescription(rs.getString("description"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return productManager;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
    public ProductManagement returnCodeProduct() {
       try {
           ProductManagement productManager = new ProductManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT code FROM e_product ORDER BY code DESC LIMIT 1");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     productManager.setCode(rs.getInt("code"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return productManager;
                 
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
    public void saveProd(String e_partner_id, Timestamp updated, boolean isactive, String name, int code_additional, String type,
            int qty, String price, String total, String description, String e_product_id) {
             try {        
                 String sql = "UPDATE e_product SET e_partner_id=?, "
                         + "updated=?, isactive=?, name=?, code_additional=?, type=?, qty=?, price=?, total=?, description=?"
                         + " WHERE e_product_id ='" + e_product_id + "'";
                      PreparedStatement stmt = connection.prepareStatement(sql);
                      if(e_partner_id != null && !e_partner_id.equals("")) {
                          stmt.setString(1, e_partner_id);
                      } else {
                            stmt.setString(1, null);
                      }
                            stmt.setTimestamp(2, updated);
                            stmt.setBoolean(3, isactive);
                            stmt.setString(4, name);
                            stmt.setInt(5, code_additional);
                            stmt.setString(6, type);
                            stmt.setInt(7, qty);
                            stmt.setString(8, price);
                            stmt.setString(9, total);
                            stmt.setString(10, description);
                stmt.executeUpdate();
                stmt.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    
    public void addProductPriceSales(String productSalesId, String product_id) {
        try {
            String sql = "UPDATE e_product SET e_product_sales_id=? WHERE e_product_id='" + product_id + "'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, productSalesId);
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void removeProduct(String id) {
             try {
                 String sql = "DELETE FROM e_product WHERE e_product_id=?";
                 PreparedStatement stmt = connection.prepareStatement(sql);
                 
                 stmt.setString(1, id);
                 
                 stmt.executeUpdate();
                 stmt.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
}

