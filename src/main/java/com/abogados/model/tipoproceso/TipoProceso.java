package com.abogados.model.tipoproceso;


//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoProceso {

	private Integer id;
	private String nombre;
	
	public TipoProceso(Integer id, String nombre) {
		
//		validarDatos(id, nombre);
		
		this.id = id;
		this.nombre = nombre;
		
	}
	
	public TipoProceso(String nombre) {
		
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
