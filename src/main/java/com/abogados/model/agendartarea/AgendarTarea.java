package com.abogados.model.agendartarea;

import java.time.LocalDateTime;

import com.abogados.model.estadotarea.EstadoTarea;
import com.abogados.model.tarea.Tarea;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgendarTarea {

	private Integer id;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private EstadoTarea estado;
	private Tarea tarea;
	
	public AgendarTarea(String fechaHoraInicio, String fechaHoraFin, EstadoTarea estado, Tarea tarea) {
		
//		ValidadorArgumento.validarObligatorio(fechaHoraInicio, "La fecha y hora de inicio es obligatoria");
//		ValidadorArgumento.validarObligatorio(fechaHoraFin, "La fecha y hora de fin es obligatoria");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
		
		this.fechaHoraInicio =  LocalDateTime.parse(fechaHoraInicio);
		this.fechaHoraFin = LocalDateTime.parse(fechaHoraFin);
		this.estado = estado;
		this.tarea = tarea;
		
	}
	
	public AgendarTarea(Integer id, String fechaHoraInicio, String fechaHoraFin, EstadoTarea estado, Tarea tarea) {
//		ValidadorArgumento.validarObligatorio(id, "el id es obligatorio");
//		ValidadorArgumento.validarObligatorio(fechaHoraInicio, "La fecha y hora de inicio es obligatoria");
//		ValidadorArgumento.validarObligatorio(fechaHoraFin, "La fecha y hora de fin es obligatoria");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
		
		this.id = id;
		this.fechaHoraInicio =  LocalDateTime.parse(fechaHoraInicio);
		this.fechaHoraFin = LocalDateTime.parse(fechaHoraFin);
		this.estado = estado;
		this.tarea = tarea;
		
	}
	
	public AgendarTarea(Integer id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, EstadoTarea estado, Tarea tarea) {
		
//		validarDatos(id, fechaHoraInicio, fechaHoraFin, estado, tarea);
		
		this.id = id;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.estado = estado;
		this.tarea = tarea;
		
	}
	
	public AgendarTarea(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, EstadoTarea estado, Tarea tarea) {
		
//		ValidadorArgumento.validarObligatorio(fechaHoraInicio, "La fecha y hora de inicio es obligatoria");
//		ValidadorArgumento.validarObligatorio(fechaHoraFin, "La fecha y hora de fin es obligatoria");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
		
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.estado = estado;
		this.tarea = tarea;
		
	}
	
//	private void validarDatos(Integer id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Estado estado, Tarea tarea) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(fechaHoraInicio, "La fecha y hora de inicio es obligatoria");
//		ValidadorArgumento.validarObligatorio(fechaHoraFin, "La fecha y hora de fin es obligatoria");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
//		ValidadorArgumento.validarObligatorio(tarea, "La tarea es obligatoria");
//	}

}
