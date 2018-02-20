package com.acilia.ttschool.service;

import java.util.List;

import com.acilia.ttschool.model.ColegioModel;
import com.acilia.ttschool.model.EventModel;

public interface EventService {
	
	public abstract List<EventModel> listAllEvent();
	
	public abstract List<EventModel> findEventGlobal();
	
	public abstract EventModel modifyEvent(EventModel eventmodel);
	
	public abstract EventModel findEventByIdModel(Long id);
	
	public abstract void removeEvent(EventModel eventmodel);

}
