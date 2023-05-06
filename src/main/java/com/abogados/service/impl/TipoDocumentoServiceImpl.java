package com.abogados.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.tipodocumento.TipoDocumento;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.tipodocumento.ITipoDocumentoRepository;
import com.abogados.service.ITipoDocumentoService;

@Service

public class TipoDocumentoServiceImpl extends GeneralServiceImpl<TipoDocumento,Integer>   implements ITipoDocumentoService{
	
	@Autowired
	private ITipoDocumentoRepository repo;

	@Override
	protected GeneralRepo<TipoDocumento,Integer> getRepo(){
		return repo;
	}

}
