package com.abogados.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.estado.Estado;
import com.abogados.repository.estado.IEstadoRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.service.IEstadoService;

@Service

public class EstadoServiceImpl extends GeneralServiceImpl<Estado,Integer>  implements IEstadoService {

	@Autowired
	private IEstadoRepository repo;

	@Override
	protected GeneralRepo<Estado,Integer> getRepo(){
		return repo;
	}
}
