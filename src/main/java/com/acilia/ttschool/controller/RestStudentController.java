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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acilia.ttschool.model.StudentModel;
import com.acilia.ttschool.service.StudentService;

@RestController // hereda de Controller
@RequestMapping("/students")
public class RestStudentController {
	
	private static final Log LOG = LogFactory.getLog(StudentController.class);

	
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;
	
	
	@GetMapping("/checkrest")
	//devuelve un json
	public ResponseEntity<StudentModel> checkRest(){
		StudentModel sm = new StudentModel(1,"Alicia","Gutiérrez","4","A");
		return new ResponseEntity<StudentModel>(sm, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudentModel>> getStudents(){
		List<StudentModel> liststudents= new ArrayList<StudentModel>();
		liststudents=studentService.listAllStudent();
		return new ResponseEntity<List<StudentModel>>(liststudents,HttpStatus.OK);
		
		
	}
	

}
