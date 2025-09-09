// courseManagement.js

// Function to add a new course
function addCourse() {
    const courseName = document.getElementById('courseName').value;
    const credits = document.getElementById('credits').value;
    ajaxRequest('/admin/addCourse', 'POST', {
        courseName: courseName,
        credits: credits
    }, function(response) {
        if (response.success) {
            alert('Course added successfully');
            refreshCourseList();
        } else {
            alert('Failed to add course');
        }
    });
}

// Function to update an existing course
function updateCourse(courseId) {
    const courseName = document.getElementById('updateCourseName').value;
    const credits = document.getElementById('updateCredits').value;
    ajaxRequest('/admin/updateCourse', 'POST', {
        courseId: courseId,
        courseName: courseName,
        credits: credits
    }, function(response) {
        if (response.success) {
            alert('Course updated successfully');
            refreshCourseList();
        } else {
            alert('Failed to update course');
        }
    });
}

// Function to delete a course
function deleteCourse(courseId) {
    if (confirmDelete(courseId, 'course')) {
        ajaxRequest('/admin/deleteCourse', 'POST', {
            courseId: courseId
        }, function(response) {
            if (response.success) {
                alert('Course deleted successfully');
                refreshCourseList();
            } else {
                alert('Failed to delete course');
            }
        });
    }
}
