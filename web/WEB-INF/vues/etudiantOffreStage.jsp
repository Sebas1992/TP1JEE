<%-- 
    Document   : etudiantOffreStage
    Created on : 2018-11-28, 00:43:05
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Offre de Stage</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="./static/css/style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="./menu-etudiant.jsp" %>

        <!-- Contenu de la page -->
        <div class="container-fluid" id="contenuPage">
            <!-- Section de recherche par competences -->
            <div class="row">
                <div class="col-lg-4">
                    <h2>Recherche par compétences</h2>
                </div>
                <div class="col-lg-7" id='sectionCompetences'>
                    <!-- bouton pour la liste -->
                    <div class="col-lg-2">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Compétences <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header">Programmation</li>
                            <li onclick="ajouterCompetence('php')"><a href="#">php</a></li>
                            <li onclick="ajouterCompetence('html')"><a href="#">html</a></li>
                            <li class="divider"></li>
                            <li class="dropdown-header">Réseau</li>
                            <li onclick="ajouterCompetence('CCNA')"><a href="#">CCNA</a></li>
                            <li onclick="ajouterCompetence('Sécurité')"><a href="#">Sécurité</a></li>
                        </ul>
                    </div>
                    
                    <!-- Conteneur de comperence -->
                    <div class="col-lg-10">
                        <div  class="panel panel-default">
                            <div class="panel-body" id="conteneurCompetences"></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fin de section de recherche par competances -->

            <!-- Section de recherche des stages -->
            <div class="row" id="rechercheStage">
                <div class="col-lg-12">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <td>Compagnie <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Spécialité <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Poste <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Places <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Rémunération <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Match <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Statut <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><a href="pomme.com">pomme</a></td>
                                    <td>Programmation</td>
                                    <td>Programmeur Web</td>
                                    <td>1</td>
                                    <td>0$/hr</td>
                                    <td>87%</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td><a href="internet.com">Le meilleur internet</a></td>
                                    <td>Reseau</td>
                                    <td>Programmeur Reseau</td>
                                    <td>1</td>
                                    <td>-1$/hr</td>
                                    <td>1%</td>
                                    <td>1</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Fin de la section de recherche des stages -->
        </div>

        <!-- Footer -->
<footer id="footer" class="container-fluid text-center">
    <p>&copy; Copyright 2018, Nom Site.</p>
</footer>
        <!-- Fin footer -->
        <script>
            var nbComp = 0;
            function ajouterCompetence(nom){
                document.getElementById("conteneurCompetences").innerHTML += "<span class='competence' id='competence"+nbComp+"'>"+nom+" <a class='fas fa-times' onclick='enleverCompetence("+nbComp+")'></a></span>";
                $(".competence").addClass("alert alert-info")
                        .css("padding","5px 8px 5px 8px");
                nbComp++;
            };
            function enleverCompetence(i){
                document.getElementById("competence"+i).remove();
            }
        </script>

    </body>
</html>
