package com.acilia.ttschool.controller;

import java.util.Hashtable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acilia.ttschool.constant.ViewConstant;
import com.acilia.ttschool.utils.LogUtils;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;
	
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false) String error, 
			@RequestParam(name="logout", required=false) String logout) {
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("error",error!=null?error:"");
		params.put("logout",logout!=null?logout:"");
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(),params);
		
		model.addAttribute("error",error);
		model.addAttribute("logout", logout);
		
		LOG.info("Returning to "+ ViewConstant.LOGIN_VIEW +" view");
		
		return ViewConstant.LOGIN_VIEW;
	}
	
	@GetMapping({"/loginsucess","/"})
	public String loginCheck(){
		
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		
		LOG.info("Redirect to "+ ViewConstant.STUDENTS_VIEW + " view");
		
		//return ViewConstant.STUDENTS_VIEW;
		 return "redirect:/student/showstudent";
		 //si hay error 
		 //return "redirect:/login?error";
	}
	
	
	
}
