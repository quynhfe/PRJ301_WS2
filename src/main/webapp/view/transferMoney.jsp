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
        <input type="text" name="fromAccount" value="${sessionScope.fromAccount.accountNo}" readonly>
        
        <label>Recipient Account Number:</label>
        <input type="text" name="toAccount" required>
        
        <label>Amount:</label>
        <input type="number" name="amount" min="1" required>
        
        <button type="submit">Transfer</button>
    </form>

    <p><a href="<%= request.getContextPath()%>/view/dashBoard.jsp">Back to Dashboard</a></p>
</body>
</html>

