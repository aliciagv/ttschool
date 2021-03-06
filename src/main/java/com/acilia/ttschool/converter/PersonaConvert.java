package com.acilia.ttschool.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Persona;
import com.acilia.ttschool.entity.Profesor;
import com.acilia.ttschool.model.PersonaModel;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.model.Role;

@Component("personaConverter")
public class PersonaConvert {
	
	@Autowired
	@Qualifier("alumnoConverter")
	private AlumnoConverter alumnoConverter;
	
	@Autowired
	@Qualifier("profesorConverter")
	private ProfesorConverter profesorConverter;

	
	public PersonaModel convetPersona2PersonaModel(Persona persona,String role) { 
		PersonaModel personaModel = null;
		if (role.equalsIgnoreCase(Role.ADMIN.getRole())){
			personaModel = new PersonaModel();
			personaModel.setNombre(persona.getNombre());
			personaModel.setApellidos(persona.getApellidos());
			personaModel.setNif(persona.getNif());
		} else if (role.equals(Role.TEACHER.getRole())){
			personaModel = profesorConverter.convetUser2ProfesorModel(persona);
			
			
		} else if(role.equalsIgnoreCase("Alumno")){
			//alumnoConverter
		}
		return personaModel;
		
	}
	
	public Persona convertPersonaModel2Persona(PersonaModel personaModel){
		Persona persona = new Persona();
		persona.setId(personaModel.getIdPersona());
		return persona;
		
	}

}
