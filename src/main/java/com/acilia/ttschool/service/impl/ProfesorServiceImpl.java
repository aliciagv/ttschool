package com.acilia.ttschool.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.ProfesorConverter;
import com.acilia.ttschool.entity.Profesor;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.repository.ProfesorRepository;
import com.acilia.ttschool.service.ProfesorService;

@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	@Qualifier("profesorrepository")
	private ProfesorRepository profesorRepository;
	
	
	@Autowired
	@Qualifier("profesorConverter")
	private ProfesorConverter profesorConverter;
	
	
	@Override
	public ProfesorModel addProfesor(ProfesorModel profesormodel){
		ProfesorModel rprofesormodel=null;
		Profesor profesor = profesorRepository.save(profesorConverter.convetProfesorModel2Profesor(profesormodel));
		profesormodel=profesorConverter.convetProfesor2ProfesorModel(profesor);
		return rprofesormodel;
		
		
	}

	@Override
	public List<ProfesorModel> listAllProfesor() {
		// TODO Auto-generated method stub
		List<Profesor> listaprofesor=profesorRepository.findAll();
		List<ProfesorModel> listaprofesorModel = new ArrayList<ProfesorModel>();
		for (int i=0;i<listaprofesor.size();i++){
			listaprofesorModel.add(profesorConverter.convetProfesor2ProfesorModel(listaprofesor.get(i)));
		}
		return listaprofesorModel;
	}

	@Override
	public ProfesorModel findProfesorByIdModel(Long id) {
		// TODO Auto-generated method stub
		ProfesorModel profesorModel=null;
		Profesor profesor = profesorRepository.findById(id);
		if (profesor!=null){
			profesorModel= profesorConverter.convetProfesor2ProfesorModel(profesor);
		}
		
		return profesorModel; 
	}

	@Override
	public void removeProfesor(ProfesorModel profesormodel) {
		Profesor profesor=profesorConverter.convetProfesorModel2Profesor(profesormodel);
		profesorRepository.delete(profesor);
		
	}
}
