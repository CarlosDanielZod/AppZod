package br.com.app.jdbc.dao;

import br.com.app.model.ClientManagement;
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
public class ClientManagementDAO {
    // a conexão com o banco de dados
         private Connection connection;

         public ClientManagementDAO() {
             this.connection = new ConnectionFactory().getConnection();
         }
         
         public void addClient(ClientManagement clientManager) {
         String sql = "INSERT INTO e_client " +
                "(e_client_id, e_product_id, updated, code, name, address, rg, cpf, phone1, phone2, email, description)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

     try {
         // prepared statement para inserção
         PreparedStatement stmt = connection.prepareStatement(sql);

         // seta os valores
         stmt.setString(1, clientManager.getE_client_id());
         stmt.setString(2, clientManager.getE_product_id());
         stmt.setTimestamp(3, clientManager.getUpdated());
         stmt.setInt(4, clientManager.getCode());
         stmt.setString(5, clientManager.getName());
         stmt.setString(6, clientManager.getAddress());
         stmt.setString(7, clientManager.getRg());
         stmt.setString(8, clientManager.getCpf());
         stmt.setString(9, clientManager.getPhone1());
         stmt.setString(10, clientManager.getPhone2());
         stmt.setString(11, clientManager.getEmail());
         stmt.setString(12, clientManager.getDescription());

         // executa
         stmt.execute();
         stmt.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
  }
         
    public void addClientParcial(ClientManagement client) {
        try {
            String sql = "INSERT INTO e_client (e_client_id, code) VALUES (?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, client.getE_client_id());
            stmt.setInt(2, client.getCode());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ClientManagement returnCodeClient() {
       try {
           ClientManagement clientManager = new ClientManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT code FROM e_client ORDER BY code DESC LIMIT 1");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     clientManager.setCode(rs.getInt("code"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return clientManager;
                 
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
         
    public List<ClientManagement> getListClients() {
             try {
                 List<ClientManagement> clientList = new ArrayList<ClientManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_client");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     ClientManagement clientManager = new ClientManagement();
                     clientManager.setE_client_id(rs.getString("e_client_id"));
                     clientManager.setE_product_id(rs.getString("e_product_id"));
                     clientManager.setCreated(rs.getTimestamp("created"));
                     clientManager.setUpdated(rs.getTimestamp("updated"));
                     clientManager.setCode(rs.getInt("code"));
                     clientManager.setName(rs.getString("name"));
                     clientManager.setAddress(rs.getString("address"));
                     clientManager.setRg(rs.getString("rg"));
                     clientManager.setCpf(rs.getString("cpf"));
                     clientManager.setPhone1(rs.getString("phone1"));
                     clientManager.setPhone2(rs.getString("phone2"));
                     clientManager.setEmail(rs.getString("email"));
                     clientManager.setDescription(rs.getString("description"));

                     // adicionando o objeto à lista
                     clientList.add(clientManager);
                 }
                 rs.close();
                 stmt.close();
                 return clientList;
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
    
    
    public List<ClientManagement> getClientEmails() {
           try {
                 List<ClientManagement> clientList = new ArrayList<ClientManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT code, email FROM e_client");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     ClientManagement clientManager = new ClientManagement();
                     clientManager.setCode(rs.getInt("code"));
                     clientManager.setEmail(rs.getString("email"));
                     clientList.add(clientManager);
                 }
                 rs.close();
                 stmt.close();
                 return clientList;
                 
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
    }
    
    public List<ClientManagement> getListDescClients() {
             try {
                 List<ClientManagement> clientList = new ArrayList<ClientManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_client ORDER BY code DESC");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     ClientManagement clientManager = new ClientManagement();
                     clientManager.setE_client_id(rs.getString("e_client_id"));
                     clientManager.setE_product_id(rs.getString("e_product_id"));
                     clientManager.setCreated(rs.getTimestamp("created"));
                     clientManager.setUpdated(rs.getTimestamp("updated"));
                     clientManager.setCode(rs.getInt("code"));
                     clientManager.setName(rs.getString("name"));
                     clientManager.setAddress(rs.getString("address"));
                     clientManager.setRg(rs.getString("rg"));
                     clientManager.setCpf(rs.getString("cpf"));
                     clientManager.setPhone1(rs.getString("phone1"));
                     clientManager.setPhone2(rs.getString("phone2"));
                     clientManager.setEmail(rs.getString("email"));
                     clientManager.setDescription(rs.getString("description"));

                     // adicionando o objeto à lista
                     clientList.add(clientManager);
                 }
                 rs.close();
                 stmt.close();
                 return clientList;
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
    
    public String  saveClient(String e_product_id, Timestamp updated, String name, String address,
            String rg, String cpf, String phone1, String phone2, String email, String description, String e_client_id) {
             try {        
                 String sql = "UPDATE e_client SET e_product_id=?, "
                         + "updated=?, name=?, address=?, rg=?, cpf=?, phone1=?, phone2=?, email=?,"
                         + " description=? WHERE e_client_id ='" + e_client_id + "'";
                 
                      PreparedStatement stmt = connection.prepareStatement(sql);
                      
                            stmt.setString(1, e_product_id);
                            stmt.setTimestamp(2, updated);
                            stmt.setString(3, name);
                            stmt.setString(4, address);
                            stmt.setString(5, rg);
                            stmt.setString(6, cpf);
                            stmt.setString(7, phone1);
                            stmt.setString(8, phone2);
                            stmt.setString(9, email);
                            stmt.setString(10, description);
                            
                stmt.executeUpdate();
                stmt.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
             return e_client_id;
    }
    
    public void removeClient(String id) {
             try {
                 String sql = "DELETE FROM e_client WHERE e_client_id=?";
                 PreparedStatement stmt = connection.prepareStatement(sql);
                 
                 stmt.setString(1, id);
                 
                 stmt.executeUpdate();
                 stmt.close();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ClientManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    
    public ClientManagement getProductInClient(String product_id) {
            try {
           ClientManagement clientManager = new ClientManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT e_client_id, e_product_id FROM e_client WHERE e_product_id ='" + product_id + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     clientManager.setE_client_id(rs.getString("e_client_id"));
                     clientManager.setE_product_id(rs.getString("e_product_id"));
                 }
                 rs.close();
                 stmt.close();
                 return clientManager;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
}
