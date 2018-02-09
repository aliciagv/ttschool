package com.acilia.ttschool.controller;

import java.util.ArrayList;
import java.util.Hashtable;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.acilia.ttschool.model.CursoModel;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.service.CursoService;
import com.acilia.ttschool.utils.LogUtils;
import com.acilia.ttschool.view.CursoListExcel;

@Controller
@RequestMapping("/curso")
public class CursoController {

	private static final Log LOG = LogFactory.getLog(CursoController.class);
	private static final String titulo="Listado de cursos";

	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;

	@Autowired
	@Qualifier("cursoServiceImpl")
	private CursoService cursoService;

	@Autowired
	@Qualifier("cursoListExcel")
	private CursoListExcel cursoListExcel;

	@GetMapping()
	public String listar(Model model) {
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		model.addAttribute("titulo", titulo);
	
		List<CursoModel> listCursoModel =new ArrayList<CursoModel>();
		listCursoModel= cursoService.listAll();
		model.addAttribute("cursos",listCursoModel);
		CursoModel curso = new CursoModel();
		model.addAttribute("curso", curso);
		
		
		return "curso/cursos";
	}


	@PostMapping()
	public @ResponseBody CursoModel add(@ModelAttribute(value = "curso") CursoModel cs,
			BindingResult result)  {
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		
		CursoModel cursoModel = null;
		cursoModel = cursoService.addCurso(cs);
		
		return cursoModel;

	}

	// @RequestMapping(value="{personaId}", method = RequestMethod.GET)
	@GetMapping(value = "/curso/{cursoId}")
	public @ResponseBody CursoModel getProfesorModel(@PathVariable("cursoId") Long cursoId) {
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("idCurso",cursoId.toString());
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), params);
		
		CursoModel cursoModel = cursoService.findCursoByIdModel(cursoId);
		return cursoModel;

	} 
	
	@GetMapping(value = "/{idCurso}")
	// @RequestMapping(value = "/{personaId}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("idCurso") Long idCurso) {
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("idCurso",idCurso.toString());
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), params);
		
		CursoModel cursoModel = cursoService.findCursoByIdModel(idCurso);

		if (cursoModel == null) {
			return "error";
		} else {
			cursoService.removeCurso(cursoModel);
			return "ok";
		}

	}
/*
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		List<ProfesorModel> listProfesorModel = new ArrayList<ProfesorModel>();
		listProfesorModel = profesorService.listAllProfesor();
		return new ModelAndView(profesoresListExcel, "profesores", listProfesorModel);
	}*/

}
