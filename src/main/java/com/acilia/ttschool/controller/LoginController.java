package com.acilia.ttschool.controller;

import java.util.Hashtable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acilia.ttschool.constant.ViewConstant;
import com.acilia.ttschool.model.UserModel;
import com.acilia.ttschool.service.UserService;
import com.acilia.ttschool.utils.LogUtils;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;
	
	@Autowired
	@Qualifier("userserviceImpl")
	private UserService userservice;
	
	
	@GetMapping("/login")
	@PostMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false) String error, 
			@RequestParam(name="logout", required=false) String logout) {
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("error",error!=null?error:"");
		params.put("logout",logout!=null?logout:"");
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(),params);
		
		if (error!=null){
			model.addAttribute("error","Invalid username or password");
		}
		
		if (logout!=null){
			model.addAttribute("logout", "Logout successfully!");
		}
		
		LOG.info("Returning to "+ ViewConstant.LOGIN_VIEW +" view");
		
		return ViewConstant.LOGIN_VIEW;
	}
	
	@GetMapping({"/loginsucess","/"})
	public String loginCheck(Model model){
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		
		LOG.info("Redirect to "+ ViewConstant.HOME_VIEW + " view");
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 
		 model.addAttribute("nombre_usuario", auth.getName());
		 UserModel usermodel= userservice.findUserModelByname(auth.getName());
		 model.addAttribute("usermodel",usermodel);
		 
		 model.addAttribute("auth_usuario", auth.getAuthorities());

	      
		
		return ViewConstant.HOME_VIEW;
	}
	
	
	
}
