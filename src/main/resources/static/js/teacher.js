 $(document).ready(function() {
	 
	$("#AddModalProfesor form").validate({
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
            	
            	"telefonos[]":{
            		required:false,
            		customphone:true
            		},
            		
            	"emails[]":{
                		required:false,
                		customemail:true
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

            	  /*beforeSend: function(x){ 
            	  alert("antes")
            	  },*/
                  success: function(response){
                	  if (response.validated){
                		 
                		  $('#AddModalProfesor').modal('hide');
                		  $('#mensaje').removeClass('alert-danger');
              			  $('#mensaje').addClass('alert-success');
              			  $('#mensaje').show();	
              			  $('#smensaje').text(response.profesorModel.nombre + " ha sido añadido");
              		      $('#mensaje').fadeOut(10000);
              		      appendRow(response);
                		

                	  } else {
                		    $('#mensaje').removeClass('alert-success');
							$('#mensaje').addClass('alert-danger');
							$('#mensaje').show();	
							$('#smensaje').text("Ha habido un error al crear. Intentelo de nuevo más tarde");
                	  }
                  },
                  error: function(e){ 
                	  ('#mensaje').removeClass('alert-success');
						$('#mensaje').addClass('alert-danger');
						$('#mensaje').show();	
						$('#smensaje').text("Ha habido un error al crear. Intentelo de nuevo más tarde");
                }
    		
    			
    		});
            }
        });

      	$('#listado').stacktable();
      	
      	 xphone = 0; //Initial field counter is 1
      	 xemail =0;
         $(".input").focus(function() {
     		$(this).parent().addClass("focus");
     	});
     	
     	$(".inputplus").focus(function() {
     		$(this).parent().parent().addClass("focus");
     	});
      	
     	
     	$('#AddModalProfesor').on('hidden.bs.modal', function(){ 
     		//xphone = 0; //Initial field counter is 1
    		//$("#profesor").click();
     		$(this).find('form')[0].reset(); //para borrar todos los datos que tenga los input, textareas, select.
    		$('.modal-body').find('.help-block').text(''); // eliminar todos los mensajes de validación
    		$('.modal-body').find('.inputBox').removeClass("focus"); // remove class focus
    		var modelatt,valor;
    		var $formGroup,$inputplus;
    		if (xphone>0){
    			modelatt="numero";
    			valor="telefonos";
    				
    			for (i = xphone; i > 0; i--) { 
    				 $inputplus= $('.input-group').find('#'+valor+i+"\\."+modelatt);
    				 console.log("$inputplus length " +$inputplus.length);
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
		 	var xaux,modelatt;
     		var valor = $(this).attr('value');
     		if(valor == "telefonos"){
     			alert("XPHONE "+xphone);
     			xphone++;
     			xaux=xphone;
     			modelatt="numero";     			
     		}
     		if(valor == "emails"){
     			alert("XEMAIL "+xemail);
     			xemail++;
     			xaux=xemail;
     			modelatt="email";
     		}
     		// "index.htm\" target:\"_self\""
             var $formGroup = $(this).closest('.form-group');
             var $multipleFormGroup = $formGroup.closest('.multiple-form-group');
             var $formGroupClone = $formGroup.clone();
             $formGroup.find('input').attr("name",valor+"[]");

             $(this)
                 .toggleClass('btn-default btn-add btn-danger btn-remove')
                 .html('–');
             
             $formGroupClone.find('input').val('');
             $formGroupClone.find('input').attr("id",valor+xaux+"."+modelatt);
             //$formGroupClone.find('input').attr("name",valor+"["+xaux+"]."+modelatt);
             $formGroupClone.find('input').attr("name",valor+"[]");
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
     

     		
		
	 function appendRow(response){
		 
		
				var nuevafila= "<tr><td>" +
				response.profesorModel.nombre + "</td><td>" +
				response.profesorModel.apellidos + "</td><td>";
				
				if (response.profesorModel.nif==null){
					nuevafila+= "</td><td>";
					
				} else {
					nuevafila +=response.profesorModel.nif + "</td><td>"; 
				}
				
				nuevafila+="</td><td>" +
							"</td><td>"
				
				if (response.profesorModel.emails!=null){
					var emails = response.profesorModel.emails.length;
					for (  i = 0 ; i < emails; i++){
						if (i >0){
							nuevafila+= ", "
						}
						nuevafila+=response.profesorModel.emails[i]
					} 
				}
				nuevafila+="</td><td>"
				
				if (response.profesorModel.telefonos!=null){
				var telefonos = response.profesorModel.telefonos.length;
				for (  i = 0 ; i < telefonos; i++){
					if (i >0){
						nuevafila+= ", "
					}
					nuevafila+=response.profesorModel.telefonos[i]
				} 
				}
				nuevafila+="</td><td></td></td><td></td></tr>"
					
				$("#listado").append(nuevafila)
			
	 }
	 
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
	
 	
	
	 

       
    	




