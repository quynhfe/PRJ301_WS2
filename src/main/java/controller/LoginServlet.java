/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import data.AccountDB;
import data.CustomerDB;
import data.TranslogDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Customer;

/**
 *
 * @author ADMIN
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        CustomerDB customerDB = new CustomerDB();
        AccountDB accountDB = new AccountDB();
        TranslogDB translogDB = new TranslogDB();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Customer customer = customerDB.getCusByEmailAndPassword(email, password); 

        if (customer != null) {
            session.setAttribute("email", email);
            session.setAttribute("name", customer.getFirstName() + " " + customer.getLastName());
            session.setAttribute("customer", customer);
            Account fromAccount = accountDB.getAccountByIdNo(customer.getIdNo());
            session.setAttribute("fromAccount", fromAccount);
            session.setAttribute("transactions", translogDB.getTransaction(fromAccount.getAccountNo()));
            request.getRequestDispatcher("/view/dashBoard.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Wrong email or password");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
