/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import entity.Answer;
import entity.Question;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "takeQuizController", urlPatterns = {"/takeQuizController"})
public class takeQuizController extends HttpServlet {

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
        String reload = request.getParameter("reload");
        int countQues = (int) session.getAttribute("countQues");
        int totalQues = (int) session.getAttribute("totalQues");
        int CheckReload = (int) session.getAttribute("CheckReload");
//Time reload - next
        int timeQuiz = (int) session.getAttribute("timeQuiz");
        long timeStart = (long) session.getAttribute("timeStart");
        long timeNext = Calendar.getInstance().getTimeInMillis();
        timeQuiz = (int) (timeQuiz - (timeNext - timeStart) / 1000);
        session.setAttribute("timeStart", timeNext);
        session.setAttribute("timeQuiz", timeQuiz);
        if(countQues>0){
          session.setAttribute("active", "active");
        }
// ------------------ 
        List<Question> listTakeQuiz = (List<Question>) session.getAttribute("listTakeQuiz");
// chay lan dau
        if (reload.equals("0")) {
            int getIdQues = listTakeQuiz.get(totalQues - 1).getId();
            List<Answer> option = dao.getListAnswerByQuestionID(getIdQues);
            
            request.setAttribute("question", listTakeQuiz.get(totalQues - 1).getQuestion());
            request.setAttribute("option", option);
            session.setAttribute("countQues", totalQues - 1);
            request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
            return;
        }
//
        if (CheckReload == 1) {
            int getIdQues = listTakeQuiz.get(countQues - 1).getId();
            List<Answer> option = dao.getListAnswerByQuestionID(getIdQues);
            request.setAttribute("question", listTakeQuiz.get(countQues - 1).getQuestion());
            request.setAttribute("option", option);
            session.setAttribute("countQues", countQues - 1);
            session.setAttribute("CheckReload", 0);
            request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
            return;
        }
        if (CheckReload ==0) {
            int getIdQues = listTakeQuiz.get(countQues).getId();
            List<Answer> option = dao.getListAnswerByQuestionID(getIdQues);

            request.setAttribute("question", listTakeQuiz.get(countQues).getQuestion());
            request.setAttribute("option", option);
            session.setAttribute("countQues", countQues);
            request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
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
