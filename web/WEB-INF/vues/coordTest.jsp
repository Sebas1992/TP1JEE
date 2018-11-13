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
        <br />
        <h1>Consulter Candidatures</h1>
        <form action="" methode="get">
            <input type="hidden" name="action" value="coordonnateurConsulterCand" />
            <input type="submit" value="Rechercher candidatures" />
        </form>
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
        <br />
        <h1>Uploader fichier</h1>
        <c:out value="${message}" />
        <form action="coordonnateurUploadFile" method="POST" enctype='multipart/form-data'>
            <input type="hidden" name="action" value="coordonnateurUploadFile" />
            <input type="file" name="fichier" />
            <input type="submit" value="Upload" />
        </form>
    </body>
</html>

