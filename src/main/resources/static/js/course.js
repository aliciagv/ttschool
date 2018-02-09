 $(document).ready(function() {
	 
	$("#AddModalCurso form").validate({
            rules: {
            	nombre: { 
            		required: true, 
            		minlength:1,
            		maxlength: 50,
            		customname:true
            		},
            	
            	letra: {
            		required:false, 
            		minlength:1, 
            		maxlength: 100,
            		customname:true
            		},
            	
            	descripcion: {
            		required:true,
            		customname:true
            		}

            },
            messages: {
    			
    			nombre: {
    				required: 'El campo es requerido', 
    				minlength: 'El máximo permitido es 1 caracter', 
    				maxlength: 'El máximo permitido son 50 caracteres'
    					},
    			
    			letra: {
    				minlength: 'El máximo permitido es 1 caracter', 
            		maxlength: 'El máximo permitido son 2 caracteres'
            			},	
            	descripcion: {
            		required: 'El campo es requerido', 
            		minlength: 'El máximo permitido es 1 caracter', 
            		maxlength: 'El máximo permitido son 200 caracteres'
                  	},			
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
    	         
    		submitHandler: function(form) {
              var theURL = form.action;
              var type = form.method;
              $.ajax({
            	  type : "POST",
            	  data : $(form).serialize(),
	    		  url : theURL,
                  success: function(response){
                	 var nombre= response.nombre;
                	 $('#AddModalCurso').modal('hide');
                	 $('#mensaje').removeClass('alert-danger');
              		 $('#mensaje').addClass('alert-success');
              		 $('#mensaje').show();	
              		 $('#smensaje').text(nombre + " ha sido añadido");
              		 $('#mensaje').fadeOut(2000);
              		 window.setTimeout(function(){location.reload()},2000)                	 
                  },
                  error: function(e){ 
                	  	$('#AddModalCurso').modal('hide');
                	    $('#mensaje').removeClass('alert-success');
						$('#mensaje').addClass('alert-danger');
						$('#mensaje').show();	
						$('#smensaje').text("Ha habido un error al crear. Intentelo de nuevo más tarde"+ e.responseJSON.errorMessage);
						
                }
    		
    			
    		});
            }
        });

      	$('#listado').stacktable();
      	
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
      	

         $(".input").focus(function() {
     		$(this).parent().addClass("focus");
     	});
     	

     	$('#AddModalCurso').on('hidden.bs.modal', function(){      		
     		$(this).find('form')[0].reset(); //para borrar todos los datos que tenga los input, textareas, select.
    		$('.modal-body').find('.help-block').text(''); // eliminar todos los mensajes de validación
    		$('.modal-body').find('.inputBox').removeClass("focus"); // remove class focus

    	});
     	 	
});
	 
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
}; //fin funcion eliminar

 	
function editar(uri) {
$.ajax({
	type : "GET",
	url : uri,
	success : function(data) {
		// Populate the form fields with the data returned from server
		console.log(data);
		$('#addCursoForm').find('[name="idCurso"]').val(data.idCurso);
		
		$('#addCursoForm').find('[name="nombre"]').val(data.nombre);
		$('#addCursoForm').find('[name="nombre"]').parent().addClass("focus");
		
		$('#addCursoForm').find('[name="descripcion"]').val(data.descripcion);
		$('#addCursoForm').find('[name="descripcion"]').parent().addClass("focus");
		
		if (data.letra!=null){
			$('#addCursoForm').find('[name="letra"]').val(data.letra);
			$('#addCursoForm').find('[name="letra"]').parent().addClass("focus");
		}

		$('#modalTitleAddCursoModal').text("Modificar curso");
		$('#btnReset').remove();
		$('#btnGuardar').val("Modificar");
		
		
		 $("#AddModalCurso").modal("show");
		
		
	},  
	error: function(e){
		alert ("ERROR");
				}
			});
			
};
	

	
	 

       
    	




