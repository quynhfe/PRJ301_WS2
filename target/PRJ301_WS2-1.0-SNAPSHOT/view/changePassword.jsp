<%-- 
    Document   : changePassword
    Created on : Mar 13, 2025, 10:38:07 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Change Password</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
        <script src="js/script.js"></script>
    </head>
    <body>
        <h2>Change Password</h2>

        <form action="<%= request.getContextPath()%>/changePasswordServlet" method="post">
            <label>Current Password:</label>
            <input type="password" name="currentPassword" required>
            <p style="color: red; display: flex">${message1}</p>

            <label>New Password:</label>
            <input type="password" name="newPassword" required>

            <label>Confirm New Password:</label>
            <input type="password" name="confirmNewPassword" required>
            <p style="color: red; display: flex">${message2}</p>
            <button type="submit">Change Password</button>
        </form>
        <p style="color: red; display: flex">${message3}</p>
        <p><a href="<%= request.getContextPath()%>/view/dashBoard.jsp">Back to Dashboard</a></p>
    </body>
</html>