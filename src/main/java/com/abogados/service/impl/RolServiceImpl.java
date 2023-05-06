package com.abogados.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.usuario.Rol;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.rol.IRolRepository;
import com.abogados.service.IRolService;

@Service
public class RolServiceImpl extends GeneralServiceImpl<Rol,Integer>  implements IRolService{
	
	@Autowired
	private IRolRepository repo;

	@Override
	protected GeneralRepo<Rol,Integer> getRepo(){
		return repo;
	}


}
