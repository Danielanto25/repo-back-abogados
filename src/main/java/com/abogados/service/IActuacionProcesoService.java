package com.abogados.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.actuacionproceso.ActuacionProceso;

public interface IActuacionProcesoService extends IGeneralService<ActuacionProceso, Integer> {

	Integer subirArchivo(String json, MultipartFile archivoLlegada) throws IOException;

	List<ActuacionProceso> listarPorIdProceso(int id) throws Exception;

	void actualizarArchivo(String json, MultipartFile archivoLlegada) throws IOException;

	byte[] obtenerArchivo(Integer id) throws IOException;

	void actualizarSinArchivo(String json) throws IOException;

	void eliminarArchivo(Integer id) throws IOException;
	
	List<ActuacionProceso> listarPorNumeroProceso(String numeroProceso);

	Integer insertarSinFechas(String json, MultipartFile archivoLlegadao) throws IOException;

}
