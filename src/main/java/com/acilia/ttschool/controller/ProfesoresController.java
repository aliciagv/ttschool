package com.acilia.ttschool.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.acilia.ttschool.constant.ViewConstant;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.model.Role;
import com.acilia.ttschool.service.ProfesorService;
import com.acilia.ttschool.utils.LogUtils;

@Controller 
@RequestMapping("/profesor")
public class ProfesoresController {
	
	private static final Log LOG = LogFactory.getLog(ProfesoresController.class);
	
	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;
	
	@Autowired
	@Qualifier("profesorServiceImpl")
	private ProfesorService profesorService;
	
	
	@GetMapping("/")
	public String redirecProfesorForm(Model model){
		
		logutils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getAuthorities().toString().equalsIgnoreCase(Role.ADMIN.getRole())){
			ProfesorModel profesor = new ProfesorModel();
			model.addAttribute("profesorModel",profesor);
		}
		
		List<ProfesorModel> listProfesorModel = new ArrayList<ProfesorModel>();
		listProfesorModel=profesorService.listAllProfesor();
		model.addAttribute("listprofesorModel",listProfesorModel);
		logutils.outMetodo(LOG, LogUtils.getNombreMetodo(),  ViewConstant.TEACHER_VIEW);
		return ViewConstant.TEACHER_VIEW;
	}
	
	 @RequestMapping(value = "/edit/{id}")
	 public ModelAndView edit(@PathVariable int id) {
	  ProfesorModel profesormodel = profesorService.findProfesorByIdModel(id);
	  return new ModelAndView("empeditform", "command", profesormodel);
	 }

}
