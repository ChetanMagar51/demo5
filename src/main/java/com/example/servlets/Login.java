package com.example.servlets;

import com.example.models.UserAccount;
import com.example.services.UserAccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("serial")
@WebServlet("/Login")
public class Login extends HttpServlet {

    private UserAccountService userAccountService;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            UserAccount userAccount = userAccountService.getUserAccountByUsername(username);
            if (userAccount != null && userAccount.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", userAccount);
                // Redirect to dashboard based on role
                switch (userAccount.getRoleId()) {
                    case 1:
                        response.sendRedirect("adminDashboard.jsp");
                        break;
                    case 2:
                        response.sendRedirect("teacherDashboard.jsp");
                        break;
                    case 3:
                        response.sendRedirect("studentDashboard.jsp");
                        break;
                    default:
                        response.sendRedirect("login.jsp");
                        break;
                }
            } else {
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
	