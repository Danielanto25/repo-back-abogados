package com.abogados.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.tipocontrato.TipoContrato;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.tipocontrato.ITipoContratoRepository;
import com.abogados.service.ITipoContratoService;

@Service

public class TipoContratoServiceImpl extends GeneralServiceImpl<TipoContrato,Integer>   implements ITipoContratoService {
	
	@Autowired
	private ITipoContratoRepository repo;

	@Override
	protected GeneralRepo<TipoContrato,Integer> getRepo(){
		return repo;
	}

}
