/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import entity.Answer;
import entity.Question;
import entity.Result;
import java.io.IOException;
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
@WebServlet(name = "preNextController", urlPatterns = {"/preNextController"})
public class preNextController extends HttpServlet {

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
        int countQues = (int) session.getAttribute("countQues");
        String answer[] = request.getParameterValues("answer");

        String cQ = request.getParameter("cQ");
        List<Question> listTakeQuiz = (List<Question>) session.getAttribute("listTakeQuiz");
        List<Result> listRuslt = (List<Result>) session.getAttribute("listRuslt");

        int getIdQues = listTakeQuiz.get(countQues).getId();

        if (answer != null) {
            List<Answer> option = dao.getListAnswerByQuestionID(getIdQues);
            int check = 0;
            for (String answer2 : answer) {
                int num = Integer.parseInt(answer2);
                if (option.get(num - 1).getAnswer() == 1) {
                    check++;
                }
            }
            if (check == answer.length) {
                listRuslt.add(new Result(getIdQues, 1));
            } else {
                listRuslt.add(new Result(getIdQues, 0));
            }
        } else {
            listRuslt.add(new Result(getIdQues, 0));
        }
        session.setAttribute("listRuslt", listRuslt);
// Chuyen trang
        if (countQues == 0 || cQ != null) {
            int totalQues = (int) session.getAttribute("totalQues");
            int totalTrue = 0;
            for (Result result : listRuslt) {
                totalTrue += result.getBool();
            }
            int result = (int) (100 * totalTrue / totalQues);
            request.setAttribute("result", result);
            session.setAttribute("active", "activ");
            request.getRequestDispatcher("doneQuiz.jsp").forward(request, response);
        } else {
            session.setAttribute("CheckReload", 1);
            response.sendRedirect("takeQuizController?reload=1");
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
