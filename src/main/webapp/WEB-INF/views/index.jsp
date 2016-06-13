<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clinica Healthy</title>
  <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/extra/css/bootstrap.min.css" />"type="text/css">

    <!-- Custom Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value="/resources/extra/font-awesome/css/font-awesome.min.css"/>" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/extra/css/magnific-popup.css" />"type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/extra/css/creative.css"/>" type="text/css">
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                <a class="navbar-brand" href="admin">Area Amministrazione</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                    <li>
                       <a class="navbar-brand" style="color:red"> ${pageContext.request.userPrincipal.name}</a>
                    </li>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
          
                <div class="list-group">
                    <h2>Contact Us</h2>
                <address>
                    <strong>Ingegneria informatica Roma Tre</strong>
                    <br>Via della Vasca Navale 79
                    <br>Roma, 2016
                    <br>
                </address>
                <address>
                    <abbr title="Member1">Davide Pignotti:</abbr><a href="mailto:#">name@example.com</a>
                    <br>
                    
                    <abbr title="Member2">Susanna Marinai:</abbr> <a href="mailto:#">sus.marinai@hotmail.it</a>
                </address>
               Questo sito nasce come progetto per l'esame Sistemi Informativi su Web erogato nel 2016 nella facoltà di
        			Ingegneria Informatica Roma Tre. Tecnologie utilizzate:<br>
        			-JPA(Hibernate)<br>
        			-framework CSS(<a href="http://startbootstrap.com/">Bootstrap</a>) <br>
        			-framework app enterprise (Spring) <br>
        			-framework MVC(SpringMVC)<br>
        			-<a href="http://54.200.177.88/Clinica-Healthy/index">AWS</a> (disponibile per un periodo limitato)<br>
        			- repository su <a href="https://github.com/Pignotti-Davide/Clinica-Healthy">Github</a>
                </div> 
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                    <img src="<c:url value="/resources/Grafica/logo3.jpg"/>">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="<c:url value="/resources/Grafica/pubb1.jpg"/>" alt="">
                                </div>
                                <div class="item">
                               <img class="slide-image" src="<c:url value="/resources/Grafica/pubb2.jpg"/>" alt="">
                                </div>
                                <div class="item">
                                
                           <img class="slide-image" src="<c:url value="/resources/Grafica/pubb3.jpg"/>" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="<c:url value="#carousel-example-generic" />" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="<c:url value="#carousel-example-generic" />"  data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

                <div class="row">

                   <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                          <img src="<c:url value="/resources/Grafica/offerte.jpg"/>" class="img-responsive" alt="">
                       
                            <div class="caption">
           
                                <h4><a href="<c:url value="utente"/>">Accedi all'area paziente</a>
                                </h4>
                                <p>Potrai consultare i risultati degli esami a tuo nome </p>
                            </div>
                          
                        </div>
                    </div>
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                          <img src="<c:url value="/resources/Grafica/offerte2.jpg"/>" alt="">
                            <div class="caption">
           
                                <h4><a href="listaMedici">Conosci i nostri medici</a>
                                </h4>
                                <p>Potrai conoscere la lista dei nostri medici e gli esami da loro svolti.</p>
                            </div>
                          
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                      <div class="thumbnail">
                        <img src="<c:url value="/resources/Grafica/offerte3.jpg"/>" alt="">
                        <div class="caption">
                  
                                <h4><a href="listaTipologiaEsami">Lista tipologie esami</a>
                                </h4>
                                <p>Troverai la lista di tutti gli esami svolti dalla clinica e tutte le informazioni relative ad essi</p>
                          </div>
</div>
                    </div>

                   

                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Susanna Marinai & Davide Pignotti 2016 - progetto esame "Sistemi informativi su Web" Roma Tre</p>
                </div>
            </div>
        </footer>

    </div>


    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- jQuery -->
    <script src="<c:url value="/resources/extra/js/jquery.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/extra/js/bootstrap.min.js"/>"></script>

    <!-- Plugin JavaScript -->
    <script src="<c:url value="/resources/extra/js/scrollreveal.min.js"/>"></script>
    <script src="<c:url value="/resources/extra/js/jquery.easing.min.js"/>"></script>
    <script src="<c:url value="/resources/extra/js/jquery.fittext.js"/>"></script>
    <script src="<c:url value="/resources/extra/js/jquery.magnific-popup.min.js"/>"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/extra/js/creative.js"/>"></script>
</body>

</html>
