<%-- 
    Document   : connection
    Created on : 2018-11-24, 16:12:52
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet"> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./static/css/style.css">

    </head>
    <body>
        <div class="container-fluid" id="fond-connection">
            <div class="row" >
		<br/>
		<div class="col-md-2 col-lg-4" ></div>
		<div class="col-md-8 col-lg-4">
                    <br/>
                    <form action="connection" method="post" id="menu-connection">
                        <div class="form-group">
                        <label for="email">Identifiant:</label>
                        <input type="email" class="form-control" name="email" id="email">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Mot de passe:</label>
                            <input type="password" class="form-control" name="password" id="password">
                        </div>
                        <!--<input type="hidden" name="action" value="connection">-->
                        <button type="submit" class="btn btn-dark">Se connecter</button>
                    </form>	
		</div>	
            </div>
            <div class="row">
                <div class="col-4 mx-auto" style="background-color:white;">
                    <h2>Inscriptions</h2>
                    <a href="?action=employeurInscription">Employeur</a> <br />
                    <a href="?action=etudiantInscription">Etudiant</a>
                </div>
        </div>
    </body>
</html>
