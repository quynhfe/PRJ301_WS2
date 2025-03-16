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
    </head>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: url('https://cdn.hdbank.com.vn/hdbank-file/news/editor/QXbkRDURCXHiFoPOCHRq20221223145546/chuyentiennhanh1_1671782268394.jpg') no-repeat center center;
            background-size: cover;
            position: relative;
            display: flex;
        }

        .dashboard {
            /*background: rgba(255, 255, 255, 0.2);  Tạo hiệu ứng mờ */
            padding: 20px;
            border-radius: 10px;
            /*box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);*/
            text-align: center;
            width: 350px;
            height: 300px;
            backdrop-filter: blur(10px); /* Hiệu ứng làm mờ nền */
            margin-top: 250px;
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
            color: white;
        }

    </style>
    <body>
        <div style="color: white; font-size:  80px; width: 50%; height: 100%; display: flex; flex-direction: column; justify-content: start; padding-top: 100px">
             <h1 style="color: white; font-size:  80px; width: 100%; display: flex; flex-direction: column; justify-content: start;  margin:  0">E- Banking</h1>
            <c:if test="${not empty sessionScope.name}">
            <p style="color: white; font-size:  30px; padding: 0">Welcome, ${sessionScope.name}!</p>
        </c:if>
    </div>
    <div class="dashboard">
        <ul>
            <li><a href="<%= request.getContextPath()%>/view/changePassword.jsp">Change Password</a></li>
            <li><a href="<%= request.getContextPath()%>/view/updateInformation.jsp">Update Personal Information</a></li>
            <li><a href="<%= request.getContextPath()%>/view/transferMoney.jsp">Transfer Money</a></li>
            <li><a href="<%= request.getContextPath()%>/view/transactionLog.jsp">View Transaction & Activity Log</a></li>
            <li><a href="<%= request.getContextPath()%>/view/login.jsp" class="logout-btn">LOG OUT</a></li>
        </ul>
    </div>

</body>
</html>