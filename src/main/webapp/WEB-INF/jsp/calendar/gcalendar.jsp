<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-sm-9 col-md-9">
	<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<div id="mensaje" class="alert alert-dismissable" hidden="true">
   				 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
   				  <span id="smensaje"></span>
   			 </div>
			</div>
			<div class="col-lg-12">
				<h3 class="page-header">${titulo}</h3>
			</div><!-- /.col-lg-12 -->
			
		</div><!-- row -->
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-8">
				<div class="panel panel-default">
					<div class="panel-body">
						<div id='calendar'></div>
					</div>
				

					<!-- Modal Create Event -->
					<div class="modal fade" id="CreateModalEvent">
  						<div class="modal-dialog" role="document">
  						<c:url var="addAction" value="/colegio/global/event" ></c:url>
						<form:form action="${addAction}" id="createEventForm" commandName="event" method="post">
    						<div class="modal-content">
      							<div class="modal-header">
        							<h4 class="modal-title" id="modalTitleCreateEvent">Crear Notificación</h4>
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          								<span aria-hidden="true">&times;</span>
        							</button>
      							</div>
      							<div class="modal-body">
      								<div class="inputBox">
      									<div class="inputText">Inicio</div>
      									<form:input type="text" path="start" name="start"  class="input"/>
										<span class="help-block" id="error"></span>
									</div>
									<div class="inputBox">
      									<div class="inputText">Fin</div>
      									<form:input type="text" path="end" name="end"  class="input" data-date-format="yyyy-mm-dd"/>
      									
										<span class="help-block" id="error"></span>
									</div>
									<div class="inputBox">
      									<div class="inputText">Evento</div>
      									<form:input type="text" path="title" name="title"  class="input"/>
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
				</div>
			</div>
		</div> <!-- row -->
	</div><!-- container -->
</div><!-- col9 -->



