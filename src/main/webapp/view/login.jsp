<%-- 
    Document   : login
    Created on : Mar 13, 2025, 10:38:47 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>E-Banking System</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
        <script src="js/script.js"></script>
    </head>
    <body>
        <h2>Welcome to E-Banking System</h2>
        <c:if test="${not empty error}">
            <div class="backdrop"></div>
            <div class="error-form">
                <h3>Login fail!</h3>
                <p>${error}</p>
                <a href="<%= request.getContextPath()%>/view/login.jsp" style="display: block; margin-top: 10px; color: blue;">Try again</a>
            </div>
        </c:if>

        <form action="<%= request.getContextPath()%>/loginServlet" method="post">
            <label>Email:</label>
            <input type="text" name="email" required>
            <label>Password:</label>
            <input type="password" name="password" required>
            <button type="submit">Login</button>
        </form>

        <p>Don't have an account? <a href="<%= request.getContextPath()%>/view/register.jsp">Register here</a></p>
    </body>
</html>