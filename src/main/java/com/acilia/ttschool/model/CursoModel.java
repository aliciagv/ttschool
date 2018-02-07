package com.acilia.ttschool.model;

import java.io.Serializable;

public class CursoModel implements Serializable {


	private static final long serialVersionUID = 8555383746033924167L;
	
	private Long idCurso;
	
	private String nombre;
	
	private String letra;
	
	private String descripcion;

	public CursoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CursoModel(Long idCurso, String nombre, String letra, String descripcion) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.letra = letra;
		this.descripcion = descripcion;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
