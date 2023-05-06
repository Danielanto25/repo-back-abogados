package com.abogados.model.dto;


import com.abogados.model.estadotarea.EstadoTarea;
import com.abogados.model.tarea.Tarea;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FechaDto {
	
	private Integer id;
	private String fechaHoraInicio;
	private String fechaHoraFin;
	private EstadoTarea estado;
	private Tarea tarea;
	
}
