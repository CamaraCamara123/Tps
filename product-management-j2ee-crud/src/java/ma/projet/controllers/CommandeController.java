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
import ma.projet.entities.Produit;
import ma.projet.entities.Commande;

import java.text.SimpleDateFormat;
import java.util.Date;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.entities.LigneCommandeProduitPK;
import ma.projet.services.CategorieService;
import ma.projet.services.CommandeService;
import ma.projet.services.LigneCommandeProduitService;
import ma.projet.services.ProduitService;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CommandeController", urlPatterns = {"/CommandeController"})
public class CommandeController extends HttpServlet {

    private ProduitService ps;
    private CommandeService cmds;
    private CommandeService cs;
    private LigneCommandeProduitService lcps;
    private Commande commande = null;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        cmds = new CommandeService();
        ps = new ProduitService();
        cs = new CommandeService();
        lcps = new LigneCommandeProduitService();
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
            if (op.equals("delete")) {
                cmds.delete(cmds.getById(Integer.parseInt(request.getParameter("id"))));
            } else if (op.equals("update")) {

                int commandeId = Integer.parseInt(request.getParameter("id"));
                commande = cmds.getById(commandeId);
                request.setAttribute("commande", commande);

                request.getRequestDispatcher("Commande.jsp").forward(request, response);

            } else if (request.getParameter("modifier") != null) {

                int commande_id = Integer.parseInt(request.getParameter("id"));
                String dateStr = request.getParameter("date");
                Date date = null;
                int categorieId = Integer.parseInt(request.getParameter("categorieId"));
                if (dateStr != null && !dateStr.isEmpty()) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        date = dateFormat.parse(dateStr);
                        int quantite = Integer.parseInt(request.getParameter("quantite"));
                        int ProduitId = Integer.parseInt(request.getParameter("produitId"));
                        Commande c = new Commande(date);
                        cs.update(c);
                        Produit p = ps.getById(ProduitId);
                        LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(p.getId(), c.getId());
                        LigneCommandeProduit lp = new LigneCommandeProduit(lpk, quantite);
                        lcps.update(lp);

                    } catch (java.text.ParseException e) {
                        System.out.println(e.getMessage());
                    }
                }
                response.sendRedirect("Commande.jsp");
            }else if (request.getParameter("valider") != null){

            String dateStr = request.getParameter("date");
            Date date = null;

            if (dateStr != null && !dateStr.isEmpty()) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    date = dateFormat.parse(dateStr);
                    int quantite = Integer.parseInt(request.getParameter("quantite"));
                    int ProduitId = Integer.parseInt(request.getParameter("produitId"));
                    Commande c = new Commande(date);
                    cs.create(c);
                    Produit p = ps.getById(ProduitId);
                    LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(p.getId(), c.getId());
                    LigneCommandeProduit lp = new LigneCommandeProduit(lpk, quantite);
                    lcps.create(lp);

                } catch (java.text.ParseException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

        } 
        response.sendRedirect("Commande.jsp");

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
