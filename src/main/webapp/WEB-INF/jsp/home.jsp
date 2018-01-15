<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Home --- TTSCHOOL</title>
		<!-- Archivos CSS BOOTSTRAP -->
      	<link href="/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Archivos CSS Propios -->
        <link href="/css/nav.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<nav class="navbar navbar-default sidebar" role="navigation">
    	<div class="container-fluid">
    		<div class="navbar-header">
      			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
        			<span class="sr-only">Toggle navigation</span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
      			</button>      
    		</div>
    	<div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
      		<ul class="nav navbar-nav">
        		<li class="active"><a href="#">Home<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
        		<li class="dropdown"><a href="student.jsp" class="dropdown-toggle" data-toggle="dropdown">Alumnos<span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>          
        		<li ><a href="#">Profesores<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>        
        		<li ><a href="#">Asignaturas<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-tags"></span></a></li>
      		</ul>
    	</div>
  	</div>
</nav>
 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/bootstrap-3.3.7/js/bootstrap.min.js"></script>

	</body>
</html>