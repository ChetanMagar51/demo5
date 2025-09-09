package com.example.dao;

import com.example.models.UserAccount;
import com.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO {

    // Add a new user account
    public void addUserAccount(UserAccount userAccount) throws SQLException {
        String sql = "INSERT INTO UserAccounts (username, password, role_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userAccount.getUsername());
            statement.setString(2, userAccount.getPassword());
            statement.setInt(3, userAccount.getRoleId());
            statement.executeUpdate();
        }
    }

    // Get a user account by username
    public UserAccount getUserAccountByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM UserAccounts WHERE username = ?";
        UserAccount userAccount = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userAccount = new UserAccount();
                userAccount.setUsername(resultSet.getString("username"));
                userAccount.setPassword(resultSet.getString("password"));
                userAccount.setRoleId(resultSet.getInt("role_id"));
            }
        }
        return userAccount;
    }

    // Update a user account
    public void updateUserAccount(UserAccount userAccount) throws SQLException {
        String sql = "UPDATE UserAccounts SET password = ?, role_id = ? WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userAccount.getPassword());
            statement.setInt(2, userAccount.getRoleId());
            statement.setString(3, userAccount.getUsername());
            statement.executeUpdate();
        }
    }

    // Delete a user account by username
    public void deleteUserAccount(String username) throws SQLException {
        String sql = "DELETE FROM UserAccounts WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.executeUpdate();
        }
    }

    // Get all user accounts
    public List<UserAccount> getAllUserAccounts() throws SQLException {
        String sql = "SELECT * FROM UserAccounts";
        List<UserAccount> userAccounts = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                UserAccount userAccount = new UserAccount();
                userAccount.setUsername(resultSet.getString("username"));
                userAccount.setPassword(resultSet.getString("password"));
                userAccount.setRoleId(resultSet.getInt("role_id"));
                userAccounts.add(userAccount);
            }
        }
        return userAccounts;
    }
}
