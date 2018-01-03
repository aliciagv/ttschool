package com.acilia.ttschool.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.entity.UserRole;
import com.acilia.ttschool.repository.UserRepository;

@Service("userServiceImpl")
public class UserService implements UserDetailsService{

	
	@Autowired
	@Qualifier("userrepository")
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.acilia.ttschool.entity.User user =userRepository.findByUsername(username);
		List<GrantedAuthority> authorities= buildAuthorities(user.getUserRole());
		return buildUser(user,authorities);
		
	}
	
	private User buildUser(com.acilia.ttschool.entity.User user, List<GrantedAuthority> authorities){
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), 
				true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities( Set<UserRole> userRole){
		//nuestro set de roles a los roles de spring security;
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for (UserRole userrole: userRole){
			auths.add(new SimpleGrantedAuthority(userrole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}

}
