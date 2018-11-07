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
        <h1>Consulter Communications</h1>
        <form action="" methode="get">
            <input type="hidden" name="action" value="coordonnateurConsulterCom" />
            <input type="submit" value="Rechercher Com" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>Titre</th>
                    <th>Message</th>
                    <th colspan="2">Expediteur</th>
                    <th colspan="2">Destinataire</th>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.listeCom}" var="com">
                    <tr>
                        <td><c:out value="${com.titre}" /></td>
                        <td><c:out value="${com.message}" /></td>
                        <td><c:out value="${com.expediteur.nom}" /></td>
                        <td><c:out value="${com.expediteur.prenom}" /></td>
                        <td><c:out value="${com.destinataire.nom}" /></td>
                        <td><c:out value="${com.destinataire.prenom}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

