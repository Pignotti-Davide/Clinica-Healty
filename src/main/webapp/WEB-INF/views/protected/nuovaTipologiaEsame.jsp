
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<script type="text/javascript">
	function AggiungiRisultato(risultati) {
		var numero_risultati = risultati.value;
		var box = document.getElementById('box_risultati');
		if (numero_risultati == "") {
			box.innerHTML = '';
		} else {
			if (isNaN(numero_risultati) == true) {
				box.innerHTML = '';
			} else {
				var righe = "";

				// Inserisco una riga ad ogni ciclo
				for (i = 1; i <= numero_risultati; i++) {
					righe = righe
							+ "<br/>"
							+ " Risultato n°"
							+ i
							+ ":Nome: <input type='text' name='risultato"+i+"' size='10' />"
							+ "<br/>";
				}
				box.innerHTML = righe;
			}
		}
	}
	function AggiungiRequisito(requisiti) {
		var numero_requisiti = requisiti.value;
		var box = document.getElementById('box_requisiti');
		if (numero_requisiti == "") {
			box.innerHTML = '';
		} else {
			if (isNaN(numero_requisiti) == true) {
				box.innerHTML = '';
			} else {
				var righe = "";

				// Inserisco una riga ad ogni ciclo
				for (i = 1; i <= numero_requisiti; i++) {
					righe = righe
							+ "Requisito n°"
							+ i
							+ " : Nome requisito: <input type='text' name='requisito"+i+"' size='10' />"
							+ "	Descrizione requisito: <input type='text' name='descrizione_requisito"+i+"' size='40'/>"
							+ "<br/>";
				}
				box.innerHTML = righe;
			}
		}
	}
</script>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/shop-homepage.css" />"
	rel="stylesheet">
</head>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
<div class="container">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="admin">Area Amministrazione:</a>
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">

			<li><a class="navbar-brand" style="color: red">
					${pageContext.request.userPrincipal.name}</a></li>

			<li></li>
			<li></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container --> </nav>
<body>
	<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">

	<center>

		<h4>Aggiungi una nuova tipologia di esame</h4>

		<form:form method="post" action="addTipologiaEsame"
			modelAttribute="tipologiaEsame" name="form">
			<table>
				<tr>
					<td><font size="3" color="red">${nomeError}</font></td>
				</tr>

				<tr>
					<td>Nome Tipologia Esame :</td>
					<td><form:input type="text" path="nome" placeholder="nome" /></td>
				</tr>
				<tr>
					<td><font size="3" color="red">${descrizioneError}</font></td>
				</tr>
				<tr>
					<td>Descrizione Tipologia Esame:</td>
					<td><form:input type="text" path="descrizione"
							placeholder="descrizione" /></td>
				</tr>
				<tr>

					<td>Numero di requisiti :</td>
					<td><input type="text" name="num_requisiti" value="0"
						maxlength="2" onkeyup="AggiungiRequisito(this)" /></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><span id='box_requisiti'> </span></td>
				</tr>
			</table>
			<table>
				<tr>
					<td>Numero Risultati:</td>
			
					<td><input type="text" name="num_risultati" value="0"
						maxlength="2" onkeyup="AggiungiRisultato(this)"></input></td>
				</tr></table>
				<table>
					<tr>
						<td><span id='box_risultati'> </span></td>
					</tr>
				</table>
					<input type="submit" value="Invia" />
		</form:form>
</body>
</html>