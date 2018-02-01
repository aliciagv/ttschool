/*
 * 
 */
package com.acilia.ttschool.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Telefono;
import com.acilia.ttschool.model.PersonaModel;
import com.acilia.ttschool.model.TelefonoModel;


@Component("telefonoConverter")


public class TelefonoConverter {

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConvert personaConverter;
	
	
	public Telefono convetTelefonoModel2Telefono (TelefonoModel telefonoModel) {
		Telefono telefono = new Telefono();
		telefono.setId(telefonoModel.getIdTelefono());
		telefono.setNumero(telefonoModel.getNumero());
		return telefono;
	}
	
	public Telefono convetTelefonoModel2TelefonoWithPerson (TelefonoModel telefonoModel,PersonaModel personaModel) {
		Telefono telefono = new Telefono();
		telefono.setId(telefonoModel.getIdTelefono());
		telefono.setNumero(telefonoModel.getNumero());
		telefono.setPersona(personaConverter.convertPersonaModel2Persona(personaModel));
		return telefono;
	}

	public TelefonoModel convetTelefono2TelefonoModel(Telefono telefono) {
		TelefonoModel telefonoModel = new TelefonoModel();
		telefonoModel.setIdTelefono(telefono.getId());
		telefonoModel.setNumero(telefono.getNumero());
		return telefonoModel;
	}



}
