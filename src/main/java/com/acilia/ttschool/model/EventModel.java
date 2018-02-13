package com.acilia.ttschool.model;

import java.io.Serializable;
import java.util.Date;

public class EventModel implements Serializable {
	
	private static final long serialVersionUID = 2957465095556562442L;

	
	private Long idEvent;
	
	private String  title;
	
	private String start;
	
	private String end;
	
	private String url;
	
	private String className;
	
	private ColegioModel colegio;

	
	
	public EventModel() {

	}

	
	public EventModel(Long idEvent, String title, String start, String end, String url, String className) {
		super();
		this.idEvent = idEvent;
		this.title = title;
		this.start = start;
		this.end = end;
		this.url = url;
		this.className = className;
	}


	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	

}
