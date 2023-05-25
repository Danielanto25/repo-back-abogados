package com.abogados.service.impl;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.dto.TareaDto;
import com.abogados.model.tarea.Tarea;
import com.abogados.repository.agendartarea.IAgendarTareaRepository;
import com.abogados.repository.generico.GeneralRepo;
import com.abogados.repository.tarea.ITareaRepository;
import com.abogados.service.ITareaService;

@Service

public class TareaServiceImpl extends GeneralServiceImpl<Tarea,Integer>   implements ITareaService {
	
	@Autowired
	private ITareaRepository repo;
	@Autowired
	private IAgendarTareaRepository ageTarRepo;

	@Override
	protected GeneralRepo<Tarea,Integer> getRepo(){
		return repo;
	}

	@Override
	public Integer insertar(Tarea t) {
		// TODO Auto-generated method stub
		return repo.insertar(t);
	}

	@Override
	public void actualizar(Tarea t) {
		repo.actualizar(t);
		
	}

	@Override
	public void eliminar(Integer id) {
		repo.eliminar(id);
		
	}

	@Override
	public Tarea listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return repo.listarPorId(id);
	}

	@Override
	public void actualizar(String json) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		
		TareaDto tareaDto = objectMapper.readValue(json, TareaDto.class);
		
		Tarea validarTarea = new Tarea(tareaDto.getTarea().getId(),tareaDto.getTarea().getNombre(), tareaDto.getTarea().getDescripcion(), tareaDto.getTarea().getLink(),
				tareaDto.getTarea().getTipoTarea(), tareaDto.getTarea().getCliente(), tareaDto.getTarea().getProceso());
		repo.actualizar(validarTarea);
		
		AgendarTarea validarAgeTarea = new AgendarTarea(tareaDto.getAgendarTarea().getId(),tareaDto.getAgendarTarea().getFechaHoraInicio(),
				tareaDto.getAgendarTarea().getFechaHoraFin(), tareaDto.getAgendarTarea().getEstado(), validarTarea);
		ageTarRepo.actualizar(validarAgeTarea);
		
	}

	@Override
	public void pasarReporte(Integer id, Integer idReporte) {

		repo.pasarReporte(id, idReporte);
	}
	
	

}
