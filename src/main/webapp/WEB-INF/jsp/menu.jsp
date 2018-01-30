<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<div class="navegador">
	<div class="col-sm-3 col-md-3">
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
            	
            	<div class="panel-heading">
            		<h4 class="panel-title">
            			<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
            				<span class="glyphicon glyphicon-folder-close"></span>Administración
            			</a>
					</h4> <!-- panel-title -->
				</div> <!--  div panel-heading -->
				
				<div id="collapseOne" class="panel-collapse collapse in">
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
                 	</div><!-- collapseOne -->
               	</div><!-- panel panel-default -->
                
                <div class="panel panel-default">
                	<div class="panel-heading">
                        		<h4 class="panel-title">
                            		<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"><span class="glyphicon glyphicon-th">
                            		</span>Registro</a>
                        		</h4>
                    		</div> <!-- pannel-heading -->
                    		
                    		<div id="collapseTwo" class="panel-collapse collapse">
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
                                        		<a href="http://www.jquery2dotnet.com">Cursos</a>
                                    		</td>
                                		</tr>
                                		<tr>
                                    		<td>
                                        		<a href="http://www.jquery2dotnet.com">Notas</a>
                                    		</td>
                                		</tr>
                            		</table>
                        		</div><!-- panel-body -->
                    		</div> <!--  collapseTwo -->
                		</div><!-- panel panel-default -->
                		
                		<div class="panel panel-default">
                    		
                    		<div class="panel-heading">
                        		<h4 class="panel-title">
                            		<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"><span class="glyphicon glyphicon-bullhorn">
                            		</span>Notificaciones</a>
                        		</h4>
                    		</div> <!-- panel-heading -->
                    		
                    		<div id="collapseThree" class="panel-collapse collapse">
                        		<div class="panel-body">
                            		<table class="table">
                                		<tr>
                                    		<td>
                                    			<a href="http://www.jquery2dotnet.com">Globales</a>
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
                    		</div><!-- collapseThree -->
                		</div> <!--  panel-default-->
                		
                		<div class="panel panel-default">
                    		
                    		<div class="panel-heading">
                        		<h4 class="panel-title">
                            		<a data-toggle="collapse" data-parent="#accordion" href="#collapseFour"><span class="glyphicon glyphicon-file">
                            		</span>Informes</a>
                        		</h4>
                    		</div><!-- panel-heading -->
                    		
                    		<div id="collapseFour" class="panel-collapse collapse">
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
                    		</div> <!-- collapseFour -->
                		</div> <!-- panelDefault -->
		</div> <!--  panel-group -->
	</div> <!-- div col3 -->
</div><!-- div navegador -->
