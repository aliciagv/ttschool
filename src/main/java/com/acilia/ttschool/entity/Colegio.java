package com.acilia.ttschool.entity;

import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="colegio")
public class Colegio {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	Long id;
	
	@Column(name="nombre",length=100, unique=true)
	private String nombre;

	@Column(name="direccion",length=200,nullable=true)
	private String direccion;
	
	//owner of the relationship
	@ManyToMany(fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    @JoinTable(name = "colegio_eventos",
	            joinColumns = { @JoinColumn(name = "colegio_id", referencedColumnName = "id") },
	            inverseJoinColumns = { @JoinColumn(name = "eventos_id", referencedColumnName = "id") })
	private List<Event> eventos;


	public Colegio() {
	
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<Event> getEventos() {
		return eventos;
	}


	public void setEventos(List<Event> eventos) {
		this.eventos = eventos;
	}

	

	
}
