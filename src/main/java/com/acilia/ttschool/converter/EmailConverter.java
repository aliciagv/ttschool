/*
 * 
 */
package com.acilia.ttschool.converter;

import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Email;
import com.acilia.ttschool.model.EmailModel;


@Component("emailConverter")
public class EmailConverter {
	
	public Email convetEmailModel2Email(EmailModel emailModel) {
		Email email = new Email();
		email.setId(emailModel.getIdEmail());
		email.setEmail(emailModel.getEmail());
		
		return email;
	}

	public EmailModel convetEmail2EmailModel(Email email) {
		EmailModel emailModel = new EmailModel();
		emailModel.setIdEmail(email.getId());
		emailModel.setEmail(email.getEmail());
		return emailModel;
	}



}
