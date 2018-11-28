<%-- 
    Document   : contacterCandidat
    Created on : 2018-11-28, 02:06:53
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <%@include file="./menu-employeur.jsp" %>
        <br><br><br><br><br><br><br><br><br><br><br>
        <div class="container">
            <form>
                <div class="form-group row mt-5">
                    <label for="destinataire" class="col-sm-2 col-form-label bordure-perso">À</label>
                    <div class="col-sm-10">
                        <input type="text" readonly class="form-control-plaintext bordure-perso" id="destinataire" name="destinataire">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="titre" class="col-sm-2 col-form-label bordure-perso">Titre</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="titre" name="titre">
                    </div>
                </div>
                <div class="form-group">
                    <label for="message">Message</label>
                    <textarea class="form-control" id="message" rows="8"></textarea>
                </div>
                <button type="submit" class="btn btn-dark">Envoyer</button>
            </form>
        </div>
    </body>
</html>
