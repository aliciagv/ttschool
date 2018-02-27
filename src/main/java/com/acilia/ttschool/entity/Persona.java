package com.acilia.ttschool.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table (name="persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column (name="nif", length=50, unique=true)
	private String nif;
	
	@Column (name="nombre", nullable=false, length=50 )
	private String nombre;
	
	@Column (name="apellidos", length=100 )
	private String apellidos;
	
	@Column(name="fcreacion")
	@Temporal(TemporalType.DATE)
	private Date fcreacion;
	
	@OneToMany(cascade= CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="idpersona")
	private List<Email> emails=new ArrayList<Email>();

	@OneToMany(cascade= CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="idpersona")
	private List<Telefono> telefonos=new ArrayList<Telefono>();

	
	public Persona() {

	}

	public Persona(String nif, String nombre, String apellidos) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
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

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails.clear();
		this.emails.addAll(emails);
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		//this.telefonos=telefonos;
		
		this.telefonos.clear();
	    this.telefonos.addAll(telefonos);
	    
	}

	public Date getFcreacion() {
		return fcreacion;
	}

	public void setFcreacion(Date fcreacion) {
		this.fcreacion = fcreacion;
	}
	
	
	
	
	
	
}
