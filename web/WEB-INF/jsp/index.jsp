<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votaciones</title>
    </head>
    <body>
        <div id="titulo">Votaciones</div>
        <form action="ServletController" method="POST">
            <table>
                <tr>
                    <td>DNI</td><td><input type="text" name="nif" maxlength="9" size="9"></td>
                </tr>
                <tr>
                    <td>Clave</td><td><input type="password" name="pass" size="9"></td>
                </tr>

            </table>
            <br><br>
            <input type="submit" value="Alta Votante"  name="insertar">
            <input type="submit" value="Baja Votante" name="baja" >
            <input type="submit" value="Votar" name="votar">
            <input type="submit" value="Escrutar" name="escrutar">
            <input type="button"  value="Comprobar Censo" name="censo" onclick="location.href = 'censo.htm'">
        </form>
    </body>
</html>
