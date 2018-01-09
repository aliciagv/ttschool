package com.acilia.ttschool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	Long id;
	
	@Column (name="nombre", nullable=false, length=50)
	private String nombre;
	
	@Column (name="letra", length=2)
	private String letra;
	
	@Column (name="descripcion", length=200)
	private String descripcion;
	


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

	
	
}
