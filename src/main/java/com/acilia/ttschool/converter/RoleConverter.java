/*
 * @author acilia
 */
package com.acilia.ttschool.converter;

import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Role;
import com.acilia.ttschool.model.RoleModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleConverter.
 */
@Component("roleConverter")
public class RoleConverter {

	/**
	 * Converter role model 2 role.
	 *
	 * @param rolemodel the rolemodel
	 * @return the role
	 */
	public Role converterRoleModel2Role(RoleModel rolemodel){
		Role role = new Role();
		role.setId(rolemodel.getIdRole());
		role.setName(rolemodel.getName());
		role.setDescription(rolemodel.getDescription());
		return role;
	}
	
	/**
	 * Convert role 2 role model.
	 *
	 * @param role the role
	 * @return the role model
	 */
	public RoleModel convertRole2RoleModel(Role role){
		RoleModel rolemodel = new RoleModel();
		rolemodel.setIdRole(role.getId());
		rolemodel.setName(role.getName());
		rolemodel.setDescription(role.getDescription());
		return rolemodel;
	}
}
