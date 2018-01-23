package com.acilia.ttschool.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	
	@ManyToMany
	private List<Notificaciones> notificaciones;


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


	public List<Notificaciones> getNotificaciones() {
		return notificaciones;
	}


	public void setNotificaciones(List<Notificaciones> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	

	
}