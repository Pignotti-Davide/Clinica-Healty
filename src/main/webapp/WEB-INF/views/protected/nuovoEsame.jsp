
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
<script>
function processData(f1,f2,f3,f4,f5,f6){
	var v1 = document.getElementById(f1).value;
	var v2 = document.getElementById(f2).value;
	var v3 = document.getElementById(f3).value;
	var v4 = document.getElementById(f4).value;
	var v5 = document.getElementById(f5).value;
	var v6 = document.getElementById(f6).value;
	alert(v1+"\n"+v2+"\n"+v3+"\n"+v4+"\n"+v5+"\n"+v6);

}
</script>
    	 <style type="text/css">
	 body { 
    background-image: url('./resources/Grafica/background.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: right;
}
	   </style>
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
		<h4>Inserisci un nuovo esame</h4>

		<form:form method="post" action="addEsame" modelAttribute="esame"
			name="form">
		Tipologia:
			<form:select path="tipologia">
				<form:options items="${tipologieEsami}" itemLabel="nome"
					itemValue="idTipologiaEsame" />
			</form:select><br>
			Medico:
			<form:select path="medico">
				<form:options items="${medici}" itemLabel="idMedico"
					itemValue="idMedico" />
			</form:select><br>
			Paziente:
			<form:select path="paziente">
				<form:options items="${pazienti}" itemLabel="nome"
					itemValue="idPaziente" />
			</form:select><br>
			Inserisci la data:  
<input type="date" name="esecuzioneEsame" />	<td><font size="3" color="red">${dataError}</font></td><br>
	<input  type="submit" value="Invia" /><br>
		</form:form>
	<h4><a href="admin">Torna alla Pagina d'amministrazione</a><br>
		<a href="index">Torna alla HomePage</a>
	</center>
</body>
</html>