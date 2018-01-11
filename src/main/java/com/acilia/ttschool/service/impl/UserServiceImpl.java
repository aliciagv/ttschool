package com.acilia.ttschool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.AlumnoConverter;
import com.acilia.ttschool.converter.UserConverter;
import com.acilia.ttschool.model.UserModel;
import com.acilia.ttschool.repository.AlumnoRepository;
import com.acilia.ttschool.repository.UserRepository;
import com.acilia.ttschool.service.UserService;

@Service("userserviceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userrepository")
	private UserRepository userRepository;
	
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	
	@Override
	public UserModel addUser(UserModel usermodel) {
		
		return null;
	}

	@Override
	public List<UserModel> listAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findUserModelById(long id) {
	
		return null;
	}

	@Override
	public UserModel findUserModelByname(String username) {
		return userConverter.convertUser2UserModel(userRepository.findByUsername(username));
		
	}

	@Override
	public void removeUser(long id) {
	
		
	}

}
