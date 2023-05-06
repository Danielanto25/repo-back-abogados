package com.abogados.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.abogados.model.proceso.Proceso;
import com.abogados.model.proceso.ProcesoDto;

public interface IProcesoService extends IGeneralService<Proceso, Integer> {

	Integer insertar(ProcesoDto procesoDto);

	Proceso listarPorNumeroProceso(String numeroProceso);

	List<ProcesoDto> listarPorRadicado(String radicado) throws IOException;

	List<ProcesoDto> listarPorDespacho(String despacho) throws IOException;

	List<ProcesoDto> listarPorDemandante(String demandante) throws IOException;

	List<ProcesoDto> listarPorDemandado(String demandado) throws IOException;

	List<ProcesoDto> listarProcesoCliente( HttpServletRequest request) throws IOException;

	List<ProcesoDto> listarDto() throws IOException;
	
	ProcesoDto listarPorId2(Integer id);
	
	void actualizarCompleto(ProcesoDto procesoDto);
}