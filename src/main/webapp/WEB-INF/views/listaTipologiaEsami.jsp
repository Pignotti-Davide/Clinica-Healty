
<%@ page import="clinica.model.TipologiaEsame"%>
<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/master
<%@ page import="clinica.dao.impl.TipologiaEsameDao"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/master

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - lista esami</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>

<body>
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
                <a class="navbar-brand" href="#">LogIn:</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                
<<<<<<< HEAD
                
=======
                 
                </ul>
>>>>>>> refs/remotes/origin/master
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	<img src="<c:url value="/resources/Grafica/logo3.png"/>">

	<h4>
		<center>Consulta il nostro catalogo</center>
	</h4>
	<center>
		   <script type="text/javascript" language="javascript">
function visualizza(id){
  if (document.getElementById){
    if(document.getElementById(id).style.display == 'none'){
      document.getElementById(id).style.display = 'block';
    }else{
      document.getElementById(id).style.display = 'none';
    }
  }
}
</script>
	<% 	
		List<TipologiaEsame> lista =null;
	
						for(TipologiaEsame tipo: lista){
							%>
							<div id="testo"><a href="#" onclick="visualizza('immagine<%out.print(lista.indexOf(tipo));%>'); return false">
<%out.print(tipo.getNome()); %></a></div>
							<%if(tipo.getPrerequisiti().isEmpty())
								out.print("Nessuno requisito richiesto"); 
							out.print("<br>"); %>
								<div id="immagine<%out.print(lista.indexOf(tipo));%>" style="display:none"><%for(String s:tipo.getPrerequisiti().keySet()){
									out.print(tipo.getPrerequisiti().get(s));out.print("<br>"); }%></div>
								
								
								<%
							out.print("<br>"); 
							
							out.print("------------------------------");
							out.print("<br>"); 
							}%>
		<tr>
<%-- 		  <c:forEach items="${contactForm.contactMap}" var="contactMap" --%>
<%--             varStatus="status"> --%>
<!--             <tr> -->
<%--                 <td>${contactMap.key}</td> --%>
<%--                 <td>${contactMap.value}</td> --%>
<!--             </tr> -->
<%--         </c:forEach> --%>
  <h4><a href="index.html">Torna alla homepage</a>
                                </h4>
		</tr>
		<br>

		<center>
</body>
</html>

