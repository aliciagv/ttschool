package com.acilia.ttschool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.AlumnoConverter;
import com.acilia.ttschool.converter.ProfesorConverter;
import com.acilia.ttschool.entity.Alumno;
import com.acilia.ttschool.entity.Profesor;
import com.acilia.ttschool.model.AlumnoModel;
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
	public ProfesorModel addProfesor(ProfesorModel profesormodel) {
		// TODO Auto-generated method stub
		Profesor profesor = profesorRepository.save(profesorConverter.convetProfesorModel2Profesor(profesormodel));
		return profesorConverter.convetProfesor2ProfesorModel(profesor);
		
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
	public ProfesorModel findProfesorByIdModel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProfesor(int id) {
		// TODO Auto-generated method stub
		
	}

}
