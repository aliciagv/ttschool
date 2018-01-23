<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>TTSCHOOL</title>
		<!-- Archivos CSS BOOTSTRAP -->
		<link href="bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/> <!--TEMA POR DEFECTO -->
      	<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
      	 <link href="stacktable-1.0.2-13/stacktable.css" rel="stylesheet">
        <!-- Archivos CSS Propios -->
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/profesores.css" rel="stylesheet" type="text/css"/>
        <!-- Icono -->
         <link rel="shortcut icon" href="imgs/ttschool.png">
	</head>
	<body>
		<jsp:include page="cabecera.jsp"/>
		<div class="container principal">
    		<div class="wrapper principal">
    			<div class="row">
    				<jsp:include page="menu.jsp"/>
    				<div id="cuerpo" class="cuerpo">
        				<div class="col-sm-9 col-md-9">
            				<div class="well">
	            				<div class="container">
		           					 <div class="page-header">
		             					 <h1 class="all-tittles">TTSchool <small>Inicio</small></h1>
		             					  Usuario: <sec:authentication property="principal.username" /> |
                   						 Roles: <sec:authentication property="principal.authorities" /> |
		           					</div>
	        					</div><!-- container -->
            				</div><!-- well -->
            			</div><!-- col9 -->
            		</div><!-- cuerpo -->
    			</div> <!-- row -->
    		</div><!-- wrapper principal -->
    	</div> <!--  container principal -->
 		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<!-- Include all compiled plugins (below), or include individual files as needed -->
    	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
    	<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
    	<script src="stacktable-1.0.2-13/stacktable.js"></script>
    	<script src="js/validation.js"></script>
    	<script src="js/main.js"></script>

	</body>
</html>