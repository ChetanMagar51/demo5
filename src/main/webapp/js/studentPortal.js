// studentPortal.js

// Function to register for a course
function registerCourse(courseId) {
    ajaxRequest('/student/registerCourse', 'POST', {
        courseId: courseId
    }, function(response) {
        if (response.success) {
            alert('Successfully registered for the course');
            refreshEnrolledCourses();
        } else {
            alert('Failed to register for the course');
        }
    });
}

// Function to refresh the list of enrolled courses
function refreshEnrolledCourses() {
    ajaxRequest('/student/enrolledCourses', 'GET', {}, function(courses) {
        const courseTable = document.getElementById('enrolledCoursesTableBody');
        courseTable.innerHTML = '';
        courses.forEach(course => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.credits}</td>
                <td>${course.grade}</td>
            `;
            courseTable.appendChild(row);
        });
    });
}

// Function to request transcript
function requestTranscript() {
    ajaxRequest('/student/requestTranscript', 'POST', {}, function(response) {
        if (response.success) {
            alert('Transcript requested successfully');
        } else {
            alert('Failed to request transcript');
        }
    });
}
