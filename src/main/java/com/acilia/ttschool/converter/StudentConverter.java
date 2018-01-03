package com.acilia.ttschool.converter;

import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Student;
import com.acilia.ttschool.model.StudentModel;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentConverter.
 */
@Component("studentConverter")
public class StudentConverter {

	/**
	 * Convet student model 2 student.
	 *
	 * @param studentModel the student model
	 * @return the student
	 */
	public Student convetStudentModel2Student(StudentModel studentModel) {
		Student student = new Student();
		student.setId(studentModel.getId());
		student.setFirstname(studentModel.getFirstname());
		student.setLastname(studentModel.getLastname());
		student.setClase(studentModel.getClase());
		student.setCurso(studentModel.getCurso());
		return student;
	}

	/**
	 * Convet student 2 student model.
	 *
	 * @param student the student
	 * @return the student model
	 */
	public StudentModel convetStudent2StudentModel(Student student) {
		StudentModel studentModel = new StudentModel();
		studentModel.setId(student.getId());
		studentModel.setFirstname(student.getFirstname());
		studentModel.setLastname(student.getLastname());
		studentModel.setClase(student.getClase());
		studentModel.setCurso(student.getCurso());
		return studentModel;
	}

}
