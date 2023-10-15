<%-- 
    Document   : Categorie
    Created on : 4 oct. 2023, 11:52:10
    Author     : Lachgar
--%>

<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Inclure les fichiers Bootstrap via CDN -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorie</title>
    </head>

    <body>
        <% Categorie categorie = (Categorie) request.getAttribute("categorie");%>
        <% String op = "create";%>
        <% int id = 0;
            String libelle = "";
            String code = "";
            String btn = "valider";
        %>
        <%
            if (categorie != null) {
                op = "update";
                id = categorie.getId();
                libelle = categorie.getLibelle();
                code = categorie.getCode();
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
        <div class="container mt-5" style="width: 80%; margin: auto;">
            <form action="CategorieController" method="post">
                <input type="hidden" name="op" value="<%=op%>">
                <input type="hidden" name="id" value="<%=id%>">
                <fieldset>
                    <legend>Gestion des catégories</legend><br><br>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="code" class="form-label">Code:</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="code" name="code" value="<%=code%>">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="libelle" class="form-label">Libellé:</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="libelle" name="libelle" value="<%=libelle%>">
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
                <legend>Liste des catégories</legend><br><br>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>Libellé</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            CategorieService cs = new CategorieService();
                            for (Categorie c : cs.findAll()) {
                        %>
                        <tr>
                            <td><%= c.getCode()%></td>
                            <td><%= c.getLibelle()%></td>
                            <td>
                                <a href="CategorieController?op=delete&id=<%=c.getId()%>" class="btn btn-danger">Supprimer</a>
                                <a href="CategorieController?op=update&id=<%=c.getId()%>" class="btn btn-primary">Modifier</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </fieldset>
        </div>

        <!-- Inclure le JavaScript de Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    </body>

</html>
