<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Management</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <%@ include file="includes/navigation.jsp" %>
    <div class="management-container">
        <h2>Course Management</h2>
        <div class="section">
            <h3>Add New Course</h3>
            <form action="admin" method="post">
                <input type="hidden" name="action" value="addCourse">
                <div class="form-group">
                    <label for="courseName">Course Name:</label>
                    <input type="text" id="courseName" name="courseName" required>
                </div>
                <div class="form-group">
                    <label for="credits">Credits:</label>
                    <input type="number" id="credits" name="credits" required>
                </div>
                <button type="submit">Add Course</button>
            </form>
        </div>

        <div class="section">
            <h3>Update Course</h3>
            <form action="admin" method="post">
                <input type="hidden" name="action" value="updateCourse">
                <div class="form-group">
                    <label for="courseId">Course ID:</label>
                    <input type="text" id="courseId" name="courseId" required>
                </div>
                <div class="form-group">
                    <label for="courseName">Course Name:</label>
                    <input type="text" id="courseName" name="courseName" required>
                </div>
                <div class="form-group">
                    <label for="credits">Credits:</label>
                    <input type="number" id="credits" name="credits" required>
                </div>
                <button type="submit">Update Course</button>
            </form>
        </div>
    </div>
    <%@ include file="includes/footer.jsp" %>
    <script src="js/script.js"></script>
    <script src="js/courseManagement.js"></script>
<script src="js/common.js"></script>
</body>
</html>
