package com.example.servlets;

import com.example.models.Enrollment;
import com.example.services.EnrollmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private EnrollmentService enrollmentService;

    @Override
    public void init() throws ServletException {
        enrollmentService = new EnrollmentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            List<Enrollment> enrollments = enrollmentService.getAllEnrollments();  // Assuming filtered by studentId
            request.setAttribute("enrollments", enrollments);
            request.getRequestDispatcher("studentDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("enrollCourse".equals(action)) {
            enrollCourse(request, response);
        }
    }

    private void enrollCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implement course enrollment logic here
    }
}
