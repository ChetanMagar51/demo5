package com.example.services;

import com.example.dao.UserAccountDAO;
import com.example.models.UserAccount;

import java.sql.SQLException;
import java.util.List;

public class UserAccountService {

    private UserAccountDAO userAccountDAO;

    public UserAccountService() {
        userAccountDAO = new UserAccountDAO();
    }

    // Add a new user account with validation logic
    public void addUserAccount(UserAccount userAccount) throws SQLException {
        if (isValidUserAccount(userAccount)) {
            userAccountDAO.addUserAccount(userAccount);
        } else {
            throw new IllegalArgumentException("Invalid user account data");
        }
    }

    // Get a user account by username
    public UserAccount getUserAccountByUsername(String username) throws SQLException {
        return userAccountDAO.getUserAccountByUsername(username);
    }

    // Update a user account with validation logic
    public void updateUserAccount(UserAccount userAccount) throws SQLException {
        if (isValidUserAccount(userAccount)) {
            userAccountDAO.updateUserAccount(userAccount);
        } else {
            throw new IllegalArgumentException("Invalid user account data");
        }
    }

    // Delete a user account by username
    public void deleteUserAccount(String username) throws SQLException {
        userAccountDAO.deleteUserAccount(username);
    }

    // Get all user accounts
    public List<UserAccount> getAllUserAccounts() throws SQLException {
        return userAccountDAO.getAllUserAccounts();
    }

    // Validation logic for user account data
    private boolean isValidUserAccount(UserAccount userAccount) {
        return userAccount.getUsername() != null && !userAccount.getUsername().isEmpty() &&
               userAccount.getPassword() != null && !userAccount.getPassword().isEmpty();
    }
}
