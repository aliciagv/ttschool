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
import com.acilia.ttschool.entity.Telefono;
import com.acilia.ttschool.model.AlumnoModel;
import com.acilia.ttschool.model.EmailModel;
import com.acilia.ttschool.model.TelefonoModel;

// TODO: Auto-generated Javadoc
/**
 * The Class AlumnoConverter.
 */
@Component("alumnoConverter")
public class AlumnoConverter {
	
	@Autowired
	@Qualifier("emailConverter")
	private EmailConverter emailConverter;

	@Autowired
	@Qualifier("telefonoConverter")
	private TelefonoConverter telefonoConverter;

	/**
	 * Convet alumno model 2 alumno.
	 *
	 * @param alumnoModel the alumno model
	 * @return the alumno
	 */
	public Alumno convetAlumnoModel2Alumno(AlumnoModel alumnoModel) {
		Alumno alumno = new Alumno();
		alumno.setId(alumnoModel.getIdPersona());
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
		if (alumnoModel.getTelefonos()!=null && alumnoModel.getTelefonos().size()>0){ 
			List<Telefono> telefonos = new ArrayList<Telefono>();
			alumno.setTelefonos(telefonos);
			for (int i=0; i<alumnoModel.getTelefonos().size();i++){
				alumno.getTelefonos().add(telefonoConverter.convetTelefonoModel2Telefono(alumnoModel.getTelefonos().get(i)));
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
		alumnoModel.setIdPersona(alumno.getId());
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
		
		if (alumno.getTelefonos()!=null && alumno.getTelefonos().size()>0){
			List<TelefonoModel> telefonos = new ArrayList<TelefonoModel>();
			alumnoModel.setTelefonos(telefonos);
			for (int i=0; i<alumno.getEmails().size();i++){
				alumnoModel.getTelefonos().add(telefonoConverter.convetTelefono2TelefonoModel(alumno.getTelefonos().get(i)));
			}
		}
		
		return alumnoModel;
	}



}
