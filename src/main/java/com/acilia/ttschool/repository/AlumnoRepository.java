package com.acilia.ttschool.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Alumno;

@Repository("alumnorepository")
public interface AlumnoRepository  extends JpaRepository<Alumno,Serializable>{

	public abstract Alumno findById(Long id);
}
