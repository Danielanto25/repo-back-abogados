package com.abogados.model.actuacionproceso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.abogados.model.proceso.Proceso;

//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActuacionProceso {

	private Integer id;
	private String actuacion;
	private String anotacion;
	private String archivo;
	private String fechaCreacion;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private Proceso proceso;
	
	public ActuacionProceso(Integer id, String actuacion, String anotacion, String archivo, String fechaCreacion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Proceso proceso) {
		
//		validarDatos(id, actuacion, anotacion, archivo, fechaCreacion, fechaHoraInicio, fechaHoraFin, proceso);
		
		this.id = id;
		this.actuacion = actuacion;
		this.anotacion = anotacion;
		this.archivo = archivo;
		this.fechaCreacion = fechaCreacion;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.proceso = proceso;
		
	}
	
	public ActuacionProceso(String actuacion, String anotacion, String archivo, Proceso proceso) {
		
		this.actuacion = actuacion;
		this.anotacion = anotacion;
		this.archivo = archivo;
		LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fechaActual.format(formatter);
		this.fechaCreacion = fechaFormateada;
		this.proceso = proceso;
		
	}

//	public ActuacionProceso(String actuacion, String anotacion, String archivo, String fechaCreacion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Proceso proceso) {
//
////		ValidadorArgumento.validarObligatorio(actuacion, "La actuacion es obligatoria");
////		ValidadorArgumento.validarObligatorio(anotacion, "La anotacion es obligatoria");
////		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
////		ValidadorArgumento.validarObligatorio(fechaCreacion, "El archivo es obligatorio");
////		ValidadorArgumento.validarObligatorio(fechaHoraInicio, "El archivo es obligatorio");
////		ValidadorArgumento.validarObligatorio(fechaHoraFin, "El archivo es obligatorio");
////		ValidadorArgumento.validarObligatorio(proceso, "El proceso es obligatorio");
//
//		this.actuacion = actuacion;
//		this.anotacion = anotacion;
//		this.archivo = archivo;
//		this.fechaCreacion = fechaCreacion;
//		this.fechaHoraInicio = fechaHoraInicio;
//		this.fechaHoraFin = fechaHoraFin;
//		this.proceso = proceso;
//		
//	}

	
	public ActuacionProceso(String actuacion, String anotacion, String archivo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Proceso proceso) {


//		ValidadorArgumento.validarObligatorio(actuacion, "La actuacion es obligatoria");
//		ValidadorArgumento.validarObligatorio(anotacion, "La anotacion es obligatoria");
//		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(fechaHoraInicio, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(fechaHoraFin, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(proceso, "El proceso es obligatorio");

		
		this.actuacion = actuacion;
		this.anotacion = anotacion;
		this.archivo = archivo;
		LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fechaActual.format(formatter);
		this.fechaCreacion = fechaFormateada;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.proceso = proceso;
		
	}
	
//	private void validarDatos(Integer id, String actuacion, String anotacion, String archivo, LocalDateTime fechaCreacion, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Proceso proceso) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(actuacion, "La actuacion es obligatoria");
//		ValidadorArgumento.validarObligatorio(anotacion, "La anotacion es obligatoria");
//		ValidadorArgumento.validarObligatorio(archivo, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(fechaCreacion, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(fechaHoraInicio, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(fechaHoraFin, "El archivo es obligatorio");
//		ValidadorArgumento.validarObligatorio(proceso, "El proceso es obligatorio");
//	}
	
}
