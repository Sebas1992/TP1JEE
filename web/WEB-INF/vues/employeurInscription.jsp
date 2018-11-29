<%-- 
    Document   : index
    Created on : 2018-11-03, 19:41:17
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <%@include file="./menu.jsp" %>
        <h1>Hello World!</h1>
        <h2>${requestScope.message}</h2>
        <form class="form-horizontal" action="" method="get">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="container-fluid">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="nom" class="col-sm-3 col-form-label">Nom :</label>
                                    <div class="col-sm-8">
                                      <input type="text" class="form-control" name="nomEmp" id="nomEmp" placeholder="John">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="prenom" class="col-sm-3 col-form-label">Prénom :</label>
                                    <div class="col-sm-8">
                                      <input type="text" class="form-control" name="prenomEmp" id="prenomEmp" placeholder="Doe">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="col-sm-3 col-form-label">Courriel :</label>
                                    <div class="col-sm-8">
                                      <input type="email" class="form-control" name="courriel" id="mot_de_passe" placeholder="JDoe06@gmail.com">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="mdp" class="col-sm-3 col-form-label">Mot de passe :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="mot_de_passe" id="mot_de_passe" placeholder="Mot de passe" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="tel" class="col-sm-3 col-form-label"> Téléphone :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="tel" id="tel" placeholder="(514) 123-4567" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="nomComp" class="col-sm-3 col-form-label"> Nom compagnie :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="nomComp" id="nomComp" placeholder="Compagnie" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="site_web" class="col-sm-3 col-form-label"> Site Web :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="site_web" id="site_web" placeholder="www.macompagnie.com" />
                                    </div>
                                </div>                                
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="rue" class="col-sm-3 col-form-label"> Rue :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="rue" id="rue" placeholder="1er avenue" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="bureau" class="col-sm-3 col-form-label"> Bureau :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="bureau" id="bureau" placeholder="C" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="ville" class="col-sm-3 col-form-label"> Ville :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="ville" id="ville" placeholder="Montreal" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="nomComp" class="col-sm-3 col-form-label"> Numéro civique :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="numero_civique" id="numero_civique" placeholder="12345" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="code_postal" class="col-sm-3 col-form-label"> Code postal :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="code_postal" id="code_postal" placeholder="A1A 1A1" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="province" class="col-sm-3 col-form-label"> Province :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="province" id="province" placeholder="Province" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="pays" class="col-sm-3 col-form-label"> Pays :</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="pays" id="pays" placeholder="Canada" />
                                    </div>
                                </div>
                                <input type='hidden' name='role' value="employeur" />
                                <input type="hidden" name="action" value="employeurInscription">            
                                <br><input class="btn btn-primary" type="submit" value="S'inscrire"/>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
    </body>
</html>
