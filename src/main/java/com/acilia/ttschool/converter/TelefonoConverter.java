/*
 * 
 */
package com.acilia.ttschool.converter;

import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Email;
import com.acilia.ttschool.entity.Telefono;
import com.acilia.ttschool.model.EmailModel;
import com.acilia.ttschool.model.TelefonoModel;


@Component("telefonoConverter")
public class TelefonoConverter {
	
	public Telefono convetTelefonoModel2Telefono (TelefonoModel telefonoModel) {
		Telefono telefono = new Telefono();
		telefono.setId(telefonoModel.getIdTelefono());
		telefono.setNumero(telefonoModel.getNumero());
		return telefono;
	}

	public TelefonoModel convetTelefono2TelefonoModel(Telefono telefono) {
		TelefonoModel telefonoModel = new TelefonoModel();
		telefonoModel.setIdTelefono(telefono.getId());
		telefonoModel.setNumero(telefono.getNumero());
		return telefonoModel;
	}



}
