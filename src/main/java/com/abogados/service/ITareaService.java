package com.abogados.service;


import java.io.IOException;

import com.abogados.model.tarea.Tarea;

public interface ITareaService extends IGeneralService<Tarea,Integer>{

	void actualizar(String json) throws IOException;

	void pasarReporte(Integer id, Integer idReporte);
}
