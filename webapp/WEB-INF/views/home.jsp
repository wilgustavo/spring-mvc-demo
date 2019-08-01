<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvendio a Cineapp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
    <div class="panel panel-default">
        <div class="panel-heading">Tabla de películas</div>
        <div class="panel-body">
            <table class="table table-striped table-bordered table-hover">
               <thead>
                   <tr>
                       <th>Id</th>
                       <th>Título</th>
                       <th>Duración</th>
                       <th>Clasificación</th>
                       <th>Género</th>
                   </tr>
               </thead>
               <tbody>
               <c:forEach items="${peliculas}" var="pelicula">
                   <tr>
                       <th>${pelicula.id}</th>
                       <th>${pelicula.titulo}</th>
                       <th>${pelicula.duracion}</th>
                       <th>${pelicula.clasificacion}</th>
                       <th>${pelicula.genero}</th>
                   </tr>
               </c:forEach>
               </tbody>
            </table>
        </div>
    </div>
</body>
</html>