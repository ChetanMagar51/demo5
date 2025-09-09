package com.example.services;

import com.example.dao.TeacherDAO;
import com.example.models.Teacher;

import java.sql.SQLException;
import java.util.List;

public class TeacherService {

    private TeacherDAO teacherDAO;

    public TeacherService() {
        teacherDAO = new TeacherDAO();
    }

    // Add a new teacher with validation logic
    public void addTeacher(Teacher teacher) throws SQLException {
        if (isValidTeacher(teacher)) {
            teacherDAO.addTeacher(teacher);
        } else {
            throw new IllegalArgumentException("Invalid teacher data");
        }
    }

    // Get a teacher by ID
    public Teacher getTeacherById(int teacherId) throws SQLException {
        return teacherDAO.getTeacherById(teacherId);
    }

    // Update a teacher with validation logic
    public void updateTeacher(Teacher teacher) throws SQLException {
        if (isValidTeacher(teacher)) {
            teacherDAO.updateTeacher(teacher);
        } else {
            throw new IllegalArgumentException("Invalid teacher data");
        }
    }

    // Delete a teacher by ID
    public void deleteTeacher(int teacherId) throws SQLException {
        teacherDAO.deleteTeacher(teacherId);
    }

    // Get all teachers
    public List<Teacher> getAllTeachers() throws SQLException {
        return teacherDAO.getAllTeachers();
    }

    // Validation logic for teacher data
    private boolean isValidTeacher(Teacher teacher) {
        return teacher.getFirstName() != null && !teacher.getFirstName().isEmpty() &&
               teacher.getLastName() != null && !teacher.getLastName().isEmpty() &&
               teacher.getEmail() != null && !teacher.getEmail().isEmpty();
    }
}
