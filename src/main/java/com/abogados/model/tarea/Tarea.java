package com.abogados.model.tarea;


import com.abogados.model.cliente.Cliente;
import com.abogados.model.tipotarea.TipoTarea;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tarea {

	private Integer id;
	private String nombre;
	private String descripcion;
	private String link;
	private TipoTarea tipoTarea;
	private Cliente cliente;
	
	public Tarea(Integer id, String nombre, String descripcion, String link, TipoTarea tipoTarea, Cliente cliente) {
		
//		validarDatos(id, nombre, descripcion, link, tipoTarea, cliente);
		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.link = link;
		this.tipoTarea = tipoTarea;
		this.cliente = cliente;
		
	}
	
	public Tarea(String nombre, String descripcion, String link, TipoTarea tipoTarea, Cliente cliente) {
		
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//		ValidadorArgumento.validarObligatorio(descripcion, "La descripcion es obligatoria");
//		ValidadorArgumento.validarObligatorio(link, "El link es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoTarea, "El tipo de tarea es obligatorio");
//		ValidadorArgumento.validarObligatorio(cliente, "El cliente es obligatorio");
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.link = link;
		this.tipoTarea = tipoTarea;
		this.cliente = cliente;
		
	}
	
//	private void validarDatos(Integer id, String nombre, String descripcion, String link, TipoTarea tipoTarea, Cliente cliente) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//		ValidadorArgumento.validarObligatorio(descripcion, "La descripcion es obligatoria");
//		ValidadorArgumento.validarObligatorio(link, "El link es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoTarea, "El tipo de tarea es obligatorio");
//		ValidadorArgumento.validarObligatorio(cliente, "El cliente es obligatorio");
//		
//	}

}
