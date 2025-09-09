package com.example.services;

import com.example.dao.CourseDAO;
import com.example.models.Course;

import java.sql.SQLException;
import java.util.List;

public class CourseService {

    private CourseDAO courseDAO;

    public CourseService() {
        courseDAO = new CourseDAO();
    }

    // Add a new course with validation logic
    public void addCourse(Course course) throws SQLException {
        if (isValidCourse(course)) {
            courseDAO.addCourse(course);
        } else {
            throw new IllegalArgumentException("Invalid course data");
        }
    }

    // Get a course by ID
    public Course getCourseById(int courseId) throws SQLException {
        return courseDAO.getCourseById(courseId);
    }

    // Update a course with validation logic
    public void updateCourse(Course course) throws SQLException {
        if (isValidCourse(course)) {
            courseDAO.updateCourse(course);
        } else {
            throw new IllegalArgumentException("Invalid course data");
        }
    }

    // Delete a course by ID
    public void deleteCourse(int courseId) throws SQLException {
        courseDAO.deleteCourse(courseId);
    }

    // Get all courses
    public List<Course> getAllCourses() throws SQLException {
        return courseDAO.getAllCourses();
    }

    // Validation logic for course data
    private boolean isValidCourse(Course course) {
        return course.getCourseName() != null && !course.getCourseName().isEmpty() &&
               course.getCredits() > 0;
    }
}
