package com.acilia.ttschool.repository.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.acilia.ttschool.entity.Student;
import com.acilia.ttschool.repository.StudentRepositoryCustom;

public class StudentRepositoryImpl implements StudentRepositoryCustom{

	private EntityManager em;
	  
	
	/*
     * Sets the entity manager.
     */
    @PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}


	@Transactional
	public List<Student> misConsultas() {
		// TODO Auto-generated method stub
		//HQL works with the class names not with table names!
		 Query query = em.createQuery("from Student");
	        List<Student> resultList = query.getResultList();
	        return resultList;
		
	}

}
