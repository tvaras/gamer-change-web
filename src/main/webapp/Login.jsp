<%-- 
    Document   : Login
    Author     : amontess
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
		<link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
		<link rel="stylesheet" href="css/login-style.css">
    </head>
    <body>
        <div class="wrapper fadeInDown">
		  <div id="formContent">
		    <!-- Tabs Titles -->
		
		    <!-- Icon -->
		    <div class="fadeIn first">
		      <img src="img/user.png" id="icon" alt="User Icon" />
		    </div>
		
		    <!-- Login Form -->
		    <form name="formIngreso" action="./validaUsuario" method="post">
		      <input type="text" id="login" class="fadeIn second" name="txtLogin" placeholder="Usuario">
		      <input type="password" id="password" class="fadeIn third" name="txtPass" placeholder="Password">
		      <input type="submit" class="fadeIn fourth" value="Ingresar">
		    </form>
		
		  </div>
		</div>
		<jsp:include page="MenuPie.jsp" flush="true"></jsp:include>
    </body>
</html>
