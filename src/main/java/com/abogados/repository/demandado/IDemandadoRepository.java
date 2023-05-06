package com.abogados.repository.demandado;

import java.util.List;

import com.abogados.model.demandado.Demandado;
import com.abogados.repository.generico.GeneralRepo;

public interface IDemandadoRepository extends GeneralRepo<Demandado,Integer>{

	List<Demandado> listarProcesoDemandado(Integer id);
	
	void eliminarPorIdProceso(Integer id);

}
