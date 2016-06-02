<%@ page import="clinica.model.Utente" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
   boolean autorizzato = true;
  Utente utente= (Utente) request.getAttribute("utente");
  System.out.println(utente.getRole());
  System.out.println(utente.getPassword());
   if (utente!=null)
	   autorizzato &= (utente.getRole().equals("admin"));
   else 
   	   autorizzato = false;
   if (!autorizzato) {
		response.sendRedirect("error");
	}
%>


<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Area amministrazione</title>
     <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
          <img src="http://susysksiw.altervista.org/logo3.jpg">
          
<body>

  <h4><center>Area riservata all'amministrazione</center>    </h4>
                                <center>Ciao, "${utente.username}" sei qui come "${utente.role}" !!!!!
                               <form  method="get" action="../userLogout" name="form">
                                	<button class="btn-default" type="submit"><font size="3" color="red">(LogOut)</font> </button>
                                	</form>
                               <br>Ecco ciò che puoi fare: 
                                 <br>
                                  <center>
                             
<img  src="<c:url value="/resources/Grafica/inseriscipaziente.png"/>"  usemap="#link1"><map name="link1" id="link1">
<area shape="rect" coords="180, 100, 80, 200" href="nuovoPaziente"  alt="click">
</map> <img  src="<c:url value="/resources/Grafica/inseriscimedico.png"/>"  usemap="#link2"><map name="link2" id="link2">
<area shape="rect" coords="180, 100, 80, 200" href="nuovoMedico"  alt="click">
</map> <br>
<img  src="<c:url value="/resources/Grafica/inserisciesame.png"/>"  usemap="#link3"><map name="link3" id="link3">
<area shape="rect" coords="180, 100, 80, 200" href="nuovoEsame"  alt="click">
</map> <img  src="<c:url value="/resources/Grafica/inseriscitipologia.png"/>"  usemap="#link4"><map name="link4" id="link4">
<area shape="rect" coords="180, 100, 80, 200" href="nuovaTipologiaEsame"  alt="click">
</map> 
                               <br><a href="index">Torna alla homepage</a></center>
                                
				
</body>
</html>