package com.acilia.ttschool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.CursoConverter;
import com.acilia.ttschool.entity.Curso;
import com.acilia.ttschool.model.CursoModel;
import com.acilia.ttschool.repository.CursoRepository;
import com.acilia.ttschool.service.CursoService;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements CursoService {

	@Autowired
	@Qualifier("cursorepository")
	private CursoRepository cursoRepository;
		
	@Autowired
	@Qualifier("cursoConverter")
	private CursoConverter cursoConverter;
	
	@Override
	public CursoModel addCurso(CursoModel cursomodel) {
		CursoModel rcursomodel=null;
		Curso curso=cursoRepository.save(cursoConverter.convertCursoModel2Curso(cursomodel));
		rcursomodel=cursoConverter.convertCurso2CursoModel(curso);
		return rcursomodel;
	}

	@Override
	public List<CursoModel> listAll() {
		List<Curso> listacurso=cursoRepository.findAll();
		List<CursoModel> listacursoModel = new ArrayList<CursoModel>();
		for (int i=0;i<listacurso.size();i++){
			listacursoModel.add(cursoConverter.convertCurso2CursoModel(listacurso.get(i)));
		}
		return listacursoModel;
	}
	
	@Override
	public List<CursoModel> listNotAssigned() {
		
		List<Curso> listacurso=cursoRepository.findNotAssigned();
		List<CursoModel> listacursoModel = new ArrayList<CursoModel>();
		for (int i=0;i<listacurso.size();i++){
			listacursoModel.add(cursoConverter.convertCurso2CursoModel(listacurso.get(i)));
		}
		return listacursoModel;
	}

	@Override
	public CursoModel findCursoByIdModel(Long id) {
		CursoModel cursomodel = null;
		Curso curso = cursoRepository.findById(id);
		if (curso!=null){
			cursomodel= cursoConverter.convertCurso2CursoModel(curso);
		}
		return cursomodel;
	}

	@Override
	public void removeCurso(CursoModel cursomodel) {
		Curso curso= cursoConverter.convertCursoModel2Curso(cursomodel);
		cursoRepository.delete(curso);
		
	}



}
