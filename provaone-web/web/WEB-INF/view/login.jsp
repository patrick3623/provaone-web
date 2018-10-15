<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<l:layout title="Login">
	<jsp:body>
	<!--FORM-->
	<div class="row">
	<h4>Login</h4>
	<h4>${error}</h4>
	<c:if test="${isLoggedIn}">
	<a class="waves-effect waves-light btn"
							href="/provaone-web"><i
								class="material-icons left">keyboard_return</i>Página Inicial</a>
	</c:if>
	<c:if test="${!isLoggedIn}">
	<form action="login" method="POST">
			<div class="row">
				<div class="input-field col s12">
					<input id="email" type="email" name="email" />
					<label for="email" class="active">Email</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="password" type="password" name="password" />
					<label for="password" class="active">Senha</label>
				</div>
			</div>
			<div class="row">
					<div class="input-field col s6">
						<button class="btn waves-effect waves-light" type="submit"
						name="action">
							Login <i class="material-icons right">vpn_key</i>
						</button>
					</div>
					</div>
		</form>
		</c:if>
		</div>
	<!--FORM-->
	</jsp:body>
	</l:layout>