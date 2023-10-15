<%-- 
    Document   : Produit
    Created on : 8 oct. 2023, 13:27:41
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>

<%@page import="ma.projet.services.ProduitService"%>
<%@page import="ma.projet.entities.Produit"%>
<!DOCTYPE html>


<html>
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Inclure les fichiers Bootstrap via CDN -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produit</title>
    </head>
    <% Produit produit = (Produit) request.getAttribute("produit");%>
        <% String op = "create";%>
        <% int id = 0;
            String ref = "";
            double prix = 0;
            String btn = "valider";
            int categorieId = -1;
            String libelle = "";
        %>
        <%
            if (produit != null) {
                op = "update";
                id = produit.getId();
                ref = produit.getReference();
                prix = produit.getPrix();
                categorieId = produit.getCategorie().getId();
                libelle = produit.getCategorie().getLibelle();
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
            <form action="ProduitController" method="post">
                <input type="hidden" name="op" value="<%=op%>">
                <input type="hidden" name="id" value="<%=id%>">
                <fieldset>
                    <legend>Gestion des produits</legend><br><br>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="prix" class="form-label">Prix:</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="prix" name="prix" value="<%=prix%>">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="reference" class="form-label">Référence:</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="reference" name="reference" value="<%=ref%>">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="categorieId" class="form-label">Catégorie:</label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-select" id="categorieId" name="categorieId">
                                <option value="" disabled >Catégorie</option>
                                <%
                                if(op.equals("update")){
                                %>
                                <option value="<%=categorieId%>" selected><%=libelle%></option>
                                <%}%>
                                <% CategorieService cs = new CategorieService(); %>
                                <% for (Categorie c : cs.findAll()) {%>
                                <option value="<%= c.getId()%>"><%= c.getLibelle()%></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-primary" name="<%=btn%>" style="width: 200px; margin-left: 190px;"><%=op%></button>
                        </div>
                    </div>
                </fieldset>
            </form>

            <fieldset><br><br>
                <legend>Liste des produits</legend><br><br>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Référence</th>
                            <th>Prix</th>
                            <th>Catégorie</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ProduitService ps = new ProduitService();
                            for (Produit p : ps.findAll()) {
                        %>
                        <tr>
                            <td><%= p.getReference()%></td>
                            <td><%= p.getPrix()%></td>
                            <td><%= p.getCategorie().getLibelle()%></td>
                            <td>
                                <a href="ProduitController?op=delete&id=<%=p.getId()%>" class="btn btn-danger">Supprimer</a>
                                <a href="ProduitController?op=update&id=<%=p.getId()%>" class="btn btn-primary">Modifier</a>
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

