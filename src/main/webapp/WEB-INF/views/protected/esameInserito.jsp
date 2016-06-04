<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Amministrazione -Esame inserito</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
<body>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="admin">Area Amministrazione:</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                    <li>
                       <a class="navbar-brand" style="color:red"> ${pageContext.request.userPrincipal.name}</a>
                    </li>

                    <li>
                      
                    </li>
                    <li>
               
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
<h4>
		<center>Inserimento Paziente</center>
	</h4>
	<center>
		Hai inserito un nuovo Esame <br> Paziente:${esame.paziente.getCognome()} {esame.paziente.getNome()} <br>
		 Tipologia:${esame.tipologia.nome}<br>
		Medico: ${esame.medico.cognome} ${esame.medico.nome}<br>
		Data di prenotazione:${esame.prenotazione}<br>
		Data in cui si svolgerà l'esame:${esame.esecuzioneEsame}<br>
		<a href="protected/homeAdmin">Torna alla Pagina d'amministrazione</a><br>
		<a href="index">Torna alla HomePage</a>
		</center>
</body>
</html>