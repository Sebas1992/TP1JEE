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
        <h1>Hello World!</h1>
        <c:if test="${not empty param.message}">
            <c:out value="${param.message}" />
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
    </body>
</html>

