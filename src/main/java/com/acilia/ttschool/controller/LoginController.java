package com.acilia.ttschool.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acilia.ttschool.model.User;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	private static final String LOGIN_VIEW="login";
	private static final String CONTACTS_VIEW="contacts";
	
	@GetMapping("/")
	public String redirectToLogin(){
		LOG.info("METHOD: " + getNombreMetodo());
		LOG.info("Redirect to "+ CONTACTS_VIEW +" view");
		return "redirect:/"+LOGIN_VIEW;
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false) String error, 
			@RequestParam(name="logout", required=false) String logout) {
		LOG.info("METHOD: " + getNombreMetodo() +"-- PARARMS: error=" + error + " logout="+logout );
		model.addAttribute("user",new User());
		model.addAttribute("error",error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to "+ LOGIN_VIEW +" view");
		return LOGIN_VIEW;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="user") User user){
		LOG.info("METHOD: " + getNombreMetodo() +"-- PARARMS: user=" + user.toString());
		LOG.info("Returning to "+ CONTACTS_VIEW + " view");
		return CONTACTS_VIEW;
		 //si hay error 
		 //return "redirect:/login?error";
	}
	
	/**
	    * Aqui esta la magia
	    * @return
	    */
	   public String getNombreMetodo(){
	      //Retorna el nombre del metodo desde el cual se hace el llamado
	      return new Exception().getStackTrace()[1].getMethodName();
	   }
	
}
