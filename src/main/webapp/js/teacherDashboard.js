// teacherDashboard.js

// Function to handle grade update
function updateGrade(studentId, courseId) {
    const grade = document.getElementById(`gradeInput${studentId}${courseId}`).value;
    ajaxRequest('/teacher/updateGrade', 'POST', {
        studentId: studentId,
        courseId: courseId,
        grade: grade
    }, function(response) {
        alert('Grade updated successfully');
    });
}

// Function to dynamically load the list of students for a particular course
function loadStudents(courseId) {
    ajaxRequest(`/teacher/students?courseId=${courseId}`, 'GET', {}, function(students) {
        const studentTable = document.getElementById('studentTableBody');
        studentTable.innerHTML = '';
        students.forEach(student => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${student.studentId}</td>
                <td>${student.studentName}</td>
                <td>
                    <input type="text" id="gradeInput${student.studentId}${courseId}" value="${student.grade}">
                    <button onclick="updateGrade(${student.studentId}, ${courseId})">Update</button>
                </td>
            `;
            studentTable.appendChild(row);
        });
    });
}
