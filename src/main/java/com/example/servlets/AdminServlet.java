package com.example.servlets;

import com.example.models.Student;
import com.example.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Student> students = studentService.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addStudent".equals(action)) {
            addStudent(request, response);
        } else if ("updateStudent".equals(action)) {
            updateStudent(request, response);
        } else if ("deleteStudent".equals(action)) {
            deleteStudent(request, response);
        }
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);

        try {
            studentService.addStudent(student);
            response.sendRedirect("admin");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student student = new Student();
        student.setStudentId(studentId);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);

        try {
            studentService.updateStudent(student);
            response.sendRedirect("admin");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        try {
            studentService.deleteStudent(studentId);
            response.sendRedirect("admin");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
