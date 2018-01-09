package com.acilia.ttschool.model;

import java.util.List;


public class TutorModel extends PersonaModel{
	
	private List<AlumnoModel> alumnos;

	
	
	public TutorModel() {
		
	}

	public TutorModel(Long id, String nif, String nombre, String apellidos, List<EmailModel> emails,
			List<TelefonoModel> telefonos) {
		super(id, nif, nombre, apellidos, emails, telefonos);
		
	}

	public List<AlumnoModel> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoModel> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
	

}
