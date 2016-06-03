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
<title>	Area amministrazione - aggiungi nuovo medico</title>
</head>

<body>
 <img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
          
	<center><h4>Aggiungi un nuovo medico</h4>

	<form:form method="post" action="addMedico" modelAttribute="medico" name="form">
		      <table>
		      <tr><td>
		           <font size="3" color="red">${nomeError}</font>
		           </td></tr>
			<tr>
				<td>Nome Medico :</td>
				<td><form:input type='text' path='nome' placeholder="nome"/></td>
			</tr><tr><td>
                   <font size="3" color="red">${cognomeError}</font> </td></tr>
			<tr>
				<td>Cognome Medico :</td>
				<td><form:input type='text' path='cognome' placeholder="cognome" /></td><br>
			</tr><tr><td>
           <font size="3" color="red">${specializzazioneError}</font> </td></tr>
            <tr>
				<td>Specializzazione medico :</td>
				<td><form:input type='text' path='specializzazione' placeholder="specializzazione"/></td>
			</tr>
		<tr><td>
		<input type="submit" value="invia" />
		 </td></tr></table>
	</form:form>
 <br><a href="index">Torna alla homepage</a></center>
</body>
</html>