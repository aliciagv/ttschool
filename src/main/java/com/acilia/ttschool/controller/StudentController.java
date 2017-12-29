package com.acilia.ttschool.controller;

import java.util.Hashtable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acilia.ttschool.constant.ViewConstant;
import com.acilia.ttschool.model.StudentModel;
import com.acilia.ttschool.utils.LogUtils;

@Controller
@RequestMapping("/student")
public class StudentController {

	private static final Log LOG = LogFactory.getLog(StudentController.class);

	@GetMapping("/cancel")
	public String cancel(){
		
		LogUtils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		
		LogUtils.outMetodo(LOG, LogUtils.getNombreMetodo(),  ViewConstant.STUDENTS_VIEW);
		
		return ViewConstant.STUDENTS_VIEW;
	}

	@GetMapping("/studentform")
	public String redirecStudentForm(Model model){
		
		LogUtils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		
		model.addAttribute("studentModel",new StudentModel());
		
		LogUtils.outMetodo(LOG, LogUtils.getNombreMetodo(),  ViewConstant.STUDENTSFORM_VIEW);
		
		return ViewConstant.STUDENTSFORM_VIEW;
		
	}
	@PostMapping("/addstudent")
	public  String addStudent(@ModelAttribute(name="studentModel") StudentModel studentmodel){
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("studentmodel",studentmodel!=null?studentmodel.toString():"");
		
		LogUtils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		
		LogUtils.outMetodo(LOG, LogUtils.getNombreMetodo(),  ViewConstant.STUDENTS_VIEW);
		
		return ViewConstant.STUDENTS_VIEW;
	}

}
