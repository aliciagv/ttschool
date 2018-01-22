<div class="col-sm-9 col-md-9">
	<ul id="navtabs" class="nav nav-tabs">
		<li  class="active"><a data-toggle="tab" href="#tab1">Nuevo profesor</a></li>
    	<li><a data-toggle="tab" href="#tab2">Listado de profesores</a></li>
  	</ul>
	
	<div class="tab-content">
		<div class="tab-pane fade in active" id="tab1">
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
												<input type="text" name="nombre" class="input" required="required" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,50}" maxlength="50"/>
									  			<span class="help-block" id="error"></span>
											</div>
											<div class="inputBox">
												<div class="inputText">Apellidos</div>
												<input type="text" name="apellidos" class="input" required="required" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{1,100}" maxlength="100"/>
									  			<span class="help-block" id="error"></span>
											</div>
											
											<div class="inputBox">
												<div class="inputText">Nif</div>
												<input type="text" name="nif" class="input"/>
									  			<span class="help-block" id="error"></span>
											</div>
											
											<div class="form-group multiple-form-group" data-max=3>
												<div class="inputBox">
												<div class="inputText">Teléfono</div>
												<div class="form-group input-group">
													<input type="text" name="telefono[]" class="inputplus" pattern="^[9|8|7|6]\d{8}$" maxlength="9" title="Teléfono con formato inválido. 9 dígitos comenzando con 9,8,7 ó 6"/>
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
													<input type="email" name="email[]" class="inputplus" title="El email introducido no es válido"/>
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

				<div class="tab-pane fade" id="tab2">
				<div class="container">
				<div class="row">
        			<div class="col-lg-12">
	                    <h3 class="page-header">Listado de profesores</h3>
    	            </div>
        	        <!-- /.col-lg-12 -->
        	       </div>
            	</div>
				
				</div>
                
           </div>
                    

		</div>