<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teacher Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <%@ include file="includes/navigation.jsp" %>
    <div class="dashboard-container">
        <h2>Teacher Dashboard</h2>
        <div class="section">
            <h3>Assigned Courses</h3>
            <table>
                <thead>
                    <tr>
                        <th>Course ID</th>
                        <th>Course Name</th>
                        <th>Credits</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="course" items="${courses}">
                        <tr>
                            <td>${course.courseId}</td>
                            <td>${course.courseName}</td>
                            <td>${course.credits}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="section">
            <h3>Manage Grades</h3>
            <table>
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Student Name</th>
                        <th>Course ID</th>
                        <th>Grade</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="grade" items="${grades}">
                        <tr>
                            <td>${grade.studentId}</td>
                            <td>${grade.studentName}</td>
                            <td>${grade.courseId}</td>
                            <td>${grade.grade}</td>
                            <td>
                                <form action="teacher" method="post">
                                    <input type="hidden" name="action" value="updateGrade">
                                    <input type="hidden" name="studentId" value="${grade.studentId}">
                                    <input type="hidden" name="courseId" value="${grade.courseId}">
                                    <input type="text" name="grade" value="${grade.grade}">
                                    <button type="submit">Update</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%@ include file="includes/footer.jsp" %>
    <script src="js/script.js"></script>
    <script src="js/teacherDashboard.js"></script>
<script src="js/common.js"></script>
</body>
</html>
