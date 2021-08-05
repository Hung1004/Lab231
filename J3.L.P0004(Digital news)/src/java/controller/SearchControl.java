/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import entity.Digital;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SearchControl", urlPatterns = {"/SearchControl"})
public class SearchControl extends HttpServlet {

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
        DAO dao = new DAO();
        String txt = request.getParameter("txtSearch");
        
        int page = 3;
        int index =1;
        int num = dao.getAllNumDigitalBySearch(txt);
        int numpage = num/page;
        int num2 = num%page; 
        if(num!=0&&num2!=0){
            numpage++;
        }
        try {
            index = Integer.parseInt(request.getParameter("index"));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        
        
        List<Digital> listDigital = dao.getDigitalBySearch(txt, index, page);
        
        for (Digital digital : listDigital) {
            String s1= txt.toLowerCase();
            String txtLow = digital.getTitle().toLowerCase();
            String txt1 = txtLow.replaceAll(s1,"#"+s1+"%1");
               
            String txt2 = txt1.replaceAll("#", "<span class=\"mark\">");
            String text = txt2.replaceAll("%1", "</span>");
            digital.setTitle(text);
        }
        List<Digital> Top5 = dao.getTop5Digital();
        Digital getMostNews = dao.getMostDigital();

        request.setAttribute("getMostNews", getMostNews);
        request.setAttribute("txt", txt);
        request.setAttribute("numpage", numpage);
        request.setAttribute("find", num);
        request.setAttribute("index", index);
        request.setAttribute("Top5", Top5);
        request.setAttribute("listDigital", listDigital);
        request.getRequestDispatcher("searchResult.jsp").forward(request, response);

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
