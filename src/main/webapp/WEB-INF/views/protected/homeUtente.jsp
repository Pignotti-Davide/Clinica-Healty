
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
                             <center>Ciao, <%out.print(""); %>  , sei qui come <%out.print(""); %>!!!!!
                               
                               <br>Ecco ciò che puoi fare: 
                                 <br><a href="protected/risultatiPaziente.jsp">Consulta i risultati degli esami</a>
                                   <br><a href="index.html">Torna alla homepage</a>
                                  
                                
				
</body>
</html>