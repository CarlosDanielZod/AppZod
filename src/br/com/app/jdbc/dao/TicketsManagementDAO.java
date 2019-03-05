package br.com.app.jdbc.dao;

import br.com.app.model.TicketsManagement;
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
public class TicketsManagementDAO {
    
    private Connection connection;
    
    public TicketsManagementDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
     public void addTicket(TicketsManagement ticket) {
        try {
            String sql = "INSERT INTO e_ticket (e_ticket_id, e_client_id, ticket, code_client,"
                    + " name_client, address, rg, cpf, phone1, phone2, email, description_client)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, ticket.getE_ticket_id());
            stmt.setString(2, ticket.getE_client_id());
            stmt.setInt(3, ticket.getTicket());
            stmt.setInt(4, ticket.getCode_client());
            stmt.setString(5, ticket.getName_client());
            stmt.setString(6, ticket.getAddress());
            stmt.setString(7, ticket.getRg());
            stmt.setString(8, ticket.getCpf());
            stmt.setString(9, ticket.getPhone1());
            stmt.setString(10, ticket.getPhone2());
            stmt.setString(11, ticket.getEmail());
            stmt.setString(12, ticket.getDescription_client());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TicketsManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void addParcialTicket(TicketsManagement ticket) {
        try {
            String sql = "INSERT INTO e_ticket (e_ticket_id, e_client_id, ticket, code_client, name_client)"
                    + " VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, ticket.getE_ticket_id());
            stmt.setString(2, ticket.getE_client_id());
            stmt.setInt(3, ticket.getTicket());
            stmt.setInt(4, ticket.getCode_client());
            stmt.setString(5, ticket.getName_client());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TicketsManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public TicketsManagement returnCodeTicket() {
       try {
           TicketsManagement ticketManager = new TicketsManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT ticket FROM e_ticket ORDER BY ticket DESC LIMIT 1");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     ticketManager.setTicket(rs.getInt("ticket"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return ticketManager;
                 
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
    public TicketsManagement getTicketByClient(String clientId) {
        try {
           TicketsManagement ticketManager = new TicketsManagement();
                 PreparedStatement stmt = this.connection.
                prepareStatement("SELECT * FROM e_ticket WHERE e_client_id='" + clientId + "'");
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()) {
                     ticketManager.setE_client_id(rs.getString("e_client_id"));
                     ticketManager.setE_ticket_id(rs.getString("e_ticket_id"));
                     ticketManager.setCreated(rs.getTimestamp("created"));
                     ticketManager.setUpdated(rs.getTimestamp("updated"));
                     ticketManager.setTicket(rs.getInt("ticket"));
                     ticketManager.setCode_client(rs.getInt("code_client"));
                     ticketManager.setName_client(rs.getString("name_client"));
                     ticketManager.setAddress(rs.getString("address"));
                     ticketManager.setRg(rs.getString("rg"));
                     ticketManager.setCpf(rs.getString("cpf"));
                     ticketManager.setPhone1(rs.getString("phone1"));
                     ticketManager.setPhone2(rs.getString("phone2"));
                     ticketManager.setEmail(rs.getString("email"));
                     ticketManager.setDescription_client(rs.getString("description_client"));
                 }
                 
                 rs.close();
                 stmt.close();
                 return ticketManager;
                 
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
        
         public List<TicketsManagement>getListTicket() {
        try {
           List<TicketsManagement> ticketList = new ArrayList<TicketsManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_ticket");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     TicketsManagement ticketManager = new TicketsManagement();
                     ticketManager.setE_client_id(rs.getString("e_client_id"));
                     ticketManager.setE_ticket_id(rs.getString("e_ticket_id"));
                     ticketManager.setCreated(rs.getTimestamp("created"));
                     ticketManager.setUpdated(rs.getTimestamp("updated"));
                     ticketManager.setTicket(rs.getInt("ticket"));
                     ticketManager.setCode_client(rs.getInt("code_client"));
                     ticketManager.setName_client(rs.getString("name_client"));
                     ticketManager.setAddress(rs.getString("address"));
                     ticketManager.setRg(rs.getString("rg"));
                     ticketManager.setCpf(rs.getString("cpf"));
                     ticketManager.setPhone1(rs.getString("phone1"));
                     ticketManager.setPhone2(rs.getString("phone2"));
                     ticketManager.setEmail(rs.getString("email"));
                     ticketManager.setDescription_client(rs.getString("description_client"));

                      ticketList.add(ticketManager);
                 }
                 rs.close();
                 stmt.close();
                 return ticketList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
         
          public List<TicketsManagement> getFilterAllTicket(String filtroAll) {
           try {
           List<TicketsManagement> ticketList = new ArrayList<TicketsManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_ticket WHERE name_client"
                                 + " ILIKE '%" + filtroAll + "%' OR name_product ILIKE '%" + filtroAll + "%' OR cast(ticket as varchar(42)) LIKE '%" + filtroAll + "%'");

                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     TicketsManagement ticketManager = new TicketsManagement();
                   ticketManager.setE_client_id(rs.getString("e_client_id"));
                     ticketManager.setE_ticket_id(rs.getString("e_ticket_id"));
                     ticketManager.setCreated(rs.getTimestamp("created"));
                     ticketManager.setUpdated(rs.getTimestamp("updated"));
                     ticketManager.setTicket(rs.getInt("ticket"));
                     ticketManager.setCode_client(rs.getInt("code_client"));
                     ticketManager.setName_client(rs.getString("name_client"));
                     ticketManager.setAddress(rs.getString("address"));
                     ticketManager.setRg(rs.getString("rg"));
                     ticketManager.setCpf(rs.getString("cpf"));
                     ticketManager.setPhone1(rs.getString("phone1"));
                     ticketManager.setPhone2(rs.getString("phone2"));
                     ticketManager.setEmail(rs.getString("email"));
                     ticketManager.setDescription_client(rs.getString("description_client"));

                     ticketList.add(ticketManager);
                 }
                 rs.close();
                 stmt.close();
                 return ticketList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
          
           public List<TicketsManagement> getFilterNameTicket(String filtroAll, String key) {
           try {
           List<TicketsManagement> ticketList = new ArrayList<TicketsManagement>();
           String filtroColuna = "";
                if(key != null && key.equals("filtroNome")) {
                    filtroColuna = "name_client";
                }
                else if(key != null && key.equals("filtroNomeProduto")) {
                    filtroColuna = "name_product";
                }
                
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_ticket WHERE " + filtroColuna
                                 + " ILIKE '%" + filtroAll + "%'");

                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     TicketsManagement ticketManager = new TicketsManagement();
                   ticketManager.setE_client_id(rs.getString("e_client_id"));
                     ticketManager.setE_ticket_id(rs.getString("e_ticket_id"));
                     ticketManager.setCreated(rs.getTimestamp("created"));
                     ticketManager.setUpdated(rs.getTimestamp("updated"));
                     ticketManager.setTicket(rs.getInt("ticket"));
                     ticketManager.setCode_client(rs.getInt("code_client"));
                     ticketManager.setName_client(rs.getString("name_client"));
                     ticketManager.setAddress(rs.getString("address"));
                     ticketManager.setRg(rs.getString("rg"));
                     ticketManager.setCpf(rs.getString("cpf"));
                     ticketManager.setPhone1(rs.getString("phone1"));
                     ticketManager.setPhone2(rs.getString("phone2"));
                     ticketManager.setEmail(rs.getString("email"));
                     ticketManager.setDescription_client(rs.getString("description_client"));

                     ticketList.add(ticketManager);
                 }
                 rs.close();
                 stmt.close();
                 return ticketList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
          
            public List<TicketsManagement> getFilterActivesProd(boolean isactive) {
           try {
           List<TicketsManagement> productList = new ArrayList<TicketsManagement>();
                 PreparedStatement stmt = this.connection.
                         prepareStatement("SELECT * FROM e_ticket WHERE isactive='" + isactive + "'");
                 ResultSet rs = stmt.executeQuery();

                 while (rs.next()) {
                     // criando o objeto Contato
                     TicketsManagement ticketManager = new TicketsManagement();
                     ticketManager.setE_client_id(rs.getString("e_client_id"));
                     ticketManager.setE_ticket_id(rs.getString("e_ticket_id"));
                     ticketManager.setCreated(rs.getTimestamp("created"));
                     ticketManager.setUpdated(rs.getTimestamp("updated"));
                     ticketManager.setTicket(rs.getInt("ticket"));
                     ticketManager.setCode_client(rs.getInt("code_client"));
                     ticketManager.setName_client(rs.getString("name_client"));
                     ticketManager.setAddress(rs.getString("address"));
                     ticketManager.setRg(rs.getString("rg"));
                     ticketManager.setCpf(rs.getString("cpf"));
                     ticketManager.setPhone1(rs.getString("phone1"));
                     ticketManager.setPhone2(rs.getString("phone2"));
                     ticketManager.setEmail(rs.getString("email"));
                     ticketManager.setDescription_client(rs.getString("description_client"));

                     productList.add(ticketManager);
                 }
                 rs.close();
                 stmt.close();
                 return productList;
            } catch (SQLException e) {
                 throw new RuntimeException(e);
              }
    }
    
       public void saveTicket(String nameClient, String address, String rg, String cpf, String phone1, String phone2,
               String email, String descriptionClient, String ticketId) {
        try {
            String sql = "UPDATE e_ticket SET name_client=?, address=?, rg=?, cpf=?, phone1=?, phone2=?, email=?,"
                    + " description_client=? WHERE e_ticket_id='" + ticketId + "'";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, nameClient);
             stmt.setString(2, address);
            stmt.setString(3, rg);
            stmt.setString(4, cpf);
            stmt.setString(5, phone1);
            stmt.setString(6, phone2);
            stmt.setString(7, email);
            stmt.setString(8, descriptionClient);
            
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(TicketsManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }
}
