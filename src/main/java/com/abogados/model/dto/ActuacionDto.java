package com.abogados.model.dto;

import com.abogados.model.proceso.Proceso;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActuacionDto {
	
	private Integer id;
	private String actuacion;
	private String anotacion;
	private String archivo;
	private String fechaHoraInicio;
	private String fechaHoraFin;
	private Proceso proceso;

}
