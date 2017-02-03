

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio</title>
    </head>
    <body>
        Crear libro
        <form action="/SpringProject/creaLibro" method="POST">
            nombre
            <input type="text" id="nombre" name ="nombre"/>
            paginas
            <input type="text" id="nombre" name ="paginas"/>
            id biblioteca
            <input type="text" id="nombre" name ="biblioteca_id"/>
            id autor
            <input type="text" id="nombre" name ="autor_id"/>
            <input type="submit" value="Ingresar"/>
        </form>
        editar libro
        <form action="/SpringProject/editarLibro" method="POST">
            id Libro
            <input type="text" id="nombre" name ="idlibro"/>
            nombre
            <input type="text" id="nombre" name ="nombre"/>
            paginas
            <input type="text" id="nombre" name ="paginas"/>
            id biblioteca
            <input type="text" id="nombre" name ="biblioteca_id"/>
            id autor
            <input type="text" id="nombre" name ="autor_id"/>
            <input type="submit" value="Ingresar"/>
        </form>
        Crear Biblioteca
        <form action="/SpringProject/creaBiblioteca" method="POST">
            nombre
            <input type="text" id="nombre" name ="nombre"/>
            <input type="submit" value="Ingresar"/>
        </form>

        Ediar Biblioteca
        <form action="/SpringProject/editarBiblioteca" method="POST">
            id
            <input type="text" id="nombre" name ="id"/>
            nombre
            <input type="text" id="nombre" name ="nombre"/>
            <input type="submit" value="Ingresar"/>
        </form>
        

        crear Libro con bilioteca
        <form action="/SpringProject/crearLibroConBiblioteca" method="POST">
            id libro
            <input type="text" id="nombre" name ="idLibro"/>
            nombre libro
            <input type="text" id="nombre" name ="nombreLibro"/>
            paginas libro
            <input type="text" id="nombre" name ="pagiansLibro"/>
            id autor
            <input type="text" id="nombre" name ="idAutor"/>
          
            id Biblioteca
            <input type="text" id="nombre" name ="idBiblioteca"/>
            <input type="submit" value="Ingresar"/>
        </form>
        -Mostrar libros de el id de una biblioteca
        <form action="/SpringProject/" method="POST">
            id lector
            <input type="text" id="nombre" name ="idBiblioteca"/>
            <input type="submit" value="Ingresar"/>
        </form>
        -registrar comentario de un lector de un libro
        <form action="/SpringProject/" method="POST">
            id lector
            <input type="text" id="nombre" name ="idLecot"/>
            id libro
            <input type="text" id="nombre" name ="idLibro"/>
            comentario
            <input type="text" id="nombre" name ="comentario"/>
            
            <input type="submit" value="Ingresar"/>
        </form>

        

        -Mostrar libros que  leido un lecotr
        <form action="/SpringProject/" method="POST">
            id lector
            <input type="text" id="nombre" name ="idLector"/>
            <input type="submit" value="Ingresar"/>
        </form>


    </body>
</html>
