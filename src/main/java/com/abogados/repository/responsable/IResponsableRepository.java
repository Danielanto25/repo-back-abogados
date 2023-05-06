package com.abogados.repository.responsable;

import java.util.List;

import com.abogados.model.responsable.Responsable;
import com.abogados.repository.generico.GeneralRepo;

public interface IResponsableRepository extends GeneralRepo<Responsable,Integer>{

	List<Responsable> listarPorIdAgendarTarea(int id);
	
	int listarPorTareaYUsuario(int agtId, int usuId);
}
