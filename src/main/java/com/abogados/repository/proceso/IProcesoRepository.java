package com.abogados.repository.proceso;

import java.util.List;

import com.abogados.model.proceso.Proceso;
import com.abogados.model.proceso.ProcesoDto;
import com.abogados.repository.generico.GeneralRepo;

public interface IProcesoRepository extends GeneralRepo<Proceso,Integer>{
	
	Proceso listarPorNumeroProceso(String numeroProceso);
	
	List<ProcesoDto> listarPorRadicado(String radicado);

	List<ProcesoDto> listarPorDespacho(String despacho);

	List<ProcesoDto> listarPorDemandante(String demandante);

	List<ProcesoDto> listarPorDemandado(String demandado);

	List<ProcesoDto> listarProcesoCliente(Integer id);
	
	ProcesoDto listarPorId2(Integer id);

	List<ProcesoDto> listarProcesosPorCliente(String clienteDocumento);


}
