package com.example.services;

import com.example.dao.UserRoleDAO;
import com.example.models.UserRole;

import java.sql.SQLException;
import java.util.List;

public class UserRoleService {

    private UserRoleDAO userRoleDAO;

    public UserRoleService() {
        userRoleDAO = new UserRoleDAO();
    }

    // Add a new user role with validation logic
    public void addUserRole(UserRole userRole) throws SQLException {
        if (isValidUserRole(userRole)) {
            userRoleDAO.addUserRole(userRole);
        } else {
            throw new IllegalArgumentException("Invalid user role data");
        }
    }

    // Get a user role by ID
    public UserRole getUserRoleById(int roleId) throws SQLException {
        return userRoleDAO.getUserRoleById(roleId);
    }

    // Update a user role with validation logic
    public void updateUserRole(UserRole userRole) throws SQLException {
        if (isValidUserRole(userRole)) {
            userRoleDAO.updateUserRole(userRole);
        } else {
            throw new IllegalArgumentException("Invalid user role data");
        }
    }

    // Delete a user role by ID
    public void deleteUserRole(int roleId) throws SQLException {
        userRoleDAO.deleteUserRole(roleId);
    }

    // Get all user roles
    public List<UserRole> getAllUserRoles() throws SQLException {
        return userRoleDAO.getAllUserRoles();
    }

    // Validation logic for user role data
    private boolean isValidUserRole(UserRole userRole) {
        return userRole.getRoleName() != null && !userRole.getRoleName().isEmpty();
    }
}
