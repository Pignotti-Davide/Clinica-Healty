<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
=======
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
>>>>>>> refs/remotes/origin/master
<head>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<<<<<<< HEAD

<html>
<head><script type="text/javascript">
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
							+ "Tipo Risultato n°"
							+ i
							+ " : Nome risultato: <input type='text' name='risultato"+i+"' size='10' />"
							+ "<br/>";
				}
				box.innerHTML = righe;
=======
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Aggiungi una nuova Tipologia Esame</title>
<script type="text/javascript">
function AggiungiRisultato(risultati){
var numero_risultati = risultati.value;
	var box = document.getElementById('box_risultati');
	if(numero_risultati==""){
		box.innerHTML='';
	}else{
		if(isNaN(numero_risultati)==true){
			box.innerHTML='';
		}else{
			var righe = "";
			
			// Inserisco una riga ad ogni ciclo
			for(i=1; i<=numero_risultati; i++){
				righe = righe + "Tipo Risultato n°"+i+
				" : Nome risultato: <input type='text' name='risultato"+i+"' size='10' />"+
				"<br/>";
>>>>>>> refs/remotes/origin/master
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
<body>
	<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">

	<center>

		<h4>Aggiungi una nuova tipologia di esame</h4>

		<form:form method="post" action="addTipologiaEsame"
			modelAttribute="tipologiaEsame" name="form">
			<font size="3" color="red">${nomeError}</font>
			<br>
			<br>
			<tr>
				<td>Nome Tipologia Esame :</td>
				<td><form:input type="text" path="nome" placeholder="nome" /></td>
			</tr>
			<font size="3" color="red">${descrizioneError}</font>
			<br>
			<tr>
				<td>Descrizione Esame:</td>
				<td><form:input type="text" path="descrizione"
						placeholder="descrizione" /></td>
			</tr>
			<tr>
		
				<td>Numero di requisiti :</td>
				<td><form:input type="text" path="numero_requisito" value="0"
					maxlength="2" onkeyup="AggiungiRequisito(this)" /></td>
				<br>
			</tr>
			<tr>

			</tr>
			</table>
			<table>
				<tr>
					<td><span id='box_requisiti'> <!-- Box che conterrÃ  le righe aggiunte. Inizialmente vuoto! -->
					</span></td>

				</tr>
				<br>
				<tr>
			</table>
			<table>
				<td>Numero Risultati:</td>
				<br>
				<td><form:input type="text" path="indicatoriRisultati" value="0"
					maxlength="2" onkeyup="AggiungiRisultato(this)"/></td>
				<td><span id='box_risultati'> <!-- Box che conterrÃ  le righe aggiunte. Inizialmente vuoto! -->
				</span></td>
			</table>
			<input type="submit" value="invia" />
		</form:form>
		<br> <a href="index">Torna alla homepage</a>
	</center>
</body>
</html>