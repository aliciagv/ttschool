package com.acilia.ttschool.model;

import java.util.List;

public abstract class PersonaModel {

	Long id;
	
	private String nif;
	
	private String nombre;
	
	private String apellidos;
	
	private List<EmailModel> emails;

	private List<TelefonoModel> telefonos;

	
	public PersonaModel() {
		
	}

	public PersonaModel(Long id, String nif, String nombre, String apellidos, List<EmailModel> emails,
			List<TelefonoModel> telefonos) {
		super();
		this.id = id;
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.emails = emails;
		this.telefonos = telefonos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
