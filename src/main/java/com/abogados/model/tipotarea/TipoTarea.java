package com.abogados.model.tipotarea;


//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoTarea {

	private Integer id;
	private String nombre;
	
	public TipoTarea(Integer id, String nombre) {
		
//		validarDatos(id, nombre);
		
		this.id = id;
		this.nombre = nombre;
		
	}
	
	public TipoTarea(String nombre) {
		
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
