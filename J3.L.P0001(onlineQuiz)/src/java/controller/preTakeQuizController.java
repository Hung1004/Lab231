/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import entity.Question;
import entity.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
@WebServlet(name = "preTakeQuizController", urlPatterns = {"/preTakeQuizController"})
public class preTakeQuizController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        QuizDAO dao = new QuizDAO();
        int num = Integer.parseInt(request.getParameter("numberQuestion"));
        int numQues = dao.countQuestion();
        if (num <= 0 || num > numQues) {
            request.setAttribute("mess", "Number Question > 0 and <= " + numQues);
            request.getRequestDispatcher("preTakeQuiz.jsp").forward(request, response);
        } else {
            List<Question> listTakeQuiz = dao.getListQuestionToTakeQuiz(num);
            List<Result> listRuslt = new ArrayList<>();
            long timeStart = Calendar.getInstance().getTimeInMillis();

            session.setAttribute("timeQuiz", num * 20);
            session.setAttribute("timeStart", timeStart);
            session.setAttribute("countQues", num);
            session.setAttribute("CheckReload", 0);
            session.setAttribute("totalQues", num);
            session.setAttribute("listTakeQuiz", listTakeQuiz);
            session.setAttribute("listRuslt", listRuslt);
            response.sendRedirect("takeQuizController?reload=0");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
