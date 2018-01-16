package com.acilia.ttschool.model;

public class StudentModel {

	private Integer id;
	
	private String firstname;
	
	private String lastname;
	
	private String curso;
	
	private String clase;
	
	

	public StudentModel() {
		
	}

	public StudentModel(Integer id, String firstname, String lastname, String curso, String clase) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.curso = curso;
		this.clase = clase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", curso=" + curso
				+ ", clase=" + clase + "]";
	}
	
	
}
