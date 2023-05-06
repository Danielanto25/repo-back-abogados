package com.abogados.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.tipoproceso.TipoProceso;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.tipoproceso.ITipoProcesoRepository;
import com.abogados.service.ITipoProcesoService;

@Service

public class TipoProcesoServiceImpl extends GeneralServiceImpl<TipoProceso,Integer>   implements ITipoProcesoService {
	
	@Autowired
	private ITipoProcesoRepository repo;
	
	@Override
	protected GeneralRepo<TipoProceso,Integer> getRepo(){
		return repo;
	}


}
