<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<head> 
<meta charset="utf-8">
<title>Clinica Healthy -Registrazione</title>
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
				<a class="navbar-brand">Area di Login:</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li></li>
					<li></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<center><img src="<c:url value="/resources/Grafica/logo3.jpg"/>">

	<h4>
		<center>Crea un nuovo account</center>
	</h4>
<form:form method="post" action="addUtente" modelAttribute="utente" name="form">
			
			<table>
				<tr>
	
				</tr>
				<tr>
	
					<td>Username :</td><font size="3" color="red">${usernameError }</font>
					<td><form:input type="text" path='username' placeholder="username" /></td>
				</tr>
				<tr>
				</tr>

				<tr>
					<td>Password :</td>
					<td><form:input type="password" path='password'
							placeholder="password" /></td>

							<font size="3" color="red"><springForm:errors path="username" cssClass="error" /></font><br/>
			<font size="3" color="red"><springForm:errors path="password" cssClass="error" /></font><br/>

				<tr>
					<td><input type="submit" value="invia" /></td>
				</tr>
			</table>
		</form:form>
          <h4><a href="index.html">Torna alla homepage</a>
</body>
</html>