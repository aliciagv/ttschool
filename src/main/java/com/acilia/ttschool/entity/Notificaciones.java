package com.acilia.ttschool.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notificaciones")
public class Notificaciones {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="created", nullable=false)
	private Date created;
	
	@Column (name="asunto", nullable=false, length=150)
	private String asunto;
	
	@Column (name="mensajes", nullable=false, length=500)
	private String mensajes;
	
	@Column (name="upload", length=100)
	private String upload;

	@ManyToMany(mappedBy="notificaciones")
	private List<Curso> cursos;
	
	
	@ManyToMany(mappedBy="notificaciones")
	private List<Alumno> alumnos;
	
	
	@ManyToMany(mappedBy="notificaciones")
	private List<Colegio> colegio;


	public Notificaciones() {
	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public String getAsunto() {
		return asunto;
	}


	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


	public String getMensajes() {
		return mensajes;
	}


	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}


	public String getUpload() {
		return upload;
	}


	public void setUpload(String upload) {
		this.upload = upload;
	}


	public List<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}


	public List<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}


	public List<Colegio> getColegio() {
		return colegio;
	}


	public void setColegio(List<Colegio> colegio) {
		this.colegio = colegio;
	}
	
	
	
	
}
