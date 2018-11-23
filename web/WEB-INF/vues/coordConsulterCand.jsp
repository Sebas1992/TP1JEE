<%-- 
    Document   : coordCondulterCand
    Created on : 2018-11-22, 14:54:58
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <%@include file="./menu.jsp" %>
        <h1>Consulter Candidatures</h1>
        <table border="1">
            <thead>
            <th>titre</th>
            <th>description</th>
            <th>Lien web</th>
            <th>Lien document</th>
            <th>nb vues</th>
            <th>actif</th>
            <th>date</th>
            <th>statut</th>
            <th>Nom etudiant</th>
            <th>Prenom etudiant</th>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.listeCandidatures}" var="cand">
                <tr>
                    <td><c:out value="${cand.titre}" /></td>
                    <td><c:out value="${cand.description}" /></td>
                    <td><c:out value="${cand.lien_web}" /></td>
                    <td><c:out value="${cand.lien_document}" /></td>
                    <td><c:out value="${cand.nb_vues}" /></td>
                    <td><c:out value="${cand.active}" /></td>
                    <td><c:out value="${cand.date}" /></td>
                    <td><c:out value="${cand.statut}" /></td>
                    <td><c:out value="${cand.etudiant.nom}" /></td>
                    <td><c:out value="${cand.etudiant.prenom}" /></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
