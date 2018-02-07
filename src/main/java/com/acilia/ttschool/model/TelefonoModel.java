package com.acilia.ttschool.model;

import java.io.Serializable;

public class TelefonoModel implements Serializable {

	private static final long serialVersionUID = 4552267034905268432L;

	private Long idTelefono;
	
	private String numero;

	public TelefonoModel() {

	}



	public TelefonoModel(Long idTelefono, String numero) {
		super();
		this.idTelefono = idTelefono;
		this.numero = numero;
	}



	public Long getIdTelefono() {
		return idTelefono;
	}



	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}



	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "TelefonoModel [idTelefono=" + idTelefono + ", numero=" + numero + "]";
	}
	
	
	
	
	
	
}
