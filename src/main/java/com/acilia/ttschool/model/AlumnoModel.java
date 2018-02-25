package com.acilia.ttschool.model;

import java.util.Date;
import java.util.List;


public class AlumnoModel extends PersonaModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 980511289615583102L;


	private String fNacimiento;
	
	
	private String direccion;
	
	
	private CursoModel curso;
	
	private List<TutorModel> tutores;
	
	
	private List<AsignaturaModel> asignaturas;


	
	public AlumnoModel() {
		super();
	}


	public AlumnoModel(Long id, String nif, String nombre, String apellidos, List<EmailModel> emails,
			List<TelefonoModel> telefonos) {
		super(id, nif, nombre, apellidos, emails, telefonos);
	
	}

	

	public AlumnoModel(String fNacimiento, String direccion, List<TutorModel> tutores,
			List<AsignaturaModel> asignaturas) {
		super();
		this.fNacimiento = fNacimiento;
		this.direccion = direccion;
		this.tutores = tutores;
		this.asignaturas = asignaturas;
	}


	public String getfNacimiento() {
		return fNacimiento;
	}


	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<TutorModel> getTutores() {
		return tutores;
	}


	public void setTutores(List<TutorModel> tutores) {
		this.tutores = tutores;
	}


	public List<AsignaturaModel> getAsignaturas() {
		return asignaturas;
	}


	public void setAsignaturas(List<AsignaturaModel> asignaturas) {
		this.asignaturas = asignaturas;
	}


	public CursoModel getCurso() {
		return curso;
	}


	public void setCurso(CursoModel curso) {
		this.curso = curso;
	}
	
	
	
	
	
}
