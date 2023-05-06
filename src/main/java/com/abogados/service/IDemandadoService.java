package com.abogados.service;

import java.io.IOException;
import java.util.List;

import com.abogados.model.demandado.Demandado;

public interface IDemandadoService extends IGeneralService<Demandado,Integer>{

	List<Demandado> listarProcesoDemandado(Integer id) throws IOException;

}
