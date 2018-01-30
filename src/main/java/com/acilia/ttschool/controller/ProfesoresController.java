package com.acilia.ttschool.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.model.ProfesorModelJsonResponse;
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


	@GetMapping()
	public String listar (Model model){
		model.addAttribute("titulo","Listado de profesores");
		List<ProfesorModel> listProfesorModel = new ArrayList<ProfesorModel>();
		listProfesorModel = profesorService.listAllProfesor();
		model.addAttribute("profesores", listProfesorModel);
		ProfesorModel profesor = new ProfesorModel();
		model.addAttribute("profesor", profesor);
		return "profesor/listarprofesores";
	}
	

	
	@PostMapping()
	public @ResponseBody ProfesorModelJsonResponse add(@ModelAttribute(value="profesorModel") ProfesorModel pr,BindingResult result) {
		
		ProfesorModelJsonResponse response = new ProfesorModelJsonResponse();
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		ProfesorModel profesorModel=profesorService.addProfesor(pr);
		response.setProfesorModel(profesorModel);
		response.setValidated(true);
		return response;
		

	}

	//@RequestMapping(value = "/{personaId}", method = RequestMethod.DELETE)
	@GetMapping (value = "/{personaId}")
	public @ResponseBody String delete(@PathVariable("personaId") Long personaId) {
		
		ProfesorModel profesorModel = profesorService.findProfesorByIdModel(personaId);
		
		if (profesorModel == null) {
			return "error";
		} else {
			profesorService.removeProfesor(profesorModel);
			return "ok";
		}
		
	}	
	//ModelAndView
	/*@GetMapping (value = "/{personaId}")	
public ModelAndView delete(@PathVariable("personaId") Long personaId) {
		
		ProfesorModel profesorModel = profesorService.findProfesorByIdModel(personaId);
		
		if (profesorModel == null) {
			 return new ModelAndView("listarprofesores");
		} else {
			profesorService.removeProfesor(profesorModel);
			//return "ok";
			 return new ModelAndView("listarprofesores");
		}
		
	}*/
}
