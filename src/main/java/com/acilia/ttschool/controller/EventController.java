package com.acilia.ttschool.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acilia.ttschool.model.ColegioModel;
import com.acilia.ttschool.model.EventModel;
import com.acilia.ttschool.model.ProfesorModel;
import com.acilia.ttschool.service.ColegioService;
import com.acilia.ttschool.service.EventService;
import com.acilia.ttschool.utils.LogUtils;

@Controller
@RequestMapping("/event")
public class EventController {
	
	private static final Log LOG = LogFactory.getLog(EventController.class);
	
	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;

	@Autowired
	@Qualifier("eventServiceImpl")
	private EventService eventService;
	
	@PostMapping()
	public @ResponseBody EventModel  modify (@ModelAttribute(value = "event") EventModel ev){
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		EventModel eventModel=null;
		eventModel=eventService.modifyEvent(ev);
		return eventModel;
	}

	

}
