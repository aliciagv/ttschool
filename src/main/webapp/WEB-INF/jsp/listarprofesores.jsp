<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 col-md-9">	
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<%--<a id="profesorform" href="#">Profesor</a>--%>
				<button type="button" class="btn btn-info btn-sm btmodal" data-toggle="modal" data-target="#AddModalProfesor">Nuevo profesor</button>
			</div><!-- /.col-lg-12 -->
			<div class="col-lg-12">
				<h3 class="page-header">${titulo}</h3>
			</div><!-- /.col-lg-12 -->
		</div> <!-- row -->
		<div class="row">
			<div class="col-lg-1">
			</div>
			<div class="col-lg-8">
				<div class="panel panel-default">
					<div class="panel-body">
							<table id="listado">
								<thead>
									<tr>
	         								<th>Nombre</th>
	         								<th>Apellidos</th>
	         								<th>Nif</th>
	         								<th>Curso</th>
	         								<th>Letra</th>
	         								<th>Teléfonos</th>
	         								<th>Emails</th>
	         								<sec:authorize access="hasRole('ADMIN')">
	         								<th>Editar</th>
	         								<th>Eliminar</th>
	         								</sec:authorize>
	    								</tr>
	           							
	       						</thead>
									<tbody>
										<c:forEach var="profesorModel" items="${profesores}">
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
	         										<td>
	         	  										<a id="editarProfesor" href="#"  onclick="editProfesor(${profesorModel.idPersona})" >Editar</a></td>
	         									<!--   <a href="#editTeacher_${profesorModel.idPersona}" role="button" class="btn btn-large btn-primary" data-toggle="modal">Editar</a>-->
	   											<td>
	         	
	         										<button class="eliminar" data-id="${profesorModel.idPersona}" data-url="profesor/delete">Eliminar</button></td>
											</sec:authorize>
	    									</tr>
									</c:forEach>
	         					</tbody>
						</table>
						</div><!-- panel-body -->
	   			</div><!-- panel panel-default -->
	 			</div><!-- col-lg-8 -->
		</div><!-- row -->
	</div><!-- container -->
</div>	


    <!-- Modal -->
  <div class="modal fade" id="AddModalProfesor" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <c:url var="addAction" value="/profesor/add" ></c:url>
										
	 <form:form action="${addAction}"  commandName="profesor" method="post">
      

      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Registrar nuevo profesor</h4>
        </div>
        <div class="modal-body">
        	<div class="inputBox">
												<div class="inputText">Nombre</div>
												<form:input path="nombre" type="text" name="nombre" class="input" required="required" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,50}" maxlength="50"/>
									  			<span class="help-block" id="error"></span>
											</div>
											<div class="inputBox">
												<div class="inputText">Apellidos</div>
												<form:input path="apellidos" type="text" name="apellidos" class="input" required="required" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,100}" maxlength="100"/>
									  			<span class="help-block" id="error"></span>
											</div>
											
											<div class="inputBox">
												<div class="inputText">Nif</div>
												<form:input path="nif" type="text" name="nif" class="input"/>
									  			<span class="help-block" id="error"></span>
											</div>

											<div class="form-group multiple-form-group" data-max=3>
												<div class="inputBox">
												<div class="inputText">Telefono</div>
												<div class="form-group input-group">
													<form:input path="telefonos[0].numero" type="text" name="telefono[]" class="inputplus" pattern="^[9|8|7|6]\d{8}$" maxlength="9" title="Tel�fono con formato inv�lido. 9 d�gitos comenzando con 9,8,7 � 6"/>
													<span class="input-group-btn">
														<button type="button" class="btn btn-default btn-add" value="telefonos">+</button>
													</span>
												</div>
												<span class="help-block" id="error"></span>  
												</div>
											</div>
											
											<div class="form-group multiple-form-group" data-max=3>
												<div class="inputBox">
													<div class="inputText">Email</div>
													<div class="form-group input-group">
													<form:input path="emails[0].email" type="email" name="email[]" class="inputplus" title="El email introducido no es v�lido"/>
													<span class="input-group-btn">
														<button type="button" class="btn btn-default btn-add-email" value="emails">+</button>
													</span>
													</div>
													<span class="help-block" id="error"></span>  
												</div>
											</div>
        
  
        </div>
        <div class="modal-footer">
        <input type="submit" class="btn btn-primary" value="Guardar">
         <input type="reset" class="btn btn-info" value="Limpiar">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      </form:form>
    </div>
  </div>
<script src="js/validation.js"></script>
<script src="js/teacher.js"></script>

