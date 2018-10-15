<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<l:layout title="Usuários">
	<jsp:body>
		<!--FORM-->
		<div class="row">
			<h4>Formulário</h4>
			<form class="col s12" method="POST" action="usuarios">
				<div class="row">
					<div class="input-field col s6">
						<input type="text" disabled name="id" value="${form.id}" />
						<label for="id" class="active">Id</label>
					</div>
					<div class="input-field col s6">
						<input type="text" name="name" value="${form.name}" required />
						<label for="name" class="active">Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="text" name="email" value="${form.email}"
							required />
							<label for="email" class="active">Email</label>
					</div>
					<div class="input-field col s6">
						<input type="password" name="password"
							value="${form.password}" required />
							<label for="password" class="active">Senha</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<select class="browser-default" name="id_acess" required>
							<option value="" disabled selected>Escolha o tipo de
								Usuário</option>
							<c:forEach var="acess" items="${acesses}">
								<option value="${acess.id}"
									${acess.id == form.getAcess().id ? 'selected="selected"' : ''}>
									${acess.name}</option>
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
			<h4>Usuários Cadastrados</h4>
			<table>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Email</th>
					<th>EDITAR</th>
					<th>EXCLUIR</th>
				</tr>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
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