<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot" />
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${urlRoot}">My CineSite</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <sec:authorize access="isAnonymous()">
            <li><a href="#">Acerca</a></li>
            <li><a href="${urlRoot}login">Login</a></li>
        </sec:authorize>
        <sec:authorize access="hasAnyAuthority('EDITOR')">
            <li><a href="${urlRoot}peliculas/index">Películas</a></li>
            <li><a href="${urlRoot}logout">Salir</a></li>
        </sec:authorize>
        <sec:authorize access="hasAnyAuthority('GERENTE')">
            <li><a href="${urlRoot}peliculas/index">Películas</a></li>
            <li><a href="${urlRoot}banners/index">Banners</a></li>
            <li><a href="${urlRoot}logout">Salir</a></li>
        </sec:authorize>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>
