<%-- 
    Document   : Utilisateur
    Created on : 09-Oct-2023, 21:45:08
    Author     : hp
--%>

<%@page import="ma.projet.services.UtilisateurService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Gestion des Utilisateurs</title>
    </head>

    <body>
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
        <div class="container mt-5">
            <form action="UtilisateurController" method="post">
                <fieldset>
                    <legend>Gestion des Utilisateurs</legend><br><br>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="nome" class="form-label">Nome</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="nom" name="nom" value="">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="prenom" class="form-label">Prénom</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="prenom" name="prenom" value="">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="role" class="form-label">Role</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="role" name="role" value="">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="telephone" class="form-label">Telephone</label>
                        </div>
                        <div class="col-md-4">
                            <input type="tel" class="form-control" id="telephone" name="telephone" value="">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="adresse" class="form-label">Adresse</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="adresse" name="adresse" value="">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-primary" name="valider" style="width: 200px; margin-left: 190px;">Valider</button>
                        </div>
                    </div>
                </fieldset>
            </form>

            <fieldset><br><br>
                <legend>Liste des Utilisateurs</legend><br><br>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>role</th>
                            <th>Telephone</th>
                            <th>Adresse</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            UtilisateurService us = new UtilisateurService();
                            for (Utilisateur u : us.findAll()) {
                        %>
                        <tr>
                            <td><%= u.getNom()%></td>
                            <td><%= u.getPrenom()%></td>
                            <td><%= u.getRole()%></td>
                            <td><%= u.getTelephone()%></td>
                            <td><%= u.getAdresse()%></td>
                            <td>
                                <a href="UtilisateurController?op=delete&id=<%=u.getId()%>" class="btn btn-danger">Supprimer</a>
                                <a href="#" class="btn btn-primary">Modifier</a>
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
