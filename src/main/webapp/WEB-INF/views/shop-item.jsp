<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ebase</title>

    <!-- Bootstrap Core CSS -->
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="css/shop-item.css"  />" rel="stylesheet">

    <!-- jQuery -->
    <script type="text/javascript" src="<c:url value="js/jquery.js"/>"> </script>

    <!-- Bootstrap Core JavaScript -->
    <script type="text/javascript" src="<c:url value="js/bootstrap.min.js"/>"></script>
    <script type="text/javascript">


        $(document).ready(function() {
            debugger;
            var str;
// str = '[{"label":"africa","id":2,"children":[{"label":"opt","id":4,"children":[{"label":"sbor1","id":6,"children":[]},{"label":"sbor3","id":7,"children":[]}]},{"label":"roznica","id":5,"children":[{"label":"sbor2","id":8,"children":[]},{"label":"sbor3","id":9,"children":[]}]}]},{"label":"azia","id":3,"children":[{"label":"opt","id":10,"children":[{"label":"sbor5","id":12,"children":[]},{"label":"sbor7","id":13,"children":[]},{"label":"sbor2","id":14,"children":[]}]},{"label":"roznica","id":11,"children":[{"label":"sbor1","id":15,"children":[]}]}]}]';
// str = '{"label":"sbory","id":1,"children":[{"label":"africa","id":2,"children":[{"label":"opt","id":4,"children":[{"label":"sbor1","id":6,"children":[]},{"label":"sbor3","id":7,"children":[]}]},{"label":"roznica","id":5,"children":[{"label":"sbor2","id":8,"children":[]},{"label":"sbor3","id":9,"children":[]}]}]},{"label":"azia","id":3,"children":[{"label":"opt","id":10,"children":[{"label":"sbor5","id":12,"children":[]},{"label":"sbor7","id":13,"children":[]},{"label":"sbor2","id":14,"children":[]}]},{"label":"roznica","id":11,"children":[{"label":"sbor1","id":15,"children":[]}]}]}]}';

            //$.ajax({url: "/Ebase/getMenu", success: function (result) {
            // str = result;
            //}});

            $.getJSON('/Ebase/getMenu', {}, function (obj) {
                //var obj = JSON.parse(str);


                var div = document.createElement("div");
                div.className = "list-group panel";


                var divParent = document.getElementById("JMenu");

                divParent.appendChild(div);
                if (obj instanceof Array) {
                    for (j = 0; j < obj.length; j++) {
                        myParse(obj[j], div, "JMenu");
                    }
                } else myParse(obj, div, "JMenu");

                function myParse(obj, parrent, dataParent) {
                    debugger;
                    var a = document.createElement("a");
                    var label = document.createTextNode(obj.label);
                    var id = document.createTextNode(obj.id);

                    a.setAttribute('href', "#" + obj.id);
                    a.setAttribute('class', 'list-group-item');
                    a.setAttribute('data-toggle', "collapse");
                    a.setAttribute('data-parent', dataParent);

                    a.appendChild(label);
                    parrent.appendChild(a);

                    if (obj.children.length != 0) {

                        var divIn = document.createElement("div");
                        divIn.setAttribute('class', 'collapse');
                        divIn.setAttribute('id', obj.id);
                        parrent.appendChild(divIn);

                        for (var i = 0; i < obj.children.length; i++) {
                            dataParent = obj.id;
                            myParse(obj.children[i], divIn, dataParent);
                        }
                    }
                }

            })
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
                <a class="navbar-brand" href="/Ebase/">Ebase</a>
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

                <div class="thumbnail">
                    <img class="img-responsive" src="http://placehold.it/800x300" alt="">
                    <div class="caption-full">
                        <h4 class="pull-right">$24.99</h4>
                        <h4><a href="#">Product Name</a>
                        </h4>
                        <p>See more snippets like these online store reviews at <a target="_blank" href="http://bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
                        <p>Want to make these reviews work? Check out
                            <strong><a href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this building a review system tutorial</a>
                            </strong>over at maxoffsky.com!</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
                    </div>
                    <div class="ratings">
                        <p class="pull-right">3 reviews</p>
                        <p>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            4.0 stars
                        </p>
                    </div>
                </div>

                <div class="well">

                    <div class="text-right">
                        <a class="btn btn-success">Leave a Review</a>
                    </div>

                    <hr>

                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">10 days ago</span>
                            <p><h1>Hello World</h1></p>
                            <p>This product was great in terms of quality. I would definitely buy another!</p>
                        </div>
                    </div>

                    <hr>

                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">12 days ago</span>
                            <p>I've alredy ordered another one!</p>
                        </div>
                    </div>

                    <hr>

                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">15 days ago</span>
                            <p>I've seen some better than this, but not at this price. I definitely recommend this item.</p>
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
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->



</body>

</html>
