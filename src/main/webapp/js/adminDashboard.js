// adminDashboard.js

// Function to display the update student form
function showUpdateForm(studentId) {
    document.getElementById("updateStudentId").value = studentId;
    document.getElementById("updateStudentForm").style.display = "block";
}

// Function to close the update student form
function closeUpdateForm() {
    document.getElementById("updateStudentForm").style.display = "none";
}

// Function to handle the delete student action
function deleteStudent(studentId) {
    if (confirmDelete(studentId, 'student')) {
        document.getElementById(`deleteStudentForm${studentId}`).submit();
    }
}

// Function to dynamically update the list of courses in the dashboard
function refreshCourseList() {
    ajaxRequest('/admin/courses', 'GET', {}, function(courses) {
        const courseTable = document.getElementById('courseTableBody');
        courseTable.innerHTML = '';
        courses.forEach(course => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.credits}</td>
                <td>
                    <button onclick="editCourse(${course.courseId})">Edit</button>
                    <button onclick="deleteCourse(${course.courseId})">Delete</button>
                </td>
            `;
            courseTable.appendChild(row);
        });
    });
}
