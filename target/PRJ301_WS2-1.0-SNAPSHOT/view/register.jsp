<%-- 
    Document   : register
    Created on : Mar 13, 2025, 10:38:58 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
    </head>
    <body>
        <h2>Register New Account</h2>
        <form action="../registrationServlet" method="post">
            <label>ID Number:</label>
            <input type="text" name="idNo" required>

            <label>First Name:</label>
            <input type="text" name="firstName" required>

            <label>Last Name:</label>
            <input type="text" name="lastName" required>

            <label>Phone Number:</label>
            <input type="text" name="phoneNo" required>

            <label>Email:</label>
            <input type="email" name="email" required>

            <label>Address:</label>
            <input type="text" name="address" required>

            <label>Initial Balance:</label>
            <input type="number" name="initialBalance" required min="100">

            <label>Username: </label>
            <input type="username" name="username" required>
            <p style="color: red; display:flex;">${message}</p>
            
            <label>Password:</label>
            <input type="password" name="password" required>

            <label>Upload Photo (Optional):</label>
            <input type="file" name="photo">

            <button type="submit">Register</button>
        </form>

        <p>Already have an account? <a href="/view/login.jsp">Login here</a></p>
    </body>
</html>

