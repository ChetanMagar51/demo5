package com.example.services;

import com.example.dao.StudentDAO;
import com.example.models.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    // Add a new student with validation logic
    public void addStudent(Student student) throws SQLException {
        if (isValidStudent(student)) {
            studentDAO.addStudent(student);
        } else {
            throw new IllegalArgumentException("Invalid student data");
        }
    }

    // Get a student by ID
    public Student getStudentById(int studentId) throws SQLException {
        return studentDAO.getStudentById(studentId);
    }

    // Update a student with validation logic
    public void updateStudent(Student student) throws SQLException {
        if (isValidStudent(student)) {
            studentDAO.updateStudent(student);
        } else {
            throw new IllegalArgumentException("Invalid student data");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int studentId) throws SQLException {
        studentDAO.deleteStudent(studentId);
    }

    // Get all students
    public List<Student> getAllStudents() throws SQLException {
        return studentDAO.getAllStudents();
    }

    // Validation logic for student data
    private boolean isValidStudent(Student student) {
        return student.getFirstName() != null && !student.getFirstName().isEmpty() &&
               student.getLastName() != null && !student.getLastName().isEmpty() &&
               student.getEmail() != null && !student.getEmail().isEmpty();
    }
}
