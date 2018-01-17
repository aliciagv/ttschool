package com.acilia.ttschool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="telefono")
public class Telefono {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	Long id;
	
	@Column(name="numero",length=9, unique=true)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;

	
	
	public Telefono() {
	
	}


	public Telefono(String numero, Persona persona) {
		super();
		this.numero = numero;
		this.persona = persona;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
