package com.acilia.ttschool.service;

import java.util.List;

import com.acilia.ttschool.entity.Student;
import com.acilia.ttschool.model.StudentModel;

public interface StudentService {
	
	public abstract StudentModel addStudent(StudentModel studentmodel);
	
	public abstract List<StudentModel>listAllStudent();

	public abstract Student findStudentById(int id);
	
	public StudentModel findStudentByIdModel(int id);
	
	public abstract void removeStudent(int id);
}
