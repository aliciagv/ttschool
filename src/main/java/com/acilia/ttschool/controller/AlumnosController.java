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

import com.acilia.ttschool.constant.AttributeNameViewConstant;
import com.acilia.ttschool.constant.AttributeValueViewConstant;
import com.acilia.ttschool.model.AlumnoModel;
import com.acilia.ttschool.model.CursoModel;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.service.AlumnoService;
import com.acilia.ttschool.service.CursoService;
import com.acilia.ttschool.service.ProfesorService;
import com.acilia.ttschool.service.StudentService;
import com.acilia.ttschool.utils.LogUtils;
import com.acilia.ttschool.view.AlumnosListExcel;
import com.acilia.ttschool.view.ProfesoresListExcel;

@Controller
@RequestMapping("/alumno")
public class AlumnosController {

	private static final Log LOG = LogFactory.getLog(AlumnosController.class);

	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;

	@Autowired
	@Qualifier("alumnoServiceImpl")
	private AlumnoService alumnoService;
	
	@Autowired
	@Qualifier("cursoServiceImpl")
	private CursoService cursoService;

	
	@Autowired
	@Qualifier("alumnosListExcel")
	private AlumnosListExcel alumnosListExcel;

	@GetMapping()
	public String listar(Model model) {
		model.addAttribute("titulo", AttributeValueViewConstant.TITLE_STUDENT_LIST);
		List<AlumnoModel> listAlumnoModel = new ArrayList<AlumnoModel>();
		listAlumnoModel = alumnoService.listAllAlumno();
		List<CursoModel> listCursoModel =new ArrayList<CursoModel>();
		listCursoModel= cursoService.listAll();
		model.addAttribute(AttributeNameViewConstant.COURSES,listCursoModel);
		model.addAttribute("alumnos", listAlumnoModel);
		AlumnoModel alumno = new AlumnoModel();
		model.addAttribute("alumno", alumno);
		return "alumno/alumnos";
	}



	@PostMapping()
	public @ResponseBody AlumnoModel add(@ModelAttribute(value = "alumno") AlumnoModel al,
			BindingResult result)  {
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		
		AlumnoModel alumnoModel = null;
		alumnoModel = alumnoService.addAlumno(al);
		
		return alumnoModel;

	}

	@GetMapping(value = "/alumno/{personaId}")
	public @ResponseBody AlumnoModel getProfesorModel(@PathVariable("personaId") Long personaId) {
		
		AlumnoModel alumnoModel = alumnoService.findAlumnoByIdModel(personaId);
		return alumnoModel;
		

	}

	@GetMapping(value = "/{personaId}")
	public @ResponseBody String delete(@PathVariable("personaId") Long personaId) {

		AlumnoModel alumnoModel = alumnoService.findAlumnoByIdModel(personaId);

		if (alumnoModel == null) {
			return "error";
		} else {
			alumnoService.removeAlumno(alumnoModel);
			return "ok";
		}

	}

	/*@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		List<ProfesorModel> listProfesorModel = new ArrayList<ProfesorModel>();
		listProfesorModel = profesorService.listAllProfesor();
		return new ModelAndView(profesoresListExcel, "profesores", listProfesorModel);
	} */

}
