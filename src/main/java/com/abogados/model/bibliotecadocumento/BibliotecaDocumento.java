package com.abogados.model.bibliotecadocumento;


import com.abogados.model.cliente.Cliente;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BibliotecaDocumento {

	private Integer id;
	private String archivo;
	private String nombreArchivo;
	private Cliente cliente;
	
	public BibliotecaDocumento(Integer id, String archivo, String nombreArchivo, Cliente cliente) {
		
//		validarDatos(id, archivo, nombreArchivo, cliente);
		
		this.id = id;
		this.archivo = archivo;
		this.nombreArchivo = nombreArchivo;
		this.cliente = cliente;
		
	}
	
	public BibliotecaDocumento(String archivo, String nombreArchivo, Cliente cliente) {
		
//		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(nombreArchivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(cliente, "El cliente es obligatorio");
		
		this.archivo = archivo;
		this.nombreArchivo = nombreArchivo;
		this.cliente = cliente;
		
	}
	
//	private void validarDatos(Integer id, String archivo, String nombreArchivo, Cliente cliente) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(nombreArchivo, "El nombre de archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(cliente, "El cliente es obligatorio");
//	}

	
	
}
