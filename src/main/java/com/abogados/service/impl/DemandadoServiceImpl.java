package com.abogados.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.demandado.Demandado;
import com.abogados.repository.demandado.IDemandadoRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.service.IDemandadoService;

@Service
public class DemandadoServiceImpl extends GeneralServiceImpl<Demandado,Integer> implements IDemandadoService{
	
	@Autowired
	private IDemandadoRepository repo;

	@Override
	protected GeneralRepo<Demandado, Integer> getRepo() {

		return repo;
	}
	
	@Override
	public List<Demandado> listarProcesoDemandado(Integer id) throws IOException{
		
		return repo.listarProcesoDemandado(id);
		
	}

}
