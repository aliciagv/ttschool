package com.acilia.ttschool.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="event")

public class Event {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column (name="title", nullable=false, length=250 )
	private String  title;
	
	
	@Column(name="startdate",  nullable=false)
	private Date startdate;
	
	@Column(name="enddate")
	private Date enddate;
	
	@Column (name="url", length=200 )
	private String url;
	
	@Column (name="className", length=200)
	private String className;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "eventos")
	private List<Colegio> colegio;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Event(Long id, String title, Date startdate, Date enddate, String url, String className) {
		super();
		this.id = id;
		this.title = title;
		this.startdate = startdate;
		this.enddate = enddate;
		this.url = url;
		this.className = className;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
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



	public List<Colegio> getColegio() {
		return colegio;
	}



	public void setColegio(List<Colegio> colegio) {
		this.colegio = colegio;
	}

	
	


	
	
	
}
