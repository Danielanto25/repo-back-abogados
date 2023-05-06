package com.abogados.model.comentario;


import com.abogados.model.tarea.Tarea;
import com.abogados.model.usuario.Usuario;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comentario {

	private Integer id;
	private String texto;
	private Usuario usuario;
	private Tarea tarea;
	
	public Comentario(Integer id, String texto, Usuario usuario, Tarea tarea) {
		
//		validarDatos(id, texto, usuario, tarea);
		
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.tarea = tarea;
		
	}
	
	public Comentario(String texto, Usuario usuario, Tarea tarea) {
		
//		ValidadorArgumento.validarObligatorio(texto, "El texto es obligatorio");
//		ValidadorArgumento.validarObligatorio(usuario, "El usuario es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
		
		this.texto = texto;
		this.usuario = usuario;
		this.tarea = tarea;
		
	}
	
	
//	private void validarDatos(Integer id, String texto, Usuario usuario, Tarea tarea) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(texto, "El texto es obligatorio");
//		ValidadorArgumento.validarObligatorio(usuario, "El usuario es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
//	}

}
