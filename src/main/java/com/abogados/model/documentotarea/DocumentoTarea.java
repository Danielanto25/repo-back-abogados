package com.abogados.model.documentotarea;


import com.abogados.model.tarea.Tarea;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentoTarea {

	private Integer id;
	private String archivo;
	private Tarea tarea;

	public DocumentoTarea(Integer id, String archivo, Tarea tarea) {

//		validarDatos(id, archivo, tarea);

		this.id = id;
		this.archivo = archivo;
		this.tarea = tarea;
	}

	public DocumentoTarea(String archivo, Tarea tarea) {

//		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");

		this.archivo = archivo;
		this.tarea = tarea;
	}

//	private void validarDatos(Integer id, String archivo, Tarea tarea) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
//	}

}
