package com.example.dao;

import com.example.models.Course;
import com.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    // Add a new course
    public void addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO Courses (course_id, course_name, course_description, credits) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            statement.setString(3, course.getCourseDescription());
            statement.setInt(4, course.getCredits());
            statement.executeUpdate();
        }
    }

    // Get a course by ID
    public Course getCourseById(int courseId) throws SQLException {
        String sql = "SELECT * FROM Courses WHERE course_id = ?";
        Course course = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, courseId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                course = new Course();
                course.setCourseId(resultSet.getInt("course_id"));
                course.setCourseName(resultSet.getString("course_name"));
                course.setCourseDescription(resultSet.getString("course_description"));
                course.setCredits(resultSet.getInt("credits"));
            }
        }
        return course;
    }

    // Update a course
    public void updateCourse(Course course) throws SQLException {
        String sql = "UPDATE Courses SET course_name = ?, course_description = ?, credits = ? WHERE course_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, course.getCourseName());
            statement.setString(2, course.getCourseDescription());
            statement.setInt(3, course.getCredits());
            statement.setInt(4, course.getCourseId());
            statement.executeUpdate();
        }
    }

    // Delete a course by ID
    public void deleteCourse(int courseId) throws SQLException {
        String sql = "DELETE FROM Courses WHERE course_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, courseId);
            statement.executeUpdate();
        }
    }

    // Get all courses
    public List<Course> getAllCourses() throws SQLException {
        String sql = "SELECT * FROM Courses";
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("course_id"));
                course.setCourseName(resultSet.getString("course_name"));
                course.setCourseDescription(resultSet.getString("course_description"));
                course.setCredits(resultSet.getInt("credits"));
                courses.add(course);
            }
        }
        return courses;
    }
}
