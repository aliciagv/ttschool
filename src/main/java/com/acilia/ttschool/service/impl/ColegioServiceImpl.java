package com.acilia.ttschool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.ColegioConverter;
import com.acilia.ttschool.converter.EventConverter;
import com.acilia.ttschool.entity.Colegio;
import com.acilia.ttschool.entity.Event;
import com.acilia.ttschool.model.ColegioModel;
import com.acilia.ttschool.model.EventModel;
import com.acilia.ttschool.repository.ColegioRepository;
import com.acilia.ttschool.service.ColegioService;
import com.acilia.ttschool.service.EventService;

@Service("colegioServiceImpl")
public class ColegioServiceImpl implements ColegioService {

	@Autowired
	@Qualifier("colegiorepository")
	private ColegioRepository colegioRepository;
	
	@Autowired
	@Qualifier("colegioConverter")
	private ColegioConverter colegioConverter;
	
	@Autowired
	@Qualifier("eventServiceImpl")
	private EventService eventService;
	
	
	@Override
	public ColegioModel findColegioByIdModel(Long id) {
		ColegioModel colegiomodel =null;
		Colegio colegio=colegioRepository.findById(id);
		colegiomodel=colegioConverter.convertColegio2ColegioModel(colegio);
		return colegiomodel;
	}

	@Override
	public EventModel addEvent(ColegioModel colegiomodel,EventModel eventmodel) {
	
		EventModel reventmodel=null;
		Colegio colegio=colegioRepository.save(colegioConverter.convertColegioModel2Colegioadd(colegiomodel, eventmodel));
		//reventmodel=eventConverter.convertEventModel2Event(eventModel);
		return reventmodel;
		
	}

	@Override
	public void removeEvent(ColegioModel colegiomodel, EventModel eventmodel) {
		Colegio colegio=colegioConverter.convertColegioModel2Colegioremove(colegiomodel, eventmodel);
		colegioRepository.save(colegio);
		eventService.removeEvent(eventmodel);
		
		
	}



}
