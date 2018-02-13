package com.acilia.ttschool.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Colegio;
import com.acilia.ttschool.entity.Curso;
import com.acilia.ttschool.model.ColegioModel;
import com.acilia.ttschool.model.EventModel;


@Component("colegioConverter")
public class ColegioConverter {
	
	@Autowired
	@Qualifier("eventConverter")
	private EventConverter eventConverter;
	
	public Colegio convertColegioModel2Colegio(ColegioModel colegioModel){
		Colegio colegio = new Colegio();
		colegio.setId(colegioModel.getIdColegio());
		colegio.setNombre(colegioModel.getNombre());
		colegio.setDireccion(colegioModel.getDireccion());
		
		/*if (colegioModel.getEventos()!=null && colegioModel.getEventos().size()>0){
			for (int i=0; i<colegioModel.getEventos().size();i++){
				 
			}
		}*/
		
		
		return colegio;
		
	}

	public ColegioModel convertColegio2ColegioModel(Colegio colegio){
		ColegioModel colegiomodel = new ColegioModel();
		colegiomodel.setIdColegio(colegio.getId());
		colegiomodel.setNombre(colegio.getNombre());
		colegiomodel.setDireccion(colegio.getDireccion());
		if (colegio.getEventos()!=null && colegio.getEventos().size()>0){
			List<EventModel> eventos = new ArrayList<EventModel>();
			colegiomodel.setEventos(eventos);
			for (int i=0; i<colegio.getEventos().size();i++){
				eventos.add(eventConverter.convertEvent2EventModel(colegio.getEventos().get(i)));
			}
		}
		
		return colegiomodel;
		
		
	}

}
