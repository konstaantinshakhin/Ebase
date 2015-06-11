<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>General page</title>
    <meta charset="utf-8">
    <link href="<c:url value="/css/style3.css" />" rel="stylesheet">
    <link href="<c:url value="/css/jqtree.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/js/jquery-1.11.3.js"/>"> </script>
    <script type="text/javascript" src="<c:url value="/js/tree.jquery.js"/>"> </script>
    <script type="text/javascript" src="<c:url value="/js/jquery.cookie.js"/>"> </script>
    <script type="text/javascript">
        $(document).ready(function()
        {

//            $('#tree1').bind(
//                    'tree.click',
//                    function(event) {
//                        // The clicked node is 'event.node'
//                        var node = event.node;
//                        //alert(node.name);
//                    }
//            );
            $.getJSON(
                    '/Ebase/getMenu',
                    function(data) {
                        $('#tree1').tree({
                            data: data
                        });
                    }
            );
            //alert("JS WORKIN!!!");

            //var jdata = [{"label":"africa","id":2,"children":[{"label":"opt","id":4,"children":[{"label":"sbor1","id":6,"children":[]},{"label":"sbor3","id":7,"children":[]}]},{"label":"roznica","id":5,"children":[{"label":"sbor2","id":8,"children":[]},{"label":"sbor3","id":9,"children":[]}]}]},{"label":"azia","id":3,"children":[{"label":"opt","id":10,"children":[{"label":"sbor5","id":12,"children":[]},{"label":"sbor7","id":13,"children":[]},{"label":"sbor2","id":14,"children":[]}]},{"label":"roznica","id":11,"children":[{"label":"sbor1","id":15,"children":[]}]}]}]

            $(function() {
                $('#tree1').tree({
                    data: data
                });
            });
        });
    </script>
</head>
<body>
<div class="header ">
    <div class="layout-positioner">
        <div class="layout-column-1 layout-column">
            <div class="logo hidden">
                <!--<img width="140" src="img/logo.png">-->
                <h1>EBASE</h1>
                <p>Найдите необходимую информацию в EBASE</p>
            </div>
        </div>
        <%--<div class="layout-column-2 layout-column">--%>
        <%--<ul class="menu hidden">--%>
        <%--<li>Курсы</li>--%>
        <%--<li>Интенсив</li>--%>
        <%--</ul>--%>
        <%--</div>--%>
    </div>
</div>
<div class="features ">
    <div class="layout-positioner">
        <div class="left-column">
            <div class="feature hidden">

                <div id="tree1" ></div>
            </div>
        </div>
        <div class="right-column">
            <div class="feature hidden">
            <h1>Hello World!!!</h1>
            </div>
        </div>
        <%--<div class="layout-column">--%>
        <%--<div class="feature hidden">--%>
        <%----%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<div class="layout-column">--%>
        <%--<div class="feature hidden">--%>
        <%----%>
        <%--</div>--%>
        <%--</div>--%>
    </div>
</div>
<div class="footer">
    <div class="layout-positioner">
        <div class="footer-logo hidden">
            <!--<img width="140" src="img/logo.png">-->
            <h1>EBASE</h1>
        </div>
    </div>
</div>
</body>
</html>