package com.acilia.ttschool.model;

import java.util.List;

public class ProfesorModel extends PersonaModel{

	private static final long serialVersionUID = 1869626023613226653L;

	private CursoModel curso;
	
	public ProfesorModel() {
	
	}

	public ProfesorModel(Long idPersona, String nif, String nombre, String apellidos, List<EmailModel> emails,
			List<TelefonoModel> telefonos) {
		super(idPersona, nif, nombre, apellidos, emails, telefonos);
		// TODO Auto-generated constructor stub
	}

	public CursoModel getCurso() {
		return curso;
	}

	public void setCurso(CursoModel curso) {
		this.curso = curso;
	}
	
	


	
	

}
