package com.acilia.ttschool.service;

import java.util.List;

import com.acilia.ttschool.model.AlumnoModel;

public interface AlumnoService {
	
public abstract AlumnoModel addAlumno(AlumnoModel alumnomodel);
	
	public abstract List<AlumnoModel>listAllAlumno();
	
	public AlumnoModel findAlumnoByIdModel(int id);
	
	public abstract void removeAlumno(int id);

}
