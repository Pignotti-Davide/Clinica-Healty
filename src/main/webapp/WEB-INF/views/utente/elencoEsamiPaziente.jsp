<%@page import="clinica.dao.impl.EsameDaoJPA"%>
<%@page import="clinica.model.Esame"%>
<%@page import="clinica.model.Paziente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elenco esami Paziente</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<td style="width: 938px;">
				<h4>
					<center>I suoi esami:</center>
				</h4> <%
 	Paziente p = (Paziente) session.getAttribute("paziente");
 	for (Esame e : new EsameDaoJPA().retrieveEsamiDelPaziente(p)) {
 		out.print("Codice esame:" + e.getIdEsame() + "		Nome esame:" + e.getTipologiaEsame().getNome()
 				+ "");
 	}
 %>
			</td>
			<td>
				<form action="ControllerEsameSelezionato" method="get">

					<div class="form-group">
						Inserisci il codice dell'esame che intendi visualizzare: <input
							type="text" name="codiceEsame">
							</div>
						<button type="submit" class="btn btn-default">Invia</button>
						</form>
						
			</td>

		</tr>
	</table>
</body>
</html>