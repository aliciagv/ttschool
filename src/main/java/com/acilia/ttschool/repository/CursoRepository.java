package com.acilia.ttschool.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Curso;

@Repository("cursorepository")
public interface CursoRepository extends JpaRepository<Curso,Serializable>{

}
