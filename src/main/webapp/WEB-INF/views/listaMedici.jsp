
<%@page import="java.util.ArrayList"%>
<%@ page import="clinica.model.Medico"%>
<%@ page import="clinica.dao.impl.MedicoDao"%>
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
	<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">

	<h4>
		<center>Consulta l'elenco dei nostri medici</center>
	</h4>
	<center>
		<% 	
						for(Medico tipo: new ArrayList<Medico>()){
							out.print("Nome:"); 
							out.print(tipo.getNome());
							out.print("<br>");
							out.print("Cognome:"); 
							out.print(tipo.getCognome());
							out.print("<br>"); 
							out.print("Specializzazione:"); 
							out.print(tipo.getSpecializzazione());
							out.print("<br>"); 
							out.print("------------------------------");
							out.print("<br>"); 
							}%>
							  <h4><a href="index.html">Torna alla homepage</a>
                                </h4>
		<tr>
		</tr>
		<br>
		<center>
</body>
</html>
