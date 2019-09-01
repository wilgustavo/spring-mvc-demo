<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Peliculas</title>
    <spring:url value="/resources" var="urlPublic" />
    <spring:url value="/peliculas/index" var="urlPelicula" />
    <spring:url value="/peliculas/create" var="formPelicula" />
    <spring:url value="/peliculas/edit" var="urlEdit" />
    <spring:url value="/peliculas/delete" var="urlDelete" />
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

  </head>

  <body>

    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Peliculas</h3>

      <c:if test="${not empty mensaje}">
          <div class="alert alert-success" role="alert">${mensaje}</div>
      </c:if>

      <a href="${formPelicula}" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Titulo</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Fecha Estreno</th>
                <th>Estatus</th>
                <th>Opciones</th>
            </tr>
            <c:forEach items="${peliculas.content}" var="pelicula">
            <tr>
                <td>${pelicula.titulo}</td>
                <td>${pelicula.genero}</td>
                <td>${pelicula.clasificacion}</td>
                <td>${pelicula.duracion} min</td>
                <td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="yyyy-MM-dd" /></td>
                <td>
                  <c:choose>
                    <c:when test="${pelicula.estatus eq 'Activa'}">
                        <span class="label label-success">${pelicula.estatus}</span>
                    </c:when>
                    <c:otherwise>
                        <span class="label label-danger">${pelicula.estatus}</span>
                    </c:otherwise>
                  </c:choose>
                </td>
                <td>
                    <a href="${urlEdit}/${pelicula.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlDelete}/${pelicula.id}" onclick="return confirm('Estas seguro?')" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <nav aria-label="">
            <ul class="pager">
               <c:choose>
                  <c:when test="${peliculas.hasPrevious()}">
                    <li><a href="${urlPelicula}?page=${peliculas.number -1 }">Anterior</a></li>
                  </c:when>
                  <c:otherwise>
                    <li class="disabled"><a href="#">Anterior</a></li>
                  </c:otherwise>
               </c:choose>
               <c:choose>
                  <c:when test="${peliculas.hasNext()}">
                    <li><a href="${urlPelicula}?page=${peliculas.number + 1 }">Siguiente</a></li>
                  </c:when>
                  <c:otherwise>
                    <li class="disabled"><a href="#">Siguiente</a></li>
                  </c:otherwise>
               </c:choose>
            </ul>
        </nav>
      </div>

      <hr class="featurette-divider">


    <jsp:include page="../includes/footer.jsp"></jsp:include>


    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
