package com.acilia.ttschool.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Profesor;

@Repository("profesorrepository")
public interface ProfesorRepository  extends JpaRepository<Profesor,Serializable>{
	
	public abstract Profesor findById(Long id);
}
