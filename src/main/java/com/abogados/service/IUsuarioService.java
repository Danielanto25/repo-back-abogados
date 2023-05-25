package com.abogados.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.abogados.model.usuario.Usuario;

public interface IUsuarioService extends IGeneralService<Usuario, Integer>{

	Usuario buscarUsuarioClaveEstadoPorUsuario(String email);

	List<String> buscarRolePorUsuario(String email);
	
	Usuario info(HttpServletRequest request);

	List<Usuario> listarSinCliente();

}
