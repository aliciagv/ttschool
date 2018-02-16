$(document).ready(function() {

    // page is now ready, initialize the calendar...
    
    $('#calendar').fullCalendar({
        // put your options and callbacks here
    	 locale: 'es',
    	 header: {
    	      left: 'prev,next today',
    	      center: 'title',
    	      right: 'month,agendaWeek,agendaDay'
    	    },
   
    	defaultDate: moment().format("YYYY-MM-DD"),
		editable: true,
		events: {
	        url: 'global/events',
	        type: 'GET',
	        error: function() {
	            alert('Ha habido algún error al obtener los datos');
	        },
		},
    	 dayClick: function(date, jsEvent, view, resourceObj) {
    		 	$('#CreateModalEvent').modal('show');
    		 	$('#start').val(date.format());
    		 	$('#start').parent().addClass("focus");
    		 	$("#start").prop("readonly", true);
    		 	
    		 	alert("Click");
    		 	//date es un obj de tipo moment
    		 	alert('Date: ' + date.format("YYYY-MM-DDTHH:mm:ss"));
    		 	//jsEvent es un obj nativo de JS, almacena las coordenadas de donde hemos hecho click
    	        alert('Coordenadas '+jsEvent.pageX + ', ' + jsEvent.pageY );
    	        //view es un obj de tipo View Object propio de fullcalendar
    	        alert('Nombre de la vista '+ view.name);
    	        alert('Title de la vista '+ view.title);
    	        alert('Start de la vista '+ view.start.format());
    	        alert('End de la vista '+ view.end.format());
    	        //$(this).css('background-color', 'red');

    	    },
    	    eventClick: function(calEvent, jsEvent, view) {

    	        alert('Event: ' + calEvent.title);
    	        alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
    	        alert('View: ' + view.name);

    	        // change the border color just for fun
    	        $(this).css('border-color', 'red');

    	    },
    	    eventDrop: function(event, delta, revertFunc) {

    	       

    	        if (!confirm("¿Esta seguro modificar "+ event.title +" al día " +event.start.format())) {
    	            revertFunc();
    	        }
    	        else {
    	        	alert("Llamar a modificar");
    	        	 
    	        	var eventData;
    	        	eventData = {
    						id: event.id,
    						title: event.title,
    						start: event.start.format(),
    						end:  (event.end == null) ? event.start.format() : event.end.format(),
    						url: event.url,
    						className:event.className
    						
    				};
    	           
    	            $.ajax({
    	            	type: "POST",
    				    url: "global/event",
    				    data: JSON.stringify(eventData),
    				    contentType: "application/json; charset=utf-8",
    				    dataType: "json",
    				    headers: {
    	                    'X-CSRF-TOKEN':  ${_csrf.token}
    	                },
    	                success: function(response){
    	                	$('#calendar').fullCalendar();
    	                    
    	                },
    	                error: function(e){                     
    	                    revertFunc();
    	                    alert('Error al modificar: '+e.responseText);
    	                }
    	            });
    	            }
    	        }

    	/* events :[
    		{
    			//id:1,
    			title: "Primer evento",
    			start: "2018-02-13",
    			end:   "2018-02-15 24:00:00",
    			//url:"http://www.google.com"
    			//color: "red",	
    			//textColor:"white"
    			className:"importante",
    			editable:true
    		},
    		
    		{
    			//id:1,
    			title: "Segundo evento",
    			start: "2018-02-20 08:00:00",
    			end:   "2018-02-21 24:00:00",
    			//url:"http://www.google.com"
    			//color: "red",	
    			//textColor:"white"
    			className:"info",
    			editable:true
    		}
    	]*/
    })
    
    $(".input").focus(function() {
 		$(this).parent().addClass("focus");
 	});
    
    
	$("#CreateModalEvent form").validate({
        rules: {
        	start: { 
        		required: true, 
        		},
        	
        	title: {
        		required:true, 
        		minlength:1, 
        		maxlength: 250,
        		customname:true
        		},
        		
        	end:{
        		required:false,
                greaterThan: "#start"              
        	}
        },
        messages: {
			
        	start: {
				required: 'El campo es requerido', 
				
					},
			
			title: {

				required: 'El campo es requerido',
				minlength: 'El máximo permitido es 1 caracter', 
        		maxlength: 'El máximo permitido son 2 caracteres'
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
            	// var nombre= response.nombre;
            	 $('#CreateModalEvent').modal('hide');
            	 $('#mensaje').removeClass('alert-danger');
          		 $('#mensaje').addClass('alert-success');
          		 $('#mensaje').show();	
          		 // $('#smensaje').text(nombre + " ha sido añadido");
          		 $('#smensaje').text("El evento ha sido añadido");
          		 $('#mensaje').fadeOut(2000);
          		 window.setTimeout(function(){location.reload()},2000)                	 
              },
              error: function(e){ 
            	  	$('#CreateModalEvent').modal('hide');
            	    $('#mensaje').removeClass('alert-success');
					$('#mensaje').addClass('alert-danger');
					$('#mensaje').show();	
					$('#smensaje').text("Ha habido un error al crear. Intentelo de nuevo más tarde"+ e.responseJSON.errorMessage);
					
            }
		
			
		});
        }
	  });
	
	var date_input=$('input[name="end"]'); //our date input has the name "date"
	var container=$('#CreateModalEvent  form').length>0 ? $('#CreateModalEvent  form').parent() : "body";
	date_input.datepicker({
		container: container,
		todayHighlight: true,
		autoclose: true,
	});
	
 	$('#CreateModalEvent').on('hidden.bs.modal', function(){      		
 		$(this).find('form')[0].reset(); //para borrar todos los datos que tenga los input, textareas, select.
		$('.modal-body').find('.help-block').text(''); // eliminar todos los mensajes de validación
		$('.modal-body').find('.inputBox').removeClass("focus"); // remove class focus

	});

});


