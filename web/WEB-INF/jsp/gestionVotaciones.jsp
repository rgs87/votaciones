<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votaciones</title>
    </head>
    <body>
        <div id="titulo">Votaciones</div>
        <spring:nestedPath path="votante">
            <form  action="" method="POST" >
                <table>
                    <tr>
                        <td>DNI</td>
                        <td>
                            <spring:bind path="nif">
                                <input type="text" name="${status.expression}" value="${status.value}" size="9" maxlength="9">
                            </spring:bind>
                        </td>
                    </tr>
                    <tr>
                        <td>Clave</td>
                        <td>
                            <spring:bind path="password">
                                <input type="password" name="${status.expression}" value="${status.value}" size="9" >
                            </spring:bind>
                        </td>
                    </tr>

                </table>
                <br><br>
                <input type="submit" value="Alta Votante"  name="insertar">
                <input type="submit" value="Baja Votante" name="baja" >
                <input type="submit" value="Votar" name="votar">
                <input type="button" value="Escrutar" name="escrutar">
                <input type="button"  value="Comprobar Censo" name="censo" onclick="location.href = 'censo.htm'">
            </form>
        </spring:nestedPath>
    </body>
</html>

