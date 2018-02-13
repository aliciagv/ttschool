<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<div class="navegador">
	<div class="col-sm-3 col-md-3">
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
            	
            	<div class="panel-heading">
            		<h4 class="panel-title">
            			<span class="glyphicon glyphicon-folder-close"></span>Administración
            			
					</h4> <!-- panel-title -->
				</div> <!--  div panel-heading -->
				
				
					<div class="panel-body">
						<table class="table">
	               			<tr>
	               				<td>
	               					<span class="glyphicon glyphicon-info-sign text-info"></span>
	               					<a href="http://www.jquery2dotnet.com">Información</a>
	                    		</td>
	                		</tr>
	                		<tr>
	                			<td>
	                				<span class="glyphicon glyphicon-flash text-info"></span>
	                				<a href="http://www.jquery2dotnet.com">Servicios</a>
	                    		</td>
	                		</tr>
	                		<tr>
	                			<td>
	                				<span class="glyphicon glyphicon-book text-info"></span>
	                				<a href="http://www.jquery2dotnet.com">Libros de Texto</a>
	                        			
								</td>
							</tr>
	                 		<tr>
	                 			<td>
	                 				<span class="glyphicon glyphicon-paperclip text-info"></span>
	                 				<a href="http://www.jquery2dotnet.com">Impresos y Autorizaciones</a>
	                         	</td>
	                 		</tr>
	                 	</table>
                      </div><!-- panel-body -->
               	</div><!-- panel panel-default -->
                
                <div class="panel panel-default">
                	<div class="panel-heading">
                        		<h4 class="panel-title">
                            		
                            		</span>Registro</a>
                        		</h4>
                    		</div> <!-- pannel-heading -->
                    		
                    		
                    			<div class="panel-body">
                            		<table class="table">
                                		<tr>
                                    		<td>
                                    		<span class="glyphicon glyphicon-user"></span><a href="http://www.jquery2dotnet.com">Administrador</a>
                                    		</td>
                                		</tr>
                                		<tr>
                                    		<td>
                                        		
                                        		<a href="<c:url value="/profesor" />">Profesor</a>
                                        		
                                    		</td>
                                		</tr>
                                		<tr>
                                    		<td>
                                        		 <span class="glyphicon glyphicon-education"></span><a href="http://www.jquery2dotnet.com">Alumno</a>
                                    		</td>
                                		</tr>
                                		<tr>
                                    		<td>
                                        		<span class="glyphicons glyphicons-parents"></span><a href="http://www.jquery2dotnet.com">Tutor</a>
                                    		</td>
                                		</tr>
                                		<tr>
                                    		<td>
                                        		<a href="http://www.jquery2dotnet.com">Asignaturas</a>
                                    		</td>
                                		</tr>
                                		<tr>
                                    		<td>
                                    			<a href="<c:url value="/curso" />">Cursos</a>
                                    		</td>
                                		</tr>
                                		<tr>
                                    		<td>
                                        		<a href="http://www.jquery2dotnet.com">Notas</a>
                                    		</td>
                                		</tr>
                            		</table>
                        		</div><!-- panel-body -->
                		</div><!-- panel panel-default -->
                		
                		<div class="panel panel-default">
                    		
                    		<div class="panel-heading">
                        		<h4 class="panel-title">
                            		
                            		</span>Notificaciones</a>
                        		</h4>
                    		</div> <!-- panel-heading -->
                    		
                        		<div class="panel-body">
                            		<table class="table">
                                		<tr>
                                    		<td>
                                    			<a href="<c:url value="/global" />">Globales</a>
                                    		</td>
                               		 	</tr>
                                		<tr>
                                    		<td>
                                        		<a href="http://www.jquery2dotnet.com">Curso</a>
                                    		</td>
                                		</tr>
                                		<tr>
                                    		<td>
                                        		<a href="http://www.jquery2dotnet.com">Personales</a> 
                                    		</td>
                                		</tr>
                            		</table>
                        		</div><!-- panel body -->
                		</div> <!--  panel-default-->
                		
                		<div class="panel panel-default">
                    		
                    		<div class="panel-heading">
                        		<h4 class="panel-title">
                            		
                            		</span>Informes</a>
                        		</h4>
                    		</div><!-- panel-heading -->
                    		
                    		
                        		<div class="panel-body">
                            		<table class="table">
	                                	<tr>
    		                                <td>
            		                            <span class="glyphicon glyphicon-user"></span>
            		                            <a href="http://www.jquery2dotnet.com">Profesores</a>
                    		                </td>
                            		    </tr>
                                		<tr>
                              		      	<td>
	                                	        <span class="glyphicon glyphicon-education"></span>
	                                	        <a href="http://www.jquery2dotnet.com">Alumnos</a>
    	                                	</td>
        		                        </tr>
                                		<tr>
                                    		<td>
                                        		<span class="glyphicon glyphicon-shopping-cart"></span>
                                        		<a href="http://www.jquery2dotnet.com">Notas</a>
                                    		</td>
                                		</tr>
                            		</table>
                        		</div> <!-- panel body -->
                		</div> <!-- panelDefault -->
		</div> <!--  panel-group -->
	</div> <!-- div col3 -->

</div>