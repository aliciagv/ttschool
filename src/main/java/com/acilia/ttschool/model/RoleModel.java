/*
 *  @author acilia
 */
package com.acilia.ttschool.model;

import java.io.Serializable;

public class RoleModel implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5825397825851164639L;

	
	private Long idRole;
	
	private String name;
	
	private String description;

	public RoleModel() {
	
	}


	public Long getIdRole() {
		return idRole;
	}


	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "RoleModel [idRole=" + idRole + ", name=" + name + ", description=" + description + "]";
	}




	
	
	

}
