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
@WebServlet(name = "SearchViewRequest", urlPatterns = {"/SearchViewRequest"})
public class SearchViewRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        String textTitle = request.getParameter("textTitle");
        List<Department> listDepartment = dao.getAllDepartment();
        request.setAttribute("listDepartment", listDepartment);
        List<Request> list = dao.getRequestByTitle(textTitle);
        request.setAttribute("textTitle", textTitle);
        request.setAttribute("Selected", 1);
        request.setAttribute("list", list);
        request.getRequestDispatcher("viewRequest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
