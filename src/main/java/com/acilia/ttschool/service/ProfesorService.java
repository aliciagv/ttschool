package com.acilia.ttschool.service;

import java.util.List;

import com.acilia.ttschool.model.ProfesorModel;

public interface ProfesorService {
	
	public abstract ProfesorModel addProfesor(ProfesorModel profesormodel);
	
	public abstract List<ProfesorModel>listAllProfesor();
	
	public ProfesorModel findProfesorByIdModel(int id);
	
	public abstract void removeProfesor(int id);

}