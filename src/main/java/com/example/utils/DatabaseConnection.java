package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database URL, username and password should be configured here
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; //  database URL
    private static final String DB_USERNAME = "system"; //  Oracle DB username
    private static final String DB_PASSWORD = "system"; // Oracle DB password

    // Load the Oracle JDBC Driver
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load Oracle JDBC driver.");
            e.printStackTrace();
        }
    }

    // Get a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    // Close the connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close the database connection.");
                e.printStackTrace();
            }
        }
    }
}
