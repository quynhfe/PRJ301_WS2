/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import data.AccountDB;
import data.TranslogDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class TransferServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TransferServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TransferServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer toAccNo = Integer.parseInt(request.getParameter("toAccount"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String message = request.getParameter("message");
        AccountDB accountDB = new AccountDB();
        Account fromAcc = (Account) session.getAttribute("fromAccount");
        Account toAcc = accountDB.getAccountByAccountNo(toAccNo);
        if (toAcc == null) {
            request.setAttribute("message1", "Account not existed");
            request.getRequestDispatcher("/view/transferMoney.jsp").forward(request, response);
        } else {
            if (amount > accountDB.getBalance(fromAcc.getAccountNo())) {
                request.setAttribute("message2", "Insufficient account balance");
                request.getRequestDispatcher("/view/transferMoney.jsp").forward(request, response);
            } else {
                accountDB.transferMoney(amount, fromAcc, toAcc, message);
                request.setAttribute("message3", "Transfer success");
                TranslogDB translogDB = new TranslogDB();
                session.setAttribute("transactions", translogDB.getTransaction(fromAcc.getAccountNo()));
                request.getRequestDispatcher("/view/transferMoney.jsp").forward(request, response);
            }

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
