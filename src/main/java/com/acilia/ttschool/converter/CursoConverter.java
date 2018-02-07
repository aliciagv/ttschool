package com.acilia.ttschool.converter;

import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Curso;
import com.acilia.ttschool.model.CursoModel;

@Component("cursoConverter")
public class CursoConverter {
	
	public Curso convertCursoModel2Curso(CursoModel cursoModel){
		Curso curso = new Curso();
		curso.setId(cursoModel.getIdCurso());
		curso.setNombre(cursoModel.getNombre());
		curso.setLetra(cursoModel.getLetra());
		curso.setDescipcion(cursoModel.getDescripcion());
		return curso;
		
	}

	public CursoModel convertCurso2CursoModel(Curso curso){
		CursoModel cursomodel = new CursoModel();
		cursomodel.setIdCurso(curso.getId());
		cursomodel.setNombre(curso.getNombre());
		cursomodel.setLetra(curso.getLetra());
		cursomodel.setDescripcion(curso.getDescipcion());
		return cursomodel;
		
		
	}
}
