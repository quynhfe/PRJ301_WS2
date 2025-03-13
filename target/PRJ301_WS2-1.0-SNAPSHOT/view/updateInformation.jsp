<%-- 
    Document   : updateInformation
    Created on : Mar 13, 2025, 10:40:11 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Personal Information</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
    <h2>Update Personal Information</h2>
    
    <form action="updateServlet" method="post">
        <label>First Name:</label>
        <input type="text" name="firstName" value="${sessionScope.user.firstName}" required>
        
        <label>Last Name:</label>
        <input type="text" name="lastName" value="${sessionScope.user.lastName}" required>
        
        <label>Phone Number:</label>
        <input type="text" name="phoneNo" value="${sessionScope.user.phoneNo}" required>
        
        <label>Email:</label>
        <input type="email" name="email" value="${sessionScope.user.email}" required>
        
        <label>Address:</label>
        <input type="text" name="address" value="${sessionScope.user.address}" required>
        
        <button type="submit">Update Information</button>
    </form>

    <p><a href="dashboard.jsp">Back to Dashboard</a></p>
</body>
</html>


