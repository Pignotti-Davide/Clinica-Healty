<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>	Area amministrazione </title>
</head>
 <style type="text/css">
	 body { 
    background-image: url('./resources/Grafica/background.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: right;
}
	   </style>
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
 <center><img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
          
	<center><h4>Informazioni relative al medico</h4>

				Hai richiesto informazioni su ${medico.nome} ${medico.cognome}<br/>
				Lista dei suoi esami <br>
				  <c:forEach items="${lista}" var="esame"  varStatus="status">
                <b>Id Esame</b>: ${esame.idEsame}<br>
                	<b>TipologiaEsame</b> : ${esame.tipologia} <br>
                	<b>Paziente Esame<b>: ${esame.paziente }<br/>

            	<hr  size=”4″ width=”200″ color=”green” noshade>
         </c:forEach>
		
		 </td></tr></table>
	
<h4><a href="admin">Torna alla Pagina d'amministrazione</a><br>
		<a href="index">Torna alla HomePage</a>
</body>
</html>