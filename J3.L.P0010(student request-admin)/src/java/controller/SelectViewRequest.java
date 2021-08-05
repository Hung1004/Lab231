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
@WebServlet(name = "SelectViewRequest", urlPatterns = {"/SelectViewRequest"})
public class SelectViewRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        List<Department> listDepartment = dao.getAllDepartment();
        String did = request.getParameter("select");
        List<Request> list = dao.getRequestByDid(did);
        
        request.setAttribute("listDepartment", listDepartment);
        request.setAttribute("choose", did);
        request.setAttribute("textTitle", "");
        request.setAttribute("list", list);
        request.getRequestDispatcher("viewRequest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
