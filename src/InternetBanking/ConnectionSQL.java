
package InternetBanking;

import java.sql.*;

public class ConnectionSQL {
    Connection connection;
    Statement statement;
    ConnectionSQL() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql:///InternetBanking", "root", "kumar");
            statement = connection.createStatement();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
