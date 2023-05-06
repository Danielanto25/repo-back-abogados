package com.abogados.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abogados.service.IManejadorArchivo;

@Service
public class ManejadorArchivoImpl implements IManejadorArchivo {

	@Value("${ruta}")
	private String rutaArchivo;

	@Override
	public String guardarArchivo(MultipartFile archivoLlegada, String subRuta)
			throws IllegalStateException, IOException {

		String nombreArchivo = crearNombreArchivo(archivoLlegada.getOriginalFilename());

		File archivoSubida = new File(rutaArchivo.concat(subRuta).concat(nombreArchivo));
		archivoLlegada.transferTo(archivoSubida);

		return nombreArchivo;
	}

	@Override
	public String actualizarArchivo(MultipartFile archivoLlegada, String nombreArchivoAntiguo, String subRuta)
			throws IllegalStateException, IOException {

		File archivoSubida = new File(rutaArchivo.concat(subRuta).concat(nombreArchivoAntiguo));
		archivoSubida.delete();

		String nombreArchivo = crearNombreArchivo(archivoLlegada.getOriginalFilename());

		File archivoNuevo = new File(rutaArchivo.concat(subRuta).concat(nombreArchivo));
		archivoLlegada.transferTo(archivoNuevo);

		return nombreArchivo;
	}
	
	public void eliminarArchivo( String archivoEliminado, String subRuta)
			throws IllegalStateException, IOException {

		File archivoSubida = new File(rutaArchivo.concat(subRuta).concat(archivoEliminado));
		archivoSubida.delete();
		
		}
	
	private String crearNombreArchivo(String nombreArchivo) {

		int numero = (int) (Math.random() * 200 + 1);
		return "archivo-" + numero + "-" + (nombreArchivo.replace("\\", ""));

	}

	@Override
	public byte[] obtenerArchivo(String subRuta, String nombreArchivo) throws IOException {

		File archivo = new File(rutaArchivo.concat(subRuta).concat(nombreArchivo));

		InputStream in = new FileInputStream(archivo);

		return IOUtils.toByteArray(in);
	}

}
