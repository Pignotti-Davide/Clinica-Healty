<%@ page import="clinica.model.Utente"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% Utente utente = (Utente)session.getAttribute("utente");
    boolean autorizzato = true;
    if (utente!=null) 	 
    	response.sendRedirect("index");
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Accedi all'area amministratore</title>
  <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
<img src="<c:url value="/resources/Grafica/logo3.png"/>">

<body>

	<h4>
		<center>Accedi all'area amministrazione</center>
	</h4>
	<center>
		Effettua il login con i tuoi dati amministrazione
		
		<form:form action="logUtente" modelAttribute="utente" method="POST">

			<div class="form-group">
				<p>${usernameError}</p>
				<label>Username</label><form:input type="text" path="username" />
			</div>
			<div class="form-group">
				<p>${passwordError}</p>
				<label>Password</label><form:input type="password" path="password" />
			</div>

			<button type="submit" class="btn btn-default">Invia</button>
		</form:form>
		<center>
</body>
</html>