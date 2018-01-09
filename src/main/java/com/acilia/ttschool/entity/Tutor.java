package com.acilia.ttschool.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tutor")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Tutor extends Persona{

	
	@ManyToMany(mappedBy="tutores")
	private List<Alumno> alumnos;
	
	
	public Tutor() {
		super();
	}

	public Tutor(String nif, String nombre, String apellidos) {
		super(nif, nombre, apellidos);
		
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
	

}
