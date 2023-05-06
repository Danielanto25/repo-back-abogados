package com.abogados.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.tipotarea.TipoTarea;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.tipotarea.ITipoTareaRepository;
import com.abogados.service.ITipoTareaService;


@Service

public class TipoTareaServiceImpl extends GeneralServiceImpl<TipoTarea,Integer>   implements ITipoTareaService{

	@Autowired
	private ITipoTareaRepository repo;
	
	@Override
	protected GeneralRepo<TipoTarea,Integer> getRepo(){
		return repo;
	}


}


