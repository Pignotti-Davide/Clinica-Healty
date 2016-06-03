<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paziente inserito</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
<body>
<h4>
		<center>Inserimento Paziente</center>
	</h4>
	<center>
		Hai inserito un nuovo Paziente <br> Nome:${paziente.nome}; <br> Cognome:${paziente.cognome}; <br>
		Si prega di comunicare al paziente il suo identificatore: ${paziente.idPaziente}; <br><br> <br>
		<a href="protected/homeAdmin">Torna alla Pagina d'amministrazione</a><br>
		<a href="index">Torna alla HomePage</a>
		</center>
</body>
</html>