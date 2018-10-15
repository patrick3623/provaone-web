<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<l:layout title="Níveis De Acesso">
	<jsp:body>
	<!--FORM-->
	<div class="row">
			<h4>Formulário</h4>
			</div>
	<form method="POST" action="niveisdeacesso">
	<div class="row">
		<input type="text" disabled name="id" value="${form.id}"/>
		<label for="id" class="active">Id</label>
		</div>
		<div class="row">
		<div class="input-field col s6">
		<input type="text" name="name" value="${form.name}"/>
		<label for="name" class="active">Nome</label>
		</div>
		<div class="input-field col s6">
		<input type="text" name="level" value="${form.level}"/>
		<label for="level" class="active">Nível</label>
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
	<!--/FORM-->
	<!--RESULTS-->
	<div class="row">
	<h2>${error}</h2>
	<h4>Niveis de Acesso</h4>
	<table>
		<tr>
			<th>Id</th>
			<th>Tipo</th>
			<th>Nivel</th>
			<th>EDITAR</th>
			<th>EXCLUIR</th>
		</tr>
		<c:forEach var="acess" items="${accesses}">
		<tr>
			<td>${acess.id}</td>
			<td>${acess.name}</td>
			<td>${acess.level}</td>
			<td><a class="waves-effect waves-light btn"
						href="niveisdeacesso?action=editar&id=${acess.id}"><i
							class="material-icons left">edit</i>EDITAR</a></td>
						<td><a class="waves-effect waves-light btn red"
						href="niveisdeacesso?action=excluir&id=${acess.id}"><i
							class="material-icons left">delete</i>EXCLUIR</a></td>
		</tr>
		</c:forEach>
	</table>
	<br>
	</div>
	<!--/RESULTS-->
</jsp:body>
</l:layout>