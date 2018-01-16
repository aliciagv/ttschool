package com.acilia.ttschool.model;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

public class EmailModel extends ResourceSupport implements Serializable{

	/**
	 * 
	 */

	private static final long serialVersionUID = 4219481214145925991L;

	private Long idEmail;
	
	private String email;
	

	
	public EmailModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmailModel(Long idEmail, String email) {
		super();
		this.idEmail = idEmail;
		this.email = email;
	}
	

	public Long getIdEmail() {
		return idEmail;
	}


	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}




	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
