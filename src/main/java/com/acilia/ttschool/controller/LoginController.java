package com.acilia.ttschool.controller;

import java.util.Hashtable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acilia.ttschool.constant.ViewConstant;
import com.acilia.ttschool.model.User;
import com.acilia.ttschool.utils.LogUtils;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin(){
		LogUtils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		LOG.info("Redirect to "+ ViewConstant.STUDENTS_VIEW +" view");
		return "redirect:/"+ViewConstant.LOGIN_VIEW;
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false) String error, 
			@RequestParam(name="logout", required=false) String logout) {
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("error",error!=null?error:"");
		params.put("logout",logout!=null?logout:"");
		
		LogUtils.inMetodo(LOG, LogUtils.getNombreMetodo(),params);
		
		model.addAttribute("user",new User());
		model.addAttribute("error",error);
		model.addAttribute("logout", logout);
		
		LOG.info("Returning to "+ ViewConstant.LOGIN_VIEW +" view");
		
		return ViewConstant.LOGIN_VIEW;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="user") User user){
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("user",user!=null?user.toString():"");
		
		LogUtils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		
		LOG.info("Returning to "+ ViewConstant.STUDENTS_VIEW + " view");
		
		return ViewConstant.STUDENTS_VIEW;
		 //si hay error 
		 //return "redirect:/login?error";
	}
	
	
	
}
