/**
 * JS para la página student.html
 */

/** Método que activa el elemento del listado seleccionado **/

$("li").click(function() {
  $("li").removeClass("active");
  $(this).addClass("active");
});