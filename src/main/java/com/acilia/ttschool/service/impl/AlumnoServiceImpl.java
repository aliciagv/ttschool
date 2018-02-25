package com.acilia.ttschool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.AlumnoConverter;
import com.acilia.ttschool.entity.Alumno;
import com.acilia.ttschool.model.AlumnoModel;
import com.acilia.ttschool.repository.AlumnoRepository;
import com.acilia.ttschool.service.AlumnoService;

@Service("alumnoServiceImpl")
public class AlumnoServiceImpl  implements AlumnoService{

	@Autowired
	@Qualifier("alumnorepository")
	private AlumnoRepository alumnoRepository;
	
	
	@Autowired
	@Qualifier("alumnoConverter")
	private AlumnoConverter alumnoConverter;

	
	@Override
	public AlumnoModel addAlumno(AlumnoModel alumnomodel) {
		// TODO Auto-generated method stub
		Alumno a = alumnoRepository.save(alumnoConverter.convetAlumnoModel2Alumno(alumnomodel));
		return alumnoConverter.convetAlumno2AlumnoModel(a);
	}

	@Override
	public List<AlumnoModel> listAllAlumno() {
		// TODO Auto-generated method stub
		List<Alumno> listalumno=alumnoRepository.findAll();
		List<AlumnoModel> listalumnoModel = new ArrayList<AlumnoModel>();
		for (int i=0;i<listalumno.size();i++){
			listalumnoModel.add(alumnoConverter.convetAlumno2AlumnoModel(listalumno.get(i)));
		}
		return listalumnoModel;
	}

	@Override
	public AlumnoModel findAlumnoByIdModel(Long id) {
		AlumnoModel alumnoModel=null;	
		Alumno alumno= alumnoRepository.findById(id);
		if (alumno!=null)
			alumnoModel=alumnoConverter.convetAlumno2AlumnoModel(alumno);
		return alumnoModel;
	}

	@Override
	public void removeAlumno(AlumnoModel alumnoModel) {
		Alumno alumno=alumnoConverter.convetAlumnoModel2Alumno(alumnoModel);
		alumnoRepository.delete(alumno);
		
		
		
	}

}
