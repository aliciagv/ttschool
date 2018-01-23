<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 col-md-9">
	<ul id="navtabs" class="nav nav-tabs">
		
    		<li class="active"><a data-toggle="tab" href="#tab2">Listado de profesores</a></li>
    	
    	<sec:authorize access="hasRole('ADMIN')">
			<li><a data-toggle="tab" href="#tab1">Nuevo profesor</a></li>
			</sec:authorize>
  	</ul>
	
	<div class="tab-content">
	<sec:authorize access="hasRole('ADMIN')">
		<div class="tab-pane fade" id="tab1">
			<div class="container">
				<div class="row">
        			<div class="col-lg-12">
	                    <h3 class="page-header">Registrar nuevo profesor</h3>
    	            </div>
        	        <!-- /.col-lg-12 -->
            	</div>
            <div class="row">
            	<div class="col-lg-1"></div>
             	<div class="col-lg-8">
                    <div class="panel panel-default">
                    	<div class="panel-heading" id="mypanelId">
                        	<h3 class="panel-title">Datos del profesor</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-10">
									<div class="formBox">
										<form id="formprofesor" role="form">
											<div class="inputBox">
												<div class="inputText">Nombre</div>
												<input type="text" name="nombre" class="input" required="required" pattern="[a-zA-Z������������ ]{1,50}" maxlength="50"/>
									  			<span class="help-block" id="error"></span>
											</div>
											<div class="inputBox">
												<div class="inputText">Apellidos</div>
												<input type="text" name="apellidos" class="input" required="required" pattern="[a-zA-Z������������ ]{1,100}" maxlength="100"/>
									  			<span class="help-block" id="error"></span>
											</div>
											
											<div class="inputBox">
												<div class="inputText">Nif</div>
												<input type="text" name="nif" class="input"/>
									  			<span class="help-block" id="error"></span>
											</div>
											
											<div class="form-group multiple-form-group" data-max=3>
												<div class="inputBox">
												<div class="inputText">Tel�fono</div>
												<div class="form-group input-group">
													<input type="text" name="telefono[]" class="inputplus" pattern="^[9|8|7|6]\d{8}$" maxlength="9" title="Tel�fono con formato inv�lido. 9 d�gitos comenzando con 9,8,7 � 6"/>
													<span class="input-group-btn">
														<button type="button" class="btn btn-default btn-add">+</button>
													</span>
												</div>
												<span class="help-block" id="error"></span>  
												</div>
											</div>
											
											<div class="form-group multiple-form-group" data-max=3>
												<div class="inputBox">
													<div class="inputText">Email</div>
													<div class="form-group input-group">
													<input type="email" name="email[]" class="inputplus" title="El email introducido no es v�lido"/>
													<span class="input-group-btn">
														<button type="button" class="btn btn-default btn-add">+</button>
													</span>
													</div>
													<span class="help-block" id="error"></span>  
												</div>
											</div>
						
				

						
										<p class="text-right">
                                			<button type="reset" class="btn btn-info" style="margin-right: 20px">Limpiar</button>
                                			<button type="submit" class="btn btn-primary">Guardar</button>
                            			</p> 

					
				</form>
			</div>
			 </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-3">
            </div>
            </div>
            <!-- /.row -->
		</div> <!-- container -->
				</div>
</sec:authorize>
				<div class="tab-pane fade in active" id="tab2">
				<div class="container">
					<div class="row">
        				<div class="col-lg-12">
	                    	<h3 class="page-header">Listado de profesores</h3>
    	            	</div>
        	        	<!-- /.col-lg-12 -->
            		</div>
            		<div class="row">
						<div class="col-lg-1"></div>
             			<div class="col-lg-8">
						<div class="panel panel-default">
						<div class="panel-body">
            				<div>
                				<table id="listado">
                  					<thead>
                  					 <tr>
          <th>Nombre</th>
          <th>Apellidos</th>
          <th>Nif</th>
          <th>Curso</th>
          <th>Letra</th>
          <th>Tel�fonos</th>
          <th>Emails</th>
          <sec:authorize access="hasRole('ADMIN')">
          	<th>Editar</th>
          	<th>Eliminar</th>
          </sec:authorize>
     </tr>
            							
        </thead>
 <tbody>
 <c:forEach var="profesorModel" items="${listprofesorModel}">
 	  <tr>
          <td>${profesorModel.nombre}</td>
          <td>${profesorModel.apellidos}</td>
          <td>${profesorModel.nif}</td>
          <td>1</td>
          <td>A</td>
          <td>
          <c:forEach var="telefonoModel" items="${profesorModel.telefonos}">
          ${telefonoModel.numero}</br>
          </c:forEach>
          </td>
          <td>
          <c:forEach var="emailModel" items="${profesorModel.emails}">
          ${emailModel.email}</br>
          </c:forEach>
          </td>
														
           <sec:authorize access="hasRole('ADMIN')">
          	<td><a id="editarProfesor" href="#"  onclick=\"editProfesor('" + ${profesorModel.idPersona}+ "');\" >Editar</a></td>
          	<td><button class="eliminar" data-id="${profesorModel.idPersona}" data-url="profesor/delete">Eliminar</button></td>
          </sec:authorize>
     </tr>
 </c:forEach>
          </tbody>

                </table>
            </div>
            
        </div>
    </div>
  </div>

    </div>
                                
                            </div>
                            
                  
                </div>
                <!-- /.col-lg-12 -->

            </div>
            <!-- /.row -->
    <div id="modalProfesor">

        
	<div class="modal fade" id="editprofesorModal" tabindex="-1" role="dialog" aria-labelledby="editprofesorLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Esto es un modal</h4>
			</div>
			<div class="modal-body">
				Texto del modal
			</div>
		</div>
	</div>
</div>            
		</div> <!-- container -->
</div>
