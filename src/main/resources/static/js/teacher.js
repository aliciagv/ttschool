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
            	
            	"telefono[]":{
            		required:false,
            		customphone:true
            		}
            	
            		
            	
            	
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
              form.submit();
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
      	
     	
     	$('.modal').on('hidden.bs.modal', function(){ 
     		//xphone = 0; //Initial field counter is 1
    		//$("#profesor").click();
     		$(this).find('form')[0].reset(); //para borrar todos los datos que tenga los input, textareas, select.
    		$('.modal-body').find('.help-block').text(''); // eliminar todos los mensajes de validación
    		$('.modal-body').find('.inputBox').removeClass("focus"); // remove class focus
    		var modelatt,valor;
    		
    		if (xphone>0){
    			modelatt="numero";
    			valor="telefonos";
    				
    			for (i = xphone; i < 0; i--) { 
    				 var $inputplus= $('.input-group').find('#'+valor+i+"\\."+modelatt);
    				 $inputplus.closest('.form-group');
    				 $formGroup.remove();
    				
    			}
    		}
    		
    		if (xemail>0){
    			modelatt="email";
    			valor="emails";
    			for (i = xemail; i < 0; i--) { 
    				 var $inputplus= $('.input-group').find('#'+valor+i+"\\."+modelatt);
    				 $inputplus.closest('.form-group');
    				 $formGroup.remove();
    			}
    		}

            
       	 	xphone = 0; //Initial field counter is 1
       	 	xemail =0;
       	 	
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

             $(this)
                 .toggleClass('btn-default btn-add btn-danger btn-remove')
                 .html('–');
             
             $formGroupClone.find('input').val('');
             $formGroupClone.find('input').attr("id",valor+xaux+"."+modelatt);
             $formGroupClone.find('input').attr("name",valor+"["+xaux+"]."+modelatt);
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
 			console.log("$formGroup length " +$formGroup.length);
 			$formGroup.remove();
 			xphone --;
 			//anterior se convierte en +
 			var $inputplusant= $multipleFormGroup.find('#'+valor+xphone+"\\."+modelatt);
 			//$inputplusant.find('button').toggleClass('btn-default btn-add btn-danger btn-remove').html('+')

 			 //$lastFormGroupLast.find('.btn-add').attr('disabled', true);
 			
 		}
 		if(valor == "emails"){
 			alert("XEMAIL remove "+xemail);
 			modelatt="email";
 			var $inputplus= $('.input-group').find('#'+valor+xemail+"."+modelatt);
  			var $formGroup= $inputplus.closest('.form-group');
  			 $formGroup.remove();
 			xemail--;
 			//anterior se convierte en +
 			//$(this).toggleClass('btn-default btn-add btn-danger btn-remove').html('–');
 			
 			
 		}

         
        /* var $formGroup = $(this).closest('.form-group');
         var $multipleFormGroup = $formGroup.closest('.multiple-form-group');

         var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
         if ($multipleFormGroup.data('max') >= countFormGroup($multipleFormGroup)) {
            // $lastFormGroupLast.find('.btn-add').attr('disabled', false);
        	 //$formGroup.find('.btn-add').attr('disabled', false);
        	 
         }
         
         //$formGroup.remove();
         
         $lastFormGroupLast.remove();
         
         //var $multipleFormGroupnextDelete=$('.modal-body').find('.inputBox');
         //  $(this).toggleClass('btn-default btn-add btn-danger btn-remove').html('–');
         
         xphone--;*/
     };

     var countFormGroup = function ($form) {
         return $form.find('.form-group').length;
     };

     $(document).on('click', '.btn-add', addFormGroup);
     $(document).on('click', '.btn-remove', removeFormGroup);
     		
		
	
	
 	
	
	 

       
    	




