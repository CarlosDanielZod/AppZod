package br.com.app.jdbc.dao;

import br.com.app.model.PaymentsManagement;
import connection.connectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public class PaymentsManagementDAO {
    
    private Connection connection;
    
    public PaymentsManagementDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void addPayments(PaymentsManagement payment) {
         String sql = "INSERT INTO e_payments " +
                "(e_payments_id, e_product_close_id, form_payment, sinal, total_payable, total_reimaning, date_delivery, ispaid)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, payment.getE_payments_id());
            stmt.setString(2, payment.getE_product_close_id());
            stmt.setString(3, payment.getForm_payment());
            stmt.setString(4, payment.getSinal());
            stmt.setString(5, payment.getTotal_payable());
            stmt.setString(6, payment.getTotal_reimaning());
            stmt.setString(7, payment.getDate_delivery());
            stmt.setBoolean(8, payment.getIsPaid());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
