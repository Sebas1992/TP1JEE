<%-- 
    Document   : menu-employeur
    Created on : 2018-11-28, 02:48:04
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="menu">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" id="btnMenuColl" data-toggle="collapse" data-target="#navbar-collapse-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="?action=profilEmployeur"><img id="logo" src="./static/images/logoCouper.png"/></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-main">
            <div id="choixMenu">
                <ul class="nav navbar-nav navbar-left">
                    <li><a class="#" href="?action=profilEmployeur">Mon profil</a></li>
                    <li><a class="#" href="?action=profilEmployeur">Publier une offre de stage</a></li>
                    <li><a class="#" href="?action=profilEmployeur">Rechercher Candidat</a></li>
                    <li><a class="#" href="?action=deconnection">Se déconnecter</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>
