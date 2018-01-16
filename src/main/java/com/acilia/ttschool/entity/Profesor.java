package com.acilia.ttschool.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Profesor extends Persona {
	


	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(String nif, String nombre, String apellidos) {
		super(nif, nombre, apellidos);
		// TODO Auto-generated constructor stub
	}

	
	

}
