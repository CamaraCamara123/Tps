<%-- 
    Document   : Commande
    Created on : 8 oct. 2023, 17:13:08
    Author     : ADMIN
--%>

<%@page import="java.util.Date"%>
<%@page import="ma.projet.services.UtilisateurService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ma.projet.entities.LigneCommandeProduit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ma.projet.services.CommandeService"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page import="ma.projet.services.ProduitService"%>
<%@page import="ma.projet.entities.Commande"%>
<%@page import="ma.projet.entities.Produit"%>
<%@page import="ma.projet.entities.Utilisateur"%>
<!DOCTYPE html>




<html>
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Inclure les fichiers Bootstrap via CDN -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commande</title>
    </head>
    <% Commande commande = (Commande) request.getAttribute("commande");%>
        <% String op = "create";%>
        <% int id = 0;
            Date dateC = new Date();
            String btn = "valider";
        %>
        <%
            if (commande != null) {
                op = "update";
                id = commande.getId();
                dateC = commande.getDate();
                btn = "modifier";
            }
        %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div >
            <a class="navbar-brand" href="">
                <img src="produit.png" style="margin-left: 80px;" alt="Logo" width="30" height="30">

            </a>
        </div>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="Categorie.jsp">Categorie</a></li>
                <li class="nav-item"><a class="nav-link" href="Produit.jsp">Produit</a></li>
                <li class="nav-item"><a class="nav-link" href="Commande.jsp">Commande</a></li>
                <li class="nav-item"><a class="nav-link" href="Utilisateur.jsp">Utilisateur</a></li>
               

            </ul>
        </div>
    </nav>
    <body>
        <div class="container mt-5">
            <form action="CommandeController" method="post">
                <input type="hidden" name="op" value="<%=op%>">
                <input type="hidden" name="id" value="<%=id%>">
                <fieldset>
                    <legend>Gestion des Commande</legend><br><br>


                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="date" class="form-label">Date :</label>
                        </div>
                        <div class="col-md-4">
                            <input type="date" class="form-control" id="date" name="date" value="">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="produitId" class="form-label">Produit :</label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-select" id="produitId" name="produitId">
                                <option value="" disabled >Produit</option>
                                <% ProduitService ps = new ProduitService(); %>
                                <% for (Produit p : ps.findAll()) {%>
                                <option value="<%= p.getId()%>"><%= p.getReference()%></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="quantite" class="form-label">Quantité:</label>
                        </div>
                        <div class="col-md-4">
                            <input type="number" class="form-control" id="quantite" name="quantite" value="">
                        </div>
                    </div>





                    <div class="row mb-3">
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-primary" name="valider" style="width: 200px; margin-left: 190px;">
                                Valider</button>
                        </div>
                    </div>
                </fieldset>
            </form>


            <fieldset><br><br>
                <legend>Liste des commandes</legend><br><br>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Date</th>                       
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            CommandeService cs = new CommandeService();
                            for (Commande c : cs.findAll()) {
                        %>
                        <tr>
                            <td><%= c.getId()%></td>
                            <td><%= c.getDate()%></td>
                           
                            <td>
                                <a href="CommandeController?op=delete&id=<%=c.getId()%>" class="btn btn-danger">Supprimer</a>
                                <a href="" class="btn btn-primary">Modifier</a>

                            </td>
                            <%}%>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>

        <!-- Inclure le JavaScript de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>

