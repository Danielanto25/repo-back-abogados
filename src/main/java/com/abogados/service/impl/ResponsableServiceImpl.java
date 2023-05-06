package com.abogados.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.responsable.Responsable;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.responsable.IResponsableRepository;
import com.abogados.service.IResponsableService;

@Service
public class ResponsableServiceImpl extends GeneralServiceImpl<Responsable,Integer> implements IResponsableService{
	
	@Autowired
	private IResponsableRepository repo;

	@Override
	public Integer insertar(Responsable t) {
		return repo.insertar(t);
	}

	@Override
	public void actualizar(Responsable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Responsable listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected GeneralRepo<Responsable, Integer> getRepo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Responsable> listarPorIdAgendarTarea(Integer id) {
		return repo.listarPorIdAgendarTarea(id);
	}

}
