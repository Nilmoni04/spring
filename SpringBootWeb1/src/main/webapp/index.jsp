<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="calculator">
        <p>Welcome to your first Spring MVC application!</p>
        <h2>Add Two Numbers</h2>
        <form action="/add" method="post">
            <label>Enter First Number:</label>
            <input type="number" name="num1" required><br><br>

            <label>Enter Second Number:</label>
            <input type="number" name="num2" required><br><br>

            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>
