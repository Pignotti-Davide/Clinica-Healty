
<%@page import="java.util.ArrayList"%>
<%@ page import="clinica.model.Medico"%>
<%@ page import="clinica.dao.impl.MedicoDaoImpl"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - lista medici</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
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
	<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">

	<h4>
		<center>Consulta l'elenco dei nostri medici</center>
	</h4>
	<center>
	<c:forEach items="${lista}" var="med" varStatus="status">
      <div id="testo">	
      	Nome : ${med.nome}<br>
      	Cognome: ${med.cognome}<br>
      	Specializzazione: ${med.specializzazione}
      	<hr  size=”1″ width=”200″ color=”green” noshade>
      </c:forEach>
							  <h4><a href="index.html">Torna alla homepage</a>
                                </h4>
		<tr>
		</tr>
		<br>
		<center>
</body>
</html>
