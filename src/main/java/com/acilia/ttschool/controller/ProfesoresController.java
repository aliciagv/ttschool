package com.acilia.ttschool.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acilia.ttschool.constant.ViewConstant;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.utils.LogUtils;

@Controller 
@RequestMapping("/profesor")
public class ProfesoresController {
	
	private static final Log LOG = LogFactory.getLog(ProfesoresController.class);
	
	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;
	
	@GetMapping("/form")
	public String redirecProfesorForm(Model model){
		
		logutils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		ProfesorModel profesor = new ProfesorModel();
		/*if (id!=0){
			student = studentService.findStudentByIdModel(id);	
		}*/
		model.addAttribute("profesorModel",profesor);
		
		logutils.outMetodo(LOG, LogUtils.getNombreMetodo(),  ViewConstant.TEACHERFORM_VIEW);
		
		return ViewConstant.TEACHERFORM_VIEW;
		
	}

}
