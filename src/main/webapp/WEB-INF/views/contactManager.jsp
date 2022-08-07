<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenedor contactos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script type="text/javascript">
	var idSeleccionado = 0;
	function submitFormAction(action, method) {
		document.getElementById("frmAcciones").action = action;
		document.getElementById("frmAcciones").method = method;
		document.getElementById("frmAcciones").submit();
	}
	function setIdSeleccionado(id) {
		idSeleccionado = id;
	}
	function borrarFila() {
		window.location.href = "/contactManager/deleteContact/?id=" + idSeleccionado;
	}
</script>
</head>
<body>

	<form:form id="frmAcciones" modelAttribute="contactoVista"
		action="/addContact">
		<div class="container m-2">
			<fieldset>
				<legend>Mantenedor de Contactos</legend>
				<table class="table-light" border="1">
					<tr>
						<td>Nombre:</td>
						<td><input type="text" id="idNombre" name="nombre" /></td>
						<td>Apellido Paterno:</td>
						<td><input type="text" id="idApellidoPaterno"
							name="apellidoPaterno" /></td>
							<td>Apellido Materno:</td>
						<td><input type="text" id="idApellidoMaterno"
							name="apellidoMaterno" /></td>
					</tr>
					<tr>
						<td>Dirección:</td>
						<td><input type="text" id="idDireccion" name="direccion" /></td>
						<td>Teléfono:</td>
						<td><input type="text" id="idTelefono" name="telefono" /></td>
					</tr>
					<tr>
						<td colspan="4"><input type="button" class="btn btn-secondary" value="Buscar" /> <input
							type="button" class="btn btn-success" value="Agregar"
							onclick="submitFormAction('/contactManager/addContact', 'post')" />
							<input type="button" class="btn btn-danger" value="Eliminar" onclick="borrarFila()" /></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form:form>
	<br>
	<br>
	<!-- tabla que muestra listado de contactos -->
	<div class="container m-2">
	<legend>Lista de Contactos</legend>
		<table class="table table-bordered"   border="2">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Dirección</th>
					<th>Teléfono</th>
					<!--  <th></th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaContactos}" var="contactoTemp">
					<tr>

						<td>${contactoTemp.idContacto}</td>
						<td>${contactoTemp.nombre}</td>
						<td>${contactoTemp.apellidoPaterno}</td>
						<td>${contactoTemp.apellidoMaterno}</td>
						<td>${contactoTemp.direccion}</td>
						<td>${contactoTemp.telefono}</td>
						<td><input type="radio" name="optSelectRow"
							onclick="setIdSeleccionado(${contactoTemp.idContacto})" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>