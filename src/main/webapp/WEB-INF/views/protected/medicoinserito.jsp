
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page import="clinica.model.TipologiaEsame"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Medico inserito</title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">
</head>

<body>
	<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">

	<h4>
		<center>Inserimento medico</center>
	</h4>
	<center>
		Hai inserito un nuovo medico <br> Nome:${medico.nome}; <br>
		Cognome:${medico.cognome}; <br>
		Specializzazione:${medico.specializzazione}; <br> <br> <br>
		<a href="protected/homeAdmin">Torna alla Pagina d'amministrazione</a>
		<a href="index">Torna alla HomePage</a>
		<center>
</body>
</html>
