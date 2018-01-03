package com.acilia.ttschool.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Student;

@Repository("studentrepository")
public interface StudentRepository extends JpaRepository<Student,Serializable> {
	
	public abstract Student findById(int id);

}
