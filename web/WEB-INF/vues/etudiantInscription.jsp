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
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="menu">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" id="btnMenuColl" data-toggle="collapse" data-target="#navbar-collapse-main">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="?action=default"><img id="logo" src="./static/images/logoCouper.png"/></a>
            </div>
        </div>
    </nav>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <h1>Inscription Etudiant</h1>
        <form class="form-horizontal" action="" method="get">
                <div class="row" id="contenuMiddle">
                    <div class="col-lg-12" id="contenuGauche">
                        <div class="container-fluid" id="infoBase">
                            <div class="form-group">
                                <label for="nom" class="col-sm-3 col-form-label">Nom :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" name="nom" id="nom" placeholder="John">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="prenom" class="col-sm-3 col-form-label">Prénom :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" name="prenom" id="prenom" placeholder="Doe">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-3 col-form-label">Courriel :</label>
                                <div class="col-sm-8">
                                  <input type="email" class="form-control" name="email" id="email" placeholder="JDoe06@gmail.com">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mdp" class="col-sm-3 col-form-label">Mot de passe :</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="mdp" id="mdp" placeholder="Mot de passe" />
                                </div>
                            </div>
                            <input type='hidden' name='role' value="etudiant" />
                            <input type="hidden" name="action" value="etudiantInscription">            
                            <br><input class="btn btn-primary" type="submit" value="S'inscrire"/>
                        </div>
                    </div>
                </div>
            </form>
        </body>
</html>
