package com.example.utils;
import com.example.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Get a connection
            connection = DatabaseConnection.getConnection();

            // Example query
            String sql = "SELECT * FROM Students";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                System.out.println("Student ID: " + resultSet.getInt("student_id"));
                System.out.println("First Name: " + resultSet.getString("first_name"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                // Add other fields as necessary
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            DatabaseConnection.closeConnection(connection);
        }
    }
}
