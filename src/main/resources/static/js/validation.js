$.validator.addMethod('customname', function (value, element) {
	/* Inicio validacion NAME */

	 return this.optional(element) || /[a-zA-ZáéíóúÁÉÍÓÚñÑ ]/.test(value);
 
}, "El valor introducido no es válido");

$.validator.addMethod('customnif', function (value, element) {
	/* Inicio validacion NIF */
	if (value ===""){
		return true;
}
    if  (this.optional(element) || (/^[0-9]{8}[A-Z]{1}$/.test(value))) {
        return  ("TRWAGMYFPDXBNJZSQVHLCKE".charAt(value.substring(8, 0) % 23) === value.charAt(8));
    }
    //  Hay ciertos NIFs que empiezan por K, L o M
    if (this.optional(element) ||(/^[KLM]{1}/.test(value))) {
        return  (value[ 8 ] === String.fromCharCode(64));
    }
    /* Fin validacion NIF */
    return false;
}, "El nif introducido no es válido");

$.validator.addMethod('customphone', function (value, element) {
	/* Inicio validacion PHONE */
	console.log("CUSTOMPHONE" + value);
	 return this.optional(element) ||/^[9|8|7|6]\d{8}$/.test(value);
 
}, "El teléfono introducido no es válido");

$.validator.addMethod('customemail', function (value, element) {
	/* Inicio validacion PHONE */
	console.log("EMAIL" + value);
	var pattern = new RegExp("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	 return this.optional(element) ||pattern.test(value);
 
}, "El email introducido no es válido");





