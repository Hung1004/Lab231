/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.daoPhoto;
import entity.Contact;
import entity.Gallery;
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
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

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
        daoPhoto dao = new daoPhoto();
        
        int page = 3;
        int index =1;
        int num = dao.getallNumGallery();
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
        
        List<Gallery> listGallery = dao.getGalleryByPage(index, page);
        List<Gallery> listgetDataTop3Gallery = dao.getDataTop3Gallery();
        Gallery getDataTop1Gallery = dao.getDataTop1Gallery();
        
        request.setAttribute("getDataTop3Gallery", listgetDataTop3Gallery);
        request.setAttribute("getDataTop1Gallery", getDataTop1Gallery);     
        request.setAttribute("listGallery", listGallery);     
        request.setAttribute("numpage", numpage);     
        request.setAttribute("index", index);     
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
