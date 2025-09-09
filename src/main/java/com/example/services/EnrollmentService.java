package com.example.services;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.EnrollmentDAO;
import com.example.models.Enrollment;

public class EnrollmentService {

    private EnrollmentDAO enrollmentDAO;

    public EnrollmentService() {
        enrollmentDAO = new EnrollmentDAO();
    }

    // Add a new enrollment with validation logic
    public void addEnrollment(Enrollment enrollment) throws SQLException {
        if (isValidEnrollment(enrollment)) {
            enrollmentDAO.addEnrollment(enrollment);
        } else {
            throw new IllegalArgumentException("Invalid enrollment data");
        }
    }

    // Get an enrollment by ID
    public Enrollment getEnrollmentById(int enrollmentId) throws SQLException {
        return enrollmentDAO.getEnrollmentById(enrollmentId);
    }

    // Update an enrollment with validation logic
    public void updateEnrollment(Enrollment enrollment) throws SQLException {
        if (isValidEnrollment(enrollment)) {
            enrollmentDAO.updateEnrollment(enrollment);
        } else {
            throw new IllegalArgumentException("Invalid enrollment data");
        }
    }

    // Delete an enrollment by ID
    public void deleteEnrollment(int enrollmentId) throws SQLException {
        enrollmentDAO.deleteEnrollment(enrollmentId);
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() throws SQLException {
        return enrollmentDAO.getAllEnrollments();
    }

    // Validation logic for enrollment data
    private boolean isValidEnrollment(Enrollment enrollment) {
        return enrollment.getStudentId() > 0 && 
               enrollment.getCourseId() > 0 &&
               enrollment.getEnrollmentDate() != null;
    }
}
