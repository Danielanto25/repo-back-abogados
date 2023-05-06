package com.abogados.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.agendartarea.AgendarTareaDto;
import com.abogados.repository.agendartarea.IAgendarTareaRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.responsable.IResponsableRepository;
import com.abogados.service.IAgendarTareaService;

@Service
public class AgendarTareaServiceImpl extends GeneralServiceImpl<AgendarTarea,Integer> implements IAgendarTareaService{
	
	@Autowired
	private IAgendarTareaRepository repo;
	
	@Autowired
	private IResponsableRepository repoRes;

	@Override
	protected GeneralRepo<AgendarTarea,Integer> getRepo(){
		return repo;
	}
	
	@Override
	public Integer insertar(AgendarTarea t) {

		int resultado = repo.insertar(t);
		//repoRes.insertar();
		
		return repo.insertar(t);
	}

	@Override
	public void actualizar(AgendarTarea t) {
		repo.actualizar(t);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AgendarTarea listarTarea(Integer tareaId) {
		return repo.listarTarea(tareaId);
	}
	
	@Override
	public List<AgendarTarea> listarPorFechaInicio(String fechaInicio) throws IOException {
		return repo.listarPorFechaInicio(fechaInicio);
	}

	@Override
	public AgendarTarea listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgendarTarea> listarPorFechaFin(String fechaFin) throws IOException {
		return repo.listarPorFechaFin(fechaFin);
	}

	@Override
	public List<AgendarTareaDto> listarUser(String user) {
		return repo.listarUser(user);
	}

	@Override
	public List<AgendarTareaDto> listarDto() throws IOException {
		
		return repo.listarDto();
	}

}
