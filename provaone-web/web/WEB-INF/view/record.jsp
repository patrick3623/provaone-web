<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<l:layout title="Registros de Ponto">
	<jsp:body>
	<!--FORM-->
		<div class="row">
			<h4>Formulário</h4>
			<form class="col s12" method="POST" action="registros">
				<div class="row">
					<div class="input-field col s6">
						<input type="text" disabled name="id" value="${form.id}" />
						<label for="id" class="active">id</label>
					</div>
					<div class="input-field col s6">
						<input type="time" name="date" value="${form.date}" required />
						<label for="date" class="active">Data</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="note" value="${form.note}" required />
							<label for="note" class="active">Notas</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<select class="browser-default" name="id_user" required>
							<option value="" disabled selected>Escolha de
								Usuário</option>
							<c:forEach var="user" items="${users}">
								<option value="${user.id}"
									${user.id == form.getUser().id ? 'selected="selected"' : ''}>
									${user.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<button class="btn waves-effect waves-light" type="submit"
							name="action">
							ENVIAR <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</form>
		</div>
		<!--/FORM-->
		<!--RESULTS-->
		<div class="row">
			<h2>${error}</h2>
			<h4>Registros de Ponto</h4>
			<table>
				<tr>
					<th>Id</th>
					<th>Data</th>
					<th>Nota</th>
					<th>Usuário</th>
					<th>EDITAR</th>
					<th>EXCLUIR</th>
				</tr>
				<c:forEach var="record" items="${records}">
					<tr>
						<td>${record.id}</td>
						<td>${record.date}</td>
						<td>${record.note}</td>
						<td>${record.getUser().id}</td>
						<td><a class="waves-effect waves-light btn"
							href="usuarios?action=editar&id=${user.id}"><i
								class="material-icons left">edit</i>EDITAR</a></td>
						<td><a class="waves-effect waves-light btn red"
							href="usuarios?action=excluir&id=${user.id}"><i
								class="material-icons left">delete</i>EXCLUIR</a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
		</div>
	<!--/RESULTS-->
	</jsp:body>
</l:layout>