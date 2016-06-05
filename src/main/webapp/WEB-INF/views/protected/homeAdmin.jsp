
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>




<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Area amministrazione</title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">
</head>
<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">

<body>
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
    </nav>
	<h4>
		<center>Area riservata all'amministrazione</center>
	</h4>
	<center>
		Ciao, ${pageContext.request.userPrincipal.name} <a
			href="<c:url value="/j_spring_security_logout" />"> Logout</a> <br>Ecco
		ci� che puoi fare: <br>
			<img src="<c:url value="/resources/Grafica/inseriscipaziente.png"/>"
				usemap="#link1">
			<map name="link1" id="link1">
				<area shape="rect" coords="180, 100, 80, 200" href="nuovoPaziente"
					alt="click">
			</map>
			<img src="<c:url value="/resources/Grafica/inseriscimedico.png"/>"
				usemap="#link2">
			<map name="link2" id="link2">
				<area shape="rect" coords="180, 100, 80, 200" href="nuovoMedico"
					alt="click">
			</map>
			<br> <img
				src="<c:url value="/resources/Grafica/inserisciesame.png"/>"
				usemap="#link3">
			<map name="link3" id="link3">
				<area shape="rect" coords="180, 100, 80, 200" href="nuovoEsame"
					alt="click">
			</map>
			<img src="<c:url value="/resources/Grafica/inseriscitipologia.png"/>"
				usemap="#link4">
			<map name="link4" id="link4">
				<area shape="rect" coords="180, 100, 80, 200"
					href="nuovaTipologiaEsame" alt="click">
			</map>
			<br>
			<a href="inserisciRisultati">Inserisci risultati</a>
			<a href="index">Torna alla homepage</a>
		</center>
</body>
</html>