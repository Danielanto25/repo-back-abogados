package com.abogados.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.bibliotecadocumento.BibliotecaDocumento;

public interface IBibliotecaDocumentoService extends IGeneralService<BibliotecaDocumento, Integer> {

	Integer subirArchivo(String json, MultipartFile archivoLlegada) throws IOException;

	void actualizarArchivo(String json, MultipartFile archivoLlegada) throws IOException;

	byte[] obtenerArchivo(Integer id) throws IOException;

	List<BibliotecaDocumento> listarPorCliente(String cliente) throws IOException;

	void actualizarSinArchivo(String json) throws IOException;

	void eliminarArchivo(Integer id) throws IOException;

	void eliminarDocumentosPorCliente(Integer id) throws IOException;
	
	

}
