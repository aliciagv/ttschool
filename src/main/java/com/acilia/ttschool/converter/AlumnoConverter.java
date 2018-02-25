/*
 * 
 */
package com.acilia.ttschool.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Alumno;
import com.acilia.ttschool.entity.Curso;
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
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	
	@Autowired
	@Qualifier("emailConverter")
	private EmailConverter emailConverter;

	@Autowired
	@Qualifier("telefonoConverter")
	private TelefonoConverter telefonoConverter;
	
	@Autowired
	@Qualifier("cursoConverter")
	private CursoConverter cursoConverter;

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
		alumno.setNif((alumno.getNif()!=null && alumno.getNif().equalsIgnoreCase(""))?null:alumno.getNif());
		alumno.setDireccion(alumnoModel.getDireccion());
		if (alumnoModel.getfNacimiento()!=null && !alumnoModel.getfNacimiento().equalsIgnoreCase("")){
			try {
				alumno.setfNacimiento(sdf.parse(alumnoModel.getfNacimiento()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			alumno.setfNacimiento(null);
		}
		
		boolean add=false;
		if (alumnoModel.getEmails()!=null && alumnoModel.getEmails().size()>0){
			List<Email> emails = new  ArrayList<Email>();
			Email email=null;
			for (int i=0; i<alumnoModel.getEmails().size();i++){
				if (alumnoModel.getEmails().get(i)!=null && !alumnoModel.getEmails().get(i).getEmail().equalsIgnoreCase("")){
					email=emailConverter.convetEmailModel2Email(alumnoModel.getEmails().get(i));
					emails.add(email);
					add=true;
				}
			}
			if (add){
				alumno.setEmails(emails);
			}
		}
		add=false;
		if (alumnoModel.getTelefonos()!=null && alumnoModel.getTelefonos().size()>0){ 
			List<Telefono> telefonos = new ArrayList<Telefono>();
			Telefono telefono=null;
			for (int i=0; i<alumnoModel.getTelefonos().size();i++){
				if (alumnoModel.getTelefonos().get(i)!=null && !alumnoModel.getTelefonos().get(i).getNumero().equalsIgnoreCase("")) {
					telefono=telefonoConverter.convetTelefonoModel2TelefonoWithPerson(alumnoModel.getTelefonos().get(i), alumnoModel);;	
					telefonos.add(telefono);
					add=true;
				}
				
			}
			if (add) {
				alumno.setTelefonos(telefonos);
			}
		}
		if (alumnoModel.getCurso()!=null){
			Curso curso=null;
			if (alumnoModel.getCurso().getIdCurso()!=0){
				curso = cursoConverter.convertCursoModel2Curso(alumnoModel.getCurso());
			}
			alumno.setCurso(curso);
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
		if (alumno.getfNacimiento()!=null){
			alumnoModel.setfNacimiento(sdf.format(alumno.getfNacimiento()));
		}
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
		if (alumno.getCurso()!=null){
			alumnoModel.setCurso(cursoConverter.convertCurso2CursoModel(alumno.getCurso()));
		}
		
		return alumnoModel;
	}



}
