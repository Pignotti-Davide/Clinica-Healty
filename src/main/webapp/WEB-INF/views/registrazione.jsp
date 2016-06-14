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
<form:form method="post" action="confermaUtente" modelAttribute="utente" name="form">
		
					<td>Username :</td><font size="3" color="red">${usernameError }</font>
					<td><form:input type="text" path='username' placeholder="username" /></td><br>
					<td>Password :</td>
					<td><form:input type="password" path='password'
							placeholder="password" /></td>

							<font size="3" color="red"><springForm:errors path="username" cssClass="error" /></font><br/>
			<font size="3" color="red"><springForm:errors path="password" cssClass="error" /></font><br/>
					<td><input type="submit" value="invia" /></td>
					</form:form>
					<br>
					<c:if test="${not empty utente.username}">
   <p><c:out value="Conferma le seguenti informazioni:"/><p>
    <b><p><c:out value="Username:"/></b> ${utente.username}<br>
     <b><p><c:out value="Password:"/> </b>${utente.password}<br>
     <form:form method="post" action="addUtente" modelAttribute="utente" name="form2">
     <form:input type="hidden" path='username' placeholder="id" /><br/>
     <form:input type="hidden" path='password' placeholder="id" /><br/>
     <td><input type="submit" value="Conferma" /></td>
     </form:form>
   </c:if>
				</tr>
			</table>
		
          <h4><a href="index.html">Torna alla homepage</a>
</body>
</html>