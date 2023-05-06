package com.abogados.model.responsable;

import com.abogados.model.agendartarea.AgendarTarea;
import com.abogados.model.usuario.Usuario;

import org.springframework.stereotype.Repository;

//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Repository
public class Responsable {

	private Integer id;
	private Usuario usuario;
	private AgendarTarea agendarTarea;
	public Responsable(Integer id, Usuario usuario, AgendarTarea agendarTarea) {
		
//		validarDatos(id, usuario, agendarTarea);
		
		this.id = id;
		this.usuario = usuario;
		this.agendarTarea = agendarTarea;
		
	}
	
	public Responsable(Usuario usuario, AgendarTarea agendarTarea) {

//		ValidadorArgumento.validarObligatorio(usuario, "el usuario es obligatorio");
//		ValidadorArgumento.validarObligatorio(agendarTarea, "el agendarTarea es obligatorio");

		this.usuario = usuario;
		this.agendarTarea = agendarTarea;
		
	}
	
	public Responsable(Integer id,Usuario usuario) {

//		ValidadorArgumento.validarObligatorio(usuario, "el usuario es obligatorio");
//		ValidadorArgumento.validarObligatorio(agendarTarea, "el agendarTarea es obligatorio");

		this.id = id;
		this.usuario = usuario;
		
	}
	
//	private void validarDatos(Integer id, Usuario usuario, AgendarTarea agendarTarea) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(usuario, "La usuario es obligatoria");
//		ValidadorArgumento.validarObligatorio(agendarTarea, "La agendarTarea es obligatoria");
//	}
	
}
