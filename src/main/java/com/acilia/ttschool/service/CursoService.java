package com.acilia.ttschool.service;

import java.util.List;

import com.acilia.ttschool.model.CursoModel;


public interface CursoService {
	
	public abstract CursoModel addCurso(CursoModel cursomodel);
	
	public abstract List<CursoModel>listAll();
	
	public abstract List<CursoModel>listNotAssigned();
	
	public CursoModel findCursoByIdModel(Long id);
	
	public abstract void removeCurso(CursoModel cursomodel);

}
