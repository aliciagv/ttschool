


$(document).ready(function() { 

        var addFormGroup = function (event) {
            event.preventDefault();

            var $formGroup = $(this).closest('.form-group');
            var $multipleFormGroup = $formGroup.closest('.multiple-form-group');
            var $formGroupClone = $formGroup.clone();

            $(this)
                .toggleClass('btn-default btn-add btn-danger btn-remove')
                .html('–');

            $formGroupClone.find('input').val('');
            $formGroupClone.insertAfter($formGroup);

            var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
            if ($multipleFormGroup.data('max') <= countFormGroup($multipleFormGroup)) {
                $lastFormGroupLast.find('.btn-add').attr('disabled', true);
            }
        };

        var removeFormGroup = function (event) {
            event.preventDefault();

            var $formGroup = $(this).closest('.form-group');
            var $multipleFormGroup = $formGroup.closest('.multiple-form-group');

            var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
            if ($multipleFormGroup.data('max') >= countFormGroup($multipleFormGroup)) {
                $lastFormGroupLast.find('.btn-add').attr('disabled', false);
            }

            $formGroup.remove();
        };

        var countFormGroup = function ($form) {
            return $form.find('.form-group').length;
        };

        $(document).on('click', '.btn-add', addFormGroup);
        $(document).on('click', '.btn-remove', removeFormGroup);
        
        $(".input").focus(function() {
    		$(this).parent().addClass("focus");
    	});
    	
    	$(".inputplus").focus(function() {
    		$(this).parent().parent().addClass("focus");
    	});
    	
      	$("#formprofesor").validate({
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
    				minlength: 'El mínimo permitido es 1 caracter', 
    				maxlength: 'El máximo permitido son 50 caracteres'
    					},
    			
            	apellidos: {
            		required: 'El campo es requerido', 
            		minlength: 'El mínimo permitido es 1 caracter', 
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

      	$('#profesor').click(function() {
      	    $.ajax({
      	         type: "GET",
      	         cache: false,
      	         url: "profesor/list",
      	         data: "",
      	         success: function(response){
      	             $('#cuerpo').html(response);
      	         }
      	    });
      	});

      	$('#listado').stacktable();
      	

      	/**$('#profesorform').click(function() {
      	    $.ajax({
      	         type: "GET",
      	         cache: false,
      	         url: "profesor/form",
      	         data: "",
      	         success: function(response){
      	             $('#cuerpo').html(response);
      	         }
      	    });
      	});*/
 


});





