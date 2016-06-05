<%@page import="org.springframework.ui.Model"%>
<%@page import="clinica.dao.impl.EsameDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="clinica.model.Esame"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Risultati</title>
</head>
<body>
	Seleziona l'esame di cui inserire i risultati tramite il suo codice:

	<form:form method="post" action="mostraEsame" name="form">
		<select name="esame">
			<c:forEach items="${esami}" var="esame">
				<option value="${esame.idEsame}">${esame.idEsame}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Mostra esame" />
	</form:form>

	Tipologia esame: ${esame.tipologia}
	<br> "Medico: ${esame.medico.nome} ${esame.medico.cognome}
	<br> "Paziente: ${esame.paziente.nome} ${esame.paziente.cognome}
	<br>
	<c:forEach items="${esame.risultati}" var="risultato">
			<div> ${risultato.key}: <input type='text' name='risultato" + i + "' size='10' /></div> <br>
			</c:forEach>
	
		

	<span id='box_esame'> </span>
</body>
</html>