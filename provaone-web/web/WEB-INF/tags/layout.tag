<%@tag description="Layout" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="title"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="assets/css/template.css"/>
<link type="text/css" rel="stylesheet"
	href="assets/css/materialize.min.css" media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>${title}</title>
</head>
<body>
	<!--NAV-->
	<nav>
		<div class="nav-wrapper yellow darken-3">
			<a href="/provaone-web" class="brand-logo">Meu Ponto</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="usuarios">Usuários</a></li>
				<li><a href="niveisdeacesso">Niveis De Acesso</a></li>
				<li><a href="registros">Registros De Ponto</a></li>
				<c:if test="${isLoggedIn}">
							<li><a href="logout">Sair</a></li>
							</c:if>
							<c:if test="${!isLoggedIn}">
							<li><a href="login">Entrar</a></li>
							</c:if>
			</ul>
		</div>
	</nav>
	<!--/NAV-->
	<main id="content" class="container"> <jsp:doBody /> </main>
	<!--FOOTER-->
	<footer class="page-footer yellow darken-3">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">Meu Ponto</h5>
					<p class="grey-text text-lighten-4">Sistema de Gerenciamento de
						Ponto Eletrônico.</p>
				</div>
				<div class="col l4 offset-l2 s12">
					<h5 class="white-text">Páginas</h5>
					<ul>
						<li><a class="grey-text text-lighten-3" href="usuarios">Usuários</a></li>
						<li><a class="grey-text text-lighten-3" href="niveisdeacesso">Niíveis
								de Acesso</a></li>
						<li><a class="grey-text text-lighten-3" href="registros">Registros</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">
				© 2018 Copyright <a class="grey-text text-lighten-4"
					href="https://www.patrickweb.tk/">Patrick Ferro Ribeiro</a>

			</div>
		</div>
	</footer>
	<!--/FOOTER-->
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="assets/js/materialize.min.js"></script>
</body>
</html>