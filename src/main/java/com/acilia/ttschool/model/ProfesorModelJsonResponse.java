package com.acilia.ttschool.model;

import java.io.Serializable;
import java.util.Map;

public class ProfesorModelJsonResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1912968083446614250L;

	private ProfesorModel profesorModel;  
	private boolean validated;
	private Map<String, String> errorMessages;
	
	public ProfesorModelJsonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfesorModel getProfesorModel() {
		return profesorModel;
	}
	public void setProfesorModel(ProfesorModel profesorModel) {
		this.profesorModel = profesorModel;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	
}
