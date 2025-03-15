<%-- 
    Document   : register
    Created on : Mar 13, 2025, 10:38:58 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
    </head>
    <body>
        <h2>Register New Account</h2>
        <form action="<%= request.getContextPath()%>/registrationServlet" method="post">
            <label>ID Card:</label>
            <input type="text" name="idNo" required>
            <p style="color: red; display:flex;">${message1}</p>

            <label>First Name:</label>
            <input type="text" name="firstName" required>

            <label>Last Name:</label>
            <input type="text" name="lastName" required>

            <label>Phone Number:</label>
            <input type="text" name="phoneNo" required>

            <label>Email:</label>
            <input type="email" name="email" required>
            <p style="color: red; display:flex;">${message2}</p>

            <label>Address:</label>
            <input type="text" name="address" required>

            <label>Initial Balance:</label>
            <input type="number" name="initialBalance" required min="100">

            <label>Password:</label>
            <input type="password" name="password" required>

            <label>Upload Photo (Optional):</label>
            <input type="file" name="photo">

            <button type="submit">Register</button>
        </form>

        <c:if test="${not empty accountNo}">
            <div class="backdrop"></div>
            <div class="error-form">
                <h3>Your account No: </h3>
                <p>${accountNo}</p>
                <a href="<%= request.getContextPath()%>/view/register.jsp" style="display: block; margin-top: 10px; color: blue;">Ok</a>
            </div>
        </c:if>

        <p>Already have an account? <a href="<%= request.getContextPath()%>/view/login.jsp">Login here</a></p>
    </body>
</html>

