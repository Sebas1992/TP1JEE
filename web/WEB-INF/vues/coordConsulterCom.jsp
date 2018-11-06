<%-- 
    Document   : coordConsulterCom
    Created on : 2018-11-05, 19:41:54
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Creer Coordonnateur</h1>
        <c:if test="${not empty requestScope.message}">
            <c:out value="${requestScope.message}" />
        </c:if>
        <form action="" method="get" >
            <label>Id numero:</label>
            <input type="text" name="id_etu" id="id_etu"  /><br>
            <label>Adresse courriel:</label>
            <input type="text" name="email" id="email"  /><br>
            <label>Mot de passe</label>
            <input type="text" name="mdp" id="mdp"  /><br>
            <label>Nom:</label>
            <input type="text" name="nom" id="nom"  /><br>
            <label>Prenom:</label>
            <input type="text" name="prenom" id="prenom"  /><br>
            <input type='hidden' name='role' value="coordonnateur" />
            <input type="hidden" name="action" value="coordonnateurConsulterCom">
            
            <br><input type="submit" value="S'inscrire"/>
        </form>
        
        <h1>Chercher coordonnateur par cle</h1>
        <form action="" methode="get">
            <label>Cle:</label>
            <input type="text" name="id_etu" id="id_etu" />
            <input type="hidden" name="action" value="coordonnateurConsulterCom" />
            <input type="submit" value="Chercher" />
        </form>
        <c:choose>
        <c:when test="${not empty requestScope.coordonnateur}">
            <table>
                <thead>
                <th>Id</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Courriel</th>
                </thead>
                <tbody
                    <tr>
                        <td><c:out value="${requestScope.coordonnateur.id_coordonnateur}" /></td>
                        <td><c:out value="${requestScope.coordonnateur.nom}" /></td>
                        <td><c:out value="${requestScope.coordonnateur.prenom}" /></td>
                        <td><c:out value="${requestScope.coordonnateur.courriel}" /></td>
                    </tr>
                </tbody>
            </table>
        </c:when>
            <c:otherwise>
                <c:out value="Impossible de trouver le Coordonnateur" />
            </c:otherwise>
        </c:choose>
    </body>
</html>

