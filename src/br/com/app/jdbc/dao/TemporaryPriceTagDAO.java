package br.com.app.jdbc.dao;

import br.com.app.model.TemporaryPriceTag;
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
public class TemporaryPriceTagDAO {
    
    private Connection connection;
    
    public TemporaryPriceTagDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void addPriceTag(TemporaryPriceTag priceTag) {
         String sql = "INSERT INTO temporary_pricetag " +
                "(code, name, type, salesprice)" +
                " values (?, ?, ?, ?)";

     try {
         PreparedStatement stmt = connection.prepareStatement(sql);

         stmt.setInt(1, priceTag.getCode());
         stmt.setString(2, priceTag.getName());
         stmt.setString(3, priceTag.getType());
         stmt.setString(4, priceTag.getSalesPrice());

         stmt.execute();
         stmt.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
  }
    
    public void updatePriceTag(String salesPrice, int code) {
             try {        
                String sql = "UPDATE temporary_pricetag SET salesprice=?"
                         + " WHERE code ='" + code + "'";
                 
                    PreparedStatement stmt = connection.prepareStatement(sql);
                      
                    stmt.setString(1, salesPrice);
                            
                stmt.executeUpdate();
                stmt.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    
    public TemporaryPriceTag getCodeProductPrint(int code) {
             try {
                     TemporaryPriceTag priceTag = new TemporaryPriceTag();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM temporary_pricetag WHERE code='" + code + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     priceTag.setCode(rs.getInt("code"));
                     priceTag.setName(rs.getString("name"));
                     priceTag.setType(rs.getString("type"));
                     priceTag.setSalesPrice(rs.getString("salesprice"));

                 }
                 
                 rs.close();
                 stmt.close();
                 return priceTag;
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
    }

