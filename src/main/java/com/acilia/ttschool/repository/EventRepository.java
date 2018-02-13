package com.acilia.ttschool.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Event;

@Repository("eventrepository")
public interface EventRepository  extends JpaRepository<Event,Serializable>{
	
	 @Query("select  e from Event e INNER JOIN  e.colegio c where c.id=1)")
	 public abstract List<Event> findEventGlobal();

	 
}
