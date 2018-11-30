<%-- 
    Document   : index
    Created on : 2018-11-03, 19:41:17
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <%@include file="./menu-employeur.jsp" %>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <h2>Publier offre de stage</h2>
        <form class="form-horizontal" action="" method="POST" enctype='multipart/form-data'>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="container-fluid">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="titre" class="col-sm-3 col-form-label">Titre :</label>
                                    <div class="col-sm-8">
                                      <input type="text" class="form-control" name="titre" id="titre" placeholder="stage">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="description" class="col-sm-3 col-form-label">Description :</label>
                                    <div class="col-sm-8">
                                      <input type="text" class="form-control" name="description" id="descriptioin" placeholder="Description">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="site web" class="col-sm-3 col-form-label">Site Web :</label>
                                    <div class="col-sm-8">
                                      <input type="text" class="form-control" name="lien_web" id="lien_web" placeholder="www.siteweb.com">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="document" class="col-sm-3 col-form-label">Document :</label>
                                    <div class="col-sm-8">
                                      <input type="file" class="form-control" name="document" id="document" placeholder="document">
                                    </div>
                                </div>
                                <input type='hidden' name='role' value="employeur" />
                                <input type="hidden" name="action" value="employeurPublierOffreStage">            
                                <br><input class="btn btn-primary" type="submit" value="Publier"/>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
    </body>
</html>
