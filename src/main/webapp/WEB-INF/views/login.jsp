<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head> 
<meta charset="utf-8">
<title>Clinica Healthy - Login</title>
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
		<center>Accedi con i tuoi dati personali</center>
	</h4>
<form method="post" name="f" action="<c:url value="/${pageContext.request.contextPath}/j_spring_security_check"/>">
            <label>Nickname</label>
            <input type='text' name='j_username' /><br>

            <label>Password</label>
            <input type='password' name='j_password'><br>

            <input name="submit" type="submit">
        </form>
        <center><c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Il login non è riuscito. Errore: <br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
</c:if>
          <center>Non possiedi un account?<a style="color: red" href="registrazione"> Registrati</a>
          <h4><a href="index.html">Torna alla homepage</a>
</body>
</html>