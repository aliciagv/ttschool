package com.acilia.ttschool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.StudentConverter;
import com.acilia.ttschool.entity.Student;
import com.acilia.ttschool.model.StudentModel;
import com.acilia.ttschool.repository.StudentRepository;
import com.acilia.ttschool.service.StudentService;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	@Qualifier("studentrepository")
	private StudentRepository studentRepository;

	@Autowired
	@Qualifier("studentConverter")
	private StudentConverter studentConverter;

	@Override
	public StudentModel addStudent(StudentModel studentmodel) {
		// TODO Auto-generated method stub
		Student student = studentRepository.save(studentConverter.convetStudentModel2Student(studentmodel));
		return studentConverter.convetStudent2StudentModel(student);
	}

	@Override
	public List<StudentModel> listAllStudent() {
		List<Student> lstudent = studentRepository.findAll();
		
		List<StudentModel> studentmodel = new ArrayList<StudentModel>();
		for (Student student : lstudent) {
			studentmodel.add(studentConverter.convetStudent2StudentModel(student));

		}
		return studentmodel;
	}

	@Override
	public Student findStudentById(int id) {
		return studentRepository.findById(id);

	}

	@Override
	public void removeStudent(int id) {
		Student student = studentRepository.findById(id);
		if (student != null)
			studentRepository.delete(findStudentById(student.getId()));
	}
	
	@Override
	public StudentModel findStudentByIdModel(int id){
		return studentConverter.convetStudent2StudentModel(findStudentById(id));
		
	}

	@Override
	public List<StudentModel> listAllStudentCustom() {
		// TODO Auto-generated method stub
		
		List<Student> lstudent = studentRepository.misConsultas();
		
		List<StudentModel> studentmodel = new ArrayList<StudentModel>();
		for (Student student : lstudent) {
			studentmodel.add(studentConverter.convetStudent2StudentModel(student));

		}
		return studentmodel;
	}

}
