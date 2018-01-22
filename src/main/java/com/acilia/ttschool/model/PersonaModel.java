package com.acilia.ttschool.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public  class PersonaModel extends ResourceSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5964624344994118158L;

	Long idPersona;
	
	private String nif;
	
	private String nombre;
	
	private String apellidos;
	
	private List<EmailModel> emails;

	private List<TelefonoModel> telefonos;

	
	public PersonaModel() {
		
	}



	public PersonaModel(Long idPersona, String nif, String nombre, String apellidos, List<EmailModel> emails,
			List<TelefonoModel> telefonos) {
		super();
		this.idPersona = idPersona;
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.emails = emails;
		this.telefonos = telefonos;
	}



	public Long getIdPersona() {
		return idPersona;
	}



	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}



	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<EmailModel> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailModel> emails) {
		this.emails = emails;
	}

	public List<TelefonoModel> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<TelefonoModel> telefonos) {
		this.telefonos = telefonos;
	}
	
	

}
