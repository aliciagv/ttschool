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
      									<form:input type="hidden" path="idEvent" name="idEvent"/>
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
        							
         							
         							<button type="button"  id="btnReset" class="btn btn-primary" data-id=" " data-toggle="modal" data-target="#DeleteModalEvent" >Borrar</button>
          							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      							</div>
    						</div>
    						

    					</form:form>
  						</div>
					</div>
					
					
					    							<div id="DeleteModalEvent" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Confirmación de Borrado</h4>
            </div>

            <div class="modal-body">
                <p>¿Estas seguro que quieres borrar la Notificación? </p>
                <input type="hidden" name="idEvento" id="idEvento"/>
            </div>
            <div class="modal-footer">

                 <button id="btnBorrar" type="button" class="btn btn-default" data-dismiss="modal">Borrar</button>
                 <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div> 
					
					

				</div>
			</div>
		</div> <!-- row -->
	</div><!-- container -->
</div><!-- col9 -->



