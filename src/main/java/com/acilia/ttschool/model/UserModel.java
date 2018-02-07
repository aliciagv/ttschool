/*
 *  @author acilia
 */
package com.acilia.ttschool.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6839369741150215740L;
	
	private Long idUser;

	private String username;
	
	private String password;
	
	private boolean enabled;

	private RoleModel role;
	
	private PersonaModel persona;

	public UserModel() {

	}
	


	public Long getIdUser() {
		return idUser;
	}



	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}
	

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}



	@Override
	public String toString() {
		return "UserModel [idUser=" + idUser + ", username=" + username + ", password=" + password + ", enabled="
				+ enabled + ", role=" + role + ", persona=" + persona + "]";
	}









}
