

<%@ page import="clinica.model.TipologiaEsame"%>
<%@ page import="clinica.service.impl.FacadeTipologiaEsame"%>
<%@ page import="clinica.dao.impl.TipologiaEsameDao"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
	<% 	FacadeTipologiaEsame facade=  new FacadeTipologiaEsame();
		List<TipologiaEsame> lista =facade.listaTipologiaEsame();
	
						for(TipologiaEsame tipo: lista){
							%>
							<div id="testo"><a href="#" onclick="visualizza('immagine<%out.print(lista.indexOf(tipo));%>'); return false">
<%out.print(tipo.getNome()); %></a></div>
							<%if(tipo.getRequisiti().isEmpty())
								out.print("Nessuno requisito richiesto"); 
							out.print("<br>"); %>
								<div id="immagine<%out.print(lista.indexOf(tipo));%>" style="display:none"><%for(String s:tipo.getRequisiti().keySet()){
									out.print(tipo.getRequisiti().get(s));out.print("<br>"); }%></div>
								
								
								<%
							out.print("<br>"); 
							
							out.print("------------------------------");
							out.print("<br>"); 
							}%>
		<tr>
  <h4><a href="index.html">Torna alla homepage</a>
                                </h4>
		</tr>
		<br>

		<center>
</body>
</html>
