<%-- 
    Document   : confirmacion
    Created on : 1/02/2017, 02:01:03 AM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio</title>
    </head>
    <body>
        <form action="/SpringProject/admin/creaBiblioteca" method="POST">
            <input type="text" id="nombre" name ="nombre"/>
            <input type="submit" value="Ingresar"/>
        </form>
        <a href="/admin/creaBiblioteca">Contact us</a>
    </body>
</html>
