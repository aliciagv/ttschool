/*
 * 
 */
package com.acilia.ttschool.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Email;
import com.acilia.ttschool.model.EmailModel;
import com.acilia.ttschool.model.PersonaModel;


@Component("emailConverter")
public class EmailConverter {
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConvert personaConverter;
	
	public Email convetEmailModel2Email(EmailModel emailModel) {
		Email email = new Email();
		email.setId(emailModel.getIdEmail());
		email.setEmail(emailModel.getEmail());
		
		return email;
	}
	
	public Email convertEmailModel2EmailWithPerson(EmailModel emailModel,PersonaModel personaModel){
		Email email = new Email();
		email.setId(emailModel.getIdEmail());
		email.setEmail(emailModel.getEmail());
		email.setPersona(personaConverter.convertPersonaModel2Persona(personaModel));
		return email;
	}

	public EmailModel convetEmail2EmailModel(Email email) {
		EmailModel emailModel = new EmailModel();
		emailModel.setIdEmail(email.getId());
		emailModel.setEmail(email.getEmail());
		return emailModel;
	}



}
