<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Ebase</title><meta charset="utf-8"/>
    <link href="<c:url value="/resources/css/style3.css" />" rel="stylesheet">
    <%--<link href="<c:url value="/resources/css/my.css">"  rel="stylesheet" type="text/css">--%>
    <%--<style>--%>
        <%--body{--%>
            <%--min-width:500px;--%>

            <%--margin:0;--%>
            <%--/*margin-bottom:auto;--%>
            <%--margin-top:auto;--%>
            <%--height: 100%;*/--%>
            <%--padding:0;--%>
            <%--font-family:'PT Sans', sans-serif;--%>
            <%--font-size:14px;--%>
        <%--}--%>
        <%--.clearfix:after{--%>
            <%--content:'';--%>
            <%--clear:both;--%>
            <%--display:table;--%>
        <%--}--%>
        <%--.layout-positioner{--%>
            <%--width:430px;--%>
            <%--margin:0 auto;--%>
            <%--/*border:2px dashed #3498db;*/--%>
        <%--}--%>
        <%--.layout-positioner:after{--%>
            <%--content:'';--%>
            <%--clear:both;--%>
            <%--display:table;--%>
        <%--}--%>
        <%--.header{--%>
            <%--margin-bottom:10px;--%>
            <%--/*background:#34495e;*/--%>
            <%--background:rgba(236, 240, 241, 0.9);--%>
            <%--color:black;--%>
        <%--}--%>
        <%--.header .layout-column{--%>

            <%--min-height:50px;--%>
            <%--/*background:rgba(192, 57, 43, 0.9);*/--%>
        <%--}--%>
        <%--.header .layout-column-1{--%>
            <%--float:left;--%>
            <%--width:280px;--%>
        <%--}--%>
        <%--.header .layout-column-2{--%>
            <%--float:right;--%>
            <%--width:130px;--%>
        <%--}--%>
        <%--.wrapper{--%>
            <%--/*padding-top:auto;--%>
            <%--padding-bottom:auto;--%>
            <%--position: relative;--%>
            <%--min-height: 100%;*/--%>
        <%--}--%>
        <%--.features{--%>
            <%--margin-bottom:10px;--%>
            <%--/*margin-top:auto;--%>
            <%--margin-bottom:auto;*/--%>
        <%--}--%>
        <%--.features .layout-column{--%>
            <%--float:left;--%>
            <%--margin-right:20px;--%>
            <%--width:130px;--%>
            <%--min-height:100px;--%>
            <%--background:#f9f6f3;--%>
        <%--}--%>
        <%--.features .layout-column:last-child{--%>
            <%--margin-right:0;--%>
        <%--}--%>
        <%--.footer{--%>

            <%--/*min-height:50px;--%>
            <%--background:#34495e;--%>
            <%--position: absolute;--%>
            <%--width:100%;--%>
            <%--*/--%>
            <%--background:rgba(236, 240, 241, 0.9);--%>
            <%--color:black;--%>
        <%--}--%>

        <%--/* Стили содержания */--%>
        <%--.hidden{--%>
            <%--display:block;--%>
            <%--/* display:none; */--%>
        <%--}--%>
        <%--.logo{--%>
            <%--padding:10px;--%>
        <%--}--%>
        <%--.logo p{--%>
            <%--margin:0;--%>
        <%--}--%>
        <%--.menu{--%>
            <%--margin:0;--%>
            <%--padding:10px;--%>
            <%--list-style:none;--%>
            <%--color:white;--%>
        <%--}--%>
        <%--.menu li{--%>
            <%--padding:5px;--%>
            <%--margin-bottom:5px;--%>
            <%--text-align:center;--%>
            <%--background:#2c3e50;--%>
            <%--border-radius:5px;--%>
        <%--}--%>
        <%--.feature{--%>
            <%--/*border:2px dashed #3498db;*/--%>
            <%--padding:10px;--%>
            <%--text-align:center;--%>
        <%--}--%>
        <%--.footer-logo{--%>
            <%--padding:10px;--%>
        <%--}--%>
        <%--.login{--%>

            <%--margin-left:50px;--%>
            <%--min-height:250px;--%>
            <%--width:130px;--%>
            <%--/*background:#f9f6f3;--%>
            <%--position:50% 50%;--%>
            <%--border:2px dashed #3498db;*/--%>

        <%--}--%>
        <%--.login-form {--%>

            <%--padding:10px;--%>
            <%--font-weight:bold;--%>
            <%--font-size:12px;--%>
            <%--font-family:"Tahoma", sans-serif;--%>
            <%--text-transform:uppercase;--%>
        <%--}--%>
        <%--.button {--%>
            <%--padding:0px;--%>
            <%--margin-top:3px;--%>
            <%--margin-botton:3px;--%>
        <%--}--%>
        <%--.input-form {--%>
            <%--border-radius:2px;--%>
            <%--margin-top:3px;--%>
            <%--margin-botton:3px;--%>
        <%--}--%>
    <%--</style>--%>
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
                <div class="layout-column-2 layout-column">
				
                </div>
            </div>
    </div>
        <div class="features ">
		 <div class="layout-positioner">
		 <div class="login">
            <form name='login-form'
                  action="<c:url value='j_spring_security_check' />" method='POST'
				class="login-form">
				Login:<input type='text' name='username' value='' class="input-form">
				Password:<input type='password' name='password' class="input-form" />
				<input name="submit" type="submit" value="login" class="login-form button" />
			</form>
        </div>
		</div>
		</div>
    </body>
</html>