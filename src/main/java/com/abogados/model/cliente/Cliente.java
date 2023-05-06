package com.abogados.model.cliente;


import com.abogados.model.tipocontrato.TipoContrato;
import com.abogados.model.tipodocumento.TipoDocumento;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

	private Integer id;
	private String nombre;
	private String documento;
	private String descripcion;
	private String numeroContrato;
	private String archivo;
	private TipoContrato tipoContrato;
	private TipoDocumento tipoDocumento;
	
	public Cliente(Integer id, String nombre, String documento, String descripcion, String numeroContrato, String archivo, TipoContrato tipoContrato, TipoDocumento tipoDocumento) {
		
//		validarDatos(id, nombre, documento, descripcion, numeroContrato, archivo, tipoContrato, tipoDocumento);
		
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
		this.descripcion = descripcion;
		this.numeroContrato = numeroContrato;
		this.archivo = archivo;
		this.tipoContrato = tipoContrato;
		this.tipoDocumento = tipoDocumento;
	}
	
	public Cliente(String nombre, String documento, String descripcion, String numeroContrato, String archivo, TipoContrato tipoContrato, TipoDocumento tipoDocumento) {
		
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//		ValidadorArgumento.validarObligatorio(documento, "El documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(descripcion, "La descripcion es obligatoria");
//		ValidadorArgumento.validarObligatorio(numeroContrato, "El numero de contrato es obligatorio");
//		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoContrato, "El tipo de contrato es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoDocumento, "El tipo de documento es obligatorio");
		
		this.nombre = nombre;
		this.documento = documento;
		this.descripcion = descripcion;
		this.numeroContrato = numeroContrato;
		this.archivo = archivo;
		this.tipoContrato = tipoContrato;
		this.tipoDocumento = tipoDocumento;
	}
	
//	private void validarDatos(Integer id, String nombre, String documento, String descripcion, String numeroContrato, String archivo, TipoContrato tipoContrato, TipoDocumento tipoDocumento) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//		ValidadorArgumento.validarObligatorio(documento, "El documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(descripcion, "La descripcion es obligatoria");
//		ValidadorArgumento.validarObligatorio(numeroContrato, "El numero de contrato es obligatorio");
//		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoContrato, "El tipo de contrato es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoDocumento, "El tipo de documento es obligatorio");
//		
//	}

}
