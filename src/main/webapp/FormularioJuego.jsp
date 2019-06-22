<%-- 
    Document   : FormularioJuego
    Author     : tvaras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ingresar Juego</title>
	<link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Ingreso de Juegos</h1>
			<p class="lead">Actualiza tu cat&aacute;logo de juegos que
				quieras intercambiar.</p>
		</div>
	</div>
	<div class="container">
		<form action="ingresar-juego.html" method="post">
			<div class="form-group">
				<label for="txtNombreJuego">Nombre del Juego</label>
				<input type="text" class="form-control form-control-sm" name="juego.nombre" id="txtNombreJuego" placeholder="MORTAL KOMBAT 10" maxlength="100" required="required" >
			</div>
			<div class="form-group">
				<label for="cbConsola">Consola</label>
				<select class="form-control form-control-sm" id="cbConsola" name="juego.consola.id">
					<option>-- SELECCIONAR --</option>
				<c:forEach items="${listaConsola}" var="e"> 
				    <option value="${e.id}">${e.descripcion}</option>
				</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="cbTiempoUso">Tiempo de uso</label>
				<select class="form-control form-control-sm" id="cbTiempoUso" name="juego.tiempoUso.id">
					<option>-- SELECCIONAR --</option>
				<c:forEach items="${listaTiempoUso}" var="e"> 
				    <option value="${e.id}">${e.descripcion}</option>
				</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="cbEstado">Estado</label>
				<select class="form-control form-control-sm" id="cbEstado" name="juego.estadoJuego.id">
					<option>-- SELECCIONAR --</option>
				<c:forEach items="${listaEstadoJuego}" var="e"> 
				    <option value="${e.id}">${e.descripcion}</option>
				</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="taComentarios">Comentarios</label>
				<textarea class="form-control form-control-sm" id="taComentarios" maxlength="500" name="juego.comentario" 
				required="required" placeholder="Juego muy entretenido y sin detalle alguno"
					rows="3"></textarea>
			</div>
			<c:if test="${mensajeStatus != null}">
				<div class="alert alert-${mensajeStatus}" role="alert">
			  		${mensaje}
				</div>
				<% 
					request.removeAttribute("mensaje");
					request.removeAttribute("mensajeStatus");
				%>
			</c:if>
  			<button type="submit" class="btn btn-primary small">Registrar Juego</button>
		</form>
		<div class="top-buffer">
		</div>
		<div class="row">
			<table class="table table-sm">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Nombre</th>
			      <th scope="col">Consola</th>
			      <th scope="col">Tiempo Uso</th>
			      <th scope="col">Estado</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${listaJuego}" var="e"> 
			    <tr>
			      <th scope="row">${e.id}</th>
			      <td>${e.nombre}</td>
			      <td>${e.consola.descripcion}</td>
			      <td>${e.tiempoUso.descripcion}</td>
			      <td>${e.estadoJuego.descripcion}</td>
			    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
		<jsp:include page="MenuPie.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>