
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="clinica.model.TipologiaEsame"%>
<%@ page import="clinica.model.Paziente"%>
<%@ page import="clinica.model.Medico"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiungi nuovo esame</title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
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
	<!-- /.container --> </nav>
	<center>
		<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
		<h4>Clinica Healthy - Area amministrazione</h4>

		<form:form method="post" action="addEsame" modelAttribute="esame"
			name="form">
		Tipologia
			<form:select path="tipologia">
				<form:options items="${tipologieEsami}" itemLabel="nome"
					itemValue="idTipologiaEsame" />
			</form:select><br>
			Medico:
			<form:select path="medico">
				<form:options items="${medici}" itemLabel="nome"
					itemValue="idMedico" />
			</form:select><br>
			Paziente:
			<form:select path="paziente">
				<form:options items="${pazienti}" itemLabel="nome"
					itemValue="idPaziente" />
			</form:select><br>
			Inserisci la data e l'ora: (Importante: inserisci la data nel seguente formato: dd/MM/yyyy HH:mm)
<form:input path="esecuzioneEsame" type="datetime-local" /><br>
	<input type="submit" value="Invia" />
			<input type="submit" value="Invia" />
		</form:form>
		<br> <a href="index">Torna alla homepage</a>
	</center>
</body>
</html>