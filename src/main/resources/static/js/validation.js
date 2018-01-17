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

	 return this.optional(element) ||/^[9|8|7|6]\d{8}$/.test(value);
 
}, "El teléfono introducido no es válido");



