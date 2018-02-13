package com.acilia.ttschool.service;

import java.util.List;

import com.acilia.ttschool.model.AlumnoModel;

public interface AlumnoService {
	
	public  AlumnoModel addAlumno(AlumnoModel alumnomodel);
	
	public  List<AlumnoModel>listAllAlumno();
	
	public AlumnoModel findAlumnoByIdModel(int id);
	
	public  void removeAlumno(int id);

}
