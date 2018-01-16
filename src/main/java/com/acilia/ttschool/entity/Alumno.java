package com.acilia.ttschool.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="alumno")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Alumno extends Persona{
	
	@Column(name="fNacimiento",nullable=true)
	private Date fNacimiento;
	
	@Column(name="direccion",length=200,nullable=true)
	private String direccion;
	
	@ManyToMany
	private List<Tutor> tutores;
	
	@ManyToMany
	private List<Asignatura> asignaturas;

	@JoinColumn(name = "curso_id", referencedColumnName = "id")
	@ManyToOne(optional = true)
	private Curso curso;
	
	
	
	@ManyToMany
	private List<Notificaciones> notificaciones;
	
	
	public Alumno() {
		super();
	}

	public Alumno(String nif, String nombre, String apellidos,Date fNacimiento,String direccion) {
		super(nif, nombre, apellidos);
		this.fNacimiento=fNacimiento;
		this.direccion=direccion;

	}
	

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Notificaciones> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificaciones> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	
	


}
