<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 col-md-9">	
			<div class="container">
				<div class="row">
        			<div class="col-lg-12">
	                    <h3 class="page-header">${titulo}</h3>
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
									<c:url var="addAction" value="/profesor/add" ></c:url>
										
										<form:form action="${addAction}" commandName="profesor">
										
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
												<div class="inputText">Teléfono</div>
												<div class="form-group input-group">
													<form:input path="telefonos[0].numero" type="text" name="telefono[]" class="inputplus" pattern="^[9|8|7|6]\d{8}$" maxlength="9" title="Teléfono con formato inválido. 9 dígitos comenzando con 9,8,7 ó 6"/>
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
													<form:input path="emails" type="email" name="email[]" class="inputplus" title="El email introducido no es válido"/>
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
										
										
					
				</form:form>
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