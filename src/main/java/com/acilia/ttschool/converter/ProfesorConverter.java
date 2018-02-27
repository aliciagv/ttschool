/*
 * 
 */
package com.acilia.ttschool.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Alumno;
import com.acilia.ttschool.entity.Curso;
import com.acilia.ttschool.entity.Email;
import com.acilia.ttschool.entity.Persona;
import com.acilia.ttschool.entity.Profesor;
import com.acilia.ttschool.entity.Telefono;
import com.acilia.ttschool.entity.User;
import com.acilia.ttschool.model.AlumnoModel;
import com.acilia.ttschool.model.EmailModel;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.model.TelefonoModel;

// TODO: Auto-generated Javadoc

@Component("profesorConverter")
public class ProfesorConverter {
	
	@Autowired
	@Qualifier("emailConverter")
	private EmailConverter emailConverter;


	@Autowired
	@Qualifier("telefonoConverter")
	private TelefonoConverter telefonoConverter;
	
	@Autowired
	@Qualifier("cursoConverter")
	private CursoConverter cursoConverter;

	public Profesor convetProfesorModel2Profesor(ProfesorModel profesorModel) {
		Profesor profesor = new Profesor();
		profesor.setId(profesorModel.getIdPersona());
		if (profesorModel.getIdPersona()==null) {
			profesor.setFcreacion(new Date());
		}
		profesor.setNombre(profesorModel.getNombre());
		profesor.setApellidos(profesorModel.getApellidos());
		profesor.setNif((profesorModel.getNif()!=null && !profesorModel.getNif().equalsIgnoreCase(""))?profesorModel.getNif():null);
		
		boolean add=false;
		if (profesorModel.getEmails()!=null && profesorModel.getEmails().size()>0){
			List<Email> emails = new  ArrayList<Email>();
			Email email=null;
			for (int i=0; i<profesorModel.getEmails().size();i++){
				if (profesorModel.getEmails().get(i)!=null && !profesorModel.getEmails().get(i).getEmail().equalsIgnoreCase("")) {
					if (profesorModel.getEmails().get(i).getIdEmail()!=null){
						email=emailConverter.convertEmailModel2EmailWithPerson(profesorModel.getEmails().get(i),profesorModel);
					}else {
						email=emailConverter.convetEmailModel2Email(profesorModel.getEmails().get(i));
					}
					emails.add(email);	
					add=true;
				}	
			}
			if (add){
				profesor.setEmails(emails);
			}
		}
		
		add=false;
		if (profesorModel.getTelefonos()!=null && profesorModel.getTelefonos().size()>0){ 
			List<Telefono> telefonos = new ArrayList<Telefono>();
			Telefono telefono=null;
			for (int i=0; i<profesorModel.getTelefonos().size();i++){
				if (profesorModel.getTelefonos().get(i)!=null && !profesorModel.getTelefonos().get(i).getNumero().equalsIgnoreCase("")) {
					if (profesorModel.getTelefonos().get(i).getIdTelefono()!=null){
						telefono=telefonoConverter.convetTelefonoModel2TelefonoWithPerson(profesorModel.getTelefonos().get(i), profesorModel);;	
					}else {
						telefono=telefonoConverter.convetTelefonoModel2Telefono(profesorModel.getTelefonos().get(i));
					}
					telefonos.add(telefono);
					add=true;
				}
				
			}
			if (add) {
				profesor.setTelefonos(telefonos);
			}
		}
		if (profesorModel.getCurso()!=null){
			if (profesorModel.getCurso().getIdCurso()!=0){
				Curso curso=null;
				curso = cursoConverter.convertCursoModel2Curso(profesorModel.getCurso());
				profesor.setCurso(curso);
			}
			
		}	
			
			
		
		
		
		return profesor;
	}

	/**
	 * Convet alumno 2 alumno model.
	 *
	 * @param alumno the alumno
	 * @return the alumno model
	 */
	public ProfesorModel convetProfesor2ProfesorModel(Profesor profesor) {
		ProfesorModel profesorModel = new ProfesorModel();
		profesorModel.setIdPersona(profesor.getId());
		profesorModel.setNombre(profesor.getNombre());
		profesorModel.setApellidos(profesor.getApellidos());
		profesorModel.setNif(profesor.getNif());
		
		if (profesor.getEmails()!=null && profesor.getEmails().size()>0){
			List<EmailModel> emails = new ArrayList<EmailModel>();
			profesorModel.setEmails(emails);
			for (int i=0; i<profesor.getEmails().size();i++){
				profesorModel.getEmails().add(emailConverter.convetEmail2EmailModel(profesor.getEmails().get(i)));
			}
		}
		if (profesor.getTelefonos()!=null && profesor.getTelefonos().size()>0){
			List<TelefonoModel> telefonos = new ArrayList<TelefonoModel>();
			profesorModel.setTelefonos(telefonos);
			for (int i=0; i<profesor.getTelefonos().size();i++){
				profesorModel.getTelefonos().add(telefonoConverter.convetTelefono2TelefonoModel(profesor.getTelefonos().get(i)));
			}
		}
		if (profesor.getCurso()!=null){
			profesorModel.setCurso(cursoConverter.convertCurso2CursoModel(profesor.getCurso()));
		}
		
		return profesorModel;
	}

	public ProfesorModel convetUser2ProfesorModel(Persona persona) {
		ProfesorModel profesorModel = new ProfesorModel();
		profesorModel.setIdPersona(persona.getId());
		profesorModel.setNombre(persona.getNombre());
		profesorModel.setApellidos(persona.getApellidos());
		profesorModel.setNif(persona.getNif());
		
		if (persona.getEmails()!=null && persona.getEmails().size()>0){
			List<EmailModel> emails = new ArrayList<EmailModel>();
			profesorModel.setEmails(emails);
			for (int i=0; i<persona.getEmails().size();i++){
				profesorModel.getEmails().add(emailConverter.convetEmail2EmailModel(persona.getEmails().get(i)));
			}
		}
		if (persona.getTelefonos()!=null && persona.getTelefonos().size()>0){
			List<TelefonoModel> telefonos = new ArrayList<TelefonoModel>();
			profesorModel.setTelefonos(telefonos);
			for (int i=0; i<persona.getEmails().size();i++){
				profesorModel.getTelefonos().add(telefonoConverter.convetTelefono2TelefonoModel(persona.getTelefonos().get(i)));
			}
		}
		
		return profesorModel;
	}



}
