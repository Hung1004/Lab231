/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hùng
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        DAO dao = new DAO();
        
        String date = sdf.format(calendar);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = dao.getAccount(username, password);
        if (account == null) {
            request.setAttribute("mess", "Enter correct information!");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        session.setAttribute("date", date);
        session.setAttribute("account", account);
        response.sendRedirect("HomeController");
    }

}
