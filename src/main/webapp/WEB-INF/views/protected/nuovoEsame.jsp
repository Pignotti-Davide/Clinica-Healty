
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiungi nuovo esame</title>
 <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">
</head>
<body>
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
<center><img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
<h4>Clinica Healthy - Area amministrazione</h4>

		<form:form method="post" action="addEsame"
			modelAttribute="esame" name="form">
				<label>Paziente:</label> <input path="paziente" type="text" /><br>
<!-- 	<label>Tipologia:</label> -->
<!-- <select name="tipologiaEsame"> -->

<%-- <% for(TipologiaEsame t:new FacadeTipologiaEsame().listaTipologiaEsame())  --%>
<%-- 	out.print( "<option value="+t.getIdTipologiaEsame()+">"+t.getNome()+"</option>");%> --%>
<!--  </select><br>  -->
<!-- 	<label>Paziente:</label> -->
<!--  <select name="paziente">  -->
<%--  <% for(Paziente p:new FacadePaziente().findAllPazienti())  --%>
<%--  	out.print( "<option value="+p.getIdPaziente()+">"+p.getNome()+" "+p.getCognome()+"</option>");%> --%>
<!--  </select><br> -->
<!-- 	<label>Medico:</label> -->
<!--  <select name="medico">  -->
<%--  <% for(Medico m:new FacadeMedico().findAllMedici()) --%>
<%-- out.print( "<option value="+m.getIdMedico()+">"+m.getNome()+" "+m.getCognome()+"</option>");%>  --%>
<!--  </select><br>  -->
<label>Seleziona la data:</label>
<input path="prenotazione" type="datetime-local" /><br>
	<input type="submit" value="Invia" />
</form:form>
 <br><a href="index.html">Torna alla homepage</a></center>
</body>
</html>