<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Amministrazione - Tipologia Esame inserita</title>
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
 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="admin">Area Amministrazione:</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                    <li>
                       <a class="navbar-brand" style="color:red"> ${pageContext.request.userPrincipal.name}</a>
                    </li>

                    <li>
                      
                    </li>
                    <li>
               
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
<img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
<body>
	<h4>
		<center>Inserimento risultati</center>
	</h4>
	<center>
		Hai inserito i seguenti risultati all'esame con Id ${id}: <br> <br>
	
         <td>Lista Risultati </td><br>
	  <c:forEach items="${risultati}" var="risultati" 
        varStatus="status">
           <tr>
                 <b><td>Nome risultato</b>: ${risultati.key}</td><br>
               <td><b>Descrizione risultato</b>:${risultati.value}</td>
            </tr> 
               	<hr  size=”500″ width=”10″ color=”green” noshade>
          </c:forEach>
		
		<h4><a href="admin">Torna alla Pagina d'amministrazione</a><br>
		<a href="index">Torna alla HomePage</a>
							
		<center>
</body>
</html>