<%-- 
    Document   : censo
    Created on : 06-jun-2015, 17:33:44
    Author     : Ruben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Censo</h1>
        <table>
            <tr>
                <th>NIF</th>
                <th>¿Votado?</th>
            </tr>
            <c:forEach items="${censo}" var="votante">
                <tr>
                    <td>${votante.nif}</td>
                    <td>${votante.votado}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.htm">Volver al inicio</a>
    </body>
</html>
