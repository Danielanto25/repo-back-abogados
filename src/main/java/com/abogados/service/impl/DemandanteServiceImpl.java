package com.abogados.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.demandante.Demandante;
import com.abogados.repository.demandante.IDemandanteRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.service.IDemandanteService;

@Service
public class DemandanteServiceImpl extends GeneralServiceImpl<Demandante,Integer> implements IDemandanteService{
	
	@Autowired
	private IDemandanteRepository repo;

	@Override
	protected GeneralRepo<Demandante, Integer> getRepo() {

		return repo;
	}
	
	@Override
	public List<Demandante> listarProcesoDemandante(Integer id) throws IOException{
		
		return repo.listarProcesoDemandante(id);
		
	}

}
