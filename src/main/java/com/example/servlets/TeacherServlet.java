package com.example.servlets;

import com.example.models.Course;
import com.example.services.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {

    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Course> courses = courseService.getAllCourses();  // Assuming this gets courses for the teacher
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("teacherDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addGrade".equals(action)) {
            addGrade(request, response);
        } else if ("uploadMaterial".equals(action)) {
            uploadMaterial(request, response);
        }
    }

    private void addGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implement grade addition logic here
    }

    private void uploadMaterial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implement material upload logic here
    }
}
