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
        <% 
            if(request.getParameter("message")!=null){
        %>      <h2><% request.getParameter("message"); %>/h2><%
            }
        
        %>
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

