package com.abogados.model.usuario;


import com.abogados.model.estado.Estado;
import com.abogados.model.tipodocumento.TipoDocumento;
//import com.abogados.util.ValidadorArgumento;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario {

	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String documento;
	private TipoDocumento tipoDocumento;
	private Estado estado;
	
	public Usuario(Integer id, String nombre, String apellido, String email, String password, String documento, TipoDocumento tipoDocumento, Estado estado) {
		
//		validarDatos(id, nombre, apellido, email, password, documento, tipoDocumento, estado);
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.estado = estado;
		
	}
	
	public Usuario(String nombre, String apellido, String email, String password, String documento, TipoDocumento tipoDocumento, Estado estado) {
		
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//		ValidadorArgumento.validarObligatorio(apellido, "El apellido es obligatorio");
//		ValidadorArgumento.validarObligatorio(email, "El email es obligatorio");
//		ValidadorArgumento.validarObligatorio(password, "La password es obligatoria");
//		ValidadorArgumento.validarObligatorio(documento, "El documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoDocumento, "El tipo de documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.estado = estado;
		
	}
	
	public Usuario(String nombre, String password, String documento, TipoDocumento tipoDocumento, Estado estado) {
		
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//		ValidadorArgumento.validarObligatorio(password, "La password es obligatoria");
//		ValidadorArgumento.validarObligatorio(documento, "El documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoDocumento, "El tipo de documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
		
		this.nombre = nombre;
		this.password = password;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.estado = estado;
		
	}
	
public Usuario(Integer id, String nombre, String password, String documento, TipoDocumento tipoDocumento, Estado estado) {
		
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//		ValidadorArgumento.validarObligatorio(password, "La password es obligatoria");
//		ValidadorArgumento.validarObligatorio(documento, "El documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoDocumento, "El tipo de documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
		
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.estado = estado;
		
	}
	
//	private void validarDatos(Integer id, String nombre, String apellido, String email, String password, String documento, TipoDocumento tipoDocumento, Estado estado) {
//
//		ValidadorArgumento.validarObligatorio(id, "El id es obligatorio");
//		ValidadorArgumento.validarObligatorio(nombre, "El nombre es obligatorio");
//		ValidadorArgumento.validarObligatorio(apellido, "El apellido es obligatorio");
//		ValidadorArgumento.validarObligatorio(email, "El email es obligatorio");
//		ValidadorArgumento.validarObligatorio(password, "La password es obligatoria");
//		ValidadorArgumento.validarObligatorio(documento, "El documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(tipoDocumento, "El tipo de documento es obligatorio");
//		ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
//		
//	}

}
