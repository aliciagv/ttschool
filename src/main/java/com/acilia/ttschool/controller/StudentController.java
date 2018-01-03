package com.acilia.ttschool.controller;

import java.util.Hashtable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acilia.ttschool.constant.ViewConstant;
import com.acilia.ttschool.entity.Student;
import com.acilia.ttschool.model.StudentModel;
import com.acilia.ttschool.service.StudentService;
import com.acilia.ttschool.utils.LogUtils;

@Controller
@RequestMapping("/student")
public class StudentController {

	private static final Log LOG = LogFactory.getLog(StudentController.class);

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;
	
	
	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;
	
	@GetMapping("/cancel")
	public String cancel(){
		
		logutils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		
		logutils.outMetodo(LOG, LogUtils.getNombreMetodo(),  ViewConstant.STUDENTS_VIEW);
		
		return "redirect:/student/showstudent";
	}

	@GetMapping("/studentform")
	public String redirecStudentForm(@RequestParam(name="id",required=false) int id,Model model){
		
		logutils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		StudentModel student = new StudentModel();
		if (id!=0){
			student = studentService.findStudentByIdModel(id);	
		}
		model.addAttribute("studentModel",student);
		
		logutils.outMetodo(LOG, LogUtils.getNombreMetodo(),  ViewConstant.STUDENTSFORM_VIEW);
		
		return ViewConstant.STUDENTSFORM_VIEW;
		
	}
	@PostMapping("/addstudent")
	public  String addStudent(@ModelAttribute(name="studentModel") StudentModel studentmodel, Model model){
		
		Hashtable<String,String> params = new Hashtable<String,String>();
		params.put("studentmodel",studentmodel!=null?studentmodel.toString():"");
		
		logutils.inMetodo(LOG,LogUtils.getNombreMetodo(), null);
		if (null!=studentService.addStudent(studentmodel)) {
			model.addAttribute("result",0);
		} else {
			model.addAttribute("result",1);
		}
		
		
		logutils.outMetodo(LOG, LogUtils.getNombreMetodo(),  ViewConstant.STUDENTS_VIEW);
		
		return "redirect:/student/showstudent";
	}
	
	@GetMapping("/showstudent")
	public ModelAndView showStudent(){
		ModelAndView mav = new ModelAndView(ViewConstant.STUDENTS_VIEW);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); //
		mav.addObject("username",user.getUsername());
		mav.addObject("students",studentService.listAllStudent());
		return mav;
	}
	
	@GetMapping("/removestudent")
	public ModelAndView removeStudent(@RequestParam(name="id",required=true) int id){
		studentService.removeStudent(id);
		return showStudent();
	}

}
