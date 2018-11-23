<%-- 
    Document   : etudiantInscription
    Created on : 2018-11-22, 19:48:15
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <br />
        <br />
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
            <input type='hidden' name='role' value="etudiant" />
            <input type="hidden" name="action" value="inscription">
            
            <br><input type="submit" value="S'inscrire"/>
        </form>
        </body>
</html>
