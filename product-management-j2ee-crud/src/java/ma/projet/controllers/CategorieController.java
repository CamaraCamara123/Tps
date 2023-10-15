/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.projet.entities.Categorie;
import ma.projet.services.CategorieService;

/**
 *
 * @author Lachgar
 */
@WebServlet(name = "CategorieController", urlPatterns = {"/CategorieController"})
public class CategorieController extends HttpServlet {

    private CategorieService cs;
    private Categorie categorie = null;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        cs = new CategorieService();
    }

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

        if (request.getParameter("op") != null) {
            String op = request.getParameter("op");
            if(op.equals("delete")){
                cs.delete(cs.getById(Integer.parseInt(request.getParameter("id"))));
            }else if(op.equals("update")&&request.getParameter("modifier") == null){
                int categorieId = Integer.parseInt(request.getParameter("id"));
                categorie = cs.getById(categorieId);
                request.setAttribute("categorie", categorie);
                
                request.getRequestDispatcher("Categorie.jsp").forward(request, response);
            }else if(request.getParameter("modifier") != null){
                String code = request.getParameter("code");
                String libelle = request.getParameter("libelle");
                int categorieId = Integer.parseInt(request.getParameter("id"));
                Categorie c = new Categorie(categorieId,code, libelle);
                cs.update(c);
                request.setAttribute("categorie", null);
                request.getRequestDispatcher("Categorie.jsp").forward(request, response);
            }else if(request.getParameter("valider") != null){
                String code = request.getParameter("code");
            String libelle = request.getParameter("libelle");
            cs.create(new Categorie(code, libelle));
            }
        } 
        response.sendRedirect("Categorie.jsp");

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
