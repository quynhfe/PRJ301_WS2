/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import data.AccountDB;
import data.CustomerDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.Customer;

/**
 *
 * @author ADMIN
 */
public class RegistrationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDB customerDB = new CustomerDB();
        AccountDB accountDB = new AccountDB();
        String idNo = request.getParameter("idNo");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        double initialBalance = Double.parseDouble(request.getParameter("initialBalance"));
        String password = request.getParameter("password");
        for (Customer c : customerDB.getAllCustomer()) {
            if (c.getIdNo().equals(idNo)) {
                request.setAttribute("message1", "* This user had been a bank account");
                request.getRequestDispatcher("/view/register.jsp").forward(request, response);
            }
            if (c.getEmail().equals(email)) {
                request.setAttribute("message2", "* email is existed");
                request.getRequestDispatcher("/view/register.jsp").forward(request, response);
            }
        }
        Customer cus = new Customer(idNo, firstName, lastName, phoneNo, email, address, initialBalance, password);
        Account acc = new Account(idNo, initialBalance);
        customerDB.addCustomer(cus);
        accountDB.addAccount(acc);
        request.setAttribute("accountNo", acc.getAccountNo());
        request.setAttribute("customer", cus);
        request.getRequestDispatcher("/view/register.jsp").forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        
        return "Short description";
    }// </editor-fold>

}
