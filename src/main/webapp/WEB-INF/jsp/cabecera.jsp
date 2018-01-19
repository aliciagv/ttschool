<div class="cabecera"> 
	<div class="navbar" role="navigation">
    	<div class="container"> 
        	
        	<div class="navbar-header">
            	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar1">
                	<span class="sr-only">Toggle navigation</span>
                	<span class="icon-bar"></span>
                	<span class="icon-bar"></span>
                	<span class="icon-bar"></span> 
            	</button>
            	<a target="_blank" href="#" class="navbar-brand"><img src="imgs/ttschool.png" alt="TTSchool""></a>
        	</div> <!-- navbar-header -->
        	
        	<div id="navbar1"class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
                	<li class="dropdown">
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        	<span class="glyphicon glyphicon-user"></span> 
                        	<strong><sec:authentication property="principal.username"/></strong>
                        	<span class="glyphicon glyphicon-chevron-down"></span>
                    	</a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="navbar-login">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <p class="text-center">
                                            <span class="glyphicon glyphicon-user icon-size"></span>
                                        </p>
                                    </div> <!-- col-lg4 -->
                                    <div class="col-lg-8">
                                        <p class="text-left"><strong>Nombre Apellido</strong></p>
                                        <p class="text-left small">correoElectronico@email.com</p>
                                        <p class="text-left">
                                            <a href="#" class="btn btn-primary btn-block btn-sm">Actualizar Datos</a>
                                        </p>
                                    </div><!-- col-lg-8 -->
                                </div> <!-- row -->
                            </div><!-- navbar-login -->
                        </li>
                        <li class="divider"></li>
                        	<li>
                            	<div class="navbar-login navbar-login-session">
                                	<div class="row">
                                    	<div class="col-lg-12">
                                    		<!--  <form action="${pageContext.request.contextPath}/logout" method="post">---->
											<form action="logout" method="post">
   												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   												<input class="btn btn-danger btn-block" type="submit" value="Log out" />
											</form>
										
											

                                    	</div><!-- col-lg-12 -->
                                	</div><!-- row -->
                            	</div><!-- navbar-login -->
                        	</li>
                    	</ul>
                	</li>
            	</ul>
        	</div><!-- navbar1 -->
    	</div><!-- container -->
	</div><!-- navbar -->
</div><!-- cabecera -->