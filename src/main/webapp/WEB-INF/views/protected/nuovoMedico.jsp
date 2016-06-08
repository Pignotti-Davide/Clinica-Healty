<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

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
          
	<center><h4>Aggiungi un nuovo medico</h4>

	<form:form method="post" action="addMedico" modelAttribute="medico" name="form">
		      <table>
		      <tr><td>
		           </td></tr>
			<tr>
				<td>Nome Medico :</td><font size="3" color="red"><springForm:errors path="nome" cssClass="error" /></font><br>
				<td><form:input type='text' path='nome' placeholder="nome"/></td>
				 
			</tr><tr><td>
      
			<tr>
				<td>Cognome Medico :</td>        <font size="3" color="red"><springForm:errors path="cognome" cssClass="error" /></font>
				<td><form:input type='text' path='cognome' placeholder="cognome" /></td><br>
			</tr><tr><td>
 
            <tr>
            <td>Specializzazione Medico :</td><font size="3" color="red"><springForm:errors path="specializzazione" cssClass="error" /></font> 
				<td><form:input type='text' path='specializzazione' placeholder="specializzazione"/></td>
			</tr>
		<tr><td>
		<input type="submit" value="invia" />
		 </td></tr></table>
	</form:form>
 <h4><br><a href="index">Torna alla homepage</a></center>
</body>
</html>