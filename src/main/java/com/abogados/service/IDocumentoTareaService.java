package com.abogados.service;


import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.abogados.model.documentotarea.DocumentoTarea;

public interface IDocumentoTareaService extends IGeneralService<DocumentoTarea,Integer>{ 
	
	Integer subirArchivo(String json,MultipartFile archivoLlegada, String responsable) throws IOException;
	void subirArchivoEditar(String json,MultipartFile archivoLlegada) throws IOException;
	void actualizarSinArchivo(String json) throws IOException;
	byte[] obtenerArchivo(Integer id) throws IOException;
	
	
	Integer insertarVariosResponsables(String json,MultipartFile archivoLlegada,String responsable) throws IOException;
	
}
