<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<jsp:include page="../cabeceraTag.jsp" />
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
   		 <!-- Modal AddModalCurso-->
  		<div class="modal fade" id="AddModalCurso" role="dialog">
    		<div class="modal-dialog">
			<!-- Modal content-->
     		<c:url var="addAction" value="/curso" ></c:url>
			<form:form action="${addAction}" id="addCursoForm" commandName="curso" method="post">
				<div class="modal-content">
        			<div class="modal-header">
          				<button type="button" class="close" data-dismiss="modal">&times;</button>
          				<h4 class="modal-title" id="modalTitleAddCursoModal">Registrar nuevo curso</h4>
        			</div>
        			<div class="modal-body">
        				<div class="inputBox">
        					<div class="inputText">Nombre</div>
							<form:input path="nombre" type="text" name="nombre" class="input" required="required" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,50}" maxlength="50"/>
							<form:input type="hidden" path="idCurso" name="idCurso"/>
							<span class="help-block" id="error"></span>
						</div>
						<div class="inputBox">
							<div class="inputText">Letra</div>
							<form:input path="letra" type="text" name="letra" class="input" required="required" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,2}" maxlength="2"/>
							<span class="help-block" id="error"></span>
						</div>
						<div class="inputBox">
							<div class="inputText">Descripción</div>
							<form:input path="descripcion" type="text" name="descripcion" class="input"/>
							<span class="help-block" id="error"></span>
						</div>
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
  	 <!--  End Modal AddModalCurso-->
	
		<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
		<script src="<c:url value="/stacktable-1.0.2-13/stacktable.js" />"></script>
		<script src="<c:url value="/js/validation.js" />"></script>
    	<script src="<c:url value="/js/course.js" />"></script>
    	<script src="<c:url value="/js/pagination.js" />"></script>
	</body>
</html>