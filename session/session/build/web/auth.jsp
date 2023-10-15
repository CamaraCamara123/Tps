<%-- 
    Document   : auth
    Created on : 10 oct. 2023, 12:10:57
    Author     : Lachgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="auth" method="POST">
            <fieldset>
                <legend>Inscription :</legend>
                <table>
                    <tr>
                        <td>Email : </td>
                        <td><input type="text" name="email" value=""></td>
                    </tr>
                    <tr>
                        <td>password : </td>
                        <td><input type="text" name="password" value=""></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Connect"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><h3>
                            ${msg}
                            </h3></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
