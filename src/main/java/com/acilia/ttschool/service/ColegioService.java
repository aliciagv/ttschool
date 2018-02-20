package com.acilia.ttschool.service;

import com.acilia.ttschool.model.ColegioModel;
import com.acilia.ttschool.model.EventModel;

public interface ColegioService {
	
	public ColegioModel findColegioByIdModel(Long id);
	
	public EventModel addEvent(ColegioModel colegiomodel,EventModel eventmodel);
	
	public abstract void removeEvent(ColegioModel colegiomodel,EventModel eventmodel);
	

}
