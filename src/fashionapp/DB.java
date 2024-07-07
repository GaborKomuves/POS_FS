package fashionapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/pos";
    private static final String USER = "root";
    private static final String PASSWORD = "P@55w0rd!!";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection established successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to connect to the database.");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to close the database connection.");
            }
        }
    }

    public static void main(String[] args) {
        // Test the connection
        getConnection();
        // Close the connection
        closeConnection();
    }
}
