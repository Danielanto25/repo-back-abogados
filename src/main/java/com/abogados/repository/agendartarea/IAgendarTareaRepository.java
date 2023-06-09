package com.abogados.repository.agendartarea;

import java.util.List;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.agendartarea.AgendarTareaDto;
import com.abogados.model.responsable.Responsable;
import com.abogados.model.responsables.Responsables;
import com.abogados.repository.generico.GeneralRepo;


public interface IAgendarTareaRepository extends GeneralRepo<AgendarTarea,Integer>{

	AgendarTarea listarTarea(Integer tareaId);

	List<Responsable> listarResponsables(Integer agendarTarId);

	List<AgendarTarea> listarPorFechaInicio(String fechaInicio);

	List<AgendarTarea> listarPorFechaFin(String fechaFin);

	List<AgendarTareaDto> listarUser(String user);
	
	List<AgendarTareaDto> listarDto();


}
