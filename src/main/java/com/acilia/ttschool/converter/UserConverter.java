/*
 * @author acilia
 */
package com.acilia.ttschool.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.User;
import com.acilia.ttschool.model.UserModel;

// TODO: Auto-generated Javadoc
/**
 * The Class UserConverter.
 */
@Component("userConverter")
public class UserConverter {
	
	/** The role converter. */
	@Autowired
	@Qualifier("roleConverter")
	private RoleConverter roleConverter;
	
	/**
	 * Convert user model 2 user.
	 *
	 * @param usermodel the usermodel
	 * @return the user
	 */
	public User convertUserModel2User(UserModel usermodel){
		User user = new User();
		user.setId(usermodel.getIdUser());
		user.setUsername(usermodel.getUsername());
		user.setPassword(usermodel.getPassword());
		user.setRole(roleConverter.converterRoleModel2Role(usermodel.getRole()));
		return user;
		
	}
	
	/**
	 * Convert user 2 user model.
	 *
	 * @param user the user
	 * @return the user model
	 */
	public UserModel convertUser2UserModel(User user){
		UserModel usermodel= new UserModel();
		usermodel.setIdUser(user.getId());
		usermodel.setUsername(user.getUsername());
		usermodel.setPassword(user.getPassword());
		usermodel.setRole(roleConverter.convertRole2RoleModel(user.getRole()));
		return usermodel;
		
	}

}
