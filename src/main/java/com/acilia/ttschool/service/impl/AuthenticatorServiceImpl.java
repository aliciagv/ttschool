/*
 *  @author acilia
 */
package com.acilia.ttschool.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.controller.LoginController;
import com.acilia.ttschool.entity.Role;
import com.acilia.ttschool.repository.UserRepository;
import com.acilia.ttschool.utils.LogUtils;

@Service("authenticatorServiceImpl")
public class AuthenticatorServiceImpl implements UserDetailsService{

	private static final Log LOG = LogFactory.getLog(AuthenticatorServiceImpl.class);
	
	
	@Autowired
	@Qualifier("userrepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("username",username!=null?username:"");
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(),params);
		
		com.acilia.ttschool.entity.User user =userRepository.findByUsername(username);
		if (user==null){
			throw new UsernameNotFoundException("Username " + username + " not found");
		}else {
			List<GrantedAuthority> authorities= buildAuthorities(user);
			logutils.outMetodo(LOG, LogUtils.getNombreMetodo(), null);
			return buildUser(user,authorities);
		}
		
		
	}
	
	private User buildUser(com.acilia.ttschool.entity.User user, List<GrantedAuthority> authorities){
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), 
				true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(com.acilia.ttschool.entity.User user){
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority(user.getRole().getName()));
		return auths;
	}

}
