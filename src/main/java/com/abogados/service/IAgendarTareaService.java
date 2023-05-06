package com.abogados.service;

import java.io.IOException;
import java.util.List;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.agendartarea.AgendarTareaDto;

public interface IAgendarTareaService extends IGeneralService< AgendarTarea,Integer>{
	
	AgendarTarea listarTarea(Integer tareaId);

	List<AgendarTarea> listarPorFechaInicio(String fechaInicio) throws IOException;

	List<AgendarTarea> listarPorFechaFin(String fechaFin) throws IOException;

	List<AgendarTareaDto> listarUser(String user);
	
	List<AgendarTareaDto> listarDto() throws IOException;

}
