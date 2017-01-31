<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IS2</title>
        <script src=" <c:url value="/js/jquery-1.12.3.min.js" /> "></script>
    </head>
    <body>
        <h1>Ejemplo Spring + JDBC + Hibernate</h1>
        <hr>
        <form method="POST" action="/SpringProject/muestraGrupos">
            <h2>Ingresa id del Profesor para ver sus grupos</h2>
            <input id="id_profesor" name="id_profesor" type="text" placeholder=" Id Profesor">
            <button>Aceptar</button>
        </form>
        <br><hr>
    
        <h2>Ingresa los datos del nuevo profesor</h2>
        <form:form method="POST" action="/SpringProject/registroProfesor">
            <form:input path="nombre_profesor" type="text" id="nombre_profesor" placeholder=" Nombre"/>
            <form:input path="tipo_profesor" type="text" id="tipo_profesor" placeholder=" Tipo"/>
            <button type="submit">Registrar Profesor</button>
        </form:form>
        <br><hr>
        
        <h2>Ingresa el nombre del profesor a eliminar</h2>
        <form method="POST" action="/SpringProject/eliminarProfesor">    
            <input id="eliminar_nombre_profesor" name="eliminar_nombre_profesor" type="text" placeholder=" Nombre Profesor">
            <button>Eliminar</button>
        </form>
        <br><hr>
         
        <h2>Ingresa el id del grupo y el nuevo nombre</h2>
        <form method="POST" action="/SpringProject/modificarNombre">    
               <input id="id_grupo" name="id_grupo" type="text" placeholder=" Id Grupo">
               <input id="nombre_grupo" name="nombre_grupo" type="text" placeholder=" Nombre Grupo">
               <button>Modificar</button>
        </form>
        <br><hr>
         
         
        </body>
</html>
