package com.acilia.ttschool.model;

import java.io.Serializable;
import java.util.List;


public class ColegioModel implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6568800258196503282L;

	private Long idColegio;
	
	private String nombre;

	private String direccion;
	
	private List<EventModel> eventos;
	
	
	
	public ColegioModel() {
	
	}
	

	public ColegioModel(Long idColegio, String nombre, String direccion, List<EventModel> eventos) {
		super();
		this.idColegio = idColegio;
		this.nombre = nombre;
		this.direccion = direccion;
		this.eventos = eventos;
	}


	public Long getIdColegio() {
		return idColegio;
	}

	public void setIdColegio(Long idColegio) {
		this.idColegio = idColegio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<EventModel> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventModel> eventos) {
		this.eventos = eventos;
	}
	
	

}
