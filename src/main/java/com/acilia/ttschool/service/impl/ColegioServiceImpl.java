package com.acilia.ttschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acilia.ttschool.converter.ColegioConverter;
import com.acilia.ttschool.entity.Colegio;
import com.acilia.ttschool.model.ColegioModel;
import com.acilia.ttschool.repository.ColegioRepository;
import com.acilia.ttschool.service.ColegioService;

@Service("colegioServiceImpl")
public class ColegioServiceImpl implements ColegioService {

	@Autowired
	@Qualifier("colegiorepository")
	private ColegioRepository colegioRepository;
	
	@Autowired
	@Qualifier("colegioConverter")
	private ColegioConverter colegioConverter;
	
	@Override
	public ColegioModel findColegioByIdModel(Long id) {
		ColegioModel colegiomodel =null;
		Colegio colegio=colegioRepository.findById(id);
		colegiomodel=colegioConverter.convertColegio2ColegioModel(colegio);
		return colegiomodel;
	}



}
