<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Medico inserito</title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
    	 <style type="text/css">
	 body { 
    background-image: url('./resources/Grafica/background.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: right;
}
	   </style>
<!-- Custom CSS -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="admin">Area Amministrazione:</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li><a class="navbar-brand" style="color: red">
							${pageContext.request.userPrincipal.name}</a></li>

					<li></li>
					<li></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<center><img src="<c:url value="/resources/Grafica/logo3.jpg"/>">

	<h4>
		<center>Inserimento medico</center>
	</h4>
	<center>
		Hai inserito un nuovo medico <br> <b>Nome</b>:${medico.nome} <br>
		<b>Cognome</b>:${medico.cognome} <br>
		<b>Specializzazione</b>:${medico.specializzazione} <br> <br> 
			<form:form method="post" action="eliminaMedico" name="form" modelAttribute="medico">
			<form:input type="hidden" path='idMedico'
							placeholder="id" /><br/>
		<input type="submit" value="Elimina" />	
		</form:form>
		<h4><a href="admin">Torna alla Pagina d'amministrazione</a><br>
		<a href="index">Torna alla HomePage</a>
		<center>
</body>
</html>
