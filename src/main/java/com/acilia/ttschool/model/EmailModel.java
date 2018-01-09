package com.acilia.ttschool.model;

public class EmailModel {

	private Long id;
	
	private String email;
	

	
	public EmailModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EmailModel(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
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
	

}
