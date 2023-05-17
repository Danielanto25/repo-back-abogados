package com.abogados.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IManejadorArchivo {

	String guardarArchivo(MultipartFile archivoLlegada, String subRuta) throws IllegalStateException, IOException;

	String actualizarArchivo(MultipartFile archivoLlegada,String nombreArchivoAntiguo, String subRuta) throws IllegalStateException, IOException;
	
	byte[] obtenerArchivo(String subRuta, String nombreArchivo) throws IOException;

	void eliminarArchivo(String nombreArchivoAntiguo) throws IllegalStateException, IOException;
}
