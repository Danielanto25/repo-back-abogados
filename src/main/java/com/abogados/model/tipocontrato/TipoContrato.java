package com.abogados.model.tipocontrato;

import org.springframework.stereotype.Repository;

//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Repository
public class TipoContrato {

	private Integer id;
	private String nombre;

	public TipoContrato(Integer id, String nombre) {
		
//		validarDatos(id, nombre);
		
		this.id = id;
		this.nombre = nombre;
		
	}
	
	public TipoContrato(String nombre) {
		
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
		
		this.nombre = nombre;
		
	}
	
//	private void validarDatos(Integer id, String nombre) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//
//	}
	
}
