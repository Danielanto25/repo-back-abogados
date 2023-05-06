package com.abogados.model.proceso;


import com.abogados.model.cliente.Cliente;
import com.abogados.model.estadoproceso.EstadoProceso;
import com.abogados.model.tipoproceso.TipoProceso;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Proceso {

	private Integer id;
	private String numeroProceso;
	private String corporacion;
	private String ciudad;
	private String despacho;
	private String ponente;
	private String cuantia;
	private String tribunal;
	private Cliente cliente;
	private TipoProceso tipoProceso;
	private EstadoProceso estado;
	
	public Proceso(Integer id, String numeroProceso, String corporacion, String ciudad, String despacho, String ponente, String cuantia, String tribunal, Cliente cliente, TipoProceso tipoProceso, EstadoProceso estado) {
		
//		validarDatos(id, numeroProceso, corporacion, ciudad, despacho, ponente, cuantia, tipoProceso, estado);
		
		this.id = id;
		this.numeroProceso = numeroProceso;
		this.corporacion = corporacion;
		this.ciudad = ciudad;
		this.despacho = despacho;
		this.ponente = ponente;
		this.cuantia = cuantia;
		this.tribunal = tribunal;
		this.cliente = cliente;
		this.tipoProceso = tipoProceso;
		this.estado = estado;
		
	}
	
	public Proceso(String numeroProceso, String corporacion, String ciudad, String despacho, String ponente, String cuantia, String tribunal, Cliente cliente, TipoProceso tipoProceso, EstadoProceso estado) {
		
//		ValidadorArgumento.validarObligatorio(numeroProceso, "El numero de proceso es obligatorio");
//		ValidadorArgumento.validarObligatorio(corporacion, "La corporacion es obligatoria");
//		ValidadorArgumento.validarObligatorio(ciudad, "La ciudad es obligatoria");
//		ValidadorArgumento.validarObligatorio(despacho, "El despacho es obligatorio");
//		ValidadorArgumento.validarObligatorio(ponente, "El ponente es obligatorio");
//		ValidadorArgumento.validarObligatorio(cuantia, "La cuantia es obligatoria");
//		ValidadorArgumento.validarObligatorio(tipoProceso, "El tipo de proceso es obligatorio");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
		
		this.numeroProceso = numeroProceso;
		this.corporacion = corporacion;
		this.ciudad = ciudad;
		this.despacho = despacho;
		this.ponente = ponente;
		this.cuantia = cuantia;
		this.tribunal = tribunal;
		this.cliente = cliente;
		this.tipoProceso = tipoProceso;
		this.estado = estado;
		
	}
	
//	private void validarDatos(Integer id, String numeroProceso, String corporacion, String ciudad, String despacho, String ponente, String cuantia, TipoProceso tipoProceso, Estado estado) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(numeroProceso, "El numero de proceso es obligatorio");
//		ValidadorArgumento.validarObligatorio(corporacion, "La corporacion es obligatoria");
//		ValidadorArgumento.validarObligatorio(ciudad, "La ciudad es obligatoria");
//		ValidadorArgumento.validarObligatorio(despacho, "El despacho es obligatorio");
//		ValidadorArgumento.validarObligatorio(ponente, "El ponente es obligatorio");
//		ValidadorArgumento.validarObligatorio(cuantia, "La cuantia es obligatoria");
//		ValidadorArgumento.validarObligatorio(tipoProceso, "El tipo de proceso es obligatorio");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
//		
//	}


}
