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

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {

    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Course> courses = courseService.getAllCourses();
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("courseManagement.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addCourse".equals(action)) {
            addCourse(request, response);
        } else if ("updateCourse".equals(action)) {
            updateCourse(request, response);
        } else if ("deleteCourse".equals(action)) {
            deleteCourse(request, response);
        }
    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        int credits = Integer.parseInt(request.getParameter("credits"));

        Course course = new Course();
        course.setCourseName(courseName);
        course.setCredits(credits);

        try {
            courseService.addCourse(course);
            response.sendRedirect("courses");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String courseName = request.getParameter("courseName");
        int credits = Integer.parseInt(request.getParameter("credits"));

        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setCredits(credits);

        try {
            courseService.updateCourse(course);
            response.sendRedirect("courses");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        try {
            courseService.deleteCourse(courseId);
            response.sendRedirect("courses");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
