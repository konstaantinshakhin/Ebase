<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Ebase</title><meta charset="utf-8"/>
    <link href="<c:url value="/css/style3.css" />" rel="stylesheet">

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