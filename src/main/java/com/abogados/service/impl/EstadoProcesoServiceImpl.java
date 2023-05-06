package com.abogados.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.estadoproceso.EstadoProceso;
import com.abogados.repository.estadoproceso.IEstadoProcesoRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.service.IEstadoProcesoService;

@Service

public class EstadoProcesoServiceImpl extends GeneralServiceImpl<EstadoProceso,Integer>  implements IEstadoProcesoService {

	@Autowired
	private IEstadoProcesoRepository repo;

	@Override
	protected GeneralRepo<EstadoProceso,Integer> getRepo(){
		return repo;
	}
}
