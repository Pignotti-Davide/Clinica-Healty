
<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page import="clinica.model.TipologiaEsame"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html>
<head>
<meta charset="utf-8">

<title>Clinica Healthy - lista esami</title>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">
	 <style type="text/css">
	 body { 
    background-image: url('./resources/Grafica/background.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: right;
}
	   </style>
</head>
<body>
<%-- <body background="<c:url value="/resources/Grafica/sfondo2.jpg"/>"> --%>
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
	<center><img src="<c:url value="/resources/Grafica/logo3.jpg"/>"></center>
	<h4>
		<center>Consulta il nostro catalogo</center>
	</h4>
	<center>
		<script type="text/javascript" language="javascript">
function visualizza(id){
  if (document.getElementById){
    if(document.getElementById(id).style.display == 'none'){
      document.getElementById(id).style.display = 'block';
    }else{
      document.getElementById(id).style.display = 'none';
    }
  }
}
</script>
<c:forEach items="${lista}" var="tipo" varStatus="status">
      <div id="testo">	
		<b><u></u></b>
			<a href="<c:url value="#" />" onclick="visualizza('immagine${status.index}');">
				<b><u>Nome </u></b>:${tipo.nome}	<b><u>Descrizione</u></b> ${tipo.descrizione}<br>			
			</a>
			
		</div>		
		<div id="immagine${status.index}" style="display: none">
		<c:if test="${empty requisito}">
   <p><c:out value="Nessun Requisito"/><p>
   </c:if>
	<c:forEach items="${tipo.requisiti}" var="requisito" varStatus="status">
	
						  <td><u>Nome requisito</u>: ${requisito.key}</td>
               <td><u> Descrizione requisito</u>:${requisito.value}</td><br>
							<tr>
							</c:forEach>
							<c:forEach items="${tipo.indicatoriRisultati}" var="risultato" varStatus="status">
						  <td><u>Tipo di risultato</u>: ${risultato}</td><br>
  
							<tr>
							</c:forEach></div>
							   <hr  size=”60″ width=”100″ color=”green” noshade>
</c:forEach>
		  
		<h4><a href="index.html">Torna alla homepage</a>
			</h4>
		<table>
				<tr>
			
		</tr>
		</table>
		
		<br>

	
</body>
</html>
