<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvendio a Cineapp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
    <spring:url value="/resources" var="urlPublic"></spring:url>
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
                       <th>Imagen</th>
                       <th>Fecha de estreno</th>
                       <th>Estatus</th>
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
                       <th><img alt="${pelicula.imagen}" src="${urlPublic}/images/${pelicula.imagen}"></th>
                       <th><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd/MM/yyyy"/> </th>
                       <th>
                           <c:choose>
                              <c:when test="${pelicula.estatus == 'Activa'}">
                                  <span class="label label-success">ACTIVA</span>
                              </c:when>
                              <c:otherwise>
                                  <span class="label label-danger">INACTIVA</span>
                              </c:otherwise>
                           </c:choose>
                       </th>
                   </tr>
               </c:forEach>
               </tbody>
            </table>
        </div>
    </div>
</body>
</html>