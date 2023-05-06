package com.abogados.model.responsables;


import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.usuario.Usuario;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Responsables {
	
	private Integer id;
	private Usuario usuario;
	private AgendarTarea agendarTarea;
	
	
	public Responsables(Integer id, Usuario usuario,AgendarTarea agendarTarea ) {
		
//		validarDatos(id, usuario, agendarTarea);
		
		this.id = id;
		this.usuario = usuario;
		this.agendarTarea = agendarTarea;
		
	}
	
	public Responsables(Usuario usuario, AgendarTarea agendarTarea) {
		
//		ValidadorArgumento.validarObligatorio(usuario, "El usuario es obligatorio");
//		ValidadorArgumento.validarObligatorio(agendarTarea, "La tarea es obligatoria");
		
		this.usuario = usuario;
		this.agendarTarea = agendarTarea;
		
	}
	
	
//	private void validarDatos(Integer id, Usuario usuario,AgendarTarea agendarTarea ) {
//		
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(usuario, "El usuario es obligatorio");
//		ValidadorArgumento.validarObligatorio(agendarTarea, "La tarea es obligatoria");
//	}
	

}
