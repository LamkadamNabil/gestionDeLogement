package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public static Connection getDBConnection() throws SQLException {


           String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
           String DB_CONNECTION = "jdbc:mysql://localhost:3306/logementDB";
           String DB_USER = "root";
           String DB_PASSWORD = "";

        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException exception) {
           exception.printStackTrace();
        }

        return connection;
    }

}
