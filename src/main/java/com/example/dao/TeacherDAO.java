package com.example.dao;

import com.example.models.Teacher;
import com.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    // Add a new teacher
    public void addTeacher(Teacher teacher) throws SQLException {
        String sql = "INSERT INTO Teachers (teacher_id, first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, teacher.getTeacherId());
            statement.setString(2, teacher.getFirstName());
            statement.setString(3, teacher.getLastName());
            statement.setString(4, teacher.getEmail());
            statement.setString(5, teacher.getPhoneNumber());
            statement.executeUpdate();
        }
    }

    // Get a teacher by ID
    public Teacher getTeacherById(int teacherId) throws SQLException {
        String sql = "SELECT * FROM Teachers WHERE teacher_id = ?";
        Teacher teacher = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, teacherId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("teacher_id"));
                teacher.setFirstName(resultSet.getString("first_name"));
                teacher.setLastName(resultSet.getString("last_name"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setPhoneNumber(resultSet.getString("phone_number"));
            }
        }
        return teacher;
    }

    // Update a teacher
    public void updateTeacher(Teacher teacher) throws SQLException {
        String sql = "UPDATE Teachers SET first_name = ?, last_name = ?, email = ?, phone_number = ? WHERE teacher_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getEmail());
            statement.setString(4, teacher.getPhoneNumber());
            statement.setInt(5, teacher.getTeacherId());
            statement.executeUpdate();
        }
    }

    // Delete a teacher by ID
    public void deleteTeacher(int teacherId) throws SQLException {
        String sql = "DELETE FROM Teachers WHERE teacher_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, teacherId);
            statement.executeUpdate();
        }
    }

    // Get all teachers
    public List<Teacher> getAllTeachers() throws SQLException {
        String sql = "SELECT * FROM Teachers";
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("teacher_id"));
                teacher.setFirstName(resultSet.getString("first_name"));
                teacher.setLastName(resultSet.getString("last_name"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setPhoneNumber(resultSet.getString("phone_number"));
                teachers.add(teacher);
            }
        }
        return teachers;
    }
}
