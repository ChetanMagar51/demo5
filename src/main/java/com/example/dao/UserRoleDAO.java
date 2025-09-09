package com.example.dao;

import com.example.models.UserRole;
import com.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDAO {

    // Add a new user role
    public void addUserRole(UserRole userRole) throws SQLException {
        String sql = "INSERT INTO UserRoles (role_id, role_name) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userRole.getRoleId());
            statement.setString(2, userRole.getRoleName());
            statement.executeUpdate();
        }
    }

    // Get a user role by ID
    public UserRole getUserRoleById(int roleId) throws SQLException {
        String sql = "SELECT * FROM UserRoles WHERE role_id = ?";
        UserRole userRole = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roleId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userRole = new UserRole();
                userRole.setRoleId(resultSet.getInt("role_id"));
                userRole.setRoleName(resultSet.getString("role_name"));
            }
        }
        return userRole;
    }

    // Update a user role
    public void updateUserRole(UserRole userRole) throws SQLException {
        String sql = "UPDATE UserRoles SET role_name = ? WHERE role_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userRole.getRoleName());
            statement.setInt(2, userRole.getRoleId());
            statement.executeUpdate();
        }
    }

    // Delete a user role by ID
    public void deleteUserRole(int roleId) throws SQLException {
        String sql = "DELETE FROM UserRoles WHERE role_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, roleId);
            statement.executeUpdate();
        }
    }

    // Get all user roles
    public List<UserRole> getAllUserRoles() throws SQLException {
        String sql = "SELECT * FROM UserRoles";
        List<UserRole> userRoles = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(resultSet.getInt("role_id"));
                userRole.setRoleName(resultSet.getString("role_name"));
                userRoles.add(userRole);
            }
        }
        return userRoles;
    }
}
