package com.acilia.ttschool.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acilia.ttschool.model.AlumnoModel;
import com.acilia.ttschool.service.AlumnoService;

@RestController // hereda de Controller
@RequestMapping("/alumnos")
public class RestAlumnoController {
	
	private static final Log LOG = LogFactory.getLog(RestAlumnoController.class);

	@Autowired
	@Qualifier("alumnoServiceImpl")
	private AlumnoService alumnoService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<AlumnoModel>> getAlumnos(){
		List<AlumnoModel> listalumnosModel= new ArrayList<AlumnoModel>();
		listalumnosModel=alumnoService.listAllAlumno();
		return new ResponseEntity<List<AlumnoModel>>(listalumnosModel,HttpStatus.OK);
		
		
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<Void> alumnosPost(@RequestBody AlumnoModel alumnoModel) {

		try {
			alumnoService.addAlumno(alumnoModel);
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

}
