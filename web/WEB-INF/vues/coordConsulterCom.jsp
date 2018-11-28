<%-- 
    Document   : coordConsulterCom
    Created on : 2018-11-22, 19:18:56
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <%@include file="./menu.jsp" %>
        <br><br><br><br><br><br><br><br><br>
        <h1>Communications</h1>
        <div class="col-lg-12">
            <div class="table-responsive">          
                <table class="table table-striped">        
                    <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Message</th>
                            <th colspan="2">Expediteur</th>
                            <th colspan="2">Destinataire</th>
                        </tr>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.listeCom}" var="com">
                            <tr>
                                <td><c:out value="${com.titre}" /></td>
                                <td><c:out value="${com.message}" /></td>
                                <td><c:out value="${com.expediteur.nom}" /></td>
                                <td><c:out value="${com.expediteur.prenom}" /></td>
                                <td><c:out value="${com.destinataire.nom}" /></td>
                                <td><c:out value="${com.destinataire.prenom}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
