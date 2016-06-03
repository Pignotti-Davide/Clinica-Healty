<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Area utente</title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
          <img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
          
<body>

  <h4><center>Area dedicata agli utenti</center>    </h4>
                             <center>Ciao, <%out.print(""); %>  , sei qui come <%out.print(""); %>.  <form  method="get" action="../userLogout" name="form">
                                	<button class="btn-default" type="submit"><font size="3" color="red">(LogOut)</font> </button>
	</form>
		           <font size="3" color="red">${codeError}</font> <br>
                               <br>Per consultare i risultati degli esami inserisci il codice:
                              <form method="get" action="controllerRisultati" name="form">
		           <font size="3" color="red">${codeError}</font> <br>
			<br>
			<tr>
				
				<td><input type='text' name='code' placeholder="codice"/></td><br>
			</tr>
		<input type="submit" value="invia" />
	</form>
                                   <br><a href="index.html">Torna alla homepage</a>
                                  
                                
				
</body>
</html>