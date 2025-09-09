<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Portal</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <%@ include file="includes/navigation.jsp" %>
    <div class="portal-container">
        <h2>Student Portal</h2>
        <div class="section">
            <h3>My Courses</h3>
            <table>
                <thead>
                    <tr>
                        <th>Course ID</th>
                        <th>Course Name</th>
                        <th>Credits</th>
                        <th>Grade</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="course" items="${courses}">
                        <tr>
                            <td>${course.courseId}</td>
                            <td>${course.courseName}</td>
                            <td>${course.credits}</td>
                            <td>${course.grade}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="section">
            <h3>Academic Progress</h3>
            <!-- Insert charts or progress bars here -->
        </div>
    </div>
    <%@ include file="includes/footer.jsp" %>
    <script src="js/script.js"></script>
</body>
</html>
