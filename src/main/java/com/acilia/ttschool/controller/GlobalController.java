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
@RequestMapping("/global")
public class GlobalController {
	
	private static final Log LOG = LogFactory.getLog(CursoController.class);
	
	@Autowired
	@Qualifier("logutils")
	private LogUtils logutils;

	@Autowired
	@Qualifier("eventServiceImpl")
	private EventService eventService;
	
	
	@Autowired
	@Qualifier("colegioServiceImpl")
	private ColegioService colegioService;

	@GetMapping()
	public String listar(Model model) {
		
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		model.addAttribute("titulo", "Notificaciones globales");
		EventModel evento = new EventModel();
		model.addAttribute("event", evento);
		return "calendar/global";
	}
	@GetMapping("/events")
	public @ResponseBody List<EventModel> getEventos() {
		List<EventModel> eventos = new ArrayList();
		//eventos=eventService.findEventGlobal(); // eventos que son del colegio 1
		
		ColegioModel colegiomodel=colegioService.findColegioByIdModel(new Long(1));
		eventos=colegiomodel.getEventos();
		return eventos;
		
	}
	
	@PostMapping()
	public @ResponseBody EventModel add(@ModelAttribute(value = "event") EventModel ev,
			BindingResult result)  {
		logutils.inMetodo(LOG, LogUtils.getNombreMetodo(), null);
		
		EventModel eventModel = null;
		eventModel = eventService.addEvent(ev);
		
		
		return eventModel;

	}
}
