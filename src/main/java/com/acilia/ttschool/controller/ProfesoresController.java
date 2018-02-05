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
import com.acilia.ttschool.service.ProfesorService;
import com.acilia.ttschool.utils.LogUtils;
import com.acilia.ttschool.view.ProfesoresListExcel;

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

	@Autowired
	@Qualifier("profesoresListExcel")
	private ProfesoresListExcel profesoresListExcel;

	@GetMapping()
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de profesores");
		List<ProfesorModel> listProfesorModel = new ArrayList<ProfesorModel>();
		listProfesorModel = profesorService.listAllProfesor();
		model.addAttribute("profesores", listProfesorModel);
		ProfesorModel profesor = new ProfesorModel();
		model.addAttribute("profesor", profesor);
		return "profesor/profesores";
	}

	@GetMapping("/refresh")
	public String refresh(Model model) {
		model.addAttribute("titulo", "Listado de profesores");
		List<ProfesorModel> listProfesorModel = new ArrayList<ProfesorModel>();
		listProfesorModel = profesorService.listAllProfesor();
		model.addAttribute("profesores", listProfesorModel);
		return "profesor/listar";
	}

	@PostMapping()
	public @ResponseBody ProfesorModel add(@ModelAttribute(value = "profesor") ProfesorModel pr,
			BindingResult result)  {
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		
		ProfesorModel profesorModel = null;
		profesorModel = profesorService.addProfesor(pr);

		return profesorModel;

	}

	// @RequestMapping(value="{personaId}", method = RequestMethod.GET)
	@GetMapping(value = "/profesor/{personaId}")
	public @ResponseBody ProfesorModel getProfesorModel(@PathVariable("personaId") Long personaId, Model model) {

		ProfesorModel profesormodel = profesorService.findProfesorByIdModel(personaId);
		return profesormodel;
		// model.addAttribute("profesor", profesormodel );
		// model.addAttribute("profesor", new ProfesorModel());
		// return "profesor/listarprofesores";

	}

	@GetMapping(value = "/{personaId}")
	// @RequestMapping(value = "/{personaId}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("personaId") Long personaId) {

		ProfesorModel profesorModel = profesorService.findProfesorByIdModel(personaId);

		if (profesorModel == null) {
			return "error";
		} else {
			profesorService.removeProfesor(profesorModel);
			return "ok";
		}

	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		List<ProfesorModel> listProfesorModel = new ArrayList<ProfesorModel>();
		listProfesorModel = profesorService.listAllProfesor();
		return new ModelAndView(profesoresListExcel, "profesores", listProfesorModel);
	}

}
