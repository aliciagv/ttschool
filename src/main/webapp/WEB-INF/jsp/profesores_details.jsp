<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                  <div class="modal fade" id="editTeacher">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="ModalTitle">Esto es un modal</h4>
			</div>
			<div class="modal-body">
				Texto del modal
				${profesorDetail.idPersona}
				${profesorDetail.nombre}
				${profesorDetail.apellidos}
			</div>
		</div>
	</div>
</div> 