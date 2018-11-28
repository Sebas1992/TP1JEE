<%-- 
    Document   : coordDocuments
    Created on : 2018-11-22, 19:38:14
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
        <h1>Uploader fichier</h1>
        <c:out value="${message}" />
        <form action="coordonnateurUploadFile" method="POST" enctype='multipart/form-data'>
            <input type="hidden" name="action" value="coordonnateurUploadFile" />
            <input type="file" name="fichier" />
            <input type="submit" value="Upload" />
        </form>
    </body>
</html>
