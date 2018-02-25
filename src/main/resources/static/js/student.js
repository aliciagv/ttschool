 $(document).ready(function() {
	 
	$("#AddModalAlumno form").validate({
            rules: {
            	nombre: { 
            		required: true, 
            		minlength:1,
            		maxlength: 50,
            		customname:true
            		},
            	
            	apellidos: {
            		required:true, 
            		minlength:1, 
            		maxlength: 100,
            		customname:true
            		},
            	
            	nif: {
            		required:false,
            		customnif:true
            		},
            		
            	"telefonos[0].numero":{
            		required:false,
            		customphone:true
            	},
                		
               	"telefonos[1].numero":{
            		required:false,
            		customphone:true
            	},
                    		
                "telefonos[2].numero":{
                	required:false,
                	customphone:true
                },
                
            	
            },
            messages: {
    			
    			nombre: {
    				required: 'El campo es requerido', 
    				minlength: 'El máximo permitido es 1 caracter', 
    				maxlength: 'El máximo permitido son 50 caracteres'
    					},
    			
            	apellidos: {
            		required: 'El campo es requerido', 
            		minlength: 'El máximo permitido es 1 caracter', 
            		maxlength: 'El máximo permitido son 100 caracteres'
            			}	
            	},
            	
    	     errorPlacement : function(error, element) {
    	         $(element).closest('.inputBox').find('.help-block').html(error.html());
    	         },
    	         highlight : function(element) {
    	         $(element).closest('.inputBox').removeClass('has-success').addClass('has-error');
    	         },
    	         unhighlight: function(element, errorClass, validClass) {
    	         $(element).closest('.inputBox').removeClass('has-error').addClass('has-success');
    	         $(element).closest('.inputBox').find('.help-block').html('');
    	         },
    	         
    		submitHandler: function(form)
            {
              alert('El formulario ha sido validado correctamente!');
              //form.submit();
              var theURL = form.action;
              var type = form.method;
              $.ajax({
            	  type : "POST",
            	  data : $(form).serialize(),
	    		  url : theURL,

                  success: function(response){
                	  var nombre= response.nombre;
                	  $('#AddModalAlumno').modal('hide');

                	 $('#mensaje').removeClass('alert-danger');
              		 $('#mensaje').addClass('alert-success');
              		 $('#mensaje').show();	
              		 $('#smensaje').text(nombre + " ha sido añadido");
              		 $('#mensaje').fadeOut(2000);
              		 window.setTimeout(function(){location.reload()},2000)
	 
                  },
                  error: function(e){ 
                	  	$('#AddModalProfesor').modal('hide');
                	    $('#mensaje').removeClass('alert-success');
						$('#mensaje').addClass('alert-danger');
						$('#mensaje').show();	
						$('#smensaje').text("Ha habido un error al crear. Intentelo de nuevo más tarde"+ e.responseJSON.errorMessage);
						
                }
    		
    			
    		});
            }
        });

      	$('#listado').stacktable();
    	var date_input=$('input[name="fNacimiento"]'); //our date input has the name "date"
    	var container=$('#AddModalAlumno  form').length>0 ? $('#AddModalAlumno  form').parent() : "body";
    	date_input.datepicker({
    		container: container,
    		todayHighlight: true,
    		autoclose: true,
    		changeMonth: true,
    		changeYear: true,
    		minDate: "01/01/1920",
    		maxDate: "-3y"
    	});
      	
        $('th').click(function() {
            var table = $(this).parents('table').eq(0)
            var rows = table.find('tr:gt(0)').toArray().sort(comparer($(this).index()))
            this.asc = !this.asc
            if (!this.asc) {
              rows = rows.reverse()
            }
            for (var i = 0; i < rows.length; i++) {
              table.append(rows[i])
            }
            setIcon($(this), this.asc);
          })

          function comparer(index) {
            return function(a, b) {
              var valA = getCellValue(a, index),
                valB = getCellValue(b, index)
              return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA.localeCompare(valB)
            }
          }

          function getCellValue(row, index) {
            return $(row).children('td').eq(index).html()
          }

          function setIcon(element, asc) {
            $("th").each(function(index) {
              $(this).removeClass("sorting");
              $(this).removeClass("asc");
              $(this).removeClass("desc");
            });
            element.addClass("sorting");
            if (asc) element.addClass("asc");
            else element.addClass("desc");
          }

      	$('#myTable').pageMe({pagerSelector:'#myPager',showPrevNext:true,hidePageNumbers:false,perPage:5});
      	
      	 xphone = 0; //Initial field counter is 1
      	 xemail =0;
         $(".input").focus(function() {
     		$(this).parent().addClass("focus");
     	});
     	
     	$(".inputplus").focus(function() {
     		$(this).parent().parent().addClass("focus");
     	});
      	
     	
     	$('#AddModalAlumno').on('hidden.bs.modal', function(){ 
     		//xphone = 0; //Initial field counter is 1
    		//$("#profesor").click();
     		$(this).find('form')[0].reset(); //para borrar todos los datos que tenga los input, textareas, select.
     		$(this).find('form').find(".inputplushidden").val(null); // para borrar todos los hidden
    		$('.modal-body').find('.help-block').text(''); // eliminar todos los mensajes de validación
    		$('.modal-body').find('.inputBox').removeClass("focus"); // remove class focus
    		$('#addProfesorForm').find('select').find('option').not(':first').remove();
    		var modelatt,valor;
    		var $formGroup,$inputplus;
    		if (xphone>0){
    			modelatt="numero";
    			valor="telefonos";
    				
    			for (i = xphone; i > 0; i--) { 
    				 $inputplus= $('.input-group').find('#'+valor+i+"\\."+modelatt);
    				 //console.log("$inputplus length " +$inputplus.length);
    				 $formGroup=$inputplus.closest('.form-group');
    				 $formGroup.remove();
    				
    			}
    			xphone = 0; //Initial field counter is 1
    			$inputplus= $('.input-group').find('#'+valor+xphone+"\\."+modelatt);
				$formGroup=$inputplus.closest('.form-group');
				$formGroup.find('.btn').toggleClass('btn-default btn-add btn-danger btn-remove').html("+");
				 
				
    			
    		}
    		
    		if (xemail>0){
    			modelatt="email";
    			valor="emails";
    			for (i = xemail; i > 0; i--) { 
    				 $inputplus= $('.input-group').find('#'+valor+i+"\\."+modelatt);
    				 $formGroup=$inputplus.closest('.form-group');
    				 $formGroup.remove();
    			}
    			
    			xemail = 0; //Initial field counter is 1
    			$inputplus= $('.input-group').find('#'+valor+xemail+"\\."+modelatt);
				$formGroup=$inputplus.closest('.form-group');
				$formGroup.find('.btn').toggleClass('btn-default btn-add btn-danger btn-remove').html("+");
    			
    		}

       	 	
    	});
     	
    	
		
});
	 
	
	 
	 var addFormGroup = function (event) {
     		
		 	event.preventDefault();
		 	var xaux,modelatt,idmodelatt;
     		var valor = $(this).attr('value');
     		if(valor == "telefonos"){
     			alert("XPHONE "+xphone);
     			xphone++;
     			xaux=xphone;
     			modelatt="numero";     	
     			idmodelatt="idTelefono";
     		}
     		if(valor == "emails"){
     			alert("XEMAIL "+xemail);
     			xemail++;
     			xaux=xemail;
     			modelatt="email";
     			idmodelatt="idEmail";
     		}

             var $formGroup = $(this).closest('.form-group');
             var $multipleFormGroup = $formGroup.closest('.multiple-form-group');
             var $formGroupClone = $formGroup.clone();
            // $formGroup.find('.inputplus').attr("name",valor+"[]");

             $(this)
                 .toggleClass('btn-default btn-add btn-danger btn-remove')
                 .html('–');
             
             $formGroupClone.find('.inputplus').val('');
             $formGroupClone.find('.inputplus').attr("id",valor+xaux+"."+modelatt);
             $formGroupClone.find('.inputplus').attr("name",valor+"["+xaux+"]."+modelatt);
             //$formGroupClone.find('.inputplus').attr("name",valor+"[]");
             $formGroupClone.find('.inputplushidden').attr("id",valor+xaux+"."+idmodelatt);
             $formGroupClone.find('.inputplushidden').attr("name",valor+"["+xaux+"]."+idmodelatt);
             $formGroupClone.find('.inputplushidden').val(null);
             //$formGroupClone.find('.inputplus').attr("name",valor+"[]");
             $formGroupClone.insertAfter($formGroup);

             var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
             if ($multipleFormGroup.data('max') <= countFormGroup($multipleFormGroup)) {
                 $lastFormGroupLast.find('.btn-add').attr('disabled', true);
             }
        
     	
     	};
       
     

     var removeFormGroup = function (event) {
         event.preventDefault();
  		var valor = $(this).attr('value');
  		
  		var modelatt;
		 
  		var $formGroup = $(this).closest('.form-group');
        var $multipleFormGroup = $formGroup.closest('.multiple-form-group');
        
 		if(valor == "telefonos"){
 			alert("XPHONE remove "+xphone);
 			modelatt="numero"; 
 			var $inputplus= $multipleFormGroup.find('#'+valor+xphone+"\\."+modelatt);
 			var $formGroup = $inputplus.closest('.form-group');
 			$formGroup.remove();
 			xphone --;
 			//anterior se convierte en +
 			var $inputplusant= $multipleFormGroup.find('#'+valor+xphone+"\\."+modelatt);
 			var $formGroupant = $inputplusant.closest('.form-group');
 			//toggleClass: método alterna entre la adición y la eliminación de uno o más nombres de las clases de los elementos seleccionados
 			//Los nombres de las clases se agregan si falta, y eliminado si ya está establecido
 			$formGroupant.find('.btn').toggleClass('btn-default btn-add btn-danger btn-remove').html("+");
 			
 		}
 		if(valor == "emails"){
 			alert("XEMAIL remove "+xemail);
 			modelatt="email";
 			var $inputplus= $multipleFormGroup.find('#'+valor+xemail+"\\."+modelatt);
 			var $formGroup = $inputplus.closest('.form-group');
 			$formGroup.remove();
 			xemail --;
 			//anterior se convierte en +
 			var $inputplusant= $multipleFormGroup.find('#'+valor+xemail+"\\."+modelatt);
 			var $formGroupant = $inputplusant.closest('.form-group');
 			//toggleClass: método alterna entre la adición y la eliminación de uno o más nombres de las clases de los elementos seleccionados
 			//Los nombres de las clases se agregan si falta, y eliminado si ya está establecido
 			$formGroupant.find('.btn').toggleClass('btn-default btn-add btn-danger btn-remove').html("+");
 			
 			
 		}

     };

     var countFormGroup = function ($form) {
         return $form.find('.form-group').length;
     };

     $(document).on('click', '.btn-add', addFormGroup);
     $(document).on('click', '.btn-remove', removeFormGroup);
     

     		

	 
	 function eliminar(uri, button) {

					$.ajax({
						type : "GET",
						url : uri,
						success : function(data) {
							if(data=="ok"){
							  $('#mensaje').removeClass('alert-danger');
							  $('#mensaje').addClass('alert-success');
							  $('#mensaje').show();	
							  $('#smensaje').text("El registro se ha borrado correctamente");
						      $('#mensaje').fadeOut(10000);
						      $boton = $('#listado').find('#'+button);
						      console.log ("BOTON " +$boton.length);
						      $boton.closest('tr').remove();
						      
						
							}else{
								$('#mensaje').removeClass('alert-success');
								$('#mensaje').addClass('alert-danger');
								$('#mensaje').show();	
								$('#smensaje').text("Ha habido un error al borrar. Intentelo de nuevo más tarde");
							      
							}
						},  
						error: function(e){ 
		                	  $('#mensaje').removeClass('alert-success');
								$('#mensaje').addClass('alert-danger');
								$('#mensaje').show();	
								$('#smensaje').text("Ha habido un error al borrar. Intentelo de nuevo más tarde");
		                }
					});
					
		};
	
 	
		 function editar(uri) {
				$.ajax({
					type : "GET",
					url : uri,
					success : function(data) {
						//alert ("SUCCESS");
						
						console.log(data);
						$('#addAlumnoForm').find('[name="idPersona"]').val(data.idPersona);
						
						$('#addAlumnoForm').find('[name="nombre"]').val(data.nombre);
						$('#addAlumnoForm').find('[name="nombre"]').parent().addClass("focus");
						
						$('#addAlumnoForm').find('[name="apellidos"]').val(data.apellidos);
						$('#addAlumnoForm').find('[name="apellidos"]').parent().addClass("focus");
						
						if (data.nif!=null){
							$('#addAlumnoForm').find('[name="nif"]').val(data.nif);
							$('#addAlumnoForm').find('[name="nif"]').parent().addClass("focus");
						}
						if (data.direccion!=null){
							$('#addAlumnoForm').find('[name="direccion"]').val(data.direccion);
							$('#addAlumnoForm').find('[name="direccion"]').parent().addClass("focus");
						}
						if (data.fNacimiento!=null){
							$('#addAlumnoForm').find('[name="fNacimiento"]').val(data.fNacimiento);
							$('#addAlumnoForm').find('[name="fNacimiento"]').parent().addClass("focus");
						}
						
						if (data.curso!=null){
							if (data.curso.idCurso!=null){
								$('#addAlumnoForm').find('select').append(new Option(data.curso.descripcion, data.curso.idCurso, true, true));
								$('#addAlumnoForm').find('select').parent().addClass("focus");
								
							}
						}
						var $multipleFormGroup,$lastFormGroupLast,$button,$inputplus;
						var telefonos= data.telefonos;
						if (telefonos!=null){
							if (telefonos.length>0){
								 
								$('#addAlumnoForm').find('[name="telefonos[0].numero"]').parent().parent().addClass("focus");
							
							for (i=0; i<telefonos.length; i++){

								if (i>0){
									//'#'+valor+xemail+"\\."+modelatt
									 $inputplus= $('#addAlumnoForm').find('.input-group').find('#telefonos0\\.numero');
									 $formGroup=$inputplus.closest('.form-group');
				    				 $multipleFormGroup = $formGroup.closest('.multiple-form-group');
				    				//  $multipleFormGroup = $('#addProfesorForm').find('.multiple-form-group');
								     $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
								     $button=$lastFormGroupLast.find('.btn');
								     $button.click();
									
								}
								//$('#addProfesorForm').find('[name="telefonos['+i+'].idTelefono"]').val(telefonos[i].idTelefono);
								//$('#addProfesorForm').find('[name="telefonos['+i+'].numero"]').val(telefonos[i].numero);
								//#emails0\\.email
								$('#addAlumnoForm').find('#telefonos'+i+'\\.idTelefono').val(telefonos[i].idTelefono);
								$('#addAlumnoForm').find('#telefonos'+i+'\\.numero').val(telefonos[i].numero);
							}
						}
						}
						var emails= data.emails;
						
						if (emails!=null){

							if (emails.length>0){

								$('#addAlumnoForm').find('[name="emails[0].email"]').parent().parent().addClass("focus");
							
							for (i=0; i<emails.length; i++){

								if (i>0){
									//'#'+valor+xemail+"\\."+modelatt
									 $inputplus= $('#addProfesorForm').find('.input-group').find('#emails0\\.email');
									 $formGroup=$inputplus.closest('.form-group');
				    				 $multipleFormGroup = $formGroup.closest('.multiple-form-group');
				    				//  $multipleFormGroup = $('#addProfesorForm').find('.multiple-form-group');
								     $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
								     $button=$lastFormGroupLast.find('.btn');
								     $button.click();
									
								}
								//$('#addProfesorForm').find('[name="emails['+i+'].idEmail"]').val(emails[i].idEmail);
								//$('#addProfesorForm').find('[name="emails['+i+'].email"]').val(emails[i].email);
								//#emails0\\.email
								$('#addAlumnoForm').find('#emails'+i+'\\.idEmail').val(emails[i].idEmail);
								$('#addAlumnoForm').find('#emails'+i+'\\.email').val(emails[i].email);
								
							}
						}
						
							
							
						}
						$('#modalTitleAddAlumnoModal').text("Modificar profesor");
						$('#btnReset').remove();
						$('#btnGuardar').val("Modificar");
						
						
						 $("#AddModalAlumno").modal("show");
						
						
					},  
					error: function(e){
						alert ("ERROR");
					}
				});
				
	};
	

	
	 

       
    	




