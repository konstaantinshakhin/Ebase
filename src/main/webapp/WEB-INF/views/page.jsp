<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Ebase</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="css/shop-homepage.css"  />" rel="stylesheet">

    <!-- jQuery -->
    <script type="text/javascript" src="<c:url value="js/jquery.js"/>"> </script>

    <!-- Bootstrap Core JavaScript -->
    <script type="text/javascript" src="<c:url value="js/bootstrap.min.js"/>"></script>

    <script type="text/javascript" src="<c:url value="js/listMenu.js"/>"> </script>


    <script type="text/javascript">

        $(document).ready(function() {
          listMenu();
        })

    </script>
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
            <a class="navbar-brand" href="#">EBASE</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
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
    <p class="lead">Shop Name</p>



    <div id="JMenu">
    </div>
</div>

<div class="col-md-9">

<div class="row carousel-holder">

    <div class="col-md-12">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                </div>
                <div class="item">
                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                </div>
                <div class="item">
                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                </div>
            </div>
            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
    </div>

</div>

<div class="row">

<c:forEach var="item" items="${items}">


<div class="col-sm-4 col-lg-4 col-md-4">
    <div class="thumbnail">
        <img src="http://placehold.it/320x150" alt="">
        <div class="caption">
            <h4 class="pull-right"><c:out value="${item.price}"/></h4>
            <h4><p> <a target="_blank" href="/Ebase/item?id=<c:out value="${item.id}"/>"><c:out value="${item.itemName}"/></a>.</p>
            </h4>
            <p> <a target="_blank" href="/Ebase/item?id=<c:out value="${item.id}"/>"><c:out value="${item.itemName}"/></a>.</p>
        </div>
        <div class="ratings">
            <p class="pull-right">15 reviews</p>
            <p>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star-empty"></span>
            </p>
        </div>
    </div>
</div>
</c:forEach>

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
                <p>Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->



</body>

</html>
