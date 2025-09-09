package com.example.dao;

import com.example.models.Enrollment;
import com.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    // Add a new enrollment
    public void addEnrollment(Enrollment enrollment) throws SQLException {
        String sql = "INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date, grade) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, enrollment.getEnrollmentId());
            statement.setInt(2, enrollment.getStudentId());
            statement.setInt(3, enrollment.getCourseId());
            statement.setDate(4, new java.sql.Date(enrollment.getEnrollmentDate().getTime()));
            statement.setString(5, enrollment.getGrade());
            statement.executeUpdate();
        }
    }

    // Get an enrollment by ID
    public Enrollment getEnrollmentById(int enrollmentId) throws SQLException {
        String sql = "SELECT * FROM Enrollments WHERE enrollment_id = ?";
        Enrollment enrollment = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, enrollmentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                enrollment = new Enrollment();
                enrollment.setEnrollmentId(resultSet.getInt("enrollment_id"));
                enrollment.setStudentId(resultSet.getInt("student_id"));
                enrollment.setCourseId(resultSet.getInt("course_id"));
                enrollment.setEnrollmentDate(resultSet.getDate("enrollment_date"));
                enrollment.setGrade(resultSet.getString("grade"));
            }
        }
        return enrollment;
    }

    // Update an enrollment
    public void updateEnrollment(Enrollment enrollment) throws SQLException {
        String sql = "UPDATE Enrollments SET student_id = ?, course_id = ?, enrollment_date = ?, grade = ? WHERE enrollment_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, enrollment.getStudentId());
            statement.setInt(2, enrollment.getCourseId());
            statement.setDate(3, new java.sql.Date(enrollment.getEnrollmentDate().getTime()));
            statement.setString(4, enrollment.getGrade());
            statement.setInt(5, enrollment.getEnrollmentId());
            statement.executeUpdate();
        }
    }

    // Delete an enrollment by ID
    public void deleteEnrollment(int enrollmentId) throws SQLException {
        String sql = "DELETE FROM Enrollments WHERE enrollment_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, enrollmentId);
            statement.executeUpdate();
        }
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() throws SQLException {
        String sql = "SELECT * FROM Enrollments";
        List<Enrollment> enrollments = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setEnrollmentId(resultSet.getInt("enrollment_id"));
                enrollment.setStudentId(resultSet.getInt("student_id"));
                enrollment.setCourseId(resultSet.getInt("course_id"));
                enrollment.setEnrollmentDate(resultSet.getDate("enrollment_date"));
                enrollment.setGrade(resultSet.getString("grade"));
                enrollments.add(enrollment);
            }
        }
        return enrollments;
    }
}
