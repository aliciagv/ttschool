package com.acilia.ttschool.model;

import java.util.List;

public class ProfesorModel extends PersonaModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869626023613226653L;

	public ProfesorModel() {
	
	}

	public ProfesorModel(Long id, String nif, String nombre, String apellidos, List<EmailModel> emails,
			List<TelefonoModel> telefonos) {
		super(id, nif, nombre, apellidos, emails, telefonos);
	
	}
	
	

}
