package com.acilia.ttschool.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acilia.ttschool.entity.Colegio;
import com.acilia.ttschool.entity.Event;
import com.acilia.ttschool.model.EventModel;
import com.acilia.ttschool.model.ColegioModel;

@Component("eventConverter")
public class EventConverter {
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public Event convertEventModel2Event(EventModel eventModel){
		Event event = new Event();
		event.setId(eventModel.getIdEvent());
		event.setTitle(eventModel.getTitle());
		try {
			event.setStartdate(sdf.parse(eventModel.getStart()));
			event.setEnddate((eventModel.getEnd()!=null && !eventModel.getEnd().equalsIgnoreCase("")?sdf.parse(eventModel.getEnd()):null));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		event.setUrl(eventModel.getUrl());
		event.setClassName(eventModel.getClassName());
		return event;
		
	}

	public EventModel convertEvent2EventModel(Event event){
		EventModel eventmodel = new EventModel();
		eventmodel.setIdEvent(event.getId());
		eventmodel.setTitle(event.getTitle());
		eventmodel.setStart(event.getStartdate().toString());
		eventmodel.setEnd(event.getEnddate()!=null?event.getEnddate().toString():null);
		eventmodel.setUrl(event.getUrl());
		eventmodel.setClassName(event.getClassName());
		return eventmodel;
		
		
	}

}
