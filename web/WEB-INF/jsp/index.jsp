<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/estilos.css" rel="stylesheet"  type="text/css"/>
        <title>Votaciones</title>
    </head>
    <body>
        <div id="titulo">Votaciones</div>
        <form:form  commandName="votante" method="POST">
            <table>
                <tr>
                    <td>DNI</td>
                    <td><form:input path="dni" size="9" maxlength="9" /></td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td>
                        <form:password type="password" name="pass" size="9" path="pass" />
                    </td>
                </tr>

            </table>
            <br><br>
            <input type="submit" value="Alta Votante"  name="insertar">
            <input type="button" value="Baja Votante" name="baja" >
            <input type="button" value="Votar" name="votar">
            <input type="button" value="Escrutar" name="escrutar">
            <input type="button"  value="Comprobar Censo" name="censo" onclick="location.href = 'censo.htm'">
        </form:form>
    </body>
</html>
