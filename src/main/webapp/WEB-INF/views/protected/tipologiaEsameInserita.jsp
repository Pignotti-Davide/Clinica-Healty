<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Amministrazione - Tipologia Esame inserita</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
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
    </nav>
<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
<body>
	<h4>
		<center>Inserimento tipologia</center>
	</h4>
	<center>
		Hai inserito una nuova tipologia d'esame <br>
		Nome:${tipologiaEsame.nome}; <br>
		<tr>
		<td>Decrizione: ${tipologiaEsame.descrizione}</td><br>
		<td>Lista Tipologia Risultati: </td><br>
		  <c:forEach items="${tipologiaEsame.indicatoriRisultati}" var="indicatoriRisultati" 
           varStatus="status">
           <tr> 
                <td>Tipi risultati: ${indicatoriRisultati}<br></td>
            </tr> 
         </c:forEach>
         <td>Lista Requisiti: </td><br>
	  <c:forEach items="${tipologiaEsame.requisiti}" var="requisiti" 
        varStatus="status">
           <tr>
                 <td>Nome requisito: ${requisiti.key}:</td>
               <td>Descrizione requisito:${requisiti.value}</td>
            </tr> 
          </c:forEach>
		<a href="${pageContext.request.contextPath}/eliminaTipologiaEsame/${tipologiaEsame.idTipologiaEsame}">Cancella La Tipologia D'esame</a><br><br>
		<a href="admin">Torna alla Pagina d'amministrazione</a><br><br>
		<a href="index">Torna alla HomePage</a>
							
		<center>
</body>
</html>
