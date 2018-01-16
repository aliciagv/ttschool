package com.acilia.ttschool.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="asignatura")

public class Asignatura {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	Long id;
	
	@Column(name="nombre",length=50, unique=true)
	private String nombre;
	
	@Column(name="descripcion",length=150)
	private String descripcion;
	
	@ManyToMany(mappedBy="asignaturas")
	private List<Alumno> alumnos;
	
	

	public Asignatura() {
	}
		

	public Asignatura(String nombre, String descripcion, List<Alumno> alumnos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alumnos = alumnos;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
	
}
