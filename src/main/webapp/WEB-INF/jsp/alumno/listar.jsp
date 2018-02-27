<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="col-sm-9 col-md-9">
	<div class="container">
		<div class="row">
			<sec:authorize access="hasRole('ADMIN')">
				<div class="col-lg-12">
					<button type="button" class="btn btn-info btn-sm btmodal" data-toggle="modal" data-target="#AddModalAlumno">Nuevo alumno</button>
				</div><!-- /.col-lg-12 -->
			</sec:authorize>
			<div class="col-lg-8">
				<div id="mensaje" class="alert alert-dismissable" hidden="true">
   					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
   				  	<span id="smensaje"></span>
   			 	</div>
			</div>
			
			<div class="col-lg-12">
				<h3 class="page-header">${titulo}</h3>
			</div><!-- /.col-lg-12 -->
		</div> <!-- row -->
		<div class="row">
			<div class="col-lg-1">
			</div>
			<div class="col-lg-10">
			<div id="dexcel" align="right">
			<a href="alumno/export"><img  alt="excel" width="4%" height="4%" src="<c:url value="/imgs/Excel-icon.png" />"> </a>
			</div>
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
	         								<th>Direcci�n</th>
	         								<th>Fecha de nacimiento</th>
	         								<th>Tel�fonos</th>
	         								<th>Emails</th>
	         								<sec:authorize access="hasRole('ADMIN')">
	         								<th>Editar</th>
	         								<th>Eliminar</th>
	         								</sec:authorize>
	    								</tr>
	           							
	       						</thead>
									<tbody id="myTable">
										<c:forEach var="alumnoModel" items="${alumnos}">
		  									<tr>
	         									<td>${alumnoModel.nombre}</td>
	         									<td>${alumnoModel.apellidos}</td>
	         									<td>${alumnoModel.nif}</td>
	         									<td>${alumnoModel.curso.nombre}</td>
	         									<td>${alumnoModel.curso.letra}</td>
	         									<td>${alumnoModel.direccion}</td>
	         									<td>${alumnoModel.fNacimiento}</td>
	         									<td>
	         										<c:forEach var="telefonoModel" items="${alumnoModel.telefonos}">
	         											${telefonoModel.numero}</br>
	         										</c:forEach>
	         									</td>
	         									<td>
	         										<c:forEach var="emailModel" items="${alumnoModel.emails}">
	         										${emailModel.email}</br>
	         										</c:forEach>
	         									</td>
														
	          									<sec:authorize access="hasRole('ADMIN')">
	         										<td>
	         											<button id="editarAlumno"  type="button" class="btn btn-info btn-sm"  onclick="editar('<c:url value="/alumno/alumno/${alumnoModel.idPersona }" />');"><span class="glyphicon glyphicon-edit"></span></button>
	         											
	         	  									</td>
	         									
	   											<td>
	   											    <button id="eliminarAlumno${alumnoModel.idPersona }" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#DeleteModalAlumno${alumnoModel.idPersona }"><span class="glyphicon glyphicon-trash"></span></button>
	         									
	         									</td>	
											</sec:authorize>
	    									</tr>
	    									
	    									<div id="DeleteModalAlumno${alumnoModel.idPersona }" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Confirmaci�n de Borrado</h4>
            </div>

            <div class="modal-body">
                <p>�Estas seguro que quieres borrar el Alumno? </p>
            </div>
            <div class="modal-footer">

                 <button id="btnBorrar" type="button" class="btn btn-default" data-dismiss="modal" onclick="eliminar('<c:url value="/alumno/${alumnoModel.idPersona }" />', 'eliminarAlumno${alumnoModel.idPersona }');">Borrar</button>
                 <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div> 
									</c:forEach>
	         					</tbody>
						</table>
						</div><!-- panel-body -->
	   			</div><!-- panel panel-default -->
	   			 <!--  <ul class="pagination pagination-lg pager" id="myPager"></ul> -->
	   			<ul class="pagination pull-right" id="myPager"></ul>
	 			</div><!-- col-lg-8 -->
		</div><!-- row -->
	</div><!-- container -->
            			</div><!-- col9 -->