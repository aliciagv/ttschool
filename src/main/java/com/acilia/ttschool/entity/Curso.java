package com.acilia.ttschool.entity;

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
@Table(name="curso")
public class Curso {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column (name="nombre", nullable=false, length=50)
	private String nombre;
	
	@Column (name="letra", length=2)
	private String letra;
	
	@Column (name="descripcion", length=200)
	private String descripcion;
		
	/*@JoinColumn(name = "profesor_id", referencedColumnName = "id")
	@ManyToOne(optional = true)
	private Profesor profesor;*/

	@ManyToMany
	private List<Event> eventos;


	public Curso() {
	}

	public Curso(String nombre, String letra, String descripcion) {
		super();
		this.nombre = nombre;
		this.letra = letra;
		this.descripcion = descripcion;
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

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getDescipcion() {
		return descripcion;
	}

	public void setDescipcion(String descipcion) {
		this.descripcion = descipcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Event> getEventos() {
		return eventos;
	}

	public void setEventos(List<Event> eventos) {
		this.eventos = eventos;
	}

	/*public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}*/

	
	

	
	
}
