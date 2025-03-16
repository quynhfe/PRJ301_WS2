/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import data.CustomerDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author ADMIN
 */
public class UpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer c = (Customer) session.getAttribute("customer");
        request.getRequestDispatcher("/view/updateInformation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idNo = request.getParameter("idNo");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        double initialBalance = Double.parseDouble(request.getParameter("initialBalance"));
        String password = request.getParameter("password");
        Customer c = new Customer(idNo, firstName, lastName, phoneNo, email, address, initialBalance, password);
        CustomerDB cDB = new CustomerDB();
        cDB.updateCustomer(c);
        HttpSession session = request.getSession();
        session.setAttribute("customer", c);
        request.setAttribute("message", "Information had been updated");
        request.getRequestDispatcher("/view/updateInformation.jsp").forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
