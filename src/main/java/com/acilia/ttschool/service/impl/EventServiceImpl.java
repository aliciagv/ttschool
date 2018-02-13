package com.acilia.ttschool.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.EventConverter;
import com.acilia.ttschool.entity.Event;
import com.acilia.ttschool.entity.Profesor;
import com.acilia.ttschool.model.EventModel;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.repository.EventRepository;
import com.acilia.ttschool.service.EventService;

@Service("eventServiceImpl")
public class EventServiceImpl implements EventService {

	@Autowired
	@Qualifier("eventrepository")
	private EventRepository eventRepository;
	
	@Autowired
	@Qualifier("eventConverter")
	private EventConverter eventConverter;
	
	@Override
	public List<EventModel> listAllEvent() {
		List<Event> listevent= eventRepository.findAll();
		List<EventModel> listeventModel= new ArrayList<EventModel>();
		for (int i=0; i<listevent.size();i++){
			listeventModel.add(eventConverter.convertEvent2EventModel(listevent.get(i)));
		}
		return listeventModel;
	}

	@Override
	public EventModel addEvent(EventModel ev) {
		EventModel reventmodel=null;
		Event event = eventRepository.save(eventConverter.convertEventModel2Event(ev));
		reventmodel=eventConverter.convertEvent2EventModel(event);
		return reventmodel;
	}

	@Override
	public List<EventModel> findEventGlobal() {
		List<Event> listevent= eventRepository.findEventGlobal();
		List<EventModel> listeventModel= new ArrayList<EventModel>();
		for (int i=0; i<listevent.size();i++){
			listeventModel.add(eventConverter.convertEvent2EventModel(listevent.get(i)));
		}
		return listeventModel;
	}

}
