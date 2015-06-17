<%-- 
    Document   : escrutinio
    Created on : 18-jun-2015, 0:01:22
    Author     : Manuel Vinuesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css"><%@ include file="../resources/css/estilos.css" %> </style>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Escrutinio</h1>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Nº votos</th>
            </tr>
            <c:forEach items="${escrutinio}" var="partido">
                <tr>
                    <td>${partido.nombre}</td>
                    <td>${partido.votos}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.htm">Volver al inicio</a>
    </body>
</html>