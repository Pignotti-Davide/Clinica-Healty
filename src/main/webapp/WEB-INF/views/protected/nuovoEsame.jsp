<%@page import="clinica.service.impl.*"%>
<%@page import="clinica.model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci nuovo esame</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
<body>
<img src="<c:url value="/resources/Grafica/logo3.png"/>">
<center><h4>Aggiungi un nuovo esame</h4>
<	<form:form action="nuovoEsame" modelAttribute="esame" method="POST">

			<div class="form-group">
				<p>${usernameError}</p>
				<label>Nome:</label> <form:input type="text" path="username" />
			</div>
			<div class="form-group">
				<p>${passwordError}</p>
				<label>Password</label><form:input type="password" path="password" />
			</div>

			<button type="submit" class="btn btn-default">Invia</button>
		</form:form>
Seleziona Tipologia d'esame:
<select name="tipologiaEsame">
<%-- <% for(TipologiaEsame t:new FacadeDati().findAllTipologieEsami()) --%>
<%-- 	out.print( "<option value="+t.getIdTipologiaEsame()+">"+t.getNome()+"</option>");%> --%>
<!-- </select><br> -->
<!-- Seleziona Paziente: -->
<!-- <select name="paziente"> -->
<%-- <% for(Paziente p:new FacadeDati().findAllPazienti()) --%>
<%-- 	out.print( "<option value="+p.getIdPaziente()+">"+p.getNome()+" "+p.getCognome()+"</option>");%> --%>
<!-- </select><br> -->
<!-- Seleziona Medico: -->
<!-- <select name="medico"> -->
<%-- <% for(Medico m:new FacadeDati().findAllMedici()) --%>
<%-- 	out.print( "<option value="+m.getIdMedico()+">"+m.getNome()+" "+m.getCognome()+"</option>");%> --%>
<!-- </select><br> -->
Seleziona la data dell'esame:
<input name="dataPerL'esame" type="datetime" />
	<input type="submit" value="invia" />
	</form>
 <br><a href="index.html">Torna alla homepage</a></center>
</body>
</html>