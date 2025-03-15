<%-- 
    Document   : updateInformation
    Created on : Mar 13, 2025, 10:40:11 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Personal Information</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
    </head>
    <body>
        <h2>Update Personal Information</h2>

    <c:if test="${empty sessionScope.customer}">
        <p style="color: red;">Error: No customer information found. Please log in again.</p>
    </c:if>

    <form action="<%= request.getContextPath()%>/updateServlet" method="post">
        <input type="hidden" name="idNo" value="${sessionScope.customer.getIdNo()}">
        <input type="hidden" name="initialBalance" value="${sessionScope.customer.getInitialBalance()}">
        <input type="hidden" name="password" value="${sessionScope.customer.getPassword()}">
         
        <label>First Name:</label>
        <input type="text" name="firstName" value="${sessionScope.customer.getFirstName()}" required>

        <label>Last Name:</label>
        <input type="text" name="lastName" value="${sessionScope.customer.getLastName()}" required>

        <label>Phone Number:</label>
        <input type="text" name="phoneNo" value="${sessionScope.customer.getPhoneNo()}" required>

        <label>Email:</label>
        <input type="email" name="email" value="${sessionScope.customer.getEmail()}" readonly="true">

        <label>Address:</label>
        <input type="text" name="address" value="${sessionScope.customer.getAddress()}" required>

        <button type="submit">Update Information</button>
    </form>

    <p><a href="<%= request.getContextPath()%>/view/dashBoard.jsp">Back to Dashboard</a></p>
</body>
</html>


