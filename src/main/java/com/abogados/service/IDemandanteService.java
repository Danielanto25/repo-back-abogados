package com.abogados.service;

import java.io.IOException;
import java.util.List;

import com.abogados.model.demandante.Demandante;

public interface IDemandanteService extends IGeneralService<Demandante,Integer>{

	List<Demandante> listarProcesoDemandante(Integer id) throws IOException;

}
