package com.acilia.ttschool.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Colegio;

@Repository("colegiorepository")
public interface ColegioRepository extends JpaRepository<Colegio,Serializable>{

	 public abstract Colegio findById(Long id);
}
