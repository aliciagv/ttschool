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
import com.acilia.ttschool.repository.TelefonoRepository;
import com.acilia.ttschool.service.ProfesorService;

@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	@Qualifier("profesorrepository")
	private ProfesorRepository profesorRepository;
	
	@Autowired
	@Qualifier("telefonorepository")
	private TelefonoRepository telefonorepository;
	
	@Autowired
	@Qualifier("profesorConverter")
	private ProfesorConverter profesorConverter;
	
	
	@Override
	public ProfesorModel addProfesor(ProfesorModel profesormodel) {
		// TODO Auto-generated method stub
		Profesor profesor=null;
		if (profesormodel.getIdPersona()!=null){
			//modificación
			Profesor profesorbbdd =profesorRepository.findById(profesormodel.getIdPersona());
			reviewTelefonos(profesorbbdd,profesormodel);
			//removeEmails();
		}else {
			//creación
			profesor = profesorRepository.save(profesorConverter.convetProfesorModel2Profesor(profesormodel));
		}
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
	
	private void reviewTelefonos(Profesor profesorbbdd,ProfesorModel profesormodel){
		if (profesorbbdd!=null){
		boolean find=false;
		for (int i=0; i<profesorbbdd.getTelefonos().size(); i++){
		
			if (profesormodel.getTelefonos()==null){
				telefonorepository.delete(profesorbbdd.getTelefonos().get(i));
			}
			else {
				int j=0;
				find=false;
				while (j<profesormodel.getTelefonos().size()&& (!find)){
					if (profesorbbdd.getTelefonos().get(i).getId().compareTo(profesormodel.getTelefonos().get(j).getIdTelefono())==0){
						//SON IGUALES
						find=true;
					}
					j++;
					
					
				}
				if (!find) telefonorepository.delete(profesorbbdd.getTelefonos().get(i));
			}
			
			
			
		}
		}
		
	}
	

}
