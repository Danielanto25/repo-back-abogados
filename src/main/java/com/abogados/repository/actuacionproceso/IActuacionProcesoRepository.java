package com.abogados.repository.actuacionproceso;




import java.util.List;

import com.abogados.model.actuacionproceso.ActuacionProceso;
import com.abogados.model.proceso.ProcesoDto;
import com.abogados.repository.generico.GeneralRepo;


public interface IActuacionProcesoRepository extends GeneralRepo<ActuacionProceso,Integer> {

	List<ActuacionProceso> listarPorIdProceso(int id);

	void actualizarSinArchivo(ActuacionProceso actuacionProceso);

	List<ActuacionProceso> listarPorNumeroProceso(String numeroProceso);

	Integer insertarSinFechas(ActuacionProceso actuacionProceso);

	List<ProcesoDto> listarDto();
	
}
