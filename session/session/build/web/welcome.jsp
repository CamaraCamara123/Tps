<%-- 
    Document   : welcome
    Created on : 10 oct. 2023, 12:25:31
    Author     : Lachgar
--%>

<%@page import="ma.projet.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! Client c;%>
        <%
          if(session==null){
              response.sendRedirect("auth.jsp");
          } else{
              c = (Client)session.getAttribute("client");
          }
                %>
        <h1>
            Welcome : <%= c.getNom() %>
            
        </h1>
            <div>
                    <a href="auth?op=logout">logout</a>
            </div>
    </body>
</html>
