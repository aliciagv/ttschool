<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<jsp:include page="../cabeceraTag.jsp" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css"/>
		<link href="<c:url value="/stacktable-1.0.2-13/stacktable.css" />" rel="stylesheet" />  
	</head>
	<body>
		<jsp:include page="../cabecera.jsp"/>
		<div class="container principal">
    		<div class="wrapper principal">
    			<div class="row">
    				<jsp:include page="../menu.jsp"/>
    				<div id="cuerpo" class="cuerpo">
						<jsp:include page="listar.jsp"/>
            		</div><!-- cuerpo -->
    			</div> <!-- row -->
    		</div><!-- wrapper principal -->
    	</div> <!--  container principal -->
    	<jsp:include page="../footer.jsp"/>
    <!-- Modal AddModalProfesor-->
  <div class="modal fade" id="AddModalAlumno" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <c:url var="addAction" value="/alumno" ></c:url>
										
	 <form:form action="${addAction}" id="addAlumnoForm" commandName="alumno" method="post">
      

      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="modalTitleAddAlumnoModal">Registrar nuevo alumno</h4>
        </div>
        <div class="modal-body">
        									<div class="inputBox">
												<div class="inputText">Nombre</div>
												<form:input path="nombre" type="text" name="nombre" class="input" required="required" pattern="[a-zA-ZÃ¡Ã©Ã­Ã³ÃºÃÃÃÃÃÃ±Ã ]{1,50}" maxlength="50"/>
												<form:input type="hidden" path="idPersona" name="idPersona"/>
									  			<span class="help-block" id="error"></span>
											</div>
											<div class="inputBox">
												<div class="inputText">Apellidos</div>
												<form:input path="apellidos" type="text" name="apellidos" class="input" required="required" pattern="[a-zA-ZÃ¡Ã©Ã­Ã³ÃºÃÃÃÃÃÃ±Ã ]{1,100}" maxlength="100"/>
									  			<span class="help-block" id="error"></span>
											</div>
											
											<div class="inputBox">
												<div class="inputText">Nif</div>
												<form:input path="nif" type="text" name="nif" class="input"/>
									  			<span class="help-block" id="error"></span>
											</div>
											<div class="inputBox">
												<div class="inputText">Dirección</div>
												<form:input path="direccion" type="text" name="direccion" class="input"/>
									  			<span class="help-block" id="error"></span>
											</div>
											<div class="inputBox">
      											<div class="inputText">Fecha Nacimiento</div>
      											<form:input type="text" path="fNacimiento" name="fNacimiento"  class="input" data-date-format="yyyy-mm-dd"/>
		      									<span class="help-block" id="error"></span>
											</div>

											<div class="inputBox">
											<div class="inputText">Curso</div>
											<form:input type="hidden" path="curso.nombre"  name="curso.nombre" />
												<form:select path="curso.idCurso" name="curso" id="curso" class="input focus">
												 	<form:option value="0" label=" " />
        											<form:options items="${cursos}"  
        											itemValue="idCurso" 
        											itemLabel="descripcion"/>
												</form:select>
									  			<span class="help-block" id="error"></span>
											</div>
											

												
											<div class="form-group multiple-form-group" data-max=3>
												<div class="inputBox">
												<div class="inputText">Teléfono</div>
												<div class="form-group input-group">
													<form:input path="telefonos[0].numero" type="text" name="telefonos[]" class="inputplus" pattern="^[9|8|7|6]\d{8}$" maxlength="9" title="Teléfono con formato inválido. 9 dígitos comenzando con 9,8,7 ó 6"/>
													<form:input type="hidden" path="telefonos[0].idTelefono" class="inputplushidden" name="telefonos[0].idTelefono"/>
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
													<form:input path="emails[0].email" type="email" name="emails[]" class="inputplus" title="El email introducido no es válido"/>
													<form:input type="hidden" path="emails[0].idEmail" class="inputplushidden" name="emails[0].idEmail"/>
													<span class="input-group-btn">
														<button type="button" class="btn btn-default btn-add" value="emails">+</button>
													</span>
													</div>
													<span class="help-block" id="error"></span>
													</div>
											</div>
        
  		<div id="info" style="color: green;"></div>
        </div>
        <div class="modal-footer">
        <input type="submit" id="btnGuardar" class="btn btn-primary" value="Guardar">
         <input type="reset" id="btnReset" class="btn btn-info" value="Limpiar">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      </form:form>
    </div>
  </div>
  
 
  
  		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
  		<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
		<script src="<c:url value="/stacktable-1.0.2-13/stacktable.js" />"></script>
		<script src="<c:url value="/js/validation.js" />"></script>
    	<script src="<c:url value="/js/student.js" />"></script>
    	<script src="<c:url value="/js/pagination.js" />"></script>


	</body>
</html>