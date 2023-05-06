package com.abogados.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.abogados.model.responsables.Responsables;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.responsables.IResponsablesRepository;
import com.abogados.service.IResponsablesService;

public class ResponsablesServiceImpl extends GeneralServiceImpl<Responsables,Integer> implements IResponsablesService {

	@Autowired
	private IResponsablesRepository repo;

	@Override
	protected GeneralRepo<Responsables, Integer> getRepo() {
		return repo;
	}

}
