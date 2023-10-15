<%-- 
    Document   : ProduitUpdate
    Created on : 8 oct. 2023, 15:07:53
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
        <title>Categorie</title>
    </head>
    <body>
        <div class="container mt-5">
            <form action="ProduitController" method="post">
                <fieldset>
                    <legend>Modifier le produit : </legend><br><br>

                    <% Produit produit = (Produit) request.getAttribute("produit");%>

                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="id" class="form-label">Id:</label>
                        </div>
                        <div class="col-md-4">
                            <input disabled type="text" class="form-control" id="id" name="id" value="<%= produit.getId()%>" />
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="prix" class="form-label">Prix:</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="prix" name="prix" value="<%= produit.getPrix()%>" />
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="reference" class="form-label">Référence:</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="reference" name="reference" value="<%= produit.getReference()%>" />
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="categorieId" class="form-label">Catégorie:</label>
                        </div>
                        <div class="col-md-4">
                            <select class="form-select" id="categorieId" name="categorieId">
                                <% CategorieService cs = new CategorieService(); %>
                                <% for (Categorie c : cs.findAll()) {%>
                                <option value="<%= c.getId()%>"><%= c.getLibelle()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <button style="width: 200px; margin-left: 190px;" type="submit" class="btn btn-primary" name="modifier">Modifier</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
