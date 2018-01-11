package com.acilia.ttschool.service;

import java.util.List;

import com.acilia.ttschool.model.UserModel;

public interface UserService {
	
	public abstract UserModel addUser(UserModel usermodel);
	
	public abstract List<UserModel> listAllUsers();
	
	public abstract UserModel findUserModelById(long id);
	
	public abstract UserModel findUserModelByname(String username);
	
	public abstract void removeUser(long id);

}
