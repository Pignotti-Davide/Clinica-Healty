<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Amministrazione - Tipologia Esame inserita</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
 <style type="text/css">
	 body { 
    background-image: url('./resources/Grafica/background.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: right;
}
	   </style>
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
<script>function AggiungiRequisito(requisiti){
 	var numero_requisiti = requisiti.value;
 	var box = document.getElementById('box_risultati');
	if(numero_requisiti==""){
		box.innerHTML='';
 	}else{
		if(isNaN(numero_requisiti)==true){
			box.innerHTML='';
 		}else{
			var righe = "";
			
			// Inserisco una riga ad ogni ciclo
			for(i=1; i<=numero_requisiti; i++){
				righe = righe + "Requisito n�"+i+${risultato}+
 				": <input type='text' name='requisito"+i+"' size='10' />"
				+
				"<br/>";
			}
			box.innerHTML=righe;
		}
	}
 }
 </script>
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

<body>
<center><img src="<c:url value="/resources/Grafica/logo3.jpg"/>"><br>
	<h4>Seleziona l'esame di cui inserire i risultati tramite il suo codice:</h4><br>

	<form:form method="post" action="mostraEsame" name="form">
		Inserisci l'id dell'esame:<select name="esame">
			<c:forEach items="${esami}" var="esame">
				<option value="${esame.idEsame}">${esame.idEsame}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Mostra esame" />
	</form:form>
<br>
<b>Id esame</b>: ${esame.idEsame}<br>
	<b>Tipologia esame</b>: ${esame.tipologia.nome}
	<br> <b>Medico</b>: ${esame.medico.nome} ${esame.medico.cognome}
	<br> <b>Paziente</b>: ${esame.paziente.nome} ${esame.paziente.cognome}
	<form:form method="post" action="addRisultati" name="form" modelAttribute="esame">
		<form:input type="hidden" path='idEsame' placeholder="id" /><br/>

	<b>Elenco dei risultati</b>:<br>
	<c:forEach items="${esame.risultati}" var="risultato"><br>
			<b>${risultato.key}</b>: 	
	<input type="text" name='risultato${risultato.key}' size='10' /> <br><font size="3" color="red">${risultatoError}</font>
	
	
			</c:forEach>
			<input type="submit" value="Invia" />
			</form:form><br>
			<h4><a href="admin">Torna alla Pagina d'amministrazione</a><br>
		<a href="index">Torna alla HomePage</a>
</body>
</html>