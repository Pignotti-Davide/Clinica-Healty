<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
<body>
	<img src="<c:url value="/resources/Grafica/logo3.png"/>">

	<center>
		<h4>Aggiungi un nuovo paziente</h4>

		<form:form method="post" action="addPaziente" modelAttribute="paziente" name="form">
			<font size="3" color="red">${nomeError}</font> <br> <br>
			<tr>
				<td>Nome Paziente :</td>
				<td><form:input type="text" path="nome" placeholder="nome" /></td>
			</tr>
			<font size="3" color="red">${cognomeError}</font> <br>
			<tr>
				<td>Cognome Paziente :</td>
				<td><form:input type="text" path="cognome"
					placeholder="cognome" /></td>	
			</tr>
			<br> <input type="submit" value="invia" />
		</form:form>
		<br>
		<a href="index">Torna alla homepage</a>
	</center>
</body>
</html>