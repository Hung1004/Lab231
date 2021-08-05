/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import entity.Department;
import entity.Request;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hùng
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        String to = sdf.format(calendar.getTime());
        calendar.add(Calendar.DATE, -2);
        String from = sdf.format(calendar.getTime());

        List<Department> list = dao.getAllDepartment();
        List<Request> listRequestToday = new ArrayList();
        List<Request> listRequestLast2days = new ArrayList();
        
        for (Department department : list) {
            Request rqToday = dao.getRequestToday(department.getId(), department.getName(), to);
            listRequestToday.add(rqToday);
             Request rq2days = dao.getRequestLast2days(department.getId(), department.getName(), from, to);
            listRequestLast2days.add(rq2days);
        }
        
        request.setAttribute("listRequestToday", listRequestToday);
        request.setAttribute("listRequestLast2days", listRequestLast2days);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
