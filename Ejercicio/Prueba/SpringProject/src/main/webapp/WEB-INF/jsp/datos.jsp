<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="alumno" items="${alumnos}">
            <h2>${alumno.nombre_alumno}</h2>
        </c:forEach>
    </body>
</html>
