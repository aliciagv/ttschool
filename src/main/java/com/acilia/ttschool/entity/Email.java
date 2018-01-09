package com.acilia.ttschool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="email")
public class Email {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	Long id;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;

	
	public Email() {

	}
	
	public Email(String email, Persona persona) {
		super();
		this.email = email;
		this.persona = persona;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
