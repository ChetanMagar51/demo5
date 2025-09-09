package com.example.dao;

import com.example.models.Student;
import com.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Add a new student
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO Students (student_id, first_name, last_name, email, phone_number, date_of_birth, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getPhoneNumber());
            statement.setDate(6, new java.sql.Date(student.getDateOfBirth().getTime()));
            statement.setString(7, student.getAddress());
            statement.executeUpdate();
        }
    }

    // Get a student by ID
    public Student getStudentById(int studentId) throws SQLException {
        String sql = "SELECT * FROM Students WHERE student_id = ?";
        Student student = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setDateOfBirth(resultSet.getDate("date_of_birth"));
                student.setAddress(resultSet.getString("address"));
            }
        }
        return student;
    }

    // Update a student
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE Students SET first_name = ?, last_name = ?, email = ?, phone_number = ?, date_of_birth = ?, address = ? WHERE student_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getPhoneNumber());
            statement.setDate(5, new java.sql.Date(student.getDateOfBirth().getTime()));
            statement.setString(6, student.getAddress());
            statement.setInt(7, student.getStudentId());
            statement.executeUpdate();
        }
    }

    // Delete a student by ID
    public void deleteStudent(int studentId) throws SQLException {
        String sql = "DELETE FROM Students WHERE student_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            statement.executeUpdate();
        }
    }

    // Get all students
    public List<Student> getAllStudents() throws SQLException {
        String sql = "SELECT * FROM Students";
        List<Student> students = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setDateOfBirth(resultSet.getDate("date_of_birth"));
                student.setAddress(resultSet.getString("address"));
                students.add(student);
            }
        }
        return students;
    }
}
