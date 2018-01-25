$(document).ready(function() { 
	var xphone = 0; 

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



});



