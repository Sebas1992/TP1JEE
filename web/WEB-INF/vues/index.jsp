<%-- 
    Document   : index
    Created on : 2018-11-03, 19:41:17
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <%@include file="./menu.jsp" %>    
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <h2>Inscriptions</h2>
        <a href="?action=employeurInscription">Employeur</a> <br />
        <a href="?action=etudiantInscription">Etudiant</a>
        <h2>Profil etudiant</h2>
        <a href="?action=etudiantProfil">Etudiant profil</a>
    </body>
</html>
