package assignment.model;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionHelper {
    public static Connection ketnoi() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Aptech_fpt";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.err.printf(ex.getMessage());
        } catch (SQLException ex) {
            System.err.printf("Can't connection ");
        }


        return connection;
    }

}
