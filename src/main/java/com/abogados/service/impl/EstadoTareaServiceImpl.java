package com.abogados.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.estadotarea.EstadoTarea;
import com.abogados.repository.estadotarea.IEstadoTareaRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.service.IEstadoTareaService;

@Service

public class EstadoTareaServiceImpl extends GeneralServiceImpl<EstadoTarea,Integer>  implements IEstadoTareaService {

	@Autowired
	private IEstadoTareaRepository repo;

	@Override
	protected GeneralRepo<EstadoTarea,Integer> getRepo(){
		return repo;
	}
}
