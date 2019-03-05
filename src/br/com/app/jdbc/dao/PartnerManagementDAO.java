package br.com.app.jdbc.dao;

import br.com.app.model.PartnerManagement;
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
public class PartnerManagementDAO {
    
    private Connection connection;
    
    public PartnerManagementDAO() {
         this.connection = new ConnectionFactory().getConnection();
    }
        
    public void addPartner(PartnerManagement partner) {
        try {
            String sql = "INSERT INTO e_partner (e_partner_id, name, address, phone1, phone2, email, cnpj, description, socialnetwork)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, partner.getE_partner_id());
            stmt.setString(2, partner.getName());
            stmt.setString(3, partner.getAddress());
            stmt.setString(4, partner.getPhone1());
            stmt.setString(5, partner.getPhone2());
            stmt.setString(6, partner.getEmail());
            stmt.setString(7, partner.getCnpj());
            stmt.setString(8, partner.getDescription());
            stmt.setString(9, partner.getSocialNetwork());             
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PartnerManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void addParcialPartner(PartnerManagement partner) {
        try {
            String sql = "INSERT INTO e_partner (e_partner_id)"
                    + "VALUES(?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, partner.getE_partner_id());       
           
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PartnerManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<PartnerManagement>getListPartner() {
        try {
           List<PartnerManagement> partnerList = new ArrayList<PartnerManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_partner");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     PartnerManagement partnerManager = new PartnerManagement();
                     partnerManager.setE_partner_id(rs.getString("e_partner_id"));
                     partnerManager.setName(rs.getString("name"));
                     partnerManager.setAddress(rs.getString("address"));
                     partnerManager.setPhone1(rs.getString("phone1"));
                     partnerManager.setPhone2(rs.getString("phone2"));
                     partnerManager.setEmail(rs.getString("email"));
                     partnerManager.setCnpj(rs.getString("cnpj"));
                     partnerManager.setDescription(rs.getString("description"));
                     partnerManager.setSocialNetwork(rs.getString("socialnetwork"));

                     partnerList.add(partnerManager);
                 }
                 rs.close();
                 stmt.close();
                 return partnerList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
        
    public PartnerManagement getPartner(String partner_id) {
        try {
           PartnerManagement partnerManager = new PartnerManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT * FROM e_partner WHERE e_partner_id ='" + partner_id + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     
                     partnerManager.setE_partner_id(rs.getString("e_partner_id"));
                     partnerManager.setName(rs.getString("name"));
                     partnerManager.setAddress(rs.getString("address"));
                     partnerManager.setPhone1(rs.getString("phone1"));
                     partnerManager.setPhone2(rs.getString("phone2"));
                     partnerManager.setEmail(rs.getString("email"));
                     partnerManager.setCnpj(rs.getString("cnpj"));
                     partnerManager.setDescription(rs.getString("description"));
                     partnerManager.setSocialNetwork(rs.getString("socialnetwork"));
                 }
                 rs.close();
                 stmt.close();
                 return partnerManager;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
    public void removePartner(String e_partner_id) {
        try {
            String sql = "DELETE FROM e_partner WHERE e_partner_id=?";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, e_partner_id);
            
            stmt.executeUpdate();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PartnerManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
