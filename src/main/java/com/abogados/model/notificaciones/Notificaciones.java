package com.abogados.model.notificaciones;

import java.time.LocalDateTime;

import com.abogados.model.responsables.Responsables;
import com.abogados.model.tarea.Tarea;
import com.abogados.model.usuario.Usuario;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Notificaciones {
	
	private Integer id;
	private LocalDateTime fecha;
	private Usuario usuario;
	private Tarea tarea;
	private Responsables responsables;
	
	public Notificaciones(Integer id, LocalDateTime fecha,Usuario usuario,Tarea tarea,Responsables responsables ) {
	
//		validarDatos(id,fecha,usuario,tarea,responsables);
		this.id=id;
		this.fecha=fecha;
		this.usuario=usuario;
		this.tarea=tarea;
		this.responsables=responsables;
		
	}
	
	public Notificaciones(LocalDateTime fecha,Usuario usuario,Tarea tarea,Responsables responsables ) {
	
//		ValidadorArgumento.validarObligatorio(fecha, "La fecha es obligatoria");
//		ValidadorArgumento.validarObligatorio(usuario, "El usuario es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
//		ValidadorArgumento.validarObligatorio(responsables, "El responsable es obligatorio");
		
		this.fecha = fecha;
		this.usuario = usuario;
		this.tarea = tarea;
		this.responsables=responsables;
	}
	
//	private void validarDatos(Integer id, LocalDateTime fecha,Usuario usuario,Tarea tarea,Responsables responsables ) {
//	
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(fecha, "La fecha es obligatoria");
//		ValidadorArgumento.validarObligatorio(usuario, "El usuario es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
//		ValidadorArgumento.validarObligatorio(responsables, "El responsable es obligatorio");
//		
//	}
	
	
}
