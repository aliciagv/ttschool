package com.acilia.ttschool.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Colegio;
import com.acilia.ttschool.entity.Curso;
import com.acilia.ttschool.entity.Event;
import com.acilia.ttschool.model.ColegioModel;
import com.acilia.ttschool.model.EventModel;


@Component("colegioConverter")
public class ColegioConverter {
	
	@Autowired
	@Qualifier("eventConverter")
	private EventConverter eventConverter;
	
	public Colegio convertColegioModel2Colegioadd(ColegioModel colegioModel,EventModel eventmodel){
		Colegio colegio = new Colegio();
		colegio.setId(colegioModel.getIdColegio());
		colegio.setNombre(colegioModel.getNombre());
		colegio.setDireccion(colegioModel.getDireccion());
		Event evento=eventConverter.convertEventModel2Event(eventmodel);
		if (colegioModel.getEventos()==null){
			List<Event> listevento= new ArrayList<Event>();
			listevento.add(evento);
			colegio.setEventos(listevento);
		} else {
			List<Event> listeventos= new ArrayList<Event>();
			colegio.setEventos(listeventos);
			for (int i=0;i<colegioModel.getEventos().size();i++){
				colegio.getEventos().add(eventConverter.convertEventModel2Event(colegioModel.getEventos().get(i)));
			}
			colegio.getEventos().add(evento);
		}
		return colegio;
		
	}
	
	public Colegio convertColegioModel2Colegioremove(ColegioModel colegioModel,EventModel eventmodel){
		Colegio colegio = new Colegio();
		colegio.setId(colegioModel.getIdColegio());
		colegio.setNombre(colegioModel.getNombre());
		colegio.setDireccion(colegioModel.getDireccion());
		List<Event> listeventos= new ArrayList<Event>();
		colegio.setEventos(listeventos);
		for (int i=0;i<colegioModel.getEventos().size();i++){
			if (!colegioModel.getEventos().get(i).getIdEvent().equals(eventmodel.getIdEvent()))
			colegio.getEventos().add(eventConverter.convertEventModel2Event(colegioModel.getEventos().get(i)));
			}
			
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
			colegiomodel.setEventos(eventos);
		}
		
		return colegiomodel;
		
		
	}

}
