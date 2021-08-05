/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import entity.Account;
import entity.Request;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
@WebServlet(name = "SolveRequestController", urlPatterns = {"/SolveRequestController"})
public class SolveRequestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(Calendar.getInstance().getTime());
        
        String solution = request.getParameter("solution");
        String rid = request.getParameter("rid");
        String status = request.getParameter("status");
        Account account = (Account) session.getAttribute("account");
        dao.updateRequest(Integer.parseInt(rid), Integer.parseInt(status), date, account.getId(), solution, 1);
        Request getRequest = dao.getRequestByID(rid);

        request.setAttribute("getRequest", getRequest);
        request.getRequestDispatcher("solveRequest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
