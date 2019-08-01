<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvendio a Cineapp</title>
</head>
<body>
    <h1>Lista de pel�culas</h1>
    <ol>
       <c:forEach items="${peliculas}" var="pelicula">
           <li>${pelicula}</li>
       </c:forEach>
    </ol>

    Tabla de pel�culas
    <table border="1">
       <thead>
           <tr>
               <th>Id</th>
               <th>T�tulo</th>
               <th>Duraci�n</th>
               <th>Clasificaci�n</th>
               <th>G�nero</th>
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
</body>
</html>