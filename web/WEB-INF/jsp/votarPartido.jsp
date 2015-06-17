<%-- 
    Document   : votarPartido
    Created on : 16-jun-2015, 20:53:49
    Author     : Ruben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elige partdio</title>
    </head>
    <body style="text-align: center;">
        <spring:nestedPath path="partido">
            <form action="" method="POST">
                <h1>Elige partido</h1>
                <spring:bind path="nombre">
                    <input type="radio" name="${status.expression}" value="pp"><img src="${pageContext.request.contextPath}/WEB-INF/resources/images/pp.jpg" width="50" height="50" alt="pp" ><br>
                    <input type="radio" name="${status.expression}" value="psoe"><img src="../images/psoe.jpg" width="50" height="50" alt="psoe"><br>
                    <input type="radio" name="${status.expression}" value="ciutadans"><img src="../images/ciutadans.jpg" width="50" height="50" alt="ciudadanos"><br>
                    <input type="radio" name="${status.expression}" value="upd"><img src="../images/upd.jpg" width="50" height="50" alt="upd"><br><br>
                </spring:bind>
                <input type="Submit" value="Votar" name="votar">
            </form>
        </spring:nestedPath>
    </body>
</html>
