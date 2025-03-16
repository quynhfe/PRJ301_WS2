<%-- 
    Document   : transferMoney
    Created on : Mar 13, 2025, 10:39:45 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Transfer Money</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
    </head>
    <body>
        <h2>Transfer Money</h2>

        <form action="<%= request.getContextPath()%>/transferServlet" method="post">
            <label>Your Account Number:</label>
            <input type="number" name="fromAccount" value="${sessionScope.fromAccount.getAccountNo()}" readonly>

            <label>Recipient Account Number:</label>
            <input type="number" name="toAccount" required>
            <p style="color: red; display: flex">${message1}</p>

            <label>Amount:</label>
            <input type="number" name="amount" min="1" required>
            <p style="color: red; display: flex">${message2}</p>
            
            <label>Description:</label>
            <input style="height: 60px" type="text" name="message" value="${sessionScope.name} have transferred money" required>
            <button type="submit">Transfer</button>
            
            <p style="color: red; display: flex">${message3}</p>
        </form>

        <p><a href="<%= request.getContextPath()%>/view/dashBoard.jsp">Back to Dashboard</a></p>
    </body>
</html>

