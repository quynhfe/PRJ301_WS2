<%-- 
    Document   : dashBoard
    Created on : Mar 13, 2025, 10:38:27 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Dashboard</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .dashboard {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 350px;
        }

        h2 {
            color: #094067;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        ul li {
            margin: 15px 0;
        }

        ul li a {
            text-decoration: none;
            background: #3da9fc;
            color: #fffffe;
            padding: 10px 15px;
            border-radius: 5px;
            display: block;
            transition: background 0.3s;
        }

        ul li a:hover {
            background: #ef4565;
        }

        .logout-btn {
            background: #ef4565 !important;
        }

    </style>
    <body>

        <div class="dashboard">
            <c:if test="${not empty sessionScope.username}">
                <p>Welcome, ${sessionScope.username}!</p>
            </c:if>
            <ul>
                <li><a href="<%= request.getContextPath()%>/view/changePassword.jsp">Change Password</a></li>
                <li><a href="<%= request.getContextPath()%>/view/updateInformation.jsp">Update Personal Information</a></li>
                <li><a href="<%= request.getContextPath()%>/view/transferMoney.jsp">Transfer Money</a></li>
                <li><a href="<%= request.getContextPath()%>/view/transactionLog.jsp">View Transaction & Activity Log</a></li>
                <li><a href="<%= request.getContextPath()%>/view/login.jsp" class="logout-btn">Logout</a></li>
            </ul>
        </div>

    </body>
</html>