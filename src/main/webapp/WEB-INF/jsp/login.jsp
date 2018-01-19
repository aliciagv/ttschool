<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Login --- TTSCHOOL</title>
 		<!-- Archivos CSS BOOTSTRAP -->
      	<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Archivos CSS Propios -->
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        
	</head>

	<body onload='document.loginForm.username.focus();'>

		<div class="container">
			<div class="card card-container">
        		<img id="profile-img" class="profile-img-card" src="imgs/ttschool.png" />
            	<p id="profile-name" class="profile-name-card"></p>
            	<form class="form-signin" name='loginForm'  action="<c:url value='logincheck' />" method='POST'>
          			<span id="reauth-email" class="reauth-email"></span>
                	<input type="email"  class="form-control" placeholder="Email address" name="username" id="username"></input>
                	<input type="password" class="form-control" placeholder="Password" name="password" id="password"></input>
                	<!--  <div id="remember" class="checkbox">
	                    <label>
    	                    <input type="checkbox" value="remember-me"> Remember me </input>
        	            </label>
            	    </div>-->
                    <c:if test="${not empty error}">
               	 		<div  class="alert alert-danger" role="alert">${error}</div>
                	</c:if>
                
                	<c:if test="${not empty logout}">
               	 		<div class="alert alert-info" role="alert">${logout}</div>
                	</c:if> 
        		
                	<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
                 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            	</form><!-- /form -->
           <!--   <a href="#" class="forgot-password">
                Forgot the password?
            </a>-->
        	</div><!-- /card-container -->
    	</div><!-- /container -->
    	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
    
	</body>
</html>