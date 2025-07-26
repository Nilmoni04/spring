<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="calculator">
        <p>Welcome to your first Spring MVC application!</p>
        <h2>Student Table</h2>
        <form action="/addStudent" method="post">
            <label>Enter Student Name:</label>
            <input type="text" name="name" required><br><br>

            <label>Enter Roll Number:</label>
            <input type="text" name="roll" required><br><br>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
