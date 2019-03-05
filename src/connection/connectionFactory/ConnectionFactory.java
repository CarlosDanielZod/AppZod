package connection.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public class ConnectionFactory {
    public Connection getConnection() {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                  return DriverManager.getConnection(
                          "jdbc:postgresql://localhost:5432/appzod", "postgres", "root");
              } catch (SQLException e) {
                  throw new RuntimeException(e);
              }
          }
}
