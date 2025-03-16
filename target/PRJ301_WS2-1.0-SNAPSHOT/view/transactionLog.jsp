<%-- 
    Document   : transactionLog
    Created on : Mar 13, 2025, 10:39:34 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Transaction Log</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
    </head>
    <style>/* style.css */

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        h2 {
            color: #094067;
            margin-top: 20px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #3da9fc;
            color: white;
            font-size: 16px;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #e3f2fd;
            transition: 0.3s;
        }

        p {
            margin-top: 20px;
        }

        a {
            text-decoration: none;
            background: #ef4565;
            color: white;
            padding: 10px 15px;
            border-radius: 5px;
            display: inline-block;
            transition: background 0.3s ease;
        }

        a:hover {
            background: #d83450;
        }
    </style>
    <body>
        <h2>Transaction & Activity Log</h2>

        <table border="1">
            <tr>
                <th>Transaction ID</th>
                <th>From Account</th>
                <th>To Account</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Status</th>
            </tr>

            <c:forEach var="tx" items="${sessionScope.transactions}">
                <tr>
                    <td>${tx.getTransID()}</td>
                    <td>${tx.getFromAccount()}</td>
                    <td>${tx.getToAccount()}</td>
                    <td>${tx.getAmount()}</td>
                    <td>${tx.getTimestamp()}</td>
                    <td>${tx.getMessage()}</td>
                </tr>
            </c:forEach>

            <c:if test="${empty transactions}">
                <tr>
                    <td colspan="6" style="text-align:center;">No transactions found</td>
                </tr>
            </c:if>
        </table>

        <p><a href="<%= request.getContextPath()%>/view/dashBoard.jsp">Back to Dashboard</a></p>
    </body>
</html>

