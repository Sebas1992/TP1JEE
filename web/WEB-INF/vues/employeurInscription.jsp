<%-- 
    Document   : index
    Created on : 2018-11-03, 19:41:17
    Author     : Utilisateur
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
        <h1>Hello World!</h1>
        <h2>${requestScope.message}</h2>
        <form action="" method="get" >
            <label>Adresse courriel:</label>
            <input type="text" name="courriel" id="courriel"  /><br>
            <label>Mot de passe</label>
            <input type="text" name="mot_de_passe" id="mot_de_passe"  /><br>
            <label>Nom:</label>
            <input type="text" name="nomEmp" id="nomEmp"  /><br>
            <label>Prenom:</label>
            <input type="text" name="prenomEmp" id="prenomEmp"  /><br>            
            <label>Telephone:</label>
            <input type="text" name="tel" id="tel"  /><br>
            <input type="hidden" name="action" value="employeurInscription">
            <label>Nom compagnie:</label>
            <input type="text" name="nomComp" id="nomComp"  /><br>
            <label>Site web</label>
            <input type="text" name="site_web" id="site_web"  /><br>
            <label>Numero civique:</label>
            <input type="text" name="numero_civique" id="numero_civique"  /><br>
            <label>Rue:</label>
            <input type="text" name="rue" id="rue"  /><br>
            <label>Bureau:</label>
            <input type="text" name="bureau" id="bureau"  /><br>
            <label>Ville:</label>
            <input type="text" name="ville" id="ville"  /><br>
            <label>Code postal:</label>
            <input type="text" name="code_postal" id="code_postal"  /><br>
            <label>Province:</label>
            <input type="text" name="province" id="province"  /><br>
            <label>Pays</label>
            <input type="text" name="pays" id="pays"  /><br>
            <input type="hidden" name="action" value="employeurInscription" />
            <br><input type="submit" value="S'inscrire"/>
        </form>
    </body>
</html>
