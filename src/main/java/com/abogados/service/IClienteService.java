package com.abogados.service;


import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.cliente.Cliente;

public interface IClienteService  extends IGeneralService<Cliente,Integer>{

	Integer subirArchivo(String json, MultipartFile archivoLlegada) throws IOException;

	void actualizarArchivo(String json, MultipartFile archivoLlegada) throws IOException;

	Cliente listarPorCliente(String cliente) throws IOException;

	byte[] obtenerArchivo(Integer id) throws IOException;

	void actualizarSinArchivo(String json) throws IOException;

	void eliminarArchivo(Integer id) throws IOException;


	
}
