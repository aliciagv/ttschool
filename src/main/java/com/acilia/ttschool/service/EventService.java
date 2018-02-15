package com.acilia.ttschool.service;

import java.util.List;

import com.acilia.ttschool.model.ColegioModel;
import com.acilia.ttschool.model.EventModel;

public interface EventService {
	
	public abstract List<EventModel> listAllEvent();
	
	public abstract List<EventModel> findEventGlobal();

}
