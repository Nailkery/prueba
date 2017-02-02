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
        Crear Biblioteca
        <form action="/SpringProject/admin/creaBiblioteca" method="POST">
            <input type="text" id="nombre" name ="nombre"/>
            <input type="submit" value="Ingresar"/>
        </form>
        Crear un libro
        <form action="/SpringProject/admin/creaLibro" method="POST">
            <input type="text" id="nombre" name ="nombre"/>
            <input type="text" id="paginas" name="paginas"/>
            <input type="text" id="biblioteca_id" name ="biblioteca_id"/>
            <input type="text" id="autor_id" name ="autor_id"/>
            <input type="submit" value="Ingresar"/>
        </form>
        Crear un autor
        <form action="/SpringProject/admin/creaAutor" method="POST">
            <input type="text" id="nombre" name ="nombre"/>
            <input type="text" id="edad" name="edad"/>
            <input type="submit" value="Ingresar"/>
        </form>
    </body>
</html>
