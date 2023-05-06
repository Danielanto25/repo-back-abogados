package com.abogados.repository.demandante;

import java.util.List;

import com.abogados.model.demandante.Demandante;
import com.abogados.repository.generico.GeneralRepo;

public interface IDemandanteRepository extends GeneralRepo<Demandante,Integer>{

	List<Demandante> listarProcesoDemandante(Integer id);
	
	void eliminarPorIdProceso(Integer id);

}
