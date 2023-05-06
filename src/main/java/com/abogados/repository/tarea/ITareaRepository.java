package com.abogados.repository.tarea;

import com.abogados.model.tarea.Tarea;
import com.abogados.repository.generico.GeneralRepo;


public interface ITareaRepository extends GeneralRepo<Tarea,Integer>{

	void pasarReporte(Integer id, Integer idReporte);

}
