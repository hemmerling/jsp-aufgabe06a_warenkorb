/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe06a_warenkorb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hemmerling.aufgabe06a_warenkorb.model.persistence.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author rhemmerling
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private static final String ACTION = "action";
    private static final String ID = "id";

    private static final String START_PAGE = "index.jsp";
    private static final String WARENKORB_PAGE = "warenkorb.jsp";
    private static final String ADD_ARTIKEL1 = "ArtikelAddAction";
    private static final String ADD_ARTIKEL2 = "add_artikel.jsp";
    private static final String ARTIKELLISTE_PAGE = "artikelliste.jsp";

    private static final String WARENKORB = "warenkorb";
    private static final String ALLE_WARENKOERBE = "alle_warenkoerbe";
    private static final String ADD_ARTIKEL = "add_artikel";
    private static final String ARTIKELLISTE = "artikelliste";

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
        Warenkorb warenkorb = Warenkorb.getInstance(); // Singleton 

        session.setAttribute(WARENKORB, warenkorb);
        Object obj1 = session.getAttribute(WARENKORB);
        session.setAttribute(WARENKORB, warenkorb);

        String action = request.getParameter(ACTION);

        String nextPage = new String("index.jsp");

        System.out.println("test");

        if (action != null && !action.trim().isEmpty()) {
            switch (action) {
                case WARENKORB: {
                    nextPage = WARENKORB_PAGE;
                    break;
                }
                case ADD_ARTIKEL: {
                    int id = Integer.valueOf((String)request.getParameter(ID));
                    System.out.println(id);
                    ArrayList<Artikel> artikelListe = new ArtikelListe().get();
                    warenkorb.add(artikelListe.get(id));
                    nextPage = WARENKORB_PAGE;
                    break;
                }
                case ARTIKELLISTE: {
                    nextPage = ARTIKELLISTE_PAGE;
                    break;
                }
            }

        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
        requestDispatcher.forward(request, response);
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
