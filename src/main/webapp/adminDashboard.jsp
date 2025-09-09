<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <%@ include file="includes/navigation.jsp" %>
    <div class="dashboard-container">
        <h2>Admin Dashboard</h2>
        <div class="section">
            <h3>Manage Students</h3>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.studentId}</td>
                            <td>${student.firstName}</td>
                            <td>${student.lastName}</td>
                            <td>${student.email}</td>
                            <td>
                                <button onclick="showUpdateForm(${student.studentId})">Update</button>
                                <form action="admin" method="post" class="inline-form">
                                    <input type="hidden" name="action" value="deleteStudent">
                                    <input type="hidden" name="studentId" value="${student.studentId}">
                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="section">
            <h3>Add New Student</h3>
            <form action="admin" method="post">
                <input type="hidden" name="action" value="addStudent">
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" id="firstName" name="firstName" required>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" name="lastName" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <button type="submit">Add</button>
            </form>
        </div>
    </div>
    <script src="js/adminDashboard.js"></script>
<script src="js/common.js"></script>
    <%@ include file="includes/footer.jsp" %>
    <script src="js/script.js"></script>
</body>

</body>
</html>
