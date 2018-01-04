package com.acilia.ttschool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acilia.ttschool.model.StudentModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@GetMapping("/checkrest")
	//devuelve un json
	public ResponseEntity<StudentModel> checkRest(){
		StudentModel sm = new StudentModel(1,"Alicia","Gutiérrez","4","A");
		return new ResponseEntity<StudentModel>(sm, HttpStatus.OK);
	}

}
