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
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
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
        
        <c:forEach var="tx" items="${transactions}">
            <tr>
                <td>${tx.transactionId}</td>
                <td>${tx.fromAccount}</td>
                <td>${tx.toAccount}</td>
                <td>${tx.amount}</td>
                <td>${tx.date}</td>
                <td>${tx.status}</td>
            </tr>
        </c:forEach>
        
        <c:if test="${empty transactions}">
            <tr>
                <td colspan="6" style="text-align:center;">No transactions found</td>
            </tr>
        </c:if>
    </table>

    <p><a href="dashboard.jsp">Back to Dashboard</a></p>
</body>
</html>

