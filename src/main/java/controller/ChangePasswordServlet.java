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
public class ChangePasswordServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePasswordServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(false);
        Customer c = (Customer) session.getAttribute("customer");
        System.out.println(c.toString());
        System.out.println(c.getPassword());
        String currentPassword1 = c.getPassword();
        String currentPassword2 = request.getParameter("currentPassword");
        if (!currentPassword1.equals(currentPassword2)) {
            request.setAttribute("message1", "* Wrong current password");
            request.getRequestDispatcher("/view/changePassword.jsp").forward(request, response);
        }
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        if (!newPassword.equals(confirmNewPassword)) {
            request.setAttribute("message2", "* Confirmation password does not match");
            request.getRequestDispatcher("/view/changePassword.jsp").forward(request, response);
        }
        CustomerDB cusDB = new CustomerDB();
        cusDB.changePasswordCustomer(c, newPassword);
        request.setAttribute("message3", "Password has change");
        request.getRequestDispatcher("/view/changePassword.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
