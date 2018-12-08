<%-- 
    Document   : profilEtudiant
    Created on : 2018-11-23, 22:40:25
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profil étudiant</title>
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
        <div class="container" id="profilEtu">
            <!--  *************************************Bare du haut *************************************-->
            <div class="row" id="contenuHaut">
                <div class="col-lg-6">
                    <h2>Profil</h2>
                </div>
                <div class="col-lg-6">
                    <a href="#" class="btn btn-danger btn-md" id="info">
                        <span class="glyphicon glyphicon-info-sign"></span> Info
                    </a>
                </div>
            </div>
            <!--  ************************************* Formulaire *************************************-->
            <form class="form-horizontal">
                <div class="row" id="contenuMiddle">
                    <div class="col-lg-5" id="contenuGauche">
                        <div class="container-fluid" id="infoBase">
                            <div class="form-group">
                                <label for="nom" class="col-sm-3 col-form-label">Nom :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="nom" name="nom" placeholder="John">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="prenom" class="col-sm-3 col-form-label">Prénom :</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Doe">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-3 col-form-label">Courriel :</label>
                                <div class="col-sm-8">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="JDoe06@gmail.com">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="cv" class="col-sm-3 col-form-label">CV :</label>
                                <div class="col-sm-8 input-group">
                                    <label class="input-group-btn">
                                        <span class="btn btn-primary">
                                            Ajouter<input type="file" lass="form-control-file" accept="application/pdf" style="display: none;" id="cv">
                                        </span>
                                    </label>
                                    <select class="form-control" id="cvListe" readonly>
                                        <option>cv_C#.pdf</option>
                                        <option>cvJavaEE.pdf</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-5" id="contenuDroit">
                        <div class="row">
                            <table  id="competence" class="table table-hover">
                                <thead>
                                    <tr>
                                        <td>Compétences <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        <td>Niveau <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${criteres}" var="crit">
                                        <tr>
                                            <td><c:out value="${crit.nom}" /></td>
                                            <td>
                                                <select class="form-control">
                                                    <option>non</option>
                                                    <option>oui</option>
                                                </select>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-lg-4 col-sm-10">
                                <label for="statut_recherche">Statut de recherche:</label> 
                            </div>
                            <div class="col-lg-7 col-sm-10">
                                <select class="form-control" id="statut_recherche" name="statut_recherche">
                                    <option>En recherche de stage</option>
                                    <option>Stage trouvé</option>
                                    <option>Confirmé</option>
                                </select>
                            </div>
                        </div>
                        <div class="row" id="rowGaucheBas">
                            <input type="hidden" name="action" value="etudiantModifierProfil">
                            <input type="hidden" name="modifier" value="oui">
                            <div class="col-lg-4">
                                <input type="submit" class="btn btn-primary" value="Enregistrer les modifications">
                            </div>
                        </div>
                    </div>    
                </div>
            </form>
        </div>
        <footer id="footer" class="container-fluid text-center">
            <p>&copy; Copyright 2018, Stagéo.</p>
        </footer>
        <script>
            $('#info').popover({ trigger: "hover", title: "Statistiques", placement: "bottom", content: "3 canditature envoyés 15 jours de recherche Cv lu : 10 fois Consultation Profil : 104 fois" });
        </script>
    </body>
</html>
