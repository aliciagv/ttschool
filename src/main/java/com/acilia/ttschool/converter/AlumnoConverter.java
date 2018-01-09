/*
 * 
 */
package com.acilia.ttschool.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Alumno;
import com.acilia.ttschool.entity.Email;
import com.acilia.ttschool.model.AlumnoModel;
import com.acilia.ttschool.model.EmailModel;

// TODO: Auto-generated Javadoc
/**
 * The Class AlumnoConverter.
 */
@Component("alumnoConverter")
public class AlumnoConverter {
	
	@Autowired
	@Qualifier("emailConverter")
	private EmailConverter emailConverter;


	/**
	 * Convet alumno model 2 alumno.
	 *
	 * @param alumnoModel the alumno model
	 * @return the alumno
	 */
	public Alumno convetAlumnoModel2Alumno(AlumnoModel alumnoModel) {
		Alumno alumno = new Alumno();
		alumno.setId(alumnoModel.getId());
		alumno.setNombre(alumnoModel.getNombre());
		alumno.setApellidos(alumnoModel.getApellidos());
		alumno.setNif(alumno.getNif());
		alumno.setDireccion(alumnoModel.getDireccion());
		alumno.setfNacimiento(alumnoModel.getfNacimiento());
		if (alumnoModel.getEmails()!=null && alumnoModel.getEmails().size()>0){
			List<Email> emails = new  ArrayList<Email>();
			alumno.setEmails(emails);
			for (int i=0; i<alumnoModel.getEmails().size();i++){
				alumno.getEmails().add(emailConverter.convetEmailModel2Email(alumnoModel.getEmails().get(i)));
			}
		}
		
		return alumno;
	}

	/**
	 * Convet alumno 2 alumno model.
	 *
	 * @param alumno the alumno
	 * @return the alumno model
	 */
	public AlumnoModel convetAlumno2AlumnoModel(Alumno alumno) {
		AlumnoModel alumnoModel = new AlumnoModel();
		alumnoModel.setId(alumno.getId());
		alumnoModel.setNombre(alumno.getNombre());
		alumnoModel.setApellidos(alumno.getApellidos());
		alumnoModel.setNif(alumno.getNif());
		alumnoModel.setDireccion(alumno.getDireccion());
		alumnoModel.setfNacimiento(alumno.getfNacimiento());
		if (alumno.getEmails()!=null && alumno.getEmails().size()>0){
			List<EmailModel> emails = new ArrayList<EmailModel>();
			alumnoModel.setEmails(emails);
			for (int i=0; i<alumno.getEmails().size();i++){
				alumnoModel.getEmails().add(emailConverter.convetEmail2EmailModel(alumno.getEmails().get(i)));
			}
		}
		
		return alumnoModel;
	}



}
