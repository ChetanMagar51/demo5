<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Student Management System</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="Login" >
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
            <p class="error">${errorMessage}</p>
        </form>
    </div>
</body>
</html>
